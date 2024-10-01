package stato_thread;
import java.util.Scanner;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("inserisci T:");
		int t = scanner.nextInt();
		
		System.out.println("inserisci N:");
		int n = scanner.nextInt();
		scanner.close();
		
		conserva[] num = new conserva[t];
		Thread[] a = new Thread[t];
		

		
		for(int i = 0; i < t; i++) {
			num[i] = new conserva(new numeri(n));
			a[i] = new Thread(num[i]);
			a[i].start();
		}
		mainthread b = new mainthread(num , a);
		b.run();
		
	}

}
