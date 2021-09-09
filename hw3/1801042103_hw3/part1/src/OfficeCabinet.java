/**
 * @author ozan.geckin
 * This class has all the details of OfficeCabinet product of Company extend OfficeProducts 
 */
//package hw3;

public class OfficeCabinet extends OfficeProduct {

	/**
	 * Constructor of OfficeCabinet class with two parameters model, color call
	 * constructor of Abstract User
	 * 
	 * @param model model of OfficeCabinet
	 * @param color color of OfficeCabinet
	 */
	public OfficeCabinet(String model, String color) {
		super(model, color, "Office Cabinet");
	}

}
