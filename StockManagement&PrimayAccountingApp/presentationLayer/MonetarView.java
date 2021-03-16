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

public class MonetarView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton addMonetarBtn = new JButton("Finalizare");
	private JButton resetBtn = new JButton("Reset");
	private JButton backBtn = new JButton("Back");
	private JTextField idMonetar = new JTextField(10);
	private JTextField numar = new JTextField(13);
	private JTextField data = new JTextField(14);
	private JTextField total = new JTextField(12);

	public MonetarView() {

		// Layout the components
		JPanel content = new JPanel();
		content.setBackground(new Color(51, 153, 255));
		content.setLayout(new GridLayout(7, 0));

		addMonetarBtn.setPreferredSize(new Dimension(130, 40));
		addMonetarBtn.setFont(new Font("Serif", Font.BOLD, 16));
		resetBtn.setPreferredSize(new Dimension(130, 40));
		resetBtn.setFont(new Font("Serif", Font.BOLD, 16));
		backBtn.setPreferredSize(new Dimension(130, 40));
		backBtn.setFont(new Font("Serif", Font.BOLD, 16));
		idMonetar.setEditable(false);

		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(51, 153, 255));
		JLabel label = new JLabel("Va rugam introduceti datele necesare: ", SwingConstants.CENTER);
		label.setFont(new Font("Serif", Font.BOLD, 24));
		panel1.add(label);

		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(51, 153, 255));
		panel2.setLayout(new FlowLayout());
		JLabel label1 = new JLabel("Id monetar:", SwingConstants.CENTER);
		label1.setFont(new Font("Serif", Font.BOLD, 20));
		panel2.add(label1);
		panel2.add(idMonetar);

		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(51, 153, 255));
		panel3.setLayout(new FlowLayout());
		JLabel label2 = new JLabel("Numar monetar:", SwingConstants.CENTER);
		label2.setFont(new Font("Serif", Font.BOLD, 20));
		panel3.add(label2);
		panel3.add(numar);

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
		JLabel label4 = new JLabel("Total:", SwingConstants.CENTER);
		label4.setFont(new Font("Serif", Font.BOLD, 20));
		panel5.add(label4);
		panel5.add(total);

		JPanel panel6 = new JPanel();
		panel6.setBackground(new Color(51, 153, 255));
		panel6.setLayout(new FlowLayout());
		panel6.add(addMonetarBtn);
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
		this.setTitle("Monetar");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public int getId() {
		return Integer.valueOf(idMonetar.getText());
	}

	public void setId(int id) {
		idMonetar.setText("" + id);
	}

	public int getNumar() {
		if (numar.getText().equals(""))
			return -1;
		return Integer.valueOf(numar.getText());
	}

	public void setNumar() {
		numar.setText("");
	}

	public String getData() {
		return data.getText();
	}

	public void setData() {
		data.setText("");
	}

	public float getTotal() {
		if (total.getText().equals(""))
			return -1;
		return Float.valueOf(total.getText());
	}

	public void setTotal() {
		total.setText("");
	}

	public void addMonetarListener(ActionListener listenForMonetar) {
		addMonetarBtn.addActionListener(listenForMonetar);
	}

	public void resetBtnListener(ActionListener listenForReset) {
		resetBtn.addActionListener(listenForReset);
	}

	public void backBtnListener(ActionListener listenForBack) {
		backBtn.addActionListener(listenForBack);
	}
}
