package B_7562;

import java.util.*;
import java.io.*;

class Point {
	int x, y, cnt;

	Point(int x, int y, int cnt) {

		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}

public class Main {
	static int gox[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int goy[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static int map[][];
	static boolean c[][];
	static int len;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			len = Integer.parseInt(br.readLine());
			map = new int[len][len];
			c = new boolean[len][len];
			String in1[] = br.readLine().split(" ");
			String in2[] = br.readLine().split(" ");
			Point p1 = new Point(Integer.parseInt(in1[0]), Integer.parseInt(in1[1]), 0);
			Point p2 = new Point(Integer.parseInt(in2[0]), Integer.parseInt(in2[1]), 0);
			bfs(p1, p2);
		}

	}

	static public void bfs(Point p1, Point p2) {
		Queue<Point> q = new LinkedList();
		q.add(p1);
		int ans = Integer.MAX_VALUE;

		while (!q.isEmpty()) {
			Point p = q.poll();
			int x = p.x;
			int y = p.y;
			int cnt = p.cnt;
			c[x][y] = true;
			if (x == p2.x && y == p2.y) {
				ans = Math.min(ans, cnt);
				continue;
			}
			for (int i = 0; i < 8; i++) {
				int nx = x + gox[i];
				int ny = y + goy[i];
				if (isPossible(nx, ny)) {
					if (!c[nx][ny]) {
						q.add(new Point(nx, ny, cnt+1));
						c[nx][ny] = true;
					}
				}
			}
		}
		System.out.println(ans);
	}

	static public boolean isPossible(int x, int y) {
		if (x < 0 || y < 0 || x >= len || y >= len)
			return false;
		return true;
	}

}
