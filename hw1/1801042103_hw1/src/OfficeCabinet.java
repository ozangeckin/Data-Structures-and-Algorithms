/**
 * @author 1801042103
 *  This class has all the details of OfficeCabinet of Company extend OfficeProducts
 */
//package CompanySystem;

public class OfficeCabinet extends OfficeProducts {

	/**
	 * Default constructor of OfficeCabinet Class
	 */
	public OfficeCabinet() {
		super();
		this.name = "Office Cabinet";
	}

	/**
	 * Constructor of OfficeCabinet class with parameter model
	 * 
	 * @param model model of OfficeCabinet
	 */
	public OfficeCabinet(String model) {
		super(model, null, "Office Cabinet");
	}
}
