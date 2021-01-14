// Myo Thet Tun - 2918551 - Lab 1
import java.util.Scanner;

/* Class DoublyLinkedList */
public class DoublyLinkedList {
	private static String newID = "";
	private static double newAmt = 0;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		/* Creating object of linkedList */
		Wallet w = new Wallet();
		char ch;
		/* Perform list operations */
		do {
			System.out.println("\nMy Wallet Test\n");
			System.out.println("1. insert at begining");
			System.out.println("2. insert at end");
			System.out.println("3. delete");
			System.out.println("4. get size");
			System.out.println("5. display");
			System.out.println("6. search");

			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter ID to insert");
				newID = scan.next();
				System.out.println("Enter amount to insert");
				newAmt = scan.nextDouble();
				Node n = new Node(newID, newAmt);
				w.insertAtStart(n);
				break;

			case 2:
				System.out.println("Enter ID to insert");
				newID = scan.next();
				System.out.println("Enter amount to insert");
				newAmt = scan.nextDouble();
				Node no = new Node(newID, newAmt);
				w.insertAtEnd(no);
				break;

			case 3:
				System.out.println("Enter ID to delete");
				newID = scan.next();
				Node x = new Node(newID, 0);
				w.delete(x);
				break;

			case 4:
				System.out.println("Size = " + w.getSize() + " \n");
				break;

			case 5:
				w.display();
				break;

			case 6:
				System.out.println("Enter ID to search");
				String ID = scan.next();
				System.out.println(w.search(ID));
				break;

			default:
				System.out.println("Invalid Entry \n ");
				break;
			}

			System.out.println("\nDo you want to continue? (y/n) \n");
			ch = scan.next().charAt(0);

		} while (ch == 'Y' || ch == 'y');
		scan.close();
		return;
	}
}
