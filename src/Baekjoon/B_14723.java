package BAEKJOON;

import java.util.*;

public class B_14723 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int n = N;
		int a = 1;

		int b = 0;// ���� �Ʒ����� ����
		int k = 0;// �밢�� ��
		int t = 0;// ��
		int g = 0; // ����;
		int h = 0; // �и�;
		while (n > 0) {
			n -= a;
			a++;
			k++;
		}
		k = k - 1;
		for (int i = 1; i <= k; i++) {
			t += i;

		}

		if (N - t != 0) {
			b = N - t;
		} else {
			b = k;

		}
		h = b;
		g = k + 1 - b + 1;

		System.out.println(g + " " + h);

	}

}
