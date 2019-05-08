package B_17176;
import java.math.*;
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		// int N = sc.nextInt();
		// 65 ~ 90 A ~ Z
		char a[] = new char[53];

		a[0] = ' ';
		a[1] = 65;
		a[2] = 66;
		a[3] = 67;
		a[4] = 68;
		a[5] = 69;
		a[6] = 70;
		a[7] = 71;
		a[8] = 72;
		a[9] = 73;
		a[10] = 74;
		a[11] = 75;
		a[12] = 76;
		a[13] = 77;
		a[14] = 78;
		a[15] = 79;
		a[16] = 80;
		a[17] = 81;
		a[18] = 82;
		a[19] = 83;
		a[20] = 84;
		a[21] = 85;
		a[22] = 86;
		a[23] = 87;
		a[24] = 88;
		a[25] = 89;
		a[26] = 90;

		a[27] = 97;
		a[28] = 98;
		a[29] = 99;
		a[30] = 100;
		a[31] = 101;
		a[32] = 102;
		a[33] = 103;
		a[34] = 104;
		a[35] = 105;
		a[36] = 106;
		a[37] = 107;
		a[38] = 108;
		a[39] = 109;
		a[40] = 110;
		a[41] = 111;
		a[42] = 112;
		a[43] = 113;
		a[44] = 114;
		a[45] = 115;
		a[46] = 116;
		a[47] = 117;
		a[48] = 118;
		a[49] = 119;
		a[50] = 120;
		a[51] = 121;
		a[52] = 122;

		int n = sc.nextInt();
		int num[] = new int[n];

		for (int i = 0; i < n; i++) {
			int temp = sc.nextInt();
			num[i] = temp;
		}
		String line2 = sc.nextLine();
		String line = sc.nextLine();
		int num2[] = new int[n];
		int check = 0;
		for (int i = 0; i < n; i++) {
			num2[i] = line.charAt(i);
		}
		
		Arrays.sort(num);
		Arrays.sort(num2);
		for (int i = 0; i < n; i++) {
			if (a[num[i]] == num2[i])
				check++;
		}
		
		

		if (check == n) {
			System.out.println("y");
		} else {
			System.out.println("n");
		}

	}
}
