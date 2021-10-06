package B_11726;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 2*n 을 1*2 n개로 채운 형태 = 1개
		// 위 형태에서 1 * 2 타일 2개를 을 2 * 1타일 2개로 바꾸는 방식
		int n = Integer.parseInt(br.readLine());
		long dp[] = new long[n + 1];
		//initialize
		dp[0] = 1;
		dp[1] = 2;
		long ans = 0;
		for (int i = 2; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;

			
		}
		System.out.println(dp[n - 1]);
	}

}
