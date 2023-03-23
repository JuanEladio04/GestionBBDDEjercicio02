package es.jepm.ddbbGestion.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.jepm.ddbbGestion.model.Student;

public class StudentController {
	

	public static Student findResult(int order) {
		List<Student> list = new ArrayList<Student>();
		
		try {
			Connection conn = ConnectionManager.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from estudiante where id = " + 1);
			
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("nombre"));
				student.setLastName(rs.getString("apellido1"));
				student.setLastName2(rs.getString("apellido2"));
				student.setDni(rs.getString("direccion"));
				student.setEmail(rs.getString("email"));
				student.setPhoneN(rs.getString("telefono"));
				list.add(student);
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return list.get(order);
	}

	
}
