package presentationLayer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AddProdusView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton addProdusBtn = new JButton("Finalizare");
	private JButton resetBtn = new JButton("Resetare");
	private JButton backBtn = new JButton("Back");
	private JButton calculateBtn = new JButton("Calculeaza");
	private JTextField idProdus = new JTextField(12);
	private JTextField denumire = new JTextField(12);
	private JTextField um = new JTextField(5);
	private JTextField cantitate = new JTextField(13);
	private JTextField procent = new JTextField(14);
	private JTextField pretFaraTVA = new JTextField(9);
	private JTextField pretVanzare = new JTextField(10);

	public AddProdusView() {
		// Layout the components
		JPanel content = new JPanel();
		content.setBackground(new Color(51, 153, 255));
		content.setLayout(new GridLayout(9, 0));

		addProdusBtn.setPreferredSize(new Dimension(200, 40));
		addProdusBtn.setFont(new Font("Serif", Font.BOLD, 16));
		resetBtn.setPreferredSize(new Dimension(200, 40));
		resetBtn.setFont(new Font("Serif", Font.BOLD, 16));
		backBtn.setPreferredSize(new Dimension(200, 40));
		backBtn.setFont(new Font("Serif", Font.BOLD, 16));
		calculateBtn.setPreferredSize(new Dimension(200, 40));
		calculateBtn.setFont(new Font("Serif", Font.BOLD, 16));
		idProdus.setEditable(false);

		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(51, 153, 255));
		JLabel label = new JLabel("Va rugam introduceti detaliile produsului: ", SwingConstants.CENTER);
		label.setFont(new Font("Serif", Font.BOLD, 24));
		panel1.add(label);

		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(51, 153, 255));
		panel2.setLayout(new FlowLayout());
		JLabel label1 = new JLabel("Id produs:", SwingConstants.CENTER);
		label1.setFont(new Font("Serif", Font.BOLD, 20));
		panel2.add(label1);
		panel2.add(idProdus);

		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(51, 153, 255));
		panel3.setLayout(new FlowLayout());
		JLabel label2 = new JLabel("Denumire:", SwingConstants.CENTER);
		label2.setFont(new Font("Serif", Font.BOLD, 20));
		panel3.add(label2);
		panel3.add(denumire);

		JPanel panel4 = new JPanel();
		panel4.setBackground(new Color(51, 153, 255));
		panel4.setLayout(new FlowLayout());
		JLabel label3 = new JLabel("Unitate de masura:", SwingConstants.CENTER);
		label3.setFont(new Font("Serif", Font.BOLD, 20));
		panel4.add(label3);
		panel4.add(um);

		JPanel panel5 = new JPanel();
		panel5.setBackground(new Color(51, 153, 255));
		panel5.setLayout(new FlowLayout());
		JLabel label4 = new JLabel("Cantitate:", SwingConstants.CENTER);
		label4.setFont(new Font("Serif", Font.BOLD, 20));
		panel5.add(label4);
		panel5.add(cantitate);

		JPanel panel6 = new JPanel();
		panel6.setBackground(new Color(51, 153, 255));
		panel6.setLayout(new FlowLayout());
		JLabel label5 = new JLabel("Procent:", SwingConstants.CENTER);
		label5.setFont(new Font("Serif", Font.BOLD, 20));
		panel6.add(label5);
		panel6.add(procent);

		JPanel panel7 = new JPanel();
		panel7.setBackground(new Color(51, 153, 255));
		panel7.setLayout(new FlowLayout());
		JLabel label6 = new JLabel("Pret fara TVA:", SwingConstants.CENTER);
		label6.setFont(new Font("Serif", Font.BOLD, 20));
		panel7.add(label6);
		panel7.add(pretFaraTVA);

		JPanel panel8 = new JPanel();
		panel8.setBackground(new Color(51, 153, 255));
		panel8.setLayout(new FlowLayout());
		JLabel label7 = new JLabel("Pret vanzare:", SwingConstants.CENTER);
		label7.setFont(new Font("Serif", Font.BOLD, 20));
		panel8.add(label7);
		panel8.add(pretVanzare);
		panel8.add(calculateBtn);

		JPanel panel9 = new JPanel();
		panel9.setBackground(new Color(51, 153, 255));
		panel9.setLayout(new FlowLayout());
		panel9.add(addProdusBtn);
		panel9.add(resetBtn);
		panel9.add(backBtn);

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
		this.setTitle("Adaugare Produs");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	// getters and setters

	public void setId(int id) {
		this.idProdus.setText("" + id);
	}

	public int getId() {
		return Integer.valueOf(this.idProdus.getText());
	}

	public void setDenumire() {
		this.denumire.setText("");
	}

	public String getDenumire() {
		return this.denumire.getText();
	}

	public void setUm(String um) {
		this.um.setText("" + um);
	}

	public String getUm() {
		return this.um.getText();
	}

	public void setCantitate() {
		this.cantitate.setText("");
	}

	public int getCantitate() {
		if (this.cantitate.getText().equals(""))
			return -1;
		else
			return Integer.valueOf(this.cantitate.getText());
	}

	public void setProcent(int pr) {
		this.procent.setText("" + pr);
	}

	public int getProcent() {
		if (this.procent.getText().equals(""))
			return -1;
		else
			return Integer.valueOf(this.procent.getText());
	}

	public void setPretFaraTVA() {
		this.pretFaraTVA.setText("");
	}

	public float getPretFaraTVA() {
		if (this.pretFaraTVA.getText().equals(""))
			return -1;
		else
			return Float.valueOf(this.pretFaraTVA.getText());
	}

	public void setPretVanzare(float pret) {
		this.pretVanzare.setText("" + pret);
	}

	public float getPretVanzare() {
		if (this.pretVanzare.getText().equals(""))
			return -1;
		else
			return Float.valueOf(this.pretVanzare.getText());
	}

	public void addProdusBtnListener(ActionListener listenForAddProdus) {
		addProdusBtn.addActionListener(listenForAddProdus);
	}

	public void resetBtnListener(ActionListener listenForResetBtn) {
		resetBtn.addActionListener(listenForResetBtn);
	}

	public void backBtnListener(ActionListener listenForBackBtn) {
		backBtn.addActionListener(listenForBackBtn);
	}

	public void calculateBtnListener(ActionListener listenForCalculateBtn) {
		calculateBtn.addActionListener(listenForCalculateBtn);
	}
}
