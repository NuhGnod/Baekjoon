package B_9461;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long dp[] = new long[T];
		// 규칙 -- 바로 전 even[n] = odd중 odd[n-1]빼고 모두 더한 값 +1
		// 1 1 2 4 7 //odd
		// 0 1 2 3 5 9 //even
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();

			long odd[] = new long[N + 3];
			long even[] = new long[N + 3];
			odd[1] = 1;
			for (int i = 2, j = 1; i <= N + 1 && j <= N + 1; i += 2, j += 2) {
				for (int q = 0; q <= i; q++) {
					even[i + 1] += even[q];
				}
				odd[j] = even[i + 1] - even[i - 2] + 1;

				for (int w = 1; w <= j; w++) {
					odd[j + 1] += odd[w];
				}

				even[i] = odd[j + 1] - odd[j] + 1;
				odd[j + 1] = 0;
				even[i + 1] = 0;
			}
			if (N % 2 == 0) {
				dp[t] = even[N];

			} else {
				dp[t] = odd[N];

			}

		}
		for(int t=0; t<T; t++) {
			System.out.println(dp[t]);	
		}
		

	}
}
