package B_11054;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int A[] = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = sc.nextInt();
		}
		int front_dp[] = new int[N + 1];
		int back_dp[] = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			front_dp[i] = 1;
			for (int j = 1; j <= i; j++) {
				if (A[j] < A[i] && front_dp[i] < front_dp[j] + 1) {
					front_dp[i]++;
				}
			}
		}
		for (int i = N; i >= 1; i--) {
			back_dp[i] = 1;
			for (int j = N; j >= i; j--) {
				if (A[j] < A[i] && back_dp[i] < back_dp[j] + 1) {
					back_dp[i]++;
				}
			}
		} /*
			 * Arrays.parallelSort(front_dp); System.out.println(front_dp[N]);
			 * Arrays.sort(back_dp); System.out.println(back_dp[N]);
			 */
		int max=0;
		int max_index=0;
		for(int i=1; i<=N; i++) {
			if(max <=front_dp[i] + back_dp[i]) {
				
				max = front_dp[i] + back_dp[i];
			}
		}
		System.out.println(max-1);
	}

}
