package B_10830;

import java.util.*;

public class Main {
	static long time = 1;
	static long num = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int B = sc.nextInt();
		long A[][] = new long[N][N];
		long C[][] = new long[N][N];
		num = B;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				A[i][j] = sc.nextInt();

			}
		}
		multiply(A, B, A);

	}

	static public void multiply(long a[][], int b, long c[][]) {
		long C[][] = new long[a.length][a.length];

		if (b == 1) {
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a.length; j++) {
					for (int q = 0; q < a.length; q++) {
						C[i][j] += c[i][q] * a[q][j] % 1000;
					}
				}
			}
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a.length; j++) {
					System.out.print(C[i][j] % 1000 + " ");
				}
				System.out.println();
			}

		} else if (b % 2 == 1) {
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a.length; j++) {
					for (int q = 0; q < a.length; q++) {
						C[i][j] += c[i][q] * c[q][j] % 1000;
					}
				}
			}
			time *= 2;
			if (num - time * ((b - 1) / 2) > 1) {
				multiply(c, (b-1) / 2, C);

			} else {
				multiply(a, (b-1) / 2, C);
			}

		} else {
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a.length; j++) {
					for (int q = 0; q < a.length; q++) {
						C[i][j] += c[i][q] * c[q][j] % 1000;
					}
				}
			}
			time *= 2;
			if (num - time * (b / 2) > 1) {
				multiply(c, b / 2, C);

			} else {
				multiply(a, b / 2, C);
			}

		}

	}

}
