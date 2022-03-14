package B_23055;

import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

				int N = Integer.parseInt(br.readLine());

				Character arr[][] = new Character[N][N];
				int l = 0;
				int r = N-1;
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						arr[i][j]=' ';
					}
					
				}
				for (int i = 0; i < N; i++) {
					if (i == 0 || i == N - 1) {
						for (int j = 0; j < N; j++) {
							arr[i][j] = '*';
						}
						continue;
					}
					
					arr[i][0] = '*';
					arr[i][N - 1] = '*';
					l++;
					r--;
					arr[i][l] = '*';
					arr[i][r] = '*';

				}
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						System.out.print(arr[i][j]);
					}
					System.out.println();
				}

	}

}
