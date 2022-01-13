
public class Llenar extends Thread{
	private Deposito dep;
	
	public Llenar(Deposito d) {
		this.dep = d;
	}
	
	public void run() {
		synchronized (dep) {
			for (int i = 0; i < 100; i++) {
				dep.llena();
			}
		}
	}
}
