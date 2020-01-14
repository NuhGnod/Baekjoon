package B_10828;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int x = 0;
		String temp[] = new String[T + 1];
		int ans[] = new int[T + 1];
		int size = 0;
		for (int i = 0; i < T + 1; i++) {
			String line = sc.nextLine();
			temp[i] = line;
		}
		for (int i = 1; i < T + 1; i++) {
			if (temp[i].charAt(1) == 'u') {// push

				int a = Integer.parseInt(temp[i].substring(5, temp[i].length()));
				for (int j = 1; j < T + 1; j++) {
					if (ans[j] == 0) {

						ans[j] = a;

						size++;
						break;

					}
				}
				

			} else if (temp[i].charAt(0) == 't') {// top
				for (int j = 0; j < T; j++) {
					if (ans[j + 1] == 0) {
						if(size == 0) System.out.println(-1);
						else
						System.out.println(ans[j]);
						break;
					}
				}

			} else if (temp[i].charAt(0) == 's') {
				System.out.println(size);
			} else if (temp[i].charAt(0) == 'e') {
				if (size == 0)
					System.out.println(1);
				else
					System.out.println(0);
			} else if (temp[i].charAt(1) == 'o') {
				if (size == 0)
					System.out.println(-1);
				else {
					System.out.println(ans[size]);
					ans[size] = 0;
					size--;
				}
			}
		}
	}
}
