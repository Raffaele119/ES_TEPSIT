package produttore_consumatore;

public class consumatore implements Runnable {
    private int pari;
    private int dispari;
    private buffer buf; //riferimento al buffer condiviso

    //costruttore che riceve il buffer condiviso
    public consumatore(buffer buf) {
        this.buf = buf;
    }

    public void usa() {
        while (true) {
            int n = buf.pop(); //rimuove un numero dal buffer

            if (n % 2 == 0) {
                pari++;
            } else {
                dispari++;
            }

            //stampa la statistica aggiornata
            System.out.println("Statistica numeri pari letti: " + pari);
            System.out.println("Statistica numeri dispari letti: " + dispari);

            try {
                Thread.sleep(1200); //il consumatore aspetta 1 secondo
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
        }
    }

    @Override
    public void run() {
        usa();
    }
}
