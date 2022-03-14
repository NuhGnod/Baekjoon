package B_1934;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int temp = 0;
			if(a != b) {
				if (a > b) {
					temp = a;
					a = b;
					b = temp;
				}
//				System.out.println(gcd(a, b));
				System.out.println(lcm(a, b));
			
			}else {
//				System.out.println(a);
				System.out.println(b);
			
			}
		}
	}

	static int lcm(int a, int b) {
		return (a * b) / gcd(b, a % b);
	}

	static int gcd(int a, int b) {
		if (a % b == 0) {
			return b;
		}
		return gcd(b, a % b);
	}
}
