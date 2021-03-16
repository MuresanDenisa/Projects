package presentationLayer;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import businessLayer.FurnizorBL;
import model.Furnizor;

public class FurnizoriView extends JFrame {

	public FurnizoriView() {
		FurnizorBL furnizorBL = new FurnizorBL();
		ArrayList<Furnizor> furnizori = furnizorBL.listAll();
		String[] column = { "ID", "Denumire", "Reg_com", "	CIF", "Capital", "Sediul", "Judet", "Cod IBAN", "Banca" };
		String[][] data = generateTableData(furnizori);

		JTable jt = new JTable(data, column);
		jt.setPreferredSize(new Dimension(400, 800));
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jt.getColumnModel().getColumn(0).setPreferredWidth(2);
		jt.getColumnModel().getColumn(1).setPreferredWidth(100);
		jt.getColumnModel().getColumn(2).setPreferredWidth(50);
		jt.getColumnModel().getColumn(3).setPreferredWidth(50);
		jt.getColumnModel().getColumn(4).setPreferredWidth(30);
		jt.getColumnModel().getColumn(5).setPreferredWidth(60);
		jt.getColumnModel().getColumn(6).setPreferredWidth(60);
		jt.getColumnModel().getColumn(7).setPreferredWidth(100);
		jt.getColumnModel().getColumn(8).setPreferredWidth(60);
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		JScrollPane sp = new JScrollPane(jt);

		this.setContentPane(sp);
		this.pack();
		this.setTitle("Furnizori");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public String[][] generateTableData(ArrayList<Furnizor> furnizori) {
		int size = furnizori.size();
		String[][] data = new String[size][9];
		int i = 0;

		for (Furnizor f : furnizori) {

			String[] aux = new String[9];
			aux[0] = f.getIdFurnizor() + "";
			aux[1] = f.getFurnizor();
			aux[2] = f.getReg_com();
			aux[3] = f.getCif();
			aux[4] = f.getCapital();
			aux[5] = f.getSediul();
			aux[6] = f.getJudetul();
			aux[7] = f.getCod_iban();
			aux[8] = f.getBanca();

			data[i++] = aux;
		}
		return data;
	}
}
