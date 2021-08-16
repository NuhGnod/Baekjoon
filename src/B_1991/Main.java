package B_1991;

import java.io.*;
import java.util.*;

public class Main {
	static String result = "";
	static Map<String, List<String>> tree = new HashMap();
	static int as = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String str[] = br.readLine().split(" ");
			List<String> list = new ArrayList<>();

			list.add(str[1]);
			list.add(str[2]);
			tree.put(str[0], list);

		} // 트리 만들기
		preOrder("A");
		result += "\n";
		inOrder("A");
		result += "\n";
		postOrder("A");
		System.out.print(result);
	}

	// 전위 순회
	static void preOrder(String s) {
		if (s.equals(".")) {
			return;
		}

		result += s;
		preOrder(tree.get(s).get(0));
		preOrder(tree.get(s).get(1));
	}// 중위 순회

	static void inOrder(String s) {
		if (s.equals(".")) {
			return;
		}

		inOrder(tree.get(s).get(0));
		result += s;
		inOrder(tree.get(s).get(1));
	}// 후위 순회

	static void postOrder(String s) {
		if (s.equals(".")) {
			return;
		}

		postOrder(tree.get(s).get(0));
		postOrder(tree.get(s).get(1));
		result += s;
	}

}
