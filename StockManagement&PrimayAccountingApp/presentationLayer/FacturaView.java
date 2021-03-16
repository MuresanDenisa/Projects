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
import javax.swing.JComboBox;
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

import businessLayer.ClientBL;
import businessLayer.DelegatBL;
import businessLayer.ProdusBL;
import model.Client;
import model.Delegat;
import model.Produs;

public class FacturaView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField filterTextField = new JTextField(20);

	private JTextField facturaIdTextField = new JTextField(13);
	private JTextField facturaDateTextField = new JTextField(10);
	private JTextField facturaNoTextField = new JTextField(12);
	private JTextField facturaTotalTextField = new JTextField(12);
	private JTextField facturaTVATextField = new JTextField(12);

	private JTextField productIdTextField = new JTextField(10);
	private JTextField quantityTextField = new JTextField(12);

	private JButton addBtn = new JButton("Adauga la factura");
	private JButton addDelegateBtn = new JButton("+");
	private JButton refreshDelegateBtn = new JButton("~");
	private JButton addClientBtn = new JButton("+");
	private JButton refreshClientBtn = new JButton("~");
	private JButton finalizareBtn = new JButton("Finalizare");
	private JButton backBtn = new JButton("Back");
	private JButton generatePDFBtn = new JButton("Exporta PDF");
	private DefaultTableModel model;
	private JTable stockJTable = new JTable(model);
	private JComboBox<Client> clientJComboBox = new JComboBox<Client>();
	private JComboBox<Delegat> delegatJComboBox = new JComboBox<Delegat>();
	private DefaultTableModel model2;
	private JTable productsJTable = new JTable(model2);

	public FacturaView() {

		JPanel content = new JPanel();
		content.setBackground(new Color(51, 153, 255));
		content.setLayout(new GridLayout(1, 2));

		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(51, 153, 255));
		panel1.setLayout(new FlowLayout());

		JLabel label1 = new JLabel("Id factura:");
		label1.setFont(new Font("Serif", Font.BOLD, 24));
		panel1.add(label1);
		facturaIdTextField.setEditable(false);
		panel1.add(facturaIdTextField);

		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(51, 153, 255));
		panel2.setLayout(new FlowLayout());

		JLabel label2 = new JLabel("Nr. factura:");
		label2.setFont(new Font("Serif", Font.BOLD, 24));
		panel2.add(label2);
		panel2.add(facturaNoTextField);

		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(51, 153, 255));
		panel3.setLayout(new FlowLayout());

		JLabel label3 = new JLabel("Data factura:");
		label3.setFont(new Font("Serif", Font.BOLD, 24));
		panel3.add(label3);
		panel3.add(facturaDateTextField);

		JPanel panel4 = new JPanel();
		panel4.setBackground(new Color(51, 153, 255));
		panel4.setLayout(new FlowLayout());

		JLabel label4 = new JLabel("Total factura:");
		label4.setFont(new Font("Serif", Font.BOLD, 24));
		panel4.add(label4);
		panel4.add(facturaTotalTextField);

		JPanel panel5 = new JPanel();
		panel5.setBackground(new Color(51, 153, 255));
		panel5.setLayout(new FlowLayout());

		JLabel label5 = new JLabel("TVA factura:");
		label5.setFont(new Font("Serif", Font.BOLD, 24));
		panel5.add(label5);
		panel5.add(facturaTVATextField);

		JPanel panel6 = new JPanel();
		panel6.setBackground(new Color(51, 153, 255));
		panel6.setLayout(new FlowLayout());

		JPanel panelBorderDelegate = new JPanel(new BorderLayout());
		panelBorderDelegate.add(addDelegateBtn, BorderLayout.WEST);
		panelBorderDelegate.add(refreshDelegateBtn, BorderLayout.EAST);

		JLabel label6 = new JLabel("Delegat:");
		label6.setFont(new Font("Serif", Font.BOLD, 24));
		panel6.add(label6);
		fillDelegatJComboBox();
		panel6.add(delegatJComboBox);
		panel6.add(panelBorderDelegate);

		JPanel panelBorderClient = new JPanel(new BorderLayout());
		panelBorderClient.add(addClientBtn, BorderLayout.WEST);
		panelBorderClient.add(refreshClientBtn, BorderLayout.EAST);

		JPanel panel7 = new JPanel();
		panel7.setBackground(new Color(51, 153, 255));
		panel7.setLayout(new FlowLayout());

		JLabel label7 = new JLabel("Client:");
		label7.setFont(new Font("Serif", Font.BOLD, 24));
		panel7.add(label7);
		fillClientJComboBox();
		panel7.add(clientJComboBox);
		panel7.add(panelBorderClient);

		JPanel panel8 = new JPanel(new BorderLayout());
		panel8.setBackground(new Color(51, 153, 255));

		JLabel label8 = new JLabel("   Id produs   Cantinate");
		label8.setFont(new Font("Serif", Font.BOLD, 20));
		panel8.add(label8, BorderLayout.NORTH);

		JPanel panel9 = new JPanel();
		panel9.setBackground(new Color(51, 153, 255));
		panel9.setLayout(new FlowLayout());
		panel9.add(productIdTextField);
		panel9.add(quantityTextField);
		panel9.add(addBtn);
		panel8.add(panel9, BorderLayout.CENTER);

		String[] column = { "ID", "Denumire", "U.M", "Cantitate", "Procent", "Pret fara TVA", "Pret vanzare" };
		String[][] data = {};

		this.model2 = new DefaultTableModel(data, column);
		productsJTable = new JTable(model2);
		productsJTable.getColumnModel().getColumn(0).setPreferredWidth(2);
		productsJTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		productsJTable.getColumnModel().getColumn(2).setPreferredWidth(15);
		productsJTable.getColumnModel().getColumn(3).setPreferredWidth(30);
		productsJTable.getColumnModel().getColumn(4).setPreferredWidth(30);
		productsJTable.getColumnModel().getColumn(5).setPreferredWidth(60);
		productsJTable.getColumnModel().getColumn(6).setPreferredWidth(60);

		JPanel panel10 = new JPanel();
		panel10.setBackground(new Color(51, 153, 255));
		JScrollPane scrollpanel = new JScrollPane(productsJTable);
		scrollpanel.setPreferredSize(new Dimension(500, 350));
		panel10.add(scrollpanel);

		JPanel panel12 = new JPanel();
		panel12.setBackground(new Color(51, 153, 255));
		panel12.setLayout(new FlowLayout());
		panel12.add(finalizareBtn);
		panel12.add(backBtn);
		panel12.add(generatePDFBtn);

		JPanel panel11 = new JPanel();
		panel11.setBackground(new Color(51, 153, 255));
		panel11.setLayout(new GridLayout(10, 0));

		addDelegateBtn.setPreferredSize(new Dimension(50, 27));
		addDelegateBtn.setFont(new Font("Serif", Font.PLAIN, 16));
		addClientBtn.setPreferredSize(new Dimension(50, 27));
		addClientBtn.setFont(new Font("Serif", Font.PLAIN, 16));
		refreshDelegateBtn.setPreferredSize(new Dimension(50, 27));
		refreshDelegateBtn.setFont(new Font("Serif", Font.PLAIN, 16));
		refreshClientBtn.setPreferredSize(new Dimension(50, 27));
		refreshClientBtn.setFont(new Font("Serif", Font.PLAIN, 16));
		generatePDFBtn.setPreferredSize(new Dimension(150, 40));
		generatePDFBtn.setFont(new Font("Serif", Font.BOLD, 16));
		addBtn.setPreferredSize(new Dimension(250, 40));
		addBtn.setFont(new Font("Serif", Font.BOLD, 16));
		finalizareBtn.setPreferredSize(new Dimension(150, 40));
		finalizareBtn.setFont(new Font("Serif", Font.BOLD, 16));
		backBtn.setPreferredSize(new Dimension(150, 40));
		backBtn.setFont(new Font("Serif", Font.BOLD, 16));

		generateTableData();
		stockJTable = new JTable(model);
		stockJTable.getColumnModel().getColumn(0).setPreferredWidth(2);
		stockJTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		stockJTable.getColumnModel().getColumn(2).setPreferredWidth(15);
		stockJTable.getColumnModel().getColumn(3).setPreferredWidth(30);
		stockJTable.getColumnModel().getColumn(4).setPreferredWidth(30);
		stockJTable.getColumnModel().getColumn(5).setPreferredWidth(60);
		stockJTable.getColumnModel().getColumn(6).setPreferredWidth(60);

		TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(stockJTable.getModel());

		stockJTable.setRowSorter(rowSorter);

		JPanel panelBorderS = new JPanel(new BorderLayout());
		panelBorderS.add(new JLabel("Introduceti produsul cautat:"), BorderLayout.WEST);
		panelBorderS.add(filterTextField, BorderLayout.CENTER);

		JScrollPane sp = new JScrollPane(stockJTable);
		sp.setPreferredSize(new Dimension(300, 300));

		JPanel panelTable = new JPanel(new BorderLayout());
		panelTable.add(panelBorderS, BorderLayout.SOUTH);
		panelTable.add(sp, BorderLayout.CENTER);

		JPanel content1 = new JPanel();
		content1.setBackground(new Color(51, 153, 255));
		content1.setLayout(new GridLayout(2, 0));
		content1.add(panelTable);
		content1.add(panel10);

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

		panel11.add(panel1);
		panel11.add(panel2);
		panel11.add(panel3);
		panel11.add(panel6);
		panel11.add(panel7);
		panel11.add(panel8);
		panel11.add(panel4);
		panel11.add(panel5);
		panel11.add(panel12);

		content.add(content1);
		content.add(panel11);

		this.setContentPane(content);
		this.pack();
		this.setTitle("Adaugare Factura");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void generateTableData() {

		ProdusBL produsBL = new ProdusBL();
		ArrayList<Produs> products = produsBL.ListAll();

		String[] column = { "ID", "Denumire", "U.M", "Cantitate", "Procent", "Pret fara TVA", "Pret vanzare" };

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
		this.model = new DefaultTableModel(data, column);
		this.stockJTable.repaint();
	}

	public void updateTable(Produs p) {

		String[] aux = new String[7];
		aux[0] = p.getIdProdus() + "";
		aux[1] = p.getDenumire() + "";
		aux[2] = p.getUm() + "";
		aux[3] = p.getCantitate() + "";
		aux[4] = p.getProcent() + "";
		aux[5] = p.getPret_fara_TVA() + "";
		aux[6] = p.getPret_vanzare() + "";
		model2.addRow(aux);
		productsJTable.repaint();
	}

	public void fillClientJComboBox() {

		ArrayList<Client> clients = new ClientBL().listAll();

		for (Client c : clients) {
			clientJComboBox.addItem(c);
		}
	}

	public JComboBox<Client> getClientJComboBox() {
		return clientJComboBox;
	}

	public void fillDelegatJComboBox() {

		ArrayList<Delegat> delegates = new DelegatBL().listAll();

		for (Delegat d : delegates) {
			delegatJComboBox.addItem(d);
		}

	}

	public void updateDelegateJComboBox(Delegat delegate) {
		delegatJComboBox.addItem(delegate);
		delegatJComboBox.repaint();
	}

	public void updateClientJComboBox(Client client) {
		clientJComboBox.addItem(client);
		clientJComboBox.repaint();
	}

	public JComboBox<Delegat> getDelegatJComboBox() {
		return delegatJComboBox;
	}

	public float getFacturaTotal() {
		if (facturaTotalTextField.getText().equals(""))
			return -1;
		return Float.valueOf(facturaTotalTextField.getText());
	}

	public void setFacturaTotal(float total) {
		this.facturaTotalTextField.setText(total + "");
	}

	public float getFacturaTVA() {
		if (facturaTVATextField.getText().equals(""))
			return -1;
		return Float.valueOf(facturaTVATextField.getText());
	}

	public void setFacturaTVA(float tva) {
		this.facturaTVATextField.setText(tva + "");
	}

	public JTable getjTable() {
		return stockJTable;
	}

	public void setjTable(DefaultTableModel model) {
		this.stockJTable = new JTable(model);
	}

	public String getFilter() {
		return filterTextField.getText();
	}

	public void setFilter() {
		this.filterTextField.setText("");
	}

	public int getFacturaId() {
		return Integer.valueOf(facturaIdTextField.getText());
	}

	public void setFacturaId(int id) {
		this.facturaIdTextField.setText("" + id);
	}

	public String getfacturaDate() {
		return facturaDateTextField.getText();
	}

	public void setfacturaDate() {
		this.facturaDateTextField.setText("");
	}

	public int getfacturaNo() {
		if (facturaNoTextField.getText().equals(""))
			return -1;
		else
			return Integer.valueOf(facturaNoTextField.getText());
	}

	public void setfacturaNo(int number) {
		this.facturaNoTextField.setText("" + number);
	}

	public int getProductId() {
		if (productIdTextField.getText().equals(""))
			return -1;
		return Integer.valueOf(productIdTextField.getText());
	}

	public void setProductId(int id) {
		this.productIdTextField.setText(id + "");
	}

	public void setEmptyProductId() {
		this.productIdTextField.setText("");
	}

	public int getQuantity() {
		if (quantityTextField.getText().equals(""))
			return -1;
		return Integer.valueOf(quantityTextField.getText());
	}

	public void setQuantityTextField() {
		this.quantityTextField.setText("");
	}

	public void refreshDelegateBtnListener(ActionListener listenForRefreshBtn) {
		refreshDelegateBtn.addActionListener(listenForRefreshBtn);
	}

	public void refreshClientBtnListener(ActionListener listenForRefreshBtn) {
		refreshClientBtn.addActionListener(listenForRefreshBtn);
	}

	public void finalizareBtnListener(ActionListener listenForFinalizareBtn) {
		finalizareBtn.addActionListener(listenForFinalizareBtn);
	}

	public void backBtnListener(ActionListener listenForBackBtn) {
		backBtn.addActionListener(listenForBackBtn);
	}

	public void addProductBtnListener(ActionListener listenForAddProductBtn) {
		addBtn.addActionListener(listenForAddProductBtn);
	}

	public void addDelegateBtnListener(ActionListener listenForAddDelegateBtn) {
		addDelegateBtn.addActionListener(listenForAddDelegateBtn);
	}

	public void addClientBtnListener(ActionListener listenForAddClientBtn) {
		addClientBtn.addActionListener(listenForAddClientBtn);
	}

	public void tableListner(MouseListener listenForTableAction) {
		stockJTable.addMouseListener(listenForTableAction);
	}

	public void generatePDFListener(ActionListener listenForGeneratePDFBtn) {
		generatePDFBtn.addActionListener(listenForGeneratePDFBtn);
	}
}
