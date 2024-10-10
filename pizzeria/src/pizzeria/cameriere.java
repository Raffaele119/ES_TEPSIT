package pizzeria;

public class cameriere implements Runnable {
	    private final buffer<ordini> ordini;
	    private final buffer<ordini> pizzeInCucina;
	    private final buffer<ordini> pizzeCotte;
	    private final buffer<ordini> pizzeServite;

	    public cameriere(buffer<ordini> ordini, buffer<ordini> pizzeInCucina, buffer<ordini> pizzeCotte, buffer<ordini> pizzeServite) {
	        this.ordini = ordini;
	        this.pizzeInCucina = pizzeInCucina;
	        this.pizzeCotte = pizzeCotte;
	        this.pizzeServite = pizzeServite;
	    }

	    @Override
	    public void run() {
	        while (true) {
	            if (Math.random() > 0.5 || pizzeCotte.dimensione() == 0) {
	                // Prende un nuovo ordine e lo manda in cucina
	            	ordini ordine = ordini.prendi();
	                System.out.println("Cameriere: Ho preso l'ordine dal tavolo " + ordine.getTavoloId());
	                pizzeInCucina.aggiungi(ordine);
	            } else {
	                // Prende una pizza cotta e la porta al tavolo
	            	ordini pizza = pizzeCotte.prendi();
	                System.out.println("Cameriere: Porto la pizza al tavolo " + pizza.getTavoloId());
	                pizzeServite.aggiungi(pizza);
	            }

	            try {
	                Thread.sleep(1000); // Simula il tempo di movimento
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }
	        }
	    }
	}
