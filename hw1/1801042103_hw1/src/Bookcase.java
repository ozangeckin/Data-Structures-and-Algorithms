/**
 * @author 1801042103
 *  This class has all the details of Bookcase product of Company extend OfficeProducts
 */
//package CompanySystem;

public class Bookcase extends OfficeProducts {

	/**
	 * Default constructor of Bookcase class
	 */
	public Bookcase() {
		super();
		this.name = "Bookcase";
	}

	/**
	 * Constructor of Bookcase class with parameter model
	 * 
	 * @param model model of Bookcase
	 */
	public Bookcase(String model) {
		super(model, null, "Bookcase");
	}

}
