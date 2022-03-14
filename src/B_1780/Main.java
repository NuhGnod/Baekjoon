package B_1780;

import java.io.*;

public class Main {
	
	static int[] arr = new int[4];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.valueOf(br.readLine());
		int map[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			String temp[] = br.readLine().split(" ");

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.valueOf(temp[j]);
			}
		}
		solve(map, 0, 0, N);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);

	}

	static public void solve(int[][] map, int x, int y, int n) {
		if (check(map, x, y, n)) {
			arr[map[x][y] + 1]++;
		} else {

			int m = n / 3;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					solve(map, x + m * i, y + m * j, m);
				}
			}

		}

	}

	static public boolean check(int[][] map, int x, int y, int n) {
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (map[x][y] != map[i][j])
					return false;
			}
		}
		return true;
	}

}
