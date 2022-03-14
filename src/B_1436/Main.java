package B_1436;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		String temp = "";
		int i = 665;
		int j = 0;
//		
		while (true) {
			i++;
			temp = String.valueOf(i);
			for (j = temp.length() - 1; j > 1; j--) {
				if (temp.charAt(j) == '6' && temp.charAt(j - 1) == '6' && temp.charAt(j - 2) == '6') {
					cnt++;
					break;
				}
			}
			if (cnt == N) {
				System.out.println(i);
				break;
			}
		}
	}

}
