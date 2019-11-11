package Baekjoon;

import java.util.*;



public class B_15979 {
	public static int gcd(int a, int b) {
	    while (b != 0) {
	      int temp = a % b;
	      a = b;
	      b = temp;
	    }
	    return Math.abs(a);
	  }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		
		if (M < 0) {
			M = -M;
		}
		if(gcd(M,N) == 1) {//¼­·Î¼Ò
			System.out.println("1");
		}
		else if(gcd(M,N) == 0){
			System.out.println("0");
		}
		else {
			System.out.println("2");
		}
		

	}

}
