
//You MUST RENAME THIS PROGRAM TO SOMETHING APPROPRIATE FOR YOUR PROJECT
//YOU MUST PUT YOUR NAME AS AUTHOR and INCLUDE JAVADOCS FOR ALL METHODS
//USE THE SHOPPING CART List class as an example
import java.util.*;
import java.lang.Math;
////////////////////
// Author: Justin Truong
// Final Project
// Instructor: Reiter
// Class: AP CSA
// Semester: Spring Semester
////////////////////
public class ShoppingCart {
	// declare an ArrayList
	/**
	 * ArrayList of racket objects of the warehouse
	 */
	private ArrayList<Racket> warehouse;

	// constructor to construct/instantiate the ArrayList
	/**
	 * Instantiates the ArrayList
	 */
	public ShoppingCart() {
		warehouse = new ArrayList<Racket>();
	}

	/**
	 * Adds an racket object to the ArrayList
	 * 
	 * @param name    the name of the Racket
	 * @param company the designer of the racket
	 * @param color   the general color of the racket
	 * @param price   the price of the racket
	 * @param inCart  if the racket is in cart
	 */
	public void addRacket(String name, String company, String color, double price, boolean inCart) {
		warehouse.add(new Racket(name, company, color, price, inCart));
	}

	// Copy all method headings from UML, make sure you have correct method heading,
	// create empty body. If method returns a value, return something just so it
	// will compile until you are ready to write that method.

