/**
 * @author 1801042103
 *  This class has all the details of OfficeChair product of Company extend OfficeProducts
 */
//package CompanySystem;

public class OfficeChair extends OfficeProducts {

	/**
	 * Default constructor of OfficeChair class
	 */
	public OfficeChair() {
		super();
		this.name = "Office Chair";
	}

	/**
	 * Constructor of OfficeChair class with two parameters model and color
	 * 
	 * @param model model of OfficeChair
	 * @param color color of OfficeChair
	 */
	public OfficeChair(String model, String color) {
		super(model, color, "Office Chair");
	}
}
