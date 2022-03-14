package B_20005;

import java.util.*;
import java.io.*;

public class Main {
	static boolean[][][] bfsIsVisited;
	static int[] xArrow, yArrow;
	static int count;
	static int bossX, bossY, bossHP;
	static int M, N, P;
	static char map[][];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[] = br.readLine().split(" ");

		M = Integer.parseInt(temp[0]);
		N = Integer.parseInt(temp[1]);
		 P = Integer.parseInt(temp[2]);

		map = new char[M][N];
		bfsIsVisited = new boolean[P][M][N];
		xArrow = new int[] { 1, 0, -1, 0 };
		yArrow = new int[] { 0, 1, 0, -1 };
		PlayerInfo[] playerInfo = new PlayerInfo[P];
		for (int i = 0; i < M; i++) {
			String temp1 = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = temp1.charAt(j);
				if ('a' <= map[i][j] && map[i][j] <= 'z') {
					playerInfo[map[i][j] - 'a'] = new PlayerInfo(map[i][j] - 'a', -1, i, j, false);
					bfsIsVisited[map[i][j] - 'a'][i][j] = true;
				} else if (map[i][j] == 'B') {
					bossX = j;
					bossY = i;

				}

			}
		}

		LinkedList<PlayerInfo> queue = new LinkedList<>();
		for (int i = 0; i < P; i++) {
			String t[] = br.readLine().split(" ");
			int id = t[0].charAt(0);
			int dps = Integer.parseInt(t[1]);
			playerInfo[id - 'a'].setDps(dps);
			queue.add(playerInfo[id - 'a']);
		}
		bossHP = Integer.parseInt(br.readLine());
		bfs(queue);
		System.out.println(count);


	}

	public static void bfs(LinkedList<PlayerInfo> queue) {
		int id, dps, x, y;
		boolean isFindBoss;

		while (queue.size() != 0) {
			int queueSize = queue.size();
			if (bossHP <= 0) {
				break;

			}
			for (int s = 0; s < queueSize; s++) {
				PlayerInfo p = queue.poll();
				id = p.getId();
				dps = p.getDps();
				x = p.getX();
				y = p.getY();
				isFindBoss = p.isFindBoss();
				if (x == bossX && y == bossY) {
					if (!isFindBoss) {
						count++;
					}
					bossHP -= dps;
					queue.add(new PlayerInfo(id, dps, y, x, true));
				} else {
					for (int i = 0; i < 4; i++) {
						if (!(y + yArrow[i] >= M) && !(x + xArrow[i] >= N) && !(y + yArrow[i] < 0)
								&& !(x + xArrow[i] < 0) && map[y + yArrow[i]][x + xArrow[i]] != 'X'
								&& !bfsIsVisited[id][y + yArrow[i]][x + xArrow[i]]) {
							queue.add(new PlayerInfo(id, dps, y + yArrow[i], x + xArrow[i], isFindBoss));
							bfsIsVisited[id][y + yArrow[i]][x + xArrow[i]] = true;
						}
//						if (!(y + yArrow[i] < 0) && !(x + xArrow[i] < 0) && !(y + yArrow[i] >= M)
//								&& !(x + xArrow[i] >= N) && map[y + yArrow[i]][x + xArrow[i]] != 'X'
//								&& !bfsIsVisited[id][y + yArrow[i]][x + xArrow[i]]) {
//							queue.add(new PlayerInfo(id, dps, y + yArrow[i], x + xArrow[i], isFindBoss));
//							bfsIsVisited[id][y + yArrow[i]][x + xArrow[i]] = true;
//						}
					}
				}
			}
		}
	}

}

class PlayerInfo {
	private int id;
	private int dps;
	private int x;
	private int y;
	private boolean isFindBoss;

	public PlayerInfo(int id, int dps, int y, int x, boolean isFindBoss) {
		this.id = id;
		this.dps = dps;
		this.x = x;
		this.y = y;
		this.isFindBoss = isFindBoss;

	}

	public int getId() {
		return id;

	}

	public int getDps() {
		return dps;

	}

	public void setDps(int dps) {
		this.dps = dps;
	}

	public int getX() {
		return x;

	}

	public int getY() {
		return y;

	}

	public boolean isFindBoss() {
		return isFindBoss;
	}
}
