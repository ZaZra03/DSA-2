package finals_lab_exam;

public class Transaction {
	private int transactionID;
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
}
