package es_1_Natale;

public class Counter {
	   private int count = 0;

	    public void next() { //senza il synchronized si verifica la race condition perchè piu thread potrebbero accedere contemporaneamente alla varibile causando output incongruente
	        count++;  //incremento della variabile locale
	    }

	    public int getCount() {
	        return count; //restituisce il valore
	    }
	}
