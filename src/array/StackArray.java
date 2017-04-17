package array;

/**
 * @author vikky.agrawal
 *
 */
public class StackArray {

	/**
	 * @param args
	 */

	private static int N = -1;
	private int[] arr;

	StackArray(int size) {
		this.arr = new int[size];
	}

	public static void main(String[] args) {

		String str = "abc";
		char chr[] = str.toCharArray();

		StackArray StackArray = new StackArray(20);

		for (int i = 0; i < 10; i++) {
			StackArray.push((int) (Math.random() * 100));
			System.out.println(StackArray.peek());
		}

		String sdtr = "Ahssdafdbs";
		float f = 10.2f;
		double d = 10.2;
		System.out.println(f == d);

		System.out.println(20 / 10 % 2);

	}

	public void push(int data) {

		if (N == arr.length) {
			System.out.println("Not enough space");
			return;
		}

		arr[++N] = data;

	}

	public int pop() {
		if (N < 0) {
			System.out.println("not enough elements");
		}

		return arr[N--];
	}

	public int peek() {
		return arr[N];
	}

	public int getNum(char a) {
		int flag = 0;

		switch (a) {
		case 'A':
		case 'a':
			flag = 1;
			break;
		case 'B':
		case 'b':
			flag = 2;
			break;

		}
		return flag;
	}

}
