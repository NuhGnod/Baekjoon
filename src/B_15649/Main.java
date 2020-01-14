	package B_15649;
	
	import java.util.*;
	
	public class Main {
		static int M;
		static int N;
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
	
			N = sc.nextInt();
			M = sc.nextInt();
			int arr[] = new int[M];
			boolean check[] = new boolean[N];
	
			back(check, arr, 0);
	
		}
	
		static void back(boolean[] check, int[] arr, int k) {
			if (k == M) {
				for (int i = 0; i < M; i++) {
					System.out.print(arr[i] + " ");
				}
				System.out.println();
				return;
			}
	
			for (int i = 0; i < N; i++) {
				if (!check[i]) {
					arr[k] = i + 1;
					check[i] = true;
					back(check, arr, k + 1);
					check[i] = false;
				}
			}
	
		}
	
	}
