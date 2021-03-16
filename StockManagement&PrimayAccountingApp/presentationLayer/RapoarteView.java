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

public class RapoarteView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton vizFurnizorBtn = new JButton("Vizualizare Furnizori");
	private JButton vizClientBtn = new JButton("Vizualizare Clienti");
	private JButton vizDelegatBtn = new JButton("Vizualizare Delegati");
	private JButton vizStockBtn = new JButton("Vizualizare Stoc");
	private JButton vizReceptieBtn = new JButton("Vizualizare Receptii");
	private JButton vizFacturaBtn = new JButton("Vizualizare  Facturi");
	private JButton vizMonetarBtn = new JButton("Vizualizare  Monetar");
	private JButton vizRegistruBtn = new JButton("Vizualizare Registre de Casa");

	public RapoarteView() {

		// Layout the components
		JPanel content = new JPanel();
		content.setBackground(new Color(51, 200, 255));
		content.setLayout(new GridLayout(5, 0));

		// Set welcoming message panel
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(51, 200, 255));
		panel1.setLayout(new GridLayout(2, 0));

		JLabel label = new JLabel("Bine ai venit, Nidarom!", SwingConstants.CENTER);
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
		JPanel panel9 = new JPanel();
		panel9.setBackground(new Color(51, 200, 255));
		JPanel panel10 = new JPanel();
		panel10.setBackground(new Color(51, 200, 255));
		JPanel panel11 = new JPanel();
		panel11.setBackground(new Color(51, 200, 255));
		JPanel panel12 = new JPanel();
		panel12.setBackground(new Color(51, 200, 255));
		JPanel panel13 = new JPanel();
		panel13.setBackground(new Color(51, 200, 255));
		JPanel panel14 = new JPanel();
		panel14.setBackground(new Color(51, 200, 255));
		JPanel panel15 = new JPanel();
		panel15.setBackground(new Color(51, 200, 255));
		JPanel panel16 = new JPanel();
		panel16.setBackground(new Color(51, 200, 255));
		JPanel panel17 = new JPanel();
		panel17.setBackground(new Color(51, 200, 255));

		vizStockBtn.setPreferredSize(new Dimension(400, 40));
		vizStockBtn.setFont(new Font("Serif", Font.BOLD, 16));
		panel2.add(vizStockBtn);
		vizFurnizorBtn.setPreferredSize(new Dimension(400, 40));
		vizFurnizorBtn.setFont(new Font("Serif", Font.BOLD, 16));
		panel3.add(vizFurnizorBtn);
		vizClientBtn.setPreferredSize(new Dimension(400, 40));
		vizClientBtn.setFont(new Font("Serif", Font.BOLD, 16));
		panel4.add(vizClientBtn);
		vizDelegatBtn.setPreferredSize(new Dimension(400, 40));
		vizDelegatBtn.setFont(new Font("Serif", Font.BOLD, 16));
		panel5.add(vizDelegatBtn);
		vizReceptieBtn.setPreferredSize(new Dimension(400, 40));
		vizReceptieBtn.setFont(new Font("Serif", Font.BOLD, 16));
		panel6.add(vizReceptieBtn);
		vizFacturaBtn.setPreferredSize(new Dimension(400, 40));
		vizFacturaBtn.setFont(new Font("Serif", Font.BOLD, 16));
		panel7.add(vizFacturaBtn);
		vizRegistruBtn.setPreferredSize(new Dimension(400, 40));
		vizRegistruBtn.setFont(new Font("Serif", Font.BOLD, 16));
		panel8.add(vizRegistruBtn);
		vizMonetarBtn.setPreferredSize(new Dimension(400, 40));
		vizMonetarBtn.setFont(new Font("Serif", Font.BOLD, 16));
		panel9.add(vizMonetarBtn);

		panel10.setLayout(new GridLayout(1, 2));
		panel10.add(panel2);
		panel10.add(panel6);

		panel11.setLayout(new GridLayout(1, 2));
		panel11.add(panel3);
		panel11.add(panel7);

		panel12.setLayout(new GridLayout(1, 2));
		panel12.add(panel4);
		panel12.add(panel8);

		panel13.setLayout(new GridLayout(1, 2));
		panel13.add(panel5);
		panel13.add(panel9);

		content.add(panel1);
		content.add(panel10);
		content.add(panel11);
		content.add(panel12);
		content.add(panel13);

		this.setContentPane(content);
		this.pack();
		this.setTitle("Rapoarte");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	void vizClientBtnListener(ActionListener listenerForClientBtn) {
		vizClientBtn.addActionListener(listenerForClientBtn);
	}

	void vizFurnizorBtnListener(ActionListener listenerForFurnizorBtn) {
		vizFurnizorBtn.addActionListener(listenerForFurnizorBtn);
	}

	void vizDelegatBtnListener(ActionListener listenerForDelegatBtn) {
		vizDelegatBtn.addActionListener(listenerForDelegatBtn);
	}

	void vizReceptieBtnListener(ActionListener listenerForReceptieBtn) {
		vizReceptieBtn.addActionListener(listenerForReceptieBtn);
	}

	void vizFacturaBtnListener(ActionListener listenerForFacturaBtn) {
		vizFacturaBtn.addActionListener(listenerForFacturaBtn);
	}

	void vizRegistruBtnListener(ActionListener listenerForRegistruBtn) {
		vizRegistruBtn.addActionListener(listenerForRegistruBtn);
	}

	void vizMonetarBtnListener(ActionListener listenerForMonetarBtn) {
		vizMonetarBtn.addActionListener(listenerForMonetarBtn);
	}

	void vizStockBtnListener(ActionListener listenerForStockBtn) {
		vizStockBtn.addActionListener(listenerForStockBtn);
	}
}
