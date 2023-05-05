package B_10830;

import java.util.*;

public class Main {
	static long time = 1;
	static long num = 0;

	static int N = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		long B = sc.nextLong();
		long A[][] = new long[N][N];
		long C[][] = new long[N][N];
		num = B;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				A[i][j] = sc.nextInt();

			}
		}
		if (B == 1) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(A[i][j] % 1000 + " ");
				}
				System.out.println();
			}
		} else {
			C = matrix(A, B);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(C[i][j] % 1000+ " ");
				}
				System.out.println();
			}
		}
	}

	static public long[][] mul(long a[][], long b[][]) {
		long[][] C = new long[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int q = 0; q < N; q++) {
					C[i][j] += (a[i][q] * b[q][j]);
					C[i][j] %= 1000;
				}
			}
		}
		return C;
	}

	static public long[][] matrix(long a[][], long b) {
		long C[][] = new long[a.length][a.length];

		if (b == 1) {
			return a;
		} else if (b % 2 == 1) {
			C = matrix(a, b - 1);
			return mul(C, a);
		} else {
			C = matrix(a, b / 2);
			return mul(C, C);
		}

	}

}
