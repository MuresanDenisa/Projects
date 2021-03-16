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

public class AdministratorView extends JFrame {

	private JButton addMenuItemBtn = new JButton("add menuItem");
	private JButton editMenuItemBtn = new JButton("edit menuItem");
	private JTextField itemToDelete = new JTextField(10);
	private JButton deleteMenuItemBtn = new JButton("delete menuItem");
	private JButton viewAllMenuItemsBtn = new JButton(" view all menuItems");

	/**
	 * Public constructur, creates the graphic user interface
	 */
	public AdministratorView() {
		// Layout the components
		JPanel content = new JPanel();
		content.setLayout(new GridLayout(5, 0));

		// Set welcoming message panel
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2, 0));
		panel1.add(new JLabel("Welcome!", SwingConstants.CENTER));
		panel1.add(new JLabel("Please choose your operation!", SwingConstants.CENTER));

		// Set buttons panels
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		panel4.setLayout(new FlowLayout());
		JPanel panel5 = new JPanel();

		addMenuItemBtn.setPreferredSize(new Dimension(400, 40));
		editMenuItemBtn.setPreferredSize(new Dimension(400, 40));
		deleteMenuItemBtn.setPreferredSize(new Dimension(200, 40));
		viewAllMenuItemsBtn.setPreferredSize(new Dimension(400, 40));

		panel2.add(addMenuItemBtn);
		panel3.add(editMenuItemBtn);
		panel4.add(new JLabel("Insert name:"));
		panel4.add(itemToDelete);
		panel4.add(deleteMenuItemBtn);
		panel5.add(viewAllMenuItemsBtn);

		// Finalize layout
		content.add(panel1);
		content.add(panel2);
		content.add(panel3);
		content.add(panel5);
		content.add(panel4);
		this.setContentPane(content);
		this.pack();
		this.setTitle("Administrator View");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	/**
	 * gets the name of the product that should be deleted
	 * 
	 * @return
	 */
	public String getItemToDelete() {
		return itemToDelete.getText();
	}

	/**
	 * adds action listener for the " add menu Item " button, notifies the
	 * controller when the button is clicked
	 * 
	 * @param listenerForAddBtn
	 */
	void addMenuItemListener(ActionListener listenerForAddBtn) {
		addMenuItemBtn.addActionListener(listenerForAddBtn);
	}

	/**
	 * adds action listener for the " edit menu Item " button, notifies the
	 * controller when the button is clicked
	 * 
	 * @param listenerForAddBtn
	 */
	void editMenuItemListener(ActionListener listenerForEditBtn) {
		editMenuItemBtn.addActionListener(listenerForEditBtn);
	}

	/**
	 * adds action listener for the " add menu Item " button, notifies the
	 * controller when the button is clicked
	 * 
	 * @param listenerForAddBtn
	 */
	void deleteMenuItemListener(ActionListener listenerForDeleteBtn) {
		deleteMenuItemBtn.addActionListener(listenerForDeleteBtn);
	}

	/**
	 * adds action listener for the " add menu Item " button, notifies the
	 * controller when the button is clicked
	 * 
	 * @param listenerForAddBtn
	 */
	void viewAllMenuItemsListener(ActionListener listenerForViewAllBtn) {
		viewAllMenuItemsBtn.addActionListener(listenerForViewAllBtn);
	}
}
