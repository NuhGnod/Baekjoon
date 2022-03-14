package B_2261;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.valueOf(br.readLine());

		Pair[] pair = new Pair[n];
		StringTokenizer st;
		
		for (int i = 0; i < n; i++) {
			 st = new StringTokenizer(br.readLine());
			pair[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

		}
		Arrays.sort(pair, (a, b) -> (a.x - b.x)); // negative : a will be ordered before b
//		0 : ordering of a anb wont't change
//		positive : b will be ordered before a
		TreeSet<Pair> set = new TreeSet<>((a, b) -> ((a.y == b.y) ? a.x - b.x : a.y - b.y));
		set.add(pair[0]);
		set.add(pair[1]);
		long answer = distSquare(pair[0], pair[1]);
		int start = 0;
		for (int i = 2; i < n; i++) {
			Pair cur = pair[i];
			while (start < i) {
				Pair p = pair[start];
				long x = cur.x - p.x;
				if (x * x > answer) {
					set.remove(p);
					start += 1;
				} else {
					break;
				}
			}
			int d = (int) Math.sqrt((double) answer) + 1;
			Pair from = new Pair(-10001, cur.y - d);
			Pair to = new Pair(10001, cur.y + d);
			for (Pair p : set.subSet(from, to)) {
				long distance = distSquare(cur, p);
				answer = Math.min(answer, distance);
			}
			set.add(cur);
		}
//		for (int i = 0; i < n; i++) {
//			bw.write(pair[i].x + " " + pair[i].y + "\n");
//		}
		bw.write(answer + "\n");
		
		bw.close();
	}

	private static long distSquare(Pair pair, Pair pair2) {
		return (long) ((pair.x - pair2.x) * (pair.x - pair2.x) + (pair.y - pair2.y) * (pair.y - pair2.y));
	}

}

class Pair {
	int x;
	int y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;

	}
}