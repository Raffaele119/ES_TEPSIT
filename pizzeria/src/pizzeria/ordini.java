package pizzeria;

public class ordini {
	    private final int tavoloId;
	    private final String[] tipiPizza;

	    public ordini(int tavoloId, String[] tipiPizza) {
	        this.tavoloId = tavoloId;
	        this.tipiPizza = tipiPizza;
	    }

	    public int getTavoloId() {
	        return tavoloId;
	    }

	    public String[] getTipiPizza() {
	        return tipiPizza;
	    }
	}
