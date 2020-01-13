package B_1110;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String N = sc.nextLine();
		int cnt = 0;
		String temp = "";
		while (!temp.equals(N)) {
			if (Integer.valueOf(N) < 10) {
				N += "0";
			}
			String n_r = "";
			String num_r="";
			int num;
			if (cnt == 0) {
				n_r = String.valueOf(N.charAt(1));

				num = Integer.valueOf(N.charAt(0) - 48) + Integer.valueOf(N.charAt(1) - 48);

			} else {
				n_r = String.valueOf(temp.charAt(1));

				num = Integer.valueOf(temp.charAt(0) - 48) + Integer.valueOf(temp.charAt(1) - 48);	

			}
			if(num < 10) {
				num_r = String.valueOf(String.valueOf(num).charAt(0));

			}else {
				num_r = String.valueOf(String.valueOf(num).charAt(1));

			}

			temp = n_r + String.valueOf(num_r);
			cnt++;
		}
		System.out.println(cnt);
	}

}
