package es.jepm.ddbbGestion.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import es.jepm.ddbbGestion.model.PersonModel;

public class StudentController {
	

	public static List<PersonModel> findResult() {
		List<PersonModel> list = new ArrayList<PersonModel>();
		
		try {
			Connection conn = ConnectionManager.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from estudiante");
			
			while (rs.next()) {
				PersonModel student = new PersonModel();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("nombre"));
				student.setLastName(rs.getString("apellido1"));
				student.setLastName2(rs.getString("apellido2"));
				student.setDni(rs.getString("dni"));
				student.setEmail(rs.getString("email"));
				student.setPhoneN(rs.getString("telefono"));
				student.setAddress(rs.getString("direccion"));
				student.setGender(rs.getInt("sexo"));
				list.add(student);
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
	
	/**
	 * 
	 * @param student
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static int realizeUpdate(PersonModel student) throws ClassNotFoundException {
		try {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement ps = conn.prepareStatement(
				"update estudiante set nombre = ?, apellido1 = ?, apellido2 = ?, dni = ?, direccion = ? where id = ?");
	
		ps.setString(1, student.getName());
		ps.setString(2, student.getLastName());
		ps.setString(3, student.getLastName2());
		ps.setString(4, student.getDni());
		ps.setString(5, student.getAddress());
		ps.setInt(6, student.getId());

		int rows = ps.executeUpdate();
		ps.close();
		conn.close();
		
		JOptionPane.showMessageDialog(null, "Modificacion realizada correctamente");
		return rows;
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "Imposible realizar la modificación");
		e.printStackTrace();
	}
	return 0;
		
	}

	
}
