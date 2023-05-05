package B_2805;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		long arr[] = new long[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());

		}
		Arrays.sort(arr);
		long left = 1;
		long right = arr[N - 1];
		long ans = -1;
		while (left <= right) {
			long cnt = 0;
			long mid = (left + right) / 2;
			for (int i = 0; i < N; i++) {
				cnt += (arr[i] < mid) ? 0 : arr[i] - mid;
			}
			if (cnt < M) {
				right = mid - 1;
				continue;
			}
			if (cnt >= M) {
				ans = Math.max(ans, mid);
				left = mid + 1;
			}

		}
		// 0미터로 설정한 경우
		long cnt = 0;
		for (int i = 0; i < N; i++) {
			cnt += arr[i];
		}
		if (cnt >= M) {
			ans = Math.max(ans, 0);
		}
		System.out.println(ans);
	}

}
