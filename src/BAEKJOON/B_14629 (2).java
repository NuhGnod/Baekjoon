package Baekjoon;

import java.util.*;
import java.math.*;

class fuck {
	String line = "";
	String ans = "";
	int dup = 0;
	int n[] = new int[12];
	int temp[] = new int[12];

	public fuck(String s) {
		this.line = s;
		for (int i = 0; i < 10; i++) {
			temp[i] = i;

		}
		for (int i = 0; i < line.length(); i++) {
			n[i] = line.charAt(i);

		}
	}

	public void ansa() {

		for (int i = 0; i < line.length(); i++) {
			if (i - dup > 0) {
				ans += temp[i - dup+1];
			} else if(i-dup==0){ 
				ans+="0";
				
				
			}
			else {
				ans+=temp[10-(i-dup)];
			}

		}
	}

	public void time(int dup) {
		this.dup = dup;

	}

	public void answer() {
		System.out.println(ans);
	}
}

public class B_14629 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		fuck f = new fuck(line);
		int q = 0;
		if (line.length() > 10) {
			System.out.println("9876543210");

		} else {
			for (int i = 0; i < line.length(); i++) {
				for (int j = 0; j <i; j++) {
					if (line.charAt(i) == line.charAt(j)) {
						q++;
					}

				}
				f.ansa();

			}
			f.answer();

		}

	}
}