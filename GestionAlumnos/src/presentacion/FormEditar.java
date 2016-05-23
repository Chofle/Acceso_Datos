package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import dao.AlumnoDao;
import utilidades.Alumno;
import utilidades.DaoException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class FormEditar {

	JFrame frmEdic;
	private JTextField textFieldNombreEdic;
	private JTextField textFieldApellido1Edic;
	private JTextField textFieldApellido2Edic;
	private JTextField textFieldNumMatriculaEdic;
	private JTextField textFieldDniEdic;
	private List<Alumno> listaAlumnos = null;
	private String dniAlumnoEdic = FormMenu.dniAlumnoTabla;
	private AlumnoDao alumnoDao = new AlumnoDao();
	private Alumno alumnoBuscado;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormEditar window = new FormEditar();
					window.frmEdic.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormEditar() {
		initialize();	
		
		listaAlumnos = alumnoDao.getListaAlumnos();
		alumnoBuscado = alumnoDao.buscarAlumnoPorDni(dniAlumnoEdic);
		
		textFieldNombreEdic.setText(alumnoBuscado.getNombre());
		textFieldApellido1Edic.setText(alumnoBuscado.getApellido1());
		textFieldApellido2Edic.setText(alumnoBuscado.getApellido2());
		textFieldNumMatriculaEdic.setText(String.valueOf(alumnoBuscado.getNumMatricular()));
		textFieldDniEdic.setText(alumnoBuscado.getDni());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEdic = new JFrame();
		frmEdic.setTitle("Editar de Alumno");
		frmEdic.setBounds(100, 100, 533, 407);
		frmEdic.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmEdic.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(30, 51, 452, 238);
		frmEdic.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(25, 26, 67, 14);
		panel.add(lblNombre);
		
		textFieldNombreEdic = new JTextField();
		textFieldNombreEdic.setBounds(124, 23, 291, 20);
		panel.add(textFieldNombreEdic);
		textFieldNombreEdic.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido1:");
		lblApellido.setBounds(25, 65, 67, 14);
		panel.add(lblApellido);
		
		textFieldApellido1Edic = new JTextField();
		textFieldApellido1Edic.setColumns(10);
		textFieldApellido1Edic.setBounds(124, 62, 291, 20);
		panel.add(textFieldApellido1Edic);
		
		JLabel lblApellido_1 = new JLabel("Apellido2");
		lblApellido_1.setBounds(25, 103, 67, 14);
		panel.add(lblApellido_1);
		
		textFieldApellido2Edic = new JTextField();
		textFieldApellido2Edic.setColumns(10);
		textFieldApellido2Edic.setBounds(124, 100, 291, 20);
		panel.add(textFieldApellido2Edic);
		
		JLabel lblNMatrcula = new JLabel("N\u00BA matr\u00EDcula:");
		lblNMatrcula.setBounds(25, 142, 89, 14);
		panel.add(lblNMatrcula);
		
		textFieldNumMatriculaEdic = new JTextField();
		textFieldNumMatriculaEdic.setColumns(10);
		textFieldNumMatriculaEdic.setBounds(124, 139, 291, 20);
		panel.add(textFieldNumMatriculaEdic);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(25, 184, 67, 14);
		panel.add(lblDni);
		
		textFieldDniEdic = new JTextField();
		textFieldDniEdic.setColumns(10);
		textFieldDniEdic.setBounds(124, 181, 291, 20);
		panel.add(textFieldDniEdic);
		
		JLabel lblDatosDelAlumno = new JLabel("Datos del alumno:");
		lblDatosDelAlumno.setBounds(30, 26, 201, 14);
		frmEdic.getContentPane().add(lblDatosDelAlumno);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldNombreEdic.getText().trim().isEmpty() || textFieldNumMatriculaEdic.getText().trim().isEmpty() || textFieldApellido1Edic.getText().trim().isEmpty()
						|| textFieldApellido2Edic.getText().trim().isEmpty() || textFieldDniEdic.getText().trim().isEmpty()){
					
						JOptionPane.showMessageDialog(frmEdic, "Hay campos de texto vacíos", "" ,JOptionPane.WARNING_MESSAGE);
						
					}else{
						int numMatricular = Integer.valueOf(textFieldNumMatriculaEdic.getText()); 
						String nombre =  textFieldNombreEdic.getText();
						String apellido1 = textFieldApellido1Edic.getText();
						String apellido2 = textFieldApellido2Edic.getText(); 
						
						Date fechaActual = new Date();
						SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
						String horaAlta = alumnoBuscado.getHoraAlta();
						String horaModificacion = formato.format(fechaActual);
						
						String cadena = textFieldDniEdic.getText();
						Pattern pat = Pattern.compile("^[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z]$");
					    Matcher mat = pat.matcher(cadena);
					    if (mat.matches()) {
					    	String dni = textFieldDniEdic.getText();
					    	
					    	Alumno alumnoNuevo = new Alumno(numMatricular, nombre,apellido1, apellido2, horaAlta, horaModificacion, dni);
						
							try {
								alumnoDao.update(numMatricular, nombre,apellido1, apellido2, horaAlta, horaModificacion, dni, dniAlumnoEdic);
								JOptionPane.showMessageDialog(frmEdic,"Alumno actualizado correctamente","" , 1);
							} catch (DaoException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							frmEdic.dispose();
							
							listaAlumnos.clear();
							listaAlumnos = alumnoDao.getListaAlumnos();
							alumnoDao.agregarDatos(FormMenu.tablaAlumnos, listaAlumnos);
							
						}else{
					    	JOptionPane.showMessageDialog(frmEdic, "DNI incorrecto", "" ,JOptionPane.WARNING_MESSAGE);
					    	textFieldDniEdic.requestFocus(); // asigno el foco al textfield 
					    	textFieldDniEdic.selectAll(); // luego selecciono todo el texto 
					    }
					}
			}
		});
		btnAceptar.setBounds(129, 321, 89, 23);
		frmEdic.getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEdic.dispose();
			}
		});
		btnCancelar.setBounds(293, 321, 89, 23);
		frmEdic.getContentPane().add(btnCancelar);
	}

}
