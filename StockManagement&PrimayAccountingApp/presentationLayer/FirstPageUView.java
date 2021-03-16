package presentationLayer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class FirstPageUView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton vanzareBtn = new JButton("Vanzare Produs");
	private JButton receptieBtn = new JButton("Receptie");
	private JButton vizStockBtn = new JButton("Vizualizare Stoc");
	private JButton vizReceptieBtn = new JButton("Vizualizare Receptii");
	private JButton logOutBtn = new JButton("LOGOUT");

	public FirstPageUView() {

		// Layout the components
		JPanel content = new JPanel();
		content.setBackground(new Color(51, 200, 255));
		content.setLayout(new GridLayout(4, 0));

		// Set welcoming message panel
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(51, 200, 255));
		panel1.setLayout(new GridLayout(2, 0));

		JLabel label = new JLabel("Bine ai venit!", SwingConstants.CENTER);
		label.setFont(new Font("Serif", Font.BOLD, 24));
		panel1.add(label);

		JLabel label1 = new JLabel("Alege operatia dorita: ", SwingConstants.CENTER);
		label1.setFont(new Font("Serif", Font.BOLD, 24));
		panel1.add(label1);

		// Set buttons panels
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(51, 200, 255));
		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(51, 200, 255));
		JPanel panel4 = new JPanel();
		panel4.setBackground(new Color(51, 200, 255));
		JPanel panel5 = new JPanel();
		panel5.setBackground(new Color(51, 200, 255));
		JPanel panel6 = new JPanel();
		panel6.setBackground(new Color(51, 200, 255));
		JPanel panel7 = new JPanel();
		panel7.setBackground(new Color(51, 200, 255));
		JPanel panel8 = new JPanel();
		panel8.setBackground(new Color(51, 200, 255));

		vizStockBtn.setPreferredSize(new Dimension(400, 40));
		vizStockBtn.setFont(new Font("Serif", Font.BOLD, 16));
		vizReceptieBtn.setPreferredSize(new Dimension(400, 40));
		vizReceptieBtn.setFont(new Font("Serif", Font.BOLD, 16));
		vanzareBtn.setPreferredSize(new Dimension(400, 40));
		vanzareBtn.setFont(new Font("Serif", Font.BOLD, 16));
		receptieBtn.setPreferredSize(new Dimension(400, 40));
		receptieBtn.setFont(new Font("Serif", Font.BOLD, 16));
		logOutBtn.setPreferredSize(new Dimension(400, 40));
		logOutBtn.setFont(new Font("Serif", Font.BOLD, 16));

		panel2.add(vanzareBtn);
		panel3.add(vizStockBtn);
		panel4.add(receptieBtn);
		panel5.add(vizReceptieBtn);
		panel8.add(logOutBtn);

		panel6.setLayout(new GridLayout(1, 2));
		panel6.add(panel2);
		panel6.add(panel3);

		panel7.setLayout(new GridLayout(1, 2));
		panel7.add(panel4);
		panel7.add(panel5);

		content.add(panel1);
		content.add(panel6);
		content.add(panel7);
		content.add(panel8);

		this.setContentPane(content);
		this.pack();
		this.setTitle("STOCK APP");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	/**
	 * adds action listener for the " Vanzare " button, notifies the controller when
	 * the button is clicked
	 * 
	 * @param listenForAdminBtn
	 */
	void vanzareBtnListener(ActionListener listenerForVanzareBtn) {
		vanzareBtn.addActionListener(listenerForVanzareBtn);
	}

	/**
	 * adds action listener for the "logOut" button, notifies the controller when
	 * the button is clicked
	 * 
	 * @param listenForAdminBtn
	 */
	void logOutBtnListener(ActionListener listenerForBtn) {
		logOutBtn.addActionListener(listenerForBtn);
	}

	/**
	 * adds action listener for the " vizStock " button, notifies the controller
	 * when the button is clicked
	 * 
	 * @param listenForAdminBtn
	 */
	void vizStockBtnListener(ActionListener listenerForStockBtn) {
		vizStockBtn.addActionListener(listenerForStockBtn);
	}

	/**
	 * adds action listener for the " add Receptie " button, notifies the controller
	 * when the button is clicked
	 * 
	 * @param listenForAdminBtn
	 */
	void receptieBtnListener(ActionListener listenerForReceptieBtn) {
		receptieBtn.addActionListener(listenerForReceptieBtn);
	}

	/**
	 * adds action listener for the " viz Receptie " button, notifies the controller
	 * when the button is clicked
	 * 
	 * @param listenForAdminBtn
	 */
	void vizReceptieBtnListener(ActionListener listenerForReceptieBtn) {
		vizReceptieBtn.addActionListener(listenerForReceptieBtn);
	}
}
