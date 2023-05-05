package B_1222;

import java.util.*;

public class Main {
	static long[] primeArr = new long[2000000];
	static int[] arr = new int[2000000];

	public static void getPrime(ArrayList<Integer> prime, int num) {
		prime.add(2);
		for (int i = 2; i <= num; i++) {
			for (int j = 0; j < prime.size(); j++) {
				if (i % prime.get(j) == 0) {
					break;
				}
				if (j + 1 == prime.size()) {
					prime.add(i);
				}
			}
		}
		for (int i = 0; i < prime.size(); i++) {
			primeArr[i] = prime.get(i);
//			System.out.println(primeArr[i]);
		}
//		System.out.println("소수 개수 : " + cnt);
	}

	public static void getaliquot(int n) {
		int num = n;
		int temp = 0;
		for (int i = 0; i < n; i++) {
			if (num % primeArr[i] == 0) {
//				System.out.println(primeArr[i]);
				arr[(int) primeArr[i]]++;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		
		ArrayList<Integer> prime = new ArrayList<Integer>();
		
		int N = sc.nextInt();
		getPrime(prime, (int) Math.sqrt(2000000));

		for (int i = 0; i < N; i++) {
			getaliquot(sc.nextInt());
		}
		int max = 0;

		for (int i = 0; i < arr.length; i++) {
			if(max <= arr[i] * i) {
				if(arr[i] != 1) {
					max = arr[i] * i;
				}
			}
			
		}
		System.out.println(max);
	}
}
