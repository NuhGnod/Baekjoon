package B_11651;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	static class Pair<L,R>{
		private L l;
		private R r;
		public Pair(L l, R r) {
			this.l = l;
			this.r = r;
		}
		public L getL() {
			return l;
		}
		public void setL(L l) {
			this.l = l;
		}
		public R getR() {
			return r;
		}
		public void setR(R r) {
			this.r = r;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		List<Pair<Integer,Integer>> a = new ArrayList<Pair<Integer, Integer>>();
		for(int i=0; i<n; i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			Pair<Integer, Integer> p = new Pair<Integer, Integer>(x, y);
			a.add(p);
		}
		a.sort(new Comparator<Pair<Integer, Integer>>() {
			@Override
			public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
				if (o1.getR() < o2.getR()) {
	                return -1;
	            } else if (o1.getR().equals(o2.getR())) {
	                return o1.getL()-o2.getL();
	            } else {
	                return 1;
	            }
			}
		});
			
		for(Pair<Integer, Integer> tmp : a){
			System.out.println(tmp.getL()+" "+tmp.getR());
		}
		
	}
}
