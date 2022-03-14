package B_2798;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int arr[] = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < N-2; i++) {
			for (int j = i+1; j < N-1; j++) {
				for (int q = j+1; q < N; q++) {
					if (max < arr[i] + arr[j] + arr[q] && (arr[i] + arr[j] + arr[q]) <= M)
						max = arr[i] + arr[j] + arr[q];

				}
			}
		}
		System.out.println(max);
	}

}
