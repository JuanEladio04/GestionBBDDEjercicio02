package es.jepm.ddbbGestion.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import es.jepm.ddbbGestion.controllers.GenderController;
import es.jepm.ddbbGestion.controllers.StudentController;
import es.jepm.ddbbGestion.model.Gender;
import java.awt.Insets;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class PersonalDataPanel extends JPanel {
	private JTextField jtfID;
	private JTextField jtfName;
	private JTextField jtfLastname;
	private JTextField jtfLastName2;
	private JTextField jftDNI;
	private JTextField jtfAddress;
	private JTextField jtfEmail;
	private JTextField jtfPhoneN;
	private JLabel lblNewLabel_7;
	private JComboBox cbGender;
	private JPanel panel;
	private JButton btnChooseImage;
	private JTextField textField_1;
	private JButton btnNewButton_1;
	private JScrollPane scrollPane;
	private static byte[] BYTEIMAGE;

	/**
	 * Create the panel.
	 */
	public PersonalDataPanel() {
		setBackground(new Color(255, 255, 255));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWidths = new int[]{0, 289, 0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0};
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
		gbc_jtfID.insets = new Insets(0, 0, 5, 5);
		gbc_jtfID.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfID.gridx = 1;
		gbc_jtfID.gridy = 0;
		add(jtfID, gbc_jtfID);
		jtfID.setColumns(10);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 9;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);
		
		btnChooseImage = new JButton("Elegir Imagen");
		btnChooseImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser selector = new JFileChooser();
				selector.setFileFilter(new FileNameExtensionFilter("Archivos de imagen", "jpg", "jpeg", "png", "gif"));
				int state = selector.showOpenDialog(null);
				if (state == JFileChooser.APPROVE_OPTION) {
					try {
					    File file = selector.getSelectedFile();
					    String path = file.getAbsolutePath();
						BYTEIMAGE = Files.readAllBytes(file.toPath());
					    ImageIcon image = new ImageIcon(path);
					    JLabel lImage = new JLabel(image);
					    scrollPane.setViewportView(lImage);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		GridBagConstraints gbc_btnChooseImage = new GridBagConstraints();
		gbc_btnChooseImage.insets = new Insets(0, 0, 5, 0);
		gbc_btnChooseImage.gridx = 0;
		gbc_btnChooseImage.gridy = 1;
		panel.add(btnChooseImage, gbc_btnChooseImage);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 2;
		panel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		btnNewButton_1 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 3;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
		
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
		gbc_jtfName.insets = new Insets(0, 0, 5, 5);
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
		gbc_jtfLastname.insets = new Insets(0, 0, 5, 5);
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
		gbc_jftLastName2.insets = new Insets(0, 0, 5, 5);
		gbc_jftLastName2.fill = GridBagConstraints.HORIZONTAL;
		gbc_jftLastName2.gridx = 1;
		gbc_jftLastName2.gridy = 3;
		add(jtfLastName2, gbc_jftLastName2);
		jtfLastName2.setColumns(10);
		
		lblNewLabel_7 = new JLabel("Sexo:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 4;
		add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		cbGender = new JComboBox();
		GridBagConstraints gbc_cbGender = new GridBagConstraints();
		gbc_cbGender.insets = new Insets(0, 0, 5, 5);
		gbc_cbGender.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbGender.gridx = 1;
		gbc_cbGender.gridy = 4;
		add(cbGender, gbc_cbGender);
		
		JLabel lblNewLabel_3 = new JLabel("DNI");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 5;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jftDNI = new JTextField();
		GridBagConstraints gbc_jftDNI = new GridBagConstraints();
		gbc_jftDNI.insets = new Insets(0, 0, 5, 5);
		gbc_jftDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_jftDNI.gridx = 1;
		gbc_jftDNI.gridy = 5;
		add(jftDNI, gbc_jftDNI);
		jftDNI.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Dirección: ");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 6;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfAddress = new JTextField();
		GridBagConstraints gbc_jtfAddress = new GridBagConstraints();
		gbc_jtfAddress.insets = new Insets(0, 0, 5, 5);
		gbc_jtfAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfAddress.gridx = 1;
		gbc_jtfAddress.gridy = 6;
		add(jtfAddress, gbc_jtfAddress);
		jtfAddress.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Email: ");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 7;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 5);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 7;
		add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Teléfono:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 8;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		jtfPhoneN = new JTextField();
		GridBagConstraints gbc_jtfPhoneN = new GridBagConstraints();
		gbc_jtfPhoneN.insets = new Insets(0, 0, 0, 5);
		gbc_jtfPhoneN.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfPhoneN.gridx = 1;
		gbc_jtfPhoneN.gridy = 8;
		add(jtfPhoneN, gbc_jtfPhoneN);
		jtfPhoneN.setColumns(10);
		
		setValuesToGender();
		
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
	/**
	 * 
	 * @param address
	 */
	
	public void setAddress(String address) {
		this.jtfAddress.setText(address);
	}
	
	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.jtfEmail.setText(email);
	}
	
	/**
	 * 
	 * @param pNumber
	 */
	public void setPhoneNumber(String pNumber) {
		this.jtfPhoneN.setText(pNumber);
	}
	
	/**
	 * 
	 * @param gender
	 */
	public void setGender(int gender) {
		this.cbGender.setSelectedItem(gender);
	}
	
	/**
	 * 
	 * @return
	 */
	public static byte[] getByteImage() {
			return BYTEIMAGE;
	}	
	
	/**
	 * 
	 */
	private void setValuesToGender() {
		List<Gender> values = GenderController.findResult();
		
		for(Gender value : values) {
			cbGender.addItem(value.getId());
		}		
	}
	
	
}
