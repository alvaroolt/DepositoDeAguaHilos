
public class Vaciar extends Thread {
	private Deposito dep;

	public Vaciar(Deposito d) {
		this.dep = d;
		this.suspendido.setSuspendido(false);
	}

	SolicitarSuspender suspendido = new SolicitarSuspender();

	public void run() {
		synchronized (dep) {

			while (!this.suspendido.getSuspendido()) {
				for (int i = dep.getCapacidad(); i > 0; i--) {
					dep.vacia();
					System.out.println(dep.getCapacidad() + " (disminuye)");

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
