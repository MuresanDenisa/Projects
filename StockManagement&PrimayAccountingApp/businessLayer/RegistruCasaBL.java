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

import dataAccessObjects.RegistruCasaDAO;
import model.InregistrariRegistru;
import model.RegistruCasa;

public class RegistruCasaBL {

	private RegistruCasaDAO registruCasaDAO;
	private int maxRegistruId;

	// constructor
	public RegistruCasaBL() {

		registruCasaDAO = new RegistruCasaDAO();
		setMaxRegistruId(registruCasaDAO.findMaxId());
	}

	/**
	 * Insert function
	 * 
	 * @param registru
	 */
	public void insertRegistruCasa(RegistruCasa registru) {

		registruCasaDAO.insert(registru);
	}

	/**
	 * find by id function
	 * 
	 * @param id
	 * @return
	 */
	public RegistruCasa findById(int id) {
		return registruCasaDAO.findById(id);
	}

	/**
	 * find max id function
	 * 
	 * @return
	 */
	public int findMaxId() {

		return registruCasaDAO.findMaxId();

	}

	/**
	 * list al function
	 * 
	 * @return
	 */
	public ArrayList<RegistruCasa> listAll() {

		return registruCasaDAO.findAll();
	}

	/**
	 * generate PDF
	 * 
	 * @param registru
	 * @param inreg
	 */
	public void generateRegistru(RegistruCasa registru, ArrayList<InregistrariRegistru> inreg) {
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
				String[] parts = registru.getData().split("/");
				paragraph.add("Unitatea: NIDAROM AUTO S.R.L          Data       Numar");
				paragraph.add("RO 13811950                        ZI LUNA  AN    Poz ");
				paragraph.add("J31/70/19.03.2001                  " + parts[0] + "  " + parts[1] + " " + parts[2]
						+ "     " + registru.getNrPoz());

				paragraph.add("\n\n\n");
				paragraph.add("                     REGISTRU CASA");
				paragraph.add("\n\n");

				float[] relativeWidths = { 100, 500, 300, 300 };
				PdfPTable table = new PdfPTable(4);
				table.setWidths(relativeWidths);
				table.setTotalWidth(PageSize.A4.getWidth() - 40);
				table.setLockedWidth(true);

				PdfPCell cell = new PdfPCell(new Phrase("Nr.Crt", font));
				cell.setFixedHeight(30);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase("EXPLICATIE", font));
				cell.setFixedHeight(30);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase("Incasari", font));
				cell.setFixedHeight(30);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase("Plati", font));
				cell.setFixedHeight(30);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				table.setHeaderRows(1);

				PdfPCell cellBlankRow = new PdfPCell(new Phrase(" "));
				cell.setColspan(4);
				cell.setHorizontalAlignment(1);
				table.addCell(cellBlankRow);
				table.addCell("");
				table.addCell(new Phrase("" + registru.getSoldInitial(), font));
				table.addCell("");

				for (InregistrariRegistru i : inreg) {
					table.addCell(new Phrase(i.getNrCurent() + "", font));
					table.addCell(new Phrase(i.getDenumire() + "", font));
					table.addCell(new Phrase(i.getIncasari() + "", font));
					table.addCell(new Phrase(i.getPlati() + "", font));

				}

				paragraph.add(table);
				paragraph.add("\n");
				paragraph.add("______________________________________________________");
				paragraph.add("\n\n");
				paragraph.add("        Raport pagina total: " + registru.getSoldFinal());
				paragraph.add("\n\n");
				paragraph.add("Casier");

				try {
					document.add(paragraph);
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

	// setters and getters
	public int getMaxRegistruId() {
		return maxRegistruId;
	}

	public void setMaxRegistruId(int maxRegistruId) {
		this.maxRegistruId = maxRegistruId;
	}
}
