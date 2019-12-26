package B_2447;

import java.util.*;

public class Main {

	public static void go(int n, int x, int y) {
		if ((x / n) % 3 == 1 && (y / n) % 3 == 1) {
			System.out.print(" ");
		} else {
			if (n / 3 == 0) {
				System.out.print("*");
			} else {
				go(n / 3, x, y);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				go(n, i, j);
			}
			System.out.println();
		}
	}

}
