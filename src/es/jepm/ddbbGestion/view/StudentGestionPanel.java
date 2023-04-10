package es.jepm.ddbbGestion.view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import es.jepm.ddbbGestion.controllers.ConnectionManager;
import es.jepm.ddbbGestion.controllers.StudentController;
import es.jepm.ddbbGestion.model.PersonModel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentGestionPanel extends JPanel {
	
	private int order = 0;


	/**
	 * Create the panel.
	 */
	public StudentGestionPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0};
		gridBagLayout.columnWeights = new double[]{1.0};
//		gridBagLayout.columnWidths = new int[]{0, 0};
//		gridBagLayout.rowHeights = new int[]{0, 0, 0};
//		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("GESTION DEL ESTUDIANTE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		/*
		 * Personal Gestion Panel
		 */
		
		PersonalDataPanel personalDataPanel = new PersonalDataPanel ();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(personalDataPanel, gbc_panel);
		
		findResult(personalDataPanel, 0);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel1 = new GridBagConstraints();
		gbc_panel1.fill = GridBagConstraints.BOTH;
		gbc_panel1.gridx = 0;
		gbc_panel1.gridy = 2;
		add(panel, gbc_panel1);
		GridBagLayout gbl_panel = new GridBagLayout();
//		gbl_panel.columnWidths = new int[]{0, 0};
//		gbl_panel.rowHeights = new int[]{0, 0};
//		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
//		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<PersonModel> rslt = StudentController.findResult();
				
				updateTableImage();
				
			}
		});
		
		JButton btnFisrtResult = new JButton("<<");
		GridBagConstraints gbc_btnFisrtResult = new GridBagConstraints();
		gbc_btnFisrtResult.insets = new Insets(0, 0, 0, 5);
		gbc_btnFisrtResult.gridx = 0;
		gbc_btnFisrtResult.gridy = 0;
		panel.add(btnFisrtResult, gbc_btnFisrtResult);
		GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
		gbc_btnUpdate.gridx = 1;
		gbc_btnUpdate.gridy = 0;
		panel.add(btnUpdate, gbc_btnUpdate);
		
	}
	
	/**
	 * 
	 * @param panel
	 * @param order
	 */
	public void findResult(PersonalDataPanel panel, int order) {
		List<PersonModel> rslt = StudentController.findResult();
		
		panel.setId(rslt.get(order).getId());
		panel.setName(rslt.get(order).getName());
		panel.setLastName(rslt.get(order).getLastName());
		panel.setLastName2(rslt.get(order).getLastName2());
		panel.setDNI(rslt.get(order).getDni());
		panel.setEmail(rslt.get(order).getEmail());
		panel.setPhoneNumber(rslt.get(order).getPhoneN());
		panel.setAddress(rslt.get(order).getAddress());
		panel.setGender(rslt.get(order).getGender());

	}
	
	/**
	 * 
	 */
	private void updateTableImage() {
		try {		   
			Connection conexion = ConnectionManager.getConnection();
		   
			PreparedStatement ps = (PreparedStatement) conexion.
					prepareStatement("UPDATE estudiante set imagen=? where id=?");
			
			ps.setBytes(1, PersonalDataPanel.getByteImage());
			ps.setInt(2, 1);
		   
			int registrosAfectados = ps.executeUpdate();
			if (registrosAfectados > 0) {
				JOptionPane.showMessageDialog(null, "Inserción correcta en la tabla");
			}
			
			ps.close();
			conexion.close();
		}
		catch (ClassNotFoundException ex) {
			System.out.println("Imposible acceder al driver Mysql");
			ex.printStackTrace();
		}
		catch (SQLException ex) {
			System.out.println("Error en la ejecuci�n SQL: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

}
