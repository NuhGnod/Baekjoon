package B_1966;

import java.util.*;
import java.awt.Point;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.valueOf(br.readLine());

		for (int i = 0; i < N; i++) {
			String temp[] = br.readLine().split(" ");
			String value[] = br.readLine().split(" ");
			Queue<Integer> q = new LinkedList();
			int cnt = 0;
			int target = Integer.valueOf(temp[1]) + 1;
			int number = Integer.valueOf(temp[0]);
			for (int j = 1; j <= number; j++) {
				q.add(j);
			}
			while (true) {
				int poll = 0;
				if (q.size() == 0)
					break;
				if (check(value)) {
					q.add(q.poll());
					value = change(value);
				} else {
					poll = q.poll();
					value = valuePoll(value);
					cnt++;

				}
				if (target == poll) {
					bw.write(cnt+ "\n");
					break;
				}
			}

		}
		bw.close();
	}

	static public String[] valuePoll(String[] value) {
		String VALUE[] = new String[value.length - 1];
		for (int i = 1; i < value.length; i++) {
			VALUE[i - 1] = value[i];
		}
		return VALUE;
	}

	static public String[] change(String[] value) {
		String temp = value[0];
		for (int i = 0; i < value.length - 1; i++) {
			value[i] = value[i + 1];
		}
		value[value.length - 1] = temp;
		return value;
	}

	static public boolean check(String[] value) {

		for (int i = 0; i < value.length; i++) {
			if (Integer.valueOf(value[0]) < Integer.valueOf(value[i])) {
				return true;
			}
		}
		return false;
	}

}
