package es.jepm.ddbbGestion.model;

public class Student {
	private int id;
	private String name;
	private String lastName;
	private String lastName2;
	private String dni;
	private String address;
	private String email;
	private String phoneN;
	
	/**
	 * Constructor por defecto
	 */
	public Student() {
		super();
	}
	
	/**
	 * @param id
	 * @param name
	 * @param lastName
	 * @param lastName2
	 * @param dni
	 * @param address
	 * @param email
	 * @param phoneN
	 */
	public Student(int id, String name, String lastName, String lastName2, String dni, String address, String email,
			String phoneN) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.lastName2 = lastName2;
		this.dni = dni;
		this.address = address;
		this.email = email;
		this.phoneN = phoneN;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * @return the lastName2
	 */
	public String getLastName2() {
		return lastName2;
	}
	
	/**
	 * @param lastName2 the lastName2 to set
	 */
	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}
	
	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}
	
	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return the phoneN
	 */
	public String getPhoneN() {
		return phoneN;
	}
	
	/**
	 * @param phoneN the phoneN to set
	 */
	public void setPhoneN(String phoneN) {
		this.phoneN = phoneN;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", lastName=" + lastName + ", lastName2=" + lastName2 + ", dni="
				+ dni + ", address=" + address + ", email=" + email + ", phoneN=" + phoneN + "]";
	}
	
}
