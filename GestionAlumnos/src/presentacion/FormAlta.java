package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

import dao.AlumnoDao;

import utilidades.Alumno;
import utilidades.DaoException;

public class FormAlta {

	JFrame frmAlta;
	private JTextField textFieldNombreAlumno;
	private JTextField textFieldApellido1Alumno;
	private JTextField textFieldApellido2Alumno;
	private JTextField textFieldNumMatriculaAlumno;
	private JTextField textFieldDniAlumno;
	private List<Alumno> listaAlumnos = null;
	private AlumnoDao alumnoDao = new AlumnoDao();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAlta window = new FormAlta();
					window.frmAlta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormAlta(){
		initialize();
		
		textFieldNumMatriculaAlumno.setText(String.valueOf(alumnoDao.getNumMatricula()));
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAlta = new JFrame();
		frmAlta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmAlta.setAlwaysOnTop(true);
		frmAlta.setTitle("Alta de Alumno");
		frmAlta.setBounds(100, 100, 533, 407);
		frmAlta.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(30, 51, 452, 238);
		frmAlta.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(25, 26, 67, 14);
		panel.add(lblNombre);
		
		textFieldNombreAlumno = new JTextField();
		textFieldNombreAlumno.setBounds(124, 23, 291, 20);
		panel.add(textFieldNombreAlumno);
		textFieldNombreAlumno.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido1:");
		lblApellido.setBounds(25, 65, 67, 14);
		panel.add(lblApellido);
		
		textFieldApellido1Alumno = new JTextField();
		textFieldApellido1Alumno.setColumns(10);
		textFieldApellido1Alumno.setBounds(124, 62, 291, 20);
		panel.add(textFieldApellido1Alumno);
		
		JLabel lblApellido_1 = new JLabel("Apellido2");
		lblApellido_1.setBounds(25, 103, 67, 14);
		panel.add(lblApellido_1);
		
		textFieldApellido2Alumno = new JTextField();
		textFieldApellido2Alumno.setColumns(10);
		textFieldApellido2Alumno.setBounds(124, 100, 291, 20);
		panel.add(textFieldApellido2Alumno);
		
		JLabel lblNMatrcula = new JLabel("N\u00BA matr\u00EDcula:");
		lblNMatrcula.setBounds(25, 142, 89, 14);
		panel.add(lblNMatrcula);
		
		textFieldNumMatriculaAlumno = new JTextField();
		textFieldNumMatriculaAlumno.setEnabled(false);
		textFieldNumMatriculaAlumno.setEditable(false);
		textFieldNumMatriculaAlumno.setColumns(10);
		textFieldNumMatriculaAlumno.setBounds(124, 139, 291, 20);
		panel.add(textFieldNumMatriculaAlumno);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(25, 184, 67, 14);
		panel.add(lblDni);
		
		textFieldDniAlumno = new JTextField();
		textFieldDniAlumno.setColumns(10);
		textFieldDniAlumno.setBounds(124, 181, 291, 20);
		panel.add(textFieldDniAlumno);
		
		JLabel lblDatosDelAlumno = new JLabel("Datos del alumno:");
		lblDatosDelAlumno.setBounds(30, 26, 201, 14);
		frmAlta.getContentPane().add(lblDatosDelAlumno);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textFieldNumMatriculaAlumno.getText().trim().isEmpty() || textFieldApellido1Alumno.getText().trim().isEmpty()
						|| textFieldApellido2Alumno.getText().trim().isEmpty() || textFieldDniAlumno.getText().trim().isEmpty()){
					
						JOptionPane.showMessageDialog(frmAlta, "Hay campos de texto vacíos", "" ,JOptionPane.WARNING_MESSAGE);
						
					}else{
						int numMatricular = Integer.valueOf(textFieldNumMatriculaAlumno.getText()); 
						String nombre =  textFieldNombreAlumno.getText();
						String apellido1 = textFieldApellido1Alumno.getText();
						String apellido2 = textFieldApellido2Alumno.getText(); 
						
						Date fechaActual = new Date();
						SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
						String horaAlta = formato.format(fechaActual);
						String horaModificacion = formato.format(fechaActual);
						
						String cadena = textFieldDniAlumno.getText();
						Pattern pat = Pattern.compile("^[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z]$");
					    Matcher mat = pat.matcher(cadena);
					    if (mat.matches()) {
					    	String dni = textFieldDniAlumno.getText();
					    	
					    	Alumno alumnoNuevo = new Alumno(numMatricular, nombre,apellido1, apellido2, horaAlta, horaModificacion, dni);
						
							try {
								alumnoDao.insertar(numMatricular, nombre,apellido1, apellido2, horaAlta, horaModificacion, dni);
								JOptionPane.showMessageDialog(frmAlta,"Alumno insertado correctamente","" , 1);
							} catch (DaoException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							frmAlta.dispose();
							
							listaAlumnos = alumnoDao.getListaAlumnos();
							alumnoDao.agregarDatos(FormMenu.tablaAlumnos, listaAlumnos);
							
						}else{
					    	JOptionPane.showMessageDialog(frmAlta, "DNI incorrecto", "" ,JOptionPane.WARNING_MESSAGE);
					    	textFieldDniAlumno.requestFocus(); // asigno el foco al textfield 
					    	textFieldDniAlumno.selectAll(); // luego selecciono todo el texto 
					    }
					}
			}
		});
		btnAceptar.setBounds(129, 321, 89, 23);
		frmAlta.getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAlta.dispose();
			}
		});
		btnCancelar.setBounds(293, 321, 89, 23);
		frmAlta.getContentPane().add(btnCancelar);
	}

}
