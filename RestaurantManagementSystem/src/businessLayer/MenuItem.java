package businessLayer;

import java.io.Serializable;

public abstract class MenuItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String productName;
	protected float price;

	public abstract float computePrice();

	/**
	 * Public constructor, sets the name and the price
	 * 
	 * @param name
	 * @param price
	 */
	public MenuItem(String name, float price) {
		this.productName = name;
		this.price = price;
	}

	/**
	 * Public constructor, sets the name and sets price to zero
	 * 
	 * @param name
	 * @param price
	 */
	public MenuItem(String name) {
		this.productName = name;
		this.price = 0;
	}

	// getters and setters
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		String string = "";

		string += this.getProductName() + ", price: " + this.getPrice();

		return string;

	}
}
