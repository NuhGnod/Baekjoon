package B_1874;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<Integer> st = new Stack();
		int n = Integer.valueOf(br.readLine());
		int num = 0;
		int FLAG = 0;
		ArrayList<String> arr = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			boolean flag = false;

			int temp = 0;
			temp = Integer.valueOf(br.readLine());

			while (num < temp) {
				num++;
//				bw.write("+\n");
				arr.add("+");
				st.add(num);
				if (num == temp) {
					st.pop();
//					bw.write("-\n");
					arr.add("-");
					flag = true;
					break;
				}
			}
			if (flag)
				continue;
			else {
				if (st.peek() != temp) {
					FLAG = 1;
					bw.write("NO\n");
					break;
				}
				st.pop();
//				bw.write("-\n");
				arr.add("-");
				continue;
			}
		}
		if (FLAG == 0) {
			for (int i = 0; i < arr.size(); i++) {
				bw.write(arr.get(i)+ "\n");
			}
		}
		bw.close();
	}

}
