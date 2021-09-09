/**
 * @author ozan.geckin
 * This class has details of Customer class extends User class and implements StockChecker
 */
//package hw3;

import java.util.Random;

public class Customer extends User implements StockChecker {

	private int customerID;
	private String email;
	private String phoneNumber;
	private String address;
	public HybridList<OfficeProduct> orders;

	/**
	 * Default constructor Customer
	 */
	public Customer() {
		super("", "", "Customer", "");
		this.customerID = 0;
		this.email = "";
		this.phoneNumber = "";
		this.address = "";
		orders = new HybridList<OfficeProduct>();
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
	public Customer(String newName, String newSurname, String newPassword, String newEmail, String newPhoneNumber,
			String newAddress) {
		super(newName, newSurname, "Customer", newPassword);
		this.email = newEmail;
		this.phoneNumber = newPhoneNumber;
		this.address = newAddress;
		this.customerID = generateRandomCustomerId();
		orders = new HybridList<OfficeProduct>();
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
	 * This method check whether the entered costumer is registered in the system
	 * 
	 * @param company Company
	 * @param email   String Customer email
	 * @param pass    String Customer pass
	 * @return boolean 
	 */
	public boolean customerValidate(Company company, String name, String pass) {
		for (int i = 0; i < company.getUserList().getSize(); i++) {
			if (company.getUserList().get(i).getUserStatus().equals("Customer")) {
				if (company.getUserList().get(i).getName().equals(name)
						&& company.getUserList().get(i).getName().equals(pass)) {
					return true;
				}
			}

		}
		return false;
	}

	/**
	 * This method allows to add customer to the company system
	 * 
	 * @param company Company
	 */
	public void customerRegister(Company company) {
		company.getUserList().add(this);
	}

	/**
	 * This method lists customer's product
	 */
	public void customerProductList() {

		System.out.print("WELCOME TO SYSTEM " + getName() + " old ordes \n");
		if (orders.getSize() == 0) {
			System.out.println("Order is null");
		}
		for (int i = 0; i < orders.getSize(); i++) {
			System.out.println(orders.get(i).toString());
		}
	}

	/**
	 * This method allow the customer to buy products and the branch uptade stock
	 * 
	 * @param company    Company
	 * @param product    OfficeProduct
	 * @param branchName String
	 */
	public void customerSell(Company company, OfficeProduct product, String branchName) {
		orders.addFirst(product);
		for (int i = 0; i < company.getBranchList().getSize(); i++) {
			if (company.getBranchList().get(i).getName().equals(branchName)) {
				company.getBranchList().get(i).getBranchEmployeeList().get(0).removeProduct(company, product);
			}
		}

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
	 * I override the object class's toString method according to my needs.
	 */
	@Override
	public String toString() {
		return String.format("Customer ID: " + customerID + ", Customer's Name: " + getName() + ", Customer's Surname: "
				+ getSurname() + ", Customer's Email: " + email + ", Customer's Password: " + getPassword()
				+ ", Customer's Address: " + address + ", Customer's PhoneNumber: " + phoneNumber);
	}
}
