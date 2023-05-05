package B_1931;
import java.util.*;

public class Main {
	static class Pair<Start, End>{
		private Start start;
		private End end;
		
		public void Pair(Start start, End end) {
			this.end = end;
			this.start = start;
		}
		public void setStart(Start start) {
			this.start = start;
		}
		public void setEnd(End end) {
			this.end = end;
		}
		public Start getStart() {
			return start;
		}
		public End getEnd() {
			return end;
		}
		public void print() {
			System.out.println(start + " " + end);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int ans = 0;

		List<Pair<Integer, Integer>> arr = new ArrayList();
		for (int i = 0; i < N; i++) {

			Pair<Integer, Integer> p = new Pair();
			p.setStart(sc.nextInt());
			p.setEnd(sc.nextInt());
			arr.add(p);

		}
		arr.sort(new Comparator<Pair<Integer, Integer>>() {// 끝나는 작은 순서대로, 같다면 시작하는 시간이 작은 순서대로 정렬

			@Override
			public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
				// TODO Auto-generated method stub
				if (o1.getEnd().equals(o2.getEnd())) {
					return o1.getStart() - o2.getStart();
				} else
					return o1.getEnd() - o2.getEnd();
			}

		});

//		for (int i = 0; i < N; i++) {
//
//			arr.get(i).print();
//
//		}
		int end = 0;
		for (int i = 0; i < N; i++) {
			if (end <= arr.get(i).getStart()) {
				end = arr.get(i).getEnd();
				ans++;
			}

		}
		System.out.println(ans);

	}

}
