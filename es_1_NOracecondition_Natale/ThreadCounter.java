package es_1_Natale;
import java.util.Random;

public class ThreadCounter implements Runnable {
	 private Counter counter;
	    private int n;

	    public ThreadCounter(Counter counter, int n) {
	        this.counter = counter;
	        this.n = n;
	    }

	    @Override
	    public void run() {
	        Random random = new Random();
	        int nrandom = random.nextInt(n / 2, n);//genera un numero random fra n/2 e n
	        for (int i = 0; i < nrandom; i++) {
	            counter.next();
	        }
	        System.out.println("thread ha incrementato " + nrandom + " volte");
	    }
	}