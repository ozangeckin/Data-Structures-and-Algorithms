/**
 * This class keeps information about products.
 * 
 * @author ozan.geckin
 *
 */
public class Product {

	private String id;
	private String name;
	private String prdctCatog;
	private Integer price;
	private Integer discountAmount;
	private String description;
	private String trader;

	/**
	 * Seven parameter constructor
	 * 
	 * @param id            Product id
	 * @param name          Product name
	 * @param prdctCategory Product catagory
	 * @param price         Product price
	 * @param dicPri        Product discount Price
	 * @param description   Product description
	 * @param trader        Product trader
	 */
	public Product(String id, String name, String prdctCategory, Integer price, Integer dicPri, String description,
			String trader) {
		this.id = id;
		this.name = name;
		this.prdctCatog = prdctCategory;
		this.price = price;
		this.discountAmount = dicPri;
		this.description = description;
		this.trader = trader;

	}

	/**
	 * Copy constructor provide assign operator
	 * 
	 * @param other Product
	 */
	Product(Product other) {
		this.id = other.id;
		this.name = other.name;
		this.prdctCatog = other.prdctCatog;
		this.price = other.price;
		this.discountAmount = other.discountAmount;
		this.description = other.description;
		this.trader = other.trader;
	}
	/**
	 * Getter for product id
	 * @return id Product
	 */
	public String getId() {
		return id;
	}

	/**
	 * Setter of product id
	 * @param id Product id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Getter for product name
	 * @return name Product name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter of product name
	 * @param name Product name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for product name
	 * @return trader Product trader
	 */
	public String getTrader() {
		return trader;
	}

	/**
	 * Setter of product trader
	 * @param trader Product trader
	 */
	public void setTrader(String trader) {
		this.trader = trader;
	}
	
	/**
	 * Getter for product description
	 * @return description Product description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Setter of product description
	 * @param description Product description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Getter for product price
	 * @return price Product Price
	 */
	public Integer getPrice() {
		return price;
	}

	/**
	 * Setter of product price
	 * @param price Product price
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

	/**
	 * Getter for product discount amount
	 * @return discount Product discount amount 
	 */
	public Integer getDiscountAmount() {
		return discountAmount;
	}
	
	/**
	 * Setter of product discount amount
	 * @param discountAmount Product discount amount
	 */
	public void setDiscountAmount(Integer discountAmount) {
		this.discountAmount = discountAmount;
	}

	/**
	 * Getter for product catagory
	 * @return product catagory Product product catagory
	 */
	public String getPrdctCatog() {
		return prdctCatog;
	}

	/**
	 * Setter of product catagory
	 * @param prdctCatog Product product catagory
	 */
	public void setPrdctCatog(String prdctCatog) {
		this.prdctCatog = prdctCatog;
	}
	
	/**
	 * This method compara according to Product name
	 * @param product Product
	 * @return int comparison results
	 */
	public int compareToName(Product product) {
		return (this.name.compareTo(product.getName()));
	}
	
	/**
	 * This method compara according to Product price
	 * @param product Product
	 * @return int comparison results
	 */
	public int compareToPrice(Product product) {
		return (this.price.compareTo(product.getPrice()));
	}
	
	/**
	 * This method compara according to Product discount
	 * @param product Product
	 * @return int comparison results
	 */
	public int compareToDiscount(Product product) {
		return (this.discountAmount.compareTo(product.getDiscountAmount()));
	}
	
	/**
	 * This method provide print Product
	 */
	@Override
	public String toString() {
		return String.format(
				"Product ID: " + id + " Product Name: " + name + " Product Catalog: " + prdctCatog + " Product Price: "
						+ String.valueOf(price) + " Product Discount Amount: " + String.valueOf(discountAmount)
						+ " Product Description: " + description + " Product Trader: " + trader);
	}

}
