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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InitPageView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField idTextField = new JTextField(25);
	private JPasswordField passwordTextField = new JPasswordField(21);
	private JButton logInBtn = new JButton("LOGIN");

	public InitPageView() {
		// Layout the components
		JPanel content = new JPanel();
		content.setBackground(new Color(51, 153, 255));
		content.setLayout(new GridLayout(4, 0));

		// Set welcoming message panel
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(51, 153, 255));
		panel1.setLayout(new GridLayout(2, 0));

		JLabel label = new JLabel("Bine ai venit!", SwingConstants.CENTER);
		label.setFont(new Font("Serif", Font.BOLD, 24));
		panel1.add(label);

		// Set buttons panels
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(51, 153, 255));
		panel2.setLayout(new FlowLayout());
		JLabel label1 = new JLabel("ID:", SwingConstants.CENTER);
		label1.setFont(new Font("Serif", Font.BOLD, 24));
		panel2.add(label1);
		panel2.add(idTextField);

		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(51, 153, 255));
		panel3.setLayout(new FlowLayout());
		JLabel label2 = new JLabel("Parola:", SwingConstants.CENTER);
		label2.setFont(new Font("Serif", Font.BOLD, 24));
		panel3.add(label2);
		panel3.add(passwordTextField);
		passwordTextField.setEchoChar('*');

		JPanel panel4 = new JPanel();
		panel4.setBackground(new Color(51, 153, 255));
		panel4.add(logInBtn);
		logInBtn.setPreferredSize(new Dimension(400, 40));

		content.add(panel1);
		content.add(panel2);
		content.add(panel3);
		content.add(panel4);

		this.setContentPane(content);
		this.pack();
		this.setTitle("STOCK APP");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	// getters and setters
	public void setId(String id) {
		this.idTextField.setText(id);
	}

	public String getId() {
		return this.idTextField.getText();
	}

	public void setPassword(String password) {
		this.passwordTextField.setText(password);
	}

	public String getPassword() {
		return String.copyValueOf(this.passwordTextField.getPassword());
	}

	/**
	 * adds action listener for the "login" button, notifies the controller when the
	 * button is clicked
	 * 
	 * @param listenForAdminBtn
	 */
	void logInBtnListener(ActionListener listenerForBtn) {
		logInBtn.addActionListener(listenerForBtn);
	}
}
