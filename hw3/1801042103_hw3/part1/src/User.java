/**
 * 
 * @author ozan.geckin
 * This class has all the details of User of Company
 */
//package hw3;

public abstract class User {

	private String name;
	private String surname;
	private String userStatus;
	private String password;

	/**
	 * Default constructor of User abstract class set name of User empty set surname
	 * of User empty set password of use empty set userStatus of User empty
	 */
	public User() {
		name = "";
		surname = "";
		userStatus = "";
		password = "";
	}

	/**
	 * Constructor of User class with three parameters name,surname and password
	 * 
	 * @param newName       User name
	 * @param newSurname    User surname
	 * @param newUserStatus User password
	 */
	public User(String newName, String newSurname, String newUserStatus) {
		this.name = newName;
		this.surname = newSurname;
		this.userStatus = newUserStatus;
		this.password = "";

	}

	/**
	 * Constructor of User class with four parameters
	 * name,surname,userStatus,password
	 * 
	 * @param newName       User name
	 * @param newSurname    User surname
	 * @param newUserStatus User userStatus
	 * @param newPassword   User password
	 */
	public User(String newName, String newSurname, String newUserStatus, String newPassword) {
		this.name = newName;
		this.surname = newSurname;
		this.userStatus = newUserStatus;
		this.password = newPassword;
	}

	/**
	 * Copy Constructor I am using it in assign operations
	 * 
	 * @param otherObj User
	 */
	public User(User otherObj) {
		this.name = otherObj.name;
		this.surname = otherObj.surname;
		this.password = otherObj.password;
		this.userStatus = otherObj.userStatus;
	}

	/**
	 * Getter for User name
	 * 
	 * @return name name of the User
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter of User name
	 * 
	 * @param name name of User
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for User surname
	 * 
	 * @return surname surname of the User
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Setter of User surname
	 * 
	 * @param surname surname of the User
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * Getter for User userStatus
	 * 
	 * @return userStatus userStatus of the User
	 */
	public String getUserStatus() {
		return userStatus;
	}

	/**
	 * Setter of User userStatus
	 * 
	 * @param userStatus userStatus of the User
	 */
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	/**
	 * Getter for User password
	 * 
	 * @return password password of the User
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter of User userStatus
	 * 
	 * @param password password of the Us
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
