package utilidades;

import java.util.ArrayList;
import java.util.List;

public class Matricula {
	
	private long id;
	
	private int alumno;
	

	private List<Modulo> modulos;
	
	public Matricula(){
		modulos = new ArrayList<Modulo>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAlumno() {
		return alumno;
	}

	public void setAlumno(int alumno) {
		this.alumno = alumno;
	}

	public List<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(List<Modulo> modulos) {
		this.modulos = modulos;
	}

	@Override
	public String toString() {
		return "Matricula [id=" + id + ", alumno=" + alumno + ", modulos=" + modulos + "]";
	}
	
	
	
}