	/**
	 * Sorts the ArrayList into alphabetical order
	 * 
	 * @return returns the ArrayList in alphabetical order in string format
	 */
	public String sortAlphabetical() {
		Racket temp;
		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			for (int q = 0; q < warehouse.size() - 1; q++) {
				if ((warehouse.get(q).getName().compareTo(warehouse.get(q + 1).getName()) > 0)) {
					temp = warehouse.get(q);
					warehouse.set(q, warehouse.get(q + 1));
					warehouse.set(q + 1, temp);
					sorted = false;
				}
			}
		}
		String list = "";
		for (int l = 0; l < warehouse.size(); l++) {
			list += l + ". " + warehouse.get(l).toString() + " \n";
		}
		return list;
	}

	/**
	 * Sorts the ArrayList by price
	 * 
	 * @return returns the ArrayList sorted by price in string format
	 */
	public String sortByPrice() {
		Racket temp;
		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			for (int q = 0; q < warehouse.size() - 1; q++) {
				if (warehouse.get(q).getPrice() < warehouse.get(q + 1).getPrice()) {
					temp = warehouse.get(q);
					warehouse.set(q, warehouse.get(q + 1));
					warehouse.set(q + 1, temp);
					sorted = false;
				}
			}
		}
		String list = "";
		for (int l = 0; l < warehouse.size(); l++) {
			list += l + ". " + warehouse.get(l).toString() + " \n";
		}
		return list;
	}

	/**
	 * Sorts the ArrayList into company (alphabetical) order
	 * 
	 * @return returns the ArrayList in company (alphabetical) order in string
	 *         format
	 */
	public String sortCompany() {
		Racket temp;
		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			for (int q = 0; q < warehouse.size() - 1; q++) {
				if ((warehouse.get(q).getCompany().compareTo(warehouse.get(q + 1).getCompany()) > 0)) {
					temp = warehouse.get(q);
					warehouse.set(q, warehouse.get(q + 1));
					warehouse.set(q + 1, temp);
					sorted = false;
				}
			}
		}
		String list = "";
		for (int l = 0; l < warehouse.size(); l++) {
			list += l + ". " + warehouse.get(l).toString() + " \n";
		}
		return list;
	}

	/**
	 * Sorts the ArrayList by ascending color
	 * 
	 * @return returns string format of ArrayList in ascending color order
	 */
	public String sortByColor() {
		Racket temp;
		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			for (int q = 0; q < warehouse.size() - 1; q++) {
				if (warehouse.get(q).getColor().compareTo(warehouse.get(q + 1).getColor()) > 0) {
					temp = warehouse.get(q);
					warehouse.set(q, warehouse.get(q + 1));
					warehouse.set(q + 1, temp);
					sorted = false;
				}
			}
		}
		String list = "";
		for (int l = 0; l < warehouse.size(); l++) {
			list += l + ". " + warehouse.get(l).toString() + " \n";
		}
		return list;
	}

	/**
	 * Sorts the ArrayList by order added
	 * 
	 * @returns string format of ArrayList in order added
	 */
	public String sortByOrderAdded() {
		Racket temp;
		boolean sorted = false;
		String list = "";
		int count = 0;
		while (!sorted) {
			sorted = true;
			if (warehouse.get(count).getInCart()) {
				count++;
			}
			for (int q = warehouse.size() - 1; q > count; q--) {
				if (warehouse.get(q).getInCart()) {
					temp = warehouse.get(q);
					warehouse.set(q, warehouse.get(q - 1));
					warehouse.set(q - 1, temp);
					sorted = false;

				}
			}

		}
		for (int l = 0; l < warehouse.size(); l++) {
			list += l + ". " + warehouse.get(l).toString() + " \n";
		}
		return list;
	}

	/**
	 * Saves the edits made by user into file
	 * 
	 * @return output returns the output of the save
	 */
	public String saveToFile() {
		String save = "";
		for (Racket racket : warehouse) {
			if (racket.getInCart())
				save += racket.getName() + "\n" + racket.getCompany() + "\n" + racket.getColor() + "\n"
						+ racket.getPrice() + "\n" + racket.getInCart() + "\n";
		}
		return save;
	}

	/**
	 * Saves the edits made by employee into file
	 * 
	 * @return output returns the output of the save
	 */
	public String saveToWarehouse() {
		String save = "";
		for (Racket racket : warehouse) {
			racket.changeInCart(false);
			save += racket.getName() + "\n" + racket.getCompany() + "\n" + racket.getColor() + "\n" + racket.getPrice()
					+ "\n" + racket.getInCart() + "\n";
		}
		return save;
	}

	/**
	 * Searches for all rackets above a certain size
	 * 
	 * @param price maximum price/budget of rackets
	 * @return returns all rackets in the ArrayList above specified size
	 */
	public String sortByMax(double price) {
		String list = "";
		for (int q = 0; q < warehouse.size(); q++) {
			if (price >= (warehouse.get(q).getPrice()))
				list = list + warehouse.get(q) + "\n";
		}
		return list;
	}

	/**
	 * Deletes specified racket from the ArrayList
	 * 
	 * @param species the specific species in the tank
	 */
	public void delete(int racketDel) {
		warehouse.remove(racketDel);
	}

	/**
	 * Removes specified racket from the ArrayList
	 * 
	 * @param the specific racket in the warehouse
	 * @return boolean if method was sucessful
	 */
	public boolean removeFromCart(int racketRemove) {
		for (int l = 0; l < warehouse.size(); l++) {
			if (l == racketRemove) {
				warehouse.get(l).changeInCart(false);
				return true;
			}
		}
		return false;
	}

	/**
	 * Removes specified racket from the ArrayList
	 * 
	 * @param the specific racket in the warehouse
	 * @return boolean if method was sucessful
	 */
	public boolean addToCart(int racketAdd) {
		for (int l = 0; l < warehouse.size(); l++) {
			if (l == racketAdd) {
				warehouse.get(l).changeInCart(true);
				return true;
			}
		}
		return false;
	}

	/**
	 * Get Featured Racket
	 * 
	 * @return Special Racket Info
	 */
	public String featuredRacket() {
		int ran = (int) (Math.random() * warehouse.size());
		return "FEATURED RACKET\nThe " + warehouse.get(ran).getName() + "\n\tMade By: "
				+ warehouse.get(ran).getCompany() + "\n\tPrice: $" + warehouse.get(ran).getPrice() + "0";
	}

	/**
	 * Show current warehouse order
	 * 
	 * @return toString of warehouse currently
	 */
	public String toString() {
		String list = "";
		for (int l = 0; l < warehouse.size(); l++) {
			list += l + ". " + warehouse.get(l).toString() + " \n";
		}
		return list;
	}

	/**
	 * Show current warehouse order
	 * 
	 * @return toString of warehouse currently
	 */
	public void setInCart(String name, String company) {
		for (int k = 0; k < warehouse.size() - 1; k++) {
			if (warehouse.get(k).getName().equals(name) && warehouse.get(k).getCompany().equals(company))
				warehouse.get(k).changeInCart(true);
		}
	}

	/**
	 * Saves the edits made by user into file
	 * 
	 * @return output returns the output of the save
	 */
	public Double calculateCartTotal() {
		double total = 0;
		for (Racket racket : warehouse) {
			if (racket.getInCart())
				total += racket.getPrice();
		}
		return total;
	}
}