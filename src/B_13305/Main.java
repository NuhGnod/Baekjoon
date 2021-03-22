package B_13305;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		String len[] = br.readLine().split(" ");
		String price[] = br.readLine().split(" ");
		long minPrice = 0;
		long setMinPrice = 0;
		long totalMinPrice =0 ;
		long middleLength = 0;
//		totalMinPrice = Integer.parseInt(len[0]) * Integer.parseInt(price[0]);
		minPrice = Integer.parseInt(price[0]);
		
		for (int i = 1; i < N; i++) {
			
			int curPrice = Integer.parseInt(price[i]);
			int curLen = Integer.parseInt(len[i-1]);
			if (curPrice < minPrice) {
				totalMinPrice += minPrice * curLen;
				minPrice = curPrice;				
			}	
			else {
				totalMinPrice += minPrice * curLen;
				middleLength = 0;
			}
		}
		System.out.println(totalMinPrice);

	}

}
