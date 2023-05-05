package B_1475;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String room = "";
		room = String.valueOf(N);
		int num[] = new int[10];
		for (int i = 0; i < room.length(); i++) {
			num[room.charAt(i) - '0']++;
		}
		
		int j = num[6] + num[9] +1;
		num[6] = j /2;
		num[9] = j / 2;
		

		Arrays.sort(num);
		int max = num[9];
		
		System.out.println(max);

	}

}
