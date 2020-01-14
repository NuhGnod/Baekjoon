package B_7568;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int weight[] = new int[N];
		int height[] = new int[N];
		int ans[] = new int[N];

		for (int i = 0; i < N; i++) {
			weight[i] = sc.nextInt();
			height[i] = sc.nextInt();
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			cnt = 0;
			for (int j = 0; j < N; j++) {
				if (weight[i] < weight[j] && height[i] < height[j]) {
					cnt++;
				}
			}
			ans[i] = cnt+1;
		}
		for(int i=0; i<N; i++) {
			System.out.print(ans[i] + " ");
		}
	}

}
