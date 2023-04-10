package es.jepm.ddbbGestion.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.jepm.ddbbGestion.model.Gender;

public class GenderController {
	
	public static List<Gender> findResult() {
		List<Gender> list = new ArrayList<Gender>();
		
		try {
			Connection conn = ConnectionManager.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from tipologiaSexo");
			
			while (rs.next()) {
				Gender gender = new Gender();
				gender.setId(rs.getInt("id"));
				gender.setDescription(rs.getString("descripcion"));
				list.add(gender);
			}
			
			rs.close();
			st.close();
			conn.close();
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return list;
	}

}
