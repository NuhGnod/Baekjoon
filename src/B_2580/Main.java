package B_2580;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int sudoku[][] = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = sc.nextInt();
			}
		}
		int arr[] = new int[9];
		boolean[] check = new boolean[9];

		sudoku(sudoku, arr, check, 0);
	}

	static int[] find(int map, int[] num, int x, int y) {
		for (int i = 0; i < 9; i++) {

		}
		for (int i = 0; i < 9; i++) {

		}

		return num;
	}

	static void sudoku(int sudoku[][], int[] arr, boolean check[], int k) {
		// 012 345 678
		int num[] = new int[9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

			}
		}
		for (int i = 0; i < 9; i++) {

		}
		for (int i = 0; i < 9; i++) {

		}
	}

}
