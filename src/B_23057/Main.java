package B_23057;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long sum = 0;
		int[] arr = new int[N];
		String in[] = br.readLine().split(" ");
		LinkedList<Integer> list = new LinkedList();
		Set<Integer> s = new HashSet();
		s.add(0);

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(in[i]);
			sum += arr[i];
			for (int x : s) {
				
				list.add(x + arr[i]);
//				System.out.println(x);

			}
			for (int x : list) {
				s.add(x);

			}

		}
//		for (int x : s) {
//			System.out.println(x);
//		}
		
		System.out.println(sum + 1 - s.size());

	}

}
