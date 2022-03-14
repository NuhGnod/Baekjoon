package B1629;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		ArrayList<Integer> arr = new ArrayList<Integer>();

		long result = go(a, b, c);
//		for (int i = 0; i < b; i++) {
//			arr.add((int) Math.pow(arr.get(i), 2));
//		}
		System.out.println(result);

	}

	static public long go(long a, long b, long c) {
		long result = 0;
		if (b == 1)
			return a % c;
		else if (b == 0) {
			return 1;
		} else if (b % 2 == 1) {
			// odd
			result = go(a, (b - 1) / 2, c);
			return ((result * result) % c) * a % c;
		} else {// even
			result = go(a, b / 2, c);
			return ((result * result) % c);
		}
	}

}
