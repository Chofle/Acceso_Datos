package presentacion;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;


import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import dao.AlumnoDao;
import utilidades.Alumno;
import utilidades.DaoException;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

import java.awt.Component;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormMenu {

	private JFrame frmMenu;
	
	JTextField textFieldBuscarAlumno;
	public static JTable tablaAlumnos;
	private AlumnoDao alumnoDao = new AlumnoDao();
	private List<Alumno> listaAlumnos = null;
	public static String dniAlumnoTabla = "";
	List<Alumno> listaAlumnosEncontradosApellido1 = new ArrayList<Alumno>();
	List<Alumno> listaAlumnosEncontradosApellido2 = new ArrayList<Alumno>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormMenu window = new FormMenu();
					window.frmMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenu = new JFrame();
		frmMenu.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmMenu.setResizable(false);
		frmMenu.setTitle("Gesti\u00F3n Docente");
		frmMenu.setBounds(100, 100, 694, 489);
		frmMenu.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(30, 61, 633, 389);
		frmMenu.getContentPane().add(panel);
		panel.setLayout(null);
		
		JComboBox comboBoxCampoBusqueda = new JComboBox();
		comboBoxCampoBusqueda.setModel(new DefaultComboBoxModel(new String[] {"Nombre", "Apellido1", "Apellido2", "N\u00FAmero matricular", "DNI"}));
		comboBoxCampoBusqueda.setBounds(161, 58, 324, 20);
		panel.add(comboBoxCampoBusqueda);
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(frmMenu, "¿Seguro que quieres borrar este alumno?", "" ,JOptionPane.OK_CANCEL_OPTION) == JOptionPane.YES_OPTION){
					try {
						alumnoDao.borrar(dniAlumnoTabla);
						listaAlumnos.clear();
						listaAlumnos = alumnoDao.getListaAlumnos();
						alumnoDao.agregarDatos(tablaAlumnos, listaAlumnos);
						
					} catch (DaoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnBorrar.setEnabled(false);
		btnBorrar.setBounds(505, 145, 104, 23);
		panel.add(btnBorrar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormEditar window = new FormEditar();
				window.frmEdic.setVisible(true);
			}
		});
		btnEditar.setEnabled(false);
		btnEditar.setBounds(505, 179, 104, 23);
		panel.add(btnEditar);
		
		
		JButton btnMatricular = new JButton("Matricular");
		
		btnMatricular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormMatriculas window = new FormMatriculas();
				window.frmMatriculas.setVisible(true);
			}
		});
		
		btnMatricular.setEnabled(false);
		btnMatricular.setBounds(505, 213, 104, 23);
		panel.add(btnMatricular);
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(listaAlumnos != null){
					listaAlumnos.clear();
				}
				
				tablaAlumnos.removeAll();
								
				btnBorrar.setEnabled(false);
				btnEditar.setEnabled(false);
				//String campoABuscar = comboBoxCampoBusqueda.getSelectedItem().toString();
				listaAlumnos = alumnoDao.getListaAlumnos();

				if(textFieldBuscarAlumno.getText().isEmpty()){
					alumnoDao.agregarDatos(tablaAlumnos, listaAlumnos);
				}else{
					switch(comboBoxCampoBusqueda.getSelectedItem().toString()){
						case "DNI":
							Alumno alumnoEncontrado = alumnoDao.buscarAlumnoPorDni(textFieldBuscarAlumno.getText());
							List<Alumno> listaAlumnosEncontradosDni = new ArrayList<Alumno>();
							listaAlumnosEncontradosDni.add(alumnoEncontrado);
							alumnoDao.agregarDatos(tablaAlumnos, listaAlumnosEncontradosDni);
							break;
						case "Nombre":
							Alumno alumnoEncontradoNombre = alumnoDao.buscarAlumnoPorNombre(textFieldBuscarAlumno.getText());
							List<Alumno> listaAlumnosEncontradosNombre = new ArrayList<Alumno>();
							listaAlumnosEncontradosNombre.add(alumnoEncontradoNombre);
							alumnoDao.agregarDatos(tablaAlumnos, listaAlumnosEncontradosNombre);
							break;
						case "Apellido1":
							listaAlumnosEncontradosApellido1.clear();
							listaAlumnosEncontradosApellido1 = alumnoDao.buscarAlumnoPorApellido1(textFieldBuscarAlumno.getText());
							alumnoDao.agregarDatos(tablaAlumnos, listaAlumnosEncontradosApellido1);
							break;
						case "Apellido2":
							listaAlumnosEncontradosApellido2.clear();
							listaAlumnosEncontradosApellido2 = alumnoDao.buscarAlumnoPorApellido2(textFieldBuscarAlumno.getText());
							alumnoDao.agregarDatos(tablaAlumnos, listaAlumnosEncontradosApellido2);
							break;
						case "N\u00FAmero matricular":
							Alumno alumnoEncontradoNumMatricula = alumnoDao.buscarAlumnoPorNumMatricula(Integer.valueOf(textFieldBuscarAlumno.getText()));
							List<Alumno> listaAlumnosEncontradosNumMatricula = new ArrayList<Alumno>();
							listaAlumnosEncontradosNumMatricula.add(alumnoEncontradoNumMatricula);
							alumnoDao.agregarDatos(tablaAlumnos, listaAlumnosEncontradosNumMatricula);
							break;
					}
				}	
				
				listaAlumnos.clear();
			}
		});
		btnBuscar.setBounds(505, 13, 104, 23);
		panel.add(btnBuscar);
		
		JLabel lblBuscarAlumno = new JLabel("Buscar Alumno:");
		lblBuscarAlumno.setBounds(28, 15, 136, 19);
		panel.add(lblBuscarAlumno);
		
		textFieldBuscarAlumno = new JTextField();
		textFieldBuscarAlumno.setBounds(161, 12, 324, 20);
		panel.add(textFieldBuscarAlumno);
		textFieldBuscarAlumno.setColumns(10);
		
		JLabel lblCampoDeBusqueda = new JLabel("Campo de Busqueda:");
		lblCampoDeBusqueda.setBounds(28, 57, 136, 23);
		panel.add(lblCampoDeBusqueda);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 115, 457, 240);
		panel.add(scrollPane);
		
		tablaAlumnos = new JTable();
		tablaAlumnos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {			
				btnBorrar.setEnabled(true);
				btnEditar.setEnabled(true);
				btnMatricular.setEnabled(true);
				//textFieldBuscarAlumno.setText(String.valueOf(tablaAlumnos.getSelectedRow()));
				dniAlumnoTabla = tablaAlumnos.getValueAt(tablaAlumnos.getSelectedRow(),1).toString();
				//textFieldBuscarAlumno.setText(algo);
			}
		});
		scrollPane.setViewportView(tablaAlumnos);
		tablaAlumnos.setToolTipText("");
		tablaAlumnos.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormAlta window = new FormAlta();
				window.frmAlta.setVisible(true);
			}
		});
		
		btnNuevo.setBounds(505, 111, 104, 23);
		panel.add(btnNuevo);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(30, 11, 633, 34);
		frmMenu.getContentPane().add(menuBar);
		
		JMenu mnMen = new JMenu("Men\u00FA");
		menuBar.add(mnMen);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(frmMenu, "¿Quieres salir de la aplicación?", "" ,JOptionPane.OK_CANCEL_OPTION) == JOptionPane.YES_OPTION) 
				System.exit(-1);
			}
		});
		mnMen.add(mntmSalir);
	}
	
	@SuppressWarnings("unused")
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
	
}
