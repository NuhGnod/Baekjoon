package B_2447;

import java.util.*;

public class Main {
	private static char[][] starArr;

	public static void go(int n, int x, int y) {
		if ((x / n) % 3 == 1 && (y / n) % 3 == 1) {
			starArr[x][y] = ' ';
		} else {
			if (n / 3 == 0) {
				starArr[x][y] = '*';
			} else {
				go(n / 3, x, y);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		starArr = new char[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(starArr[i], ' ');
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				go(n, i, j);
			}
		}for(int i=0; i<n; i++) {
			System.out.println(starArr[i]);
		}
	}

}
