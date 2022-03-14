package B_1697;

import java.util.*;
import java.io.*;

class map {
	int pos;
	int time;

	map(int p, int t) {
		pos = p;
		time = t;
	}

	int getPos() {
		return pos;
	}

	int getTime() {
		return time;
	}
}

public class Main {
	static int N, M;
	static boolean c[];
	static int ans;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		if (N > M) {
			c =new boolean[N+1];
		}else {
			c = new boolean[M + 2];
				
		}
		bfs(N, M);
		System.out.println(ans);
	}

	static public int bfs(int X, int K) {
		ans = 9999999;
		map m = new map(X, 0);

		Queue<map> q = new LinkedList();
		q.add(m);

		while (!q.isEmpty()) {
			int time = q.peek().getTime();
			int pos = q.poll().getPos();
			c[pos] = true;
			if (pos == M)
				ans = Math.min(ans, time);
			else {
				if (pos - 1 >= 0) {
					if (!c[pos - 1])
						q.add(new map(pos - 1, time + 1));
				}
				if (pos + 1 <= M + 1) {
					if (!c[pos + 1])
						q.add(new map(pos + 1, time + 1));
				}
				if (pos * 2 <= M + 1) {
					if (!c[pos * 2])
						q.add(new map(pos * 2, time + 1));
				}

			}
		}
		return 1;

	}

}
