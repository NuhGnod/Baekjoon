package B_9663;

import java.util.*;

public class Main {
	static int cnt = 0;
	static int N;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		for (int i = 1; i < N + 1; i++) {
			int chess[] = new int[N + 1];
			chess[1] = i;
			back(chess, 1);
		}
		System.out.println(cnt);
	}

	static boolean isPossible(int[] chess, int level) {
		for (int i = 1; i < level; i++) {
			if (chess[i] == chess[level] || Math.abs(level - i) == Math.abs(chess[level] - chess[i])) {
				return false;
			}
		}
		return true;
	}

	static void back(int[] chess, int level) {
		if (level == N) {
			cnt++;
		} else {
			for (int i = 1; i < 1 + N; i++) {
				chess[level + 1] = i;
				if (isPossible(chess, level + 1)) {
					back(chess, level + 1);
				}
			}
		}
	}

}
