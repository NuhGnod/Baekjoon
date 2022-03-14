package B_2753;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int flag = 0;
		if ((N % 4 == 0) && (N % 100 != 0) || (N % 4 == 0) && (N % 400 == 0)) {
			flag = 1;
		}
		System.out.println(flag);
	}

}
