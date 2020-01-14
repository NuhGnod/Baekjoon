package B_10872;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(cal(N));
	}

	static int cal(int n) {
		if (n == 0)
			return 1;
		
		return n * cal(n - 1);
	}

}
