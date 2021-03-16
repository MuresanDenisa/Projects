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

import businessLayer.BaseProduct;
import businessLayer.MenuItem;
import businessLayer.Restaurant;

public class AddMenuItemView extends JFrame {

	private JButton addBaseProductBtn = new JButton("add base product");
	private JTextField productName = new JTextField(10);
	private JTextField price = new JTextField(10);
	private JTextField quantity = new JTextField(10);
	private JButton addProductBtn = new JButton("add product");
	private JButton addCompositeBtn = new JButton("finish composite product");
	private JComboBox<MenuItem> menuBox = new JComboBox<MenuItem>();
	private JTextField compositeProductName = new JTextField(10);

	private ArrayList<MenuItem> compositeItem;

	public AddMenuItemView(Restaurant restaurant) {

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

		addBaseProductBtn.setPreferredSize(new Dimension(400, 40));
		addCompositeBtn.setPreferredSize(new Dimension(400, 40));
		addProductBtn.setPreferredSize(new Dimension(400, 40));

		panel2.setLayout(new FlowLayout());
		panel3.setLayout(new FlowLayout());
		panel4.setLayout(new FlowLayout());
		panel5.setLayout(new FlowLayout());
		panel8.setLayout(new FlowLayout());

		panel1.setLayout(new GridLayout(5, 0));
		panel1.add(new JLabel("Insert product's detailes:", SwingConstants.CENTER));

		panel2.add(new JLabel("Insert product's name:"));
		panel2.add(productName);

		panel3.add(new JLabel("Insert product's price:"));
		panel3.add(price);

		panel4.add(new JLabel("Insert product's quantity:"));
		panel4.add(quantity);

		fillMenuBox(0, restaurant);
		panel5.add(new JLabel("Choose products:"));
		panel5.add(menuBox);

		panel6.add(addBaseProductBtn);
		panel7.add(addProductBtn);

		panel8.add(new JLabel("Insert products' name:"));
		panel8.add(compositeProductName);

		panel9.add(addCompositeBtn);

		// Finalize layout
		// BaseProduct Layout
		content.add(panel1);
		content.add(panel2);
		content.add(panel3);
		content.add(panel4);
		content.add(panel6);

		// CompositeProduct Layout
		content.add(panel8);
		content.add(panel5);
		content.add(panel7);
		content.add(panel9);
		this.setContentPane(content);
		this.pack();
		this.setTitle("Add Menu Item View");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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
	 * @param size
	 * @param restaurant
	 */
	public void fillMenuBox(int size, Restaurant restaurant) {

		ArrayList<MenuItem> menu = restaurant.getRestaurantMenu();

		for (int i = size; i < menu.size(); i++) {
			if (menu.get(i) instanceof BaseProduct)
				menuBox.addItem(menu.get(i));
		}
	}

	/**
	 * resets the product name JTextField
	 */
	public void setProductName() {
		this.productName.setText("");
	}

	/**
	 * gets the name of the new product
	 * 
	 * @return
	 */
	public String getProductName() {
		return productName.getText();
	}

	/**
	 * resets the price JText Field
	 */
	public void setPrice() {
		this.price.setText("");
	}

	/**
	 * gets the price of the new product
	 * 
	 * @return
	 */
	public float getPrice() {
		return Float.parseFloat(price.getText());
	}

	/**
	 * resets the quantity JTextField
	 */
	public void setQuantity() {
		this.quantity.setText("");
	}

	/**
	 * gets the quantity of the new product
	 * 
	 * @return
	 */
	public int getQuantity() {
		return Integer.parseInt(quantity.getText());
	}

	/**
	 * resets the compositeProductName JTextField
	 */
	public void setCompositeProductName() {
		this.compositeProductName.setText("");
	}

	/**
	 * gets the name of the new composite product
	 * 
	 * @return
	 */
	public String getCompositeProductName() {
		return compositeProductName.getText();
	}

	/**
	 * adds action listener for the " add base product " button, notifies the
	 * controller when the button is clicked
	 * 
	 * @param listenerForBaseProduct
	 */
	void addBaseProductListener(ActionListener listenerForBaseProduct) {
		addBaseProductBtn.addActionListener(listenerForBaseProduct);
	}

	/**
	 * adds action listener for the " add composite product " button, notifies the
	 * controller when the button is clicked
	 * 
	 * @param listenerForCompositeProduct
	 */
	void addCompositeProductListener(ActionListener listenerForCompositeProduct) {
		addCompositeBtn.addActionListener(listenerForCompositeProduct);
	}

	/**
	 * adds action listener for the " add product " button, notifies the controller
	 * when the button is clicked
	 * 
	 * @param listenerForAddProductBtn
	 */
	void addProductBtnListener(ActionListener listenerForAddProductBtn) {
		addProductBtn.addActionListener(listenerForAddProductBtn);
	}

}
