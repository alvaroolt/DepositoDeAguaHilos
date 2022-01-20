
public class Vaciar extends Thread {
	private Deposito dep;

	public Vaciar(Deposito d) {
		this.dep = d;
		this.suspendido.setSuspendido(false);
	}

	SolicitarSuspender suspendido = new SolicitarSuspender();

	public SolicitarSuspender getSuspendido() {
		return suspendido;
	}

	public void setSuspendido(SolicitarSuspender suspendido) {
		this.suspendido = suspendido;
	}

	public void run() {
		synchronized (dep) {
			
				for (int i = dep.getCapacidad(); i > 0; i--) {
					while (!this.suspendido.getSuspendido()) {
					dep.vacia();
					System.out.println(dep.getCapacidad() + " (disminuye)");

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
