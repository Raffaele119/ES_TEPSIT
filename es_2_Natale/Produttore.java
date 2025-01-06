package ProduttoreConsumatore;
import java.util.Random;

public class Produttore implements Runnable{
	 private Buffer buffer;
     private Random random = new Random();

     public Produttore(Buffer buffer) {
         this.buffer = buffer;
     }

     @Override
     public void run() {
         try {
             while (true) {
                 int numero = random.nextInt(10) + 1;  //genera un numero da 1 a 10 compresi
                 buffer.inserisci(numero);
                 Thread.sleep(random.nextInt(1000));
             }
         } catch (InterruptedException e) {
             Thread.currentThread().interrupt();
         }
     }
 }
