package B_1927;

import java.io.*;
import java.util.*;


public class Main {
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		MinHeap h = new MinHeap(N);
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num > 0) {
				h.insert(num);
			} else {
//				h.remove();
				sb.append(String.valueOf(h.remove()) + "\n");
//				bw.write(String.valueOf(h.remove()) + "\n");
			}
		}
		bw.write(sb.toString());
//		for (int i = 1; i < h.size(); i++) {
//			bw.write(String.valueOf(h.print(i)) + " ");
//		}
		br.close();
		bw.close();
	}

	public static class MinHeap {
		int size = 1;
		int[] heap;

		public MinHeap(int N) {
			heap = new int[N + 1];
			heap[0] = 0;
		}

	
		public void insert(int num) {

			heap[size++] = num;
			int cur = size - 1;// 실제 원소 갯수들 <- 0번 인덱스에 0을 넣어주었기 때문.
			while (cur > 1 && heap[cur] < heap[cur / 2]) {

				// 현재 노드와 부모 노드 교체.
				int temp = heap[cur];
				heap[cur] = heap[cur / 2];
				heap[cur / 2] = temp;

				cur = cur / 2;

			}
		}


		public int remove() {
			if (size == 1) {
				return 0;
			}
			int removeNum = heap[1];
			heap[1] = heap[size - 1];
			heap[size - 1] = 0;
			size--;

			int cur = 1;
			while (cur * 2 <= size - 1) {
				if (cur * 2 == size - 1) {
					if (heap[cur] > heap[cur * 2]) {
						int temp = heap[cur];
						heap[cur] = heap[cur * 2];
						heap[cur * 2] = temp;

						cur = cur * 2;
					}else {
						break;
					}
				} else {

					int minIndex = heap[cur * 2] < heap[cur * 2 + 1] ? cur * 2 : cur * 2 + 1;
					int min = heap[minIndex];

					if (min > heap[cur]) {
						break;
					} else {
						int temp = heap[cur];
						heap[minIndex] = temp;
						heap[cur] = min;

						cur = minIndex;
					}

				}
			}

			return removeNum;
		}

	}

}
