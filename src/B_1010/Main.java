package B_1010;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			long A = 1;
			long B = 1;
			
			if (a >= 15) {
				a = b - a;
				
			}
			int time = a;
			for (int j = 0; j < time; j++) {
				A *= b--;
				B *= a--;

			}
//			System.out.println(A + " " + B);
			System.out.println((long) (A / B));
		}
	}

}
