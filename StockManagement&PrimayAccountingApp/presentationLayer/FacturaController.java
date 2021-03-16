package presentationLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import businessLayer.ClientBL;
import businessLayer.DelegatBL;
import businessLayer.Produse_FacturiBL;
import model.Client;
import model.Delegat;
import model.Facturi;
import model.Produs;
import model.Produse_Facturi;

public class FacturaController {

	private FacturaView facturaView;
	private FirstPageController firstPageController;
	private FirstPageView firstPageView;
	private ArrayList<Produs> products;
	private ArrayList<Produse_Facturi> selectedProducts;
	private Client client;
	private Delegat delegate;
	private Facturi factura;
	private float total;
	private float tva;

	public FacturaController(FacturaView view) {
		this.facturaView = view;
		this.firstPageView = new FirstPageView();
		this.firstPageController = new FirstPageController(firstPageView);
		this.total = 0;
		this.tva = 0;
		this.products = new ArrayList<Produs>();
		this.selectedProducts = new ArrayList<Produse_Facturi>();

		this.facturaView.addDelegateBtnListener(new AddDelegateListener());
		this.facturaView.refreshDelegateBtnListener(new RefreshDelegatesListener());
		this.facturaView.addClientBtnListener(new AddClientListener());
		this.facturaView.refreshClientBtnListener(new RefreshClientListener());
		this.facturaView.backBtnListener(new BackBtnListener());
		this.facturaView.tableListner(new TableListener());
		this.facturaView.addProductBtnListener(new AddProductListener());
		this.facturaView.finalizareBtnListener(new FinalizareBtnListener());
		this.facturaView.generatePDFListener(new GeneratePDFListener());
	}

	class AddDelegateListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			AddDelegatView delegatView = new AddDelegatView();
			delegatView.setId(new DelegatBL().getMaxDelegatId() + 1);
			delegatView.setVisible(true);
			AddDelegatController delegatController = new AddDelegatController(delegatView);

		}

	}

	class RefreshDelegatesListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int id = new DelegatBL().getMaxDelegatId();
			Delegat delegate = firstPageController.getDelegatBL().findById(id);
			facturaView.updateDelegateJComboBox(delegate);
		}

	}

	class AddClientListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			AddClientView clientView = new AddClientView();
			clientView.setId(new ClientBL().getMaxClientId() + 1);
			clientView.setVisible(true);
			AddClientController clientController = new AddClientController(clientView);
		}

	}

	class RefreshClientListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int id = new ClientBL().getMaxClientId();
			Client client = firstPageController.getClientBL().findById(id);
			facturaView.updateClientJComboBox(client);
		}

	}

	class BackBtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			facturaView.setVisible(false);
			firstPageView.setVisible(true);
		}

	}

	class TableListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int column = 0;
			int row = facturaView.getjTable().getSelectedRow();
			int id = Integer.valueOf(facturaView.getjTable().getModel().getValueAt(row, column).toString());
			facturaView.setProductId(id);

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
			int quantity = facturaView.getQuantity();
			int idP = facturaView.getProductId();
			int idF = facturaView.getFacturaId();
			float val = 0;

			int column = 1;
			int row = facturaView.getjTable().getSelectedRow();
			String name = facturaView.getjTable().getModel().getValueAt(row, column).toString();

			column = 2;
			String um = facturaView.getjTable().getModel().getValueAt(row, column).toString();

			column = 4;
			int procent = Integer.valueOf(facturaView.getjTable().getModel().getValueAt(row, column).toString());
			column = 5;
			float price_withOut_TVA = Float
					.valueOf(facturaView.getjTable().getModel().getValueAt(row, column).toString());

			column = 6;
			float sellingPrice = Float.valueOf(facturaView.getjTable().getModel().getValueAt(row, column).toString());

			if (idP == -1)
				JOptionPane.showMessageDialog(null, "Va rugam selectati un produs!");
			else if (quantity == -1)
				JOptionPane.showMessageDialog(null, "Va rugam introduceti o cantiate!");
			else {
				Produse_Facturi productF = new Produse_Facturi(idF, idP, quantity, quantity * sellingPrice);
				selectedProducts.add(productF);

				Produs product = new Produs(idP, name, um, quantity, procent, price_withOut_TVA, sellingPrice);
				products.add(product);
				total += quantity * sellingPrice;
				tva = (19 * total) / 100;

				facturaView.updateTable(product);
				facturaView.setEmptyProductId();
				facturaView.setQuantityTextField();
				facturaView.setFacturaTotal(total);
				facturaView.setFacturaTVA(tva);
			}
		}
	}

	class FinalizareBtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int idF = facturaView.getFacturaId();
			int facturaNO = facturaView.getfacturaNo();
			String date = facturaView.getfacturaDate();

			client = (Client) facturaView.getClientJComboBox().getSelectedItem();
			delegate = (Delegat) facturaView.getDelegatJComboBox().getSelectedItem();

			float totalF = total + tva;

			if (facturaNO == -1)
				JOptionPane.showMessageDialog(null, "Va rugam introduceti numarul facturii!");
			else if (date.equals(""))
				JOptionPane.showMessageDialog(null, "Va rugam introduceti data facturii!");
			else {
				factura = new Facturi(idF, facturaNO, date, client.getIdClient(), delegate.getIdDelegat(), total, tva,
						totalF);
				firstPageController.getFacturaBl().insertFactura(factura);
				firstPageController.getFacturaBl().setMaxFacturaId(firstPageController.getFacturaBl().findMaxId());

				for (Produs p : products) {
					firstPageController.getProdusBL().UpdateMinusQuantity(p.getIdProdus(), p.getDenumire(),
							p.getPret_fara_TVA(), p.getCantitate());
				}
				for (Produse_Facturi pr : selectedProducts) {
					new Produse_FacturiBL().insert(pr);
				}
				JOptionPane.showMessageDialog(null, "Factura adaugata cu succes!");
			}
		}
	}

	class GeneratePDFListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (factura == null)
				JOptionPane.showMessageDialog(null, "Va rugam finalizati comanda!");
			else if (delegate == null)
				JOptionPane.showMessageDialog(null, "Va rugam finalizati comanda!");
			else if (client == null)
				JOptionPane.showMessageDialog(null, "Va rugam finalizati comanda!");
			else
				firstPageController.getFacturaBl().generatePDF(factura, products, client, delegate);
		}

	}
}
