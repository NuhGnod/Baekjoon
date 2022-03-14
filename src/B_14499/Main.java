package B_14499;

import java.util.*;

class dice {
	int check = 0; // print
	int dice[] = { 0, 0, 0, 0, 0, 0 }; // ¹Ø À§ µ¿ ¼­ ³² ºÏ
	int temp = 0;
	int map[][];
	int n = 0;
	int m = 0;
	int locate_y = 0;
	int locate_x = 0;

	public void map(int n, int m) {
		this.n = n;
		this.m = m;
		map = new int[n][m];
		// map
	}

	public void map(int i, int j, int t) {
		map[i][j] = t;
	}

	public void print() {
		if (check == 0)
			System.out.println(dice[1]);

	}

	public void dice_locate(int y, int x) {
		if (locate_x >= this.m || locate_x < 0 || locate_y >= this.n || locate_y < 0) {
		} else {
			locate_x += y;
			locate_y += x;
		}
	}

	public void remap() {
		if (check == 1) {
		} else if (map[locate_y][locate_x] == 0) {

			check = 0;
			map[locate_y][locate_x] = dice[0];
		} else if (check != 1 && map[locate_y][locate_x] != 0) {
			check = 0;
			dice[0] = map[locate_y][locate_x];
			map[locate_y][locate_x] = 0;
		}
	}

	public void dice_move(int n) {
		if (n == 1) {
			if (locate_x + 1 >= this.m || locate_x + 1 < 0 || locate_y >= this.n || locate_y < 0) {
				check = 1;

			} else {
				check = 0;
				dice_locate(1, 0);

				temp = dice[0];
				dice[0] = dice[2];
				dice[2] = dice[1];
				dice[1] = dice[3];
				dice[3] = temp;
			}
		} else if (n == 2) {
			if (locate_x - 1 >= this.m || locate_x - 1 < 0 || locate_y >= this.n || locate_y < 0) {
				check = 1;

			} else {
				check = 0;
				dice_locate(-1, 0);

				temp = dice[0];
				dice[0] = dice[3];
				dice[3] = dice[1];
				dice[1] = dice[2];
				dice[2] = temp;
			}
		} else if (n == 3) {
			if (locate_x >= this.m || locate_x < 0 || locate_y - 1 >= this.n || locate_y - 1 < 0) {
				check = 1;

			} else {
				check = 0;
				dice_locate(0, -1);

				temp = dice[0];
				dice[0] = dice[5];
				dice[5] = dice[1];
				dice[1] = dice[4];
				dice[4] = temp;
			}
		} else if (n == 4) {
			if (locate_x >= this.m || locate_x < 0 || locate_y + 1 >= this.n || locate_y + 1 < 0) {
				check = 1;

			} else {
				check = 0;
				dice_locate(0, 1);

				temp = dice[0];
				dice[0] = dice[4];
				dice[4] = dice[1];
				dice[1] = dice[5];
				dice[5] = temp;
			}
		}
	}
}

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		dice dice = new dice();

		int n = sc.nextInt(); // map
		int m = sc.nextInt(); // map
		int y = sc.nextInt(); // dice under_area location
		int x = sc.nextInt(); // dice under_area location
		int t = sc.nextInt();
		int move = 0; // dice moving
		dice.map(n, m);
		dice.dice_locate(x, y);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dice.map[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < t; i++) {
			move = sc.nextInt(); // dice moving

			dice.dice_move(move);

			dice.remap();
			dice.print();
		}

	}
}
