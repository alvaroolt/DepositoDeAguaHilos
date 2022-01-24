
public class SolicitarSuspender {
	private boolean suspendido;

	public boolean getSuspendido() {
		return this.suspendido;
	}

	public synchronized void setSuspendido(boolean suspendido) {
		this.suspendido = suspendido;
		notifyAll();
		System.out.println("SUSPENDIDO " + suspendido);
	}

	public synchronized void waitReanudar() throws InterruptedException {
		while (getSuspendido()) {
			wait();
		}
	}
}

