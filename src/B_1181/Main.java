package B_1181;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<String> arr = new ArrayList();
		for (int i = 0; i < N; i++) {
			arr.add(sc.next());
		}
		Collections.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				return Integer.compare(o1.length(), o2.length());
			}

		});
		for (int i = 0; i < arr.size()-1; i++) {
			if (arr.get(i).equals(arr.get(i + 1))) {
				arr.remove(i + 1);
				i--;
			}
		}
		for (int i = 0; i < arr.size(); i++) {
				
			System.out.println(arr.get(i));
		}
	}

}
