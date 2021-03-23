package B_2577;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		int ans = a * b * c;

		String str = String.valueOf(ans);

		int arr[] = new int[10];	

		for (int i = 0; i < str.length(); i++) {
			int index = str.charAt(i) - '0';
			arr[index]++;
		}
		for(int i=0; i<10; i++)
		{
			System.out.println(arr[i]);
		}

	}

}
