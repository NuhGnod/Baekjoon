package B_22353;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		double a, d, k;
		double ans = 0;
		int t = 0;
		String in[] = br.readLine().split(" ");
		a = Double.parseDouble(in[0]);// 판 당 시간
		d = Double.parseDouble(in[1]);// 승리 확률
		k = Double.parseDouble(in[2]);// 승리 확률 가중치
		ans = solve(a,d,k);
		System.out.printf("%.7f",ans);
	}

	static public double solve(double a, double d, double k) {
		if (d >= 100) {
			return a;
		}
		double res = d * 0.01 * a + (100 - d) * 0.01 * (a + solve(a, (d + d * 0.01 * k), k));
		return res;
	}
}
