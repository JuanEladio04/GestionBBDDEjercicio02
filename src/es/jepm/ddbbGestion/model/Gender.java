package es.jepm.ddbbGestion.model;

public class Gender {
	private int id;
	private String description;
	
	/**
	 * 
	 */
	public Gender() {
		super();
	}

	/**
	 * @param id
	 * @param description
	 */
	public Gender(int id, String description) {
		super();
		this.id = id;
		this.description = description;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return description;
	}
	
	

}
