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

public class AddDelegatView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton addDelegatBtn = new JButton("Finalizare");
	private JButton resetBtn = new JButton("Reset");
	private JButton backBtn = new JButton("Back");
	private JTextField idDelegat = new JTextField(10);
	private JTextField nume = new JTextField(13);
	private JTextField serie = new JTextField(14);
	private JTextField numar = new JTextField(12);

	public AddDelegatView() {

		// Layout the components
		JPanel content = new JPanel();
		content.setBackground(new Color(51, 153, 255));
		content.setLayout(new GridLayout(7, 0));

		addDelegatBtn.setPreferredSize(new Dimension(130, 40));
		addDelegatBtn.setFont(new Font("Serif", Font.BOLD, 16));
		resetBtn.setPreferredSize(new Dimension(130, 40));
		resetBtn.setFont(new Font("Serif", Font.BOLD, 16));
		backBtn.setPreferredSize(new Dimension(130, 40));
		backBtn.setFont(new Font("Serif", Font.BOLD, 16));
		idDelegat.setEditable(false);

		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(51, 153, 255));
		JLabel label = new JLabel("Va rugam introduceti detaliile delegatului: ", SwingConstants.CENTER);
		label.setFont(new Font("Serif", Font.BOLD, 24));
		panel1.add(label);

		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(51, 153, 255));
		panel2.setLayout(new FlowLayout());
		JLabel label1 = new JLabel("Id delegat:", SwingConstants.CENTER);
		label1.setFont(new Font("Serif", Font.BOLD, 20));
		panel2.add(label1);
		panel2.add(idDelegat);

		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(51, 153, 255));
		panel3.setLayout(new FlowLayout());
		JLabel label2 = new JLabel("Nume:", SwingConstants.CENTER);
		label2.setFont(new Font("Serif", Font.BOLD, 20));
		panel3.add(label2);
		panel3.add(nume);

		JPanel panel4 = new JPanel();
		panel4.setBackground(new Color(51, 153, 255));
		panel4.setLayout(new FlowLayout());
		JLabel label3 = new JLabel("Serie:", SwingConstants.CENTER);
		label3.setFont(new Font("Serif", Font.BOLD, 20));
		panel4.add(label3);
		panel4.add(serie);

		JPanel panel5 = new JPanel();
		panel5.setBackground(new Color(51, 153, 255));
		panel5.setLayout(new FlowLayout());
		JLabel label4 = new JLabel("Numar:", SwingConstants.CENTER);
		label4.setFont(new Font("Serif", Font.BOLD, 20));
		panel5.add(label4);
		panel5.add(numar);

		JPanel panel6 = new JPanel();
		panel6.setBackground(new Color(51, 153, 255));
		panel6.setLayout(new FlowLayout());
		panel6.add(addDelegatBtn);
		panel6.add(resetBtn);
		panel6.add(backBtn);

		content.add(panel1);
		content.add(panel2);
		content.add(panel3);
		content.add(panel4);
		content.add(panel5);
		content.add(panel6);

		this.setContentPane(content);
		this.pack();
		this.setTitle("Adaugare Delegat");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public int getId() {
		return Integer.valueOf(idDelegat.getText());
	}

	public void setId(int id) {
		idDelegat.setText("" + id);
	}

	public String getNume() {
		return nume.getText();
	}

	public void setNume() {
		nume.setText("");
	}

	public String getSerie() {
		return serie.getText();
	}

	public void setSerie() {
		serie.setText("");
	}

	public String getNumar() {
		return numar.getText();
	}

	public void setNumar() {
		numar.setText("");
	}

	public void addDelegatListener(ActionListener listenForDelegat) {
		addDelegatBtn.addActionListener(listenForDelegat);
	}

	public void resetBtnListener(ActionListener listenForReset) {
		resetBtn.addActionListener(listenForReset);
	}

	public void backBtnListener(ActionListener listenForBack) {
		backBtn.addActionListener(listenForBack);
	}
}
