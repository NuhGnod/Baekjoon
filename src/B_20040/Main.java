package B_20040;

import java.io.*;
import java.util.*;

//import java.util.*;
public class Main {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String temp[] = br.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);
		parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
		int ans=0;
		for (int i = 0; i < M; i++) {
			String in[] = br.readLine().split(" ");
			int a = Integer.parseInt(in[0]);
			int b = Integer.parseInt(in[1]);
			if(union(a, b)) {
				if(ans == 0)ans = i+1;
				
			}
			
		}
		System.out.println(ans);

	}

	static public boolean union(int i, int j) {
		int x = find(i);
		int y = find(j);
		
		if(x < y)parent[y]=x;
		else parent[x]=y;
		if(x == y)return true;
		else return false;
		
	}

	static public int find(int target) {
		if (parent[target] == target)
			return target;
		else {
			parent[target] = find(parent[target]);
			return parent[target];
		}
	}

}
