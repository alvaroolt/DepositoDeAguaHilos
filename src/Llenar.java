
public class Llenar extends Thread {
	private Deposito dep;

	public Llenar(Deposito d) {
		this.dep = d;
		this.suspendido.setSuspendido(false);
	}

	SolicitarSuspender suspendido = new SolicitarSuspender();

	public void run() {
		synchronized (dep) {
			while (!this.suspendido.getSuspendido()) {
				for (int i = dep.getCapacidad(); i < dep.getCapacidadMax(); i++) {
					dep.llena();
					System.out.println(dep.getCapacidad() + " (aumenta)");

					if (this.suspendido.getSuspendido()) {
						break;
					}

					try {
						Thread.sleep(100);
						this.suspendido.waitReanudar();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
