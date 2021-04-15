package B_2981;

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
		Arrays.sort(arr);
		int gcd = arr[1] - arr[0];
		for (int i = 2; i < N; i++) {//
			if (gcd > arr[i] - arr[i - 1]) {
				gcd = gcd(arr[i] - arr[i - 1], gcd);
			} else if (gcd == arr[i - 1] - arr[i - 1]) {
				gcd = gcd;
			} else
				gcd = gcd(gcd, arr[i] - arr[i - 1]);

		}
		for (int i = 2; i <= gcd; i++) {
			if (gcd % i == 0) {
				System.out.println(i);
			}
		}

//		System.out.println(gcd);

	}

	static int gcd(int a, int b) {
		if (a % b == 0) {
			return b;
		}
		return gcd(b, a % b);

	}

}
