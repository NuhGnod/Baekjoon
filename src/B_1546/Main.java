package B_1546;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double arr[] = new double[N];
		double max = 0;
		double newArr[] = new double[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();

		}
		for (int i = 0; i < N; i++) {
			max = (max < arr[i] ? arr[i] : max);

		}
		for (int i = 0; i < N; i++) {
			
				newArr[i] = arr[i] / max*100;

			
		}
		double plus = 0;
		for (int i = 0; i < N; i++) {
			plus += newArr[i];
		}
		System.out.println(plus / N);

	}

}
