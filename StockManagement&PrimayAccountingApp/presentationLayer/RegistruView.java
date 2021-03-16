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

public class RegistruView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton addRegistruBtn = new JButton("Finalizare");
	private JButton resetBtn = new JButton("Reset");
	private JButton backBtn = new JButton("Back");
	private JButton addInregBtn = new JButton("Adauga");
	private JTextField idRegistru = new JTextField(12);
	private JTextField nrPozitie = new JTextField(13);
	private JTextField data = new JTextField(21);
	private JTextField soldInitial = new JTextField(16);
	private JTextField incasari = new JTextField(10);
	private JTextField plati = new JTextField(10);
	private JTextField soldFinal = new JTextField(17);
	private JTextField nrCrt = new JTextField(6);
	private JTextField explicatie = new JTextField(14);

	public RegistruView() {

		// Layout the components
		JPanel content = new JPanel();
		content.setBackground(new Color(51, 153, 255));
		content.setLayout(new GridLayout(9, 0));

		addRegistruBtn.setPreferredSize(new Dimension(130, 40));
		addRegistruBtn.setFont(new Font("Serif", Font.BOLD, 16));
		resetBtn.setPreferredSize(new Dimension(130, 40));
		resetBtn.setFont(new Font("Serif", Font.BOLD, 16));
		backBtn.setPreferredSize(new Dimension(130, 40));
		backBtn.setFont(new Font("Serif", Font.BOLD, 16));
		addInregBtn.setPreferredSize(new Dimension(130, 40));
		addInregBtn.setFont(new Font("Serif", Font.BOLD, 16));
		idRegistru.setEditable(false);

		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(51, 153, 255));
		JLabel label = new JLabel("Va rugam introduceti datele necesare: ", SwingConstants.CENTER);
		label.setFont(new Font("Serif", Font.BOLD, 24));
		panel1.add(label);

		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(51, 153, 255));
		panel2.setLayout(new FlowLayout());
		JLabel label1 = new JLabel("Id registru casa:", SwingConstants.CENTER);
		label1.setFont(new Font("Serif", Font.BOLD, 20));
		panel2.add(label1);
		panel2.add(idRegistru);

		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(51, 153, 255));
		panel3.setLayout(new FlowLayout());
		JLabel label2 = new JLabel("Numar pozitie:", SwingConstants.CENTER);
		label2.setFont(new Font("Serif", Font.BOLD, 20));
		panel3.add(label2);
		panel3.add(nrPozitie);

		JPanel panel4 = new JPanel();
		panel4.setBackground(new Color(51, 153, 255));
		panel4.setLayout(new FlowLayout());
		JLabel label3 = new JLabel("Data:", SwingConstants.CENTER);
		label3.setFont(new Font("Serif", Font.BOLD, 20));
		panel4.add(label3);
		panel4.add(data);

		JPanel panel5 = new JPanel();
		panel5.setBackground(new Color(51, 153, 255));
		panel5.setLayout(new FlowLayout());
		JLabel label4 = new JLabel("Sold initial:", SwingConstants.CENTER);
		label4.setFont(new Font("Serif", Font.BOLD, 20));
		panel5.add(label4);
		panel5.add(soldInitial);

		JPanel panel6 = new JPanel();
		panel6.setBackground(new Color(51, 153, 255));
		panel6.setLayout(new FlowLayout());
		JLabel label5 = new JLabel(
				"Nr. Crt      Explicatie         Incasari          Plati                                  ",
				SwingConstants.CENTER);
		label5.setFont(new Font("Serif", Font.BOLD, 20));
		panel6.add(label5);

		JPanel panel7 = new JPanel();
		panel7.setBackground(new Color(51, 153, 255));
		panel7.setLayout(new FlowLayout());
		panel7.add(nrCrt);
		panel7.add(explicatie);
		panel7.add(incasari);
		panel7.add(plati);
		panel7.add(addInregBtn);

		JPanel panel8 = new JPanel();
		panel8.setBackground(new Color(51, 153, 255));
		panel8.setLayout(new FlowLayout());
		JLabel label9 = new JLabel("Sold final:", SwingConstants.CENTER);
		label9.setFont(new Font("Serif", Font.BOLD, 20));
		panel8.add(label9);
		panel8.add(soldFinal);

		JPanel panel10 = new JPanel();
		panel10.setBackground(new Color(51, 153, 255));
		panel10.setLayout(new FlowLayout());
		panel10.add(addRegistruBtn);
		panel10.add(resetBtn);
		panel10.add(backBtn);

		content.add(panel1);
		content.add(panel2);
		content.add(panel3);
		content.add(panel4);
		content.add(panel5);
		content.add(panel6);
		content.add(panel7);
		content.add(panel8);
		content.add(panel10);

		this.setContentPane(content);
		this.pack();
		this.setTitle("Registru Casa");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public void setIdRegistru(int id) {
		this.idRegistru.setText("" + id);
	}

	public int getIdReg() {
		return Integer.valueOf(idRegistru.getText());
	}

	public void setNrPozitie(int id) {
		this.nrPozitie.setText("" + id);
	}

	public int getNrPozitie() {
		return Integer.valueOf(nrPozitie.getText());
	}

	public void setData() {
		this.data.setText("");
	}

	public String getData() {
		return data.getText();
	}

	public void setSoldInitial(float soldI) {
		this.soldInitial.setText(soldI + "");
	}

	public Float getSoldInitial() {
		return Float.valueOf(soldInitial.getText());
	}

	public void setNrCriteriu(int nr) {
		this.nrCrt.setText("" + nr);
	}

	public int getNrCriteriu() {
		return Integer.valueOf(nrCrt.getText());
	}

	public void setExplicatie() {
		this.explicatie.setText("");
	}

	public String getExplicatie() {
		return explicatie.getText();
	}

	public void setIncasari() {
		this.incasari.setText(0 + "");
	}

	public Float getIncasari() {
		return Float.valueOf(incasari.getText());
	}

	public void setPlati() {
		this.plati.setText(0 + "");
	}

	public Float getPlati() {
		return Float.valueOf(plati.getText());
	}

	public void setSoldFinal(float soldF) {
		this.soldFinal.setText(soldF + "");
	}

	public Float getSoldFinal() {
		return Float.valueOf(soldFinal.getText());
	}

	public void addRegistruListener(ActionListener listenForRegistru) {
		addRegistruBtn.addActionListener(listenForRegistru);
	}

	public void resetBtnListener(ActionListener listenForReset) {
		resetBtn.addActionListener(listenForReset);
	}

	public void backBtnListener(ActionListener listenForBack) {
		backBtn.addActionListener(listenForBack);
	}

	public void addInregListener(ActionListener listenForInreg) {
		addInregBtn.addActionListener(listenForInreg);
	}
}
