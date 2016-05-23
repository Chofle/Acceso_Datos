package utilidades;


public class Alumno {

	private int numMatricular;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String horaAlta;
	private String horaModificacion;
	private String dni;
	
	public Alumno(){
	}
	
	public Alumno(int numMatricular, String nombre, String apellido1, String apellido2, String horaAlta, String horaModificacion, String dni){
		super();
		this.numMatricular = numMatricular;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.horaAlta = horaAlta;
		this.horaModificacion = horaModificacion;
		this.dni = dni;
	}
	
	public int getNumMatricular() {
		return numMatricular;
	}

	public void setNumMatricular(int numMatricular) {
		this.numMatricular = numMatricular;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getHoraAlta() {
		return horaAlta;
	}

	public void setHoraAlta(String horaAlta) {
		this.horaAlta = horaAlta;
	}

	public String getHoraModificacion() {
		return horaModificacion;
	}

	public void setHoraModificacion(String horaModificacion) {
		this.horaModificacion = horaModificacion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public void actualizar(Alumno alumno) {
		this.numMatricular = alumno.getNumMatricular();
		this.nombre = alumno.getNombre();
		this.horaAlta = alumno.getHoraAlta();
		this.horaModificacion = alumno.getHoraModificacion();
		this.dni = alumno.getDni();
	}
	
}
