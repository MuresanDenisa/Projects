package businessLayer;

import java.util.ArrayList;

public class CompositeProduct extends MenuItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<BaseProduct> compositeProduct;

	public CompositeProduct(String name, ArrayList<BaseProduct> compositeProduct) {
		super(name);
		this.compositeProduct = compositeProduct;
		this.price = computePrice();
	}

	@Override
	public float computePrice() {
		float total = 0;
		for (BaseProduct item : compositeProduct) {
			total += item.getPrice();
		}
		return total;
	}

	@Override
	public String toString() {
		String string = "";

		string += this.getProductName() + "{ ";
		for (BaseProduct product : compositeProduct)
			string += product.getProductName() + " ";

		string += "}";
		return string;
	}

	// getters and setters
	public ArrayList<BaseProduct> getCompositeProduct() {
		return compositeProduct;
	}

	public void setCompositeProduct(ArrayList<BaseProduct> compositeProduct) {
		this.compositeProduct = compositeProduct;
	}

}
