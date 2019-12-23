package B_17952;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		LinkedList q = new LinkedList();
		int n = sc.nextInt();

		int a[][] = new int[n][3];

		int total_score = 0;
		int total_flag = 0;
		int flag = 0;
		int score = 0;
		int minute = 0;
		for (int i = 0; i < n; i++) {
			flag = sc.nextInt();
			if (flag == 0) {
				a[i][0] = flag;
				a[i][1] = -1;
				a[i][2] = -1;
				total_flag++;
			} else {
				score = sc.nextInt();
				minute = sc.nextInt();
				a[i][0] = flag;
				a[i][1] = score;
				a[i][2] = minute;
//				a[i][2]--;
//				if (a[i][2] == 0) {
//					total_score = a[i][1];
//					a[i][0] = 2;
//					a[i][1] = -1;
//					a[i][2] = -1;
//				}
			}
//		}
//		for (int i = 0; i < n; i++) {
//			if (total_flag == 0)
//				break;
//			if (a[i][0] == 1) {
//				a[i][2]--;
//				
//			}
//
//		}
		}
		for (int i = 0; i < n; i++) {

			if (a[i][0] == 1) {
				q.add(0,i);
				a[(int) q.peek()][2]--;
			} else {
				if(!q.isEmpty())
				a[(int) q.peek()][2]--;
			}
			if (!q.isEmpty() && a[(int) q.peek()][2] == 0) {
				total_score += a[(int) q.peek()][1];
				q.pop();
			}
		}
		System.out.println(total_score);
	}
}
