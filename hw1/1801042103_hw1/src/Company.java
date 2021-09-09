/**
 * @author 1801042103
 * This class is the core class of my system. All transactions made to the system are managed by the methods here. 
 */
//package CompanySystem;

import java.util.Scanner;

public class Company {
	public Administrator[] adminstratorMyArray;
	public Branch[] branchMyArray;
	public Customer[] customerMyArray;
	private BranchEmployee onlineEmployee;
	private Branch onlineBranch;
	private Customer onlineCustomer;
	private int adminCapacity, adminNumber, branchCapacity, branchNumber, customerNumber, customerCapacity;
	private Scanner scan;
	private String[] productName;
	private String[] productModel;
	private String[] productColor;

	/**
	 * Default constructor of Company class set adminstratoryMyArray array of
	 * Company two size initialize set branchMyArray array of Company four size
	 * initialize set branchMyArray array of Company fill default four branch set
	 * customerMyArray array of Company two size initialize set customerMyArray
	 * array of Company fill default two customer set branchNumber of Company 4 set
	 * branchCapacity of Company 4 set adminCapacity of Company 2 set adminNumber of
	 * Company 0 set customerCapacity of Company 2 set customerNumber of Comapany 2
	 * set productName string array of Company initialize and fill office product
	 * type set productModel string array of Company initialize and fill office
	 * product model type set productColor string array of Company initialize and
	 * fill office product color type
	 */
	public Company() {
		adminstratorMyArray = new Administrator[2];
		branchMyArray = new Branch[4];
		branchMyArray[0] = new Branch("Branch1");
		branchMyArray[1] = new Branch("Branch2");
		branchMyArray[2] = new Branch("Branch3");
		branchMyArray[3] = new Branch("Branch4");
		customerMyArray = new Customer[2];
		customerMyArray[0] = new Customer("customer", "customer", "123", "customer@gmail.com", "05445649684",
				"Usküdar/Istanbul");
		customerMyArray[1] = new Customer("customer2", "customer2", "321", "customer2@gmail.com", "05053215632",
				"Ilkadim/Samsun");
		branchNumber = 4;
		branchCapacity = 4;
		adminCapacity = 2;
		adminNumber = 0;
		customerCapacity = 2;
		customerNumber = 2;
		productName = new String[] { "Office Chair", "Office Desk", "Office Cabinet", "Bookcase", "Meeting Table" };
		productModel = new String[] { "model1", "model2", "model3", "model4", "model5", "model6", "model7", "model8",
				"model9", "model10", "model11", "model12" };
		productColor = new String[] { "black", "red", "blue", "green", "pink" };
	}

	/**
	 * Prints the branch in the company system
	 */
	public void branchList() {
		System.out.println("Branches List: ");
		int counter = 1;
		for (int i = 0; i < branchCapacity; i++) {
			if (branchMyArray[i] != null) {// Check branchMyArray
				System.out.println(counter + " : " + branchMyArray[i].getName());
				counter++;
			}
		}
	}

