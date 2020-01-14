package B_1932;

import java.math.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		long max = 0;
		int max_index = 0;
		long arr[][] = new long[N + 1][N + 1];
		for (int i = 0; i < N; i++) {// 500 * 500
			for (int j = 0; j <= i; j++) {
				arr[i][j] = sc.nextLong();
			}
		} // 배열 초기화

		for (int i = N; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				arr[i-1][j] += Math.max(arr[i][j],arr[i][j+1]);
			}
		}
		System.out.println(arr[0][0]);

	}

}
