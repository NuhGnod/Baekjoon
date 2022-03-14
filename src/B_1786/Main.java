package B_1786;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String T = br.readLine();
		String P = br.readLine();
		int cnt = 0;
		int[] arr = new int[1000000 + 1];
		int table[] = new int[P.length()];
		int idx = 0;
		for (int i = 1; i < P.length(); i++) {
			while (idx > 0 && P.charAt(i) != P.charAt(idx)) {
				idx = table[idx - 1];
			}
			if (P.charAt(idx) == P.charAt(i)) {
				idx++;
				table[i] = idx;
			}
		}
		int j = 0;
		for (int i = 0; i < T.length(); i++) {
			while (j > 0 && P.charAt(j) != T.charAt(i)) {
				j = table[j - 1];
			}
			if (P.charAt(j) == T.charAt(i)) {
				if (j == P.length() - 1) {
					cnt++;
					arr[cnt - 1] = i - P.length() + 2;
					j = table[j];
				} else {
					j++;
				}
			}
		}
		System.out.println(cnt);
		for (int i = 0; i < cnt; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
