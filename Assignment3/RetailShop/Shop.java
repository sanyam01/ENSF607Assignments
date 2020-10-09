

import java.io.IOException;
import java.util.ArrayList;

/**
 * Shop has the inventory and supplier list for all the items
 * 
 * It is where user can check item quantities, decrease items and search the
 * items by the tool name and tool ID
 * 
 * @author Sanyam
 *
 */
public class Shop {

	/**
	 * supplierList represents the list of all the suppliers
	 */
	private SupplierList supplierList;
	/**
	 * inventory represents the inventory of all the tools
	 */
	private Inventory inventory;

	/**
	 * Constructs the shop object
	 * 
	 * It calls the load methods in file manager to create the supplier list and the
	 * items list
	 * 
	 * @throws IOException
	 */
	public Shop() throws IOException {

		FileManager fm = new FileManager();
		supplierList = fm.loadList("Suppliers.txt");
		inventory = fm.loadInventory("items.txt", supplierList);

	}

	public SupplierList getSupplierList() {
		return supplierList;
	}

	public void setSupplierList(SupplierList supplierList) {
		this.supplierList = supplierList;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	/**
	 * searchToolID searches the tool with the iD equal to iDNum passed to it as
	 * arguments
	 * 
	 * @param iDNum id of the item to be searched
	 * @return the string representation of the item
	 */
	public String searchToolID(int iDNum) {

		for (Items i : getInventory().getListItems()) {
			if (i.getItemID() == iDNum)
				return i.toString();
		}

		return "No Tool with such ID exists";

	}

	/**
	 * searchTool searches the tool with the given name, which is passed to it as
	 * arguments
	 * 
	 * @param name represents the name of the item to be searched
	 * @return the string representation of the item
	 */
	public String searchTool(String name) {
		for (Items i : getInventory().getListItems()) {
			if (i.getItemName().equalsIgnoreCase(name))
				return i.toString();
		}

		return "Tool not found";

	}

	/**
	 * checkQuantity checks the quantity of the item available in the inventory
	 * based on the name
	 * 
	 * @param name represents the name of the item to be counted
	 * @return the quantity of the item
	 */
	public int checkQuantity(String name) {

		for (Items i : getInventory().getListItems()) {
			if (i.getItemName().equalsIgnoreCase(name))
				return i.getItemQuantity();
		}

		return -1;

	}

	/**
	 * checkQuantity checks the quantity of the item available in the inventory
	 * based on the ID
	 * 
	 * @param id represents the id of the item to be counted
	 * @return the quantity of the item
	 */
	public int checkQuantity(int id) {

		for (Items i : getInventory().getListItems()) {
			if (i.getItemID() == id)
				return i.getItemQuantity();
		}

		return -1;
	}

	/**
	 * decreaseQuantity calls the method in the Items to decrease the quantity of
	 * the item by 1, based on the tool name
	 * 
	 * @param toolName name of the tool corresponding to which quantity is to be
	 *                 decreased
	 * @return the quantity of the item
	 */
	public String decreaseQuantity(String toolName) {
		return this.inventory.decreaseQuantity(toolName);

	}

	/**
	 * decreaseQuantity calls the method in the Items to decrease the quantity of
	 * the item by 1, based on the tool ID
	 * 
	 * @param decreaseID id of the tool corresponding to which quantity is to be
	 *                   decreased
	 * @return the quantity of the item
	 */

	public String decreaseQuantity(int decreaseID) {
		String s = "Item not found";
		for (Items i : this.inventory.getListItems()) {
			if (decreaseID == i.getItemID())
				s = this.inventory.decreaseQuantity(i.getItemName());
		}

		return s;

	}

}
