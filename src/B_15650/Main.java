package B_15650;

import java.util.*;

public class Main {
	static int M;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		M = sc.nextInt();
		int arr[] = new int[M + 1];// length+1
		boolean check[] = new boolean[N + 1];// used number
		back(check, arr, 0);

	}

	static void back(boolean[] check, int[] arr, int k) {
		if (k == M) {
			for (int i = 1; i <= M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (!check[i]) {
				if (arr[k] < i) {
					arr[k + 1] = i;
					check[i] = true;
					back(check, arr, k + 1);
					check[i] = false;
				}
			}
		}
	}

}
