package B_2565;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

//		A 전봇대에서 전선이 시작한다고 가정
		int dp[] = new int[N + 1];
		int A[][] = new int[2][N + 1];// A 전봇대
//		A 전봇대에서 전선이 시작한다고 가정
//		A -> B 전봇대 기준 : B전봇대를 오름차순으로 정렬
//		A전봇대에서 lis 구함
//		전선 총 개수 - lis
		for (int i = 1; i <= N; i++) {
			A[0][i] = sc.nextInt();//A
			A[1][i] = sc.nextInt();//B
		}
		int temp = 0;
		int temp_index = 0;

		for (int i = 1; i <= N; i++) {// sorting
			for (int j = 1; j < N; j++) {
				if (A[1][j] > A[1][j + 1]) {
					temp = A[1][j];
					A[1][j] = A[1][j + 1];
					A[1][j + 1] = temp;

					temp_index = A[0][j];
					A[0][j] = A[0][j + 1];
					A[0][j + 1] = temp_index;
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			dp[i] = 1;
			for (int j = 1; j <= i; j++) {
				if (A[0][j] < A[0][i] && dp[i] < dp[j] + 1) {
					dp[i]++;
				}
			}
		}
		Arrays.sort(dp);
		System.out.println(N-dp[N]);
	}

}
