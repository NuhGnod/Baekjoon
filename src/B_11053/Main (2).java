package B_11053;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		/*
		 * 8 1 5 10 3 13 18 15 16
		 */
		int N = sc.nextInt();
		int A[] = new int[N + 1];
		int dp[] = new int[N + 1];

		for (int j = 1; j <= N; j++) {

			A[j] = sc.nextInt();

		}
		dp[N] = 1;
		for (int i = N - 1; i > 0; i--) {
			if (A[i] < A[i + 1]) {
				for (int j = i; j < N; j++) {

					if (A[i] < A[j + 1]) {
						dp[i] = Math.max(dp[i], dp[j + 1] + 1);
						
					} else if (A[i] == A[j + 1]) {
						dp[i] = Math.max(dp[i], dp[j+1]);
						
					} else {
						dp[i] = Math.max(dp[i], 1);
					}
				}
			} else if (A[i] == A[i + 1]) {
				dp[i] = Math.max(dp[i], dp[i+1]);
			} else {
				for (int j = i; j < N; j++) {

					if (A[i] < A[j + 1]) {
						dp[i] = Math.max(dp[i], dp[j + 1] + 1);
						
					} else if (A[i] == A[j + 1]) {
						dp[i] = Math.max(dp[i], dp[j+1]);
						
					} else {
						dp[i] = Math.max(dp[i], 1);
					}
				}
			}
			
		}
		Arrays.sort(dp);
		System.out.println(dp[N]);
	}

}
