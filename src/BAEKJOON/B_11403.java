package BAEKJOON;

import java.util.*;

class dfs {
	Scanner sc = new Scanner(System.in);

	boolean check[];
	int N;
	int a[][];

	public dfs(int n) {
		this.N = n;
		this.a = new int[N][N];
		this.check = new boolean[N];

	}

	void put(int x) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				a[i][j] = x;

			}
		}
	}

	void dfs(int x) {
		check[x] = true;
		for (int i = 0; i < N; i++) {
			if (a[x][i] == 1) {

			}

		}
	}

	public void printt() {
		System.out.println(a[0][0]);
	}
}

public class B_11403 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		dfs dfs = new dfs(N);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int x = sc.nextInt();
				dfs.put(x);
			}
		}

		dfs.printt();

	}

}
