package presentationLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import businessLayer.UtilizatorBL;
import model.Utilizator;

public class InitPageController {

	private InitPageView initPageView;

	public InitPageController(InitPageView view) {
		this.initPageView = view;

		this.initPageView.logInBtnListener(new LogInListener());
	}

	class LogInListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String id = initPageView.getId();
			String password = initPageView.getPassword();

			Utilizator user = new UtilizatorBL().findByIdName(id);
			if (user == null) {
				JOptionPane.showMessageDialog(null, "ID INCORECT!");
			} else {
				if (user.getParola().equals(password)) {
					if (user.getAdministrator() == 1) {
						FirstPageView view = new FirstPageView();
						FirstPageController controller = new FirstPageController(view);
						initPageView.setVisible(false);
						view.setVisible(true);
					} else {
						FirstPageUView view = new FirstPageUView();
						FirstPageUController controller = new FirstPageUController(view);
						initPageView.setVisible(false);
						view.setVisible(true);
					}
				} else {
					JOptionPane.showMessageDialog(null, "PAROLA INCORECT!");
				}
			}
		}

	}
}
