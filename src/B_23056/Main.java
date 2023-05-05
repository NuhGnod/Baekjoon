package B_23056;
import java.io.*;
import java.util.*;

import fifth.Pair;
class Pair implements Comparable<Pair> {
	int classN;
	String name;
	int len;

	Pair(int classN, String name, int len) {
		this.classN = classN;
		this.name = name;
		this.len = len;
	}

	@Override
	public int compareTo(Pair o) {
		int res = this.classN - o.classN;
		if (res == 0) {
			res = this.len - o.len;
			if (res == 0)
				res = this.name.compareTo(o.name);
		}
		return res;

	}
}

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

				String in[] = br.readLine().split(" ");
				int N = Integer.parseInt(in[0]);
				int M = Integer.parseInt(in[1]);
				Pair blue[] = new Pair[501];
				Pair white[] = new Pair[501];
				int check[] = new int[N + 1];

				int blue_idx = 0;
				int white_idx = 0;
				for (int i = 0; i < 501; i++) {
					blue[i] = new Pair(100, "as", 100);
					white[i] = new Pair(100, "as", 100);
				}
				ArrayList<Pair> arrBlue = new ArrayList();
				ArrayList<Pair> arrWhite = new ArrayList();
				
				while (true) {
					String s[] = br.readLine().split(" ");
					int classN = Integer.parseInt(s[0]);
					String name = s[1];
					int len = name.length();
					if (classN == 0 && name.equals("0")) {
						break;
					}
					if (classN % 2 == 0) {
						if (check[classN] >= M)
							continue;
						check[classN]++;
						arrWhite.add(new Pair(classN, name, len));
						white_idx++;
						/* white[white_idx++] = new Pair(classN, name, len); */
					} else {
						if (check[classN] >= M)
							continue;
						check[classN]++;
						// odd
						arrBlue.add(new Pair(classN, name, len));
						blue_idx++;
//						blue[blue_idx++] = new Pair(classN, name, len);
					}
				}
				Collections.sort(arrBlue);
				Collections.sort(arrWhite);

//				Arrays.sort(blue, new Comparator<Pair>() {
//					@Override
//					public int compare(Pair o1, Pair o2) {
		//
//						if (o1.classN < o2.classN) {
//							return o1.classN - o2.classN;
//						} else if (o1.classN == o2.classN) {
//							if (o1.name.length() < o2.name.length()) {
//								return o1.name.length() - o2.name.length();
//							} else if (o1.name.length() == o2.name.length()) {
//								return o1.name.compareTo(o2.name);
//							} else {
//								return 1;
//							}
//						} else {
//							return 1;
//						}
		//
//					}
//				});

				for (int i = 0; i < blue_idx; i++) {
					
						System.out.println(arrBlue.get(i).classN + " "+ arrBlue.get(i).name);
				}
				for (int i = 0; i < white_idx; i++) {
					
						System.out.println(arrWhite.get(i).classN + " "+ arrWhite.get(i).name);
				}
				//

	}

}
