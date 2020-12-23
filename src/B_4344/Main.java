package B_4344;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			int n = sc.nextInt();
			int score[] = new int[n];
			double avg = 0;
			for (int j = 0; j < n; j++) {
				score[j] = sc.nextInt();
				avg += score[j];
			}
			int count = 0;
			avg /= n;
			for (int j = 0; j < n; j++) {
				if (score[j] > avg) {
					count++;
				}
			}
			double result = count * 100.000 / n;
			System.out.println(String.format("%.3f", result) + "%");
		}
	}

}
