package B_17173;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int mul[] = new int[M];
		int count[][] = new int[2][N+1];
		int ans = 0;

		for (int i = 0; i < M; i++) {
			mul[i] = sc.nextInt();
		}
		for (int i = 0; i < M; i++) {
			for (int j = 1; j * mul[i] <= N; j++) {
				if (count[1][j * mul[i]] == 0) {

					count[0][j * mul[i]] += j * mul[i];
					count[1][j * mul[i]] = 1;
				}

			}
		}
		for (int i = 0; i < N+1; i++) {
			if (count[1][i] == 1) {
				ans += count[0][i];
			}
		}
		System.out.println(ans);

	}

}
