package B_1021;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int arr[] = new int[M];
		Deque<Integer> d = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			d.addLast(i);
		}
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < M; i++) {
			while (true) {
				int index = findIndex(arr, d);
				if (index <= d.size()/2) {// front
					if (arr[i] != d.peekFirst()) {

						MoveLeft(d);
						cnt++;
					} else {
						d.pollFirst();
						break;
					}
				} else {
					if (index <= d.size()/2) {
						cnt++;
						MoveRight(d);
					} else {
						d.pollFirst();
						break;
					}
				}
			}
		}
		System.out.println(cnt);
	}

	static int findIndex(int[] arr, Deque<Integer> d) {
		Deque<Integer> temp = d;
		int index = -1;
		int size = d.size();
		for (int i = 0; i < size; i++) {
			index++;
			if (arr[i] == temp.pollFirst())
				return index;
		}

		return index;
	}

	static public Deque MoveLeft(Deque<Integer> d) {

		d.addLast(d.pollFirst());

		return d;
	}

	static public Deque MoveRight(Deque<Integer> d) {
		d.addFirst(d.pollLast());

		return d;
	}
}
