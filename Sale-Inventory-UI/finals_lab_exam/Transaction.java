/**
 * The Transaction class models a transaction with attributes such as
 * transactionID, transactionTotal, and a record containing an Array of Item
 * objects. The class provides a constructor to initialize the transactionID,
 * getter and setter methods for the record and transaction total, and a
 * displayRecords() method to print the transaction details. The
 * displayRecords() method iterates through the Array, formatting and displaying
 * the item details, and prints the transaction total. This class is useful in
 * scenarios where you need to keep track of sales, purchases, or other types of
 * transactions involving multiple items.
 *
 * @class Transaction
 *
 * @author Eugene Lawrence Autos
 * @author Ezra Micah Malsi
 * @author Hans Neil Emnacin
 * @author Marc Ryzon Elomina
 * @author Mark Cedrick De Vera
 * @author Rizaldy Cantalejo
 * 
 * @see Array
 * @see Item
 * @see Main
 */
public class Transaction {
	// Class fields
	private int transactionID;
	private int transactionTotal;
	private Array<Item> record = new Array<Item>(10);

	// Constructor
	public Transaction(int transactionID) {
		this.transactionID = transactionID;
	}

	// Getters and Setters
	public Array<Item> getRecord() {
		return record;
	}

	public void setRecord(Array<Item> record) {
		this.record = record;
	}

	public int getTransactionTotal() {
		return transactionTotal;
	}

	public void setTransactionTotal(int transactionTotal) {
		this.transactionTotal = transactionTotal;
	}

	/**
	 * This method displays the records of a transaction.
	 */
	public void displayRecords() {
		System.out.println("\nTransaction ID: " + transactionID);
		for (int i = 0; i < record.getSize(); i++) {
			if (record.getArray()[i] != null) {
				Item currentItem = (Item) record.getArray()[i];
				System.out.printf("%-10s %-1s x %-5s   Php %-1s%n", currentItem.getItemName(),
						currentItem.getItemPrice(), currentItem.getItemSold(), currentItem.getItemTotal());
			} else {
				break;
			}
		}
		System.out.println("Total: Php " + this.transactionTotal);
	}
}
