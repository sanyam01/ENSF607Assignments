package RetailShop;

/**
 * OrderLines represents the order generated for each item. It gets added to the
 * order for that particular day
 * 
 * It includes the item name, no of items ordered, and the supplier name
 * 
 * @author Sanyam
 *
 */
public class OrderLines {

	/**
	 * item represents the item for which order line is generated
	 */
	private String item;

	/**
	 * amount tells the number of items ordered
	 */
	private int amount;

	/**
	 * supplierName provides the name of the supplier
	 */
	private String supplierName;

	/**
	 * Constructs an object of OrderLines.
	 * 
	 * @param item         represents the item for which order line is generated
	 * @param amount       tells the number of items ordered
	 * @param supplierName provides the name of the supplier
	 */
	public OrderLines(String item, int amount, String supplierName) {

		this.item = item;
		this.amount = amount;
		this.supplierName = supplierName;

	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getSupplier() {
		return supplierName;
	}

	public void setSupplier(String supplier) {
		this.supplierName = supplier;
	}

}
