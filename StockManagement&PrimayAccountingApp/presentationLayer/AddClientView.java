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

public class AddClientView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton addClientBtn = new JButton("Finalizare");
	private JButton resetBtn = new JButton("Resetare");
	private JButton backBtn = new JButton("Back");
	private JTextField idClient = new JTextField(14);
	private JTextField denumire = new JTextField(16);
	private JTextField regCom = new JTextField(13);
	private JTextField cif = new JTextField(19);
	private JTextField capital = new JTextField(15);
	private JTextField sediu = new JTextField(16);
	private JTextField judet = new JTextField(15);
	private JTextField iban = new JTextField(14);
	private JTextField banca = new JTextField(17);

	public AddClientView() {
		// Layout the components
		JPanel content = new JPanel();
		content.setBackground(new Color(51, 153, 255));
		content.setLayout(new GridLayout(11, 0));

		addClientBtn.setPreferredSize(new Dimension(200, 40));
		addClientBtn.setFont(new Font("Serif", Font.BOLD, 16));
		resetBtn.setPreferredSize(new Dimension(200, 40));
		resetBtn.setFont(new Font("Serif", Font.BOLD, 16));
		backBtn.setPreferredSize(new Dimension(200, 40));
		backBtn.setFont(new Font("Serif", Font.BOLD, 16));
		idClient.setEditable(false);

		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(51, 153, 255));
		JLabel label = new JLabel("Va rugam introduceti detaliile clienutlui: ", SwingConstants.CENTER);
		label.setFont(new Font("Serif", Font.BOLD, 24));
		panel1.add(label);

		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(51, 153, 255));
		panel2.setLayout(new FlowLayout());
		JLabel label1 = new JLabel("Id client:", SwingConstants.CENTER);
		label1.setFont(new Font("Serif", Font.BOLD, 20));
		panel2.add(label1);
		panel2.add(idClient);

		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(51, 153, 255));
		panel3.setLayout(new FlowLayout());
		JLabel label2 = new JLabel("Client:", SwingConstants.CENTER);
		label2.setFont(new Font("Serif", Font.BOLD, 20));
		panel3.add(label2);
		panel3.add(denumire);

		JPanel panel4 = new JPanel();
		panel4.setBackground(new Color(51, 153, 255));
		panel4.setLayout(new FlowLayout());
		JLabel label3 = new JLabel("Reg. com.:", SwingConstants.CENTER);
		label3.setFont(new Font("Serif", Font.BOLD, 20));
		panel4.add(label3);
		panel4.add(regCom);

		JPanel panel5 = new JPanel();
		panel5.setBackground(new Color(51, 153, 255));
		panel5.setLayout(new FlowLayout());
		JLabel label4 = new JLabel("Cif:", SwingConstants.CENTER);
		label4.setFont(new Font("Serif", Font.BOLD, 20));
		panel5.add(label4);
		panel5.add(cif);

		JPanel panel6 = new JPanel();
		panel6.setBackground(new Color(51, 153, 255));
		panel6.setLayout(new FlowLayout());
		JLabel label5 = new JLabel("Capital:", SwingConstants.CENTER);
		label5.setFont(new Font("Serif", Font.BOLD, 20));
		panel6.add(label5);
		panel6.add(capital);

		JPanel panel7 = new JPanel();
		panel7.setBackground(new Color(51, 153, 255));
		panel7.setLayout(new FlowLayout());
		JLabel label6 = new JLabel("Sediul:", SwingConstants.CENTER);
		label6.setFont(new Font("Serif", Font.BOLD, 20));
		panel7.add(label6);
		panel7.add(sediu);

		JPanel panel8 = new JPanel();
		panel8.setBackground(new Color(51, 153, 255));
		panel8.setLayout(new FlowLayout());
		JLabel label7 = new JLabel("Judetul:", SwingConstants.CENTER);
		label7.setFont(new Font("Serif", Font.BOLD, 20));
		panel8.add(label7);
		panel8.add(judet);

		JPanel panel9 = new JPanel();
		panel9.setBackground(new Color(51, 153, 255));
		panel9.setLayout(new FlowLayout());
		JLabel label8 = new JLabel("Cod iban:", SwingConstants.CENTER);
		label8.setFont(new Font("Serif", Font.BOLD, 20));
		panel9.add(label8);
		panel9.add(iban);

		JPanel panel10 = new JPanel();
		panel10.setBackground(new Color(51, 153, 255));
		panel10.setLayout(new FlowLayout());
		JLabel label9 = new JLabel("Banca:", SwingConstants.CENTER);
		label9.setFont(new Font("Serif", Font.BOLD, 20));
		panel10.add(label9);
		panel10.add(banca);

		JPanel panel11 = new JPanel();
		panel11.setBackground(new Color(51, 153, 255));
		panel11.setLayout(new FlowLayout());
		panel11.add(addClientBtn);
		panel11.add(resetBtn);
		panel11.add(backBtn);

		content.add(panel1);
		content.add(panel2);
		content.add(panel3);
		content.add(panel4);
		content.add(panel5);
		content.add(panel6);
		content.add(panel7);
		content.add(panel8);
		content.add(panel9);
		content.add(panel10);
		content.add(panel11);

		this.setContentPane(content);
		this.pack();
		this.setTitle("Adaugare Client");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	// getters and setters

	public void setId(int id) {
		this.idClient.setText("" + id);
	}

	public int getId() {
		return Integer.valueOf(this.idClient.getText());
	}

	public void setDenumire() {
		this.denumire.setText("");
	}

	public String getDenumire() {
		return this.denumire.getText();
	}

	public void setRegCom() {
		this.regCom.setText("");
	}

	public String getRegCom() {
		return this.regCom.getText();
	}

	public void setCif() {
		this.cif.setText("");
	}

	public String getCif() {
		return this.cif.getText();
	}

	public void setCapital() {
		this.capital.setText("");
	}

	public String getCapital() {
		return this.capital.getText();
	}

	public void setSediu() {
		this.sediu.setText("");
	}

	public String getSediu() {
		return this.sediu.getText();
	}

	public void setJudet() {
		this.judet.setText("");
	}

	public String getJudet() {
		return this.judet.getText();
	}

	public void setIban() {
		this.iban.setText("");
	}

	public String getIban() {
		return this.iban.getText();
	}

	public void setBanca() {
		this.banca.setText("");
	}

	public String getBanca() {
		return this.banca.getText();
	}

	public void addClientListener(ActionListener listenForClient) {
		addClientBtn.addActionListener(listenForClient);
	}

	public void resetBtnListener(ActionListener listenForReset) {
		resetBtn.addActionListener(listenForReset);
	}

	public void backBtnListener(ActionListener listenForBack) {
		backBtn.addActionListener(listenForBack);
	}
}