
import java.util.ArrayList;

/**
 * Class inventory has the information of the tools(i.e. items) in the shop and
 * the order.
 * 
 * Inventory has an array list of all the tools.
 * 
 * @author Sanyam
 *
 */
public class Inventory {

	/**
	 * ArrayList<Items> listItems represents all the tools in the shop
	 */
	private ArrayList<Items> listItems;

	/**
	 * Order theOrder represents the order of the items
	 */
	private Order theOrder;

	/**
	 * Constructs an object of the class Inventory.
	 * 
	 * It also generates an order for the day
	 * 
	 * @param listItems an array list of items/tools
	 */
	public Inventory(ArrayList<Items> listItems) {
		this.setListItems(listItems);
		theOrder = new Order();

	}

	/**
	 * toString method overrides the toString method of super class.
	 * 
	 * It returns the string representation of all the tools in the inventory.
	 */
	@Override
	public String toString() {
		String p = "";
		for (Items s : listItems) {
			p = p + s.toString();
			p = p + "\n";
		}
		return p;
	}

	/**
	 * decreaseQuantity calls the method of class Items to decrease the quantity by
	 * one
	 *
	 * 
	 * @param name of item whose item is to be decremented by one
	 * @return the order for the day
	 */
	public String decreaseQuantity(String name) {
		String s = "Item not found";
		for (Items i : listItems) {
			if (i.getItemName().equalsIgnoreCase(name))
				s = i.decreaseQuantity(this.getTheOrder());
		}
		return s;

	}

	/**
	 * Iterates through all the items and passes the supplier list to the items for
	 * mapping the supplier id of the items with the supplier list and allocates the
	 * corresponding suppliers to the items
	 * 
	 * @param list represents the list of suppliers
	 */
	public void addSuppliers(SupplierList list) {
		for (Items i : listItems) {
			i.addSupplier(list);
		}
	}

	public Order getTheOrder() {
		return theOrder;
	}

	public void setTheOrder(Order theOrder) {
		this.theOrder = theOrder;
	}

	public ArrayList<Items> getListItems() {
		return listItems;
	}

	public void setListItems(ArrayList<Items> listItems) {
		this.listItems = listItems;
	}

}
