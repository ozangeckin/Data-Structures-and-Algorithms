/**
 * @author 1801042103
 * This class has the details of branch and has the employee and office product arrays
 */
//package CompanySystem;

public class Branch {

	public BranchEmployee[] employees;
	public OfficeProducts[] stocks;
	private String name;
	// stockCapacity is default stock number
	// employeeNumber is default employee number
	private int stockCapacity, stockNumber, employeeCapacity, employeeNumber;

	/**
	 * Default constructor of the Branch Class
	 */
	public Branch() {
	}

	/**
	 * sets the employee and office product classes sizes to 2 sets the employee and
	 * office product classes sizes to 21 because there are 21 objects in arrays yet.
	 * stockCapacity and stockNumber set 21
	 * employeeCapacity and employeeNumber set 2
	 * @param name name of the branch
	 */
	public Branch(String name) {
		this.name = name;
		employees = new BranchEmployee[2];
		employees[0] = new BranchEmployee("emp1", "emp1", "emp1");
		employees[1] = new BranchEmployee("emp2", "emp2", "emp2");
		stocks = new OfficeProducts[21];
		stockCapacity = 21;
		stockNumber = 21;
		employeeCapacity = 2;
		employeeNumber = 2;
		OfficeChair chair1 = new OfficeChair("model1", "red");
		OfficeChair chair2 = new OfficeChair("model2", "red");
		OfficeChair chair3 = new OfficeChair("model3", "red");
		OfficeChair chair4 = new OfficeChair("model4", "red");
		OfficeChair chair5 = new OfficeChair("model5", "red");
		OfficeChair chair6 = new OfficeChair("model6", "red");
		OfficeChair chair7 = new OfficeChair("model7", "red");
		OfficeChair chair8 = new OfficeChair("model1", "blue");
		OfficeChair chair9 = new OfficeChair("model2", "blue");
		OfficeChair chair10 = new OfficeChair("model3", "blue");
		OfficeChair chair11 = new OfficeChair("model4", "blue");
		OfficeChair chair12 = new OfficeChair("model5", "blue");
		OfficeChair chair13 = new OfficeChair("model6", "blue");
		OfficeChair chair14 = new OfficeChair("model7", "blue");
		OfficeChair chair15 = new OfficeChair("model1", "green");
		OfficeChair chair16 = new OfficeChair("model2", "green");
		OfficeChair chair17 = new OfficeChair("model3", "green");
		OfficeChair chair18 = new OfficeChair("model4", "green");
		OfficeChair chair19 = new OfficeChair("model5", "green");
		OfficeChair chair20 = new OfficeChair("model6", "green");
		OfficeChair chair21 = new OfficeChair("model7", "green");
		
		stocks[0] = chair1;
		stocks[1] = chair2;
		stocks[2] = chair3;
		stocks[3] = chair4;
		stocks[4] = chair5;
		stocks[5] = chair6;
		stocks[6] = chair7;
		stocks[7] = chair8;
		stocks[8] = chair9;
		stocks[9] = chair10;
		stocks[10] = chair11;
		stocks[11] = chair12;
		stocks[12] = chair13;
		stocks[13] = chair14;
		stocks[14] = chair15;
		stocks[15] = chair16;
		stocks[16] = chair17;
		stocks[17] = chair18;
		stocks[18] = chair19;
		stocks[19] = chair20;
		stocks[20] = chair21;


	}

	/**
	 * Copy constructor When increasing a Branch object array, there need to be a
	 * copy constructor to move the current array to temporary array.
	 * 
	 * @param otherBranch Branch object
	 */
	public Branch(Branch otherBranch) {
		this.name = otherBranch.name;
		stockCapacity = otherBranch.stockCapacity;
		stockNumber = otherBranch.stockNumber;
		employeeCapacity = otherBranch.employeeCapacity;
		employeeNumber = otherBranch.employeeNumber;
		stocks = new OfficeProducts[otherBranch.stockCapacity];
		employees = new BranchEmployee[otherBranch.employeeCapacity];

		// copies the otherBranch elements to current objects elements
		// If admin adds an employee and erases the object later, the place in the array
		// becomes null,to avoid checking a null place , i used if(!=null) statements.
		for (int i = 0; i < employeeNumber; i++) {
			if (otherBranch.employees[i] != null) {
				employees[i] = new BranchEmployee(otherBranch.employees[i].getName(),
						otherBranch.employees[i].getSurName(), otherBranch.employees[i].getPassword());
			}
		}
		for (int i = 0; i < stockNumber; i++) {
			if (otherBranch.stocks[i] != null) {
				stocks[i] = new OfficeProducts(otherBranch.stocks[i].getModel(), otherBranch.stocks[i].getColor(),
						otherBranch.stocks[i].getName());
			}
		}
	}

