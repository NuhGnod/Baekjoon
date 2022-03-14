package B_2156;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int wine[] = new int[n + 1];
		int dp[] = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			wine[i] = sc.nextInt();
		}
		dp[1] = wine[1];
		if (n == 2) {
			dp[2] = wine[1] + wine[2];
		}
		if (n == 3) {
			dp[2] = wine[1] + wine[2];
			dp[3] = Math.max(wine[1] + wine[3], wine[2] + wine[3]);

		}
		if (n >= 4) {
			dp[2] = wine[1] + wine[2];
			dp[3] = Math.max(dp[2], Math.max(wine[1] + wine[3], wine[2] + wine[3]));

			for (int i = 4; i <= n; i++) {
				dp[i] = Math.max(dp[i-1], Math.max(dp[i - 3] + wine[i - 1] + wine[i], dp[i - 2] + wine[i]));
			}
		}
		Arrays.sort(dp);
		System.out.println(dp[n]);
		
	}

}
