package B_2446;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int i = 0; i < 2 * N - 1; i++) {
			for (int j = 0; j < 2 * N - 1; j++) {
				if (i <= (2 * N - 1) / 2) {
					if (i > j)
						System.out.print(" ");
					else if (j >= 2 * N - 1 - i) {

					} else {
						System.out.print("*");
					}
				} else {
					if (2 * N - 2 - i > j) {
						System.out.print(" ");
					} else if (i < j) {

					} else {
						System.out.print("*");
					}
				}
			}
			System.out.println();
		}

	}

}
