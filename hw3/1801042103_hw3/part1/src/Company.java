/**
 * @author ozan.geckin
 * This class has details of Company class
 */
//package hw3;

public class Company {

	private KWLinkedList<Branch> branchList;
	private KWArrayList<User> userList;

	/**
	 * Default constructor Company class define an admin,a customer and four
	 * branches
	 */
	public Company() {
		userList = new KWArrayList<User>();
		userList.add(new Administrator("Ozan", "geckin"));
		userList.add(
				new Customer("customer", "customer", "123", "customer@gmail.com", "05445649684", "Uskdar/Istanbul"));
		branchList = new KWLinkedList<Branch>();
		branchList.add(new Branch("Branch1"));
		branchList.add(new Branch("Branch2"));
		branchList.add(new Branch("Branch3"));
		branchList.add(new Branch("Branch4"));
	}

	/**
	 * Prints the branch in the company system
	 */
	public void branchList() {
		System.out.println("Branches List: ");
		int counter = 1;
		for (int i = 0; i < branchList.getSize(); i++) {
			System.out.println(counter + " : " + branchList.get(i).getName());
			counter++;
		}
	}

	/**
	 * Prints the User in the company system
	 */
	public void userList() {
		System.out.println("User List: ");
		int counter = 1;
		for (int i = 0; i < userList.getSize(); i++) {
			System.out.println(counter + " - " + "Name: " + userList.get(i).getName() + ", Surname: "
					+ userList.get(i).getSurname() + ", User status: " + userList.get(i).getUserStatus());
		}
		for (int i = 0; i < branchList.getSize(); i++) {
			for (int j = 0; j < branchList.get(i).getBranchEmployeeList().getSize(); j++) {
				System.out
						.println(counter + " - " + "Name: " + branchList.get(i).getBranchEmployeeList().get(j).getName()
								+ ", Surname: " + branchList.get(i).getBranchEmployeeList().get(j).getSurname()
								+ ", User Status: " + branchList.get(i).getBranchEmployeeList().get(j).getUserStatus()
								+ "Branch Name: " + branchList.get(i).getName());
			}
		}
	}

	/**
	 * Getter for branchList in company system
	 * 
	 * @return branchList branchList(KWLinkedList) of Company
	 */
	public KWLinkedList<Branch> getBranchList() {
		return branchList;
	}

	/**
	 * Setter of branchList in company system
	 * 
	 * @param branchList branchList(KWLinkedList) of Company
	 */
	public void setBranchList(KWLinkedList<Branch> branchList) {
		this.branchList = branchList;
	}

	/**
	 * Getter for userList in company system
	 * 
	 * @return userList userList(KWArrayList) of Company
	 */
	public KWArrayList<User> getUserList() {
		return userList;
	}

	/**
	 * Setter of userList in company system
	 * 
	 * @param userList userList(KWArrayList) of Company
	 */
	public void setUserList(KWArrayList<User> userList) {
		this.userList = userList;
	}

}
