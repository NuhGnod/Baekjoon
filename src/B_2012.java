import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_2012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N+1];
        for (int i = 1; i <= N; i++) {
            int grade = Integer.parseInt(br.readLine());
            arr[i] = grade;
        }
        Arrays.sort(arr);
        long angry = 0;
        for (int i = 1; i <= N; i++) {
            angry += Math.abs(i - arr[i]);
        }
        System.out.println(angry);

    }
}
