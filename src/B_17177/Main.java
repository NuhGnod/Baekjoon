package B_17177;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		int box[] = new int[3];
		box[0] = a;
		box[1] = b;
		box[2] = c;
		int is = 0;

		Arrays.sort(box);
		int l = box[2]; // 지름
		int cr1 = (l * l - box[0] * box[0]);

		int num = 0;

		for (int i = 1; i <= l; i++) {
			int cr2 = (l * l - i * i);

			if (((l * box[1]) + (box[0] * i)) * ((l * box[1]) + (box[0] * i)) == cr1 * cr2) {
				num = i;
			}
		}
		if (num == 0) {
			System.out.println(-1);
		} else {
			System.out.println(num);
		}
		// 0 ,1, 2 경우

	}

}
