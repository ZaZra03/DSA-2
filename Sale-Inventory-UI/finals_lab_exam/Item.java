/**
 * The Item class is a representation of an item in a Java application,
 * containing important attributes such as itemID, itemPrice, itemStock,
 * itemName, itemSold, and itemTotal. It includes a constructor that initializes
 * its fields, as well as getter and setter methods for each attribute. The
 * class serves as a model for an item, facilitating storage, manipulation, and
 * use of the item's data in various business contexts such as inventory
 * management or point-of-sale systems.
 *
 * @class Item
 *
 * @author Eugene Lawrence Autos
 * @author Ezra Micah Malsi
 * @author Hans Neil Emnacin
 * @author Marc Ryzon Elomina
 * @author Mark Cedrick De Vera
 * @author Rizaldy Cantalejo
 * 
 * @see Array
 * @see Main
 * @see Transaction
 */
public class Item {
	// Class fields
	private int itemID;
	private int itemPrice, itemStock;
	private String itemName;
	private int itemSold;
	private int itemTotal;

	// Constructor
	public Item(int itemID, int itemPrice, int itemStock, String itemName) {
		this.itemID = itemID;
		this.setItemPrice(itemPrice);
		this.setItemStock(itemStock);
		this.setItemName(itemName);

	}

	// Getters and Setters
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

	public int getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(int itemTotal) {
		this.itemTotal = itemTotal;
	}
}
