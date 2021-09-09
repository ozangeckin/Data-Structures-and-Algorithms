import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * This class that contains the menu that the user can use in terms of
 * interactivity.
 * 
 * @author ozan.geckin
 *
 */
public class Driver {

	public static final Scanner input = new Scanner(System.in);

	/**
	 * You can see the results in txt files in folder data
	 */
	public static void test() {
		LinkedList<String> prodlink = new LinkedList<>();

		System.out.println("Testing Parser class");
		Parser parse = new Parser();
		parse.defaultUser();
		parse.parser();
		parse.defaultUserCreate();
		parse.defaultCatagory();
		System.out.println("Testing Trade class");
		Trader trader = new Trader(12345678, "Jack", "ozan", "trader");
		trader.addProduct(
				new Product("QWERTASXCD55", "slipper", "Shoes", 2131, 321, "Color blue", trader.getUserName()));
		trader.addProduct(
				new Product("XAERTASXCD55", "rugan", "Shoes", 2131, 321, "Color black", trader.getUserName()));
		trader.removeProduct("XAERTASXCD55", trader.getUserName());
		trader.editProduct("QWERTASXCD55",
				new Product("QWERTASXCD55", "slipper", "Shoes", 88888, 321, "Color Red", trader.getUserName()));
		prodlink = trader.listOrder(trader.getUserName());
		if (prodlink != null) {
			for (int i = 0; i < prodlink.size(); i++) {
				System.out.println(prodlink.get(i).toString());
			}
		}
		ArrayList<Product> prodName = new ArrayList<>();
		Customer customer = new Customer();
		prodName = customer.searchName("Alisha");
		System.out.println("Search product by Product Name and Product Description");
		for (int i = 0; i < prodName.size(); i++) {
			System.out.println(prodName.get(i).toString());
		}
		System.out.println("Search product by decreasing order of the product name");
		prodName = customer.sortNameDecreasing(prodName);
		for (int i = prodName.size() - 1; 0 < i; i--) {
			System.out.println(prodName.get(i).toString());
		}
		System.out.println("Search product by Trader name");
		prodName = customer.searchTrader("BigCompany");
		for (int i = 0; i < prodName.size(); i++) {
			System.out.println(prodName.get(i).toString());
		}
		System.out.println("Search product by Product prices (Upper-Down)");
		prodName = customer.searchName("Freelance Vacuum Bottles 350 ml Bottle");
		prodName = customer.sortPriceDown(prodName);
		for (int i = prodName.size() - 1; 0 < i; i--) {
			System.out.println(prodName.get(i).toString());
		}
		System.out.println("Search product by Product prices (Down-Upper)");
		prodName = customer.searchName("Freelance Vacuum Bottles 350 ml Bottle");
		prodName = customer.sortPriceDown(prodName);
		for (int i = 0; i < prodName.size(); i++) {
			System.out.println(prodName.get(i).toString());
		}
		System.out.println("Search product by Product prices (Upper-Down by Customer input))");
		prodName = customer.searchName("Freelance Vacuum Bottles 350 ml Bottle");
		prodName = customer.searchPriceLimit(prodName, 10000, 500);
		prodName = customer.sortPriceDown(prodName);
		for (int i = prodName.size() - 1; 0 < i; i--) {
			System.out.println(prodName.get(i).toString());
		}
		System.out.println("Search product by Product of the discount (Upper-Down by Customer input)");
		prodName = customer.searchName("Freelance Vacuum Bottles 350 ml Bottle");
		prodName = customer.searchDiscountLimit(prodName, 8000, 100);
		prodName = customer.sortProductDiscount(prodName);
		for (int i = prodName.size() - 1; 0 < i; i--) {
			System.out.println(prodName.get(i).toString());
		}
		System.out.println("Search product by Product category");
		prodName = customer.searchProductCategory("Clothing");
		for (int i = 0; i < prodName.size(); i++) {
			System.out.println(prodName.get(i).toString());
		}
		if (customer.order(
				new Product("QWERTASXCD55", "slipper", "Shoes", 88888, 321, "Color Red", trader.getUserName()),
				"ozan")) {
			trader.removeProduct("QWERTASXCD55", trader.getUserName());
			System.out.println("Success Order");
		} else {
			System.out.println("Not Success Order");
		}
		prodlink = trader.listOrder(trader.getUserName());
		if (prodlink != null) {
			for (int i = 0; i < prodlink.size(); i++) {
				System.out.println(prodlink.get(i).toString());
			}
		}
	}

