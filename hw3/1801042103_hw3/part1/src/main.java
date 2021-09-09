/**
 * @author ozan.geckin
 * This class is the main class of CompanySystem.
 * It allows test Company System.
 */
//package hw3;

public class main {
	/**
	 * I organized my driver class to meet the methods I use and the conditions in
	 * the assignment paper.
	 * 
	 * @param company Company
	 */
	public static void driver(Company company) {
		System.out.println("\nKWArrayList Check\n");
		KWArrayList<User> user = new KWArrayList<User>();
		Administrator testAdmin = new Administrator("TestAdmin", "TestAdmin");
		Customer testCustomer = new Customer("tCus", "tCus", "t123", "tcus@gmail.com", "2131", "Ankara");
		BranchEmployee testEmp = new BranchEmployee("tEmp", "tEmp");
		System.out.println("KWArrayList Adds method");
		user.add(testAdmin);
		user.add(testEmp);
		user.add(testCustomer, 1);

		for (int i = 0; i < user.getSize(); i++) {
			System.out.println("index: " + i + " Name: " + user.get(i).getName() + " Surname: "
					+ user.get(i).getSurname() + " User Status: " + user.get(i).getUserStatus());
		}
		System.out.println("\nindexOf check");
		System.out.println("index is testEmp" + user.indexOf(testEmp));
		System.out.println("\nKWArrayList Removes method");
		user.remove(testAdmin);
		user.remove(1);
		for (int i = 0; i < user.getSize(); i++) {
			System.out.println("index: " + i + " Name: " + user.get(i).getName() + " Surname: "
					+ user.get(i).getSurname() + " User Status: " + user.get(i).getUserStatus());
		}
		for (int i = 0; i < 100; i++) {
			System.out.print("*");
		}
		System.out.println("\nKWLinkedList Check");
		KWLinkedList<Branch> branch = new KWLinkedList<Branch>();

		Branch testBranch = new Branch("testBranch");
		Branch testBranch2 = new Branch("testBranch2");
		Branch testBranch3 = new Branch("testBranch3");
		Branch testBranch4 = new Branch("testBranch4");

		System.out.println("\nKWLinkedList Add methods");
		branch.addFirst(testBranch);
		branch.add(testBranch2);
		branch.addLast(testBranch4);
		branch.add(3, testBranch3);
		for (int i = 0; i < branch.getSize(); i++) {
			System.out.println("index: " + i + " Name: " + branch.get(i).getName());
		}
		System.out.println("\nKWLinkedList Remove Methods");
		branch.remove(2);
		branch.remove(testBranch);
		for (int i = 0; i < branch.getSize(); i++) {
			System.out.println("index: " + i + " Name: " + branch.get(i).getName());
		}
		for (int i = 0; i < 100; i++) {
			System.out.print("*");
		}
		System.out.println("\nHybirdList Check");
		HybridList<OfficeProduct> hybridList = new HybridList<OfficeProduct>();
		OfficeCabinet cabinet1 = new OfficeCabinet("model1", "black");
		OfficeChair chair1 = new OfficeChair("model1", "red");
		OfficeDesk desk1 = new OfficeDesk("model1", "blue");
		Bookcase bookcase = new Bookcase("model3", "black");
		MeetingTable table = new MeetingTable("model10", "green");
		MeetingTable table2 = new MeetingTable("model3", "blue");
		hybridList.addFirst(table);
		hybridList.addLast(chair1);
		hybridList.add(1, cabinet1);
		hybridList.addFirst(bookcase);
		hybridList.add(2, desk1);
		for (int i = 0; i < hybridList.getSize(); i++) {
			System.out.println("index: " + i + " " + hybridList.get(i).toString());
		}
		System.out.println("\nHybridList find methods");
		if (hybridList.find(table)) {
			System.out.println(table.toString() + " is contained in HybridList");
		}
		if (hybridList.find(table2)) {
			System.out.println(table2.toString() + " is contained in HybridList");
		} else {
			System.out.println(table2.toString() + " is not found");
		}
		System.out.println("\nHybridList Remove methods");
		hybridList.remove(1);
		hybridList.remove(table);
		for (int i = 0; i < hybridList.getSize(); i++) {
			System.out.println("index: " + i + " " + hybridList.get(i).toString());
		}
		System.out.println();
		if (hybridList.remove(table)) {
			System.out.println(table.toString() + " is remove in HybridList");
		} else {
			System.out.println(table.toString() + " is not remove because object is not find in HybridList");
		}
		for (int i = 0; i < 100; i++) {
			System.out.print("*");
		}
		System.out.println("\n**Default Company(Scenario test)**");
		System.out.println("**Company User List**");
		company.userList();
		System.out.println("**Company Branch List**");
		company.branchList();

		System.out.println("\n**Company add newAdmin,newBranch,newBranchEmployee**");
		Administrator newAdmin = new Administrator("admin", "admin");
		Branch newBranch = new Branch("Branch5");
		BranchEmployee newBranchEmployee = new BranchEmployee("Emp1", "emp1", "Branch5");
		BranchEmployee newBranchEmployee2 = new BranchEmployee("Emp1", "emp1",
				company.getBranchList().get(3).getName());
		company.getUserList().add(newAdmin);
		newAdmin.addBranchIndex(company, newBranch, 0);
		newAdmin.addBranchEmployee(company.getBranchList().get(1), newBranchEmployee2);
		newAdmin.addBranchEmployee(newBranch, newBranchEmployee);
		System.out.println("**Company User List**");
		company.userList();
		System.out.println("**Company Branch List**");
		company.branchList();

		System.out.println("\n**Company Remove branch,branchEmployee**");
		newAdmin.removeBranch(company, company.getBranchList().get(1));
		newAdmin.removeBranchEmployee(company.getBranchList().get(3), newBranchEmployee2);
		System.out.println("**Company User List**");
		company.userList();
		System.out.println("**Company Branch List**");
		company.branchList();

		System.out.println("\n**Company add Products**");
		newBranchEmployee.addProductHead(company, table);
		newBranchEmployee.addProductIndex(company, desk1, 1);
		newBranchEmployee.addProductTail(company, chair1);
		newBranchEmployee.addProductTail(company, cabinet1);
		newBranchEmployee.addProductHead(company, bookcase);
		int counter = 1;
		for (int i = 0; i < company.getBranchList().getSize(); i++) {
			for (int j = 0; j < company.getBranchList().get(i).getOfficeProductList().getSize(); j++) {
				System.out.println("Branch Name: " + company.getBranchList().get(i).getName() + " Stock: " + counter
						+ " : " + company.getBranchList().get(i).getOfficeProductList().get(j));
				counter++;
			}
		}

		System.out.println("\n**Company Remove Products**");
		newBranchEmployee.removeProduct(company, chair1);
		newBranchEmployee.removeProductIndex(company, 1);

		counter = 1;
		for (int i = 0; i < company.getBranchList().getSize(); i++) {
			for (int j = 0; j < company.getBranchList().get(i).getOfficeProductList().getSize(); j++) {
				System.out.println("Branch Name: " + company.getBranchList().get(i).getName() + " Stock: " + counter
						+ " : " + company.getBranchList().get(i).getOfficeProductList().get(j));
				counter++;
			}
		}

		System.out.println("\n**Customer Register and Sell Product**");
		Customer newCustomer = new Customer("customer2", "customer2", "123", "customer2@gmail.com", "05445649684",
				"Istanbul");
		newCustomer.customerRegister(company);
		System.out.println("\n**Customer orders list**");
		newCustomer.customerProductList();

		newCustomer.customerSell(company, table, "Branch5");
		newCustomer.customerSell(company, bookcase, "Branch5");
		System.out.println("\n**Customer orders list**");
		newCustomer.customerProductList();

		System.out.println("\n**Stock List**");
		counter = 1;
		for (int i = 0; i < company.getBranchList().getSize(); i++) {
			for (int j = 0; j < company.getBranchList().get(i).getOfficeProductList().getSize(); j++) {
				System.out.println("Branch Name: " + company.getBranchList().get(i).getName() + " Stock: " + counter
						+ " : " + company.getBranchList().get(i).getOfficeProductList().get(j));
				counter++;
			}
		}

	}

	public static void main(String[] args) {
		Company company = new Company();
		driver(company);//call driver method
	}

}
