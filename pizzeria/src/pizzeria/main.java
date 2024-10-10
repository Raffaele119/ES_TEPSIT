package pizzeria;

public class main {

	public static void main(String[] args) {
		    buffer ordini = new buffer();
		    buffer pizzeInCucina = new buffer();
		    buffer pizzeCotte = new buffer();
		    buffer pizzeServite = new buffer();

	        //avvio i camerieri
	        for (int i = 0; i < 3; i++) {
	            new Thread(new cameriere(ordini, pizzeInCucina, pizzeCotte, pizzeServite)).start();
	        }

	        //avvio i pizzaioli
	        new Thread(new Pizzaiolo(pizzeInCucina, pizzeCotte)).start();

	        //avvio i tavoli che fanno ordini
	        for (int i = 0; i < 20; i++) {
	            new Thread(new tavoli(ordini, pizzeServite, i)).start();
	        }
	    }
	}
