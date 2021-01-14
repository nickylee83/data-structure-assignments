import java.util.Arrays;

public class LinkedList<T> {
	private Link<T> Head = null;
	private Link<T> Tail = null;
	private int size = 0;

	public void add(T data) {
		Link<T> p = new Link<T>(data);
		if (Head == null) {
			Head = p;
			Tail = p;
			size++;
		} else {
			p.setNext(Head);
			Head.setPrev(p);
			Head = p;
			size++;
		}
	}

	public Link<T> search(T node) {
		Link<T> k = Head;
		while (k != null) {
			if (k.getData().equals(node)) {
				return k;
			}
			k = k.next();
		}

		return null;
	}

	public boolean contains(T node) {
		return search(node) != null;
	}

	public void remove(T node) {
		Link<T> n = Head;
		while (n != null) {// removes all equal nodes
			if (n.getData().equals(node)) {
				if (size <= 1) {// removes last element
					Tail = null;
					Head = null;
					size--;
				}
				if (n.prev() == null && Head != null) {// if element is at the
														// head
					Head = n.next();
					Head.setPrev(null);
					size--;
				}
				if (n.next() == null && Tail != null) {// if element is at the
														// tail
					Tail = n.prev();
					Tail.setNext(null);
					size--;
				}
				if (n.prev() != null && n.next() != null) {// the element is in
															// the middle
					n.prev().setNext(n.next());
					n.next().setPrev(n.prev());
					size--;
				}
			}
			n = n.next();
		}
	}

	public int size() {
		return this.size;
	}

	public Link<T> popHead() {
		if (Head != null) {
			Link<T> temp = Head;
			Head = Head.next();
			return temp;
		}
		return null;
	}

	public void modify(T node, T replacement) {
		Link<T> k = Head;
		while (k != null) {// replace every ocurrence of the node
			if (k.getData().equals(node)) {
				k.setData(replacement);
			} else {
				k = k.next();
			}
		}
	}

	public T[] toArray() {
		T[] ret = (T[]) new Object[size];
		Link<T> k = Head;
		for (int i = 0; i < size; i++) {
			ret[i] = k.getData();
			k = k.next();
		}

		return ret;

	}

	public String toString() {
		return Arrays.toString(toArray());
	}

	public void sort() {
		T[] unsorted = toArray();
		Arrays.sort(unsorted);
		Head = null;
		size = 0;
		Arrays.stream(unsorted).forEach(this::add);// adds each element of the
													// array to the link list
	}
}

class Link<T> {
	private T data;
	private Link<T> next;
	private Link<T> prev;

	public Link(T data) {
		this.data = data;
	}

	public T getData() {
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Link<T> next() {
		return this.next;
	}

	public Link<T> prev() {
		return this.prev;
	}

	public void setNext(Link<T> node) {
		this.next = node;
	}

	public void setPrev(Link<T> node) {
		this.prev = node;
	}

	public String toString() {
		return this.data.toString();
	}
}
