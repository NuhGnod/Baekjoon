package B_2523;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int i = 0; i < 2 * N - 1; i++) {
			if (i <= N - 1) {
				for (int j = 0; j <= i; j++) {
					System.out.print("*");
				}
			} else {
				for (int j = 0; j < 2*N - 1 - i; j++) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}

}
