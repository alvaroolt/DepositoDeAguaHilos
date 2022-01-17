
public class Llenar extends Thread{
	private Deposito dep;
	
	public Llenar(Deposito d) {
		this.dep = d;
	}
	
	public void run() {
		synchronized (dep) {
			for (int i = dep.getCapacidad(); i < dep.getCapacidadMax(); i++) {
				dep.llena();
				System.out.println(dep.getCapacidad());
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
//		System.out.println("Capacidad: " + dep.getCapacidad());
	}
}
