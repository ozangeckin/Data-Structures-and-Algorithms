/**
 * @author ozan.geckin
 * This class has all the details of OfficeDesk product of Company extend OfficeProducts 
 */
//package hw3;

public class OfficeDesk extends OfficeProduct {
	/**
	 * Constructor of OfficeDesk class with two parameters model, color call
	 * constructor of Abstract User
	 * 
	 * @param model model of OfficeDesk
	 * @param color color of OfficeDesk
	 */
	public OfficeDesk(String model, String color) {
		super(model, color, "Office Desk");
	}

}
