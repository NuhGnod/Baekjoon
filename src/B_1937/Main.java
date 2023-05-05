package B_1937;

import java.io.*;
import java.util.*;

public class Main {
	static int map[][];
	static int dep[][];
	static int gox[] = { 0, 1, 0, -1 };
	static int goy[] = { 1, 0, -1, 0 };
	static int N;
	static int ans;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dep = new int[N][N];
		for (int i = 0; i < N; i++) {
			String in[] = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(in[j]);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int t = dfs(i, j);
				ans = Math.max(ans, t);
			}
		}
//		dfs(0, 1);

		System.out.println(ans);
	}

	public static int dfs(int x, int y) {
		if (dep[x][y] != 0)
			return dep[x][y];

		dep[x][y] = 1;
		for (int i = 0; i < 4; i++) {
			int nx = x + gox[i];
			int ny = y + goy[i];
			if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if (map[nx][ny] > map[x][y]) {
					dep[x][y] = Math.max(dep[x][y], dfs(nx, ny) + 1);
				}
			}
		}
		return dep[x][y];
	}
}
