package presentationLayer;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import businessLayer.Restaurant;

public class ChefView extends JFrame implements Observer {
	private Restaurant restaurant;

	public ChefView(Restaurant restaurant) {

		this.restaurant = restaurant;
		restaurant.addObserver(this);

		JPanel content = new JPanel();
		content.add(new JLabel("Welcome!", SwingConstants.CENTER));
		this.setContentPane(content);
		this.pack();
		this.setTitle("Chef View");
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		this.setVisible(true);
		int x = JOptionPane.showConfirmDialog(null, arg, "Notification !", 2);
		this.setVisible(false);
		restaurant.deleteObserver(this);
	}

}
