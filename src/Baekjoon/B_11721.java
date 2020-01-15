package BAEKJOON;
import java.util.*;
public class B_11721 {

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		String N =sc.nextLine();
		int check = 0;
		int t=0;
		char [] A = new char [N.length()];
		for(int i =0; i<N.length(); i++) {
			A[i] = N.charAt(i);
			check++;
			System.out.print(A[i]);
			if(check >9 && check%10 == 0) {
				
				System.out.println();
			}
		}
		System.out.println(check);
		
		
	}
}
