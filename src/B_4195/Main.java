package B_4195;

import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	static int[] level;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int F = Integer.parseInt(br.readLine());
			parent = new int[F * 2];
			level = new int[F * 2];
			for (int i = 0; i < F * 2; i++) {
				parent[i] = i;
				level[i] = 1;
			}
			int idx = 0;
			Map<String, Integer> map = new HashMap();
			for (int i = 0; i < F; i++) {
				String in[] = br.readLine().split(" ");
				if (!map.containsKey(in[0]))
					map.put(in[0], idx++);
				if (!map.containsKey(in[1]))
					map.put(in[1], idx++);
				System.out.println(union(map.get(in[0]), map.get(in[1])));
			}

		}

	}

	static public int find(int target) {
		if (parent[target] == target) {
			return target;
		}
		parent[target] = find(parent[target]);
		return parent[target];
	}

	static public int union(int i, int j) {
		int x = find(i);
		int y = find(j);
		if(x == y) {
			return level[x];
		}
		if (x < y) {
			parent[y] = x;
			level[x] += level[y];
			level[y] = 1;
			return level[x];
		} else {
			parent[x] = y;
			level[y] += level[x];
			level[x] = 1;
			return level[y];
		}

	}

}
