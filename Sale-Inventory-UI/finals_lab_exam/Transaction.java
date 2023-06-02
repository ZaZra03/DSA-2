package finals_lab_exam;

public class Transaction {
	private int transactionID;
	private Array<Item> record = new Array<Item>(10);
	
	public Transaction(int transactionID) {
		this.transactionID = transactionID;
	}
}
