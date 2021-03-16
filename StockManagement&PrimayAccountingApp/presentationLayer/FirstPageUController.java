package presentationLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import businessLayer.ProdusBL;
import businessLayer.ReceptieBL;
import model.Receptie;

public class FirstPageUController {

	private FirstPageUView firstPageUView;
	private ProdusBL produsBL;
	private ReceptieBL receptieBl;

	public FirstPageUController(FirstPageUView view) {
		this.firstPageUView = view;
		this.setProdusBL(new ProdusBL());
		this.setReceptieBl(new ReceptieBL());

		this.firstPageUView.vanzareBtnListener(new VanzareListener());
		this.firstPageUView.receptieBtnListener(new AddRecListener());
		this.firstPageUView.vizStockBtnListener(new ListProdListener());
		this.firstPageUView.vizReceptieBtnListener(new VizRecListener());
		this.firstPageUView.logOutBtnListener(new LogOutListener());

	}

	// ActionListeners

	class LogOutListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			InitPageView view = new InitPageView();
			view.setId("");
			view.setPassword("");
			InitPageController controller = new InitPageController(view);
			firstPageUView.setVisible(false);
			view.setVisible(true);
		}

	}

	class VizRecListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ReceptiiView receptiiView = new ReceptiiView();
			receptiiView.setVisible(true);
		}
	}

	public class ListProdListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			StockView stockView = new StockView();
			stockView.setVisible(true);
		}
	}

	class VanzareListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			VanzareView vanzareView = new VanzareView();
			VanzareController vanzareController = new VanzareController(vanzareView);
			vanzareView.setVisible(true);
		}
	}

	class AddRecListener implements ActionListener {

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
			// firstPageUView.setVisible(false);
			receptieView.setVisible(true);
		}
	}

	// setters and getters
	public ProdusBL getProdusBL() {
		return produsBL;
	}

	public void setProdusBL(ProdusBL produsBL) {
		this.produsBL = produsBL;
	}

	public ReceptieBL getReceptieBl() {
		return receptieBl;
	}

	public void setReceptieBl(ReceptieBL receptieBl) {
		this.receptieBl = receptieBl;
	}

}
