package B_2231;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

//		N 의 각 자리수 구하기 : 
//		1째 자리 : N % 10
//		2째 자리 : (N % 100) / 10
//		3째 자리: (N % 1000) / 100
//		n째 자리 : (N % 10^n) / (10^n-1)
		int temp = 10;
		int size = 1;

		while (true) {
			if ((N / temp) == 0) {
				break;

			}
			temp *= 10;
			size++;
		}
		int flag = 0;
		int plus = 0;
		for (int i = 1; i < N; i++) {
			temp = 10;
			plus = 0;
			plus += i % 10;// 일의 자리
			for (int j = 1; j < size; j++) {
				if (i >= temp) {// 십의 자리 ~ n의 자리
					plus += (i % (temp * 10)) / (temp);
				}
				temp *= 10;
			}
			if (N == (plus + i)) {
				flag = i;
				break;
			}

		}
		System.out.println(flag);

	}
}
