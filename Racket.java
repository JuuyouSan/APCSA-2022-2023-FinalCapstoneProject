//You MUST RENAME THIS PROGRAM TO SOMETHING APPROPRIATE FOR YOUR PROJECT
//YOU MUST PUT YOUR NAME AS AUTHOR and INCLUDE JAVADOCS FOR ALL METHODS
//USE THE SHOPPING CART Item class as an example

////////////////////
// Author: Justin Truong
// Final Project
// Instructor: Reiter
// Class: AP CSA
// Semester: Spring Semester
////////////////////
public class Racket {
	// INSTANCE FIELDS
	private String name;
	private String company;
	private String color;
	private Double price;
	private boolean inCart;

	// CONSTRUCTORS
	/**
	 * Creates a racket to be uploaded to the warehouse
	 * 
	 * @param n    The name or title of the tennis racket
	 * @param c    The company who designed and created the tennis reacket
	 * @param col  The general color of the tennis racket
	 * @param want Informs if the racket is added in the shopping cart
	 */
	public Racket(String n, String c, String col, Double cost, boolean want) {
		name = n;
		company = c;
		color = col;
		price = cost;
		inCart = want;
	}

	// ACCESSORS (including equals, compareTo and toString)

	/**
	 * Get Name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get Company
	 * 
	 * @return company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * Get Color
	 * 
	 * @return color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Get Price
	 * 
	 * @return Price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * Get if inside shopping cart
	 * 
	 * @return inCart
	 */
	public boolean getInCart() {
		return inCart;
	}

	/**
	 * returns true or false if word equals name
	 * 
	 * @param Object o
	 * @return true or false
	 */
	public boolean equals(Object o) {
		Racket other = (Racket) o;
		return this.name.equals(other.name);

	}

	/**
	 * Comparing names
	 * 
	 * @param o the name to compare to
	 */
	public int compareTo(Object o) {
		Racket itemObject = (Racket) o;

		return this.name.compareTo(itemObject.name);
	}

	/**
	 * print to String
	 * 
	 * @return String Name, Company, Color, Price, and if in cart
	 */
	public String toString() {
		String buying;
		if (inCart == true)
			buying = "In Cart";
		else
			buying = "";
		return "Name: " + name + "                    " + buying + "\nMade by: " + company + "\nGeneral Color: " + color
				+ "\nPrice: $" + price + "0\n";
	}

	// MUTATORS for each instance field even if not using
	/**
	 * Change Name
	 * 
	 * @param n New Name
	 */
	public void changeName(String n) {
		name = n;
	}

	/**
	 * Change Company
	 * 
	 * @param c New Company
	 */
	public void changeCompany(String c) {
		company = c;
	}

	/**
	 * Change Color
	 * 
	 * @param c New Color
	 */
	public void changeColor(String c) {
		color = c;
	}

	/**
	 * Change Price
	 * 
	 * @param p New Price
	 */
	public void changePrice(Double p) {
		price = p;
	}

	/**
	 * Change if inside shopping cart
	 * 
	 * @param b Changes inCart
	 */
	public void changeInCart(boolean b) {
		inCart = b;
	}

	/**
	 * Saves file of racket object
	 */
	public String saveToFile() {
		return name + "\n" + company + "\n" + color + "\n" + price + "\n" + inCart;
	}
}