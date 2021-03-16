package businessLayer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Set;

import dataLayer.FileWriter;
import presentationLayer.ChefView;

public class Restaurant extends Observable implements IRestaurantProcessing, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<MenuItem> restaurantMenu;
	private ArrayList<Order> restaurantOrders;
	private Map<Order, ArrayList<MenuItem>> orderMenuMap;
	private int idOrder;

	public Restaurant() {
		setRestaurantMenu(new ArrayList<MenuItem>());
		restaurantOrders = new ArrayList<Order>();
		orderMenuMap = new HashMap<Order, ArrayList<MenuItem>>();
		this.idOrder = restaurantOrders.size();

	}

	@Override
	public void createNewMenuItem(BaseProduct baseProduct, CompositeProduct compositeProduct) {
		// TODO Auto-generated method stub
		assert (baseProduct != null || compositeProduct != null);

		int preSize = getRestaurantMenu().size();

		if (baseProduct == null) {
			restaurantMenu.add(compositeProduct);
		}

		if (compositeProduct == null) {
			getRestaurantMenu().add(baseProduct);
		}

		int postSize = getRestaurantMenu().size();

		assert postSize == preSize + 1;

	}

	@Override
	public String deleteMenuItem(String productName) {
		// TODO Auto-generated method stub

		assert productName != null;
		int preSize = getRestaurantMenu().size();

		ArrayList<CompositeProduct> compositeProductsToBeDeleted = new ArrayList<CompositeProduct>();
		MenuItem copyItem = null;

		copyItem = findItemByName(productName);
		if (copyItem == null) {
			return "MenuItem not found!";
		}

		if (copyItem instanceof BaseProduct) {
			for (MenuItem product : restaurantMenu) {
				if (product instanceof CompositeProduct) {
					for (BaseProduct baseProduct : ((CompositeProduct) product).getCompositeProduct()) {
						if (baseProduct.getProductName().contentEquals(productName))
							compositeProductsToBeDeleted.add((CompositeProduct) product);
					}
				}
			}

			for (CompositeProduct prod : compositeProductsToBeDeleted) {
				restaurantMenu.remove(prod);
			}
		}

		restaurantMenu.remove(copyItem);
		int postSize = getRestaurantMenu().size();

		assert postSize != preSize;
		return "MenuItem deleted!";

	}

	@Override
	public void editMeniuItem(String name, float price) {
		// TODO Auto-generated method stub

		assert name != null;
		MenuItem item = findItemByName(name);
		float prePrice = item.getPrice();

		item.setPrice(price);

		float postPrice = item.getPrice();
		assert prePrice != postPrice;

	}

	@SuppressWarnings("deprecation")
	@Override
	public void createNewOrder(Order order, ArrayList<MenuItem> items) {
		// TODO Auto-generated method stub

		assert order != null;
		assert items.size() != 0;

		boolean notifyChef = false;

		restaurantOrders.add(order);

		String chefMessage = "A new order has been created\n" + "Order ID:" + order.getOrderID()
				+ "\nProducts to be cooked:\n";
		for (MenuItem item : items) {
			if (item instanceof CompositeProduct) {
				notifyChef = true;
				chefMessage += item.toString() + "\n";
			}
		}

		orderMenuMap.put(order, items);
		if (isWellFormed()) {
			System.out.println("Order is wellFormed!\n");
			if (notifyChef == true) {
				ChefView chef = new ChefView(this);
				setChanged();
				notifyObservers(chefMessage);
				clearChanged();
			}
		} else
			System.out.println("Order is not wellFormed!\n");

		this.idOrder = restaurantOrders.size();
	}

	@Override
	public float computePrice(int orderID) {
		// TODO Auto-generated method stub
		assert orderID != -1;
		Order orderCopy = null;
		float price = 0;

		for (Order order : restaurantOrders) {
			if (order.getOrderID() == orderID)
				orderCopy = order;
		}

		ArrayList<MenuItem> orderedItems = orderMenuMap.get(orderCopy);

		for (MenuItem item : orderedItems) {
			price += item.getPrice();
		}
		orderCopy.setTotal(price);
		assert price != 0;

		return price;

	}

	@Override
	public void genereateBill(int orderID) {
		// TODO Auto-generated method stub
		assert orderID != -1;
		Order orderCopy = null;

		for (Order order : restaurantOrders) {
			if (order.getOrderID() == orderID)
				orderCopy = order;
		}

		ArrayList<MenuItem> orderedItems = orderMenuMap.get(orderCopy);
		FileWriter newFile = new FileWriter(orderCopy, orderedItems);

	}

	/**
	 * checks if an order is wellFormed
	 * 
	 * @return
	 */
	public boolean isWellFormed() {
		Set<Order> set = orderMenuMap.keySet();

		for (Order order : set) {
			if (orderMenuMap.get(order) == null)
				return false;
		}
		return true;

	}

	/**
	 * find an item in the menu by name;
	 * 
	 * @param name
	 * @return
	 */
	public MenuItem findItemByName(String name) {

		for (MenuItem item : restaurantMenu) {
			if (item.getProductName().equals(name))
				return item;
		}

		return null;
	}

	// getters and setters
	public ArrayList<MenuItem> getRestaurantMenu() {
		return restaurantMenu;
	}

	public void setRestaurantMenu(ArrayList<MenuItem> restaurantMenu) {
		this.restaurantMenu = restaurantMenu;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public ArrayList<Order> getRestaurantOrders() {
		return restaurantOrders;
	}

	public void setRestaurantOrders(ArrayList<Order> restaurantOrders) {
		this.restaurantOrders = restaurantOrders;
	}

	public Map<Order, ArrayList<MenuItem>> getOrderMenuMap() {
		return orderMenuMap;
	}

	public void setOrderMenuMap(Map<Order, ArrayList<MenuItem>> orderMenuMap) {
		this.orderMenuMap = orderMenuMap;
	}

}
