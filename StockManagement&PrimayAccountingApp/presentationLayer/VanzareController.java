package presentationLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import businessLayer.ProdusBL;
import model.Produs;

public class VanzareController {

	private VanzareView vanzareView;
	private FirstPageView firstPageView;
	private FirstPageController firstPageController;

	public VanzareController(VanzareView view) {
		this.vanzareView = view;
		this.firstPageView = new FirstPageView();
		this.firstPageController = new FirstPageController(firstPageView);

		this.vanzareView.backBtnListener(new BackButtonListener());
		this.vanzareView.finalizareBtnListener(new FinalizareBtnListner());
		this.vanzareView.tableListner(new TableListener());
	}

	class TableListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int columnId = 0;
			int row = vanzareView.getjTable().getSelectedRow();
			int id = Integer.valueOf(vanzareView.getjTable().getModel().getValueAt(row, columnId).toString());
			vanzareView.setIdProdus(id);

			int columnName = 1;
			String name = vanzareView.getjTable().getModel().getValueAt(row, columnName).toString();
			vanzareView.setNumeProdus(name);

			int columnPrice = 5;
			float price = Float.valueOf(vanzareView.getjTable().getModel().getValueAt(row, columnPrice).toString());
			vanzareView.setPrice(price);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

	class FinalizareBtnListner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int id = vanzareView.getIdProdus();
			String name = vanzareView.getNumeProdus();
			float price = vanzareView.getPrice();
			int quantity = vanzareView.getQuantity();

			ProdusBL produsBL = new ProdusBL();
			Produs produs = produsBL.findById(id);

			if (produs.getCantitate() < quantity)
				JOptionPane.showMessageDialog(null, "Stoc indisponibil");
			else {
				produsBL.UpdateMinusQuantity(id, name, price, quantity);
				JOptionPane.showMessageDialog(null, "Operatie realizata cu succes!");
			}
		}

	}

	class BackButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			vanzareView.setVisible(false);
			firstPageView.setVisible(true);
		}

	}
}
