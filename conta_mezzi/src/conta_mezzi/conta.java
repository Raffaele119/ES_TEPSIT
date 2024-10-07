package conta_mezzi;

public class conta implements Runnable{
	private int n;
	private int d;
	
	public conta(int n, int delay) {
		this.n = n;
		this.d = delay;
	}
	
	public void run() {
		for(int i = 0 ; i <= n ; i++) {
			System.out.println(Thread.currentThread().getName() + " - Contatore: " + (i));
			
			try {
                Thread.sleep(d);
	        } catch(InterruptedException e){
	                e.printStackTrace();
	        }
		}	
	}
}

