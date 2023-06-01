package finals_lab_exam;

public class Order {
	private int orderID;
	private int orderPrice, orderCount;
	private String orderName;
	
	public Order(int orderID, int orderPrice, int orderCount, String orderName) {
		this.setOrderID(orderID);
		this.setOrderPrice(orderPrice);
		this.setOrderCount(orderCount);
		this.setOrderName(orderName);
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
}
