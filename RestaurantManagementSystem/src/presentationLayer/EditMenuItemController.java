package presentationLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import businessLayer.Restaurant;
import dataLayer.RestaurantSerializator;

public class EditMenuItemController {

	private EditMenuItemView view;
	private Restaurant restaurant;

	public EditMenuItemController(EditMenuItemView view, Restaurant restaurant) {
		this.view = view;
		this.restaurant = restaurant;
		this.view.editProductListener(new EditProductListener());
	}

	/**
	 * Action listener for the "add base product" button which adds a new base
	 * product to the menu
	 * 
	 * @author DENISA
	 *
	 */
	class EditProductListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String name = view.getProductName();
			float price = view.getPrice();

			restaurant.editMeniuItem(name, price);
			RestaurantSerializator.serialize(restaurant);
			JOptionPane.showMessageDialog(null, "MenuItem edited!");
			System.out.println(restaurant.getRestaurantMenu().toString());
		}

	}
}
