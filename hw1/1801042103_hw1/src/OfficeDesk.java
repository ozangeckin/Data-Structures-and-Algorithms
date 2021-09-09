/**
 * @author 1801042103
 *  This class has all the details of OfficeDesk product of Company extend OfficeProducts
 */
//package CompanySystem;

public class OfficeDesk extends OfficeProducts {

	/**
	 * Default constructor of OfficeDesk class
	 */
	public OfficeDesk() {
		super();
		this.name = "Office Desk";
	}
	
	/**
	 * Constructor of OfficeDesk class with two parameters model and color
	 * @param model model of OfficeDesk
	 * @param color color of OfficeDesk
	 */
	public OfficeDesk(String model, String color) {
		super(model, color, "Office Desk");

	}

}
