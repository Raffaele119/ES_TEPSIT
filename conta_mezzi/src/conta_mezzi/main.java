package conta_mezzi;

import java.util.Scanner;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("inserisci numero di thread");
		int t = scanner.nextInt();
		System.out.println("inserisci numero ");
		int n = scanner.nextInt();
		System.out.println("inserisci delay ");
		int d = scanner.nextInt();
		
		int app = t/2;
		Thread[] thread = new Thread[t];
		
		for(int i = 0; i < app; i++ ) { 
			conta con = new conta(n,d);
			thread[i] = new Thread(con);
			thread[i].setName("Thread UP " + (i));
			thread[i].start();
		}
		
		for(int i = app; i < t; i++ ) { 
			containdietro contind = new containdietro(n,d);
			thread[i] = new Thread(contind);
			thread[i].setName("Thread DOWN " + (i));
			thread[i].start();
		}
		
		


	}
}