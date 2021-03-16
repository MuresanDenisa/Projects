package presentationLayer;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class EditMenuItemView extends JFrame {

	private JButton editProductBtn = new JButton("edit product");
	private JTextField productName = new JTextField(10);
	private JTextField price = new JTextField(10);

	public EditMenuItemView() {

		// Layout the components
		JPanel content = new JPanel();
		content.setLayout(new GridLayout(4, 0));

		// Set the buttons' panels
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();

		editProductBtn.setPreferredSize(new Dimension(400, 40));

		panel2.setLayout(new FlowLayout());
		panel3.setLayout(new FlowLayout());

		panel1.setLayout(new GridLayout(5, 0));
		panel1.add(new JLabel("Insert product's detailes that you want to edit:", SwingConstants.CENTER));

		panel2.add(new JLabel("Insert prodcut's name:"));
		panel2.add(productName);

		panel3.add(new JLabel("Insert prodcut's price:"));
		panel3.add(price);

		panel4.add(editProductBtn);

		// Finalize layout
		content.add(panel1);
		content.add(panel2);
		content.add(panel3);
		content.add(panel4);

		this.setContentPane(content);
		this.pack();
		this.setTitle("Edit Menu Item View");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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
	 * gets the price of the new product
	 * 
	 * @return
	 */
	public float getPrice() {
		return Float.parseFloat(price.getText());
	}

	/**
	 * adds action listener for the " edit base product " button, notifies the
	 * controller when the button is clicked
	 * 
	 * @param listenerForBaseProduct
	 */
	void editProductListener(ActionListener listenerForProduct) {
		editProductBtn.addActionListener(listenerForProduct);
	}

}
