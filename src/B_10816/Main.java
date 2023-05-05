package B_10816;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int n = Integer.parseInt(st.nextToken());
			sb.append(upper(n, arr) - lower(n,arr) + " ");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	static int lower(int n, int[] arr) {
		int left = 0;
		int right = arr.length;

		while (left < right) {
			int mid = (left + right) / 2;
			if (arr[mid] >= n) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	static int upper(int n, int[] arr) {
		int left = 0;
		int right = arr.length;

		while (left < right) {
			int mid = (left + right) / 2;
			if (arr[mid] <= n) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;	
	}

}
