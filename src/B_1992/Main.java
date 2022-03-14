package B_1992;

import java.util.*;

public class Main {
	static int N;
	static int cnt = 0;

	static public void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = Integer.valueOf(sc.nextLine());
		Deque<int[][]> q = new LinkedList();

		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String temp = sc.nextLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = temp.charAt(j) - 48;
			}
		}
		q.add(map);

		solve(map, 0, 0, N);

	}

	public static void solve(int[][] a, int x, int y, int n) {

		if (same(a, x, y, n)) {
			System.out.print(a[x][y]);
		} else {
			System.out.print("(");
			int m = n / 2;
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					solve(a, x + m * i, y + m * j, m);
				}
			}
			System.out.print(")");
		}

	}

	static public boolean same(int[][] a, int x, int y, int n) {
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (a[x][y] != a[i][j])
					return false;
			}
		}
		return true;
	}

}
