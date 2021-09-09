/**
 * @author 1801042103
 * This class has all the details of BranchEmployee extend Users class
 */
//package CompanySystem;

public class BranchEmployee implements Users {

	private String name;
	private String surname;
	private String password;

	/**
	 * Default Constructor set name of BranchEmployee empty set surname of
	 * BranchEmployee empty set password of BranchEmployee empty
	 */
	public BranchEmployee() {
		this.name = "";
		this.surname = "";
		this.password = "";
	}

	/**
	 * Constructor of BranchEmployee class with three parameters
	 * name,surname,password
	 * 
	 * @param name     BranchEmployee name
	 * @param surname  BranchEmployee surname
	 * @param password BranchEmployee password
	 */
	public BranchEmployee(String name, String surname, String password) {
		this.name = name;
		this.surname = surname;
		this.password = password;
	}

	/**
	 * Copy constructor System need to be copy constructor to move the other object
	 * and object
	 * 
	 * @param otherObj BranchEmployee object
	 */
	public BranchEmployee(BranchEmployee otherObj) {
		this.name = otherObj.name;
		this.surname = otherObj.surname;
		this.password = otherObj.password;
	}

	/**
	 * Getter for BranchEmployee name
	 * 
	 * @return name name of BranchEmployee name
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Setter of BranchEmployee name
	 * 
	 * @param name name of BranchEmployee name
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for BranchEmployee surname
	 * 
	 * @return surname surname of BranchEmployee name
	 */
	@Override
	public String getSurName() {
		return surname;
	}

	/**
	 * Setter of BranchEmployee surname
	 * 
	 * @param surname surname of BranchEmployee name
	 */
	@Override
	public void setSurName(String surname) {
		this.surname = surname;
	}

	/**
	 * Getter for BranchEmployee password
	 * 
	 * @return password password of BranchEmployee name
	 */
	@Override
	public String getPassword() {
		return password;
	}

	/**
	 * Setter of BranchEmployee password
	 * 
	 * @param password password of BranchEmployee name
	 */
	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * I override the object class's toString method according to my needs.
	 */
	@Override
	public String toString() {
		return String.format("Employee name: " + name + " " + ",Employee surname: " + surname
				+ " ,Hint: Employee Password: " + password);
	}

}
