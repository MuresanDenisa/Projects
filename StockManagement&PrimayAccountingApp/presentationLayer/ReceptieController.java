package presentationLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import businessLayer.FurnizorBL;
import businessLayer.ProdusBL;
import businessLayer.Produse_ReceptieBL;
import model.Furnizor;
import model.Produs;
import model.Produse_Receptie;
import model.Receptie;

public class ReceptieController {

	private ReceptieView receptieView;
	private FirstPageView firstPageView;
	private FirstPageController firstPageController;
	private ArrayList<Produse_Receptie> selectedProducts;
	private ArrayList<Produs> products;
	private Receptie receptie;
	private Furnizor furnizor;

	public ReceptieController(ReceptieView view) {
		this.receptieView = view;
		this.firstPageView = new FirstPageView();
		this.firstPageController = new FirstPageController(firstPageView);
		this.selectedProducts = new ArrayList<Produse_Receptie>();
		this.products = new ArrayList<Produs>();

		this.receptieView.addFurnizorBtnListener(new AddFurnizorListener());
		this.receptieView.refreshFurnizorBtnListener(new RefreshFurnizorListener());
		this.receptieView.addNewProductBtnListener(new AddNewProductListener());
		this.receptieView.refreshBtnListener(new RefreshListener());
		this.receptieView.backBtnListener(new BackButtonListener());
		this.receptieView.tableListner(new TableListener());
		this.receptieView.addProductBtnListener(new AddProductListener());
		this.receptieView.finalizareBtnListener(new FinalizareBtnListener());
		this.receptieView.generatePDFListener(new GeneratePDFListener());
	}

	class RefreshFurnizorListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int id = new FurnizorBL().getMaxFurnizorId();
			Furnizor furnizor = firstPageController.getFurnizorBL().findById(id);
			receptieView.updateJComboBox(furnizor);
		}

	}

	class AddFurnizorListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			AddFurnizorView furnizorView = new AddFurnizorView();
			furnizorView.setId(new FurnizorBL().getMaxFurnizorId() + 1);
			furnizorView.setVisible(true);
			AddFurnizorController furnizorController = new AddFurnizorController(furnizorView);
		}

	}

	class FinalizareBtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int idR = receptieView.getReceptieId();
			int noR = receptieView.getReceptieNo();
			String dateR = receptieView.getReceptieDate();

			int noF = receptieView.getFacturaNo();
			float totalF = receptieView.getFacturaTotal();
			String dateF = receptieView.getFacturaDate();

			furnizor = (Furnizor) receptieView.getFurnizorJComboBox().getSelectedItem();
			int idF = furnizor.getIdFurnizor();

			float totalR = 0;
			for (Produse_Receptie p : selectedProducts) {
				totalR += p.getValoare();
			}

			if (noR == -1)
				JOptionPane.showMessageDialog(null, "Va rugam introduceti numarul receptiei!");
			else if (dateR.equals(""))
				JOptionPane.showMessageDialog(null, "Va rugam introduceti data receptiei!");
			else if (noF == -1)
				JOptionPane.showMessageDialog(null, "Va rugam introduceti numarul facturii!");
			else if (totalF == -1)
				JOptionPane.showMessageDialog(null, "Va rugam introduceti totalul facturii!");
			else if (dateF.equals(""))
				JOptionPane.showMessageDialog(null, "Va rugam introduceti data facturii!");
			else {
				receptie = new Receptie(idR, "NIDAROM AUTO", noR, dateR, noF, totalF, dateF, idF, totalR);
				firstPageController.getReceptieBl().insertReceptie(receptie);
				firstPageController.getReceptieBl().setMaxReceptieId(firstPageController.getReceptieBl().findMaxId());

				for (Produs p : products) {
					firstPageController.getProdusBL().UpdatePlusQuantity(p.getDenumire(), p.getPret_fara_TVA(),
							p.getCantitate());
				}

				for (Produse_Receptie pr : selectedProducts) {
					new Produse_ReceptieBL().insert(pr);
				}
				JOptionPane.showMessageDialog(null, "Receptie adaugata cu succes!");
			}
		}

	}

	class GeneratePDFListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			if (furnizor == null)
				JOptionPane.showMessageDialog(null, "Va rugam finalizati comanda!");
			else if (selectedProducts == null)
				JOptionPane.showMessageDialog(null, "Va rugam finalizati comanda!");
			else if (receptie == null)
				JOptionPane.showMessageDialog(null, "Va rugam finalizati comanda!");
			else
				firstPageController.getReceptieBl().generatePDF(furnizor, products, receptie);
		}

	}

	class AddNewProductListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			AddProdusView addProductView = new AddProdusView();
			addProductView.setId(new ProdusBL().getMaxProdusId() + 1);
			addProductView.setProcent(15);
			addProductView.setUm("BUC");
			AddProdusController addProdusController = new AddProdusController(addProductView);
			addProductView.setVisible(true);

		}

	}

	class BackButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			receptieView.setVisible(false);
			firstPageView.setVisible(true);
		}

	}

	class TableListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int column = 0;
			int row = receptieView.getjTable().getSelectedRow();
			int id = Integer.valueOf(receptieView.getjTable().getModel().getValueAt(row, column).toString());
			receptieView.setProductId(id);
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

	class AddProductListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			int quantity = receptieView.getQuantity();
			int idP = receptieView.getProductId();
			int idR = receptieView.getReceptieId();

			int column = 1;
			int row = receptieView.getjTable().getSelectedRow();
			String name = receptieView.getjTable().getModel().getValueAt(row, column).toString();

			column = 2;
			String um = receptieView.getjTable().getModel().getValueAt(row, column).toString();

			column = 4;
			int procent = Integer.valueOf(receptieView.getjTable().getModel().getValueAt(row, column).toString());
			column = 5;
			float price_withOut_TVA = Float
					.valueOf(receptieView.getjTable().getModel().getValueAt(row, column).toString());

			column = 6;
			float sellingPrice = Float.valueOf(receptieView.getjTable().getModel().getValueAt(row, column).toString());

			if (idP == -1)
				JOptionPane.showMessageDialog(null, "Va rugam selectati un produs!");
			else if (quantity == -1)
				JOptionPane.showMessageDialog(null, "Va rugam introduceti o cantiate!");
			else {
				Produse_Receptie productR = new Produse_Receptie(idR, idP, quantity, quantity * sellingPrice);
				selectedProducts.add(productR);

				Produs product = new Produs(idP, name, um, quantity, procent, price_withOut_TVA, sellingPrice);
				products.add(product);
				receptieView.updateTable2(product);
				receptieView.setEmptyProductId();
				receptieView.setQuantityTextField();
			}
		}
	}

	class RefreshListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Produs product = firstPageController.getProdusBL().findById(firstPageController.getProdusBL().findMaxId());
			receptieView.updateTable(product);
			receptieView.updateTable2(product);
			products.add(product);

			int idR = receptieView.getReceptieId();
			Produse_Receptie productR = new Produse_Receptie(idR, product.getIdProdus(), product.getCantitate(),
					product.getCantitate() * product.getPret_vanzare());
			selectedProducts.add(productR);
		}

	}
}