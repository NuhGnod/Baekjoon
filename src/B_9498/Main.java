package B_9498;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if (N >= 90)
			System.out.println("A");
		if (N >= 80 && N < 90)
			System.out.println("B");
		if(N >= 70 && N < 80)
			System.out.println("C");
		if(N >= 60 && N < 70)
			System.out.println("D");
		if(N<60)System.out.println("F");
	}
}
