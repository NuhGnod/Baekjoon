package B_17175;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long dp[] = new long[51];
		int N = sc.nextInt();
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= 50; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + 1;

		}
		long ans = dp[N] % 1000000007;

		System.out.println(ans);

	}

}
