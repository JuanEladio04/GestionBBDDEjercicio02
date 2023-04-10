package es.jepm.ddbbGestion.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.jepm.ddbbGestion.model.PersonModel;

public class ProfesorController {
	
	public static List<PersonModel> findResult() {
		List<PersonModel> list = new ArrayList<PersonModel>();
		
		try {
			Connection conn = ConnectionManager.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from profesor");
			
			while (rs.next()) {
				PersonModel profesor = new PersonModel();
				profesor.setId(rs.getInt("id"));
				profesor.setName(rs.getString("nombre"));
				profesor.setLastName(rs.getString("apellido1"));
				profesor.setLastName2(rs.getString("apellido2"));
				profesor.setDni(rs.getString("dni"));
				profesor.setEmail(rs.getString("email"));
				profesor.setPhoneN(rs.getString("telefono"));
				profesor.setAddress(rs.getString("direccion"));
				profesor.setGender(rs.getInt("sexo"));
				list.add(profesor);
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
