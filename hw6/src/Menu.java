/**
 * This class It contains the functions of the methods I designed to be an
 * interactive structure.
 * 
 * @author ozan.geckin
 *
 */
public class Menu {
	/**
	 *This method print user types
	 */
	public void userType() {
		System.out.println("Welcome to Shopping Site");
		System.out.println("Choose User");
		System.out.println("1 - Trader ");
		System.out.println("2 - Customer ");
		System.out.println("3 - Register Customer");
		System.out.println("0 - Exit");
		System.out.println("Choose: ");
	}
	/**
	 * This method print Trader function
	 */
	public void TraderMenu() {
		System.out.println("Welcome to Trader Menu");
		System.out.println("1 - Add product ");
		System.out.println("2 - Remove product ");
		System.out.println("3 - Edit product");
		System.out.println("4 - Lists order");
		System.out.println("0 - Exit");
		System.out.println("Choose: ");
	}
	/**
	 * This method print Customer function
	 */
	public void CustomerMenu() {
		System.out.println("Welcome to Customer Menu");
		System.out.println("1 - Search product by Product Name and Product Description");
		System.out.println("2 - Search product by Trader name");
		System.out.println("3 - Search product by decreasing order of the product name");
		System.out.println("4 - Search product by Product prices (Upper-Down)");
		System.out.println("5 - Search product by Product prices (Down-Upper)");
		System.out.println("6 - Search product by Product prices (Upper-Down by Customer input))");
		System.out.println("7 - Search product by Product of the discount (Upper-Down by Customer input)");
		System.out.println("8 - Search product by Product category");
		System.out.println("9 - Product Order");
		System.out.println("0 - Exit");
		System.out.println("Choose: ");
	}

}
