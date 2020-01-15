package BAEKJOON;

import java.util.*;

public class B_1913 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int temp = N;
		int temp2 = N;
		int a = 0;
		int b = 0;

		int box[][] = new int[N + 1][N + 1];

		for (int i = N * N; i > 0; i--) {

			box[a][b] = i;

			while (box[a + 1][b] == 0 && a < N) {
				a++;
				break;

			}

		}
	}

}
