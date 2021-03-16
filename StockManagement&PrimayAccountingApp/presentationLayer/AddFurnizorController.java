package presentationLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Furnizor;

public class AddFurnizorController {

	private AddFurnizorView addFurnizorView;
	private FirstPageView firstPageView;
	private FirstPageController firstPageController;

	public AddFurnizorController(AddFurnizorView view) {
		this.addFurnizorView = view;
		this.firstPageView = new FirstPageView();
		this.firstPageController = new FirstPageController(firstPageView);

		addFurnizorView.addFurnizorListener(new FurnizorListener());
		addFurnizorView.resetBtnListener(new ResetBtnListener());
		addFurnizorView.backBtnListener(new BackBtnListener());
	}

	class FurnizorListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int id = addFurnizorView.getId();
			String denumire = addFurnizorView.getDenumire();
			String regCom = addFurnizorView.getRegCom();
			String cif = addFurnizorView.getCif();
			String capital = addFurnizorView.getCapital();
			String sediu = addFurnizorView.getSediu();
			String judet = addFurnizorView.getJudet();
			String iban = addFurnizorView.getIban();
			String banca = addFurnizorView.getBanca();

			if ((denumire.length() > 50) || (denumire.equals("")))
				JOptionPane.showMessageDialog(null, "Denumire necorespunzatoare!");
			else if ((regCom.length() > 20) || (regCom.equals("")))
				JOptionPane.showMessageDialog(null, "Numar de inregistrare la Registrul Comertului necorespunzator!");
			else if ((cif.length() > 20) || (cif.equals("")))
				JOptionPane.showMessageDialog(null, "Cif necorespunzator!");
			else if (capital.length() > 30)
				JOptionPane.showMessageDialog(null, "Capital necorespunzator!");
			else if ((sediu.length() > 50) || (sediu.equals("")))
				JOptionPane.showMessageDialog(null, "Sediu necorespunzator!");
			else if ((judet.length() > 15) || (judet.equals("")))
				JOptionPane.showMessageDialog(null, "Judet necorespunzator!");
			else if (iban.length() > 50)
				JOptionPane.showMessageDialog(null, "IBAN necorespunzator!");
			else if (banca.length() > 30)
				JOptionPane.showMessageDialog(null, "Banca necorespunzator!");
			else {
				Furnizor furnizor = new Furnizor(id, denumire, regCom, cif, capital, sediu, judet, iban, banca);
				firstPageController.getFurnizorBL().insertFurnizor(furnizor);
				firstPageController.getFurnizorBL().setMaxFurnizorId(firstPageController.getFurnizorBL().findMaxId());
				JOptionPane.showMessageDialog(null, "Furnizor adaugat cu succes!");
			}
		}

	}

	class ResetBtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			addFurnizorView.setDenumire();
			addFurnizorView.setRegCom();
			addFurnizorView.setCif();
			addFurnizorView.setCapital();
			addFurnizorView.setSediu();
			addFurnizorView.setJudet();
			addFurnizorView.setIban();
			addFurnizorView.setBanca();

		}
	}

	class BackBtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			addFurnizorView.setVisible(false);
			firstPageView.setVisible(true);
		}

	}
}
