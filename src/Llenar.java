
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
		System.out.println(this.suspendido.getSuspendido());
		synchronized (dep) {
			System.out.println("he entrado en sync");
			while (!this.suspendido.getSuspendido()) {
				System.out.println("he entrado en el while");
				for (int i = dep.getCapacidad(); i < dep.getCapacidadMax(); i++) {
					System.out.println("he entrado en el for");
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
