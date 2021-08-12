package B_1167;

import java.io.*;
import java.util.*;

class Pair {
	int to, len;

	public Pair(int t, int l) {
		this.to = t;
		this.len = l;
	}
}

public class Main {
	static int V;
	static boolean c[];
	static ArrayList<Pair>[] arr;
	static int ans, node;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		arr = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			arr[i] = new ArrayList<Pair>();
		}
		c = new boolean[V + 1];
		ans = 0; 	
		for (int i = 0; i < V; i++) {
			String[] s = br.readLine().split(" ");
			int root = Integer.parseInt(s[0]);
			for (int j = 1; j < s.length - 1; j += 2) {
				int node = Integer.parseInt(s[j]);
				int len = Integer.parseInt(s[j + 1]);

				arr[root].add(new Pair(node, len));
				arr[node].add(new Pair(root, len));
			}

		}
		
		dfs(1,0);
		c= new boolean[V+1];
		dfs(node, 0);
		System.out.println(ans);
	}

	static public void dfs(int start, int dist) {
		if(ans < dist	) {
			ans = dist;
			node = start;
		}
//		System.out.println("to : " + start);

		c[start] = true;
		for (Pair p : arr[start]) {
			int to = p.to;
			int len = p.len;
			if (!c[to]) {
					dfs(to,len+dist);
//					c[to] = true;
			}

		}
	}

}
