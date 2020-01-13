package B_10814;

import java.io.*;
import java.util.*;

public class Main {
	static class Pair<Age, Name, Integer> {
		private Age age;
		private Name name;
		private int index;

		public void Pair(Age age, Name name, int Index) {
			this.age = age;
			this.name = name;
			this.index = index;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int Index) {
			this.index = Index;
		}

		public Age getAge() {
			return age;
		}

		public Name getName() {
			return name;
		}

		public void setAge(Age age) {
			this.age = age;
		}

		public void setName(Name name) {
			this.name = name;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Pair<Integer, String, Integer>> a = new ArrayList<Pair<Integer, String, Integer>>();
		int N = Integer.valueOf(br.readLine());

		for (int i = 0; i < N; i++) {
			String temp[] = br.readLine().split(" ");

			int age = Integer.valueOf(temp[0]);
			String name = temp[1];

			Pair<Integer, String, Integer> p = new Pair<Integer, String, Integer>();
			p.setAge(age);
			p.setName(name);
			p.setIndex(i);
			a.add(p);

		}
		a.sort(new Comparator<Pair<Integer, String, Integer>>() {

			@Override
			public int compare(Pair<Integer, String, Integer> o1, Pair<Integer, String, Integer> o2) {
				// TODO Auto-generated method stubif (o1.getAge() > o2.getAge())
				if(o1.getAge() > o2.getAge())return 1;
				else if(o1.getAge().equals(o2.getAge()))return o1.getIndex() - o2.getIndex();
				else return -1;
			}

		});
		for (Pair<Integer, String, Integer> i : a) {
			bw.write(String.valueOf(i.getAge()) + " " + i.getName() + "\n");
		}
		br.close();
		bw.close();
	}

}
