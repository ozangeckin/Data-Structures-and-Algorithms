/**
 * @author ozan.geckin
 * This class has all the details of BranchEmployee extends User of company
 */
//package hw3;

public class BranchEmployee extends User implements StockChecker {

	private String branchName;

	/**
	 * Default Constructor of BranchEmployee
	 */
	public BranchEmployee() {
		super("", "", "Branch Employee", "");
		this.branchName = "";
	}

	/**
	 * Constructor of BranchEmployee class with two parameters name, surname class
	 * call constructor of Abstarct User
	 * 
	 * @param name    name of BranchEmployee name
	 * @param surname surname of BranchEmployee surname
	 */
	public BranchEmployee(String name, String surname) {
		super(name, surname, "Branch Employee", "");
		this.branchName = "";
	}

	/**
	 * Constructor of BranchEmployee class with three parameters
	 * name,surname,branchName class call constructor of Abstract User
	 * 
	 * @param name       name of BranchEmployee name
	 * @param surname    surname of BranchEmployee surname
	 * @param branchName branchName of BranchEmployee branchEmployee
	 */
	public BranchEmployee(String name, String surname, String branchName) {
		super(name, surname, "BranchEmployee", "");
		this.branchName = branchName;
	}

	/**
	 * Copy constructor for assign two BranchEmployee obje
	 * 
	 * @param otherObj BranchEmployee
	 */
	public BranchEmployee(BranchEmployee otherObj) {
		setName(otherObj.getName());
		setSurname(otherObj.getSurname());
		setPassword(otherObj.getPassword());
		setUserStatus(otherObj.getUserStatus());
	}

	/**
	 * This method allow add product head in the company system
	 * 
	 * @param company    Company
	 * @param newProduct OfficeProduct
	 */
	public void addProductHead(Company company, OfficeProduct newProduct) {
		for (int i = 0; i < company.getBranchList().getSize(); i++) {
			if (company.getBranchList().get(i).getName().equals(branchName)) {
				company.getBranchList().get(i).getOfficeProductList().addFirst(newProduct);

			}
		}
	}

	/**
	 * This method allow add product index in the company system
	 * 
	 * @param company    Company
	 * @param newProduct OfficeProduct
	 * @param index      int
	 */

	public void addProductIndex(Company company, OfficeProduct newProduct, int index) {
		for (int i = 0; i < company.getBranchList().getSize(); i++) {
			if (company.getBranchList().get(i).getName().equals(branchName)) {
				company.getBranchList().get(i).getOfficeProductList().add(index, newProduct);

			}
		}

	}

	/**
	 * This method allow add product tail in the company system
	 * 
	 * @param company    Company
	 * @param newProduct OfficeProduct
	 */
	public void addProductTail(Company company, OfficeProduct newProduct) {
		for (int i = 0; i < company.getBranchList().getSize(); i++) {
			if (company.getBranchList().get(i).getName().equals(branchName)) {
				company.getBranchList().get(i).getOfficeProductList().addLast(newProduct);

			}
		}
	}

	/**
	 * This method allow remove product in the company system
	 * 
	 * @param company    Company
	 * @param newProduct OfficeProduct
	 */
	public void removeProduct(Company company, OfficeProduct newProduct) {
		for (int i = 0; i < company.getBranchList().getSize(); i++) {
			if (company.getBranchList().get(i).getName().equals(branchName)) {
				company.getBranchList().get(i).getOfficeProductList().remove(newProduct);
			}
		}
	}

	/**
	 * This method allow remove product where index in the company system
	 * @param company Company
	 * @param index int
	 */
	public void removeProductIndex(Company company, int index) {
		for (int i = 0; i < company.getBranchList().getSize(); i++) {
			if (company.getBranchList().get(i).getName().equals(branchName)) {
				company.getBranchList().get(i).getOfficeProductList().remove(index);
			}
		}
	}
	/**
	 * This method allow print BranchEmployee
	 */
	@Override
	public String toString() {
		return String.format("Employee name: " + getName() + " " + ",Employee surname: " + getSurname());
	}

}
