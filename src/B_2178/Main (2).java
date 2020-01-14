package B_2178;

import java.util.*;
import java.io.*;

public class Main {
	public static int row = 0;
	public static int col = 0;
	public static int[][] map = null;
	public static String path = "";

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long begin = System.currentTimeMillis();

		String a[] = new String[2];
		String line = "";

		a = br.readLine().split(" ");
		row = Integer.parseInt(a[0]);
		col = Integer.parseInt(a[1]);

		map = new int[row][col];

		for (int i = 0; i < row; i++) {
			line = br.readLine();
			for (int j = 0; j < col; j++) {
				map[i][j] = (line.charAt(j) - '0');

			}

		}

		int dap = 0;
		path = "";
		dap = bfs();
		System.out.println(dap);
		// System.out.println("#" + 1 + " " + dap + path);
		map = null;
		long end = System.currentTimeMillis();
		// System.out.printf("%.3f (secs)", (end - begin) / 1000.0);

	}

	private static int bfs() {
		int ret = 0;
		int curRow = 0;
		int curCol = 0;
		int curDist = 1;
		String curPath = "";

		LinkedList<Coord> q = new LinkedList<Coord>();
		q.add(new Coord(curRow, curCol, curDist, curPath));

		while (!q.isEmpty()) {
			Coord co = (Coord) q.poll();
			curRow = co.row;
			curCol = co.col;
			curDist = co.dist;
			curPath = co.path;
			path = curPath;
			ret = curDist;
			map[curRow][curCol] = 0;
			if (curRow == row - 1 && curCol == col - 1)
				break;

			if (curRow - 1 >= 0 && map[curRow - 1][curCol] == 1) {
				q.add(new Coord(curRow - 1, curCol, curDist + 1, curPath));
			}
			// 아래로 갈수 있으면

			if (curRow + 1 < row && map[curRow + 1][curCol] == 1) {

				q.add(new Coord(curRow + 1, curCol, curDist + 1, curPath));

			}

			// 왼쪽으로 갈수 있으면

			if (curCol - 1 >= 0 && map[curRow][curCol - 1] == 1) {

				q.add(new Coord(curRow, curCol - 1, curDist + 1, curPath));

			}

			// 오른쪽으로 갈수 있으면

			if (curCol + 1 < col && map[curRow][curCol + 1] == 1) {

				q.add(new Coord(curRow, curCol + 1, curDist + 1, curPath));

			}

		}
		q.clear();
		return ret;
	}

	public static class Coord {
		int row, col, dist;
		String path;

		public Coord(int row, int col, int dist, String oldPath) {
			this.row = row;
			this.col = col;
			this.dist = dist;
			if ("".equals(oldPath)) {
				this.path = "(" + row + ", " + col + ")";

			} else {
				this.path = oldPath + "->" + "(" + row + ", " + col + ")";

			}
		}
	}

}
