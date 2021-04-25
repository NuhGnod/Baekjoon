package B_1920;

import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long arr[] = new long[N];

		String temp[] = (br.readLine().split(" "));
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(temp[i]);
			
		}
		Arrays.sort(arr);
		int M = Integer.parseInt(br.readLine());
		temp = br.readLine().split(" ");
		long m[] = new long[M];
		for (int i = 0; i < M; i++) {
			m[i] = Long.parseLong(temp[i]);
		}
		for (int i = 0; i < M; i++) {
			int left = 0;
			int right = N - 1;
			boolean flag = false;
			while (right >= left) {
				int mid = (right + left) / 2;

				if (m[i] < arr[mid]) {
					right = mid - 1;
					continue;
				}
				if (m[i] > arr[mid]) {
					left = mid + 1;
					continue;
				}
				if (m[i] == arr[mid]) {
					System.out.println("1");
					flag = true;
					break;
				}
			}
			if (flag == false)
				System.out.println("0");

		}

	}

}
