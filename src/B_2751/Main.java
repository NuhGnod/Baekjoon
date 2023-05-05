package B_2751;

import java.io.*;
import java.util.*;;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		
		ArrayList<Integer> arr = new ArrayList();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(arr);
		for (int i = 0; i < N; i++) {
			bw.write(String.valueOf(arr.get(i)) + "\n");
			bw.flush();
		}
	}

}
