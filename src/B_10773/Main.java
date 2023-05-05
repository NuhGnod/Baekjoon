package B_10773;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int K = sc.nextInt();
		Stack<Integer> st = new Stack();

		for (int i = 0; i < K; i++) {
			int temp = sc.nextInt();

			if (temp == 0) {
				st.pop();
			} else {
				st.add(temp);
			}
		}
		int ans=0;
		for (Iterator<Integer> i = st.iterator(); i.hasNext(); ) {
			ans+=i.next();
		}
		System.out.println(ans);
	}

}
