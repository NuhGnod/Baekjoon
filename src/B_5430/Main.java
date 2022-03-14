package B_5430;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.valueOf(br.readLine());// 100

		for (int i = 0; i < N; i++) {// 100
			int flag = 0;// 원상태
			String p = br.readLine();// 100,000
			int n = Integer.valueOf(br.readLine());// 100,000
			String temp = br.readLine();// 100[1,2,3,4]
			String temp2 = "";
			Deque<Integer> d1 = new LinkedList<Integer>();// 100
			int FLAG = 0;
			for (int j = 0; j < temp.length(); j++) {// 100
				if (temp.charAt(j) == '[') {
					continue;
				} else if (temp.charAt(j) == ',' || temp.charAt(j) == ']') {
					if (temp2.length() != 0)
						d1.addLast(Integer.valueOf(temp2));
					temp2 = "";
					continue;
				} else {
					temp2 += temp.charAt(j);
				}
			}
//			while (true) {
//				int k = 0;
//				if (temp.charAt(k) == ',') {
//					continue;
//				}else {
//					
//				}
//			}
			for (int j = 0; j < p.length(); j++) {// 100,000
				if (p.charAt(j) == 'R') {// 뒤집기
					flag++;
					continue;
				}
				if ((flag % 2) == 0) { // 원상태
					if (d1.size() == 0) {
						bw.write("error\n");
						FLAG = 1;
						break;
					} else
						d1.pollFirst();
				} else {// 뒤집힌 상태
					if (d1.size() == 0) {
						bw.write("error\n");
						FLAG = 1;

						break;
					} else
						d1.pollLast();
				}
			}
			if (flag % 2 == 0 && FLAG !=1) {
				int size = d1.size();
				String t = "";
				bw.write("[");
				for (int j = 0; j < size; j++) {// 100
					t = String.valueOf(d1.pollFirst());
					bw.write(t);
					if (j != size - 1)

						bw.write(",");
				}
					bw.write("]\n");
				
			} else if (flag % 2 != 0 && FLAG !=1){

				int size = d1.size();
				String t = "";
				bw.write("[");
				for (int j = 0; j < size; j++) {// 100
					t = String.valueOf(d1.pollLast());
					bw.write(t);
					if (j != size - 1)
						bw.write(",");
				}
				bw.write("]\n");

			}
		}
		bw.close();
	}

}
