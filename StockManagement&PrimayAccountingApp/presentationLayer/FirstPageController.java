package presentationLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import businessLayer.ClientBL;
import businessLayer.DelegatBL;
import businessLayer.FacturiBL;
import businessLayer.FurnizorBL;
import businessLayer.MonetarBL;
import businessLayer.ProdusBL;
import businessLayer.ReceptieBL;
import businessLayer.RegistruCasaBL;
import businessLayer.UtilizatorBL;
import model.Receptie;
import model.RegistruCasa;

public class FirstPageController {

	private FirstPageView firstPageView;
	private ProdusBL produsBL;
	private FurnizorBL furnizorBL;
	private ClientBL clientBL;
	private DelegatBL delegatBL;
	private MonetarBL monetarBL;
	private RegistruCasaBL registruBL;
	private ReceptieBL receptieBl;
	private FacturiBL facturaBl;
	private UtilizatorBL utilizatorBL;

	public FirstPageController(FirstPageView view) {
		this.firstPageView = view;
		this.setProdusBL(new ProdusBL());
		this.setFurnizorBL(new FurnizorBL());
		this.setClientBL(new ClientBL());
		this.setDelegatBL(new DelegatBL());
		this.setMonetarBL(new MonetarBL());
		this.setRegistruBL(new RegistruCasaBL());
		this.setReceptieBl(new ReceptieBL());
		this.setFacturaBl(new FacturiBL());
		this.setUtilizatorBL(new UtilizatorBL());

		this.firstPageView.addProdusBtnListener(new AddProdusListener());
		this.firstPageView.addFurnizorBtnListener(new AddFurnizorListener());
		this.firstPageView.addClientBtnListener(new AddClientListener());
		this.firstPageView.addDelegatBtnListener(new AddDelegatListener());
		this.firstPageView.rapoarteBtnListener(new RapoarteListener());
		this.firstPageView.vanzareBtnListener(new VanzareListener());
		this.firstPageView.receptieBtnListener(new ReceptieListener());
		this.firstPageView.facturaBtnListener(new FacturaListener());
		this.firstPageView.registruBtnListener(new RegistruListener());
		this.firstPageView.monetarBtnListener(new MonetarListener());
		this.firstPageView.logOutBtnListener(new LogOutListener());
		this.firstPageView.addUserBtnListener(new UserListener());
	}

	// getters and setters

	public ProdusBL getProdusBL() {
		return produsBL;
	}

	public ReceptieBL getReceptieBl() {
		return receptieBl;
	}

	public void setReceptieBl(ReceptieBL receptieBl) {
		this.receptieBl = receptieBl;
	}

	public FacturiBL getFacturaBl() {
		return facturaBl;
	}

	public UtilizatorBL getUtilizatorBL() {
		return utilizatorBL;
	}

	public void setUtilizatorBL(UtilizatorBL utilizatorBL) {
		this.utilizatorBL = utilizatorBL;
	}

	public void setFacturaBl(FacturiBL facturaBl) {
		this.facturaBl = facturaBl;
	}

	public MonetarBL getMonetarBL() {
		return monetarBL;
	}

	public void setMonetarBL(MonetarBL monetarBL) {
		this.monetarBL = monetarBL;
	}

	public void setProdusBL(ProdusBL produsBL) {
		this.produsBL = produsBL;
	}

	public FurnizorBL getFurnizorBL() {
		return furnizorBL;
	}

	public void setFurnizorBL(FurnizorBL furnizorBL) {
		this.furnizorBL = furnizorBL;
	}

	public ClientBL getClientBL() {
		return clientBL;
	}

	public void setClientBL(ClientBL clientBL) {
		this.clientBL = clientBL;
	}

	public DelegatBL getDelegatBL() {
		return delegatBL;
	}

	public void setDelegatBL(DelegatBL delegatBL) {
		this.delegatBL = delegatBL;
	}

	public RegistruCasaBL getRegistruBL() {
		return registruBL;
	}

	public void setRegistruBL(RegistruCasaBL registruBL) {
		this.registruBL = registruBL;
	}

