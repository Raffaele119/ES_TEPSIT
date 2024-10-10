package pizzeria;

public class tavoli implements Runnable {
    private final buffer<ordini> ordini;
    private final buffer<ordini> pizzeServite;
    private final int tavoloId;

    public tavoli(buffer<ordini> ordini, buffer<ordini> pizzeServite, int tavoloId) {
        this.ordini = ordini;
        this.pizzeServite = pizzeServite;
        this.tavoloId = tavoloId;
    }

    @Override
    public void run() {
        // Simula l'ordine del tavolo
        int numeroPersone = (int) (Math.random() * 5 + 1);
        String[] tipiPizze = new String[numeroPersone];

        for (int i = 0; i < numeroPersone; i++) {
            tipiPizze[i] = "Margherita"; //pizze casuali
        }

        ordini nuovoOrdine = new ordini(tavoloId, tipiPizze);
        System.out.println("Tavolo " + tavoloId + ": Ha ordinato " + numeroPersone + " pizze.");

        //aggiunge l'ordine al buffer
        ordini.aggiungi(nuovoOrdine); 
        ordini.aggiungi(nuovoOrdine);

        //consuma le pizze
        for (int i = 0; i < numeroPersone; i++) {
        	ordini pizzaServita = pizzeServite.prendiPerId(tavoloId, o -> o.getTavoloId());//estrae l'ID del tavolo da ogni oggetto ordini
            if (pizzaServita != null) {
                System.out.println("Tavolo " + tavoloId + ": Ha ricevuto una pizza.");
            }
        }
    }
}
