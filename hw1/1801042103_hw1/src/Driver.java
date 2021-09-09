/**
 * @author 1801042103
 * This class is the main class of CompanySystem.
 * It allows the user to use the system with the selections of the user through the menus.
 */
//package CompanySystem;

import java.util.Scanner;

public class Driver {

	private static Scanner scan;

	/**
	 * This method provide create default Admin
	 * 
	 * @return Administrator Administrator object
	 */
	public static Administrator createDefaultAdmin() {
		Administrator adminstrator = new Administrator();
		adminstrator.setName("admin");
		adminstrator.setSurName("admin");
		adminstrator.setPassword("admin");
		return adminstrator;
	}

	public static void main(String args[]) throws MyException {
		// In the main menu, all of the methods in the system are scripted to be tested.
		// Method is not defined in the driver class. There is only method to create
		// default admin. The driver class calls the methods over the objects of other
		// classes in the system. A menu structure that the user can easily use has been
		// defined.
		String temp, temp1, temp2, aName, aPass, aSurname, branch, eName, eSurname, ePass, cEmail = null, cPass = null,
				checkCus = null, menuChoice = "";
		;// for user input
		boolean c = false, c1 = false, exit = false, exitMenu, c2 = false;// for check
		OfficeProducts searchProduct;
		BranchEmployee tempEmp;
		Company company = new Company();
		Menus menu = new Menus();
		company.addAdmin(createDefaultAdmin());// default admin adding
		scan = new Scanner(System.in);// scan obje

		do {// Main menu loop
			menu.mainMenu();
			System.out.print("Enter input: ");
			menuChoice = scan.next();
			switch (menuChoice) {
			case "1":// Administrator menu loop
				System.out.println("****WELCOME ADMIN LOGIN SCREEN ");
				for (int i = 0; i < company.getAdminNumber(); i++) {
					System.out.println("Hint: Admin's Name :" + company.adminstratorMyArray[i].getName()
							+ ", Admin's Surname= " + company.adminstratorMyArray[i].getSurName()
							+ ", Admin's Password= " + company.adminstratorMyArray[i].getPassword());
				}
				System.out.print("Admin name: ");
				aName = scan.next();
				System.out.print("Admin surname: ");
				aSurname = scan.next();
				System.out.print("Admin password: ");
				aPass = scan.next();
				Administrator enterAdmin = new Administrator(aName, aSurname, aPass);
				exitMenu = false;
				do {
					if (company.adminValidate(enterAdmin)) {
						menu.administratorMenu();
						System.out.print("Enter input: ");
						menuChoice = scan.next();
						switch (menuChoice) {
						case "1":// adding branch
							company.addBranch();
							break;
						case "2":// remove branch
							company.removeBranch();
							break;
						case "3":// adding branch employee
							company.branchList();
							company.addBranchEmployee();
							break;
						case "4":// remove branch employee
							company.branchList();
							System.out.print(" Choice Branch's name: ");
							branch = scan.next();
							company.removeBranchEmployee(branch);
							break;
						case "5":// stock list
								company.branchList();
								System.out.print("Choice Branch's name: ");
								branch = scan.next();
								for (int i = 0; i < company.getBranchNumber(); i++) {
									if (company.branchMyArray[i].getName().matches(branch)) {
										try {
											company.branchStockList(company.branchMyArray[i]);
											c2=true;
										} catch (MyException e) {
											e.printStackTrace();
										}
									}
								}
								if(c2==false) {
									System.out.println("Branch is not found ");
								}
							break;
						case "0":// return main menu
							exitMenu = true;
							break;
						default:
							System.out.println("\nError: You entered an invalid input!\n");
							break;
						}
					} else {
						System.out.println("\nError:Not Login Because Wrong Information\n");
						exitMenu = true;
					}
				} while (!exitMenu);

				break;
			case "2":// branch employee Menu
				company.branchList();
				System.out.print(" Choice Branch's name: ");
				branch = scan.next();
				c = company.branchEmployeeList(branch);
				if (c == true) {
					System.out.println("****WELCOME BRANCH EMPLOYEE LOGIN SCREEN**** ");
					System.out.print("Employee's name: ");
					eName = scan.next();
					System.out.print("Employee's surname: ");
					eSurname = scan.next();
					System.out.print("Employee's password: ");
					ePass = scan.next();
					tempEmp = new BranchEmployee(eName, eSurname, ePass);
				} else {
					break;
				}
				exitMenu = false;
				do {
					if (company.branchEmployeeValidate(tempEmp, branch)) {// branch employee validate
						menu.branchEmployeeMenu();
						System.out.print("Enter input: ");
						menuChoice = scan.next();
						switch (menuChoice) {
						case "1":
							company.branchStockList(company.onlineBranch());
							break;
						case "2"://
							company.registeredCustomer();
							System.out.println("What is your email?");
							cEmail = scan.next();
							System.out.println("What is your password?");
							cPass = scan.next();
							company.informationCustomer(cEmail, cPass);
							break;
						case "3":// sell
							company.employeeSell();
							break;
						case "4":// add product
							company.addProductBranch();
							break;
						case "5":// remove product
							company.removeProductBranch();
							break;
						case "0":// return main menu
							exitMenu = true;
							break;
						default:
							System.out.println("\nError: You entered an invalid input!\n");
							break;
						}

					} else {
						System.out.println("\nError:Not Login Because Wrong Information\n");
						exitMenu = true;
					}
				} while (!exitMenu);
				break;

			case "3":// Customer
				company.registeredCustomer();
				System.out.println("\n****WELCOME CUSTOMER LOGIN SCREEN****");
				System.out.println("Are you registered in system?(Y(yes) or N(no)");
				checkCus = scan.next();
				if (checkCus.matches("Y") || checkCus.matches("y")) {
					System.out.println("What is your email?");
					cEmail = scan.next();
					System.out.println("What is your password?");
					cPass = scan.next();
					if (company.customerValidate(cEmail, cPass)) {

					} else {
						System.out.println("NOT MEMBER IN THE SYSTEM");
						company.customerRegister();
						System.out.println("");
						break;
					}

				} else if (checkCus.matches("N") || checkCus.matches("n")) {
					company.customerRegister();
					break;
				} else {
					System.out.println("Invalid choice");
					break;
				}
				exitMenu = false;
				do {
					menu.customerMenu();
					System.out.print("Enter input: ");
					menuChoice = scan.next();
					switch (menuChoice) {
					case "1": // search product
						System.out.println("Branch List");
						company.branchList();
						System.out.print(" Choice Branch's name: ");
						branch = scan.next();
						for (int i = 0; i < company.getBranchNumber(); i++) {
							if (company.branchMyArray[i].getName().matches(branch)) {
								company.setOnlineBranch(company.branchMyArray[i]);
								c1 = true;
							}
						}
						if (c1 == true) {
							searchProduct = new OfficeProducts();
							searchProduct = company.interfaceProducts();
							if (company.checkProductBranch(searchProduct)) {
								System.out.println("We have the product");
								System.out.println(searchProduct.toString());

							} else {
								System.out.println("Unfortunately, the product you are looking for is out of our "
										+ company.onlineBranch().getName() + " branch.");
							}
						} else {
							System.out.print("Invalid Branch name");
							break;
						}
						break;

					case "2": // product List
						do {
							company.branchList();
							System.out.print(" Choice Branch's name: ");
							branch = scan.next();
							for (int i = 0; i < company.getBranchNumber(); i++) {
								if (company.branchMyArray[i].getName().matches(branch)) {
									try {
										company.branchStockList(company.branchMyArray[i]);

									} catch (MyException e) {
										e.printStackTrace();
									}
								}
							}
						} while (exitMenu);
						break;
					case "3": // Purchase
						company.branchList();
						System.out.print(" Choice Branch's name: ");
						branch = scan.next();
						for (int i = 0; i < company.getBranchNumber(); i++) {
							if (company.branchMyArray[i].getName().matches(branch)) {
								company.setOnlineBranch(company.branchMyArray[i]);
								c1 = true;
							}
						}
						if (c1 == true) {
							company.customerSell();
						} else {
							System.out.print("Invalid Branch name");
							break;
						}
						break;
					case "4":// Information of the previous orders
						company.informationCustomer(cEmail, cPass);
						break;
					case "0": // return main menu
						exitMenu = true;
						break;
					default:
						System.out.println("\nError:You entered an invalid input!\n");
						break;
					}
				} while (!exitMenu);
				break;
			case "4":// adding admin
				System.out.print("Enter the new admin's name: ");
				temp = scan.next();
				System.out.print("Enter the new admin's surname: ");
				temp1 = scan.next();
				System.out.print("Enter the new admin's password: ");
				temp2 = scan.next();
				Administrator newAdmin = new Administrator(temp, temp1, temp2);
				company.addAdmin(newAdmin);
				break;
			case "0":// exit system
				System.out.println("System Terminated!!");
				exit = true;
				break;
			default:
				System.out.println("\nError: You entered an invalid input!\n");
				break;
			}

		} while (!exit);

	}
}
