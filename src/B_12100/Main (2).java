package B_12100;

import java.util.*;

class _2048 {
	int set[][];
	int size;
	int index[][];
	int max = 0;

	public _2048(int n) {
		this.size = n;
		set = new int[n][n];
		index = new int[2][size * size];

	}

	public void _2048(int i, int j, int n) {
		set[i][j] = n;
	}

	public int max() {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < size * size; j++) {
				index[i][j] = -1;
			}
		}

		max = set[0][0];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (set[i][j] > max) {
					max = set[i][j];
				}
			}
		}
		return max;

	}

	public void ans() {

		for (int i = 0; i < size; i++) {
			System.out.println();
			for (int j = 0; j < size; j++) {
				System.out.print(set[i][j] + " ");
			}
		}
		System.out.println(index[0][0]);
		for (int i = 0; i < 2; i++) {
			System.out.println();
			for (int j = 0; j < size * size; j++) {
				System.out.print(index[i][j] + " ");
			}
		}

	}

	public void run() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {

			}
		}
	}

	public void move() {
		int k = 0;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {

				if (set[i][j] == max) {
					index[0][k] = i;
					index[1][k] = j;
					k++;
				}

			}
		}

	}
}

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		_2048 _2048 = new _2048(N);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				_2048._2048(i, j, sc.nextInt());
			}
		}

		_2048.max();
		_2048.move();

		_2048.ans();
	}

}
