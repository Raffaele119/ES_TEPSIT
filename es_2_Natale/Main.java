package ProduttoreConsumatore;

public class Main {

	public static void main(String[] args) {
		Buffer buffer = new Buffer();

        //creazione e avvio del produttore
        Thread produttore = new Thread(new Produttore(buffer));
        produttore.start();

        //creazione e avvio dei due consumatori
        Thread consumatore1 = new Thread(new Consumatore(buffer, 1, 5));
        Thread consumatore2 = new Thread(new Consumatore(buffer, 6, 10));
        consumatore1.start();
        consumatore2.start();
    }
}