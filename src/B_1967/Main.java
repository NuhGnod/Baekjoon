package B_1967;

import java.util.*;

import java.io.*;

class Pair {
	int to, len;

	public Pair(int to, int len) {
		this.to = to;
		this.len = len;
	}
}

public class Main {
	static int N;
	static boolean c[];
	static ArrayList<Pair>[] arr;
	static int ans, node;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<Pair>();
		}
		c = new boolean[N + 1];
		ans = 0;
		for (int i = 0; i < N-1; i++) {
			String s[] = br.readLine().split(" ");
			int root = Integer.parseInt(s[0]);
			int child = Integer.parseInt(s[1]);
			int len = Integer.parseInt(s[2]);
			arr[root].add(new Pair(child, len));
			arr[child].add(new Pair(root, len));
		}
		if(N != 1) {
			dfs(1, 0);
			c = new boolean[N + 1];
			dfs(node,0);
			
			System.out.println(ans);
		}
		else {
			System.out.println(0);
		}
		

	}

	public static void dfs(int start, int dist) {
		if (ans < dist) {
			ans = dist;
			node = start;
		}
		c[start] = true;
		for (Pair p : arr[start]) {
			int to = p.to;
			int len = p.len;

			if (!c[to]) {
				dfs(to, len + dist);
			}
		}
	}

}
