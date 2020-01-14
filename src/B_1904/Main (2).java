package B_1904;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String n1 = "00";
		String n2 = "1";
		int N = sc.nextInt(); // 크기 N
		int dp[] = new int[N + 1];
		dp[0] = 0; // X

		// N=2 : 00, 11
		// N=3 : 001, 100, 111 ---- 3
		// N=4 ; 0000, 0011, 1001, 1100, 1111 ---- 5
		// N=5 ; 00001, 00100, 00111, 10000, 10011, 11001, 11100, 11111 ---- 8
		// N=6; 00:3 00:2 00:1 00:0
		// 00이 으로 시작하는경우, 1로 시작하는 경우,
		// -> 1 + 4!/4! +
		// N이 홀수인경우: N-1 인 경우 + a1
		// N이 짝수인경우 : N-2 인 경우 + 2
		if (N >= 3) {
			dp[0] = 0;
			dp[1] = 1;
			dp[2] = 2;

			for (int i = 3; i <= N; i++) {
				dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
			}
			System.out.println(dp[N]);
		} else if (N == 1) {
			System.out.println(1);
		} else if (N == 0) {
			System.out.println(dp[0]);

		} else if (N == 2) {
			System.out.println(2);
		}
	}

}
