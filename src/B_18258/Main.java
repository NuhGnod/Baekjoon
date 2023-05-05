package B_18258;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Queue<String> q = new LinkedList<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String back = "";
		int N = Integer.valueOf(br.readLine());
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			String arr[] = new String[temp.length()];

			arr = temp.split(" ");

			if (arr[0].equals("push")) {

				back = (arr[1]);
				q.add(arr[1]);
			}
			if (temp.equals("front")) {
				if (q.isEmpty())
					bw.write("-1\n");
				else
					bw.write(q.peek() + "\n");

			}
			if (temp.equals("size")) {
				bw.write(q.size() + "\n");

			}
			if (temp.equals("back")) {
				if (q.isEmpty())
					bw.write("-1\n");

				else
					bw.write(back + "\n");

			}
			if (temp.equals("pop")) {
				if (q.isEmpty())
					bw.write("-1\n");
				else
					bw.write(q.poll() + "\n");
			}
			if (temp.equals("empty")) {
				bw.write(q.isEmpty() ? "1\n" : "0\n");
				
			}
		}
		bw.close();
	}

}
