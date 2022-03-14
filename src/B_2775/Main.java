package B_2775;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			
			int hotel[][] = new int[k+1][n+1];
			for(int j=0; j<=k;j++) {
				for(int q = 1; q<=n; q++) {
					if(j == 0) {
						hotel[0][q] = q;
					}
					if(q==0) {
						hotel[j][0] = 1;
					}else if(j!=0 && q!=0){
						hotel[j][q] = hotel[j-1][q] + hotel[j][q-1];
					}
					
					
				}
			}
			System.out.println(hotel[k][n]);
			
		}
	}

}
