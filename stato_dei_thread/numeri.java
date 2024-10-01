package stato_thread;

public class numeri {
	private int x, counter;
	
	public int AumentoCounter() {
		return ++counter;
	}
	public int getX() {
		return x;
	}
	public int getCounter() {
		return counter;
	}
	public numeri(int n) {
		counter = 0;
		x = (int)(Math.random() * n);
	}
}
