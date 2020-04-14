package B_6549;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (true) {
			String[] arr;
			String temp = br.readLine();
			Stack<Long> st = new Stack();
			arr = (temp.split(" "));
			int N = Integer.valueOf(arr[0]);
			if (N == 0)
				break;
			st.add(Long.valueOf(arr[1]));
			long s = 0;
			s = st.get(0);
			for (int i = 1; i < N; i++) {
				if (Long.valueOf(arr[i]) < st.get(i - 1)) {
					if(s > (i+1)*)
				}
			}
		}
	}

}
