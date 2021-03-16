package presentationLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.InregistrariRegistru;
import model.RegistruCasa;

public class RegistruController {

	private RegistruView registruView;
	private FirstPageView firstPageView;
	private FirstPageController firstPageController;
	private ArrayList<InregistrariRegistru> inregistrari;
	private float soldInitial;
	private float soldFinal;

	public RegistruController(RegistruView view) {
		this.registruView = view;
		this.firstPageView = new FirstPageView();
		this.firstPageController = new FirstPageController(firstPageView);
		this.inregistrari = new ArrayList<InregistrariRegistru>();
		this.soldInitial = registruView.getSoldInitial();
		this.soldFinal = soldInitial;

		registruView.addRegistruListener(new AddRegistruListener());
		registruView.resetBtnListener(new ResetBtnListener());
		registruView.backBtnListener(new BackBtnListener());
		registruView.addInregListener(new InregListener());
	}

	class AddRegistruListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int idReg = registruView.getIdReg();
			int nrPoz = registruView.getNrPozitie();
			String data = registruView.getData();
			int nrCrt = inregistrari.get(0).getNrCurent();
			int nextNrCurent = registruView.getNrCriteriu();
			float soldInitial = registruView.getSoldInitial();
			float soldFinal = registruView.getSoldFinal();
			float incasariTotal = 0;
			float plati = 0;

			for (InregistrariRegistru r : inregistrari) {
				incasariTotal = incasariTotal + r.getIncasari();
				plati = plati + r.getPlati();
			}
			if ((data.length() > 10) || (data.equals("")))
				JOptionPane.showMessageDialog(null, "Data necorespunzatoare!");
			else {
				RegistruCasa registru = new RegistruCasa(idReg, data, nrPoz, soldInitial, incasariTotal, plati,
						soldFinal, nrCrt, nextNrCurent);
				firstPageController.getRegistruBL().insertRegistruCasa(registru);
				firstPageController.getRegistruBL()
						.setMaxRegistruId(firstPageController.getRegistruBL().getMaxRegistruId() + 1);

				JOptionPane.showMessageDialog(null, "Registru de Casa adaugat cu succes!");
				firstPageController.getRegistruBL().generateRegistru(registru, inregistrari);
			}
		}
	}

	class ResetBtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			registruView.setData();
			registruView.setExplicatie();
			registruView.setIncasari();
			registruView.setPlati();
			registruView.setSoldFinal(0);
		}
	}

	class InregListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (soldInitial == 0) {
				soldInitial = registruView.getSoldInitial();
				soldFinal = soldInitial;
			}
			try {
				int nrCrt = registruView.getNrCriteriu();

				String explicatie = registruView.getExplicatie();
				float incasari = registruView.getIncasari();
				float plati = registruView.getPlati();

				soldFinal = soldFinal + incasari - plati;
				InregistrariRegistru inreg = new InregistrariRegistru(nrCrt, explicatie, incasari, plati);
				inregistrari.add(inreg);

				registruView.setSoldFinal(soldFinal);
				registruView.setNrCriteriu(nrCrt + 1);
				registruView.setExplicatie();
				registruView.setIncasari();
				registruView.setPlati();
			} catch (NumberFormatException exception) {
				JOptionPane.showMessageDialog(null, "Atentie! Va rugam completati toate casutele!");
			}
		}

	}

	class BackBtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			registruView.setVisible(false);
			firstPageView.setVisible(true);
		}

	}
}
