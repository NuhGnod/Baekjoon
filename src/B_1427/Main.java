package B_1427;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		String num = "";
		num = String.valueOf(N);
		int arr[] = new int[num.length()];

		for (int i = 0; i < num.length(); i++) {
			arr[i] = num.charAt(i) - 48;
		}
		for (int i = 0; i < num.length() - 1; i++) {
			for (int j = 0; j < num.length() - 1; j++) {
				int min = 0;
				if (arr[j] < arr[j + 1]) {
					min = arr[j];

					arr[j] = arr[j + 1];
					arr[j + 1] = min;
				}
			}
		}
		for (int i = 0; i < num.length(); i++) {
			System.out.print(arr[i]);
		}
	}

}
