package B_10026;

import java.io.*;
import java.util.*;

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int gox[] = { 1, 0, -1, 0 };
	static int goy[] = { 0, 1, 0, -1 };
	static int map[][];
	static int map2[][];
	static boolean c[][];
	static int N;
	static int cnt;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		map2 = new int[N][N];
		c = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String in = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = in.charAt(j) - 'A';
				if (in.charAt(j) == 'R') {// Red -> Green
					map2[i][j] = 'G' - 'A';
				} else {
					map2[i][j] = in.charAt(j) - 'A';
				}
			}

		}
		c = new boolean[N][N];
		cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!c[i][j]) {
					bfs(new Point(i, j), map);
					cnt++;
				}
			}
		}
		System.out.print(cnt + " ");
		cnt = 0;
		c = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!c[i][j]) {
					bfs(new Point(i, j), map2);
					cnt++;
				}
			}
		}
		System.out.print(cnt);
	}

	static public void bfs(Point pp, int[][] m) {
		Queue<Point> q = new LinkedList();
		q.add(pp);
		c[pp.x][pp.y] = true;
		while (!q.isEmpty()) {
			Point p = q.poll();
			int cx = p.x;
			int cy = p.y;
			for (int i = 0; i < 4; i++) {
				int nx = cx + gox[i];
				int ny = cy + goy[i];
				if (isPossible(nx, ny)) {
					if (m[nx][ny] == m[cx][cy] && !c[nx][ny]) {
						q.add(new Point(nx, ny));
						c[nx][ny] = true;
					} else {

					}
				}
			}
		}
	}

	static public boolean isPossible(int x, int y) {
		if (x < 0 || y < 0 || x >= N || y >= N)
			return false;
		return true;
	}

}
