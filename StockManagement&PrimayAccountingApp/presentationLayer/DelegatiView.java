package presentationLayer;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import businessLayer.DelegatBL;
import model.Delegat;

public class DelegatiView extends JFrame {

	public DelegatiView() {
		DelegatBL delegatBL = new DelegatBL();
		ArrayList<Delegat> delegati = delegatBL.listAll();
		String[] column = { "ID", "Nume", "Serie", "Numar" };
		String[][] data = generateTableData(delegati);

		JTable jt = new JTable(data, column);
		jt.setPreferredSize(new Dimension(400, 800));
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jt.getColumnModel().getColumn(0).setPreferredWidth(2);
		jt.getColumnModel().getColumn(1).setPreferredWidth(100);
		jt.getColumnModel().getColumn(2).setPreferredWidth(5);
		jt.getColumnModel().getColumn(3).setPreferredWidth(15);
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		JScrollPane sp = new JScrollPane(jt);

		this.setContentPane(sp);
		this.pack();
		this.setTitle("Delegati");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public String[][] generateTableData(ArrayList<Delegat> delegati) {
		int size = delegati.size();
		String[][] data = new String[size][4];
		int i = 0;

		for (Delegat d : delegati) {

			String[] aux = new String[4];
			aux[0] = d.getIdDelegat() + "";
			aux[1] = d.getNume();
			aux[2] = d.getSerie();
			aux[3] = d.getNumar();

			data[i++] = aux;
		}
		return data;
	}
}
