package BAEKJOON;

import java.util.*;

public class B_14721 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a[][] = new int[n][2];
		int temp = 0;
		int max = 0;
		int min = 0;

		for (int i = 0; i < n; i++) {
			a[i][0] = sc.nextInt();
			a[i][1] = sc.nextInt();

		}
		max = a[0][1];
		min = a[0][1];
		for (int i = 1; i < n; i++) {
			if (max < a[i][1]) {
				max = a[i][1];

			}

		}
		for (int i = 1; i < n; i++) {
			if (min > a[i][1]) {
				min = a[i][1];

			}

		}
		System.out.println(max + " " + min);
		System.out.println("s");

	}

}
