package B_7569;

import java.util.*;
import java.io.*;

class Point {
	int x;
	int y;
	int z;

	public Point(int z, int x, int y) {
		this.x = x;
		this.y = y;
		this.z=z;

	}

	public int getX() {
		return x;

	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}
}

public class Main {
	static int tomato, notTomato, M, N, H;
	static int[][][] map;
	static int gox[] = { 1, 0, 0, -1, 0, 0 };
	static int goy[] = { 0, 1, 0, 0, -1, 0 };
	static int goz[] = { 0, 0, 1, 0, 0, -1 };
	static int date, cnt;
	static boolean c[][][];
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
		H = Integer.parseInt(t[2]); // height;
		c = new boolean[H][N][M];
		map = new int[H][N][M];
		cnt = M * N * H;
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				String input[] = br.readLine().split(" ");
				for (int j = 0; j < M; j++) {
					map[h][i][j] = Integer.parseInt(input[j]);
					if (map[h][i][j] == 1) {
						tomato++;
						c[h][i][j] = true;
						q.add(new Point(h, i, j));
					} else if (map[h][i][j] == -1) {
						c[h][i][j] = true;
						notTomato++;
						cnt--;
					}
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
				int y = q.peek().getY();
				int z = q.poll().getZ();
				c[z][x][y] = true;
				for (int i = 0; i < 6; i++) {
					int cx = x + gox[i];
					int cy = y + goy[i];
					int cz = z + goz[i];
					if (isPossible(cx, cy, cz)) {
						if (!c[cz][cx][cy] && map[cz][cx][cy] != -1) {
							q.add(new Point(cz, cx, cy));
							c[cz][cx][cy] = true;
							tomato++;
							map[cz][cx][cy] = 1;
//							showMap();
//							System.out.println();
						}
					}
				}
			}
		}

	}

	static public boolean isPossible(int nx, int ny, int nz) {
		if (nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= H) {
			return false;
		}
		return true;
	}

	static public void showMap() {
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					System.out.print(map[h][i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
