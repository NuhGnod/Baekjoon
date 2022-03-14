package B_4949;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int cnt = 0;
		while (true) {
			int flag = 0;

			String temp = br.readLine();
			if (temp.equals("."))
				break;
			Stack<Character> st = new Stack();
			for (int i = 0; i < temp.length(); i++) {
				if (temp.charAt(i) == '(' || temp.charAt(i) == '[') {
					st.add(temp.charAt(i));
				}
				if (st.isEmpty() && (temp.charAt(i) == ')' || temp.charAt(i) == ']')) {// 비어있는데 닫는 괄호
					bw.write("no\n");
					flag = 1;
					break;
				}
				if (!st.isEmpty() && (temp.charAt(i) == ')' || temp.charAt(i) == ']')) {// 닫는 괄호
					if ((temp.charAt(i) == ')')) {// 정상
						if (st.peek() == '(') {
							st.pop();
							continue;
						}
					}
					if ((temp.charAt(i) == ']')) {// 정상
						if (st.peek() == '[') {
							st.pop();
							continue;
						}
					}
					// 비정상
					flag=1;
					bw.write("no\n");
					break;

				}
			}

			if (flag == 0) {
				if (st.isEmpty())
					bw.write("yes\n");
				else {
					bw.write("no\n");

				}
			}

		}
//([]()).
//[]().
//(].
//)(.
//([)].
//([(([([])()(())]))]).
// .
		bw.close();

	}
}
