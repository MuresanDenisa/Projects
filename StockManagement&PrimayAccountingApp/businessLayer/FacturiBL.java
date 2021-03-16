package businessLayer;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import dataAccessObjects.FacturiDAO;
import model.Client;
import model.Delegat;
import model.Facturi;
import model.Produs;

public class FacturiBL {

	private FacturiDAO facturaDAO;
	private int maxFacturaId;

	// constructor
	public FacturiBL() {

		facturaDAO = new FacturiDAO();
		maxFacturaId = findMaxId();
	}

	/**
	 * insert function
	 * 
	 * @param factura
	 */
	public void insertFactura(Facturi factura) {
		facturaDAO.insert(factura);
	}

	/**
	 * find max id function
	 * 
	 * @return
	 */
	public int findMaxId() {

		return facturaDAO.findMaxId();
	}

	/**
	 * list all function
	 * 
	 * @return
	 */
	public ArrayList<Facturi> listAll() {
		return facturaDAO.findAll();
	}

	/**
	 * generate PDF function
	 * 
	 * @param factura
	 * @param produse
	 * @param client
	 * @param delegat
	 */
	public void generatePDF(Facturi factura, ArrayList<Produs> produse, Client client, Delegat delegat) {
		JFrame parentComponent = new JFrame();
		JFileChooser fileChooser = new JFileChooser();
		Font font = FontFactory.getFont(FontFactory.COURIER, 12);
		// Some init code, if you need one, like setting title
		int returnValue = fileChooser.showOpenDialog(parentComponent);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();
			try {
				Document document = new Document();
				PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileToSave + ".pdf"));
				document.open();

				Paragraph paragraph = new Paragraph();
				paragraph.setFont(font);
				paragraph.add("Factura Nr." + factura.getNrFactura());
				paragraph.add("\nData" + factura.getData());
				paragraph.setAlignment(Element.ALIGN_CENTER);

				PdfPTable table = new PdfPTable(2);
				table.setTotalWidth(PageSize.A4.getWidth() - 20);
				table.setLockedWidth(true);

				PdfPCell cell = new PdfPCell(new Phrase("FURNIZOR", font));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase("CUMPARATOR", font));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				PdfPCell cell0 = new PdfPCell(new Phrase(
						"Unitate: NIDAROM AUTO S.R.L\nNr. O.R.C./an: J31/70/19.03.2001\nC.U.I.: RO13811950\nCapital Social: 200 Lei\nSediul: Zalau, str. Tudor Vladimirescu, bl.G-164, Parter\nJudetul: Salaj\nBanca: Banca Transilvania\nIBAN: RO62BTRLRONCRT0528995801",
						font));

				PdfPCell cell1 = new PdfPCell(new Phrase("Cumparator:" + client.getClient() + "\nNr. O.R.C./an:"
						+ client.getReg_com() + "\nC.I.F: " + client.getCif() + "\nSediul:" + client.getSediul()
						+ "\nJudetul:" + client.getJudetul() + "\nCod IBAN:" + client.getCod_iban() + "\nBanca"
						+ client.getBanca(), font));

				table.addCell(cell0);
				table.addCell(cell1);
				paragraph.add(table);

				paragraph.add("\n\n");

				float[] relativeWidths2 = { 100, 300, 150, 150, 300, 250, 400 };
				PdfPTable table2 = new PdfPTable(7);
				table2.setWidths(relativeWidths2);
				table2.setTotalWidth(PageSize.A4.getWidth() - 20);
				table2.setLockedWidth(true);

				cell = new PdfPCell(new Phrase("Nr. Crt", font));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase("Denumire", font));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase("U.M", font));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase("Cant", font));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase("Pret fara TVA", font));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase("Pret Vanzare", font));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase("Val la pret de vanzare", font));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2.addCell(cell);

				table2.setHeaderRows(1);

				int i = 1;
				for (Produs p : produse) {
					table2.addCell(new Phrase(i++ + "", font));
					table2.addCell(new Phrase(p.getDenumire() + "", font));
					table2.addCell(new Phrase(p.getUm() + "", font));
					table2.addCell(new Phrase(p.getCantitate() + "", font));
					table2.addCell(new Phrase(p.getPret_fara_TVA() + "", font));
					table2.addCell(new Phrase(p.getPret_vanzare() + "", font));
					table2.addCell(new Phrase(p.getPret_vanzare() * p.getCantitate() + "", font));
				}

				paragraph.add(table2);
				paragraph.add("\n");
				PdfPTable table1 = new PdfPTable(1);
				table1.setTotalWidth(PageSize.A4.getWidth() - 20);
				table1.setLockedWidth(true);
				PdfPCell cell2 = new PdfPCell(new Phrase("Delegat: " + delegat.getNume() + " Seria: "
						+ delegat.getSerie() + " Nr: " + delegat.getNumar()
						+ "\nMijloc de transport: AUTO   nr:\nExpeditia s-a efectutat in prezenta noastra la data de                ora\nSemnaturile\n\n",
						font));
				table1.addCell(cell2);
				paragraph.add(table1);
				paragraph.add("\n\n");
				paragraph.add("_______________________________________________________________________");
				paragraph.add("\n\n");
				paragraph
						.add("Valoare: " + factura.getValoare() + "           Valoare TVA: " + factura.getValoareTVA());
				paragraph.add("\n\n");
				paragraph.add("Total:" + factura.getTotal());
				paragraph.add("\n\n");
				paragraph.add("Semnatura si stampila furnizorului:");
				try {
					document.add(paragraph);

				} catch (DocumentException e) {
					e.printStackTrace();
				}
				document.close();
				JOptionPane.showMessageDialog(null, "PDF Saved");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}

	// getters and setters
	public int getMaxFacturaId() {
		return maxFacturaId;
	}

	public void setMaxFacturaId(int maxFacturaId) {
		this.maxFacturaId = maxFacturaId;
	}
}
