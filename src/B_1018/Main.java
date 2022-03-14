package B_1018;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		char board[][] = new char[N][M];
		for (int i = 0; i < N; i++) {
			String temp = sc.next();
			
			for (int j = 0; j < M; j++) {
				board[i][j] = temp.charAt(j);
			}
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

			}
		}
		int ans = N * M;
		int cnt2 = 0;
//		i+j 가 짝수 == board[0][0]와 같아야함
		for (int q = 0; q < N - 7; q++) {

			for (int w = 0; w < M - 7; w++) {
				cnt = 0;
				cnt2 = 0;
				for (int i = q; i < q + 8; i++) {
					for (int j = w; j < w + 8; j++) {
						if (board[0][0] == 'W') {
							if ((i + j) % 2 == 0) {
								if (board[i][j] != 'W') {
									cnt++;
								}
								if (board[i][j] != 'B') {
									cnt2++;
								}
							} else {
								if (board[i][j] != 'B') {
									cnt++;
								}
								if (board[i][j] != 'W')
									cnt2++;
							}

						} else {
							if ((i + j) % 2 == 0) {
								if (board[i][j] != 'B') {
									cnt++;
								}
								if (board[i][j] != 'W')
									cnt2++;
							} else {
								if (board[i][j] != 'W') {
									cnt++;
								}
								if (board[i][j] != 'B')
									cnt2++;
							}
						}
					}
				}
				if (ans > cnt) {
					ans = cnt;
				}
				if (ans > cnt2) {
					ans = cnt2;
				}
			}
		}
		System.out.println(ans);
	}

}
