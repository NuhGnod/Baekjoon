package B_15651;

import java.io.*;

public class Main {
	static int M;
	static int N;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		String temp;
		temp = (br.readLine());
		N = Integer.valueOf(temp.charAt(0)-48);
		M = Integer.valueOf(temp.charAt(2)-48);
		int arr[] = new int[M];
		back(arr, 0);
		bw.close();

	}

	static void back(int[] arr, int k) throws IOException {
		if (k == M) {
			for (int i = 0; i < M; i++) {
				bw.write(String.valueOf(arr[i]) + " ");

			}
			bw.write("\n");

			return;
		}
		for (int i = 0; i < N; i++) {
			arr[k] = i + 1;
			back(arr, k + 1);

		}

	}
}
