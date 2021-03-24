package B_8958;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int ans = 0;
			String temp = br.readLine();
			int score[] = new int[temp.length()];
			for (int j = 0; j < temp.length(); j++) {
				if (temp.charAt(j) == 'O') {
					if (j == 0)
						score[j] = 1;
					if (j != 0)
						score[j] = score[j - 1] + 1;
				} else {
					score[j] = 0;
				}
			}
			for (int j = 0; j < temp.length(); j++) {
				ans += score[j];
			}
			System.out.println(ans);

		}

	}

}
