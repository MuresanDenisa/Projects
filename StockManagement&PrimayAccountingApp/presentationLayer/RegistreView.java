package presentationLayer;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import businessLayer.RegistruCasaBL;
import model.RegistruCasa;

public class RegistreView extends JFrame {

	public RegistreView() {
		RegistruCasaBL registruCasaBL = new RegistruCasaBL();
		ArrayList<RegistruCasa> registruCasa = registruCasaBL.listAll();
		String[] column = { "ID", "Data", "Nr. Poz", "Sold Initial", "Incasari", "Plati", "Sold Final" };
		String[][] data = generateTableData(registruCasa);

		JTable jt = new JTable(data, column);
		jt.setPreferredSize(new Dimension(400, 800));
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jt.getColumnModel().getColumn(0).setPreferredWidth(2);
		jt.getColumnModel().getColumn(1).setPreferredWidth(30);
		jt.getColumnModel().getColumn(2).setPreferredWidth(5);
		jt.getColumnModel().getColumn(3).setPreferredWidth(30);
		jt.getColumnModel().getColumn(4).setPreferredWidth(30);
		jt.getColumnModel().getColumn(5).setPreferredWidth(30);
		jt.getColumnModel().getColumn(6).setPreferredWidth(30);
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		JScrollPane sp = new JScrollPane(jt);

		this.setContentPane(sp);
		this.pack();
		this.setTitle("Registre de Casa");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public String[][] generateTableData(ArrayList<RegistruCasa> reg) {
		int size = reg.size();
		String[][] data = new String[size][7];
		int i = 0;

		for (RegistruCasa r : reg) {

			String[] aux = new String[7];
			aux[0] = r.getIdRegistru() + "";
			aux[1] = r.getData();
			aux[2] = r.getNrPoz() + "";
			aux[3] = r.getSoldInitial() + "";
			aux[4] = r.getIncasari() + "";
			aux[5] = r.getPlati() + "";
			aux[6] = r.getSoldFinal() + "";

			data[i++] = aux;
		}
		return data;
	}
}
