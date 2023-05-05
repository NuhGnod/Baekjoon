package B_5543;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int burger = 10000;
		int drink = 10000;
		for (int i = 0; i < 3; i++) {
			int temp = sc.nextInt();
			if (burger > temp)
				burger = temp;
		}
		for (int i = 0; i < 2; i++) {
			int temp = sc.nextInt();
			if (drink > temp)
				drink = temp;
		}
		System.out.println(burger+drink-50);
	}

}
