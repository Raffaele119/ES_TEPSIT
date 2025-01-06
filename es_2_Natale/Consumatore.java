package ProduttoreConsumatore;

public class Consumatore implements Runnable{
	  private Buffer buffer;
      private int minRange;
      private int maxRange;

      public Consumatore(Buffer buffer, int minRange, int maxRange) {
          this.buffer = buffer;
          this.minRange = minRange;
          this.maxRange = maxRange;
      }

      @Override
      public void run() {
          try {
              while (true) {
                  int numero = buffer.preleva();
                  if (numero >= minRange && numero <= maxRange) {
                      System.out.println("Consumatore [" + minRange + "-" + maxRange + "] ha preso: " + numero);
                  } else {
                      System.out.println("Consumatore [" + minRange + "-" + maxRange + "] ha ignorato: " + numero);
                  }
                  Thread.sleep(1000);  // Simula ritardo del consumatore
              }
          } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
          }
      }
  }