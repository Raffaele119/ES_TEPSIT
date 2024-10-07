package conta_thread;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("inserisci numero thread");

		int t = scanner.nextInt();
		System.out.println("inserisci un numero");
		int n = scanner.nextInt();
		scanner.close();
				
        // Creazione array di thread
		Thread[] thread = new Thread[t];
		//conta con = new conta(n); se metto la creazione dell'instanza della classe conta all'esterno di un for creerò una instanza condivisa con ogni thread 
		
		for(int i = 0 ; i < thread.length ; i++) {
			conta con = new conta(n);//se metto la creazione dell'instanza della classe conta all'interno di un for creerò per ogni thread una nuova instanza quindi sarà indipendente
			thread[i] = new Thread(con);
            thread[i].start(); 

		}
	}

}
