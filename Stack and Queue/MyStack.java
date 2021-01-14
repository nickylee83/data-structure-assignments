// Myo Thet Tun 2918551
public class MyStack {
	private int[] myStackArray;
	private int top = 0;

	public MyStack(int max) {
		myStackArray = new int[max];
		top = 0;
	}

	public boolean isEmpty() {
		if (top == 0) {
			return true;
		}
		return false;
	}

	public boolean isFull() {
		if (top == myStackArray.length - 1) {
			return true;
		}
		return false;
	}

	public int pop() {
		if (this.isEmpty() == false) {
			top--;
			int temp = myStackArray[top];
			myStackArray[top] = 0;
			return temp;
		} else {
			System.out.println("Empty stack!");
			return 0;
		}
	}

	public void push(int x) {
		if (this.isFull() == false) {
			myStackArray[top] = x;
			top++;
		} else {
			System.out.println("Full stack!");
		}

	}

	public void display() {
		for (int i = 0; i < myStackArray.length; i++) {
			if (i < myStackArray.length - 1) {
				System.out.print(myStackArray[i] + " , ");
			} else {
				System.out.print(myStackArray[i]);
			}
		}
	}
}
