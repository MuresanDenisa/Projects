package presentationLayer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import businessLayer.ProdusBL;
import model.Produs;

public class StockView extends JFrame {

	public JTextField totalTextField = new JTextField(30);
	public JButton exportPDFBtn = new JButton("PDF");

	public StockView() {

		ProdusBL produsBL = new ProdusBL();
		ArrayList<Produs> products = produsBL.ListAll();
		String[] column = { "ID", "Denumire", "U.M", "Cantitate", "Procent", "Pret fara TVA", "Pret vanzare" };
		String[][] data = generateTableData(products);

		JTable jt = new JTable(data, column);
		jt.setPreferredSize(new Dimension(400, 800));
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jt.getColumnModel().getColumn(0).setPreferredWidth(2);
		jt.getColumnModel().getColumn(1).setPreferredWidth(100);
		jt.getColumnModel().getColumn(2).setPreferredWidth(15);
		jt.getColumnModel().getColumn(3).setPreferredWidth(30);
		jt.getColumnModel().getColumn(4).setPreferredWidth(30);
		jt.getColumnModel().getColumn(5).setPreferredWidth(60);
		jt.getColumnModel().getColumn(6).setPreferredWidth(60);
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		JScrollPane sp = new JScrollPane(jt);

		exportPDFBtn.setPreferredSize(new Dimension(70, 27));
		exportPDFBtn.setFont(new Font("Serif", Font.PLAIN, 16));
		exportPDFBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ProdusBL produsBl = new ProdusBL();
				ArrayList<Produs> products = produsBl.ListAll();
				produsBl.generateStockPDF(products);
			}

		});

		JLabel label = new JLabel("Total:");
		label.setFont(new Font("Serif", Font.BOLD, 24));
		JPanel panelBorderTotal = new JPanel(new BorderLayout());
		panelBorderTotal.add(label, BorderLayout.WEST);
		panelBorderTotal.add(totalTextField, BorderLayout.CENTER);
		panelBorderTotal.add(exportPDFBtn, BorderLayout.EAST);

		JPanel panel1 = new JPanel(new BorderLayout());
		panel1.add(panelBorderTotal, BorderLayout.SOUTH);
		panel1.add(sp, BorderLayout.CENTER);

		this.setContentPane(panel1);
		this.pack();
		this.setTitle("Stoc");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public String[][] generateTableData(ArrayList<Produs> products) {
		int size = products.size();
		String[][] data = new String[size][7];
		int i = 0;
		float total = 0;
		for (Produs p : products) {

			String[] aux = new String[7];
			aux[0] = p.getIdProdus() + "";
			aux[1] = p.getDenumire() + "";
			aux[2] = p.getUm() + "";
			aux[3] = p.getCantitate() + "";
			aux[4] = p.getProcent() + "";
			aux[5] = p.getPret_fara_TVA() + "";
			aux[6] = p.getPret_vanzare() + "";

			data[i++] = aux;
			total += (p.getPret_vanzare() + p.getCantitate());
		}
		setTotalTextField(total);
		return data;
	}

	public void setTotalTextField(float total) {
		totalTextField.setText(total + "");
	}
}
