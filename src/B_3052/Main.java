package B_3052;

import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean arr[] = new boolean[42];
		for(int  i=0; i<10;i++) {
			int temp = sc.nextInt();
			int index = temp % 42;
			arr[index] = true;
		}
		int ans=0;
		for(int i=0; i<42; i++	) {
			if(arr[i] == true)
				++ans;
		}
		System.out.println(ans);
	}

}
