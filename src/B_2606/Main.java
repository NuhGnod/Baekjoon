package B_2606;

import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer>[] arr;
	static int  N;
	static int  ans;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	 N = Integer.parseInt(br.readLine());
		int V = Integer.parseInt(br.readLine());
		arr = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < V; i++) {
			String temp[] = br.readLine().split(" ");
			int x = Integer.parseInt(temp[0]);
			int y = Integer.parseInt(temp[1]);

			arr[x].add(y);
			arr[y].add(x);

		}
		ans=0;
		bfs(1);
		System.out.println(ans);
	}
	static public void bfs(int start) {
		boolean[] c = new boolean[N+1];
		
		Queue<Integer> q = new LinkedList();
		q.add(start);
		c[start] = true;
		while(!q.isEmpty()) {
			int x =q.remove();
//			System.out.print(x + " ");
			
			for(int y : arr[x]) {
				if(c[y] == false) {
					c[y] = true;
					q.add(y);
					ans++;
				}
			}
		}
		
		
	}

}
