
/**
 * student name: Myo Thet Tun
 * student number: 2918551
 * 
 * Empty elements: 0
Largest bucket: 15
Smallest bucket: 1
Hash code: 1550089733
Percentage used: 100.0
0: 0
1: 12
2: 54
3: 102
4: 173
5: 231
6: 239
7: 232
8: 170
9: 141
10: 85
11: 54
12: 25
13: 15
14: 4
15: 3

Size of hash table before adding p1 = 10000
Size of hash table after adding p1 = 10001
Size of hash table after adding p1 again = 10001
check pList equals newList = false
Remove p1 from pList = true
Size of hash table after removing p1 = 10000

 */
import java.util.*;

public class Assignment5_2018 {
	final static int SIZE = 10000;
	final static int NUMBER_OF_BUCKETS = 1540;

	public static void main(String[] args) {

		MyHashList<Point> pList = new MyHashList<Point>(NUMBER_OF_BUCKETS);
		for (int i = 0; i < SIZE; i++) {
			int x = (int) (Math.random() * 100000);
			int y = (int) (Math.random() * 100000);
			pList.add(new Point(x, y));
		}

		System.out.println("Empty elements: " + pList.empty());
		System.out.println("Largest bucket: " + pList.largestBucket());
		System.out.println("Smallest bucket: " + pList.smallestBucket());
		System.out.println("Hash code: " + pList.hashCode());
		Point p1 = new Point(78418, 44425);

		System.out.println("Percentage used: " + pList.percentUsed());
		int[] aList = new int[NUMBER_OF_BUCKETS];
		aList = pList.listSizes();
		int i = 0;
		for (int x : aList) {
			System.out.println(i + ": " + x);
			i++;
		}
		System.out.println("Size of hash table before adding p1 = " + pList.size());
		pList.add(p1);
		System.out.println("Size of hash table after adding p1 = " + pList.size());
		pList.add(p1);
		System.out.println("Size of hash table after adding p1 again = " + pList.size());
		MyHashList<Point> newList = new MyHashList<Point>(NUMBER_OF_BUCKETS);
		newList.getList(p1);
		System.out.println("check pList equals newList = " + pList.equals(newList));
		System.out.println("Remove p1 from pList = " + pList.remove(p1));
		System.out.println("Size of hash table after removing p1 = " + pList.size());
	}
}

// =======================================================
// class Point
class Point {
	private int x, y;

	Point(int a, int b) {
		x = a;
		y = b;
	}

	public int x() {
		return x;
	}

	public int y() {
		return y;
	}

	public String toString() {
		return "(" + x + "," + y + ")";
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + x;
		result = 31 * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Point)) {
			return false;
		}
		Point p = (Point) obj;
		if (p.x == this.x && p.y == this.y) {
			return true;
		}
		return false;
	}
}

// End class Point
// =======================================================
// MyHashList class
class MyHashList<E> implements Iterable<E> {
	private ArrayList<LinkedList<E>> table;

	public MyHashList(int n) {
		// n = the number of lists to create -
		// it does not limit the number of elements in the table
		table = new ArrayList<>();
		for (int j = 0; j < n; j++)
			table.add(new LinkedList<>());
	}

	private int hashC(E x) {
		int k = x.hashCode();
		// an alternative is to mask the minus using
		// int k = x.hashCode() & 0x7fffffff;
		int h = Math.abs(k % table.size());
		return (h);
	}

	public void add(E x) {
		if (x != null) {
			int index = hashC(x);
			if (!(table.get(index).contains(x))) {
				table.get(index).addFirst(x);
			}
		}
	}

	public boolean contains(E x) {
		int index = hashC(x);
		return (table.get(index).contains(x));
	}

	public boolean remove(E x) {
		int index = hashC(x);
		return table.get(index).remove(x);
	}

	public int size() {
		int count = 0;
		for (int j = 0; j < table.size(); j++)
			count += table.get(j).size();
		return count;
	}

	public Iterator<E> iterator() {
		ArrayList<E> items = new ArrayList<E>();
		int ind = 0;
		while (ind < table.size()) {
			Iterator<E> it = table.get(ind).iterator();
			while (it.hasNext())
				items.add(it.next());
			ind++;
		}
		return items.iterator();
	}

	public String toString() {
		return table.toString();
	}
	// ===========================================================
	// Methods for assignment to be inserted here

	public LinkedList<E> getList(E x) {
		LinkedList<E> lst = new LinkedList<E>();
		int index = hashC(x);
		while (this.iterator().hasNext()) {
			if (table.get(index).contains(x)) {
				lst.add(this.iterator().next());
			}
		}
		return lst;
	}

	public void remove(List<E> ls) {
		table.removeAll(ls);
	}
	// The signature of equals is given

	public boolean equals(Object ob) {
		if (!(ob instanceof MyHashList)) {
			return false;
		}
		MyHashList<?> hlst = (MyHashList<?>) ob; // now use hlst for comparison
		if ((hlst.size() == this.size()) && (hlst.listSizes().equals(this.listSizes()))) { // with
																							// this
			return true;
		}
		return false;
	}

	// ===========================================================
	// Methods that provide information about the state of the hashtable
	public double percentUsed() {
		int count = 0;
		for (int j = 0; j < table.size(); j++) {
			if (table.get(j).size() > 0)
				count++;
		}
		double p = count * 100.0 / table.size();
		return p;
	}

	public int largestBucket() {
		int max = 0;
		for (int j = 0; j < table.size(); j++) {
			int k = table.get(j).size();
			if (k > max)
				max = k;
		}
		return max;
	}

	public int smallestBucket() {
		int min = table.get(0).size();
		for (int j = 1; j < table.size(); j++) {
			int k = table.get(j).size();
			if (k < min)
				min = k;
		}
		return min;
	}

	public int[] listSizes() {
		int n = this.largestBucket();
		int d[] = new int[n + 1];
		for (int j = 0; j < d.length; j++)
			d[j] = 0;
		for (int j = 0; j < table.size(); j++) {
			int m = table.get(j).size();
			d[m] = d[m] + 1;
		}
		return d;
	}

	public int empty() {
		int count = 0;
		for (int j = 0; j < table.size(); j++)
			if (table.get(j).size() == 0)
				count++;
		return count;
	}
	// ==================================================================
}