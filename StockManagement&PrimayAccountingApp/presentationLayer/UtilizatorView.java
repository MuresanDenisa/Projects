package presentationLayer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import businessLayer.UtilizatorBL;
import model.Utilizator;

public class UtilizatorView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton addUserBtn = new JButton("Adauga Utilizator");
	private JTextField idUtilizator = new JTextField(14);
	private JTextField id = new JTextField(23);
	private JTextField nume = new JTextField(20);
	private JPasswordField pw1 = new JPasswordField(20);
	private JPasswordField pw2 = new JPasswordField(20);
	private JComboBox<String> roleJComboBox = new JComboBox<String>();

	public UtilizatorView() {

		JPanel content = new JPanel();
		content.setBackground(new Color(51, 153, 255));
		content.setLayout(new GridLayout(8, 0));

		addUserBtn.setPreferredSize(new Dimension(200, 40));
		addUserBtn.setFont(new Font("Serif", Font.BOLD, 16));
		idUtilizator.setEditable(false);

		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(51, 153, 255));
		JLabel label = new JLabel("Va rugam introduceti detaliile utilizatorului: ", SwingConstants.CENTER);
		label.setFont(new Font("Serif", Font.BOLD, 24));
		panel1.add(label);

		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(51, 153, 255));
		panel2.setLayout(new FlowLayout());
		JLabel label1 = new JLabel("Id utilizator:", SwingConstants.CENTER);
		label1.setFont(new Font("Serif", Font.BOLD, 20));
		panel2.add(label1);
		panel2.add(idUtilizator);

		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(51, 153, 255));
		panel3.setLayout(new FlowLayout());
		JLabel label2 = new JLabel("Id:", SwingConstants.CENTER);
		label2.setFont(new Font("Serif", Font.BOLD, 20));
		panel3.add(label2);
		panel3.add(id);

		JPanel panel4 = new JPanel();
		panel4.setBackground(new Color(51, 153, 255));
		panel4.setLayout(new FlowLayout());
		JLabel label3 = new JLabel("Nume:", SwingConstants.CENTER);
		label3.setFont(new Font("Serif", Font.BOLD, 20));
		panel4.add(label3);
		panel4.add(nume);

		JPanel panel5 = new JPanel();
		panel5.setBackground(new Color(51, 153, 255));
		panel5.setLayout(new FlowLayout());
		JLabel label4 = new JLabel("Parola", SwingConstants.CENTER);
		label4.setFont(new Font("Serif", Font.BOLD, 20));
		panel5.add(label4);
		panel5.add(pw1);

		JPanel panel6 = new JPanel();
		panel6.setBackground(new Color(51, 153, 255));
		panel6.setLayout(new FlowLayout());
		JLabel label5 = new JLabel("Parola:", SwingConstants.CENTER);
		label5.setFont(new Font("Serif", Font.BOLD, 20));
		panel6.add(label5);
		panel6.add(pw2);

		JPanel panel7 = new JPanel();
		panel7.setBackground(new Color(51, 153, 255));
		panel7.setLayout(new FlowLayout());
		roleJComboBox.addItem("Administrator");
		roleJComboBox.addItem("Angajat");
		panel7.add(roleJComboBox);

		JPanel panel8 = new JPanel();
		panel8.setBackground(new Color(51, 153, 255));
		panel8.setLayout(new FlowLayout());
		panel8.add(addUserBtn);
		addUserBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				int idUtilizator = getIdUtilizator();
				String idName = getId();
				String nume = getNume();
				String passw1 = getPassword1();
				String passw2 = getPassword2();
				String s = (String) roleJComboBox.getSelectedItem();

				if (!passw1.equals(passw2))
					JOptionPane.showMessageDialog(null, "Parole diferite");
				else {
					if (s.equals("Administrator")) {
						Utilizator utilizator = new Utilizator(idUtilizator, idName, nume, passw1, 1);
						new UtilizatorBL().insert(utilizator);
						new UtilizatorBL().setMaxUtilizatorId(new UtilizatorBL().findMaxId());
						JOptionPane.showMessageDialog(null, "Furnizor adaugat cu succes!");
					} else if (s.equals("Angajat")) {
						Utilizator utilizator = new Utilizator(idUtilizator, idName, nume, passw1, 0);
						new UtilizatorBL().insert(utilizator);
						new UtilizatorBL().setMaxUtilizatorId(new UtilizatorBL().findMaxId());
						JOptionPane.showMessageDialog(null, "Furnizor adaugat cu succes!");
					}
				}
			}

		});

		content.add(panel1);
		content.add(panel2);
		content.add(panel3);
		content.add(panel4);
		content.add(panel5);
		content.add(panel6);
		content.add(panel7);
		content.add(panel8);

		this.setContentPane(content);
		this.pack();
		this.setTitle("Adaugare Utilizator");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public void setIdUtilizator(int id) {
		this.idUtilizator.setText("" + id);
	}

	public int getIdUtilizator() {
		return Integer.valueOf(this.idUtilizator.getText());
	}

	public void setId(String id) {
		this.id.setText(id);
	}

	public String getId() {
		return this.id.getText();
	}

	public void setNume(String name) {
		this.nume.setText(name);
	}

	public String getNume() {
		return this.nume.getText();
	}

	public String getPassword1() {
		return String.copyValueOf(this.pw1.getPassword());
	}

	public void setPassword1() {
		this.pw1.setText("");
	}

	public String getPassword2() {
		return String.copyValueOf(this.pw2.getPassword());
	}

	public void setPassword2() {
		this.pw2.setText("");
	}

}
