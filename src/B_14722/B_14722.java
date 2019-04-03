package B_14722;

import java.util.Scanner;
import java.util.*;

class milk {
	Stack<Object> st = new Stack<Object>(); // i
	Stack<Object> st2 = new Stack<Object>(); // j
	queue<int> qu;
	
			
	Scanner sc = new Scanner(System.in);
	int milk[][];

	int n = 0;
	int i = 0;
	int j = 0;
	int num[];
	int num2[];

	public milk(int n) {
		this.n = n;
		milk = new int[this.n + 1][this.n + 1];
		num = new int[n];
		num2 = new int[n];

	}

	public void milk(int i, int j, int put) {
		this.i = i;
		this.j = j;

		milk[i][j] = put;
	}

	public void find() {
		while (true) {
			if (milk[i][j] == 0) {
				st.push(i);
				st2.push(j);
				j++;
			}
			else if (milk[i][j] == 1) {
				st.push(i);
				st2.push(j);
				j++;
				
			}
			else if (milk[i][j] == 2) {
				st.push(i);
				st2.push(j);
				j++;
				
			}

		}
	}
}

class dfs {

}

class dp {

}

public class B_14722 { // dfs
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		milk milk = new milk(N);
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				milk.milk(i, j, sc.nextInt());

			}
		}
		int block = 0; // 0--1--2 가 나오면 블럭
		int start = 0;
		int end = 0;

		int check = 0; // 먹는 순서
		int drink = 0; // 총 먹은 우유개수
		int pass = 0; // 0 : 먹음 1 : 안먹음
		int st = 0; // 딸기
		int ch = 0; // 초코
		int ba = 0; // 바나나
		int a = 1; // 가로
		int b = 1; // 세로

		drink = st + ch + ba;
		System.out.println(drink);

	}
}
