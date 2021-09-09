/**
 * 
 * @author 1801042103
 * This class has all the details of Administrators of Company
 */
//package CompanySystem;

public class Administrator implements Users {

	private String name;
	private String surname;
	private String password;

	/**
	 * Default constructor of Administrator Class Set name of Administrator empty
	 * Set surname of Administrator empty Set password of Administrator empty
	 */
	public Administrator() {
		name = "";
		surname = "";
		password = "";
	}

	/**
	 * Constructor of Administrator class with three parameters name, surname and
	 * password
	 * 
	 * @param name     Administrator name
	 * @param surname  Administrator surname
	 * @param password Administrator password
	 */
	public Administrator(String name, String surname, String password) {
		this.name = name;
		this.surname = surname;
		this.password = password;
	}

	/**
	 * Getter for administrator name
	 * 
	 * @return name name of the Administrator
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Setter of administrator name
	 * 
	 * @param name name of the Administrator
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for administrator surname
	 * 
	 * @return surname surname of the Administrator
	 */
	@Override
	public String getSurName() {
		return surname;
	}

	/**
	 * Setter of administrator surname
	 * 
	 * @param surname surname of the Administrator
	 */
	@Override
	public void setSurName(String surname) {
		this.surname = surname;
	}

	/**
	 * Getter for administrator password
	 * 
	 * @return password password of the Administrator
	 */
	@Override
	public String getPassword() {
		return password;
	}

	/**
	 * Setter of Administrator password
	 * 
	 * @param password password password of the Administrator
	 */
	@Override
	public void setPassword(String password) {
		this.password = password;

	}
}
