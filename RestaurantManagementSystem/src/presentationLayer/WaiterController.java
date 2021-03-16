package presentationLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import businessLayer.MenuItem;
import businessLayer.Order;
import businessLayer.Restaurant;
import dataLayer.RestaurantSerializator;

public class WaiterController {

	private WaiterView view;
	private Restaurant restaurant;
	private ArrayList<MenuItem> addedProducts;

	/**
	 * Public Constructor sets the link between the controller and the view and
	 * calls the buttonListeners
	 * 
	 * @param newView
	 */
	public WaiterController(WaiterView newView, Restaurant restaurant) {
		this.view = newView;
		this.restaurant = restaurant;
		this.addedProducts = new ArrayList<MenuItem>();
		this.view.addProductBtnListener(new AddProductToOrderListener());
		this.view.finishOrderBtnListener(new FinishOrderListener());
		this.view.computePriceBtnListener(new ComputePriceListener());
		this.view.generateBillBtnListner(new GenerateBillListener());
	}

	/**
	 * Action listener for adding an item in an order
	 * 
	 * @author DENISA
	 *
	 */
	class AddProductToOrderListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			MenuItem chosenItem = (MenuItem) view.getMenuBox().getSelectedItem();
			addedProducts.add(chosenItem);
			JOptionPane.showMessageDialog(null, "product added!");
		}

	}

	/**
	 * Action listener for the "finish order" button which adds a new order to the
	 * restaurant
	 * 
	 * @author DENISA
	 *
	 */
	class FinishOrderListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int orderId = view.getIdOrder();
			int tableNo = view.getTableNo();
			Date today = new Date();
			today.setHours(0);
			System.out.println(today);
			Order newOrder = new Order(orderId, today, tableNo);

			restaurant.createNewOrder(newOrder, addedProducts);
			RestaurantSerializator.serialize(restaurant);

			JOptionPane.showMessageDialog(null, "Order added!");
			view.setIdOrder("" + restaurant.getIdOrder());
			view.setTableNo();

			addedProducts = new ArrayList<MenuItem>();
		}

	}

	/**
	 * Action listener for the "compute price" button which computes the price of
	 * the order
	 * 
	 * @author DENISA
	 *
	 */
	class ComputePriceListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int idOrder = view.getIdOrderSecond();
			float total = restaurant.computePrice(idOrder);
			JOptionPane.showMessageDialog(null, "" + total);
			view.setIdOrderSecond();
			RestaurantSerializator.serialize(restaurant);
		}

	}

	/**
	 * Action listener for the "generate bill" button which generates a .txt file
	 * with the bill
	 * 
	 * @author DENISA
	 *
	 */
	class GenerateBillListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int idOrder = view.getIdOrderSecond();
			restaurant.genereateBill(idOrder);
			JOptionPane.showMessageDialog(null, "Bill generated!");
			view.setIdOrderSecond();
		}

	}
}
