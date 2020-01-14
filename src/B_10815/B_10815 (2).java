package B_10815;

import java.util.*;
import java.lang.*;

public class B_10815 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int num[] = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		int M;
		M = sc.nextInt();
		Arrays.sort(num);
		int ans[] = new int[M];
		int check[] = new int[M];
		for (int i = 0; i < M; i++) {
			check[i] = sc.nextInt();
		}
		
		for (int i = 0; i < M; i++) {
			if (Arrays.binarySearch(num, check[i]) >= 0) {
				check[i] = 1;

			}else {
				check[i] = 0;
			}
		}
		for (int i = 0; i < M; i++) {
			System.out.print(check[i] + " ");
		}

	}

}