	/**
	 * Prints the employees working in this branch
	 */
	public void printEmployees() {
		for (int i = 0; i < employeeNumber; i++) {
			if (employees[i] != null) {
				System.out.println(employees[i].toString());
			}
		}
	}

	/**
	 * Prints the office products in this branch
	 */
	public void printStock() {
		System.out.println("Stock List:");
		for (int i = 0; i < stockCapacity; i++) {
			if (stocks[i] != null) {
				System.out.println(stocks[i].toString());
			}
		}
	}

	/**
	 * Increases the maximum capacity of the stocks array. Holds the current
	 * information in a temporary array and creates a new stocks array by twice the
	 * current capacity. Gets the old information from temporary array.
	 */
	public void increaseStokcsCapacity() {
		OfficeProducts[] temp = new OfficeProducts[stockCapacity];

		for (int i = 0; i < stockNumber; i++) {
			if (stocks[i] != null) {
				temp[i] = new OfficeProducts(stocks[i].getModel(), stocks[i].getColor(), stocks[i].getName());
			}
		}
		stocks = new OfficeProducts[stockCapacity * 2];
		for (int i = 0; i < stockNumber; i++) {
			if (temp[i] != null) {
				stocks[i] = new OfficeProducts(temp[i].getModel(), temp[i].getColor(), temp[i].getName());
			}
		}

		stockCapacity *= 2;

	}

	/**
	 * Increases the Maximum capacity of the employees array. Holds the current
	 * information in a temporary array and creates a new employees array by twice
	 * the current capacity. Gets the old information from temporary array.
	 */
	public void increaseEmployeeCapactiy() {
		BranchEmployee[] temp = new BranchEmployee[employeeCapacity];

		// Sends the current elements to a temp array
		for (int i = 0; i < employeeNumber; i++) {
			if (employees[i] != null) {
				temp[i] = new BranchEmployee(employees[i].getName(), employees[i].getSurName(),
						employees[i].getPassword());
			}
		}
		// Creates a new array by twice the capacity and gets the old infos from the
		// temp array
		employees = new BranchEmployee[employeeCapacity * 2];
		for (int i = 0; i < employeeNumber; i++) {
			if (temp[i] != null) {
				employees[i] = new BranchEmployee(temp[i].getName(), temp[i].getSurName(), temp[i].getPassword());
			}
		}
		employeeCapacity *= 2;
	}
	
	/**
	 * Getter of Branch stokCapacity
	 * @return stockCapacity stockCapacity of Branch class
	 */
	public int getStockCapacity() {
		return stockCapacity;
	}

	/**
	 * Setter of Branch stockCapacity
	 * @param stockCapacity stockCapacity of Branch class
	 */
	public void setStockCapacity(int stockCapacity) {
		this.stockCapacity = stockCapacity;
	}
	
	/**
	 * Getter of Branch employeeNumber
	 * @return employeeNumber  employeeNumber of Branch class
	 */
	public int getEmployeeNumber() {
		return employeeNumber;
	}
	
	/**
	 * Setter of Branch employeeNumber
	 * @param employeeNumber employeeNumber of Branch class
	 */
	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	
	/**
	 * Getter of Branch name
	 * @return name name of Branch class
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Setter of Branch name
	 * @param name name of Branch class
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Getter of Branch stockNumber
	 * @return stockNumber stockNumber of Branch class
	 */
	public int getStockNumber() {
		return stockNumber;
	}

	/**
	 * Setter of Branch stockNumber
	 * @param stockNumber stockNumber of Branch class
	 */
	public void setStockNumber(int stockNumber) {
		this.stockNumber = stockNumber;
	}

	/**
	 * Getter of Branch employeeCapacity
	 * @return employeeCapacity employeeCapacity of Branch class
	 */
	public int getEmployeeCapacity() {
		return employeeCapacity;
	}
	
	/**
	 * Setter of Branch employeeCapacity
	 * @param employeeCapacity employeeCapacity of Branch class
	 */
	public void setEmployeeCapacity(int employeeCapacity) {
		this.employeeCapacity = employeeCapacity;
	}

}