	// ActionListeners
	public class AddProdusListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			AddProdusView produsView = new AddProdusView();
			produsView.setId(produsBL.getMaxProdusId() + 1);
			produsView.setProcent(15);
			produsView.setUm("BUC");
			firstPageView.setVisible(false);
			produsView.setVisible(true);
			AddProdusController produsController = new AddProdusController(produsView);
		}
	}

	class UserListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			UtilizatorView userView = new UtilizatorView();
			userView.setIdUtilizator(utilizatorBL.getMaxUtilizatorId() + 1);
			// firstPageView.setVisible(false);
			userView.setVisible(true);
		}

	}

	class AddFurnizorListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			AddFurnizorView furnizorView = new AddFurnizorView();
			furnizorView.setId(furnizorBL.getMaxFurnizorId() + 1);
			firstPageView.setVisible(false);
			furnizorView.setVisible(true);
			AddFurnizorController furnizorController = new AddFurnizorController(furnizorView);
		}

	}

	class AddClientListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			AddClientView clientView = new AddClientView();
			clientView.setId(clientBL.getMaxClientId() + 1);
			firstPageView.setVisible(false);
			clientView.setVisible(true);
			AddClientController clientController = new AddClientController(clientView);
		}

	}

	class AddDelegatListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			AddDelegatView delegatView = new AddDelegatView();
			delegatView.setId(delegatBL.getMaxDelegatId() + 1);
			firstPageView.setVisible(false);
			delegatView.setVisible(true);
			AddDelegatController delegatController = new AddDelegatController(delegatView);
		}

	}

	class RapoarteListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			RapoarteView rapoarteView = new RapoarteView();
			RapoarteController rapoarteController = new RapoarteController(rapoarteView);
			// firstPageView.setVisible(false);
			rapoarteView.setVisible(true);
		}

	}

	class VanzareListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			VanzareView vanzareView = new VanzareView();
			VanzareController vanzareController = new VanzareController(vanzareView);
			firstPageView.setVisible(false);
			vanzareView.setVisible(true);
		}
	}

	class ReceptieListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ReceptieView receptieView = new ReceptieView();

			receptieView.setReceptieId(receptieBl.getMaxReceptieId() + 1);

			if (receptieBl.getMaxReceptieId() == 0) {
				receptieView.setReceptieNo(1);
			} else {
				Receptie receptie = receptieBl.findById(receptieBl.getMaxReceptieId());
				receptieView.setReceptieNo(receptie.getNrReceptie() + 1);
			}

			ReceptieController receptieController = new ReceptieController(receptieView);
			firstPageView.setVisible(false);
			receptieView.setVisible(true);
		}
	}

	class FacturaListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			FacturaView facturaView = new FacturaView();

			facturaView.setFacturaId(facturaBl.getMaxFacturaId() + 1);

			FacturaController facturaController = new FacturaController(facturaView);
			firstPageView.setVisible(false);
			facturaView.setVisible(true);
		}
	}

	class MonetarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			MonetarView monetarView = new MonetarView();
			monetarView.setId(monetarBL.getMaxMonetarId() + 1);
			firstPageView.setVisible(false);
			monetarView.setVisible(true);
			MonetarController monetarController = new MonetarController(monetarView);
		}
	}

	class RegistruListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			RegistruView registruView = new RegistruView();
			registruView.setIdRegistru(registruBL.getMaxRegistruId() + 1);

			if (registruBL.getMaxRegistruId() == 0) {
				registruView.setNrCriteriu(0);
				registruView.setNrPozitie(0);
				registruView.setSoldInitial(0);
			} else {
				RegistruCasa reg = registruBL.findById(registruBL.getMaxRegistruId());
				registruView.setNrCriteriu(reg.getNextNrCurent());
				registruView.setNrPozitie(reg.getNrPoz() + 1);
				registruView.setSoldInitial(reg.getSoldFinal());
			}

			firstPageView.setVisible(false);
			registruView.setVisible(true);
			RegistruController registruController = new RegistruController(registruView);

		}
	}

	class LogOutListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			InitPageView view = new InitPageView();
			view.setId("");
			view.setPassword("");
			InitPageController controller = new InitPageController(view);
			firstPageView.setVisible(false);
			view.setVisible(true);
		}

	}
}
