
/*
*  Assignment 6_2018
*  Student name: Myo Thet Tun
*  Student number: 2918551
*/

// import java.io.*;
import java.util.*;

public class Assignment6_2018 {

	public static void main(String[] args) {
		BinarySearchTree<Word> bt = new BinarySearchTree<Word>();
		Random ran = new Random(100);
		String s = "";
		Word randomWord[] = new Word[20];
		for (int i = 0; i < 20; i++) {
			char a = (char) (ran.nextInt(26) + 'a');
			char b = (char) (ran.nextInt(26) + 'a');
			char c = (char) (ran.nextInt(26) + 'a');
			char d = (char) (ran.nextInt(26) + 'a');
			s = "" + a + b + c + d;
			randomWord[i] = new Word(s);
			bt.add(randomWord[i]);
		}

		// randomWord[0] = new Word("3");
		// randomWord[1] = new Word("1");
		// randomWord[2] = new Word("10");
		// randomWord[3] = new Word("21");
		// randomWord[4] = new Word("11");
		// randomWord[5] = new Word("0");
		// randomWord[6] = new Word("45");
		// randomWord[7] = new Word("33");
		// randomWord[8] = new Word("41");
		// randomWord[9] = new Word("56");
		// randomWord[10] = new Word("44");
		//
		// bt.add(randomWord[0]);
		// bt.add(randomWord[1]);
		// bt.add(randomWord[2]);
		// bt.add(randomWord[3]);
		// bt.add(randomWord[4]);
		// bt.add(randomWord[5]);
		// bt.add(randomWord[6]);
		// bt.add(randomWord[7]);
		// bt.add(randomWord[8]);
		// bt.add(randomWord[9]);
		// bt.add(randomWord[10]);

		System.out.println(bt);
		System.out.println("Height = " + bt.height());
		bt.remove(randomWord[2]);
		System.out.println("\nAfter removing 'dbyp'");
		System.out.println(bt);
		ArrayList<Word> al = new ArrayList<>();

		al.addAll(bt.leafNodes());
		System.out.print("Leaf Nodes = ");
		// for (int i = 0; i < al.size(); i++) {
		System.out.println(al);
		// }

		System.out.println("Balance = " + bt.balance());

		System.out.println("PreOrder= " + bt.preOrder());
		System.out.println("InOrder= " + bt.inOrder());
		System.out.println("PostOrder= " + bt.postOrder());

		System.out.println("Max Element = " + bt.maxElement());
		System.out.println("Size = " + bt.size());

	}
}

class Word implements Comparable<Word> {
	private String word;

	Word(String s) {
		assert nonBlank(s);
		word = s;
	}

	public String word() {
		return word;
	}

	public String toString() {
		return word;
	}

	public int compareTo(Word wd) {
		if (wd == null)
			return -1;
		return word.compareTo(wd.word());
	}

	public boolean equals(Object ob) {
		if (!(ob instanceof Word))
			return false;
		Word wd = (Word) ob;
		return word.equals(wd.word);
	}

	public int hashCode() {
		return word.hashCode();
	}

	private boolean nonBlank(String s) {
		for (int j = 0; j < s.length(); j++)
			if (s.charAt(j) == ' ')
				return false;
		return true;
	}
}

class BinarySearchTree<E extends Comparable<E>> implements Iterable<E> {
	private BNode<E> root;
	private int count;

	public BinarySearchTree() {
		root = null;
		count = 0;
	}

	public BinarySearchTree(Collection<? extends E> ls) {
		root = null;
		count = 0;
		for (E x : ls)
			this.add(x);
	}

	/*
	 * ==================================================== Assignment 8 Code
	 * for methods in Question 2
	 * 
	 * 
	 * public List<E> leafNodes(){}
	 * 
	 * public int balance(){}
	 * 
	 */
	public int balance() {
		// System.out.println("Root = " + root.data());
		if (root == null) {
			return 0;
		}
		return countNodes(root);
	}

