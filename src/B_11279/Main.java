package B_11279;

import java.util.ArrayList;
import java.io.*;
import java.util.*;
//public class Main {
//    public static int [] heap = new int[100001];
//    public static int size = 0;
//    public static StringBuilder sb = new StringBuilder();
// 
//    public static void swap(int x, int y) {
//        int temp = heap[x];
//        heap[x] = heap[y];
//        heap[y] = temp;
//    }
//    public static void push(int x) {
//        heap[++size] = x;
//        //삽입한 것 부터 힙인지 확인, 힙이아니면 계속 부모노드로 올라가고 힙이면 break
//        for(int i=size; i>1; i/=2) {
//            if(heap[i/2] < heap[i]) {
//                swap(i/2, i);
//            } else {
//                break;
//            }
//        }
//    }
// 
//    public static void pop() {
//        sb.append(heap[1]+"\n");
//        heap[1] = heap[size];
//        heap[size--] = 0;
//        for(int i=1; i*2<=size;) { //삭제 후 1에서 부터 힙으로 만들어주는 과정
//            if(heap[i] > heap[i*2] && heap[i] > heap[i*2+1]) {
//                break;
//            }else if(heap[i*2] > heap[i*2+1]) {
//                swap(i, i*2);
//                i = i*2;
//            } else {
//                swap(i, i*2+1);
//                i = i*2+1;
//            }
//        }
//    }
//    public static void main(String[] args) throws IOException{
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(reader.readLine());
//        for(int i=0; i<n; i++) {
//            int k = Integer.parseInt(reader.readLine());
//            if(k==0) {
//                if(size == 0) {
//                    sb.append(0+"\n");
//                } else {
//                    pop();
//                }
//            } else {
//                push(k);
//            }
//        }
//        System.out.print(sb.toString());
//    }
//}

public class Main {
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		MaxHeap h = new MaxHeap(N);
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

	public static class MaxHeap {
		int size = 1;
		int[] heap;

		public MaxHeap(int N) {
			heap = new int[N + 1];
			heap[0] = 0;
		}

	
		public void insert(int num) {

			heap[size++] = num;
			int cur = size - 1;// 실제 원소 갯수들 <- 0번 인덱스에 0을 넣어주었기 때문.
			while (cur > 1 && heap[cur] > heap[cur / 2]) {

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
					if (heap[cur] < heap[cur * 2]) {
						int temp = heap[cur];
						heap[cur] = heap[cur * 2];
						heap[cur * 2] = temp;

						cur = cur * 2;
					}else {
						break;
					}
				} else {

					int maxIndex = heap[cur * 2] > heap[cur * 2 + 1] ? cur * 2 : cur * 2 + 1;
					int max = heap[maxIndex];

					if (max < heap[cur]) {
						break;
					} else {
						int temp = heap[cur];
						heap[maxIndex] = temp;
						heap[cur] = max;

						cur = maxIndex;
					}

				}
			}

			return removeNum;
		}

	}

}
