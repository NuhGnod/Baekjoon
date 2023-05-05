package B_11286;

import java.util.*;
import java.io.*;

public class Main {

	public static void swap(int a, int b, int[] pq) {
		int temp = pq[a];
		pq[a] = pq[b];
		pq[b] = temp;

	}

	public static void add(int x, int[] pq) {

		pq[++size] = x;
		for (int cur = size; cur > 1; cur /= 2) {

			if (Math.abs(pq[cur / 2]) > Math.abs(pq[cur])) {
				swap(cur / 2, cur, pq);
			} else if (Math.abs(pq[cur / 2]) == Math.abs(pq[cur])) {
				if (pq[cur] < pq[cur / 2]) {
					swap(cur, cur / 2, pq);
				}
			} else
				break;
		}
	}

	public static int remove(int x, int[] pq) {
		if (size == 0) {
			return 0;
		}
		int targetNum = pq[1];
		pq[1] = pq[size];
		pq[size--] = 0;

		for (int cur = 1; cur * 2 <= size;) {
			if (cur * 2 == size) {// 자식노드가 왼쪽밖에 없을때
				if (Math.abs(pq[cur]) > Math.abs(pq[cur * 2])) {// 부모 보다 왼쪽의 절대값이 더 작은 경우
					swap(cur, cur * 2, pq);// 스왑
					cur *= 2;// 현재 노드 이동
				} else if (Math.abs(pq[cur]) == Math.abs(pq[cur * 2])) {// 절대값 같은 경우
					if (pq[cur] > pq[cur * 2]) {// 왼쪽 값이 더 작은 경우에만
						swap(cur, cur * 2, pq);// 스왑
						cur *= 2;// 현재 노드 이동
					} else {// 부모 노드 값이 더 작은 경우엔 교체 x, 끝난경우.
						break;
					}

				} else {// 부모의 절대값이 더 작은경우엔 교체 필요 x 끝난 경우.
					break;
				}
			} else {// 자식 노드가 2개일때,
				if (Math.abs(pq[cur * 2]) < Math.abs(pq[cur * 2 + 1])) {// 자식 노드중 왼쪽 노드 절댓값이 더 작은경우
					if (Math.abs(pq[cur]) > Math.abs(pq[cur * 2])) {// 부모 보다 왼쪽 노드가 절대값이 작은경우
						swap(cur, cur * 2, pq);// 스왑
						cur *= 2;
					} else if (Math.abs(pq[cur]) == Math.abs(pq[cur * 2])) {// 부모 와 왼쪽의 절대값이 같은 경우
						if (pq[cur] > pq[cur * 2]) {// 부모보다 왼쪽이 더 작은 경우
							swap(cur, cur * 2, pq);// 교체
							cur *= 2;

						} else {// 부모 노드값이 더 작은경우엔 교체x 끝난경우.
							break;
						}
					} else {// 부모노드의 절대값이 더 작은 경우, 교체 x 끝난 경우.
						break;
					}
				} else if (Math.abs(pq[cur * 2]) == Math.abs(pq[cur * 2 + 1])) {// 자식 노드간의 절댓갑이 같은 경우
					if (pq[cur * 2] < pq[cur * 2 + 1]) {// 왼쪽이 오른쪽보다 절대값은 같지만 값이 작을 때,
						if (Math.abs(pq[cur]) > Math.abs(pq[cur * 2])) {// 절대값이 왼쪽이 부몯보다 작을때
							swap(cur, cur * 2, pq);// 스왑
							cur*=2;

						} else if (Math.abs(pq[cur]) == Math.abs(pq[cur * 2])) {
							if (pq[cur] > pq[cur * 2]) {// 부모보다 왼쪽이 더 작은 경우
								swap(cur, cur * 2, pq);// 교체
								cur*=2;

							} else {// 부모 노드값이 더 작은경우엔 교체x 끝난경우.
								break;
							}
						} else {// 부모의 절대값이 더 작을때엔 교체x , 끝난경우
							break;
						}
					} else {// 오른쪽 노드가 왼쪽보다 값이 절대값은 같지만 값이 작을 떄
						if (Math.abs(pq[cur]) > Math.abs(pq[cur * 2 + 1])) {// 절대값이 왼쪽이 부몯보다 작을때
							swap(cur, cur * 2 + 1, pq);// 스왑
							cur =cur*2+1;

						} else if (Math.abs(pq[cur]) == Math.abs(pq[cur * 2 + 1])) {
							if (pq[cur] > pq[cur * 2 + 1]) {// 부모보다 왼쪽이 더 작은 경우
								swap(cur, cur * 2 + 1, pq);// 교체
								cur =cur*2+1;
							} else {// 부모 노드값이 더 작은경우엔 교체x 끝난경우.
								break;
							}
						} else {// 부모의 절대값이 더 작을때엔 교체x , 끝난경우
							break;
						}

					}
				} else {// 자식 노드중 오른쪽 절댒값이 더 작은경우
					if (Math.abs(pq[cur]) > Math.abs(pq[cur * 2 + 1])) {// 부모 보다 왼쪽 노드가 절대값이 작은경우
						swap(cur, cur * 2 + 1, pq);// 스왑
						cur =cur*2+1;
					} else if (Math.abs(pq[cur]) == Math.abs(pq[cur * 2 + 1])) {// 부모 와 왼쪽의 절대값이 같은 경우
						if (pq[cur] > pq[cur * 2 + 1]) {// 부모보다 왼쪽이 더 작은 경우
							swap(cur, cur * 2 + 1, pq);// 교체
							cur =cur*2+1;
						} else {// 부모 노드값이 더 작은경우엔 교체x 끝난경우.
							break;
						}
					} else {// 부모노드의 절대값이 더 작은 경우, 교체 x 끝난 경우.
						break;
					}
				}
			}
		}

		return targetNum;
	}

	static int size = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] pq = new int[100001];
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x != 0) {
				add(x, pq);
			} else {
				System.out.println(remove(x, pq));
			}
		}
//		for (int i = 1; i <= N; i++) {
//			System.out.print(pq[i] + " ");
//		}
	}

}
