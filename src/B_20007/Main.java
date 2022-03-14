package B_20007;

import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<pair>[] list;
	static int map[][];
	static int dist[];// 자기 위치와 각 집 사이의 최단거리
	static int N, M, X, Y;
	static boolean c[];// 떡 돌림 여부

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		X = Integer.parseInt(input[2]);
		Y = Integer.parseInt(input[3]);
		map = new int[N][N];
		dist = new int[N];
		c = new boolean[N + 1];
		for (int i = 0; i < N; i++) {
			dist[i] = 987654321;
		}

		dist[Y] = 0;
		list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<pair>();
		}
		for (int i = 0; i < M; i++) {
			String secInput[] = br.readLine().split(" ");
			int a = Integer.parseInt(secInput[0]);
			int b = Integer.parseInt(secInput[1]);
			int c = Integer.parseInt(secInput[2]);
			list[a].add(new pair(b, c));
			list[b].add(new pair(a, c));
		}
//		for (int i = 0; i < list.length; i++) {
//			System.out.println(i + " " +list[i]);
//		}
		dijkstra();
		for (int i = 0; i < dist.length; i++) {

			dist[i] *= 2;
		}

		Arrays.sort(dist);

		System.out.println(sol());

	}

	static public void dijkstra() {
		PriorityQueue<pair> pq = new PriorityQueue<Main.pair>();
		pq.add(new pair(Y, 0));
		while (!pq.isEmpty()) {
			int cur = pq.peek().getNode();
			int cLen = pq.peek().getDist();
			pq.poll();
			for (int i = 0; i < list[cur].size(); i++) {
				int next = list[cur].get(i).getNode();
				int nLen = list[cur].get(i).getDist();
				if (cLen + nLen < dist[next]) {
					dist[next] = cLen + nLen;
					pq.add(new pair(next, dist[next]));

				}

			}
		}

	}

	static public int sol() {
		int date = 1;
		int temp = X;
		for (int i = 0; i < N; i++) {
			if (temp - dist[i] > 0) {
				temp -= dist[i];
			} else {
				if (dist[i] >= X) {
					date = -1;
					break;
				} else {
					temp = X;
					date++;
					i--;
				}
			}
		}
		return date;
	}

	static class pair implements Comparable<pair> {
		private int node;
		private int dist;

		public pair(int node, int dist) {
			this.node = node;
			this.dist = dist;
		}

		public int getNode() {
			return node;
		}

		public int getDist() {
			return dist;
		}

		public String toString() {
			return String.valueOf(node) + " " + String.valueOf(dist);
		}

		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return this.dist - o.dist;
		}

	}

}
