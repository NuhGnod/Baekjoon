package B_1541;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();
		String a = "";
		int arr[] = new int[temp.length()];
		int cnt = 0;
		for (int i = 0; i < temp.length(); i++) {
			if (temp.charAt(i) != ('-') && temp.charAt(i) != ('+')) {
				a += temp.charAt(i);
			}

			if (temp.charAt(i) == ('-') || temp.charAt(i) == ('+')) {
				arr[cnt] = Integer.valueOf(a);
				cnt++;
				a = "";
				arr[cnt] = (temp.charAt(i) - 48);
				cnt++;

			}
		} // -3가 -
//		-5이 +
		arr[cnt] = Integer.valueOf(a);

		int temp1 = 0;
		for (int i = 0; i < temp.length()-1; i++) {
			if (arr[i] == -5) {
				arr[i - 1] = arr[i - 1] + arr[i + 1];
				arr[i] = 0;
				arr[i + 1] = 0;

			}
		}
//		for (int i = 0; i < 50; i++) {
//			System.out.println(arr[i]);
//		}
		int ans = arr[0];
		int flag = 0;
		for (int i = 1; i < temp.length(); i++) {
			if (flag == 1 && arr[i] != -3) {
				ans-=arr[i];
				continue;
			}

			if (arr[i] != -3) {

				ans += arr[i];
			} else {
				flag = 1;
			}
		}
		System.out.println(ans);
	}

}
