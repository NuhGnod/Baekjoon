package Baekjoon;

import java.util.*;

public class B_15894 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N];
		a[0] = 4;
		for (int i = 1; i < N; i++) {

			a[i] = a[i - 1] + 4;

		}

		if (N == 0) {
			System.out.println(a[0]);

		} else {
			System.out.println(a[N - 1]);
		}

	}

}
