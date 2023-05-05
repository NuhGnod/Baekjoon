package B_2667;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

class Point {
	int x = 0;
	int y = 0;

	Point(int x, int y) {
		this.x = x;
		this.y = y;

	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
}

public class Main {
	static int N;
	static int map[][];
	static boolean c[][];
	static int gox[] = { 1, 0, -1, 0 };
	static int goy[] = { 0, 1, 0, -1 };
	static int n = 1;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		c = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = (temp.charAt(j) - '0');
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (c[i][j] == false)
					find_apt(i, j, n);

			}
		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j]+ " ");
//			}
//			System.out.println();
//
//		}
		System.out.println(n - 1);
		int[] apt = new int[n];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) {
					apt[map[i][j]]++;
				}
			}

		}
		Arrays.sort(apt);
		for (int i = 1; i < n; i++) {
			System.out.println(apt[i]);
		}

	}

	public static int find_apt(int x, int y, int cnt) {
		Queue<Point> q = new LinkedList();
		q.add(new Point(x, y));//현재 위치 저장
		while (!q.isEmpty()) {

			int ci = q.peek().getX();
			int cj = q.poll().getY();

			c[ci][cj] = true;
			if (map[ci][cj] != 0) {//현재 위치가 1이면 단지 번호로 바꿔줌

				map[ci][cj] = cnt;
				if (map[ci][cj] == n) {//바뀐 단지 번호가 총 단지수랑 같다면 단지번호 ++1 --> 다음 단지를 위해서
					n++;
				}
			} else {
				continue;
			}
			for (int i = 0; i < 4; i++) {
				int tci = ci + gox[i];
				int tcj = cj + goy[i];
				if (tci < 0 || tci >= N || tcj < 0 || tcj >= N)
					continue;
				else {

					if (map[tci][tcj] == 1) {//다음 위치가 1이면 현재 단지번호로 바꿔주고, 

						map[tci][tcj] = cnt;
						if (c[tci][tcj] == false) {//다음 위치를 아직 방문 안했다면 Q에 추가하고 방문 했다고 표시
							q.add(new Point(tci, tcj));
							c[tci][tcj] = true;
//							System.out.println(tci + "#" + tcj);
						}
					} else {
						c[tci][tcj] = true;//다음 위치가 0이면 방문 했다고만 표시
					}

				}

			}

		}
		return 1;
	}

}
