package stato_thread;

public class mainthread {
	conserva[] temp;
	Thread[] tt;
	public mainthread(conserva arr[], Thread[] arr1) {
		temp = arr;
		tt = arr1;
	}
	public void run() {
		Boolean vivo = true; //variabile utilizzata per controllare se i thread sono vivi
		while(vivo) {
			vivo = false;
			try {
				Thread.sleep(2000);
			}catch (InterruptedException e) {}
			for(int i = 0; i<temp.length; i++) {
				if(tt[i].isAlive()) { // stampo lo stato dei thread
					vivo = true;
					System.out.println(tt[i].getId() + "è vivo" + temp[i].getNum().getCounter());
				}else {
					System.out.println(tt[i].getId() + "è morto");
				}
			}
		}
	}
 }
