package B_2884;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int M = sc.nextInt();
		
		if(M - 45 < 0) {
			H-=1;
			M -= 45;
			M +=60;
		}else {
			M -= 45;
		}
		if(H < 0) {
			H = 24 + H;
		}
		System.out.println(H + " " + M);
	}

}
