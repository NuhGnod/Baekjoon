package B_2588;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int a = A;
		int b = B;
		for (int i = 1; i <= 3; i++) {
			int num = 1;

			for (int j = 1; j <= i; j++) {
				num *= 10;
			}

			int temp = A * (B % num);
			B -= (B % num);
			B = B * 10 / num;
			if (i != 1) {
				System.out.println(temp / 10);
			} else {
				System.out.println(temp);
			}
		}
		System.out.println(a * b);
	}

}
