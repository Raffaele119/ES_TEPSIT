package es_1_Natale;
/*
 * Come mi accorgo analizzando i valori in uscita che c’è stata race-condition?
	se la somma dei valori che i thread hanno incrementato non corrisponde al valore finale del contatore allora si è verificata una race condition
	
 * Modificare il programma in modo da non avere più race-condition.
	aggiungo al metodo next() della classe Counter Synchronized
 */
	
public class RaceCondition {

	public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("inserisci il numero di thread (M): ");
        int M = scanner.nextInt();
        System.out.print("inserisci il valore di N: ");
        int N = scanner.nextInt();

        //creazione del contatore condiviso
        Counter counter = new Counter();

        //creazione e avvio dei thread
        Thread[] threads = new Thread[M];
        for (int i = 0; i < M; i++) {
            threads[i] = new Thread(new ThreadCounter(counter, N));
            threads[i].start();
        }

        for (int i = 0; i < M; i++) {
            threads[i].run();
        }

        //stampa del valore finale del contatore
        System.out.println("Valore finale del contatore: " + counter.getCount());
    }
}