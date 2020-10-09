package RetailShop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class menu represents the front end of the tool shop. It displays the menu to
 * the user and asks the user to select an operation to perform from a list of
 * operations.
 * 
 * Based on the number entered corresponding operation is performed. User will
 * continuously be displayed with the various options until he/she quits.
 * 
 * The design used to code the tool shop is from 'lectures'.
 * 
 * While testing of the code, if you input any wrong number then follow the
 * following instructions that will be displayed to you after you enter the wrong
 * input.
 * 
 * @author Sanyam
 *
 */
public class menu {

	/**
	 * printInventory(Shop theShop) prints all the tools of the inventory
	 * 
	 * @param theShop object of class Shop
	 */
	public static void printInventory(Shop theShop) {
		System.out.println(theShop.getInventory());

	}

	/**
	 * searchShopName searches the tool with the name entered by the user
	 * 
	 * If you enter the name that is not in the inventory, then you have to perform
	 * the operation again
	 * 
	 * @param theShop object of class Shop
	 * @param reader  object of BufferedReader
	 * @throws IOException
	 */
	public static void searchShopName(Shop theShop, BufferedReader reader) throws IOException {
		System.out.print("Enter the name of tool : ");
		String name = reader.readLine();
		System.out.println(theShop.searchTool(name));
	}

	/**
	 * searchShopID searches the tool with the ID entered by the user
	 * 
	 * If you enter the ID that is not in the inventory, then you have to perform
	 * the operation again
	 * 
	 * @param theShop object of class Shop
	 * @param reader  object of BufferedReader
	 * @throws IOException
	 */
	public static void searchShopID(Shop theShop, BufferedReader reader) throws IOException {

		System.out.print("Enter the ID of tool : ");
		String id = reader.readLine();
		try {
			int idNum = Integer.parseInt(id);
			System.out.println(theShop.searchToolID(idNum));
		} catch (NumberFormatException e) {
			System.out.println("No tool with such id exists");

		}

	}

	/**
	 * checkQuantityShop checks the quantity of an item based on the id or name of
	 * the tool entered by the user
	 * 
	 * If you enter any input wrong, then you have to perform the operation again
	 * 
	 * @param theShop object of class Shop
	 * @param reader  object of BufferedReader
	 * @throws IOException
	 */
	public static void checkQuantityShop(Shop theShop, BufferedReader reader) throws IOException {

		System.out.println("Do you want to check item quantity by tool name or tool id");
		System.out.println("1. Press '1' to check the quantity by tool name\n 2. Press '2' to check the quantity by tool Id");
		System.out.print("Enter a no here : ");
		String check = reader.readLine();
		int numberQuantities = -2;
		try {
			int checkNum = Integer.parseInt(check);
			if (!(checkNum == 2 || checkNum == 1))
				throw new NumberFormatException();

			// checks the quantity based on the tool name
			if (checkNum == 1) {
				System.out.print("Enter name of the tool : ");
				String toolName = reader.readLine();
				numberQuantities = theShop.checkQuantity(toolName);

				// checks the quantity based on the tool ID
			} else {
				System.out.print("Enter ID of the tool : ");
				String toolID = reader.readLine();
				int numID = Integer.parseInt(toolID);
				numberQuantities = theShop.checkQuantity(numID);
			}

			// if tool is not found in the inventory
			if (numberQuantities == -1)
				System.out.println("Tool not found");
			else
				System.out.println("The number of quantities are " + numberQuantities);

		} catch (NumberFormatException e) {
			System.out.println("Input was not valid");
		}
	}

	/**
	 * decreaseQuantityShop decreases the quantity of an item based on the id or
	 * name of the tool entered by the user
	 * 
	 * Each time user enter a particular id or name, quantity of that item is
	 * decreased by 1. If after decreasing the quantity, its count reduces to below 40, then
	 * a new order line is generated for that item.
	 * 
	 * Each time the status of the order is printed on the console. If new order line is generated then
	 * that order line also gets included in the order. 
	 * 
	 * If you enter any input wrong, then you have to perform the operation again
	 * 
	 * @param theShop object of class Shop
	 * @param reader  object of BufferedReader
	 * @throws IOException
	 */
	public static void decreaseQuantityShop(Shop theShop, BufferedReader reader) throws IOException {

		System.out.println("Do you want to decrease item quantity by tool name or tool id : ");
		System.out.println("1. Press 1 by tool name\n 2. Press 2 by tool Id");
		System.out.print("Enter a no here : ");
		String checkDecrease = reader.readLine();
		String printOrder = "";
		try {
			int inputDecrease = Integer.parseInt(checkDecrease);
			if (!(inputDecrease == 2 || inputDecrease == 1))
				throw new NumberFormatException();
			if (inputDecrease == 1) {
				System.out.print("Enter name of the tool : ");
				String toolName = reader.readLine();
				printOrder = theShop.decreaseQuantity(toolName);

			} else {
				System.out.print("Enter ID of the tool : ");
				String toolID = reader.readLine();
				int decreaseID = Integer.parseInt(toolID);
				printOrder = theShop.decreaseQuantity(decreaseID);

			}
			System.out.println(printOrder);

		} catch (NumberFormatException e) {
			System.out.println("Input was not valid");
		}

	}

	/**
	 * main for executing the tool shop
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		Shop theShop = new Shop();

		int num = 1;
		while (num >= 1 && num <= 6) {

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			System.out.println("For performing the operations, enter respective serial numbers\n");
			System.out.println("1. Display list of tools\n2. Search tool by toolName \n3. Search tool by toolID");
			System.out.println("4. Check Item Quantity \n5. Decrease item quantity\n6. Quit");
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			System.out.print("Enter a no here : ");
			String read;

			try {
				read = reader.readLine();
				num = Integer.parseInt(read);
				if (!(num >= 1 && num <= 6))
					throw new NumberFormatException();
			} catch (Exception e) {
				System.out.println("Enter an integer between 1 and 6");
				num = 1;
				continue;
			}

			switch (num) {
			case 1:
				printInventory(theShop);
				break;

			case 2:
				searchShopName(theShop, reader);
				break;

			case 3:
				searchShopID(theShop, reader);
				break;

			case 4:
				checkQuantityShop(theShop, reader);
				break;

			case 5:
				decreaseQuantityShop(theShop, reader);
				break;

			case 6:
				System.out.println("You have exited the shop");
				System.exit(1);
				break;

			}

		}

	}
}
