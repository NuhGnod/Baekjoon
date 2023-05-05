package B_1912;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int dp[] = new int[N + 1];
		int A[] = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = sc.nextInt();
		}
		// dp[n] = dp[n-1] + A[n] , A[n], dp[n-1]
		// dp[n] = A[n-1] + A[n], A[n], dp[n-1] + A[n], dp[n-1] //11, 13, 21, 8//
		// -1 -2 13 -> 21 -> 모두 선택 ->
		dp[0] = -1001;
		dp[1] = A[1];
		for (int i = 2; i <= N; i++) {
			dp[i] = A[i];
			for (int j = i; j <= i; j++) {
				dp[i] = Math.max(dp[i], Math.max(A[j-1] + A[j], dp[j-1] + A[j]));
//				dp[i] = Math.max(Math.max(dp[j - 1] + A[j], dp[j - 1]), Math.max(A[j - 1] + A[j], A[j]));

			}
		}
		Arrays.sort(dp);
		System.out.println(dp[N]);
	}

}
