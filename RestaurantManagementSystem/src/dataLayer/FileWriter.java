package dataLayer;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import businessLayer.CompositeProduct;
import businessLayer.MenuItem;
import businessLayer.Order;

public class FileWriter {

	public FileWriter(Order order, ArrayList<MenuItem> items) {
		PrintWriter writer = null;
		try {
			String fileName = "BillNo" + order.getOrderID() + ".txt";
			writer = new PrintWriter(fileName, "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.println("Order No:" + order.getOrderID());
		writer.println("Table No:" + order.getTableNo());
		for (MenuItem item : items) {
			if (item instanceof CompositeProduct)
				writer.println(item.toString());
			else
				writer.println(item.getProductName());
		}

		writer.println("Total price:" + order.getTotal());
		writer.close();
	}
}
