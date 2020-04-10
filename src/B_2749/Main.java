package B_2749;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long N = sc.nextLong();
		final int K = 1500000;
		final int mod = 1000000;
		long[] arr = new long[1500000];
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i < K; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
			arr[i] %= mod;
		}
		System.out.println(arr[(int) (N % K)]);
	}

}
