package presentationLayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import businessLayer.ClientBL;
import businessLayer.FacturiBL;
import businessLayer.ProdusBL;
import model.Facturi;
import model.Produs;

public class FacturiView extends JFrame {

	private JTable jt;
	private DefaultTableModel model;
	private JTable productsJTable = new JTable(model);
	private JTextField client = new JTextField(30);

	public FacturiView() {
		FacturiBL FacturiBL = new FacturiBL();
		ArrayList<Facturi> facturi = FacturiBL.listAll();
		String[] column = { "ID", "Numar", "Data", "Valoare", "TVA", "Total" };
		String[][] data = generateTableData(facturi);

		jt = new JTable(data, column);
		jt.setPreferredSize(new Dimension(400, 500));
		jt.getColumnModel().getColumn(0).setPreferredWidth(5);
		jt.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				removeRows(model);
				int column = 0;
				int row = jt.getSelectedRow();
				int id = Integer.valueOf(jt.getModel().getValueAt(row, column).toString());
				ArrayList<Produs> products = new ProdusBL().findProductsF(id);

				for (Produs p : products) {

					String[] aux = new String[7];
					aux[0] = p.getIdProdus() + "";
					aux[1] = p.getDenumire() + "";
					aux[2] = p.getUm() + "";
					aux[3] = p.getCantitate() + "";
					aux[4] = p.getProcent() + "";
					aux[5] = p.getPret_fara_TVA() + "";
					aux[6] = p.getPret_vanzare() + "";
					model.addRow(aux);
				}
				productsJTable.repaint();

				String clientName = "";

				for (Facturi f : facturi) {
					if (f.getIdFactura() == id)
						clientName = new ClientBL().findById(f.getIdClient()).getClient();
					setClient(clientName);
				}

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
		});

		JScrollPane sp = new JScrollPane(jt);

		JPanel content = new JPanel();
		content.setBackground(new Color(51, 153, 255));
		content.setLayout(new GridLayout(1, 2));

		JLabel label = new JLabel("Client:");
		label.setFont(new Font("Serif", Font.BOLD, 24));
		JPanel panelBorderClient = new JPanel(new BorderLayout());
		panelBorderClient.add(label, BorderLayout.WEST);
		panelBorderClient.add(client, BorderLayout.EAST);
		panelBorderClient.setBackground(new Color(51, 153, 255));

		JPanel panel1 = new JPanel(new BorderLayout());
		panel1.setBackground(new Color(51, 153, 255));
		String[] column1 = { "ID", "Denumire", "U.M", "Cantitate", "Procent", "Pret fara TVA", "Pret vanzare" };
		String[][] data1 = {};

		model = new DefaultTableModel(data1, column1);
		productsJTable = new JTable(model);
		productsJTable.getColumnModel().getColumn(0).setPreferredWidth(2);
		productsJTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		productsJTable.getColumnModel().getColumn(2).setPreferredWidth(15);
		productsJTable.getColumnModel().getColumn(3).setPreferredWidth(30);
		productsJTable.getColumnModel().getColumn(4).setPreferredWidth(30);
		productsJTable.getColumnModel().getColumn(5).setPreferredWidth(60);
		productsJTable.getColumnModel().getColumn(6).setPreferredWidth(60);

		JScrollPane scrollpanel = new JScrollPane(productsJTable);
		panel1.add(panelBorderClient, BorderLayout.NORTH);
		panel1.add(scrollpanel, BorderLayout.CENTER);

		content.add(sp);
		content.add(panel1);

		this.setContentPane(content);
		this.pack();
		this.setTitle("Facturi");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public String[][] generateTableData(ArrayList<Facturi> facturi) {
		int size = facturi.size();
		String[][] data = new String[size][6];
		int i = 0;

		for (Facturi f : facturi) {

			String[] aux = new String[7];
			aux[0] = f.getIdFactura() + "";
			aux[1] = f.getNrFactura() + "";
			aux[2] = f.getData();
			aux[3] = f.getValoare() + "";
			aux[4] = f.getValoareTVA() + "";
			aux[5] = f.getTotal() + "";

			data[i++] = aux;
		}
		return data;
	}

	public void removeRows(DefaultTableModel model) {
		int size = model.getRowCount();

		for (int i = size - 1; i >= 0; i--)
			model.removeRow(i);
	}

	public void setClient(String name) {
		client.setText(name);
	}
}
