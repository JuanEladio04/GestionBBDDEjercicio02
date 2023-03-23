package es.jepm.ddbbGestion.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import es.jepm.ddbbGestion.controllers.StudentController;
import es.jepm.ddbbGestion.model.Student;

import java.awt.Insets;

public class PersonalDataPanel extends JPanel {
	private JTextField jtfID;
	private JTextField jtfName;
	private JTextField jtfLastname;
	private JTextField jtfLastName2;
	private JTextField jftDNI;
	private JTextField jtfAddress;
	private JTextField jtfEmail;
	private JTextField jtfPhoneN;

	/**
	 * Create the panel.
	 */
	public PersonalDataPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[]{0.0, 1.0};
//		gridBagLayout.columnWidths = new int[]{40, 0, 0};
//		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
//		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("id:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		jtfID = new JTextField();
		GridBagConstraints gbc_jtfID = new GridBagConstraints();
		gbc_jtfID.anchor = GridBagConstraints.NORTH;
		gbc_jtfID.insets = new Insets(0, 0, 5, 0);
		gbc_jtfID.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfID.gridx = 1;
		gbc_jtfID.gridy = 0;
		add(jtfID, gbc_jtfID);
		jtfID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfName = new JTextField();
		jtfName.setColumns(10);
		GridBagConstraints gbc_jtfName = new GridBagConstraints();
		gbc_jtfName.insets = new Insets(0, 0, 5, 0);
		gbc_jtfName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfName.gridx = 1;
		gbc_jtfName.gridy = 1;
		add(jtfName, gbc_jtfName);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido 1: ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfLastname = new JTextField();
		jtfLastname.setColumns(10);
		GridBagConstraints gbc_jtfLastname = new GridBagConstraints();
		gbc_jtfLastname.insets = new Insets(0, 0, 5, 0);
		gbc_jtfLastname.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfLastname.gridx = 1;
		gbc_jtfLastname.gridy = 2;
		add(jtfLastname, gbc_jtfLastname);
		
		JLabel lblNewLabel_2_1 = new JLabel("Apellido 2: ");
		GridBagConstraints gbc_lblNewLabel_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_1.gridx = 0;
		gbc_lblNewLabel_2_1.gridy = 3;
		add(lblNewLabel_2_1, gbc_lblNewLabel_2_1);
		
		jtfLastName2 = new JTextField();
		jtfLastName2.setText("");
		GridBagConstraints gbc_jftLastName2 = new GridBagConstraints();
		gbc_jftLastName2.insets = new Insets(0, 0, 5, 0);
		gbc_jftLastName2.fill = GridBagConstraints.HORIZONTAL;
		gbc_jftLastName2.gridx = 1;
		gbc_jftLastName2.gridy = 3;
		add(jtfLastName2, gbc_jftLastName2);
		jtfLastName2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("DNI");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jftDNI = new JTextField();
		GridBagConstraints gbc_jftDNI = new GridBagConstraints();
		gbc_jftDNI.insets = new Insets(0, 0, 5, 0);
		gbc_jftDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_jftDNI.gridx = 1;
		gbc_jftDNI.gridy = 4;
		add(jftDNI, gbc_jftDNI);
		jftDNI.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Dirección: ");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfAddress = new JTextField();
		GridBagConstraints gbc_jtfAddress = new GridBagConstraints();
		gbc_jtfAddress.insets = new Insets(0, 0, 5, 0);
		gbc_jtfAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfAddress.gridx = 1;
		gbc_jtfAddress.gridy = 5;
		add(jtfAddress, gbc_jtfAddress);
		jtfAddress.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Email: ");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 6;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 6;
		add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Teléfono:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 7;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		jtfPhoneN = new JTextField();
		GridBagConstraints gbc_jtfPhoneN = new GridBagConstraints();
		gbc_jtfPhoneN.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfPhoneN.gridx = 1;
		gbc_jtfPhoneN.gridy = 7;
		add(jtfPhoneN, gbc_jtfPhoneN);
		jtfPhoneN.setColumns(10);
		
	}
	
	/**
	 * 
	 * @param id
	 */
	public void setId (int id) {
		this.jtfID.setText("" + id);
	}
	
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.jtfName.setText(name);
	}
	
	/**
	 * 
	 * @param lName
	 */
	public void setLastName(String lName) {
		this.jtfLastname.setText(lName);
	}
	
	/**
	 * 
	 * @param lName
	 */
	public void setLastName2(String lName) {
		this.jtfLastName2.setText(lName);
	}
	
	/**
	 * 
	 * @param name
	 */
	public void setDNI(String dni) {
		this.jftDNI.setText(dni);
	}
	
	public void setAddress(String address) {
		this.jtfAddress.setText(address);
	}
	
	public void setEmail(String email) {
		this.jtfEmail.setText(email);
	}
	
	public void setPhoneNumber(String pNumber) {
		this.jtfPhoneN.setText(pNumber);
	}
	
}
