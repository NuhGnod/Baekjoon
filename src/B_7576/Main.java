package B_7576;

import java.util.*;
import java.io.*;

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;

	}

	public int getX() {
		return x;

	}

	public int getY() {
		return y;
	}
}

public class Main {
	static int tomato, notTomato, M, N;
	static int[][] map;
	static int gox[] = { 1, 0, -1, 0 };
	static int goy[] = { 0, 1, 0, -1 };
	static int date, cnt;
	static boolean c[][];
	static Queue<Point> q;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tomato = 0;
		notTomato = 0;
		date = 0;
		q = new LinkedList();
		String t[] = br.readLine().split(" ");
		M = Integer.parseInt(t[0]);// col
		N = Integer.parseInt(t[1]);// row
		c = new boolean[N][M];
		map = new int[N][M];
		cnt = M * N;
		for (int i = 0; i < N; i++) {
			String input[] = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				if (map[i][j] == 1) {
					tomato++;
					c[i][j] = true;
					q.add(new Point(i, j));
				} else if (map[i][j] == -1) {
					c[i][j] = true;
					notTomato++;
					cnt--;
				}
			}
		}
		
		
		if (cnt == 0) {
			System.out.println(0);
		} else {
			bfs();
			if (cnt == tomato) {
				System.out.println(date);
			} else {
				System.out.println(-1);
			}
		}
	}

	static public void bfs() {

		while (!q.isEmpty()) {
			int len = q.size();
			if (cnt <= tomato)
				return;
			date++;
			for (int l = 0; l < len; l++) {
				int x = q.peek().getX();
				int y = q.poll().getY();
				c[x][y] = true;
				for (int i = 0; i < 4; i++) {
					int cx = x + gox[i];
					int cy = y + goy[i];
					if (isPossible(cx, cy)) {
						if (!c[cx][cy] && map[cx][cy] != -1) {
							q.add(new Point(cx, cy));
							c[cx][cy] = true;
							tomato++;
							map[cx][cy] = 1;
//							showMap();
//							System.out.println();
						}
					}
				}
			}
		}

	}

	static public boolean isPossible(int nx, int ny) {
		if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
			return false;
		}
		return true;
	}

	static public void showMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
