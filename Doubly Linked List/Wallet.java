// Myo Thet Tun - 2918551 - Lab 1
/* Class Wallet */
public class Wallet {
	private Node start;
	private Node end;
	public int size;

	/* Constructor */
	public Wallet() {
		start = null;
		end = null;
		size = 0;
	}

	/* Function to get size of list */
	public int getSize() {
		return size;
	}

	public void insertAtStart(Node x) {

		x.setNext(start);

		if (start == null) {
			start = x;
			end = x;
		} else {
			start.setPrev(x);
			start = x;
		}
		size++;
	}

	public void insertAtEnd(Node x) {

		x.setPrev(end);

		if (end == null) {
			start = x;
			end = x;
		} else {
			end.setNext(x);
			end = x;
		}
		size++;
	}

	/* Function to display status of list */
	public void display() {
		System.out.print("\nWallet\n");
		if (size == 0) {
			System.out.print("empty\n");
			return;
		}
		if (start.getNext() == null) {
			System.out.println(start);
			return;
		}
		Node nd = start;
		System.out.print(start + " <-> ");
		nd = start.getNext();
		while (nd.getNext() != null) {
			System.out.print(nd + " <-> ");
			nd = nd.getNext();
		}
		System.out.print(nd + "\n");
	}

	public Node search(String id) {
		Node x = new Node();
		x = start;
		if (x == null) {
			System.out.println("Empty list!");
			return null;
		}
		while (x != null) {
			if (x.getId().equals(id)) {
				return x;
			}
			x = x.getNext();
		}
		System.out.println("Not found!");
		return null;
	}

	public boolean delete(Node x) {

		Node node = new Node();
		node = start;
		if (node == null) {
			System.out.println("Empty list!");
			return false;
		}

		while (x != null && node != null) {
			if (node.getId().equals(x.getId())) {
				// delete first item
				if (x.getPrev() != null) {
					x.getPrev().setNext(x.getNext());
				} else {
					start = x.getNext();
				}

				// delete last item
				if (x.getNext() != null) {
					x.getNext().setPrev(x.getPrev());
				} else {
					end = x.getPrev();
				}
				System.out.println("Node deleted!");
				size--;
				return true;
			}
			node = node.getNext();
		}
		System.out.println("Not found!");
		return false;
	}
}