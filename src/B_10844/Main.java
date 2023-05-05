package B_10844;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1 2 3 4 5 6 7 8 9
//10 12 21 23 32 34 43 45 54 56 65 67 76 78 87 89 98
		Scanner sc = new Scanner(System.in);
		// 0 , 9 로 끝나면 *2-1
		// 나머지 *2
//101 121 123 210 212 232 234--- 876 878   898    987 989
		//
		int N = sc.nextInt();
//1010 1012 1210 1212 1232 1234  2101 2121 2123 2323 2321 2343 2345 
		long dp[][] = new long[N + 1][11];
		dp[1][0] = 0;
		for (int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
			dp[1][10] += dp[1][i] % 1000000000;
		}
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				if(j == 0) {
					dp[i][j] = dp[i-1][j+1] % 1000000000;
					
				}
				else if(j == 9) {
					dp[i][j] = dp[i-1][j-1] % 1000000000 ;
				}
				else {
					dp[i][j] += dp[i-1][j-1] % 1000000000;
					dp[i][j] += dp[i-1][j+1] % 1000000000;
				}
				dp[i][10] += dp[i][j];
				
			}
		}
		System.out.println(dp[N][10] % 1000000000);
	}

}
