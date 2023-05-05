package B_10817;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int arr[] =new int[3];
		arr[0] = A;
		arr[1] = B;
		arr[2] = C;
		Arrays.sort(arr);
		System.out.println(arr[1]);
	}

}
