package B_10090;

import java.util.*;

import java.io.*;

public class Main {
	static int[] arr, temp;
    static long answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
         
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1]; 
        temp = new int[N+1];
         
        st = new StringTokenizer(br.readLine());;
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
         
        mergeSort(1, N);
         
        System.out.println(answer);

	}

	public static void mergeSort(int left,int right) { 
        if(left >= right) return;  
         
        int mid = (left + right) / 2;
        mergeSort(left, mid);
        mergeSort(mid + 1, right);
        merge(left, mid, right);    
    }
     
    public static void merge(int left, int mid, int right) {
        int x = left; 
        int y = mid + 1;    
        int k = left;    
         
        while(x <= mid || y <= right) {    
            if (y > right || (x <= mid && arr[x] < arr[y])) {
                temp[k] = arr[x++];
            }
            else {
                answer += (mid - x + 1);
                temp[k] = arr[y++];
            }
            k++;
        }
         
        for(int i=left; i<=right; i++) {
            arr[i] = temp[i];
        }
    }

}
