package es.jepm.ddbbGestion.view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import es.jepm.ddbbGestion.controllers.ProfesorController;
import es.jepm.ddbbGestion.controllers.StudentController;
import es.jepm.ddbbGestion.model.PersonModel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.util.List;

public class ProfesorGestionPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ProfesorGestionPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[]{0.0, 1.0};
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
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(personalDataPanel, gbc_panel);
		
		setFirst(personalDataPanel);
		
	}
	
	public void setFirst(PersonalDataPanel panel) {
		List<PersonModel> rslt = ProfesorController.findResult();
		
		panel.setId(rslt.get(0).getId());
		panel.setName(rslt.get(0).getName());
		panel.setLastName(rslt.get(0).getLastName());
		panel.setLastName2(rslt.get(0).getLastName2());
		panel.setDNI(rslt.get(0).getDni());
		panel.setEmail(rslt.get(0).getEmail());
		panel.setPhoneNumber(rslt.get(0).getPhoneN());
		panel.setAddress(rslt.get(0).getAddress());
		panel.setGender(rslt.get(0).getGender());

	}

}
