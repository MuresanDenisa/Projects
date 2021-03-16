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

public class FirstPageView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton addProdusBtn = new JButton("Adaugare Produs");
	private JButton addFurnizorBtn = new JButton("Adaugare Furnizor");
	private JButton addClientBtn = new JButton("Adaugare Client");
	private JButton addDelegatBtn = new JButton("Adaugare Delegat");
	private JButton rapoarteBtn = new JButton("Vizualizare Rapoarte");
	private JButton vanzareBtn = new JButton("Vanzare");
	private JButton receptieBtn = new JButton("Receptie");
	private JButton facturaBtn = new JButton("Factura");
	private JButton monetarBtn = new JButton("Monetar");
	private JButton registruBtn = new JButton("Registru de Casa");
	private JButton logOutBtn = new JButton("LOGOUT");
	private JButton addUserBtn = new JButton("Adauga Utilizator");

	public FirstPageView() {

		// Layout the components
		JPanel content = new JPanel();
		content.setBackground(new Color(51, 153, 255));
		content.setLayout(new GridLayout(8, 0));

		// Set welcoming message panel
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(51, 153, 255));
		panel1.setLayout(new GridLayout(2, 0));

		JLabel label = new JLabel("Bine ai venit!", SwingConstants.CENTER);
		label.setFont(new Font("Serif", Font.BOLD, 24));
		panel1.add(label);

		JLabel label1 = new JLabel("Alege operatia dorita: ", SwingConstants.CENTER);
		label1.setFont(new Font("Serif", Font.BOLD, 24));
		panel1.add(label1);

		// Set buttons panels
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(51, 153, 255));
		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(51, 153, 255));
		JPanel panel4 = new JPanel();
		panel4.setBackground(new Color(51, 153, 255));
		JPanel panel5 = new JPanel();
		panel5.setBackground(new Color(51, 153, 255));
		JPanel panel6 = new JPanel();
		panel6.setBackground(new Color(51, 153, 255));
		JPanel panel7 = new JPanel();
		panel7.setBackground(new Color(51, 153, 255));
		JPanel panel8 = new JPanel();
		panel8.setBackground(new Color(51, 153, 255));
		JPanel panel9 = new JPanel();
		panel9.setBackground(new Color(51, 153, 255));
		JPanel panel10 = new JPanel();
		panel10.setBackground(new Color(51, 153, 255));
		JPanel panel11 = new JPanel();
		panel11.setBackground(new Color(51, 153, 255));
		JPanel panel12 = new JPanel();
		panel12.setBackground(new Color(51, 153, 255));
		JPanel panel13 = new JPanel();
		panel13.setBackground(new Color(51, 153, 255));
		JPanel panel14 = new JPanel();
		panel14.setBackground(new Color(51, 153, 255));
		JPanel panel15 = new JPanel();
		panel15.setBackground(new Color(51, 153, 255));
		JPanel panel16 = new JPanel();
		panel16.setBackground(new Color(51, 153, 255));
		JPanel panel17 = new JPanel();
		panel17.setBackground(new Color(51, 153, 255));
		JPanel panel18 = new JPanel();
		panel18.setBackground(new Color(51, 153, 255));
		JPanel panel19 = new JPanel();
		panel19.setBackground(new Color(51, 153, 255));
		JPanel panel20 = new JPanel();
		panel20.setBackground(new Color(51, 153, 255));

		addProdusBtn.setPreferredSize(new Dimension(400, 40));
		addProdusBtn.setFont(new Font("Serif", Font.BOLD, 16));
		panel2.add(addProdusBtn);
		addFurnizorBtn.setPreferredSize(new Dimension(400, 40));
		addFurnizorBtn.setFont(new Font("Serif", Font.BOLD, 16));
		panel3.add(addFurnizorBtn);
		addClientBtn.setPreferredSize(new Dimension(400, 40));
		addClientBtn.setFont(new Font("Serif", Font.BOLD, 16));
		panel4.add(addClientBtn);
		addDelegatBtn.setPreferredSize(new Dimension(400, 40));
		addDelegatBtn.setFont(new Font("Serif", Font.BOLD, 16));
		panel5.add(addDelegatBtn);
		rapoarteBtn.setPreferredSize(new Dimension(400, 40));
		rapoarteBtn.setFont(new Font("Serif", Font.BOLD, 16));
		panel6.add(rapoarteBtn);
		vanzareBtn.setPreferredSize(new Dimension(400, 40));
		vanzareBtn.setFont(new Font("Serif", Font.BOLD, 16));
		panel7.add(vanzareBtn);
		receptieBtn.setPreferredSize(new Dimension(400, 40));
		receptieBtn.setFont(new Font("Serif", Font.BOLD, 16));
		panel8.add(receptieBtn);
		facturaBtn.setPreferredSize(new Dimension(400, 40));
		facturaBtn.setFont(new Font("Serif", Font.BOLD, 16));
		panel9.add(facturaBtn);
		registruBtn.setPreferredSize(new Dimension(400, 40));
		registruBtn.setFont(new Font("Serif", Font.BOLD, 16));
		panel10.add(registruBtn);
		monetarBtn.setPreferredSize(new Dimension(400, 40));
		monetarBtn.setFont(new Font("Serif", Font.BOLD, 16));
		panel11.add(monetarBtn);
		logOutBtn.setPreferredSize(new Dimension(400, 40));
		logOutBtn.setFont(new Font("Serif", Font.BOLD, 16));
		panel18.add(logOutBtn);
		addUserBtn.setPreferredSize(new Dimension(400, 40));
		addUserBtn.setFont(new Font("Serif", Font.BOLD, 16));
		panel19.add(addUserBtn);

		panel12.setLayout(new GridLayout(1, 2));
		JLabel label2 = new JLabel("Administrare Stoc si Baza de Date", SwingConstants.CENTER);
		label2.setFont(new Font("Serif", Font.BOLD, 20));
		panel12.add(label2);

		JLabel label3 = new JLabel("Gestiune", SwingConstants.CENTER);
		label3.setFont(new Font("Serif", Font.BOLD, 20));
		panel12.add(label3);

		panel13.setLayout(new GridLayout(1, 2));
		panel13.add(panel2);
		panel13.add(panel7);

		panel14.setLayout(new GridLayout(1, 2));
		panel14.add(panel3);
		panel14.add(panel8);

		panel15.setLayout(new GridLayout(1, 2));
		panel15.add(panel4);
		panel15.add(panel9);

		panel16.setLayout(new GridLayout(1, 2));
		panel16.add(panel5);
		panel16.add(panel10);

		panel17.setLayout(new GridLayout(1, 2));
		panel17.add(panel6);
		panel17.add(panel11);

		panel20.setLayout(new GridLayout(1, 2));
		panel20.add(panel19);
		panel20.add(panel18);

		content.add(panel1);
		content.add(panel12);
		content.add(panel13);
		content.add(panel14);
		content.add(panel15);
		content.add(panel16);
		content.add(panel17);
		content.add(panel20);

		this.setContentPane(content);
		this.pack();
		this.setTitle("STOCK APP");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * adds action listener for the " add Produs " button, notifies the controller
	 * when the button is clicked
	 * 
	 * @param listenForAdminBtn
	 */
	public void addProdusBtnListener(ActionListener listenerForProdusBtn) {
		addProdusBtn.addActionListener(listenerForProdusBtn);
	}

	/**
	 * adds action listener for the " add User " button, notifies the controller
	 * when the button is clicked
	 * 
	 * @param listenForAdminBtn
	 */
	public void addUserBtnListener(ActionListener listenerForBtn) {
		addUserBtn.addActionListener(listenerForBtn);
	}

	/**
	 * adds action listener for the " add Client " button, notifies the controller
	 * when the button is clicked
	 * 
	 * @param listenForAdminBtn
	 */
	void addClientBtnListener(ActionListener listenerForClientBtn) {
		addClientBtn.addActionListener(listenerForClientBtn);
	}

	/**
	 * adds action listener for the " add Furnizor " button, notifies the controller
	 * when the button is clicked
	 * 
	 * @param listenForAdminBtn
	 */
	void addFurnizorBtnListener(ActionListener listenerForFurnizorBtn) {
		addFurnizorBtn.addActionListener(listenerForFurnizorBtn);
	}

	/**
	 * adds action listener for the " add Delegat " button, notifies the controller
	 * when the button is clicked
	 * 
	 * @param listenForAdminBtn
	 */
	void addDelegatBtnListener(ActionListener listenerForDelegatBtn) {
		addDelegatBtn.addActionListener(listenerForDelegatBtn);
	}

	/**
	 * adds action listener for the " Rapoarte " button, notifies the controller
	 * when the button is clicked
	 * 
	 * @param listenForAdminBtn
	 */
	void rapoarteBtnListener(ActionListener listenerForRapoarteBtn) {
		rapoarteBtn.addActionListener(listenerForRapoarteBtn);
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
	 * adds action listener for the " add Receptie " button, notifies the controller
	 * when the button is clicked
	 * 
	 * @param listenForAdminBtn
	 */
	void receptieBtnListener(ActionListener listenerForReceptieBtn) {
		receptieBtn.addActionListener(listenerForReceptieBtn);
	}

	/**
	 * adds action listener for the " add Factura " button, notifies the controller
	 * when the button is clicked
	 * 
	 * @param listenForAdminBtn
	 */
	void facturaBtnListener(ActionListener listenerForFacturaBtn) {
		facturaBtn.addActionListener(listenerForFacturaBtn);
	}

	/**
	 * adds action listener for the " add Registru " button, notifies the controller
	 * when the button is clicked
	 * 
	 * @param listenForAdminBtn
	 */
	void registruBtnListener(ActionListener listenerForRegistruBtn) {
		registruBtn.addActionListener(listenerForRegistruBtn);
	}

	/**
	 * adds action listener for the " add Monetar " button, notifies the controller
	 * when the button is clicked
	 * 
	 * @param listenForAdminBtn
	 */
	void monetarBtnListener(ActionListener listenerForMonetarBtn) {
		monetarBtn.addActionListener(listenerForMonetarBtn);
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
}
