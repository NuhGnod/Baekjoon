package B_2263;

import java.io.*;
import java.util.*;

public class Main {
	static int[] in;
	static int post[];

	static int[] root_idx;
	static String ans = "";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		root_idx = new int[N + 1];
		in = new int[N + 1];
		post = new int[N + 1];
		String t[] = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			in[i] = Integer.parseInt(t[i - 1]);
		}
		t = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			post[i] = Integer.parseInt(t[i - 1]);
		}
		for (int i = 1; i <= N; i++) {
			root_idx[in[i]] = i;

		}
		pre(1, N, 1, N);
		System.out.println(ans);
	}

	static void pre(int in_start, int in_end, int post_start, int post_end) {
		if (in_start > in_end || post_start > post_end)
			return;
		int root = post[post_end];
		ans += root + " ";
		int root_index = root_idx[root];
		int left = root_index - in_start;
		pre(in_start, root_index - 1, post_start, post_start + left - 1);
		pre(root_index + 1, in_end, post_start + left, post_end -1);
	}
}
