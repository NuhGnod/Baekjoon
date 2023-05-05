package B_10250;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();// 테스트케이스 수

		for (int i = 0; i < T; i++) {
			int floor = 0;
			int room = 1;
			String ans = "";
			int H = sc.nextInt();// 빌딩 높이
			int W = sc.nextInt();// 빌딩 가로 길이
			int N = sc.nextInt();// 손님 수
			while (N / H > 0) {

				if (N % H != 0) {
					room += N / H;
					N = N % H;
				} else {
					room += N / H -1;
					N = H;
					break;
				}

			}
			floor += N;
			ans += String.valueOf(floor);
			if (room < 10) {
				ans += "0";
				ans += String.valueOf(room);
			} else {
				ans += String.valueOf(room);
			}

			System.out.println(ans);
			ans = "";

		}

	}
}
