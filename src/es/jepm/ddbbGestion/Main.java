package es.jepm.ddbbGestion;

import java.sql.Connection;
import java.sql.SQLException;

import es.jepm.ddbbGestion.controllers.ConnectionManager;
import es.jepm.ddbbGestion.view.PrincipalWindow;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Connection connection = ConnectionManager.getConnection();
		
		PrincipalWindow.main(args);
		
	}

}
