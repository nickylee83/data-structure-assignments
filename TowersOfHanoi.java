public class TowersOfHanoi {
	public static int myCounter;

	public static void main(String args[]) {
		towers(10, 'A', 'B', 'C', 0);
		System.out.println();
		System.out.println("Total move counts = " + myCounter);
	}

	static void towers(int num, char source, char dest, char spare, int cnt) {

		if (num == 1) {
			myCounter = Counter.count(myCounter);
			System.out.printf("\nMove disk 1 from peg %c to peg %c --> move counts = %d", source, dest, myCounter);
			return;
		} else {
			towers(num - 1, source, spare, dest, myCounter);
			myCounter = Counter.count(myCounter);
			System.out.printf("\nMove disk %d from peg %c to peg %c --> move counts = %d", num, source, dest,
					myCounter);
			towers(num - 1, spare, dest, source, myCounter);
		}
	}
}

class Counter {
	public static int count(int c) {
		c++;
		return c;
	}
}
