// Myo Thet Tun - 2918551 - Lab 1
public class Node {
	private String id;
	private Node next, prev;
	private double amount;

	/* Constructor */
	public Node() {
		next = null;
		prev = null;
		id = "";
		amount = 0;
	}

	/* Constructor */
	public Node(String d,double amt) {
		id = d;
		next = null;
		prev = null;
		amount = amt;
	}

	public void setNext(Node n) {
		next = n;
	}

	public void setPrev(Node p) {
		prev = p;
	}

	public Node getNext() {
		return next;
	}

	public Node getPrev() {
		return prev;
	}

	public void setId(String d) {
		id = d;
	}

	public String getId() {
		return id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amt) {
		amount = amt;
	}
	
	@Override
	public String toString() {
		return id + ", " + amount;
	}

}
