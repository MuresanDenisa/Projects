package presentationLayer;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class RestaurantView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton adminBtn = new JButton("Admin");
	private JButton chefBtn = new JButton("Chef");
	private JButton waiterBtn = new JButton("Waiter");

	/**
	 * Public constructur, creates the graphic user interface
	 */
	public RestaurantView() {
		// Layout the components
		JPanel content = new JPanel();
		content.setLayout(new GridLayout(4, 0));

		// Set welcoming message panel
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2, 0));
		panel1.add(new JLabel("Welcome!", SwingConstants.CENTER));
		panel1.add(new JLabel("Please choose your role!", SwingConstants.CENTER));

		// Set buttons panels
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		adminBtn.setPreferredSize(new Dimension(400, 40));
		chefBtn.setPreferredSize(new Dimension(400, 40));
		waiterBtn.setPreferredSize(new Dimension(400, 40));
		panel2.add(adminBtn);
		panel3.add(chefBtn);
		panel4.add(waiterBtn);

		// Finialize layout
		content.add(panel1);
		content.add(panel2);
		content.add(panel3);
		content.add(panel4);
		this.setContentPane(content);
		this.pack();
		this.setTitle("Restaurant Mangement System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * adds action listener for the " admin " button, notifies the controller when
	 * the button is clicked
	 * 
	 * @param listenForAdminBtn
	 */
	void adminBtnListener(ActionListener listenerForAdminBtn) {
		adminBtn.addActionListener(listenerForAdminBtn);
	}

	/**
	 * adds action listener for the " chef " button, notifies the controller when
	 * the button is clicked
	 * 
	 * @param listenForChefBtn
	 */
	void chefBtnListener(ActionListener listenerForChefBtn) {
		chefBtn.addActionListener(listenerForChefBtn);
	}

	/**
	 * adds action listener for the " waiter " button, notifies the controller when
	 * the button is clicked
	 * 
	 * @param listenForChefBtn
	 */
	void waiterBtnListener(ActionListener listenerForWaiterBtn) {
		waiterBtn.addActionListener(listenerForWaiterBtn);
	}
}
