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

import dataAccessObjects.ReceptieDAO;
import model.Furnizor;
import model.Produs;
import model.Receptie;

public class ReceptieBL {

	private ReceptieDAO receptieDAO;
	private int maxReceptieId;

	// constructor
	public ReceptieBL() {

		receptieDAO = new ReceptieDAO();
		this.setMaxReceptieId(receptieDAO.findMaxId());
	}

	/**
	 * insert function
	 * 
	 * @param receptie
	 */
	public void insertReceptie(Receptie receptie) {

		receptieDAO.insert(receptie);
	}

	/**
	 * find max id function
	 * 
	 * @return
	 */
	public int findMaxId() {

		return receptieDAO.findMaxId();
	}

	/**
	 * find by id function
	 * 
	 * @param id
	 * @return
	 */
	public Receptie findById(int id) {
		return receptieDAO.findById(id);
	}

	/**
	 * list all function
	 * 
	 * @return
	 */
	public ArrayList<Receptie> listAll() {

		return receptieDAO.findAll();
	}

	/**
	 * generate pdf
	 * 
	 * @param furnizor
	 * @param products
	 * @param receptie
	 */
	public void generatePDF(Furnizor furnizor, ArrayList<Produs> products, Receptie receptie) {
		JFrame parentComponent = new JFrame();
		JFileChooser fileChooser = new JFileChooser();
		Font font = FontFactory.getFont(FontFactory.COURIER, 10);
		// Some init code, if you need one, like setting title
		int returnValue = fileChooser.showOpenDialog(parentComponent);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();
			try {
				Document document = new Document(PageSize.A4);
				PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileToSave + ".pdf"));
				document.open();

				Paragraph paragraph = new Paragraph();
				paragraph.setFont(font);
				paragraph.add("Nota de receptie");
				paragraph.add("\n");
				paragraph.add("Unitatea: NIDAROM AUTO S.R.L          Data:" + receptie.getDataReceptie() + "     Numar:"
						+ receptie.getNrReceptie());
				paragraph.add("\n");
				paragraph.setAlignment(Element.ALIGN_CENTER);

				float[] relativeWidths = { 250, 200, 300, 500, 250 };
				PdfPTable table = new PdfPTable(5);
				table.setWidths(relativeWidths);
				table.setTotalWidth(PageSize.A4.getWidth() - 20);
				table.setLockedWidth(true);

				PdfPCell cell = new PdfPCell(new Phrase("Document Livrare", font));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase("NR.", font));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase("DATA", font));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase("FURNIZORUL", font));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase("COD FISCAL", font));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				table.setHeaderRows(1);
				table.addCell(new Phrase("Factura", font));
				table.addCell(new Phrase(receptie.getNrFactura() + "", font));
				table.addCell(new Phrase(receptie.getDataFactura() + "", font));
				table.addCell(new Phrase(furnizor.getFurnizor() + "", font));
				table.addCell(new Phrase(furnizor.getCif(), font));

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
				for (Produs p : products) {
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
				paragraph.add("____________________________________________________________________________________");
				paragraph.add("\n\n");
				paragraph.add("Total factura: " + receptie.getTotalFactura() + "           Total receptie: "
						+ receptie.getTotalReceptie());
				paragraph.add("\n\n");
				paragraph.add("GESTIONAR:");

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
	public int getMaxReceptieId() {
		return maxReceptieId;
	}

	public void setMaxReceptieId(int maxReceptieId) {
		this.maxReceptieId = maxReceptieId;
	}
}
