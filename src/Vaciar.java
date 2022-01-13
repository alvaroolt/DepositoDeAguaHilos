
public class Vaciar extends Thread {
	private Deposito dep;
	
	public Vaciar (Deposito d) {
		this.dep = d;
	}
	
	public void run() {
		synchronized (dep) {
			for (int i = 0; i < 100; i++) {
				dep.vacia();
			}
		}
	}
}
