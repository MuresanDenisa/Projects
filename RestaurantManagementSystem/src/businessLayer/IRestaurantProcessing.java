package businessLayer;

import java.util.ArrayList;

public interface IRestaurantProcessing {

	// administrator operations
	/**
	 * @param baseProduct
	 * @pre baseProduct != null || compositeProduct!= null
	 * @post list.size== @pre list.size +1
	 * 
	 */
	public void createNewMenuItem(BaseProduct baseProduct, CompositeProduct compositeProduct);

	/**
	 * @param productName
	 * @pre productName != null
	 * @post list.size!= @pre list.size
	 * 
	 */
	public String deleteMenuItem(String productName);

	/**
	 * @param name
	 * @parma price
	 * @pre name != null
	 * @post item.price != @pre item.price
	 */
	public void editMeniuItem(String name, float price);

	// waiter operations
	/**
	 * 
	 * @param order
	 * @pre order!= null;
	 * @pre items.size !=0;
	 */
	public void createNewOrder(Order order, ArrayList<MenuItem> items);

	/**
	 * @param orderID
	 * @pre orderID!= -1
	 * @post @return !=0;
	 */
	public float computePrice(int orderID);

	/**
	 * @param orderID
	 * @pre orderID!= -1
	 */
	public void genereateBill(int orderID);

}
