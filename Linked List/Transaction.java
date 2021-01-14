public class Transaction implements Comparable<Transaction> {
	private String transactionID;
	private long ammount;

	public Transaction(String Id, long ammount) {
		this.transactionID = Id;
		this.ammount = ammount;
	}

	public boolean equals(Object o) {
		if (!(o instanceof Transaction)) {
			return false;
		}

		Transaction p = (Transaction) o;
		return this.transactionID.equals(p.transactionID);
	}

	public String toString() {
		return "Id: " + this.transactionID + " Ammount: " + this.ammount;
	}

	public int compareTo(Transaction o) {
		return Integer.compare((int) this.ammount, (int) o.ammount);
	}
}
