/**
 * @author 1801042103
 * This class has menu method.
 */
//package CompanySystem;

public class Menus {
	/**
	 * Default Constructor
	 */
	public Menus() {

	}

	/**
	 * This method has mainMenu context
	 */
	public void mainMenu() {
		System.out.println("****WELCOME COMPANY SYSYEM****");
		System.out.println("        ***USER TYPE***");
		System.out.println("1 - Administrator ");
		System.out.println("2 - Branch Employee");
		System.out.println("3 - Customer");
		System.out.println("4 - Add an Admin");
		System.out.println("0 - Exit");
	}

	/**
	 * This method has administratorMenu context
	 */
	public void administratorMenu() {
		System.out.println("\n****WELCOME ADMINISTRATOR MENU****");
		System.out.println("     ***SELECT THE OPERATION***");
		System.out.println("1 - Add a Branch");
		System.out.println("2 - Remove a Branch");
		System.out.println("3 - Add a Branch Employee");
		System.out.println("4 - Remove a Branch Employee");
		System.out.println("5 - Stock List");
		System.out.println("0 - Return to Main Menu");
	}

	/**
	 * This method has branchEmployeeMenu context
	 */

	public void branchEmployeeMenu() {
		System.out.println("\n****WELCOME BRANCH EMPLOYEE MENU****");
		System.out.println("     ***SELECT THE OPERATION***");
		System.out.println("1 - Stock List");
		System.out.println("2 - Information of the previous orders of a customer");
		System.out.println("3 - Sell");
		System.out.println("4 - Add Product");
		System.out.println("5 - Remove Product");
		System.out.println("0 - Return to Main Menu");
	}

	/**
	 * This method has customerMenu context
	 */

	public void customerMenu() {
		System.out.println("\n****WELCOME COSTUMER MENU****");
		System.out.println(" ***SELECT THE OPERATION***");
		System.out.println("1 - Search Product");
		System.out.println("2 - Product List");
		System.out.println("3 - Purchase");
		System.out.println("4 - Information of the previous orders");
		System.out.println("0 - Return To Main Menu");
	}
}
