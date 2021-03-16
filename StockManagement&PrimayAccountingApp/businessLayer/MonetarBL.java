package businessLayer;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import dataAccessObjects.MonetarDAO;
import model.Monetar;

public class MonetarBL {

	private MonetarDAO monetarDAO;
	private int maxMonetarId;

	// constructor
	public MonetarBL() {

		monetarDAO = new MonetarDAO();
		setMaxMonetarId(monetarDAO.findMaxId());
	}

	/**
	 * insert function
	 * 
	 * @param monetar
	 */
	public void insertMonetar(Monetar monetar) {

		monetarDAO.insert(monetar);
	}

	/**
	 * find a monetary by its number function
	 * 
	 * @param number
	 * @return
	 */
	public Monetar findByNumber(int number) {
		ArrayList<Monetar> monetar = null;
		monetar = monetarDAO.findByNumber(number);

		if (monetar.size() == 0) {
			System.out.println("Monetarul cu numarul=" + number + " nu exista.");
			return null;
		} else
			return monetar.get(0);

	}

	/**
	 * find by id function
	 * 
	 * @param id
	 * @return
	 */
	public Monetar findById(int id) {
		Monetar monetar = monetarDAO.findById(id);

		if (monetar == null) {
			System.out.println("Monetarul cu id=" + id + "nu exista.");
			return null;
		} else
			return monetar;
	}

	/**
	 * find max id function
	 * 
	 * @return
	 */
	public int findMaxId() {

		return monetarDAO.findMaxId();
	}

	/**
	 * list all function
	 * 
	 * @return
	 */
	public ArrayList<Monetar> listAll() {

		return monetarDAO.findAll();
	}

	// getters and setters
	public int getMaxMonetarId() {
		return maxMonetarId;
	}

	public void setMaxMonetarId(int maxMonetarId) {
		this.maxMonetarId = maxMonetarId;
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
	 * generates PDF function
	 * 
	 * @param monetar
	 */
	public void generateMonetar(Monetar monetar) {
		JFrame parentComponent = new JFrame();
		JFileChooser fileChooser = new JFileChooser();
		Font font = FontFactory.getFont(FontFactory.COURIER, 16);
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

				Paragraph paragraph1 = new Paragraph();
				paragraph1.setFont(font);
				paragraph1.add("                     MONETAR nr." + monetar.getNrMonetar());
				paragraph1.add("\n");
				paragraph1.add("     Data: " + monetar.getData());
				paragraph1.add("\n");
				paragraph1.add("     Magazin: Zalau       Casa:............ ");
				paragraph1.add("\n");
				paragraph1.add("______________________________________________________");
				paragraph1.add("\n\n");
				paragraph1.add("................... buc. x 500 lei ...................");
				paragraph1.add("\n\n");
				paragraph1.add("................... buc. x 200 lei ...................");
				paragraph1.add("\n\n");
				paragraph1.add("................... buc. x 100 lei ...................");
				paragraph1.add("\n\n");
				paragraph1.add("................... buc. x  50 lei ...................");
				paragraph1.add("\n\n");
				paragraph1.add("................... buc. x  10 lei ...................");
				paragraph1.add("\n\n");
				paragraph1.add("................... buc. x   5 lei ...................");
				paragraph1.add("\n\n");
				paragraph1.add("................... buc. x   1 lei ...................");
				paragraph1.add("\n\n");
				paragraph1.add("................... buc. x 50 bani ...................");
				paragraph1.add("\n\n");
				paragraph1.add("................... buc. x 10 bani ...................");
				paragraph1.add("\n\n");
				paragraph1.add("................... buc. x  5 bani ...................");
				paragraph1.add("\n\n");
				paragraph1.add("................... buc. x  1 bani ...................");
				paragraph1.add("\n\n");

				Paragraph paragraph2 = new Paragraph();
				paragraph2.setFont(font);
				paragraph2.add("                    TOTAL LEI: " + monetar.getTotal());
				paragraph2.add("\n\n");
				paragraph2.add("Casier predator,                     Casier primitor,");
				paragraph2.add("\n\n");
				paragraph2.add("................                     ................");
				paragraph2.add("\n\n");
				paragraph2.add("                     Responsabil, ....................");
				try {
					document.add(paragraph);
					document.add(paragraph1);
					document.add(paragraph2);

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
}
