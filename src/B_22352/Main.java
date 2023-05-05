package B_22352;

import java.util.*;
import java.io.*;

class Point {
	int x, y;
	int af;

	public Point(int x, int y, int af) {
		this.x = x;
		this.y = y;
		this.af = af;
	}

}

public class Main {
	static int N, M;
	static int before[][];
	static int after[][];
	static boolean check_contrast[][];
	static boolean c[][];
	static int gox[] = { 1, 0, -1, 0 };
	static int goy[] = { 0, 1, 0, -1 };
	static Point start;

	static int flag = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String in[] = br.readLine().split(" ");

		N = Integer.parseInt(in[0]);
		M = Integer.parseInt(in[1]);
		before = new int[N][M];
		after = new int[N][M];
		check_contrast = new boolean[N][M];
		c = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String m[] = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				before[i][j] = Integer.parseInt(m[j]);

			}
		}
		for (int i = 0; i < N; i++) {
			String m[] = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				after[i][j] = Integer.parseInt(m[j]);

			}
		}

		contrast();
		if (flag == 1)
			System.out.println(bfs(start));
		else {
			System.out.println("YES");
		}
//		show(check_contrast);
//		System.out.println();
//		show(c);
	}

	static public String bfs(Point start) {
		int ch = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (check_contrast[i][j] == true)
					ch = after[i][j];
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (check_contrast[i][j] == true)
					if (ch != after[i][j])
						return "NO";
			}
		}
		Queue<Point> q = new LinkedList();
		q.add(start);
		c[start.x][start.y] = true;
		while (!q.isEmpty()) {
			Point p = q.poll();
			int nx = p.x;
			int ny = p.y;
			int naf = p.af;
			for (int i = 0; i < 4; i++) {
				nx = p.x + gox[i];
				ny = p.y + goy[i];

				if (isPossible(nx, ny)) {
					if (before[p.x][p.y] == before[nx][ny] && !c[nx][ny]) {
						q.add(new Point(nx, ny, naf));
						c[nx][ny] = true;
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (c[i][j] != check_contrast[i][j]) {
					return "NO";
				}
			}
		}
		return "YES";

	}

	static public boolean isPossible(int nx, int ny) {
		if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
			return false;
		}
		return true;
	}

	static public void show(boolean arr[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	static public void contrast() {// check, check_contrast 와 비교
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (before[i][j] != after[i][j]) {// 변화한곳
					check_contrast[i][j] = true;
					int af = after[i][j];
					start = new Point(i, j, af);
					flag = 1;
				}
			}
		}

	}
}