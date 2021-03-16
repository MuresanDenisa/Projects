package presentationLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RapoarteController {

	private RapoarteView rapoarteView;
	private FirstPageView firstPageView;

	public RapoarteController(RapoarteView view) {

		this.rapoarteView = view;
		this.firstPageView = new FirstPageView();

		this.rapoarteView.vizStockBtnListener(new VizProdusListener());
		this.rapoarteView.vizFurnizorBtnListener(new VizFurnizorListener());
		this.rapoarteView.vizClientBtnListener(new VizClientListener());
		this.rapoarteView.vizDelegatBtnListener(new VizDelegatListener());
		this.rapoarteView.vizReceptieBtnListener(new VizReceptieListener());
		this.rapoarteView.vizFacturaBtnListener(new VizFacturaListener());
		this.rapoarteView.vizRegistruBtnListener(new VizRegistruListener());
		this.rapoarteView.vizMonetarBtnListener(new VizMonetarListener());
	}

	// ActionListeners
	public class VizProdusListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			StockView stockView = new StockView();
			stockView.setVisible(true);
//			firstPageView.setVisible(false);
		}
	}

	class VizFurnizorListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			FurnizoriView furnizoriView = new FurnizoriView();
			firstPageView.setVisible(false);
			furnizoriView.setVisible(true);
		}

	}

	class VizClientListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ClientiView clientiView = new ClientiView();
			firstPageView.setVisible(false);
			clientiView.setVisible(true);

		}

	}

	class VizDelegatListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			DelegatiView delegatiView = new DelegatiView();
			firstPageView.setVisible(false);
			delegatiView.setVisible(true);
		}

	}

	class VizReceptieListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ReceptiiView receptiiView = new ReceptiiView();
			receptiiView.setVisible(true);
		}
	}

	class VizFacturaListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			FacturiView facturiView = new FacturiView();
//			FacturaController facturaController = new FacturaController(facturaView);
			facturiView.setVisible(true);
		}
	}

	class VizMonetarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			MonetareView monetareView = new MonetareView();
			firstPageView.setVisible(false);
			monetareView.setVisible(true);

		}
	}

	class VizRegistruListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			RegistreView registreView = new RegistreView();
			firstPageView.setVisible(false);
			registreView.setVisible(true);
		}
	}
}
