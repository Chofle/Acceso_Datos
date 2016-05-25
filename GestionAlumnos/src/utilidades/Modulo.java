package utilidades;

import utilidades.Modulo;

public class Modulo {
	
	private String text;
	
	public Modulo(){}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Modulo [text=" + text + "]";
	}
}