	/**
	 * Company of system adding branch This method lists the branches in the system
	 * Compares branchNumber with branchCapacity if branchMyArray equal
	 * branchCapacity, it increases the capacity of branchMyArray by 2 times. It
	 * takes a branch name and creates a new branch object with it. The new branch
	 * 
	 * @throws MyException e "Not adding .There is a branch with the same name
	 */
	public void addBranch() throws MyException {
		try {
			scan = new Scanner(System.in);
			branchList();
			// Capacity is full, creates a new branches array with doubled capacity.
			if (branchCapacity == branchNumber) {
				Branch[] tempArray = new Branch[branchCapacity];
				for (int i = 0; i < branchNumber; i++) {
					tempArray[i] = new Branch(branchMyArray[i]);
				}
				branchMyArray = new Branch[branchCapacity * 2];
				for (int i = 0; i < branchNumber; i++) {
					branchMyArray[i] = new Branch(tempArray[i]);
				}
				branchCapacity *= 2;
			}
			System.out.print("Enter the new branch's name: ");
			String temp = scan.next();
			for (int i = 0; i < branchCapacity; i++) {
				if (branchMyArray[i] != null && branchMyArray[i].getName().equals(temp)) {
					throw new MyException("Not adding .There is a branch with the same name");
				}
			}
			branchMyArray[branchNumber] = new Branch(temp);
			branchNumber++;// Updates the current branch number
			System.out.println(temp + " adding");
		} catch (MyException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Company of system remove branch This method lists the branches in the system
	 * It is call findbranchByName method with parameters branchMyArray and user
	 * input branch name foundIndex keeps the return value of the findBranchByName
	 * method Created tempBranch Array copy branchMyArray foundIndex is checked and
	 * the found branch is deleted and branchMyArray is shifted. if foundIndex
	 * return -1(false) throw Exception tempBranch assign new branchMyArray Decrease
	 * branchNumbr
	 * 
	 * @throws MyException error message
	 */
	public void removeBranch() throws MyException {
		try {
			branchList();
			scan = new Scanner(System.in);
			System.out.print("Enter the name of the branch that you want to remove: ");
			String temp = scan.next();
			int foundIndex = findBranchByName(branchMyArray, temp);
			if (foundIndex == -1) {// check branch
				throw new MyException("Branch is not found");
			} else {
				Branch[] tempBranch = new Branch[branchCapacity];
				for (int i = 0; i < foundIndex; i++) {
					tempBranch[i] = branchMyArray[i];
				}
				for (int i = foundIndex + 1; i < branchMyArray.length; i++) {
					tempBranch[i - 1] = branchMyArray[i];
				}
				branchMyArray = tempBranch;
				branchNumber--;
				System.out.println("Remove Branch");
			}
		} catch (MyException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Company of system find branch by name input Branch[] arr checked null with
	 * for loop, when arr finds queries up to size, it returns index
	 * 
	 * @param arr Branch[]
	 * @param str String
	 * @return i int
	 */
	private int findBranchByName(Branch[] arr, String str) {
		if (arr != null) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != null && arr[i].getName() != null && arr[i].getName().equals(str)) {
					return i;
				}
			}
		}
		return -1;
	}

	/**
	 * Getter for online branch in company system
	 * 
	 * @return onlineBranch Branch
	 */
	public Branch onlineBranch() {
		return onlineBranch;
	}

	/**
	 * Setter of Company onlineBranch
	 * 
	 * @param branch Branch
	 */
	public void setOnlineBranch(Branch branch) {
		onlineBranch = branch;
	}

	/**
	 * This method check whether the entered admin is registered in the system
	 * 
	 * @param admin Admin object
	 * @return boolean 
	 */
	public boolean adminValidate(Administrator admin) {
		for (int i = 0; i < adminNumber; i++) {
			if (adminstratorMyArray != null && adminstratorMyArray[i].getName().matches(admin.getName())
					&& adminstratorMyArray[i].getSurName().matches(admin.getSurName())
					&& adminstratorMyArray[i].getPassword().matches(admin.getPassword())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method register admin to the system Compares adminNumber and
	 * adminCapacity.If adminNumber equal adminCapacity,it increases the capacity of
	 * adminstratorMyArray by 2 times.admin assing adminNumber indef of
	 * adminstratorMyArray Increases adminNumber
	 * 
	 * @param admin Admin object
	 * @throws MyException error message
	 */
	public void addAdmin(Administrator admin) throws MyException {
		try {
			// if capacity is reached, increases it by twice
			if (adminCapacity == adminNumber) {
				Administrator[] tempArray = new Administrator[adminCapacity];

				for (int i = 0; i < adminNumber; i++) {
					tempArray[i] = new Administrator(adminstratorMyArray[i].getName(),
							adminstratorMyArray[i].getSurName(), adminstratorMyArray[i].getPassword());
				}
				adminstratorMyArray = new Administrator[adminCapacity * 2];
				for (int i = 0; i < adminNumber; i++) {
					adminstratorMyArray[i] = new Administrator(tempArray[i].getName(), tempArray[i].getSurName(),
							tempArray[i].getPassword());
				}
				adminCapacity *= 2;
			}
			for (int i = 0; i < adminCapacity; i++) {
				if (adminstratorMyArray[i] != null && adminstratorMyArray[i].getName().equals(admin.getName())
						&& adminstratorMyArray[i].getSurName().equals(admin.getSurName())) {
					throw new MyException("Not Registered There is a admin with the same name");
				}
			}
			adminstratorMyArray[adminNumber] = admin;
			adminNumber++;
		} catch (MyException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Notify admin when there is no product in the system.
	 */
	public void adminInfo() {
		System.out.println("Admin informed ");
	}

	/**
	 * This method selects branch and adds an employee to the selected branch. Gets
	 * Branch employee information from the user. If the branch the user entered is
	 * not registered to the system throws exception. Assigns the new employee to
	 * the employee of branch array.
	 * 
	 * @throws MyException error message
	 */
	public void addBranchEmployee() throws MyException {
		try {
			String temp, temp1, temp2, temp3;
			scan = new Scanner(System.in);
			boolean control = false;
			System.out.print("Enter the Branch: ");
			temp = scan.next();
			for (int i = 0; i < branchMyArray.length; i++) {
				if (branchMyArray[i] != null && branchMyArray[i].getName().matches(temp)) {// check branch
					System.out.println(branchMyArray[i].getName() + "'s employees: ");
					branchMyArray[i].printEmployees();
					System.out.print("Enter the new branch employee's name:");
					temp1 = scan.next();
					System.out.print("Enter the new branch employee's surname:");
					temp2 = scan.next();
					System.out.print("Enter the new branch employee's password:");
					temp3 = scan.next();
					if (branchMyArray[i].getEmployeeCapacity() == branchMyArray[i].getEmployeeNumber()) {
						// If max capacity is reached,increases the capacity
						branchMyArray[i].increaseEmployeeCapactiy();
					}
					branchMyArray[i].employees[branchMyArray[i].getEmployeeNumber()] = new BranchEmployee(temp1, temp2,
							temp3);
					branchMyArray[i].setEmployeeNumber(branchMyArray[i].getEmployeeNumber() + 1);
					// Updates the current number of employees
					control = true;
					break;
				}
			}
			if (control == false) {
				throw new MyException("Branch is not found");
			}
			System.out.println("Add employee");
		} catch (MyException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * This method allows the administrator to remove employee from the system. It
	 * first chooses the admin branch. Here the branch is checked to see if it
	 * exists in the system. employee information is received.The information is
	 * checked. If there is that worker, the employee is removed from the system.
	 * 
	 * @param branch String name of branch
	 * @throws MyException error message
	 */
	public void removeBranchEmployee(String branch) throws MyException {
		try {
			scan = new Scanner(System.in);
			Branch tempBranch = new Branch("temp");
			BranchEmployee[] tempBranchEmployee;
			int point = 0;
			int k = 0;
			boolean control = false;
			boolean control2 = false;
			String temp1, temp2;
			System.out.println("Branches List: ");

			for (int i = 0; i < branchNumber; i++) {// check branch funtion
				if (branchMyArray[i].getName().matches(branch)) {
					tempBranch = branchMyArray[i];
					point = i;
					control = true;
					break;
				}
			}
			if (control == false) {
				throw new MyException("Branch is not found");

			}
			for (int i = 0; i < tempBranch.getEmployeeNumber(); i++) {
				if (tempBranch.employees[i] != null) {
					int counter = i + 1;
					//
					System.out.println(counter + " : " + tempBranch.employees[i].getName() + " "
							+ tempBranch.employees[i].getSurName());
				}
			}
			System.out.print("Enter the branch employee's name: ");
			temp1 = scan.next();
			System.out.print("Enter the branch employee's surname: ");
			temp2 = scan.next();
			tempBranchEmployee = new BranchEmployee[tempBranch.getEmployeeCapacity()];
			for (int i = 0; i < tempBranch.getEmployeeNumber(); i++) {
				if (tempBranch.employees[i].getName().matches(temp1)
						&& tempBranch.employees[i].getSurName().matches(temp2)) {
					tempBranch.employees[i] = null;
					for (int j = 0; j < tempBranch.getEmployeeNumber(); j++) {
						if (tempBranch.employees[j] != null) {
							tempBranchEmployee[k] = new BranchEmployee(tempBranch.employees[j].getName(),
									tempBranch.employees[j].getSurName(), tempBranch.employees[j].getPassword());
							k++;
						}
					}
					control2 = true;
					break;
				}
			}
			if (control2 == false) {
				throw new MyException("Branch Employee is not found");
			}
			if (k > 0) {
				for (int i = 0; i < k; i++) {
					tempBranch.employees[i] = tempBranchEmployee[i];
				}
			}
			tempBranch.setEmployeeNumber(tempBranch.getEmployeeNumber() - 1);
			branchMyArray[point] = tempBranch;
			System.out.println("Remove Branch Employee");

		} catch (MyException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * This method takes a Branch object and prints the object's office products.
	 * 
	 * @param branch Branch object
	 * @throws MyException error message
	 */
	public void branchStockList(Branch branch) throws MyException {
		try {
			boolean control = false;
			int counter = 1;
			for (int i = 0; i < branchNumber; i++) {
				if (branchMyArray[i] != null && branchMyArray[i].getName().matches(branch.getName())) {// check branch
					for (int j = 0; j < branchMyArray[i].getStockCapacity(); j++) {
						if (branchMyArray[i].stocks[j] != null) {// null check stocks
							System.out.println(counter + " : " + branchMyArray[i].stocks[j].toString());
							counter++;
						}
					}
					control = true;
				}
			}
			if (control == false) {
				throw new MyException("Stock is empty");
			}
		} catch (MyException e) {
			System.err.print(e.getMessage());
		}

	}

	/**
	 * This method check whether the entered branchEmployee is registered in the
	 * branch in Company System.
	 * 
	 * @param branchEmployee BranchEmployee object
	 * @param branch name of Branch name
	 * @return boolean
	 */
	public boolean branchEmployeeValidate(BranchEmployee branchEmployee, String branch) {
		for (int i = 0; i < branchNumber; i++) {
			if (branchMyArray != null && branchMyArray[i].getName().matches(branch)) {// check null and branch
				for (int j = 0; j < branchMyArray[i].getEmployeeNumber(); j++) {
					if (branchMyArray[i].employees[j].getName().matches(branchEmployee.getName())// check branch
																									// employee
							&& branchMyArray[i].employees[j].getSurName().matches(branchEmployee.getSurName())
							&& branchMyArray[i].employees[j].getPassword().matches(branchEmployee.getPassword())) {
						onlineEmployee = branchMyArray[i].employees[j];
						onlineBranch = branchMyArray[i];
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Getter for Company onlineEmployee
	 * 
	 * @return onlineEmployee BranchEmployee
	 */
	public BranchEmployee onlineEmployee() {
		return onlineEmployee;
	}

	/**
	 * This method checks whether the office product received as a parameter is in
	 * that branch.
	 * 
	 * @param test OfficeProducts object
	 * @return boolean
	 */
	public boolean checkProductBranch(OfficeProducts test) {
		for (int i = 0; i < onlineBranch.getStockCapacity(); i++) {
			if (onlineBranch.stocks[i] != null && test != null) {// null check
				if (onlineBranch.stocks[i].getName().matches(test.getName())// check stock office product
						&& onlineBranch.stocks[i].getModel().matches(test.getModel())
						&& onlineBranch.stocks[i].getColor().matches(test.getColor())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * This method checks parameters that takes users with the office products
	 * defined to the system.In reverse, it returns false.
	 * 
	 * @param pName String OfficeProduct name
	 * @param pModel String OfficeProduct model
	 * @param pColor String OfficeProduct color
	 * @return boolean
	 */
	public boolean errorCheckProduct(String pName, String pModel, String pColor) {
		boolean checkName = false, checkModel = false, checkColor = false;
		for (int i = 0; i < productName.length; i++) {
			if (pName.matches(productName[i])) {
				checkName = true;
				break;
			}
		}
		for (int i = 0; i < productModel.length; i++) {
			if (pModel.matches(productModel[i])) {
				checkModel = true;
				break;
			}
		}
		for (int i = 0; i < productColor.length; i++) {
			if (pColor.matches(productColor[i])) {
				checkColor = true;
				break;
			}
		}
		if (checkColor && checkModel && checkName) {
			return true;
		}
		return false;
	}

	/**
	 * This method checks that I get officeProduct information and inputs from the
	 * user. If it passes the checks,it creates an OfficeProducts object and returns
	 * it.
	 * 
	 * @return OfficeProducts object
	 * @throws MyException error message
	 */
	public OfficeProducts interfaceProducts() throws MyException {
		try {
			scan = new Scanner(System.in);
			String pCounter;
			String pName = null, pModel = null, pColor = null;
			int counter = 1;
			OfficeProducts choiceProduct;
			branchStockList(onlineBranch);
			System.out.println();
			System.out.println("Please Choice a Product");
			for (int i = 0; i < productName.length; i++) {
				System.out.println(counter + " : " + productName[i]);// print product type
				counter++;
			}
			System.out.print("Product's counter:");
			pCounter = scan.next();
			if (pCounter.matches("1")) {// check product type
				for (int i = 0; i < 7; i++) {
					System.out.println((i + 1) + " : " + productModel[i]);
				}
				System.out.print("Please Enter Model Name: ");
				pModel = scan.next();
				for (int i = 0; i < 5; i++) {
					System.out.println((i + 1) + " : " + productColor[i]);
				}
				System.out.print("Please Enter Color Name: ");
				pColor = scan.next();
				pName = "Office Chair";
			} else if (pCounter.matches("2")) {// check product type
				for (int i = 0; i < 5; i++) {
					System.out.println((i + 1) + " : " + productModel[i]);
				}
				System.out.print("Please Enter Model Name: ");
				pModel = scan.next();
				for (int i = 0; i < 4; i++) {
					System.out.println((i + 1) + " : " + productColor[i]);
				}
				System.out.print("Please Enter Color Name: ");
				pColor = scan.next();
				pName = "Office Desk";

			} else if (pCounter.matches("3")) {// check product type
				for (int i = 0; i < 12; i++) {
					System.out.println((i + 1) + " : " + productModel[i]);
				}
				System.out.print("Please Enter Model Name: ");
				pModel = scan.next();
				for (int i = 0; i < 1; i++) {
					System.out.println((i + 1) + " : " + productColor[i]);
				}
				System.out.print("Please Enter Color Name: ");
				pColor = scan.next();
				pName = "Office Cabinet";

			} else if (pCounter.matches("4")) {// check product type
				for (int i = 0; i < 12; i++) {
					System.out.println((i + 1) + " : " + productModel[i]);
				}
				System.out.print("Please Enter Model Name: ");
				pModel = scan.next();
				for (int i = 0; i < 1; i++) {
					System.out.println((i + 1) + " : " + productColor[i]);
				}
				System.out.print("Please Enter Color Name: ");
				pColor = scan.next();
				pName = "Bookcase";

			} else if (pCounter.matches("5")) {// check product type
				for (int i = 0; i < 10; i++) {
					System.out.println((i + 1) + " : " + productModel[i]);
				}
				System.out.print("Please Enter Model Name: ");
				pModel = scan.next();
				for (int i = 0; i < 4; i++) {
					System.out.println((i + 1) + " : " + productColor[i]);
				}
				System.out.print("Please Enter Color Name: ");
				pColor = scan.next();
				pName = "Meeting Table";
			} else {
				throw new MyException("Invalid Product Counter");
			}
			if (errorCheckProduct(pName, pModel, pColor)) {// check product
				choiceProduct = new OfficeProducts(pModel, pColor, pName);
				return choiceProduct;
			} else {
				adminInfo();// print admin information
				throw new MyException("Invalid Product\n");
			}
		} catch (MyException e) {
			System.err.print(e.getMessage());
			return null;
		}
	}

	/**
	 * This method adds officeProducts in onlineBranch
	 * 
	 * @throws MyException error message
	 */
	public void addProductBranch() throws MyException {
		OfficeProducts newProduct = new OfficeProducts();
		newProduct = interfaceProducts();// for user input product information
		if (onlineBranch.getStockCapacity() == onlineBranch().getStockNumber()) {// check branch stock capacity
			onlineBranch.increaseStokcsCapacity();
		}
		onlineBranch.stocks[onlineBranch.getStockNumber()] = newProduct;
		int newStock = onlineBranch.getStockNumber() + 1;
		System.out.println("Adding Product");
		onlineBranch.setStockNumber(newStock);
	}

	/**
	 * This method removes office product in onlineBranch
	 * 
	 * @throws MyException error message
	 */
	public void removeProductBranch() throws MyException {
		OfficeProducts choiceProduct = new OfficeProducts();
		choiceProduct = interfaceProducts();// for user input product information
		if (choiceProduct != null) {// null check
			removeProduct(choiceProduct);
		}
	}

	/**
	 * Getter for onlineCustomer Company class
	 * 
	 * @return onlineCustomer Customer object
	 */
	public Customer onlineCustomer() {
		return onlineCustomer;
	}

	/**
	 * This method allows customerCapacity increase
	 */
	public void increaseCustomerCapacity() {
		Customer[] temp = new Customer[customerCapacity];
		for (int i = 0; i < customerNumber; i++) {
			if (customerMyArray[i] != null) {// null check
				temp[i] = new Customer(customerMyArray[i].getName(), customerMyArray[i].getSurName(),
						customerMyArray[i].getPassword(), customerMyArray[i].getEmail());
			}
		}
		customerMyArray = new Customer[customerCapacity * 2];
		for (int i = 0; i < customerNumber; i++) {
			if (temp[i] != null) {// null check
				customerMyArray[i] = new Customer(temp[i].getName(), temp[i].getSurName(), temp[i].getPassword(),
						temp[i].getEmail());
			}
		}
		customerCapacity *=2;
	}

	/**
	 * This method check whether the entered costumer is registered in the system
	 * 
	 * @param email String Customer email
	 * @param pass String Customer pass
	 * @return boolean
	 */
	public boolean customerValidate(String email, String pass) {
		for (int i = 0; i < customerNumber; i++) {
			if (customerMyArray != null && customerMyArray[i].getEmail().matches(email)
					&& customerMyArray[i].getPassword().matches(pass)) {// check null and customer information
				onlineCustomer = customerMyArray[i];
				return true;
			}
		}
		return false;
	}

	/**
	 * This method allows register customer in the company system When a new user is
	 * added, it increases the capacity if the capacity equal customer number. The
	 * system increases the number of customers by 1 when the customer is added.
	 */
	public void customerRegister() {
		scan = new Scanner(System.in);
		String temp, temp1, temp3, temp4, temp5, temp6;
		System.out.println("NEW MEMBER REGISTRATION");
		System.out.println("Enter Customer's name: ");
		temp = scan.next();
		System.out.println("Enter Customer's surname: ");
		temp1 = scan.next();
		System.out.println("Enter Customer's email: ");
		temp3 = scan.next();
		System.out.println("Enter Customer's password: ");
		temp4 = scan.next();
		System.out.println("Enter Customer's address: ");
		temp5 = scan.next();
		System.out.println("Enter Customer's phone number: ");
		temp6 = scan.next();
		Customer newCustomer = new Customer(temp, temp1, temp4, temp3, temp6, temp5);
		if (customerCapacity == customerNumber) {// check customer capacity
			increaseCustomerCapacity();
		}

		customerMyArray[customerNumber] = newCustomer;
		customerNumber++;
	}

	/**
	 * This method lists employees in the branch.
	 * 
	 * @param Branch String Branch Name
	 * @return Boolean
	 * @throws MyException error message
	 */
	public boolean branchEmployeeList(String Branch) throws MyException {
		boolean check = false;
		try {
			int counter = 1;
			for (int i = 0; i < branchNumber; i++) {
				if (branchMyArray[i].getName().matches(Branch)) {// check branch
					for (int j = 0; j < branchMyArray[i].getEmployeeNumber(); j++) {
						System.out.println(counter + " : " + branchMyArray[i].employees[j].toString());
						counter++;
					}
					check = true;
				}
			}
			System.out.println();

			if (check == false) {
				throw new MyException("Branch is not found");
			}
		} catch (MyException e) {
			System.err.println(e.getMessage());
		}
		return check;
	}

	/**
	 * This method allows the branch stocks remove product.
	 *  
	 * @param product OfficeProducts object
	 * @throws MyException error message
	 */
	public void removeProduct(OfficeProducts product) throws MyException {
		boolean check=false;
		try {
		for (int i = 0; i < onlineBranch.getStockCapacity(); i++) {
			if (onlineBranch.stocks[i] != null && onlineBranch.stocks[i].getModel().matches(product.getModel())
					&& onlineBranch.stocks[i].getName().matches(product.getName())
					&& onlineBranch.stocks[i].getColor().matches(product.getColor())) {// check null and product in the
																						// branch stocks
				onlineBranch.stocks[i] = null;
				onlineBranch.setStockNumber(onlineBranch.getStockNumber() - 1);
				System.out.println("Remove Product");
				check=true;
			}
		}
		if(check==false) {
			throw new MyException("Product is not Branch Stock");
		}
		}catch (MyException e) {
			System.err.println(e.getMessage());

		}
	}

	/**
	 * his method allows the customer to purchase the product, and sorts the
	 * previous orders of the customer. checks if the product is in that branch,
	 * then assigns the product to the customer's orders and deletes the branch from
	 * the stocks.
	 * 
	 * @throws MyException error message
	 */
	public void customerSell() throws MyException {
		try {
		onlineCustomerProduct();
		OfficeProducts choiceProduct = new OfficeProducts();
		choiceProduct = interfaceProducts();
		if(choiceProduct ==null) {
			throw new MyException("");
		}
		
		if (checkProductBranch(choiceProduct)) {
			addCostumerProduct(choiceProduct);
			removeProduct(choiceProduct);
		}else {
			throw new MyException("Unfortunetly,The product is not in stock");
		}
		}catch (MyException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * This method to put customer's purchased product into the customer's order
	 * array.
	 * 
	 * @param product OfficeProducts object
	 */
	public void addCostumerProduct(OfficeProducts product) {
		if (onlineCustomer().getOrdersCapacity() == onlineCustomer.getOrdersNumber()) {
			onlineCustomer.increaseOrdersCapacity();
		}
		onlineCustomer.orders[onlineCustomer.getOrdersNumber()] = product;
		int counter = onlineCustomer.getOrdersNumber() + 1;
		onlineCustomer.setOrdersNumber(counter);
	}

	/**
	 * This method lists all the orders of the customer in the system.
	 * 
	 * @throws MyException error message
	 */
	public void onlineCustomerProduct() throws MyException {
		boolean check = false;
		try {
			System.out.print("WELCOME TO SYSTEM " + onlineCustomer.getName() + "old ordes \n");
			for (int i = 0; i < onlineCustomer.getOrdersNumber(); i++) {
				if (onlineCustomer.orders[i] != null) {// null check
					System.out.println(onlineCustomer.orders[i].toString());
					check = true;
				}
			}
			if (check == false) {
				throw new MyException("Noting Product");
			}
			System.out.println();
		} catch (MyException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * This method prints customers registered to the system
	 */
	public void registeredCustomer() {
		System.out.println("\nCustomers Registered In The System");
		for (int i = 0; i < customerNumber; i++) {
			if (customerMyArray[i] != null) {
				System.out.println((i + 1) + " : " + customerMyArray[i].toString());
			}
		}
	}

	/**
	 * This method gets the customer's email and password.It checks whether they are
	 * in system.If thet are registered in the system, It print their previous
	 * orders on the screen
	 * 
	 * @param temp1 String Customer email
	 * @param temp2 String Customer password
	 * @throws MyException error message
	 */
	public void informationCustomer(String temp1, String temp2) throws MyException {
		boolean check = false, check2 = false;
		try {
			for (int i = 0; i < customerNumber; i++) {
				if (customerMyArray != null && customerMyArray[i].getEmail().matches(temp1)
						&& customerMyArray[i].getPassword().matches(temp2)) {
					check2 = true;
					for (int j = 0; j < customerMyArray[i].getOrdersNumber(); j++) {
						if (customerMyArray[i].orders[j] != null) {
							System.out.println(customerMyArray[i].orders[j].toString());
							check = true;
						}

					}
				}

			}
			if (check2 == false) {
				throw new MyException("Error: Wrong Customer information");
			}
			if (check == false) {
				throw new MyException("THE CUSTOMER HAS NO OLD ORDERS");
			}
		} catch (MyException e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * This method branch employee allows to sell Querying whether the user is
	 * registered in the system If it is registered in the system, it directs it to
	 * the sales function. If it is not registered in the system,it registers and
	 * directs it to menu.
	 * 
	 * @throws MyException error message
	 */
	public void employeeSell() throws MyException {
		scan = new Scanner(System.in);
		String temp, temp1, temp2;
		registeredCustomer();
		System.out.println("\nWELCOME TO THE AUTOMATIC SALES SYSTEM");
		System.out.println("Are you registered in system?(Y(yes) or N(no)");
		temp = scan.next();
		if (temp.matches("Y") || temp.matches("y")) {
			System.out.println("What is your email?");
			temp1 = scan.next();
			System.out.println("What is your password?");
			temp2 = scan.next();
			if (customerValidate(temp1, temp2)) {
				customerSell();
			} else {
				System.out.println("NOT MEMBER IN THE SYSTEM");
				customerRegister();
				System.out.println("");
				return;
			}

		} else if (temp.matches("N") || temp.matches("n")) {
			customerRegister();
		}
	}

	/**
	 * Getter for Company adminCapacity
	 * 
	 * @return adminCapacity Company class admin array Capacity
	 */
	public int getAdminCapacity() {
		return adminCapacity;
	}

	/**
	 * Setter of Company adminCapacity
	 * 
	 * @param adminCapacity Company class admin array Capacity
	 */
	public void setAdminCapacity(int adminCapacity) {
		this.adminCapacity = adminCapacity;
	}

	/**
	 * Getter for Company adminNumber
	 * 
	 * @return adminNumber Company class admin number
	 */
	public int getAdminNumber() {
		return adminNumber;
	}

	/**
	 * Setter of Company adminNumber
	 * 
	 * @param adminNumber Company class admin number
	 */
	public void setAdminNumber(int adminNumber) {
		this.adminNumber = adminNumber;
	}

	/**
	 * Getter for Company branchCapacity
	 * 
	 * @return branchCapacity Company class Branch array Capacity
	 */
	public int getBranchCapacity() {
		return branchCapacity;
	}

	/**
	 * Setter of Company branchCapacity
	 * 
	 * @param branchCapacity Company class Branch array Capacity
	 */
	public void setBranchCapacity(int branchCapacity) {
		this.branchCapacity = branchCapacity;
	}

	/**
	 * Getter for branchNumber
	 * 
	 * @return branchNumber Company class Branch number
	 */
	public int getBranchNumber() {
		return branchNumber;
	}

	/**
	 * Setter of Company branchNumber
	 * 
	 * @param branchNumber Company class Branch number
	 */
	public void setBranchNumber(int branchNumber) {
		this.branchNumber = branchNumber;
	}

	/**
	 * Getter for Company customerNumber
	 * 
	 * @return customerNumber Company class Customer number
	 */
	public int getCustomerNumber() {
		return customerNumber;
	}

	/**
	 * Setter of Company customerNumber
	 * 
	 * @param customerNumber Company class Branch number
	 */
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	/**
	 * Getter for Company customerCapacity
	 * 
	 * @return customerCapacity Company class Customer array Capacity
	 */
	public int getCustomerCapacity() {
		return customerCapacity;
	}

	/**
	 * Setter of Company customerCapacity
	 * 
	 * @param customerCapacity Company class Customer array Capacity
	 */
	public void setCustomerCapacity(int customerCapacity) {
		this.customerCapacity = customerCapacity;
	}
}