	int leftCounter = 0;
	int rightCounter = 0;

	public int countNodes(BNode<E> myRoot) {

		if (myRoot.right() != null) {
			// countNodes(myRoot.right());
			rightCounter++;
			// System.out.println("Data right = " + myRoot.right.data());
			myRoot = myRoot.right();
			countNodes(myRoot);
			if (myRoot.left() == null && myRoot.right() == null) {
				// System.out.println("Data = " + myRoot.data());
				rightCounter++;
				// countNodes(myRoot);
			}

		} else if (myRoot.left() != null) {
			// countNodes(myRoot.left());
			// System.out.println("Data left = " + myRoot.left.data());
			leftCounter++;
			myRoot = myRoot.left();
			countNodes(myRoot);
			if (myRoot.left() == null && myRoot.right() == null) {
				leftCounter++;

				// countNodes(myRoot);
			}
			// countNodes(myRoot.left());
		}

		System.out.println(leftCounter + ", " + rightCounter);
		return leftCounter - rightCounter;
	}

	public E maxElement() {
		while (root.right != null) {
			root = root.right;
		}
		return root.data();
	}

	public ArrayList<E> leafNodes() {
		if (root == null) {
			return null;
		}
		ArrayList<E> leaf = new ArrayList<>();

		myLeafNode(leaf, root);
		return leaf;
	}

	private void myLeafNode(ArrayList<E> leaf, BNode<E> myRoot) {

		// if (myRoot.right() != null || myRoot.left() != null) {
		// myLeafNode(leaf, myRoot);

		// myLeafNode(leaf,myRoot);
		if (myRoot.left() != null) {

			myRoot = myRoot.left();
			myLeafNode(leaf, myRoot);
			if (myRoot.left() == null && myRoot.right() == null) {
				leaf.add(myRoot.data());
			}
			if (myRoot.right() != null) {
				myRoot = myRoot.right();
				myLeafNode(leaf, myRoot);
				if (myRoot.left() == null && myRoot.right() == null) {
					leaf.add(myRoot.data());
				}
			}
		}
		// myLeafNode(leaf,myRoot);
		// }

	}
	// private ArrayList<E> myLeafNode(ArrayList<E> leaf, BNode<E> myRoot) {
	//
	// if (myRoot.left() == null && myRoot.right() == null) {
	// leaf.add(myRoot.data());
	// }
	// myRoot.left();
	//
	//
	// return leaf;
	// }
	// public int leafNodesC(){
	//
	// }
	//
	// private int leafNodesCount(ArrayList<E> al) {
	// BNode<E> myRoot = root;
	//
	// if (myRoot == null) {
	// return 0;
	// }
	// if (myRoot.left == null && myRoot.right == null) {
	// return 1;
	// }
	//
	// return
	// (leafNodesCount(al,myRoot.left())+leafNodesCount(al,myRoot.right()));
	// }

	// private ArrayList<E> countLeafs(ArrayList<E> adder, BNode<E> current) {
	// if() {//no next value
	// //add current to list
	// }
	// if() {//there is a leff node call function with current.left
	//
	// }
	// else {//there is a right node call function with current.right
	//
	// }
	// }

	public void add(E x) {
		root = add(root, x);
	}

	private BNode<E> add(BNode<E> rt, E x) {
		if (x == null)
			return rt; // do not allow null values
		if (rt == null) {
			count++;
			return new BNode<E>(x);
		} else if (x.compareTo(rt.data()) < 0) {
			BNode<E> p = add(rt.left(), x);
			rt.setLeft(p);
			return rt;
		} else if (x.compareTo(rt.data()) > 0) {
			BNode<E> p = add(rt.right(), x);
			rt.setRight(p);
			return rt;
		} else // x present, so no change
			return rt;
	}

	public boolean contains(E x) {
		return contains(root, x);
	}

