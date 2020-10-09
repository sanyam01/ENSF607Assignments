package RetailShop;

/**
 * Suppliers represents the supplier that provides the tools to the inventory
 * Each supplier has a supplierID, name, address and contact
 * 
 * @author Sanyam
 *
 */
public class Suppliers {

	/**
	 * supplierID tells the iD of the supplier
	 */
	private int supplierID;
	
	/**
	 * supplierName tells the name of the supplier
	 */
	private String supplierName;
	
	/**
	 * supplierAddress gives the address of the supplier
	 */
	private String supplierAddress;
	
	/**
	 * supplierContact represents the address of the supplier
	 */
	private String supplierContact;

	/**
	 * Constructs an object of the class Suppliers
	 * 
	 * @param supplierID      iD of the supplier
	 * @param supplierName    name of the supplier
	 * @param supplierAddress address of the supplier
	 * @param supplierContact contact of the supplier
	 */
	public Suppliers(int supplierID, String supplierName, String supplierAddress, String supplierContact) {

		this.setSupplierAddress(supplierAddress);
		this.setSupplierContact(supplierContact);
		this.setSupplierID(supplierID);
		this.setSupplierName(supplierName);

	}

	public int getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public String getSupplierContact() {
		return supplierContact;
	}

	public void setSupplierContact(String supplierContact) {
		this.supplierContact = supplierContact;
	}

}
