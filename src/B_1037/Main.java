package B_1037;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int arr[] = new int[N];
		int temp = 99999999;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N-1; i++) {
				if (arr[i] > arr[i + 1]) {
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}

		}
		System.out.println(arr[0] * arr[N-1]);
		
//		for (int i = 0; i < N; i++) {
//			System.out.print(arr[i] + " ");
//		}

	}

}
