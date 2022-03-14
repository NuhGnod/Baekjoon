package B_14938;

import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
	int  v, w;

	Pair(int v, int w) {
		
		this.v = v;
		this.w = w;
	}

	

	int getV() {
		return this.v;

	}

	int getW() {
		return this.w;
	}

	@Override
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		if (this.w > o.getW()) {
			return 1;
		} else if (this.w < o.getW()) {
			return -1;
		} else {
			return 0;
		}
	}
}

public class Main {
	static int ans =0;
	static int N;
	static int M;
	static int R;
	static ArrayList<Pair>[] graph;
	static int[] items;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String temp[] = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		R = Integer.parseInt(temp[2]);

		items = new int[1 + N];
		temp = br.readLine().split(" ");
		graph = new ArrayList[N + 1];

		for (int i = 0; i < temp.length; i++) {
			items[i + 1] = Integer.parseInt(temp[i]);
		}

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList();
		}
		for (int i = 1; i <= R; i++) {
			temp = br.readLine().split((" "));
			int u = Integer.parseInt(temp[0]);
			int v = Integer.parseInt(temp[1]);
			int w = Integer.parseInt(temp[2]);
			graph[u].add(new Pair( v, w));
			graph[v].add(new Pair( u, w));

		}
//		dijk(1);
		for (int i = 1; i <= N; i++) {
			dijk(i);
		}
		System.out.println(ans);
	}

	static public void dijk(int start) {
		
		int[] distance = new int[N + 1];
		for(int i=0;i<N+1; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		pq.add(new Pair(start, 0));
		distance[start] = 0;
		while (!pq.isEmpty()) {
			Pair p = pq.poll();
			int u = p.v;
			int w=p.w;
			if(distance[u] <  w)continue;
			for(Pair x : graph[u]) {
				int nw = w + x.w;
				if(distance[x.v] > nw) {
					distance[x.v]= nw;
					pq.add(new Pair(p.v, nw));
				}
			}
		}
		int temp=0;
		for(int i=1; i<= N; i++) {
			if(distance[i] <= R) {
				temp+=items[i];
			}
		}
		if(ans < temp)ans = temp;
		
		
	}
}
