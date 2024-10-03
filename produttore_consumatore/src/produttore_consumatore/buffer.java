package produttore_consumatore;

public class buffer {
    private int[] arr; 
    private int count; //numero di elementi attualmente nel buffer
    private int in, out; //indici di inserimento e rimozione
    private int size; //dimensione del buffer

    public buffer(int size) {
        this.size = size;
        this.arr = new int[size]; //inizializza l'array con la lunghezza specificata
        this.count = 0; //contatore per tenere traccia del numero di elementi nel buffer
        this.in = 0;
        this.out = 0;
    }

    public synchronized void push(int n) {//metodo synchronized per inserire un numero nel buffer

        while (count == size) { //se il buffer è pieno, attende
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        arr[in] = n;
        in = (in + 1) % size;
        count++;
        System.out.println("Numero " + n + " inserito nel buffer.");
        notifyAll(); //notifica che è stato inserito un nuovo numero
    }

    //metodo synchronized per rimuovere un numero dal buffer
    public synchronized int pop() {
        while (count == 0) { //se il buffer è vuoto, attende
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        int n = arr[out]; //preleva il valore attuale presente nell'array 
        //aggiorna l'indice 'out' per puntare al prossimo elemento da leggere nel buffer
		//out' viene incrementato di 1, e il modulo 'size' assicura che torni all'inizio dell'array se supera la dimensione
        out = (out + 1) % size;
        count--;//decremeneta il numero di elementi all'interno del buffer
        System.out.println("Numero " + n + " rimosso dal buffer.");
        notifyAll(); //notifica che c'è spazio libero nel buffer
        return n;
    }
}
