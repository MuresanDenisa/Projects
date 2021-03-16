package businessLayer;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	private int OrderID;
	private Date date;
	private int tableNo;
	private float total;

	/**
	 * public constructor, sets the datas of a new order
	 * 
	 * @param id
	 * @param date
	 * @param table
	 * @param items
	 */
	public Order(int id, Date date, int table) {
		this.OrderID = id;
		this.date = date;
		this.tableNo = table;
	}

	@Override
	public int hashCode() {
		int hashCode = 31;
		hashCode += hashCode * OrderID + hashCode * date.getDay() + hashCode * date.getMonth()
				+ hashCode * date.getYear() + hashCode * tableNo;
		return hashCode;

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (this.getClass() != obj.getClass())
			return false;

		Order newOrder = (Order) obj;

		if (this.OrderID != newOrder.OrderID)
			return false;
		if (this.date.getDay() != newOrder.date.getDay())
			return false;
		if (this.date.getMonth() != newOrder.date.getMonth())
			return false;
		if (this.date.getYear() != newOrder.date.getYear())
			return false;
		if (this.tableNo != newOrder.tableNo)
			return false;

		return true;
	}

	@Override
	public String toString() {
		String string = "";

		string += "Order no: " + this.getOrderID() + "\nTable no:" + this.getTableNo() + "\n";

		return string;

	}

	// getters and setters
	public int getOrderID() {
		return OrderID;
	}

	public void setOrderID(int orderID) {
		OrderID = orderID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTableNo() {
		return tableNo;
	}

	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

}
