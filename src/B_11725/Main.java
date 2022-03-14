package B_11725;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] array = new ArrayList[N + 1];
		boolean[] c = new boolean[N + 1];
		int arr[] = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			array[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < N-1; i++) {
			String in[] = br.readLine().split(" ");
			int a = Integer.parseInt(in[0]);
			int b = Integer.parseInt(in[1]);
			array[a].add(b);
			array[b].add(a);

		}
		arr[1] = 1;

		Queue<Integer> q = new LinkedList();
		q.add(1);
		while (!q.isEmpty()) {
			int index = q.poll();
			c[index] = true;
			for (int x : array[index]) {
				if (!c[x]) {
					arr[x] = index;
					q.add(x);
					c[x] = true;
				}
			}
		}
		for (int i =2; i <= N; i++) {
			System.out.println(arr[i]);
		}
	}

}
