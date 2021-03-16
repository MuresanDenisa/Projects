package presentationLayer;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import businessLayer.MonetarBL;
import model.Monetar;

public class MonetareView extends JFrame {

	public MonetareView() {
		MonetarBL monetarBL = new MonetarBL();
		ArrayList<Monetar> monetare = monetarBL.listAll();
		String[] column = { "ID", "Nr. Monetar", "Data", "Total" };
		String[][] data = generateTableData(monetare);

		JTable jt = new JTable(data, column);
		jt.setPreferredSize(new Dimension(400, 800));
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jt.getColumnModel().getColumn(0).setPreferredWidth(2);
		jt.getColumnModel().getColumn(1).setPreferredWidth(100);
		jt.getColumnModel().getColumn(2).setPreferredWidth(50);
		jt.getColumnModel().getColumn(3).setPreferredWidth(50);
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		JScrollPane sp = new JScrollPane(jt);

		this.setContentPane(sp);
		this.pack();
		this.setTitle("Monetare");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public String[][] generateTableData(ArrayList<Monetar> monetare) {
		int size = monetare.size();
		String[][] data = new String[size][4];
		int i = 0;

		for (Monetar m : monetare) {

			String[] aux = new String[4];
			aux[0] = m.getIdMonetar() + "";
			aux[1] = m.getNrMonetar() + "";
			aux[2] = m.getData();
			aux[3] = m.getTotal() + "";

			data[i++] = aux;
		}
		return data;
	}
}
