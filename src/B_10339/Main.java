package B_10339;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int score=0;
		for(int i=0; i<5; i++) {
			int temp = sc.nextInt();
			if(temp < 40) {
				score+=40;
			}else {
				score+=temp;
			}
		}
	System.out.println(score/5);
		
		
	}

}
