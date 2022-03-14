package B_9012;

import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.valueOf(br.readLine());
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			Stack<Character> vps = new Stack();
			int flag = 0;
			for (int j = 0; j < temp.length(); j++) {
				if (temp.charAt(j) == ')' && vps.empty()) {
					flag = 1;
					bw.write("NO\n");
					break;
				} else if (temp.charAt(j) == ')' && !vps.empty()) {
					vps.pop();
					continue;
				}
				vps.add(temp.charAt(j));

			}
			if (flag == 0) {
				if (vps.empty())
					bw.write("YES\n");
				else {
					bw.write("NO\n");
				}
			}
		}
		bw.close();
	}

}
