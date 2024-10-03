package produttore_consumatore;

public class produttore implements Runnable {
    private int x;
    private buffer buf; 

    public produttore(int x, buffer buf) {
        this.x = x;
        this.buf = buf;
    }

    public void generanumero() {
        while (true) {
            int num = (int)(Math.random() * 1024); // numero generato
            buf.push(num); // inserisce il numero nel buffer

            try {
                int xms = (int)((Math.random() * 901) + 100); // xms tra 100 e 1000 ms
                Thread.sleep(xms); // attende xms millisecondi
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public void run() {
        generanumero();
    }
}