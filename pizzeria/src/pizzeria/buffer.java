package pizzeria;
import java.util.LinkedList;
import java.util.Queue;

public class buffer<T>  {
    //coda generica che utilizza LinkedList per memorizzare oggetti di tipo T
	private final Queue<T> queue = new LinkedList<>();

    //aggiunge un elemento alla coda
    public synchronized void aggiungi(T elemento) {
        queue.add(elemento); //aggiunge l'elemento alla coda
        notifyAll(); //notifica tutti i thread in attesa che un elemento è stato aggiunto
    }

    //preleva il primo elemento dalla coda
    public synchronized T prendi() {
        //se la coda è vuota, il thread aspetta finché non è disponibile un elemento
        while (queue.isEmpty()) {
            try {
                wait(); //mette il thread in attesa finché non viene notificato
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return queue.poll(); //rimuove e restituisce il primo elemento della coda
    }

    //dimensione della coda
    public synchronized int dimensione() {
        return queue.size(); //restituisce il numero di elementi nella coda
    }

    //preleva un elemento dalla coda in base all'ID
    public synchronized T prendiPerId(int id, IDExtractor<T> extractor) {
        //se la coda è vuota, il thread aspetta finché non è disponibile un elemento
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        //cicla attraverso gli elementi della coda
        for (T item : queue) {
            //utilizza l'extractor per ottenere l'ID dall'elemento e confrontarlo con l'ID richiesto
            if (extractor.estraiId(item) == id) {
                queue.remove(item); //rimuove l'elemento se l'ID corrisponde
                return item; //restituisce l'elemento trovato
            }
        }
        return null; //restituisce null se nessun elemento con l'ID corrisponde
    }

    //interfaccia che estrae l'ID da un oggetto di tipo T
    @FunctionalInterface
    public interface IDExtractor<T> {
        int estraiId(T elemento); //estrae l'ID
    }
}
