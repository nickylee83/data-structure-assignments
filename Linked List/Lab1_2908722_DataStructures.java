
import java.util.Scanner;

public class Lab1_2908722_DataStructures {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		Wallet lab = new Wallet();
		for (int i = 0; i < 5; i++) {
			lab.addTransaction(k);
		}

		System.out.println(lab);// prints the wallet as a string
		lab.deleteTransaction("asdf");// removes old transactions
		lab.sort();
		System.out.println(lab + " size: " + lab.size());// prints wallet after
															// removing
															// transactions
	}
}

class Wallet {
	private LinkedList<Transaction> wallet;

	public Wallet(LinkedList<Transaction> p) {
		this.wallet = p;
	}

	public Wallet() {
		wallet = new LinkedList<Transaction>();
	}

	public void deleteTransaction(String id) {
		deleteTransaction(new Transaction(id, 0));
	}

	public void deleteTransaction(Transaction p) {
		wallet.remove(p);
	}

	public Transaction search(Transaction p) {
		return wallet.search(p).getData();
	}

	public Transaction search(String id) {
		return search(new Transaction(id, 0));
	}

	public void addTransaction(Scanner in) {
		// System.out.println("Enter Transaction Id");
		String id = in.next();
		// System.out.println("Enter ammount");
		int ammount = in.nextInt();

		Transaction temp = new Transaction(id, ammount);
		wallet.add(temp);
	}

	public void addTransaction(Transaction p) {
		wallet.add(p);
	}

	public String toString() {
		return wallet.toString();
	}

	public int size() {
		return wallet.size();
	}

	public boolean contains(Transaction p) {
		return wallet.contains(p);
	}

	public void sort() {
		wallet.sort();
	}
}