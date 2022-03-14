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
				int index = findIndex(arr, d, i);
				if (index <= d.size() / 2) {// front
					if (arr[i] != d.peekFirst()) {

						MoveLeft(d);
						cnt++;
					} else {
						d.pollFirst();
						break;
					}
				} else {
					if (arr[i] != d.peekFirst()) {
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

	static int findIndex(int[] arr, Deque<Integer> d, int k) {
		Deque<Integer> temp = new LinkedList();
		Iterator iterator;
		iterator = d.iterator();
		int index = -1;
		int size = d.size();
		if (iterator.hasNext()) {

		}
		for (int i = 0; i < size; i++) {

			index++;
			if (arr[k] == Integer.valueOf(iterator.next().toString()))
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
