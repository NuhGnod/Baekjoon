package B_10989;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.valueOf(br.readLine());
		int arr[] = new int[10000];
		for (int i = 0; i < N; i++) {
			int num = 0;
			num = Integer.valueOf(br.readLine());
			arr[num - 1]++;

		}
		for (int i = 0; i < 10000; i++) {
			for (int j = 0; j < arr[i]; j++) {
				String I = String.valueOf(i+1);
				bw.write(I + "\n");
			}
		}
		br.close();
		bw.close();

	}

}
