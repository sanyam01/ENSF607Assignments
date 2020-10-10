

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * File Manager reads the supplier and the items information from the text files
 * and creates the list of Suppliers and the Items.
 * 
 * 
 * @author Sanyam
 *
 */
public class FileManager {

	/**
	 * readFile reads the text file, parses through the lines and return the whole
	 * text as String
	 * 
	 * @param fileName file which is to be read
	 * @return the text of the file
	 * @throws IOException
	 */

	private String readFile(String fileName) throws IOException {

		// reads the file
		FileReader fr = new FileReader(fileName);

		// creates a buffering character input stream
		BufferedReader br = new BufferedReader(fr);

		// constructs a string buffer with no characters
		StringBuffer sb = new StringBuffer();

		String line;

		// reads through all the words
		while ((line = br.readLine()) != null) {
			// O(n)
			sb.append(line);
			sb.append("\n");
		}
		// closes the stream and release the resources
		fr.close();

		// string containing the text
		String text = sb.toString();

		return text;
	}

	/**
	 * createSuppliers reads the supplier info from the text file passed to it as
	 * arguments and creates the list of the suppliers
	 * 
	 * @param fileName text file for reading suppliers
	 * @return list of suppliers
	 * @throws IOException
	 */
	public ArrayList<Suppliers> createSuppliers(String fileName) throws IOException {

		ArrayList<Suppliers> supplierList = new ArrayList<Suppliers>();

		String text = readFile(fileName);
		String[] lines = text.split("\n");

		// iterating through each supplier
		for (String j : lines) {

			String[] param = j.split(";");
			int id = Integer.parseInt(param[0]);

			// creating supplier object
			Suppliers sup = new Suppliers(id, param[1], param[2], param[3]);
			supplierList.add(sup);

		}
		return supplierList;

	}

	/**
	 * createItems reads the items info from the text file passed to it as arguments
	 * and creates the list of the items
	 * 
	 * 
	 * @param fileName text file for reading items
	 * @return list of items
	 * @throws IOException
	 */
	public ArrayList<Items> createItems(String fileName) throws IOException {

		ArrayList<Items> itemsList = new ArrayList<Items>();

		String text = readFile(fileName);
		String[] lines = text.split("\n");

		// iterating through each supplier
		for (String j : lines) {

			String[] param = j.split(";");
			int id = Integer.parseInt(param[0]);
			int quantity = Integer.parseInt(param[2]);
			float price = Float.parseFloat(param[3]);
			int supplierId = Integer.parseInt(param[4]);
			Suppliers sup = null;

			// creating items object
			Items it = new Items(id, param[1], quantity, price, supplierId, sup);
			itemsList.add(it);

		}
		return itemsList;

	}

	/**
	 * loadList calls the function createSupplier and passed the name of the text
	 * file from which suppliers info is to be read
	 * 
	 * @param fileName represents the name of the text file from which suppliers
	 *                 info is to be read
	 * @return the SupplierList
	 * @throws IOException
	 */
	public SupplierList loadList(String fileName) throws IOException {

		SupplierList supplierList = new SupplierList(createSuppliers(fileName));
		return supplierList;
	}

	/**
	 * loadInventory calls the method createItems and passes the supplier list and
	 * the file name from which items are to be read
	 * 
	 * @param fileName represents the name of the text file from which items info is
	 *                 to be read
	 * @return the Inventory
	 * @throws IOException
	 */

	public Inventory loadInventory(String fileName) throws IOException {

		Inventory theInventory = new Inventory(createItems(fileName));
		return theInventory;
	}
}
