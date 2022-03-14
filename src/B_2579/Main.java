package B_2579;

import java.util.*;
import java.math.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		long max = 0;
		long arr[] = new long[N + 1];
		long dp[] = new long[N + 1];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextLong();
		}
		// 1ĭ , 2ĭ

		if (N >= 4) {
			dp[0] = arr[0];
			dp[1] = Math.max(arr[0] + arr[1], arr[1]);
			dp[2] = Math.max(arr[0] + arr[2], arr[1] + arr[2]);
			for (int i = 3; i < N; i++) {
				dp[i] += Math.max(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 2] + arr[i]);
			}
			
			
			System.out.println(dp[N - 1]);
		} else if (N == 1) {
			dp[0] = arr[0];
			System.out.println(dp[0]);
		} else if (N == 2) {
			dp[0] = arr[0];
			dp[1] = Math.max(arr[0] + arr[1], arr[1]);
			System.out.println(dp[1]);

		} else if (N == 3) {
			dp[0] = arr[0];
			dp[1] = Math.max(arr[0] + arr[1], arr[1]);
			dp[2] = Math.max(arr[0] + arr[2], arr[1] + arr[2]);
			System.out.println(dp[2]);

		}

	}

}
