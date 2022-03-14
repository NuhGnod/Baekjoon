package B_1003;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			int temp = sc.nextInt();
			int n[] = new int[temp+1];
			if(temp == 0) System.out.println(1 + " " + 0);
			else if(temp == 1)System.out.println(0 + " " + 1);
			else {
				n[0] = 1;
				n[1] = 1;
				for(int j=2; j<=temp; j++) {

					n[j] = n[j-1]+ n[j-2];
						
				}
				System.out.println(n[temp-2] + " " + n[temp-1]);
			}
		}
	}

}
