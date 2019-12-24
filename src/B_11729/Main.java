package B_11729;

import java.util.*;

public class Main {
	static int cnt = 0;// total number of movement

	public static Object hanoi(int a, int from, int mid, int to) {
		if(a == 1) {
			cnt++;
			System.out.println(from + " " + to + "one");
		}else {
			
			
			hanoi(a-1, from, to, mid);
			cnt++;
			System.out.println(from +" "+to);
			hanoi(a-1, mid, from, to);
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a; // bar A
		int b; // bar B
		int c; // bar C

		System.out.println((int) Math.pow(2, n) - 1);
		hanoi(n, 1, 2, 3);// total num of disk, bar A, bar C
		System.out.println(cnt);
	}

}
