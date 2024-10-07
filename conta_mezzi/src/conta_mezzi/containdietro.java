package conta_mezzi;

public class containdietro implements Runnable{
	private int n;
	private int delay;
	
	public containdietro(int n , int d){
		this.n = n;
		this.delay = d;
	}
	public void run() {
		for (int i = n ; i > 0 ; i--) {
			System.out.println(Thread.currentThread().getName() + " - Contatore: " + (i));
			try {
                Thread.sleep(delay);
	        } catch(InterruptedException e){
	                e.printStackTrace();
	        }
		}
		
	}
}
