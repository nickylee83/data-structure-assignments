// Myo Thet Tun 2918551
public class MyQueue {
	private String[] queue;
	private int head;
	private int tail;

	public MyQueue(int max) {
		queue = new String[max];
		head = 0;
		tail = 0;
	}

	public int getHead() {
		return head;
	}

	public int getTail() {
		return tail;
	}

	public boolean isFull() {
		if (head == tail + 1 || (head == 0 && tail == queue.length - 1)) {
			return true;
		}
		return false;
	}

	public boolean isEmpty() {
		if (head == tail) {
			return true;
		}
		return false;
	}

	public void dequeue() {

		if (isEmpty() == true) {
			System.out.println("No more items to dequeue!");
			return;
		}

		queue[head] = null;
		if (head == queue.length - 1) {
			head = 0;
			System.out.println("The queue is empty!");
		} else {
			head++;
		}

		System.out.println("The item has been dequeued!");

	}

	public void enqueue(String x) {
		if (isFull() == true) {
			System.out.println("Queue is full!");
			return;
		}
		queue[tail] = x;

		if (tail == queue.length - 1) {
			tail = 0;
		} else {
			tail++;
		}
		//System.out.println("Head:" + this.getHead() + ", Tail:" + this.getTail());
		System.out.println("The item has been added!");
	}

	public String peek() {
		return queue[head];
	}

	public void dequeueAll() {
		while (isEmpty() == false) {
			if (head == queue.length - 1) {
				queue[head] = null;
				head = 0;

			} else {
				queue[head] = null;
				head++;
			}

			//System.out.println("Head:" + getHead() + ", Tail:" + getTail());
		}
		System.out.println("All items have been dequeued!");
	}

	public String toString() {
		String output = "";
		for (int i = 0; i < queue.length; i++) {
			if (queue[i] == null) {
				output += " - , ";
			} else if (i == queue.length - 1) {
				output += queue[i];
			} else {
				output += queue[i] + " , ";
			}
		}
		return output;
	}
}