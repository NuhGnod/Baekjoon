package B_2110;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int ans = 0;
		int left = 1;
		int right = arr[N - 1] - arr[0];
		while (left <= right) {
			int mid = (left + right) / 2;
			int cnt = 1;
			int last = arr[0];
			for (int i = 1; i < N; i++) {
				
				if (arr[i] - last >= mid) {
						last = arr[i];
						cnt++;
					}
				
			}
			if (cnt >= M) {
				ans = Math.max(ans, mid);
				left = mid+1;
			}  else {
				right = mid-1;
			}

		}
		System.out.println(ans);

	}

}
