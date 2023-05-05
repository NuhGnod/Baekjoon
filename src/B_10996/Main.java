package B_10996;

import java.util.*;

public class Main {
//	PrintStar
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int starCnt = 0;
		int totalCnt = 0;
		int index = 0;
		int line = 0;
		// 짝수 라인은 짝수 인덱스, 홀수라인은 홀수 인덱스
		while (true) {
			if (starCnt == n * n)
				break;
			if (totalCnt == n) {
				System.out.println();
				totalCnt = 0;
				index=0;
				line++;
				continue;
			}
			if (line % 2 == 0) {
				if (index % 2 == 0) {
					System.out.print("*");
					starCnt++;
					totalCnt++;
					index++;
				} else {
					System.out.print(" ");
					totalCnt++;
					index++;
				}
			} else {
				if (index % 2 == 1) {
					System.out.print("*");
					starCnt++;
					totalCnt++;
					index++;
				} else {
					System.out.print(" ");
					totalCnt++;
					index++;
				}
			}

		}
	}

}
