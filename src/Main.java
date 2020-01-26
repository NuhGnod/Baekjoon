package B_14888;

import java.io.*;
import java.util.*;

public class Main {
	static int Max = -1000000000;
	static int N;
	static int Min = 1000000000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int arr[] = new int[N];
		int op[] = new int[N - 1];
		int cnt = 0;
		boolean[] check = new boolean[N - 1];
		// 덧셈, 뺼셈, 곱셈, 나눗셈
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();

		}
//		0 덧셈
//		1 뺄셈
//		2 곱셈
//		3 나눗셈
		
		for (int i = 0; i < 4; i++) {
			int temp = cnt + sc.nextInt();
			for (int j = cnt; j < temp; j++) {
				cnt++;
				op[j] = i;
			}
		}
		int op_seq[] = new int[N - 1];
		back(check, op, 0, op_seq, arr);
		System.out.println(Max);

		System.out.println(Min);
	}

	static void cal(int[] arr, int[] op_seq) {
	
		int temp = 0;
		temp = arr[0];
		for (int i = 0; i < op_seq.length; i++) {
			switch (op_seq[i]) {
			case 0:
				temp += arr[i + 1];
				break;
			case 1:
				temp -= arr[i + 1];
				break;

			case 2:
				temp *= arr[i + 1];
				break;

			case 3:
				if (temp < 0) {
					temp = Math.abs(temp);
					temp /= arr[i + 1];
					temp = -temp;
				} else {
					temp /= arr[i + 1];

				}

				break;

			}
		}
		if (Max <= temp) {
			Max = temp;
		}
		if (Min >= temp) {
Min = temp;
		}
	}

	static void back(boolean[] check, int[] op, int k, int[] op_seq, int[] arr) {

		if (k == N - 1) {
//			for (int i = 0; i < N - 1; i++) {
//				System.out.print(op_seq[i] + " ");
//			}
			cal(arr, op_seq);

			return;
		}

		for (int i = 0; i < N - 1; i++) {

			if (!check[i]) {

				op_seq[k] = op[i];
				check[i] = true;
				back(check, op, k + 1, op_seq, arr);
				check[i] = false;
			}
		}
	}

}
