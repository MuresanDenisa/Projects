package businessLayer;

public class BaseProduct extends MenuItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int quantity;

	/**
	 * Public Constructor
	 * 
	 * @param name
	 * @param price
	 * @param quantity
	 */
	public BaseProduct(String name, float price, int quantity) {
		super(name, price);
		this.quantity = quantity;
	}

	@Override
	public float computePrice() {
		return this.getPrice();
	}

	// getters and setters
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