	public static void main(String[] args) {
		test();
		Menu menu = new Menu();
		Parser parse = new Parser();
		parse.defaultUser();
		parse.parser();
		parse.defaultUserCreate();
		parse.defaultCatagory();
		User user = new User();
		ArrayList<Product> prodName = new ArrayList<>();
		LinkedList<String> prodlink = new LinkedList<>();
		Trader trader = new Trader();
		Customer customer = new Customer();
		String menuChoice = "", pass = "", prdctName = "", prdctCatalog = "", descrip = "", prdtId = "", cuName = "",
				cuPass = "", naPrdct = "", traderName = "", prdtId1 = "", descrip1 = "", traderName1 = "",
				prdctCatalog1 = "", prdctName1 = "";
		Integer pri = 0, disc = 0, upper = 0, down = 0, pri1 = 0, disc1 = 0;
		Integer useId;
		boolean exit = false, exitMenu = false;

		do {
			menu.userType();
			menuChoice = input.next();
			switch (menuChoice) {
			case "1":
				System.out.println("Welcome To Trader Login");
				System.out.println("Enter User Id : ");
				useId = input.nextInt();
				System.out.println("Enter User pass: ");
				pass = input.next();
				trader = (Trader) user.Login(useId, pass, "trader");
				if (trader != null) {
					do {
						menu.TraderMenu();
						menuChoice = input.next();
						switch (menuChoice) {
						case "1":
							System.out.println("\nAdd Product");
							System.out.println("Product Id: ");
							prdtId = input.next();
							System.out.println("Product Name: ");
							prdctName = input.next();
							System.out.println("Product Catalog: ");
							prdctCatalog = input.next();
							System.out.println("Product Price: ");
							pri = input.nextInt();
							System.out.println("Product Discounted Price: ");
							disc = input.nextInt();
							System.out.println("Product Description");
							descrip = input.next();
							trader.addProduct(new Product(prdtId, prdctName, prdctCatalog, pri, disc, descrip,
									trader.getUserName()));
							break;
						case "2":
							System.out.println("\nRemove Product");
							System.out.println("Product Id: ");
							prdtId = input.next();
							trader.removeProduct(prdtId, trader.getUserName());
							break;
						case "3":
							System.out.println("\nEdit Product");
							System.out.println("Product Id: ");
							prdtId = input.next();
							System.out.println("New Product Name: ");
							prdctName = input.next();
							System.out.println("New Product Catalog: ");
							prdctCatalog = input.next();
							System.out.println("New Product Price: ");
							pri = input.nextInt();
							System.out.println("New Product Discounted Price: ");
							disc = input.nextInt();
							System.out.println("New Product Description");
							descrip = input.next();
							trader.editProduct(prdtId, new Product(prdtId, prdctName, prdctCatalog, pri, disc, descrip,
									trader.getUserName()));
							break;
						case "4":
							System.out.println("\nList Order");
							prodlink = trader.listOrder(trader.getUserName());
							if (prodlink != null) {
								for (int i = 0; i < prodlink.size(); i++) {
									System.out.println(prodlink.get(i).toString());
								}
							}
							break;
						case "0":
							System.out.println("Return User Type Menu");
							exitMenu = true;
							break;
						}
					} while (!exitMenu);
				} else {
					break;
				}
				break;
			case "2":
				System.out.println("Welcome To Customer Login");
				System.out.println("Enter User Id : ");
				useId = input.nextInt();
				System.out.println("Enter User pass: ");
				pass = input.next();
				exitMenu = false;
				customer = (Customer) user.Login(useId, pass, "customer");

				if (customer != null) {
					do {
						menu.CustomerMenu();
						menuChoice = input.next();
						switch (menuChoice) {
						case "1":
							System.out.println("Search product by Product Name and Product Description");
							System.out.println("Enter Product Name: ");
							naPrdct = input.next();
							prodName = customer.searchName(naPrdct);
							for (int i = 0; i < prodName.size(); i++) {
								System.out.println(prodName.get(i).toString());
							}
							break;
						case "2":
							System.out.println("Search product by Trader name");
							System.out.println("Enter Trader Name: ");
							traderName = input.next();
							prodName = customer.searchTrader(traderName);
							for (int i = 0; i < prodName.size(); i++) {
								System.out.println(prodName.get(i).toString());
							}

							break;
						case "3":
							System.out.println("Search product by decreasing order of the product name");
							System.out.println("Enter Product Name: ");
							naPrdct = input.next();
							prodName = customer.searchName(naPrdct);
							prodName = customer.sortNameDecreasing(prodName);
							for (int i = prodName.size() - 1; 0 < i; i--) {
								System.out.println(prodName.get(i).toString());
							}

							break;
						case "4":
							System.out.println("Search product by Product prices (Upper-Down)");
							System.out.println("Enter Product Name: ");
							naPrdct = input.next();
							prodName = customer.searchName(naPrdct);
							prodName = customer.sortPriceDown(prodName);
							for (int i = prodName.size() - 1; 0 < i; i--) {
								System.out.println(prodName.get(i).toString());
							}

							break;
						case "5":
							System.out.println("Search product by Product prices (Down-Upper)");
							System.out.println("Enter Product Name: ");
							naPrdct = input.next();
							prodName = customer.searchName(naPrdct);
							prodName = customer.sortPriceDown(prodName);
							for (int i = 0; i < prodName.size(); i++) {
								System.out.println(prodName.get(i).toString());
							}
							break;
						case "6":
							System.out.println("Search product by Product prices (Upper-Down by Customer input))");
							System.out.println("Enter Product Name: ");
							naPrdct = input.next();
							prodName = customer.searchName(naPrdct);
							System.out.println("Enter Product Upper Limit: ");
							upper = input.nextInt();
							System.out.println("Enter Product Down Limit: ");
							down = input.nextInt();
							prodName = customer.searchPriceLimit(prodName, upper, down);
							prodName = customer.sortPriceDown(prodName);
							for (int i = prodName.size() - 1; 0 < i; i--) {
								System.out.println(prodName.get(i).toString());
							}
							break;
						case "7":
							System.out.println(
									"Search product by Product of the discount (Upper-Down by Customer input)");
							System.out.println("Enter Product Name: ");
							naPrdct = input.next();
							prodName = customer.searchName(naPrdct);
							System.out.println("Enter Product Upper Limit: ");
							upper = input.nextInt();
							System.out.println("Enter Product Down Limit: ");
							down = input.nextInt();
							prodName = customer.searchDiscountLimit(prodName, upper, down);
							prodName = customer.sortProductDiscount(prodName);
							for (int i = prodName.size() - 1; 0 < i; i--) {
								System.out.println(prodName.get(i).toString());
							}
							break;
						case "8":
							System.out.println("Search product by Product category");
							System.out.println("Enter Category Name: ");
							naPrdct = input.next();
							prodName = customer.searchProductCategory(naPrdct);
							for (int i = 0; i < prodName.size(); i++) {
								System.out.println(prodName.get(i).toString());
							}
							break;
						case "9":
							System.out.println("Product Order");
							System.out.println("Product Id: ");
							prdtId1 = input.next();
							System.out.println("Product Name: ");
							prdctName1 = input.next();
							System.out.println("Product Catalog: ");
							prdctCatalog1 = input.next();
							System.out.println("Product Price: ");
							pri1 = input.nextInt();
							System.out.println("Product Discounted Price: ");
							disc1 = input.nextInt();
							System.out.println("Product Description: ");
							descrip1 = input.next();
							System.out.println("Product Trader: ");
							traderName1 = input.next();
							if (customer.order(
									new Product(prdtId1, prdctName1, prdctCatalog1, pri1, disc1, descrip1, traderName1),
									customer.getUserName())) {
								trader.removeProduct(prdtId, traderName1);

								System.out.println("Success Order");
							} else {
								System.out.println("Not Success Order");
							}
							break;
						case "0":
							System.out.println("Return User Type Menu");
							exitMenu = true;
							break;
						}
					} while (!exitMenu);

				} else {
					break;
				}
				break;
			case "3":
				System.out.println("Welcome To Customer Register");
				System.out.println("User name");
				cuName = input.next();
				System.out.println("Password");
				cuPass = input.next();
				customer.register(cuName, cuPass);
				break;
			case "0":
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
