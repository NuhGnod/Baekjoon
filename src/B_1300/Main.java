package B_1300;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		long K = sc.nextLong();

		long l = 1;
		long r = K;
		long ans = 0;
		while (l <= r) {
			long m = (l + r) / 2;
			long cnt = 0;
			for (int i = 1; i <= N; i++) {
				cnt += Math.min(m / i, N);

			}
			if (cnt < K) {
				l = m + 1;

			} else {
				ans = m;
				r = m - 1;
			}
		}
		System.out.println(ans);
	}

}
