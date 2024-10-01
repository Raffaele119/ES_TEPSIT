package stato_thread;

public class conserva implements Runnable { //classe che permette l'incremento
	numeri conservatore;
	
	public conserva( numeri num) {
		conservatore = num;
	}
	
	public void run() {
		int x = conservatore.getX();
		while(conservatore.AumentoCounter() != x);//aumento il counter
		
	}
	public numeri getNum() {
		return conservatore;
	}
	

}
