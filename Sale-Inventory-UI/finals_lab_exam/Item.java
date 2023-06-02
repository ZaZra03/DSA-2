package finals_lab_exam;

public class Item {
	private int itemID;
	private int itemPrice, itemStock;
	private String itemName;
	private int itemSold;
	
	
	public Item(int itemID, int itemPrice, int itemStock, String itemName) {
		this.itemID = itemID;
		this.setItemPrice(itemPrice);
		this.setItemStock(itemStock);
		this.setItemName(itemName);

	}

	public int getItemID() {
		return itemID;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItemStock() {
		return itemStock;
	}

	public void setItemStock(int itemStock) {
		this.itemStock = itemStock;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemSold() {
		return itemSold;
	}

	public void setItemSold(int itemSold) {
		this.itemSold = itemSold;
	}
}
