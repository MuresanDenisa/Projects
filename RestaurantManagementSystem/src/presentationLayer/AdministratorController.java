package presentationLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import businessLayer.Restaurant;
import dataLayer.RestaurantSerializator;

public class AdministratorController {

	private Restaurant restaurant;
	private AdministratorView view;

	/**
	 * Public Constructor sets the link between the controller and the view and
	 * calls the buttonListeners
	 * 
	 * @param newView
	 */
	public AdministratorController(AdministratorView newView, Restaurant restaurant) {
		this.view = newView;
		this.restaurant = restaurant;

		this.view.addMenuItemListener(new AddMenuItemListener());
		this.view.editMenuItemListener(new EditMenuItemListener());
		this.view.viewAllMenuItemsListener(new ViewAllListener());
		this.view.deleteMenuItemListener(new DeleteMenuItemListener());
	}

	/**
	 * Action listener for the "add menuItem" button which opens the Add MenuItem
	 * window GUI
	 * 
	 * @author DENISA
	 *
	 */
	class AddMenuItemListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			AddMenuItemView addItemView = new AddMenuItemView(restaurant);
			AddMenuItemController addItemController = new AddMenuItemController(addItemView, restaurant);
			addItemView.setVisible(true);
		}

	}

	/**
	 * Action listener for the "edit menuItem" button which opens the edit MenuItem
	 * window GUI
	 * 
	 * @author DENISA
	 *
	 */
	class EditMenuItemListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			EditMenuItemView editItemView = new EditMenuItemView();
			EditMenuItemController editItemController = new EditMenuItemController(editItemView, restaurant);
			editItemView.setVisible(true);
		}

	}

	/**
	 * Action listener for the "view all menuItem" button which opens the view all
	 * MenuItem window GUI
	 * 
	 * @author DENISA
	 *
	 */
	class ViewAllListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ViewAllMenuItemsView viewAllItemsView = new ViewAllMenuItemsView(restaurant.getRestaurantMenu());
			viewAllItemsView.setVisible(true);
		}

	}

	/**
	 * Action listener for the "delte menuItem" button
	 * 
	 * @author DENISA
	 *
	 */
	class DeleteMenuItemListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String productName = view.getItemToDelete();
			String string = restaurant.deleteMenuItem(productName);
			RestaurantSerializator.serialize(restaurant);
			JOptionPane.showMessageDialog(null, string);
			System.out.println(restaurant.getRestaurantMenu().toString());
		}

	}

}
