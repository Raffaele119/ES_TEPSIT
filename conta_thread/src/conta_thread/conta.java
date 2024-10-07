package conta_thread;

public class conta implements Runnable {
	private int n;
	private int counter;
	
	public conta(int n) {
		this.n = n;
	}
	
	
	public void run() {
		for (int i = 0 ;  i < n ; i++) {
			counter++;
            System.out.println(Thread.currentThread().getName() + " - Contatore: " + (i + 1) + " counter : " + counter);
		}
	}
}
