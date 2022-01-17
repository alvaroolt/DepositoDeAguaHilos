
public class Vaciar extends Thread {
	private Deposito dep;
	
	public Vaciar (Deposito d) {
		this.dep = d;
	}
	
	public void run() {
		synchronized (dep) {
			for (int i = dep.getCapacidad(); i < dep.getCapacidadMax(); i++) {
				dep.vacia();
				System.out.println(dep.getCapacidad());
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
