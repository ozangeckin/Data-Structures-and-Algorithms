/**
 * @author ozan.geckin
 * This class has all the details of OfficeChair product of Company extend OfficeProducts 
 */
//package hw3;

public class OfficeChair extends OfficeProduct {
	/**
	 * Constructor of OfficeChair class with two parameters model, color call
	 * constructor of Abstract User
	 * 
	 * @param model model of OfficeChair
	 * @param color color of OfficeChair
	 */
	public OfficeChair(String model, String color) {
		super(model, color, "Office Chair");
	}

}
