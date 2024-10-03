package produttore_consumatore;
import java.util.Scanner;

public class gestore {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci il numero di thread:");
        int t = scanner.nextInt();
        System.out.println("inserisci un numero:");
        int n = scanner.nextInt();
        scanner.close();
        
        // creo il buffer e i thread per produttori e consumatori
        buffer buf = new buffer(n);
        consumatore cons = new consumatore(buf);
        
        Thread consThread = new Thread(cons);
        consThread.start(); // avvio del thread consumatore
        
        Thread[] produttori = new Thread[t];
        
        for (int i = 0; i < t; i++) {
            produttori[i] = new Thread(new produttore(n, buf)); // produttore con il buffer condiviso
            produttori[i].start();
        }
    }
}
