package B_15652;

import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		String temp;
		temp = (br.readLine());
		N = Integer.valueOf(temp.charAt(0) - 48);
		M = Integer.valueOf(temp.charAt(2) - 48);
		int arr[] = new int[M + 1];
		back(arr, 0);
		bw.close();
	}

	static void back(int arr[], int k) throws IOException {
		if (k == M) {
			for (int i = 1; i <= M; i++) {
				bw.write(String.valueOf(arr[i]) + " ");
			}
			bw.write("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {

			arr[k + 1] = i;
			if (arr[k + 1] >= arr[k]) {
				back(arr, k + 1);
			} else {
				arr[k + 1] = 0;
			}

		}
	}

}
