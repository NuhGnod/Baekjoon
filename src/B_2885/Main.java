package B_2885;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        // 1 << 2 == 2^2 , 1 << 3 == 2^3
        int n = 1;
        int divide = 0;
        int min = 0;

        for (int i = 0; i <= 31; i++) {
            if (n >= K) {
                break;
            }
            n = n << 1;
        }
        min = n;
        if (n == K) {
            divide = 0;
        } else {
            while (true) {
                if( K == 0) break;
                if( K - (n/2) < 0){
                    while(K - (n/2) < 0) {
                        n = n >> 1;
                        divide++;
                    }
                }
                K -= ( n >> 1);
                n >>= 1;
                divide ++ ;
            }
        }
        System.out.println(min + " " + divide);
    }

}
