package B_2562;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int maxIndex = 0;
		int max = 0;

		for (int i = 0; i < 9; i++) {
			int temp = sc.nextInt();
			if (max < temp) {
				max = temp;
				maxIndex = i + 1;
			}
		}
		System.out.println(max);
		System.out.println(maxIndex);
	}
}
