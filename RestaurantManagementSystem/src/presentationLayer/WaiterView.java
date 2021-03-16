package presentationLayer;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import businessLayer.MenuItem;
import businessLayer.Restaurant;

public class WaiterView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField orderID = new JTextField(10);
	private JTextField tableNo = new JTextField(10);
	private JComboBox<MenuItem> menuBox = new JComboBox<MenuItem>();
	private JButton addProductBtn = new JButton("add product");
	private JButton finishOrderBtn = new JButton("finish order");

	private JTextField inputUser1 = new JTextField(20);
	private JButton computePriceBtn = new JButton("compute price");
	private JButton generateBillBtn = new JButton("generate bill");

	/**
	 * Public consturctor, sets the window layout
	 */
	public WaiterView(Restaurant restaurant) {

		// Layout the components
		JPanel content = new JPanel();
		content.setLayout(new GridLayout(9, 0));

		// Set the buttons' panels
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JPanel panel6 = new JPanel();
		JPanel panel7 = new JPanel();
		JPanel panel8 = new JPanel();
		JPanel panel9 = new JPanel();

		addProductBtn.setPreferredSize(new Dimension(400, 40));
		finishOrderBtn.setPreferredSize(new Dimension(400, 40));
		computePriceBtn.setPreferredSize(new Dimension(400, 40));
		generateBillBtn.setPreferredSize(new Dimension(400, 40));

		panel2.setLayout(new FlowLayout());
		panel3.setLayout(new FlowLayout());
		panel4.setLayout(new FlowLayout());
		panel7.setLayout(new FlowLayout());

		panel1.add(new JLabel("Welcome! Please choose your operation", SwingConstants.CENTER));
		panel2.add(new JLabel("Order id: "));
		String id = "" + restaurant.getIdOrder();
		orderID.setText(id);
		orderID.setEditable(false);
		panel2.add(orderID);

		panel3.add(new JLabel("TableNo: "));
		panel3.add(tableNo);

		fillMenuBox(restaurant);
		panel4.add(new JLabel("Choose menuItems: "));
		panel4.add(menuBox);

		panel5.add(addProductBtn);
		panel6.add(finishOrderBtn);

		panel7.add(new JLabel("Order ID: "));
		panel7.add(inputUser1);
		panel8.add(computePriceBtn);
		panel9.add(generateBillBtn);

		// Finalize layout
		content.add(panel1);
		content.add(panel2);
		content.add(panel3);
		content.add(panel4);
		content.add(panel5);
		content.add(panel6);
		content.add(panel7);
		content.add(panel8);
		content.add(panel9);
		this.setContentPane(content);
		this.pack();
		this.setTitle("Waiter View");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * resets the table number JTextField
	 * 
	 */
	public void setTableNo() {
		this.tableNo.setText("");
	}

	/**
	 * gets the table number fot the order
	 * 
	 * @return
	 */
	public int getTableNo() {
		return Integer.parseInt(tableNo.getText());
	}

	/**
	 * updates the id order
	 * 
	 * @param id
	 */
	public void setIdOrder(String id) {
		orderID.setEditable(true);
		this.orderID.setText(id);
		orderID.setEditable(false);
	}

	/**
	 * returns the id for the new order computed
	 * 
	 * @return
	 */
	public int getIdOrder() {
		return Integer.parseInt(orderID.getText());
	}

	/**
	 * resets the JTextField
	 */
	public void setIdOrderSecond() {
		this.inputUser1.setText("");
	}

	/**
	 * returns the order's id to which bill should be generated or price should be
	 * computed
	 * 
	 * @return
	 */
	public int getIdOrderSecond() {
		return Integer.parseInt(inputUser1.getText());
	}

	/**
	 * returns the content of the menuBox
	 * 
	 * @return
	 */
	public JComboBox<MenuItem> getMenuBox() {
		return menuBox;
	}

	/**
	 * Prints menuItems in the window GUI
	 * 
	 * @param restaurant
	 */
	public void fillMenuBox(Restaurant restaurant) {

		ArrayList<MenuItem> menu = restaurant.getRestaurantMenu();

		for (MenuItem item : menu) {
			menuBox.addItem(item);
		}
	}

	/**
	 * adds action listener for the " add product to order order " button, notifies
	 * the controller when the button is clicked
	 * 
	 * @param listenerForAddProduct
	 */
	void addProductBtnListener(ActionListener listenerForAddProduct) {
		addProductBtn.addActionListener(listenerForAddProduct);
	}

	/**
	 * adds action listener for the " add order " button, notifies the controller
	 * when the button is clicked
	 * 
	 * @param listenerForAddOrder
	 */
	void finishOrderBtnListener(ActionListener listenerForFinishOrder) {
		finishOrderBtn.addActionListener(listenerForFinishOrder);
	}

	/**
	 * adds action listener for the " compute price " button, notifies the
	 * controller when the button is clicked
	 * 
	 * @param listenerForComputePrice
	 */
	void computePriceBtnListener(ActionListener listenerForComputePrice) {
		computePriceBtn.addActionListener(listenerForComputePrice);
	}

	/**
	 * adds action listener for the " generate bill " button, notifies the
	 * controller when the button is clicked
	 * 
	 * @param listenerForComputeBill
	 */
	void generateBillBtnListner(ActionListener listenerForComputeBill) {
		generateBillBtn.addActionListener(listenerForComputeBill);
	}
}