	private boolean contains(BNode<E> rt, E x) {
		if (rt == null)
			return false;
		else {
			if (rt.data().equals(x))
				return true;
			else if (x.compareTo(rt.data()) < 0)
				return contains(rt.left(), x);
			else
				return contains(rt.right(), x);
		}
	}

	public int size() {
		return count;
	}

	public void remove(E x) {
		BNode<E> ptr = null;
		BNode<E> parentPtr = null;
		if (root != null) {
			ptr = root;
			parentPtr = root;
			boolean found = false;
			while (ptr != null && !found) {
				if (ptr.data().equals(x))
					found = true;
				else {
					parentPtr = ptr;
					if (x.compareTo(ptr.data()) < 0)
						ptr = ptr.left();
					else
						ptr = ptr.right();
				}
			}
			if (found) {
				count--;
				if (ptr == root) {
					root = removeNode(root);
				} else {
					if (x.compareTo(parentPtr.data()) < 0) {
						BNode<E> n = removeNode(parentPtr.left());
						parentPtr.setLeft(n);
					} else {
						BNode<E> n = removeNode(parentPtr.right());
						parentPtr.setRight(n);
					}
				}
			}
		}
	}

	private BNode<E> removeNode(BNode<E> rt) {
		if (rt == null)
			return null;
		else if (rt.left() == null && rt.right() == null)
			return null;
		else if (rt.left() == null)
			return rt.right();
		else if (rt.right() == null) {
			return rt.left();
		} else {
			BNode<E> ptr = rt.left();
			BNode<E> parentPtr = null;
			while (ptr.right() != null) {
				parentPtr = ptr;
				ptr = ptr.right();
			}
			rt.set(ptr.data());
			if (parentPtr == null)
				rt.setLeft(ptr.left());
			else
				parentPtr.setRight(ptr.left());
			return rt;
		}
	}

	public int height() {
		return height(root);
	}

	private int height(BNode<E> rt) {
		if (rt == null)
			return -1;
		else {
			return 1 + max(height(rt.left()), height(rt.right()));
		}
	}

	private int max(int a, int b) {
		return a >= b ? a : b;
	}

	public ArrayList<E> inOrder() {
		ArrayList<E> lst = new ArrayList<E>();
		inOrder(root, lst);
		return lst;
	}

	private void inOrder(BNode<E> rt, ArrayList<E> lst) {
		if (rt != null) {
			inOrder(rt.left(), lst);
			lst.add(rt.data());
			inOrder(rt.right(), lst);
		}
	}

	public ArrayList<E> preOrder() {
		ArrayList<E> lst = new ArrayList<E>();
		preOrder(root, lst);
		return lst;
	}

	private void preOrder(BNode<E> rt, ArrayList<E> lst) {
		if (rt != null) {
			lst.add(rt.data());
			preOrder(rt.left(), lst);
			preOrder(rt.right(), lst);
		}
	}

	public ArrayList<E> postOrder() {
		ArrayList<E> lst = new ArrayList<E>();
		postOrder(root, lst);
		return lst;
	}

	private void postOrder(BNode<E> rt, ArrayList<E> lst) {
		if (rt != null) {
			postOrder(rt.left(), lst);
			postOrder(rt.right(), lst);
			lst.add(rt.data());
		}
	}

	public Iterator<E> iterator() {
		ArrayList<E> ls = this.inOrder();
		return ls.iterator();
	}

	public String toString() {
		return this.inOrder().toString();
	}

	private class BNode<E extends Comparable<E>> {
		private E data;
		private BNode<E> left;
		private BNode<E> right;

		public BNode(E d) {
			data = d;
			left = null;
			right = null;
		}

		public E data() {
			return data;
		}

		public void set(E x) {
			data = x;
		}

		public BNode<E> left() {
			return left;
		}

		public BNode<E> right() {
			return right;
		}

		public void setLeft(BNode<E> k) {
			left = k;
		}

		public void setRight(BNode<E> k) {
			right = k;
		}
	}
}
