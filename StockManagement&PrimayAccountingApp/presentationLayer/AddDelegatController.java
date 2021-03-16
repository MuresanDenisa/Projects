package presentationLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Delegat;

public class AddDelegatController {

	private AddDelegatView addDelegatView;
	private FirstPageView firstPageView;
	private FirstPageController firstPageController;

	public AddDelegatController(AddDelegatView view) {
		this.addDelegatView = view;
		this.firstPageView = new FirstPageView();
		this.firstPageController = new FirstPageController(firstPageView);

		addDelegatView.addDelegatListener(new DelegatListener());
		addDelegatView.resetBtnListener(new ResetBtnDListener());
		addDelegatView.backBtnListener(new BackBtnDListener());
	}

	class DelegatListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int id = addDelegatView.getId();
			String nume = addDelegatView.getNume();
			String serie = addDelegatView.getSerie();
			String numar = addDelegatView.getNumar();

			if ((nume.length() > 50) || (nume.equals("")))
				JOptionPane.showMessageDialog(null, "Nume necorespunzator!");
			else if ((serie.length() > 3) || (serie.equals("")))
				JOptionPane.showMessageDialog(null, "Serie necorespunzatoare!");
			else if ((numar.length() > 6) || (numar.equals("")))
				JOptionPane.showMessageDialog(null, "Numar necorespunzator!");
			else {
				Delegat delegat = new Delegat(id, nume, serie, numar);
				firstPageController.getDelegatBL().insertDelegat(delegat);
				firstPageController.getDelegatBL().setMaxDelegatId(firstPageController.getDelegatBL().findMaxId());
				JOptionPane.showMessageDialog(null, "Delegat adaugat cu succes!");
			}
		}

	}

	class ResetBtnDListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			addDelegatView.setNumar();
			addDelegatView.setNume();
			addDelegatView.setSerie();

		}

	}

	class BackBtnDListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			addDelegatView.setVisible(false);
			firstPageView.setVisible(true);
		}

	}
}
