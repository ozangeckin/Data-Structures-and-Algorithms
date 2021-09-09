/**
 * @author ozan.geckin
 * This class has details of branch and has the employee(KWArrayList) and office product(HybridList)
 */
//package hw3;

public class Branch {

	private KWArrayList<BranchEmployee> branchEmployeeList;
	private HybridList<OfficeProduct> officeProductList;
	private String name;

	/**
	 * Default constructor of the Branch Class
	 */
	public Branch() {
		branchEmployeeList = new KWArrayList<BranchEmployee>();
		officeProductList = new HybridList<OfficeProduct>();
	}

	/**
	 * Constructor of Branch one parameter name.
	 * 
	 * @param branchName name of Branch
	 */
	public Branch(String branchName) {
		branchEmployeeList = new KWArrayList<BranchEmployee>();
		officeProductList = new HybridList<OfficeProduct>();
		name = branchName;
	}

	/**
	 * This method Copy Constructor for assign two Branch obje.
	 * 
	 * @param otherBranch Branch
	 */
	public Branch(Branch otherBranch) {
		this.name = otherBranch.name;
		this.branchEmployeeList.cloneList(otherBranch.getBranchEmployeeList());
		for (int i = 0; i < otherBranch.getOfficeProductList().getSize(); i++) {
			officeProductList.add(i, officeProductList.get(i));
		}
	}

	/**
	 * This method list officeProduct(HybridList) call OfficeProduct toString()
	 */
	public void branchOrderlist() {
		for (int i = 0; i < officeProductList.getSize(); i++) {
			System.out.println(officeProductList.get(i).toString());
		}
	}

	/**
	 * Getter for Branch BranchEmployeeList
	 * 
	 * @return branchEmployeeList branchEmployeeList(KWArrayList) of Branch
	 */
	public KWArrayList<BranchEmployee> getBranchEmployeeList() {
		return branchEmployeeList;
	}

	/**
	 * Setter of Branch BranchEmployeeList
	 * 
	 * @param branchEmployeeList branchEmployeeList(KWArrayList) of Branch
	 */
	public void setBranchEmployeeList(KWArrayList<BranchEmployee> branchEmployeeList) {
		this.branchEmployeeList.cloneList(branchEmployeeList);
	}

	/**
	 * Getter for Branch officeProductList
	 * 
	 * @return officeProductList officeProductList of Branch
	 */
	public HybridList<OfficeProduct> getOfficeProductList() {
		return officeProductList;
	}

	/**
	 * Setter of Branch officeProductList
	 * 
	 * @param officeProductList officeProductList of Branch
	 */
	public void setOfficeProductList(HybridList<OfficeProduct> officeProductList) {
		this.officeProductList = officeProductList;
	}

	/**
	 * Getter for Branch name
	 * 
	 * @return name name of Branch
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter of Branch name
	 * 
	 * @param name name of Branch
	 */
	public void setName(String name) {
		this.name = name;
	}

}
