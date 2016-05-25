package utilidades;

import java.util.ArrayList;
import java.util.List;

import utilidades.Matricula;
import utilidades.Matriculas;

public class Matriculas {

	private String año;

	private List<Matricula> matriculas;

	public Matriculas() {
		matriculas = new ArrayList<Matricula>();
	}

	public String getAño() {
		return año;
	}

	public void setAño(String año) {
		this.año = año;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	@Override
	public String toString() {
		return "Matriculas [año=" + año + ", matriculas=" + matriculas + "]";
	}

}
