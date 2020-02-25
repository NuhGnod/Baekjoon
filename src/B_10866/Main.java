package B_10866;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.valueOf(br.readLine());

		Deque<Integer> d = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			String temp[] = br.readLine().split(" ");
			if (temp[0].equals("push_front")) {
				d.addFirst(Integer.valueOf(temp[1]));
			}
			if (temp[0].equals("push_back")) {
				d.addLast(Integer.valueOf(temp[1]));
			}
			if (temp[0].equals("pop_front")) {
				if (d.isEmpty())
					bw.write("-1\n");
				else
					bw.write(d.pollFirst()+"\n");

			}
			if (temp[0].equals("pop_back")) {
				if (d.isEmpty())
					bw.write("-1\n");
				else
					bw.write(d.pollLast()+"\n");
			}
			if (temp[0].equals("size")) {
				bw.write(d.size()+"\n");
			}
			if (temp[0].equals("empty")) {
				if (d.isEmpty())
					bw.write("1\n");
				else
					bw.write("0\n");
			}
			if (temp[0].equals("front")) {
				if (d.isEmpty())
					bw.write("-1\n");
				else
					bw.write(d.peekFirst()+"\n");
			}
			if (temp[0].equals("back")) {
				if (d.isEmpty())
					bw.write("-1\n");
				else
					bw.write(d.peekLast()+"\n");
			}
		}
		bw.close();

	}

}
