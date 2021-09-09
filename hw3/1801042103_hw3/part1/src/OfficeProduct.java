//package hw3;

public abstract class OfficeProduct {

	private String model;
	private String color;
	private String name;

	/**
	 * Constructor of OfficeProduct class with three parameters name, surname and
	 * password
	 * 
	 * @param model OfficeProduct model
	 * @param color OfficeProduct color
	 * @param name  OfficeProduct name
	 */
	public OfficeProduct(String model, String color, String name) {
		this.model = model;
		this.color = color;
		this.name = name;
	}

	/**
	 * Getter for OfficeProduct model
	 * 
	 * @return model OfficeProduct model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Setter of OfficeProduct model
	 * 
	 * @param model OfficeProduct model
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * Getter for OfficeProduct color
	 * 
	 * @return OfficeProduct color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Setter of OfficeProduct color
	 * 
	 * @param color OfficeProduct color
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
	/**
	 * Getter for OfficeProduct name
	 * @return name OfficeProduct name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for OfficeProduct name
	 * @param name OfficeProduct name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method allow print OfficeProduct
	 */
	@Override
	public String toString() {
		return String.format(name + "( Model : " + model + " , Color : " + color + " )");
	}

}
