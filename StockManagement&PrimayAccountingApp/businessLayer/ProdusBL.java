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

import dataAccessObjects.ProdusDAO;
import model.Produs;

public class ProdusBL {

	private ProdusDAO produsDAO;
	private int maxProdusId;

	// Constructor
	public ProdusBL() {
		this.produsDAO = new ProdusDAO();
		this.setMaxProdusId(produsDAO.findMaxId());
	}

	/**
	 * Insert function
	 * 
	 * @param newProduct
	 */
	public void InsertProduct(Produs newProduct) {

		if (newProduct != null)
			produsDAO.insert(newProduct);
	}

	/**
	 * Increase quantity of a product function
	 * 
	 * @param name
	 * @param price
	 * @param newQuantity
	 */
	public void UpdatePlusQuantity(String name, float price, int newQuantity) {

		produsDAO.updatePlus(name, price, newQuantity);
	}

	/**
	 * Decrease quantity of a product function
	 * 
	 * @param id
	 * @param name
	 * @param price
	 * @param newQuantity
	 */
	public void UpdateMinusQuantity(int id, String name, float price, int newQuantity) {
		produsDAO.updateMinus(id, name, price, newQuantity);
	}

	/**
	 * find by id function
	 * 
	 * @param id
	 * @return
	 */
	public Produs findById(int id) {

		Produs produs = produsDAO.findById(id);

		if (produs == null) {
			System.out.println("Produsul cu id=" + id + " nu exista.");
			return null;
		} else
			return produs;
	}

	/**
	 * find by name function
	 * 
	 * @param name
	 * @return
	 */
	public ArrayList<Produs> findByName(String name) {

		ArrayList<Produs> produs = produsDAO.findByName(name);

		if (produs == null) {
			System.out.println("Produsul cu numele " + name + " nu exista.");
			return null;
		} else
			return produs;
	}

	/**
	 * Finds products in a certain reception function
	 * 
	 * @param idF
	 * @return
	 */
	public ArrayList<Produs> findProductsF(int idF) {
		return produsDAO.findProductsF(idF);
	}

	/**
	 * finds products in a certain invoice function
	 * 
	 * @param idR
	 * @return
	 */
	public ArrayList<Produs> findProductsR(int idR) {
		return produsDAO.findProductsR(idR);
	}

	/**
	 * Adds an empty line in a document
	 * 
	 * @param paragraph
	 * @param number
	 */
	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

	/**
	 * generates pdf
	 * 
	 * @param products
	 */
	public void generateStockPDF(ArrayList<Produs> products) {
		JFrame parentComponent = new JFrame();
		JFileChooser fileChooser = new JFileChooser();
		Font font = FontFactory.getFont(FontFactory.COURIER, 12);
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
				paragraph.add("Unitate: NIDAROM AUTO S.R.L");
				paragraph.add("\n");
				paragraph.add("Nr. O.R.C./an: J31/70/19.03.2001");
				paragraph.add("\n");
				paragraph.add("C.U.I.: RO13811950");
				paragraph.add("\n");
				paragraph.add("Capital Social: 200 Lei");
				paragraph.add("\n");
				paragraph.add("Sediul: Zalau, str. Tudor Vladimirescu, bl.G-164, Parter");
				paragraph.add("\n");
				paragraph.add("Judetul: Salaj");
				addEmptyLine(paragraph, 4);

				PdfPTable table = new PdfPTable(7);
				Paragraph paragraph1 = new Paragraph();
				float[] relativeWidths = { 100, 500, 120, 200, 200, 200, 200 };
				table.setWidths(relativeWidths);
				table.setTotalWidth(PageSize.A4.getWidth() - 40);
				table.setLockedWidth(true);
				paragraph1.setFont(font);
				paragraph1.add(table);

				PdfPCell cell = new PdfPCell(new Phrase("ID", font));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase("Denumire", font));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase("U.M", font));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase("Cant.", font));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase("Procent", font));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase("Pret fara TVA", font));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase("Pret Vanzare", font));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				table.setHeaderRows(1);

				Float total = (float) 0.0;
				int counter = 0;

				for (Produs p : products) {
					table.addCell(new Phrase(p.getIdProdus() + "", font));
					table.addCell(new Phrase(p.getDenumire() + "", font));
					table.addCell(new Phrase(p.getUm() + "", font));
					table.addCell(new Phrase(p.getCantitate() + "", font));
					table.addCell(new Phrase(p.getProcent() + "", font));
					table.addCell(new Phrase(p.getPret_fara_TVA() + "", font));
					table.addCell(new Phrase(p.getPret_vanzare() + "", font));

					counter++;
					total += p.getPret_vanzare();

					if (products.size() == counter) {
						addEmptyLine(paragraph1, 3);
						paragraph1.add("Total :" + total);
					}
				}

				try {
					document.add(paragraph);
					document.add(paragraph1);

				} catch (DocumentException e) {
					e.printStackTrace();
				}
				document.close();
				JOptionPane.showMessageDialog(null, "PDF Salvat");

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}

	/**
	 * find max id function
	 * 
	 * @return
	 */
	public int findMaxId() {

		return produsDAO.findMaxId();
	}

	/**
	 * list all function
	 * 
	 * @return
	 */
	public ArrayList<Produs> ListAll() {

		return produsDAO.findAll();
	}

	// getters and setters
	public int getMaxProdusId() {
		return maxProdusId;
	}

	public void setMaxProdusId(int maxProdusId) {
		this.maxProdusId = maxProdusId;
	}

}
