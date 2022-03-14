package B_14716;

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
	static int M, N;
	static boolean c[][];
	static int ans;
	static int gox[] = { 1, 1, 0, -1, -1, -1, 0, 1 };
	static int goy[] = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int map[][];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		M = Integer.parseInt(s[0]);
		N = Integer.parseInt(s[1]);
		map = new int[M][N];
		for (int i = 0; i < M; i++) {
			String in[] = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(in[j]);
			}

		}
		c = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!c[i][j] && map[i][j] == 1) {
					bfs(new Point(i, j));
					ans++;
				}
			}
		}
		System.out.println(ans);

	}

	static public void bfs(Point point) {
		Queue<Point> q = new LinkedList();
		q.add(point);
		c[point.x][point.y] = true;
		while (!q.isEmpty()) {
			Point p = q.poll();
			int cx = p.x;
			int cy = p.y;
			for (int i = 0; i < 8; i++) {
				int nx = cx + gox[i];
				int ny = cy + goy[i];
				if (isPossible(nx, ny)) {
					if (map[nx][ny] == 1 && !c[nx][ny]) {
						q.add(new Point(nx, ny));
						c[nx][ny] = true;
					}
				}
			}
		}
	}

	static public boolean isPossible(int x, int y) {
		if (x < 0 || y < 0 || x >= M || y >= N) {
			return false;
		} else
			return true;
	}

}
