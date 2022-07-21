package B_10282;

import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
	int v, s;

	Pair(int v, int s) {
		this.v = v;
		this.s = s;
	}

	@Override
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		return s - o.s;
	}

}

public class Main {
	static ArrayList<Pair>[] graph;
	static int [] dist;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n, d, c;
			String in[] = br.readLine().split(" ");
			n = Integer.parseInt(in[0]);
			d = Integer.parseInt(in[1]);
			c = Integer.parseInt(in[2]);
			dist =  new int[n+1];
			graph = new ArrayList[n+1];
			for(int i=1;i <=n; i++) {
				dist[i] = Integer.MAX_VALUE;
				graph[i] = new ArrayList();
			}
			
			for (int i = 0; i < d; i++) {
				int a, b, s;
				String hack[] = br.readLine().split(" ");
				a = Integer.parseInt(hack[0]);
				b = Integer.parseInt(hack[1]);
				s = Integer.parseInt(hack[2]);
				graph[b].add(new Pair(a,s));
			}
			dist[c] = 0;
			dijk(c);
			int  ans=0;
			int cost = 0;
			for(int   i=1; i<=n; i++) {
				if(dist[i] != Integer.MAX_VALUE) {
					ans++;
					cost = Math.max(cost, dist[i]);
				}
			}
			System.out.println(ans + " " + cost);
		}
	}

	static public void dijk(int start) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(start,0));
		
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			for(Pair x : graph[p.v]) {
				int v = x.v;
				int s = x.s;
				if(dist[v] > dist[p.v] + s) {
					dist[v] = dist[p.v] + s;
					pq.add(new Pair(v,s));
				}
			}
		}
	}

}
