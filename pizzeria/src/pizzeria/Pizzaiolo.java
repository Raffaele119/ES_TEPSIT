package pizzeria;

public class Pizzaiolo implements Runnable {
    //riferimento ai buffer delle pizze in cucina (ordini da preparare) e pizze cotte (ordini pronti)
    private final buffer<ordini> pizzeInCucina;
    private final buffer<ordini> pizzeCotte;

    //costruttore che inizializza i buffer condivisi per la gestione degli ordini
    public Pizzaiolo(buffer<ordini> pizzeInCucina, buffer<ordini> pizzeCotte) {
        this.pizzeInCucina = pizzeInCucina;
        this.pizzeCotte = pizzeCotte;
    }

    @Override
    public void run() {
        //ciclo infinito per il lavoro del pizzaiolo
        while (true) {
            //preleva un ordine dalla coda delle pizze in cucina per ogni tipo di pizza nell'ordine
        	ordini ordineDaPreparare = pizzeInCucina.prendi(); 
            System.out.println("Pizzaiolo: Sto preparando l'ordine del tavolo " + ordineDaPreparare.getTavoloId());
            for (String tipoPizza : ordineDaPreparare.getTipiPizza()) {
                try {
                    Thread.sleep(2000); //tempo di preparazione pizza
                    
                    //dopo la preparazione, aggiunge la pizza al buffer delle pizze cotte
                    pizzeCotte.aggiungi(new ordini(ordineDaPreparare.getTavoloId(), new String[]{tipoPizza}));
                    
                    //la pizza è pronta
                    System.out.println("Pizzaiolo: Pizza " + tipoPizza + " pronta per il tavolo " + ordineDaPreparare.getTavoloId());
                } catch (InterruptedException e) {
                	Thread.currentThread().interrupt();
                }
            }
        }
    }
}
