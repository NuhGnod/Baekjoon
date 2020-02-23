package B_11866;

import java.util.*;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList();

		int N = sc.nextInt();
		int K = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		int cnt = 0;
		String temp = "<";
		int size = q.size();
		if (K == 1) {
			for (int i = 0; i <size; i++) {
				if (i ==size-1)
					temp += String.valueOf(q.poll());
				else
					temp += String.valueOf(q.poll() + ", ");

			}
		} else {
			while (true) {
				if (q.size() == 0)
					break;
				q.add(q.poll());
				cnt++;
				if (cnt == K - 1) {
					if (q.size() == 1) {
						temp += String.valueOf(q.poll());

					} else {

						temp += String.valueOf(q.poll() + ", ");
					}
					cnt = 0;
					continue;

				}
			}
		}
		temp += ">";
		System.out.println(temp);

	}

}
