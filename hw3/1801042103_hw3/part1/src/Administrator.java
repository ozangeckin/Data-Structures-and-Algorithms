/**
 * 
 * @author ozan.geckin
 * This class has all the details of Administrators extends User of Company
 */
//package hw3;

public class Administrator extends User {

	/**
	 * Default constructor of Administrator class call constructor of Abstract User
	 * class
	 */
	public Administrator() {
		super();
	}

	/**
	 * Constructor of Administrator class with two parameters name,surname class
	 * call constructor of Abstract User
	 * 
	 * @param newName    newName of Administrator
	 * @param newSurName newSurName of Administrator
	 */
	public Administrator(String newName, String newSurName) {
		super(newName, newSurName, "Admin");
	}

	/**
	 * This methods allows me to add Branch to the company system.
	 * 
	 * @param company Company
	 * @param branch  Branch
	 */
	public void addBranch(Company company, Branch branch) {
		company.getBranchList().add(branch);
	}

	/**
	 * This methods allows to add Branch a certain index to the company system.
	 * 
	 * @param company Company
	 * @param branch  Branch
	 * @param index   int
	 */
	public void addBranchIndex(Company company, Branch branch, int index) {
		company.getBranchList().add(index, branch);
	}

	/**
	 * This methods remove Branch to the company system.
	 * 
	 * @param company Company
	 * @param branch  Branch
	 */
	public void removeBranch(Company company, Branch branch) {
		company.getBranchList().remove(branch);
	}

	/**
	 * This methods add BranchEmployee to the company system.
	 * 
	 * @param branch         Branch
	 * @param branchEmployee BranchEmployee
	 */
	public void addBranchEmployee(Branch branch, BranchEmployee branchEmployee) {
		branch.getBranchEmployeeList().add(branchEmployee);

	}

	/**
	 * This methods remove BranchEmployee to the company system.
	 * 
	 * @param branch         Branch
	 * @param branchEmployee BranchEmployee
	 */
	public void removeBranchEmployee(Branch branch, BranchEmployee branchEmployee) {
		branch.getBranchEmployeeList().remove(branchEmployee);
	}

	/**
	 * This method add new Admin to the company system.
	 * 
	 * @param company  Company
	 * @param newAdmin Administrator
	 */
	public void addAdmin(Company company, Administrator newAdmin) {
		company.getUserList().add(newAdmin);
	}

}
