package presentationLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import businessLayer.BaseProduct;
import businessLayer.CompositeProduct;
import businessLayer.Restaurant;
import dataLayer.RestaurantSerializator;

public class AddMenuItemController {

	private Restaurant restaurant;
	private AddMenuItemView view;
	private CompositeProduct compositeProduct;
	private ArrayList<BaseProduct> addedProducts;

	/**
	 * Public Constructor sets the link between the controller and the view and
	 * calls the buttonListeners
	 * 
	 * @param newView
	 */
	public AddMenuItemController(AddMenuItemView newView, Restaurant restaurant) {
		this.view = newView;
		this.restaurant = restaurant;
		this.addedProducts = new ArrayList<BaseProduct>();
		this.view.addBaseProductListener(new BaseProductListener());
		this.view.addProductBtnListener(new ProductListener());
		this.view.addCompositeProductListener(new CompositeProductListener());

	}

	class ProductListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			BaseProduct chosenItem = (BaseProduct) view.getMenuBox().getSelectedItem();
			addedProducts.add(chosenItem);
			JOptionPane.showMessageDialog(null, "product added!");
		}

	}

	/**
	 * Action listener for the "add base product" button which adds a new base
	 * product to the menu
	 * 
	 * @author DENISA
	 *
	 */
	class BaseProductListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			String name = view.getProductName();
			float price = view.getPrice();
			int quantity = view.getQuantity();
			BaseProduct product = new BaseProduct(name, price, quantity);

			restaurant.createNewMenuItem(product, null);
			int size = restaurant.getRestaurantMenu().size();
			view.fillMenuBox(size - 1, restaurant);
			RestaurantSerializator.serialize(restaurant);
			JOptionPane.showMessageDialog(null, "MenuItem added!");
			view.setProductName();
			view.setPrice();
			view.setQuantity();
			System.out.println(restaurant.getRestaurantMenu().toString());

		}

	}

	/**
	 * Action listener for the "add composite product" button which adds a new
	 * composite product to the menu
	 * 
	 * @author DENISA
	 *
	 */
	class CompositeProductListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			compositeProduct = new CompositeProduct(view.getCompositeProductName(), addedProducts);

			restaurant.createNewMenuItem(null, compositeProduct);
			RestaurantSerializator.serialize(restaurant);

			JOptionPane.showMessageDialog(null, "MenuItem added!");
			view.setCompositeProductName();
			System.out.println(restaurant.getRestaurantMenu().toString());
			addedProducts = new ArrayList<BaseProduct>();

		}

	}
}
