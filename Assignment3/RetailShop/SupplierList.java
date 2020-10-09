

import java.util.ArrayList;

/**
 * SupplierList maintains the list of all the suppliers of the toolShop.
 * 
 * @author Sanyam
 *
 */
public class SupplierList {
	/**
	 * list represents the list of the suppliers
	 */
	private ArrayList<Suppliers> list;

	public SupplierList(ArrayList<Suppliers> list) {
		this.list = list;
	}

	/**
	 * addSupplier(Suppliers supplier) adds the supplier to the list of suppliers
	 * 
	 * @param supplier represents the supplier
	 */
	public void addSupplier(Suppliers supplier) {
		list.add(supplier);

	}

	public ArrayList<Suppliers> getList() {
		return list;
	}

	public void setList(ArrayList<Suppliers> list) {
		this.list = list;
	}

}
