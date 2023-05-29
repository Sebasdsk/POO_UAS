import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.sql.*;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.awt.event.ActionEvent;


public class abcPadre extends JFrame {

	private JPanel contentPane;
	public JTextField txtID;
	public JTextField txtNombre;
	public JButton btnAgregar;
	public JButton btnBorrar;
	public JButton btnModificar;
	public JButton btnConsultar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					abcPadre frame = new abcPadre("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Connection con;
	private JButton btnNewButton;

	//Constructor que recibe el parametro del string para poner nombre a los formularios abc
	public abcPadre(String nombre) {
		
		//ABRIR CONEXION CON BASE DE DATOS (INICIALIZACION DE CONEXION CON BD)
        try {
            //Crea la conexion con la base de datos
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Carga el driver de sql server en memoria
            String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Lavanderia;user=sebas;password=1234"; //Crea la cadena de conexión
            con = DriverManager.getConnection(connectionUrl); //Abre la conexion
            JOptionPane.showMessageDialog(null,"La conexion se llevo a cabo con exito :P");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al conectarse con la bd: "+ e.toString());
        } catch (ClassNotFoundException cE) {
            JOptionPane.showMessageDialog(null,"Class Not Found Exception: "+ cE.toString());
        }
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modificar(e);
			}
		});
		btnModificar.setBounds(423, 297, 89, 23);
		contentPane.add(btnModificar);
		
		//Boton Agregar
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Agregar(e);
				 
			}
		});
		btnAgregar.setBounds(30, 297, 89, 23);
		contentPane.add(btnAgregar);
		
		// Method to handle the 'Agregar' button action
		
	
		
		 btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Borrar(e);
			}
		});
		btnBorrar.setBounds(161, 297, 89, 23);
		contentPane.add(btnBorrar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consultar(e);
			}
		});
		btnConsultar.setBounds(292, 297, 89, 23);
		contentPane.add(btnConsultar);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(30, 56, 55, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(335, 56, 89, 23);
		contentPane.add(lblNewLabel_1);
		
		txtID = new JTextField();
		txtID.setBounds(33, 92, 86, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(335, 90, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("algo");
		lblNombre.setBounds(203, 11, 46, 14);
		contentPane.add(lblNombre);
		
		//Etiqueta que se va estar cambiando de nombre con el parametro que reciba el constructor
		lblNombre.setText(nombre);
		
		btnNewButton = new JButton("Regresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu();
				m.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(446, 408, 85, 21);
		contentPane.add(btnNewButton);
		       
	}

	//Metodos que se van a implementar en sus respectivas clases con polimorfismo
	public void Agregar(ActionEvent e) {}
	public void Modificar(ActionEvent e){}
	public void Consultar(ActionEvent e){}
	public void Borrar(ActionEvent e){}
	
	
}
