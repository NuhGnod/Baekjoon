package B_2108;

import java.util.*;
import java.math.*;
import javafx.scene.shape.Arc;

public class Main {
	static int range(int max, int min) {
		return max - min;
	}

	static double average(ArrayList Arr) {
		int sum = 0;
		for (int i = 0; i < Arr.size(); i++) {
			sum += (int) Arr.get(i);
		}
		double result = Math.round((double) sum / Arr.size());
		int rr = (int) result;
		System.out.println(rr);
		return rr;
	}

	static int median(ArrayList Arr) {

		return (int) Arr.get(Arr.size() / 2);
	}

	static int highest(ArrayList Narr, ArrayList Parr) {// 실제 원소 값 저장 배열
		int tempNarr[] = new int[4001]; // 각 원소의 중복 횟수 저장 배열 -4000 ~ -1 =4000개
		int tempParr[] = new int[4001]; // 0 ~ 4000 = 4001개
		int high[] = new int[8002]; // -4000 ~ 4000 = 8001개
		int in = 0;
		for (int i = 0; i < Narr.size(); i++) {
			int temp = -((int) Narr.get(i));// 인덱스 == 원소의 절댓값
			tempNarr[temp]++;// 중복 횟수 저장
		}
		for (int i = 0; i < Parr.size(); i++) {
			int temp = (int) Parr.get(i);
			tempParr[temp]++;
		}
		for (int i = 0; i < 4000; i++) {// 4000개 , Narr
			high[i] = tempNarr[4000- i];
		}
		for (int i = 0; i <= 4000; i++) {
			high[i + 4000] = tempParr[i];
		}

		int ans = 0;
		int max = 0;
		int max_cnt = 0;
		for (int i = 0; i < 8002; i++) {
			if (high[i] >= max && high[i] != 0) {
				max = high[i];
			}
		}
		for (int i = 0; i < 8002; i++) {
			if (high[i] == max) {
				max_cnt++;
				ans = i;

			}
			if (max_cnt == 2) {
				break;
			}
		}
		if (ans >= 4000) {
			ans = ans - 4000;
		} else {
			ans = -(4000 - ans);
		}
		return ans;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList nArr = new ArrayList();
		ArrayList pArr = new ArrayList();
		ArrayList Arr = new ArrayList();
		int max = -500000;
		int min = 500000;
		for (int i = 0; i < N; i++) {
			int temp = sc.nextInt();
			if (temp < 0) {// Negative
				nArr.add(temp);
			} else {
				pArr.add(temp);
			}
			if (temp > max)
				max = temp;
			if (temp < min)
				min = temp;

		}
		Collections.sort((nArr));
		Collections.sort(pArr);
		for (int i = 0; i < nArr.size(); i++) {
			Arr.add(nArr.get(i));
		}
		for (int i = 0; i < pArr.size(); i++) {
			Arr.add(pArr.get(i));
		}
		average(Arr);
		int range = range(max, min);
		System.out.println(median(Arr));
		System.out.println(highest(nArr, pArr));
		System.out.println(range);

	}

}
