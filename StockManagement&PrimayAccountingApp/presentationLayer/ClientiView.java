package presentationLayer;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import businessLayer.ClientBL;
import model.Client;

public class ClientiView extends JFrame {

	public ClientiView() {
		ClientBL clientBL = new ClientBL();
		ArrayList<Client> furnizori = clientBL.listAll();
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
		this.setTitle("Clienti");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public String[][] generateTableData(ArrayList<Client> clients) {
		int size = clients.size();
		String[][] data = new String[size][9];
		int i = 0;

		for (Client c : clients) {

			String[] aux = new String[9];
			aux[0] = c.getIdClient() + "";
			aux[1] = c.getClient();
			aux[2] = c.getReg_com();
			aux[3] = c.getCif();
			aux[4] = c.getCapital();
			aux[5] = c.getSediul();
			aux[6] = c.getJudetul();
			aux[7] = c.getCod_iban();
			aux[8] = c.getBanca();

			data[i++] = aux;
		}
		return data;
	}
}
