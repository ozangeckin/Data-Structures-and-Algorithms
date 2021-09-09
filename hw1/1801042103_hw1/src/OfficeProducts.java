/**
 * @author 1801042103
 * This class has the details of a office products.
 */
//package CompanySystem;

public class OfficeProducts {

	String model;
	String color;
	String name;

	/**
	 * Default Constructor of OfficeProducts Class
	 */
	public OfficeProducts() {

	}

	/**
	 * Constructor of OfficeProducts class with three parameters model,color,name
	 * 
	 * @param model OfficeProducts model
	 * @param color OfficeProducts color
	 * @param name  OfficeProducts name
	 */
	public OfficeProducts(String model, String color, String name) {
		this.model = model;
		this.color = color;
		this.name = name;
	}
	/**
	 * Copy constructor
	 * System need to be copy constructor to move the other object and object
	 * @param otherObject OfficeProducts object
	 */
	public OfficeProducts(OfficeProducts otherObject) {
		this.name = otherObject.name;
		this.color = otherObject.color;
		this.model = otherObject.model;
	}

	/**
	 * Getter for OfficeProducts model
	 * @return model model of OfficeProducts
	 */
	public String getModel() {
		return model;
	}
	/**
	 * Setter of OfficeProducts model
	 * @param model model of OfficeProducts
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * Getter for OfficeProducts color
	 * @return color color of OfficeProducts
	 */
	public String getColor() {
		return color;
	}
	/**
	 * Setter of OfficeProducts color
	 * @param color color of OfficeProducts
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * Getter for OfficeProducts name
	 * @return name name of OfficeProducts
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * I override the object class's toString method according to my needs.
	 */
	@Override
	public String toString() {
		return String.format(name + "( Model : " + model + " , Color : " + color + " )");
	}

}
