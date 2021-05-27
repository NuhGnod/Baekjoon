package B_1655;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (minHeap.size() == maxHeap.size()) {
				maxHeap.add(num);

			} else {
				minHeap.add(num);
			}
			if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
				if (maxHeap.peek() > minHeap.peek()) {
					int temp = maxHeap.poll();
					maxHeap.add(minHeap.poll());
					minHeap.add(temp);
				}
			}
			bw.write(maxHeap.peek() + "\n");
		}
		br.close();
		bw.close();
	}

}
