package B_10818;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int arr[] = new int[N];
		int min = 99999999;
		int max = -99999999;
		for (int i = 0; i < N; i++) {
			int temp = sc.nextInt();
			if(temp > max) {
				max = temp;
			}
			if(temp <min) {
				min = temp;
			}
			
		}
		System.out.println(min + " " + max);

	}

}
