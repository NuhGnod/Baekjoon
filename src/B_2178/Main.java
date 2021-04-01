package B_2178;

import java.util.*;
import java.io.*;

public class Main {
	static int map[][];
	static boolean check[][];
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[] = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		map = new int[N][M];
		check = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j) - '0';
				check[i][j] = false;
			}
		}

		check[0][0] = true;
		bfs(0, 0);
		System.out.println(map[N - 1][M - 1]);

	}

	static public void bfs(int x, int y) {
		Queue<Info> q = new LinkedList();

		q.add(new Info(x, y));

		while (!q.isEmpty()) {
			Info cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nX = cur.x + dx[i];
				int nY = cur.y + dy[i];

				if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
					continue;
				}
				if (check[nX][nY] || map[nX][nY] == 0) {
					continue;
				}
				q.add(new Info(nX, nY));
				map[nX][nY] = map[cur.x][cur.y] + 1;
				check[nX][nY] = true;
			}
		}
	}

}

class Info {
	int x;
	int y;

	public Info(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
