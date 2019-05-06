package B_17174;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int temp = 1;

		int ans = 0;
		ans += N;

		while (temp > 0) {
			temp = N / M;
			N = N % M;
			ans += temp;
			if (temp >= M) {
				N = temp;
			}

		}
		System.out.println(ans);
	}

}
