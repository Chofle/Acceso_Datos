package utilidades;


public class Modulos {

	private int id;
	private String codigo;
	private String nombre;
	private int horasTotales;
	private int horas;
	private int curso;
	
	public Modulos(){
		horas = 0;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getHorasTotales() {
		return horasTotales;
	}

	public void setHorasTotales(int horasTotales) {
		this.horasTotales = horasTotales;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "ModuloC [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", horasTotales=" + horasTotales
				+ ", horas=" + horas + ", curso=" + curso + "]";
	}

}
