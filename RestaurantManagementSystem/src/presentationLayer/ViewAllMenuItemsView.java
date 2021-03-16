package presentationLayer;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import businessLayer.CompositeProduct;
import businessLayer.MenuItem;

public class ViewAllMenuItemsView extends JFrame {

	public ViewAllMenuItemsView(ArrayList<MenuItem> menu) {
		// Layout the table
		String columns[] = { "Name", "Price" };
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columns);

		// Create the content
		Object[] rowData = new Object[2];

		for (MenuItem item : menu) {
			if (item instanceof CompositeProduct)
				rowData[0] = item.toString();
			else
				rowData[0] = item.getProductName();
			rowData[1] = item.getPrice();
			tableModel.addRow(rowData);
		}

		// Finalize layout
		JTable table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		this.setBounds(500, 250, 800, 300);
		this.setContentPane(scrollPane);
		this.pack();
		this.setTitle("View All MenuItems View");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
}
