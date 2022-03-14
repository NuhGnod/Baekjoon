package B_10871;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int X = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int number = sc.nextInt();
			if(number < X	) {
					System.out.print(number + " ");
			}
		}

	}

}
