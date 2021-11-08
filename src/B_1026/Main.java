package B_1026;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String a[] = br.readLine().split(" ");
		String b[] = br.readLine().split(" ");
		int A[] = new int[a.length];
		int B[] = new int[b.length];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(a[i]);
			B[i] = Integer.parseInt(b[i]);

		}
		Arrays.sort(A);
		Arrays.sort(B);
		long ans = 0;
		for(int i=a.length-1; i>=0; i--) {
			ans += B[i] * A[a.length-1-i];
		}
		System.out.println(ans);
	}

}
