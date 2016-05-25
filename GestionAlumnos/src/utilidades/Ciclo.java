package utilidades;

import java.util.List;

public class Ciclo {

	private int id;

	private String nombre;
	private String nombreCorto;
	private int horas;
	private String nivel;

	private List<Modulos> modulos;

	@Override
	public String toString() {
		return "Ciclo [id=" + id + ", nombre=" + nombre + ", nombreCorto=" + nombreCorto + ", horas=" + horas
				+ ", nivel=" + nivel + ", modulos=" + modulos + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public List<Modulos> getModulos() {
		return modulos;
	}

	public void setModulos(List<Modulos> modulos) {
		this.modulos = modulos;
	}

}
