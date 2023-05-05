package B_2630;

import java.util.*;
import java.io.*;;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int white = 0;
		int blue = 0;
		int[][] arr = new int[N][N];

		Queue<int[][]> q = new LinkedList();

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		q.add(arr);
		while (true) {
			if (q.size() == 0)
				break;
			arr = q.poll();
			if (!check(arr)) {
				divide(arr,q);
			} else {
				if (arr[0][0] == 0)
					white++;
				else
					blue++;
			}

		}
		System.out.println(white);
		System.out.println(blue);

	}

	static public Queue<int[][]> divide(int[][] arr, Queue<int[][]> q) {

//		Queue<int[][]> q = new LinkedList();
		int oldSize = arr.length;
		int newSize = arr.length / 2;
		int array1[][] = new int[newSize][newSize];
		int array2[][] = new int[newSize][newSize];
		int array3[][] = new int[newSize][newSize];
		int array4[][] = new int[newSize][newSize];

		for (int i = 0; i < newSize; i++) {// 2사분면
			for (int j = 0; j < newSize; j++) {
				array1[i][j] = arr[i][j];

			}
		}
		q.add(array1);

		for (int i = 0; i < newSize; i++) {// 1사분면
			for (int j = newSize; j < oldSize; j++) {
				array2[i][j - newSize] = arr[i][j];

			}
		}

		q.add(array2);
		for (int i = newSize; i < oldSize; i++) {// 3사분면
			for (int j = 0; j < newSize; j++) {
				array3[i - newSize][j] = arr[i][j];
			}
		}
		q.add(array3);
		for (int i = newSize; i < oldSize; i++) {// 4사분면
			for (int j = newSize; j < oldSize; j++) {
				array4[i - newSize][j - newSize] = arr[i][j];

			}
		}
		q.add(array4);
		return q;
	}

	static public boolean check(int[][] arr) {
		int n = arr.length;
		int startColor = arr[0][0];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (startColor != arr[i][j])
					return false;
			}
		}
		return true;
	}

}
