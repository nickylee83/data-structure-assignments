// Myo Thet Tun 2918551
public class MyTest {

	public static void main(String[] args) {
		// Stack Testing

		MyStack s = new MyStack(5);

		System.out.println("Stack is empty = " + s.isEmpty());

		s.push(1);
		s.push(2);
		s.push(3);

		s.display();
		System.out.println();
		
		System.out.println("Popped out " + s.pop());
		s.display();
		System.out.println();
		
		System.out.println("Popped out " + s.pop());
		s.display();
		System.out.println();
		
		System.out.println("Popped out " + s.pop());
		s.display();
		System.out.println();
		
		System.out.println("Popped out " + s.pop());
		s.display();
		System.out.println();

		// Stack LinkedList Testing

		System.out.println("\n------------------");

		StackLinkedList link = new StackLinkedList(3);

		System.out.println("Total " + link.getSize());
		link.display();
		System.out.println();

		Node no = new Node(1);
		link.push(no);
		no = new Node(2);
		link.push(no);
		no = new Node(3);
		link.push(no);
		no = new Node(4);
		link.push(no);
		
		System.out.println("Total " + link.getSize());
		link.display();
		System.out.println();

		System.out.println("Search for ID1 = " + link.search(1));
		System.out.println();

		System.out.println("Pop out the nodes!");
		link.pop();
		link.display();
		System.out.println();

		link.pop();
		link.display();
		System.out.println();

		link.pop();
		link.display();
		System.out.println();
		
		// Queue test
		System.out.println("\n-------------------------");
		MyQueue mq = new MyQueue(5);

		System.out.println("Head:" + mq.getHead() + ", Tail:" + mq.getTail());

		mq.enqueue("1010111AB");
		System.out.println(mq.toString());
		System.out.println();

		mq.dequeue();
		System.out.println(mq.toString());
		System.out.println();

		mq.dequeue();		

		mq.enqueue("2020111AB");
		System.out.println(mq.toString());
		System.out.println();

		mq.enqueue("3030111AB");
		System.out.println(mq.toString());
		System.out.println();

		mq.enqueue("4040111AB");
		System.out.println(mq.toString());
		System.out.println();

		mq.enqueue("5050111AB");
		System.out.println(mq.toString());
		System.out.println();

		mq.dequeueAll();
		System.out.println(mq.toString());
		System.out.println("Head:" + mq.getHead() + ", Tail:" + mq.getTail());
		
		mq.enqueue("3030111AB");
		System.out.println(mq.toString());
		System.out.println();

		mq.enqueue("4040111AB");
		System.out.println(mq.toString());
		System.out.println();
		
		System.out.println("Peek first: " + mq.peek());
		System.out.println();
	}

}
