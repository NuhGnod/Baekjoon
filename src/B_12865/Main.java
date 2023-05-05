package B_12865;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();// 물품의 수
		int K = sc.nextInt();// 최대 무게
		int A[][] = new int[N + 1][3];
		int dp[][] = new int[N + 1][K + 1];// w,v
		for (int i = 1; i <= N; i++) {
//ㄱㄴㅇㅁ
			int W = sc.nextInt();// 각 물건의무게
			int V = sc.nextInt();// 각 물건의 가치

			A[i][1] = W;
			A[i][2] = V;

		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if (j >= A[i][1]) {
					dp[i][j] = Math.max(Math.max(A[i][2] + dp[i - 1][j - A[i][1]], dp[i - 1][j]), dp[i][j-1]);
				} else {
					dp[i][j] = dp[i - 1][j];

				}
			}
		}//ㄴㅇㅁ
		System.out.println(dp[N][K]);
	}

}
