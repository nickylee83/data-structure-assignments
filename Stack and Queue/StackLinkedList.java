// Myo Thet Tun 2918551
public class StackLinkedList {
	private Node start;
	private Node end;
	public int size;
	public int max;

	/* Constructor */
	public StackLinkedList(int mx) {
		start = null;
		end = null;
		size = 0;
		max = mx;
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	public boolean isFull() {
		if (size == max) {
			return true;
		}
		return false;
	}

	public void push(Node x) {

		if (this.isFull() == false) {
			x.setPrev(end);

			if (this.isEmpty() == true) {
				start = x;
				end = x;
			} else {
				end.setNext(x);
				end = x;
			}
			System.out.println("Node added!");
			size++;
		} else {
			System.out.println("Full Stack!");
		}

	}

	public void display() {
		System.out.println("Stack Linked List");
		if (size == 0) {
			System.out.print("Empty\n");
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

	public boolean pop() {

		Node node = new Node();
		node = end;
		// remove last
		if (this.isEmpty() == false) {
			// delete node at array[0]
			if (node.getPrev() == null) {
				node = null;
				System.out.println("Node deleted!");
				size--;
				return true;
			}
			// delete node at array[1 +]
			node.getPrev().setNext(null);
			end = node.getPrev();
			System.out.println("Node deleted!");
			size--;
			return true;
		} else {
			// show empty
			System.out.println("Empty list!");
			return false;
		}
	}

	public Node search(int id) {
		Node x = new Node();
		x = start;
		if (x == null) {
			System.out.println("Empty list!");
			return null;
		}
		while (x != null) {
			if (x.getId() == id) {
				System.out.println("Found!");
				return x;
			}
			x = x.getNext();
		}
		System.out.println("Not found!");
		return null;
	}
}

class Node {
	private int id;
	private Node next, prev;

	/* Constructor */
	public Node() {
		id = 0;
		next = null;
		prev = null;
	}

	/* Constructor */
	public Node(int d) {
		id = d;
		next = null;
		prev = null;
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

	public void setId(int d) {
		id = d;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "ID:" + id;
	}

}
