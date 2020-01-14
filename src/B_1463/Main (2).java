package B_1463;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		// 1 ~ 1000000
		// 3���� ������ �������� 3���� ������
		// 2�� ������ �������� 2�� ������
		// 1 ����
		int cnt = 0;
		// 11 > 10 > 5 > 4 > 2 > 1
		// 11 > 10 > 9 > 3 > 1
		
		
		int dp[] = new int[N+1];
		dp[1] = 0;
		
		for(int i=2; i<=N; i++) {
			dp[i] = dp[i-1] + 1;
			if(i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i/2] + 1);
				
			}
			if(i % 3 ==0) {
				dp[i] = Math.min(dp[i], dp[i/3] +1);
				
			}
		}
		System.out.println(dp[N]);
	}

}
