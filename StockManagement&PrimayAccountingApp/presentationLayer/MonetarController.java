package presentationLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Monetar;

public class MonetarController {

	private MonetarView monetarView;
	private FirstPageView firstPageView;
	private FirstPageController firstPageController;

	public MonetarController(MonetarView view) {
		this.monetarView = view;
		this.firstPageView = new FirstPageView();
		this.firstPageController = new FirstPageController(firstPageView);

		monetarView.addMonetarListener(new MonetarListener());
		monetarView.resetBtnListener(new ResetBtnMListener());
		monetarView.backBtnListener(new BackBtnMListener());
	}

	class MonetarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int id = monetarView.getId();
			String data = monetarView.getData();
			Float total = monetarView.getTotal();
			int numar = monetarView.getNumar();

			if ((data.length() > 10) || (data.equals("")))
				JOptionPane.showMessageDialog(null, "Data necorespunzatoare!");
			else if (total == -1)
				JOptionPane.showMessageDialog(null, "Va rugam introduceti totalul!");
			else if (numar == -1)
				JOptionPane.showMessageDialog(null, "Va rugam introducetinumarul monetarului!");
			else {
				Monetar monetar = new Monetar(id, numar, data, total);
				firstPageController.getMonetarBL().insertMonetar(monetar);
				firstPageController.getMonetarBL().setMaxMonetarId(firstPageController.getMonetarBL().findMaxId());
				JOptionPane.showMessageDialog(null, "Monetar adaugat cu succes!");
				firstPageController.getMonetarBL().generateMonetar(monetar);
			}
		}
	}

	class ResetBtnMListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			monetarView.setNumar();
			monetarView.setData();
			monetarView.setTotal();
		}
	}

	class BackBtnMListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			monetarView.setVisible(false);
			firstPageView.setVisible(true);
		}
	}
}
