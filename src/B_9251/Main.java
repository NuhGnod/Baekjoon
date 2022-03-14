package B_9251;

import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
//		A->1
//		
		String sen1 = sc.nextLine();
		String sen2 = sc.nextLine();
		int dp1[] = new int[sen1.length()+1];
		int dp2[] = new int[sen2.length()+1];
		int dp[][] = new int[sen2.length() + 1][sen1.length() + 1];
		for (int i = 0; i < sen1.length(); i++) {
			dp1[i+1] = sen1.charAt(i) - 64;
		}
		for (int i = 0; i < sen2.length(); i++) {
			dp2[i+1] = sen2.charAt(i) - 64;
		}
//		for (int i = 0; i < sen1.length(); i++) {
//			System.out.print(dp1[i] + " ");
//		}
//		System.out.println();
//		for (int i = 0; i < sen2.length(); i++) {
//			System.out.print(dp2[i] + " ");
//		}

		for (int i = 1; i <= sen2.length(); i++) {
			for (int j = 1; j <= sen1.length(); j++) {
				if (dp1[j] == dp2[i]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		System.out.println(dp[sen2.length()][sen1.length()]);
	}

}
