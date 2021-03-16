package presentationLayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import businessLayer.ProdusBL;
import model.Produs;

public class VanzareView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField filterTextField = new JTextField(20);
	private JTextField productIdTextField = new JTextField(20);
	private JTextField productNameTextField = new JTextField(16);
	private JTextField priceTextField = new JTextField(9);
	private JTextField quantityTextField = new JTextField(12);
	private JButton finalizareBtn = new JButton("Finalizare");
	private JButton backBtn = new JButton("Back");
	private JTable jTable;

	public VanzareView() {

		JPanel content = new JPanel();
		content.setBackground(new Color(51, 153, 255));
		content.setLayout(new GridLayout(1, 2));

		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(51, 153, 255));
		panel1.setLayout(new FlowLayout());
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(51, 153, 255));
		panel2.setLayout(new FlowLayout());
		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(51, 153, 255));
		panel3.setLayout(new FlowLayout());
		JPanel panel4 = new JPanel();
		panel4.setBackground(new Color(51, 153, 255));
		panel4.setLayout(new FlowLayout());
		JPanel panel5 = new JPanel();
		panel5.setBackground(new Color(51, 153, 255));
		panel5.setLayout(new GridLayout(5, 0));
		JPanel panel6 = new JPanel();
		panel6.setBackground(new Color(51, 153, 255));
		panel6.setLayout(new FlowLayout());

		finalizareBtn.setPreferredSize(new Dimension(300, 40));
		finalizareBtn.setFont(new Font("Serif", Font.BOLD, 16));
		backBtn.setPreferredSize(new Dimension(300, 40));
		backBtn.setFont(new Font("Serif", Font.BOLD, 16));

		ProdusBL produsBL = new ProdusBL();
		ArrayList<Produs> products = produsBL.ListAll();
		String[] column = { "ID", "Denumire", "U.M", "Cantitate", "Procent", "Pret fara TVA", "Pret vanzare" };
		String[][] data = generateTableData(products);

		DefaultTableModel model = new DefaultTableModel(data, column);
		jTable = new JTable(model);

		jTable.getColumnModel().getColumn(0).setPreferredWidth(2);
		jTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		jTable.getColumnModel().getColumn(2).setPreferredWidth(15);
		jTable.getColumnModel().getColumn(3).setPreferredWidth(30);
		jTable.getColumnModel().getColumn(4).setPreferredWidth(30);
		jTable.getColumnModel().getColumn(5).setPreferredWidth(60);
		jTable.getColumnModel().getColumn(6).setPreferredWidth(60);

		TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(jTable.getModel());

		jTable.setRowSorter(rowSorter);

		JPanel panelTable = new JPanel(new BorderLayout());
		panelTable.add(new JLabel("Introduceti produsul cautat:"), BorderLayout.WEST);
		panelTable.add(filterTextField, BorderLayout.CENTER);

		JScrollPane sp = new JScrollPane(jTable);

		JPanel panelT = new JPanel(new BorderLayout());
		panelT.add(panelTable, BorderLayout.SOUTH);
		panelT.add(sp, BorderLayout.CENTER);

		filterTextField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = filterTextField.getText();

				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String text = filterTextField.getText();

				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods,
																				// choose Tools | Templates.
			}

		});

		JLabel label1 = new JLabel("Id produs:");
		label1.setFont(new Font("Serif", Font.BOLD, 24));
		panel1.add(label1);
		panel1.add(productIdTextField);

		JLabel label2 = new JLabel("Nume produs:");
		label2.setFont(new Font("Serif", Font.BOLD, 24));
		panel2.add(label2);
		panel2.add(productNameTextField);

		JLabel label3 = new JLabel("Pret fara TVA produs:");
		label3.setFont(new Font("Serif", Font.BOLD, 24));
		panel3.add(label3);
		panel3.add(priceTextField);

		JLabel label4 = new JLabel("Cantitate vanduta:");
		label4.setFont(new Font("Serif", Font.BOLD, 24));
		panel6.add(label4);
		panel6.add(quantityTextField);

		panel4.add(finalizareBtn);
		panel4.add(backBtn);

		panel5.add(panel1);
		panel5.add(panel2);
		panel5.add(panel3);
		panel5.add(panel6);
		panel5.add(panel4);

		content.add(panelT);
		content.add(panel5);

		this.setContentPane(content);
		this.pack();
		this.setTitle("Vanzare");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public String[][] generateTableData(ArrayList<Produs> products) {
		int size = products.size();
		String[][] data = new String[size][7];
		int i = 0;

		for (Produs p : products) {

			String[] aux = new String[7];
			aux[0] = p.getIdProdus() + "";
			aux[1] = p.getDenumire() + "";
			aux[2] = p.getUm() + "";
			aux[3] = p.getCantitate() + "";
			aux[4] = p.getProcent() + "";
			aux[5] = p.getPret_fara_TVA() + "";
			aux[6] = p.getPret_vanzare() + "";

			data[i++] = aux;
		}
		return data;
	}

	public int getIdProdus() {
		return Integer.valueOf(this.productIdTextField.getText());
	}

	public void setIdProdus(int id) {
		this.productIdTextField.setText("" + id);
	}

	public String getNumeProdus() {
		return this.productNameTextField.getText();
	}

	public void setNumeProdus(String name) {
		this.productNameTextField.setText(name);
	}

	public float getPrice() {
		return Float.valueOf(this.priceTextField.getText());
	}

	public void setPrice(float price) {
		this.priceTextField.setText(price + "");
	}

	public int getQuantity() {
		return Integer.valueOf(this.quantityTextField.getText());
	}

	public void setQuantity() {
		this.quantityTextField.setText("0");
	}

	public JTextField getFilterTextField() {
		return filterTextField;
	}

	public void setFilterTextField(JTextField filterTextField) {
		this.filterTextField = filterTextField;
	}

	public void finalizareBtnListener(ActionListener listenForFinalizareBtn) {
		finalizareBtn.addActionListener(listenForFinalizareBtn);
	}

	public void backBtnListener(ActionListener listenForBackBtn) {
		backBtn.addActionListener(listenForBackBtn);
	}

	public void tableListner(MouseListener listenForTableAction) {
		jTable.addMouseListener(listenForTableAction);
	}

	public JTable getjTable() {
		return jTable;
	}

	public void setjTable(JTable jTable) {
		this.jTable = jTable;
	}

}
