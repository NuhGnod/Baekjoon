package B_1924;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();
		int cal[] = new int[13];
		cal[1] = 31;
		cal[3] = 31;
		cal[5] = 31;
		cal[7] = 31;
		cal[8] = 31;
		cal[10] = 31;
		cal[12] = 31;
		cal[2] = 28;
		cal[4] = 30;
		cal[6] = 30;
		cal[9] = 30;
		cal[11] = 30;
		int total_day = 0;
		for (int i = 0; i < x; i++) {
			total_day += cal[i];
		}
		total_day += y;
		int day = total_day % 7;
		if(day == 1) System.out.println("MON");
		if(day == 2) System.out.println("TUE");
		if(day == 3) System.out.println("WED");
		if(day == 4) System.out.println("THU");
		if(day == 5) System.out.println("FRI");
		if(day == 6) System.out.println("SAT");
		if(day == 0) System.out.println("SUN");
		
	}
	

}
