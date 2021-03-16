package presentationLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Produs;

public class AddProdusController {

	private AddProdusView addProdusView;
	private FirstPageView firstPageView;
	private FirstPageController firstPageController;

	public AddProdusController(AddProdusView view) {
		this.addProdusView = view;
		this.firstPageView = new FirstPageView();
		this.firstPageController = new FirstPageController(firstPageView);

		this.addProdusView.addProdusBtnListener(new ProdusListener());
		this.addProdusView.resetBtnListener(new ResetProdus());
		this.addProdusView.backBtnListener(new BackBtnListener());
		this.addProdusView.calculateBtnListener(new CalculateBtnListener());
	}

	class ProdusListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int id = addProdusView.getId();
			String denumire = addProdusView.getDenumire();
			String um = addProdusView.getUm();
			int cantitate = addProdusView.getCantitate();
			int procent = addProdusView.getProcent();
			float pret_fara_TVA = addProdusView.getPretFaraTVA();
			float pretVanzare = addProdusView.getPretVanzare();

			if ((denumire.length() > 30) || (denumire.equals("")))
				JOptionPane.showMessageDialog(null, "Denumire produs necorespunzatoare!");
			else if ((um.length() > 5) || (denumire.equals("")))
				JOptionPane.showMessageDialog(null, "Unitate de masura necorespunzatoare!");
			else if (cantitate == -1)
				JOptionPane.showMessageDialog(null, "Va rugam introduceti cantitatea!");
			else if (procent == -1)
				JOptionPane.showMessageDialog(null, "Va rugam adaugati procentul adaosului!");
			else if (pret_fara_TVA == -1)
				JOptionPane.showMessageDialog(null, "Va rugam adaugati pretul de cumparare!");
			else if (pretVanzare == -1)
				JOptionPane.showMessageDialog(null, "Va rugam adaugati pretul de vanzare!");
			else {
				Produs produs = new Produs(id, denumire, um, cantitate, procent, pret_fara_TVA, pretVanzare);
				firstPageController.getProdusBL().InsertProduct(produs);
				firstPageController.getProdusBL().setMaxProdusId(firstPageController.getProdusBL().findMaxId());
				JOptionPane.showMessageDialog(null, "Produs adaugat cu succes!");
			}
		}

	}

	class ResetProdus implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			addProdusView.setDenumire();
			addProdusView.setUm("BUC");
			addProdusView.setCantitate();
			addProdusView.setProcent(15);
			addProdusView.setPretFaraTVA();
			addProdusView.setPretVanzare(0);

		}

	}

	class CalculateBtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			float pret = addProdusView.getPretFaraTVA();
			int procent = addProdusView.getProcent();
			float pretVanzare = ((pret * (procent + 100)) / 100) * 119 / 100;
			addProdusView.setPretVanzare(pretVanzare);
		}

	}

	class BackBtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			addProdusView.setVisible(false);
			firstPageView.setVisible(true);
		}

	}
}
