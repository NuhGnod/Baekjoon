package B_14889;

import java.util.*;

public class Main {
	static int N;
	static int Min = 1000000000;
	static int cnt = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[][] s = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				s[i][j] = sc.nextInt();

			}
		}
		int arr[] = new int[N + 1];
		ArrayList<Integer> start = new ArrayList();
		ArrayList<Integer> link = new ArrayList();

		boolean check[] = new boolean[N];
		back(arr, check, 0, start, link, s);
		System.out.println(Min);

	}

	static int cal(ArrayList start, ArrayList link, int[][] s) {
		int a = 0;
		int b = 0;
		for (int i = 0; i < N / 2; i++) {
			for (int j = i + 1; j < N / 2; j++) {
				a += s[(int) start.get(i)][(int) start.get(j)];
				a += s[(int) start.get(j)][(int) start.get(i)];

			}
		}
		for (int i = 0; i < N / 2; i++) {
			for (int j = i + 1; j < N / 2; j++) {
				b += s[(int) link.get(i)][(int) link.get(j)];
				b += s[(int) link.get(j)][(int) link.get(i)];

			}
		}
		return Math.abs(a - b);
	}

	static void back(int[] arr, boolean[] check, int k, ArrayList start, ArrayList link, int[][] s) {

		if (k == N / 2) {
			cnt++;
			for (int i = 0; i < N; i++) {
				link.add(i);
			}
			for (int j = 1; j <= N / 2; j++) {
				start.add(arr[j]);
			}
			for (int i = 0; i < N / 2; i++) {
				link.remove(start.get(i));

			}
			

			if (Min > cal(start, link, s)) {
				Min = cal(start, link, s);

			}
			return;

		}

		for (int i = 1; i <= N; i++) {
			if (!check[i - 1]) {
				if (arr[k] < i) {
					arr[k + 1] = i-1;
					check[i - 1] = true;
					back(arr, check, k + 1, start, link, s);
					start.clear();
					link.clear();
					check[i - 1] = false;
				}

			}
		}
	}

}
