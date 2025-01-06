package ProduttoreConsumatore;

public class Buffer {
    private boolean isFull = false; //variabile per indicare se il buffer è pieno
    private int valore;     

    public synchronized void inserisci(int numero) {
        try {
            while (isFull) {  //aspetta finché il buffer è pieno
                wait();
            }
            valore = numero;  //numero viene inserito nel buffer
            isFull = true;    //buffer pieno (capienza buffer massima = 1)
            System.out.println("Produttore ha generato: " + numero);
            notifyAll();      //notifica i consumatori
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized int preleva() {
    	 while (true) { //ciclo infinito fino a che non viene prelevato il numero
             try {
                 while (!isFull) {  //aspetta finché il buffer è vuoto
                     wait();
                 }
                 int numero = valore;  //preleva il numero dal buffer
                 isFull = false;       //buffer vuoto una volta prelevato il numero
                 System.out.println("Consumatore ha prelevato: " + numero);
                 notifyAll();          //notifica produttore
                 return numero;        //restituisce il numero prelevato
                 
             } catch (InterruptedException e) {
                 Thread.currentThread().interrupt();
             }
         }
     }
 }
