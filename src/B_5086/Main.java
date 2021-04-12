package B_5086;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for (;;) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			if (N == M) {
				break;

			} else {
				if (M % N == 0) {
					System.out.println("factor");
				}
				else if(N % M == 0) {
					System.out.println("multiple");
				}
				else {
					System.out.println("neither");
				}
			}
		}
	}

}
