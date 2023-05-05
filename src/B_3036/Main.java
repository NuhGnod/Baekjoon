package B_3036;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();

		}
		int a = arr[0];
		for (int i = 1; i < N; i++) {
			System.out.println(a / gcd(a, arr[i]) + "/" + arr[i] / gcd(a, arr[i]));
		}
	}

	static int gcd(int a, int b) {
		if (a % b == 0) {
			return b;
		}
		return gcd(b, a % b);
	}

}
