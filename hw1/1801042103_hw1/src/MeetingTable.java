/**
 * @author 1801042103
 *  This class has all the details of MeetingTable product of Company extend OfficeProducts
 */
//package CompanySystem;

public class MeetingTable extends OfficeProducts {
	/**
	 * Default constructor of MeetingTable class
	 */
	public MeetingTable() {
		super();
		this.name = "Meeting Table";
	}

	/**
	 * Constructor of MeetingTable with parameter model and color
	 * 
	 * @param model model of MeetingTable
	 * @param color color of MeetingTable
	 */
	public MeetingTable(String model, String color) {
		super(model, color, "Meeting Table");
	}

}
