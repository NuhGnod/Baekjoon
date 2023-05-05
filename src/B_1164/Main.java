package B_1164;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int col = 0;
		int row = 0;
	
		String setting[] = br.readLine().split(" ");
		row = Integer.parseInt(setting[0]);
		col = Integer.parseInt(setting[1]);

		Character rect[][] = new Character[row][col];

		for (int i = 0; i < row; i++) {// 영식(직사각형) 종이 그림
			String input = br.readLine();

			for (int j = 0; j < col; j++) {
				rect[i][j] = input.charAt(j);

			}
		}
		solve(rect, row, col);

	}

	static public void solve(Character rect[][], int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (rect[i][j] == 'X') {
					if (j + 4 <= col && i + 2 <= row) {// 1번 모양 사용 가능
						if (shape1(rect, i, j)) {

							continue;
						}
						if (shape2(rect, i, j)) {
							continue;

						}
						System.out.println("-1");
						break;
						// 1번 사용 하면 2번은 자동으로 사용불가.
					} else if(j+2 <= col){// 1번 불가, 오로지 2번 모양
						shape2(rect, i, j);

					}
				}
			}
		}
		check(rect, row, col);

	}

	static public boolean shape1(Character rect[][], int r, int c) {
		if (rect[r][c] == 'X' && rect[r + 1][c] == 'X' && rect[r + 1][c + 1] == 'X' && rect[r + 1][c + 2] == 'X'
				&& rect[r + 1][c + 3] == 'X' && rect[r][c + 3] == 'X'

		) {
			rect[r][c] = 'A';
			rect[r + 1][c] = 'A';
			rect[r + 1][c + 1] = 'A';
			rect[r + 1][c + 2] = 'A';
			rect[r + 1][c + 3] = 'A';
			rect[r][c + 3] = 'A';
			return true;
		}
		return false;
	}

	static public boolean shape2(Character rect[][], int r, int c) {
		if (rect[r][c] == 'X' && rect[r][c + 1] == 'X') {
			rect[r][c] = 'B';
			rect[r][c + 1] = 'B';
			return true;
		}
		return false;

	}

	static public boolean check(Character rect[][], int r, int c) {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (rect[i][j] == 'X') {
					System.out.println(-1);
					return false;// false
				}
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(rect[i][j]);
			}
			System.out.println();
		}
		return true;// true
	}

}
