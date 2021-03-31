package B_17298;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		int[] ans = new int[n];
		String[] temp = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(temp[i]);

		}
		Stack<Integer> st = new Stack();
		st.push(0);

		for (int i = 1; i < n; i++) {
			if (st.isEmpty()) {//첫 번째 원소
				st.push(i);
			}
			while (!st.isEmpty() && a[st.peek()] < a[i]) {//앞에서부터 순차적으로 스택에 입력
				//스택의 최상위 원소가 현재 원소보다 작다면 -> 현재원소가 오큰수가 됨.
				//현재 원소가 오큰수가 되는 index까지만 반복.
				ans[st.pop()] = a[i];
			}
			st.push(i);
		}
		while (!st.isEmpty()) {//스택에 남아있다는 것은 오큰수가 존재 x
			ans[st.pop()] = -1;
		}
		for (int i = 0; i < n; i++) {
			bw.write(ans[i] + " ");
		}

		bw.close();
		br.close();
	}

}
