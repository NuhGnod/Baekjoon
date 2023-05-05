package B_1707;

import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] arr;
	static int c[];
	static boolean flag;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String in[] = br.readLine().split(" ");
			int V = Integer.parseInt(in[0]);
			int E = Integer.parseInt(in[1]);
			arr = new ArrayList[V + 1];
			c = new int[V + 1];
			flag = true;
			for (int j = 1; j <= V; j++) {
				arr[j] = new ArrayList<Integer>();
				c[j] = 0;// 검사하지 않은 정점들

			}
			for (int j = 0; j < E; j++) {
				String node[] = br.readLine().split(" ");
				int a = Integer.parseInt(node[0]);
				int b = Integer.parseInt(node[1]);
				arr[a].add(b);
				arr[b].add(a);
			}
			int cnt = 0;
			for (int j = 1; j <= V; j++) {// 모든 정점을 빠트리지 않고 검사하기 위함
				if (!flag)
					break;
				if (c[j] == 0) {
					bfs(j, 1);
				}
			}
			System.out.println(flag ? "YES" : "NO");

		}
	}

	static public void bfs(int start, int color) {

		Queue<Integer> q = new LinkedList();
		q.add(start);
		c[start] = color;
		while (!q.isEmpty()) {

			int x = q.poll();
//			System.out.print(x + " ");
			for (int y : arr[x]) {// x 정점에 연결된 노드들 검사
				if (c[y] == 0) {// x에 연결된 노드 y를 검사하지 않았다면
					c[y] = c[x] * -1;
					q.add(y);

				} else if (c[x] + c[y] != 0) {
					flag = false;
					return;
				}
			}
		}

	}

}
