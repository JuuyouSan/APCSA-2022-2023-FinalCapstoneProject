import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
//## put class headindg here
////////////////////
// Author: Justin Truong
// Final Project
// Instructor: Reiter
// Class: AP CSA
// Semester: Spring Semester
////////////////////
public class Main {
	public static boolean quit = false;
	// Use Shopping Cart lab as a sample
	// Create Stataic variable of your list class
	/**
	 * Constructs the ArrayList object 'ShoppingCart'
	 */
	public static ShoppingCart warehouse = new ShoppingCart();

	public static void main(String[] args) {
		String startup = "Please select warehouse.dat";
		JOptionPane.showMessageDialog(null, startup);
		loadFile();
		while (!quit) {
			dropDownMenu();
		}
	}

	/**
	 * Loads the file selected by the user by reading the file's information and
	 * using the information to instantiate the ArrayList 'FishTank' with multiple
	 * Animal objects
	 * Shows a message of whether the load was successful or not
	 */
	public static void loadFile() {
		// Declare your Scanner Object for input data/do not instantiate until inside
		// try block
		Scanner in;

		// Create try catch block to catch error
		try {
			// use JFileChooser to select the filename to read from
			JFileChooser chooser = new JFileChooser();
			chooser.requestFocus();
			File infile = null;
			if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				infile = chooser.getSelectedFile();
			}
			// instantiate the Scanner object
			in = new Scanner(infile);
			// loop until no more data
			if ((infile.getName()).equals("warehouse.dat")) {
				while (in.hasNext()) {
					// read all data for one record
					String name = in.nextLine();
					System.out.println(name); /// testing
					String company = in.nextLine();
					System.out.println(company); /// testing
					String color = in.nextLine();
					System.out.println(color); /// testing
					Double price = in.nextDouble();
					System.out.println(price); /// testing
					in.nextLine();
					boolean inCart = in.nextBoolean();
					System.out.println(inCart); /// testing
					in.nextLine();
					// construct an object and call list class add method
					warehouse.addRacket(name, company, color, price, inCart);
				}
				in.close();
				JOptionPane.showMessageDialog(null, "File Loaded");

			}
			if ((infile.getName()).equals("list.dat")) {
				while (in.hasNext()) {
					// read all data for one record
					String name = in.nextLine();
					String company = in.nextLine();
					String color = in.nextLine();
					Double price = in.nextDouble();
					in.nextLine();
					boolean inCart = in.nextBoolean();
					in.nextLine();
					// construct an object and call list class add method
					warehouse.setInCart(name, company);
				}
				in.close();
				JOptionPane.showMessageDialog(null, "File Loaded");

			}
		} catch (IOException e) {
			// print message and include the variable e to tell what happened
			JOptionPane.showMessageDialog(null, "Error: " + e);
		}
	}

	/**
	 * Saves the changes made by the user into a new file, giving the user to choose
	 * the name and shows a message of whether the save was successful or not
	 */
	public static void saveFile() {
		String filename = JOptionPane.showInputDialog("Enter the file name to save to: ");
		try {
			PrintWriter output = new PrintWriter(filename);
			output.println(warehouse.saveToFile());
			output.close();
			JOptionPane.showMessageDialog(null, "File has been successfully saved");
		} catch (IOException exception) {
			JOptionPane.showMessageDialog(null, "Information could not be saved");

		}
	}

	/**
	 * Saves the changes made by the user into a list, giving the user a message of
	 * whether the save was successful or not
	 */
	public static void saveList() {
		String filename = "list.dat";
		try {
			PrintWriter output = new PrintWriter(filename);
			output.println(warehouse.saveToFile());
			output.close();
			JOptionPane.showMessageDialog(null, "File has been successfully saved");
		} catch (IOException exception) {
			JOptionPane.showMessageDialog(null, "Information could not be saved");

		}
	}

	/**
	 * Saves the changes made by the employee to warehouse
	 */
	public static void saveWarehouse() {
		String filename = "warehouse.dat";
		try {
			PrintWriter output = new PrintWriter(filename);
			output.println(warehouse.saveToWarehouse());
			output.close();
			JOptionPane.showMessageDialog(null, "File has been successfully saved");
		} catch (IOException exception) {
			JOptionPane.showMessageDialog(null, "Information could not be saved");

		}
	}

	/**
	 * Creates a drop down menu which gives the user multiple options and guides the
	 * user through the menu
	 */
	public static void dropDownMenu() {
		String menu = "Welcome Valued Customer\n1. Open Cart\n2. Show Featured Racket\n3. Import Shopping List\n4. Download Shopping List\n5. Edit Warehouse(Staff Only)\n6. Cart Total Cost \n7.Exit";
		String menuOption = JOptionPane.showInputDialog(menu);
		int choice = Integer.parseInt(menuOption);
		int number;
		if (choice == 1) {
			menu = ("0. Add Racket To Cart\n1. Remove Racket To Cart\n2. Show All Rackets Less Than a Certain Price\n3. Sort By Name\n4. Sort By Price\n5. Sort By Company\n6. Sort By Color\n7. Sort By Added to Cart");
			menuOption = JOptionPane.showInputDialog(menu);
			choice = Integer.parseInt(menuOption);
			switch (choice) {
				case 0: // complete
					menu = JOptionPane.showInputDialog("Rackets\n" + warehouse.toString());
					number = Integer.parseInt(menu);
					warehouse.addToCart(number);
					if (warehouse.addToCart(number)) {
						JOptionPane.showMessageDialog(null, "Racket Added");
					} else if (warehouse.addToCart(number) == false) {
						JOptionPane.showMessageDialog(null, "Racket Not Found");
					}
					break;
				case 1: // complete
					menu = JOptionPane.showInputDialog("Rackets\n" + warehouse.toString());
					number = Integer.parseInt(menu);
					warehouse.removeFromCart(number);
					if (warehouse.removeFromCart(number)) {
						JOptionPane.showMessageDialog(null, "Racket Removed");
					} else if (warehouse.addToCart(number) == false) {
						JOptionPane.showMessageDialog(null, "Racket Not Found");
					}
					break;
				case 2: // complete
					double max = Double.parseDouble(JOptionPane.showInputDialog(null, "Maximum price: "));
					JOptionPane.showMessageDialog(null, "Rackets\n" + warehouse.sortByMax(max));
					break;
				case 3: // complete
					JOptionPane.showMessageDialog(null, "Rackets\n" + warehouse.sortAlphabetical());
					break;
				case 4: // complete
					JOptionPane.showMessageDialog(null, "Rackets\n" + warehouse.sortByPrice());
					break;
				case 5: // complete
					JOptionPane.showMessageDialog(null, "Rackets\n" + warehouse.sortCompany());
					break;
				case 6: // complete
					JOptionPane.showMessageDialog(null, "Rackets\n" + warehouse.sortByColor());
					break;
				case 7: // Complete
					JOptionPane.showMessageDialog(null, "Rackets\n" + warehouse.sortByOrderAdded());
					break;
			}
		}

		else if (choice == 2) { // complete
			JOptionPane.showMessageDialog(null, warehouse.featuredRacket());
		} else if (choice == 3) { // complete
			loadFile();
		} else if (choice == 4) { // complete
			saveList();
		} else if (choice == 5) {
			menu = "Edit Warehouse:\n0. Remove Racket From Warehouse\n1. Add Racket To Warehouse";
			menuOption = JOptionPane.showInputDialog(menu);
			choice = Integer.parseInt(menuOption);
			switch (choice) {
				case 0:
					menu = JOptionPane.showInputDialog("Rackets\n" + warehouse.toString());
					number = Integer.parseInt(menu);
					warehouse.delete(number);
					menuOption = JOptionPane
							.showInputDialog("Rackets\n" + warehouse.toString() + "Save Changes? (Y = 1/N = 0)");
					choice = Integer.parseInt(menuOption);
					switch (choice) {
						case 0:
							break;
						case 1:
							saveWarehouse();
							break;
					}
					break;
				case 1:
					String name = JOptionPane.showInputDialog("Name of Racket: ");
					String company = JOptionPane.showInputDialog("Company of Racket: ");
					String color = JOptionPane.showInputDialog("General Color:");
					String price = JOptionPane.showInputDialog("Price of Racket:");
					Double Price = Double.parseDouble(price);
					Boolean inCart = false;
					warehouse.addRacket(name, company, color, Price, inCart);
					menuOption = JOptionPane
							.showInputDialog("Rackets\n" + warehouse.toString() + "Save Changes? (Y = 1/N = 0)");
					choice = Integer.parseInt(menuOption);
					switch (choice) {
						case 0:
							break;
						case 1:
							saveWarehouse();
							break;
					}
					break;
			}
		} else if (choice == 6) { // complete
			JOptionPane.showMessageDialog(null, "Total Price: $ " + warehouse.calculateCartTotal() + "0");
		}

		else if (choice == 7){
			quit = true;
		}
	}
}