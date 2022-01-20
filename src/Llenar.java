
public class Llenar extends Thread {
	private Deposito dep;

	public Llenar(Deposito d) {
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

			for (int i = dep.getCapacidad(); i < dep.getCapacidadMax(); i++) {
				while (!this.suspendido.getSuspendido()) {
					dep.llena();
					System.out.println(dep.getCapacidad() + " (aumenta)");

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		}
//		System.out.println("Capacidad: " + dep.getCapacidad());
	}
}
