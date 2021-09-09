/**
 * @author ozan.geckin
 * This class has all the details of MeetingTable product of Company extend OfficeProducts 
 */
//package hw3;

public class MeetingTable extends OfficeProduct {
	/**
	 * Constructor of MeetingTable class with two parameters model, color call
	 * constructor of Abstract User
	 * 
	 * @param model model of MeetingTable
	 * @param color color of MeetingTable
	 */
	public MeetingTable(String model, String color) {
		super(model, color, "Meeting Table");
	}

}
