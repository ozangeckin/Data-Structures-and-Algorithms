/**
 * @author 1801042104
 * This class has all the details of Customers of Company extend Users class
 */
//package CompanySystem;

import java.util.Random;

public class Customer implements Users {

	private String name;
	private String surname;
	private String password;
	private String email;
	private String phoneNumber;
	private String address;
	private int customerID;
	public OfficeProducts[] orders;
	private int ordersCapacity, ordersNumber;

	/**
	 * Default constructor of Customer class set special generic customerID of
	 * Customer 0 set name of Customer empty set surname of Customer empty set email
	 * of Customer empty set password of Customer empty set phoneNumber of Customer
	 * empty set orders array of Customer two size initialize set ordersCapacity of
	 * Customer 2 set ordersNumber of Customer 0
	 */
	public Customer() {
		this.customerID = 0;
		this.name = "";
		this.surname = "";
		this.email = "";
		this.password = "";
		this.phoneNumber = "";
		this.address = "";
		this.orders = new OfficeProducts[2];
		this.ordersCapacity = 2;
		this.ordersNumber = 0;

	}

	/**
	 * Constructor of Customer class with four parameters name, surname, password,
	 * email
	 * 
	 * @param Name     Customer name
	 * @param Surname  Customer surname
	 * @param Password Customer password
	 * @param Email    Customer email
	 */
	public Customer(String Name, String Surname, String Password, String Email) {
		this.customerID = generateRandomCustomerId();
		this.name = Name;
		this.surname = Surname;
		this.password = Password;
		this.email = Email;
		this.address = "";
		this.phoneNumber = "";
		this.orders = new OfficeProducts[2];
		this.ordersCapacity = 2;
		this.ordersNumber = 0;
	}

	/**
	 * Constructor of Customer class with six parameters
	 * name,surname,password,email,phoneNumber,address
	 * 
	 * @param Name        Customer name
	 * @param Surname     Customer surname
	 * @param Password    Customer password
	 * @param Email       Customer email
	 * @param PhoneNumber Customer phoneNumber
	 * @param Addrees     Customer address
	 */
	public Customer(String Name, String Surname, String Password, String Email, String PhoneNumber, String Addrees) {
		this.customerID = generateRandomCustomerId();
		this.name = Name;
		this.surname = Surname;
		this.password = Password;
		this.email = Email;
		this.address = Addrees;
		this.phoneNumber = PhoneNumber;
		this.orders = new OfficeProducts[2];
		this.ordersCapacity = 2;
		this.ordersNumber = 0;
	}

	/**
	 * Generate Random Customer Id
	 * 
	 * @return tempCustomerId for customerId of Customer
	 */
	public int generateRandomCustomerId() {
		int tempCustomerId;
		Random rd = new Random();
		tempCustomerId = 1000000 + rd.nextInt(9000000);
		return tempCustomerId;
	}

	/**
	 * Getter for Customer Id
	 * 
	 * @return customerID customerID of Customer 
	 */
	public int getCustomerID() {
		return customerID;
	}

	/**
	 * Getter for Customer name
	 * 
	 * @return name name of Customer
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Getter for Customer phone number
	 * 
	 * @return phoneNumber phoneNumber of Customer
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Setter of Customer phone number
	 * 
	 * @param phoneNumber phoneNumber of Customer
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Getter for Customer address
	 * 
	 * @return address address of Customer
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Setter of Customer address
	 * 
	 * @param address address of Customer
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Setter of Customer name
	 * 
	 * @param name name of Customer
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for Customer surname
	 * 
	 * @return surname surname of Customer
	 */
	@Override
	public String getSurName() {
		return surname;
	}

	/**
	 * Setter of Customer surname
	 * 
	 * @param surname surname of Customer
	 */
	@Override
	public void setSurName(String surname) {
		this.surname = surname;
	}

	/**
	 * Getter for Customer password
	 * 
	 * @return password password of Customer
	 */
	@Override
	public String getPassword() {
		return password;
	}

	/**
	 * Setter of Customer password
	 * 
	 * @param password password of Customer
	 */
	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter for Customer email
	 * 
	 * @return email email of Customer
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter of Customer email
	 * 
	 * @param email email of Customer
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter for Customer orders array
	 * 
	 * @return orders orders of Customer
	 */
	public OfficeProducts[] getOrders() {
		return orders;
	}

	/**
	 * Getter for Customer ordersCapacity
	 * 
	 * @return ordersCapacity ordersCapacity Customer orders array capacity
	 */
	public int getOrdersCapacity() {
		return ordersCapacity;
	}

	/**
	 * Setter of Customer ordersCapacity
	 * 
	 * @param ordersCapacity ordersCapacity Customer orders array capacity
	 */
	public void setOrdersCapacity(int ordersCapacity) {
		this.ordersCapacity = ordersCapacity;
	}

	/**
	 * Getter for Customer ordersNumber
	 * 
	 * @return ordersNumber ordersNumber Customer orders number
	 */
	public int getOrdersNumber() {
		return ordersNumber;
	}

	/**
	 * Setter of Customer ordersNumber
	 * 
	 * @param ordersNumber ordersNumber Customer orders number
	 */
	public void setOrdersNumber(int ordersNumber) {
		this.ordersNumber = ordersNumber;
	}

	/**
	 * Increases the maximum capacity of the orders array. Holds the current
	 * information in a temporary array and creates a new orders array by twice the
	 * current capacity. Gets the old information from temporary array.
	 */
	public void increaseOrdersCapacity() {
		OfficeProducts[] temp = new OfficeProducts[ordersCapacity];
		for (int i = 0; i < ordersNumber; i++) {
			if (orders[i] != null) {
				temp[i] = new OfficeProducts(orders[i].getModel(), orders[i].getColor(), orders[i].getName());
			}
		}
		orders = new OfficeProducts[ordersCapacity * 2];
		for (int i = 0; i < ordersNumber; i++) {
			if (temp[i] != null) {
				orders[i] = new OfficeProducts(temp[i].getModel(), temp[i].getColor(), temp[i].getName());
			}
		}
		ordersCapacity *= 2;
	}

	/**
	 * I override the object class's toString method according to my needs.
	 */
	@Override
	public String toString() {
		return String.format("Customer ID: " + customerID + ", Customer's Name: " + name + ", Customer's Surname: "
				+ surname + ", Customer's Email: " + email + ", Customer's Password: " + password
				+ ", Customer's Address: " + address + ", Customer's PhoneNumber: " + phoneNumber);
	}

}
