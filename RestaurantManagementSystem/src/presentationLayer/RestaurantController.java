package presentationLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import businessLayer.Restaurant;

public class RestaurantController {

	private RestaurantView view;
	private Restaurant restaurant;

	/**
	 * Public Constructor sets the link between the controller and the view and
	 * calls the buttonListeners
	 * 
	 * @param newView
	 */
	public RestaurantController(RestaurantView newView, Restaurant restaurant) {
		this.view = newView;
		this.restaurant = restaurant;

		this.view.adminBtnListener(new AdminListener());
		this.view.chefBtnListener(new ChefListener());
		this.view.waiterBtnListener(new WaiterListener());
	}

	/**
	 * Action listener for the "Admin" button which opens the Admin window GUI
	 * 
	 * @author DENISA
	 *
	 */
	class AdminListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			AdministratorView adminView = new AdministratorView();
			AdministratorController adminController = new AdministratorController(adminView, restaurant);
			adminView.setVisible(true);
		}

	}

	/**
	 * Action listener for the "Chef" button which opens the Chef window GUI
	 * 
	 * @author DENISA
	 *
	 */
	class ChefListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ChefView chefView = new ChefView(restaurant);
			chefView.setVisible(true);
		}

	}

	/**
	 * Action listener for the "Waiter" button which opens the Waiter window GUI
	 * 
	 * @author DENISA
	 *
	 */
	class WaiterListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			WaiterView waiterView = new WaiterView(restaurant);
			WaiterController waiterController = new WaiterController(waiterView, restaurant);
			waiterView.setVisible(true);
		}

	}
}
