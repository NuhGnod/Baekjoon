package Baekjoon;

import java.util.*;

public class B_14716 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int check = 0;
		int n = 0;

		int a[][] = new int[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				a[i][j] = sc.nextInt();
			}
		}

		for (int i = 1; i < N - 1; i++) {
			check = 0;
			for (int j = 0; j < M; j++) {
				if (a[j][i] == 0) {
					check++;
				}
				if (check == M) {
					n++;
				}

			}
		}
		System.out.println(n + 1);

	}

}
