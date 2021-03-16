package presentationLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Client;

public class AddClientController {

	private AddClientView addClientView;
	private FirstPageView firstPageView;
	private FirstPageController firstPageController;

	public AddClientController(AddClientView view) {
		this.addClientView = view;
		this.firstPageView = new FirstPageView();
		this.firstPageController = new FirstPageController(firstPageView);

		addClientView.addClientListener(new ClientListener());
		addClientView.resetBtnListener(new ResetBtnListener());
		addClientView.backBtnListener(new BackBtnListener());
	}

	class ClientListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int id = addClientView.getId();
			String denumire = addClientView.getDenumire();
			String regCom = addClientView.getRegCom();
			String cif = addClientView.getCif();
			String capital = addClientView.getCapital();
			String sediu = addClientView.getSediu();
			String judet = addClientView.getJudet();
			String iban = addClientView.getIban();
			String banca = addClientView.getBanca();

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
				Client client = new Client(id, denumire, regCom, cif, capital, sediu, judet, iban, banca);
				firstPageController.getClientBL().insertClient(client);
				firstPageController.getClientBL().setMaxClientId(firstPageController.getClientBL().findMaxId());
				JOptionPane.showMessageDialog(null, "Client adaugat cu succes!");
			}
		}

	}

	class ResetBtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			addClientView.setDenumire();
			addClientView.setRegCom();
			addClientView.setCif();
			addClientView.setCapital();
			addClientView.setSediu();
			addClientView.setJudet();
			addClientView.setIban();
			addClientView.setBanca();

		}
	}

	class BackBtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			addClientView.setVisible(false);
			firstPageView.setVisible(true);
		}

	}
}
