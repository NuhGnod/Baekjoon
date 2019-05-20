package B_1149;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int ans[] = new int[3];
		int temp[] = new int[3];

		for (int i = 0; i < T; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			if (i == 0) {
				ans[0] = a;

				ans[1] = b;
				ans[2] = c;
			}
			if (i > 0) {
				temp[0] = ans[0];
				temp[1] = ans[1];
				temp[2] = ans[2];
				ans[0] = a + Math.min(temp[1], temp[2]);
				ans[1] = b + Math.min(temp[0], temp[2]);
				ans[2] = c + Math.min(temp[0], temp[1]);

			}

		}
		Arrays.sort(ans);
		System.out.println(ans[0]);
	}
}
