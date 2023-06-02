package finals_lab_exam;

public class Transaction {
	private int transactionID;
	private int transactionTotal;
	private Array<Item> record = new Array<Item>(10);
	
	public Transaction(int transactionID) {
		this.transactionID = transactionID;
	}

	public Array<Item> getRecord() {
		return record;
	}

	public void setRecord(Array<Item> record) {
		this.record = record;
	}
	
	public void displayRecords() {
		System.out.println("Transaction ID: " + transactionID);
		for(int i = 0; i < record.getSize(); i++) {
			if(record.getArray()[i] != null) {
				Item currentItem = (Item) record.getArray()[i];
				System.out.printf("%-10s %-1s x %-5s  %-1s %s%n", currentItem.getItemName(), currentItem.getItemPrice(), currentItem.getItemSold(), currentItem.getItemTotal());
			} else break;
		}
		System.out.println("Total: " + this.transactionTotal);
	}

	public int getTransactionTotal() {
		return transactionTotal;
	}

	public void setTransactionTotal(int transactionTotal) {
		this.transactionTotal = transactionTotal;
	}
}
