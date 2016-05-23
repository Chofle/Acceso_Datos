package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;

public class FormMatriculas {

	JFrame frmMatriculas;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormMatriculas window = new FormMatriculas();
					window.frmMatriculas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormMatriculas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMatriculas = new JFrame();
		frmMatriculas.setResizable(false);
		frmMatriculas.getContentPane().setBackground(SystemColor.menu);
		frmMatriculas.setTitle("Matr\u00EDculas");
		frmMatriculas.setBounds(100, 100, 590, 391);
		frmMatriculas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMatriculas.getContentPane().setLayout(null);
		
		JLabel lblCiclos = new JLabel("Elegir ciclo formativo:");
		lblCiclos.setBounds(31, 32, 128, 14);
		frmMatriculas.getContentPane().add(lblCiclos);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(180, 29, 374, 20);
		frmMatriculas.getContentPane().add(comboBox);
		
		JLabel lblListadoDeMdulos = new JLabel("Listado de M\u00F3dulos a matricular:");
		lblListadoDeMdulos.setBounds(31, 81, 242, 14);
		frmMatriculas.getContentPane().add(lblListadoDeMdulos);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table.setBounds(31, 118, 523, 165);
		frmMatriculas.getContentPane().add(table);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(167, 311, 89, 23);
		frmMatriculas.getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(324, 311, 89, 23);
		frmMatriculas.getContentPane().add(btnCancelar);
	}
}
