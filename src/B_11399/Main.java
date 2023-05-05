package B_11399;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		long p[] = new long[N];
		long ans = 0;
		for (int i = 0; i < N; i++) {
			p[i] = sc.nextInt();

		}
		Arrays.sort(p);
		ans = p[0];
		for (int i = 1; i < N; i++) {
			p[i] += p[i - 1];
			ans +=p[i];
		}
		System.out.println(ans);
	}

}
