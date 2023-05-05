package B_2164;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList();
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		while (q.size() > 1) {
			q.poll();
			q.add(q.poll());
		}
		System.out.println(q.peek());
	}

}
