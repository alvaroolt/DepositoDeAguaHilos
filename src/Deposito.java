import java.util.Objects;

public class Deposito {

	private int capacidadMax;
	private int capacidad;

	public Deposito(int capacidadMax, int capacidad) {
		this.capacidadMax = capacidadMax;
		this.capacidad = capacidad;
	}

	public Deposito(int capacidad) {
		super();
		this.capacidad = capacidad;
	}

	public int getCapacidadMax() {
		return capacidadMax;
	}

	public void setCapacidadMax(int capacidadMax) {
		this.capacidadMax = capacidadMax;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	public void llena() {
		this.capacidad++;
	}
	
	public void vacia() {
		capacidad--;
	}

	@Override
	public int hashCode() {
		return Objects.hash(capacidad, capacidadMax);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deposito other = (Deposito) obj;
		return capacidad == other.capacidad && capacidadMax == other.capacidadMax;
	}

	@Override
	public String toString() {
		return "Deposito [ capacidadMax=" + capacidadMax + ", capacidad=" + capacidad + "]";
	}
}
