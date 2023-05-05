package B_2292;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int temp = 1;
		for (int i = 0; i < N; i++) {
				temp += i * 6;
				if (temp >= N) {
					System.out.println(i+1);
					break;
				}
			}
		
	}

}
