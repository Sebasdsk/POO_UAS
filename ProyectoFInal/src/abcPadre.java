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
import java.awt.event.ActionEvent;


public class abcPadre extends JFrame {

	private JPanel contentPane;
	public JTextField txtID;
	public JTextField txtNombre;
	public JButton btnAgregar;

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

	//Constructor que recibe el parametro del string para poner nombre a los formularios abc
	public abcPadre(String nombre) {
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(423, 297, 89, 23);
		contentPane.add(btnModificar);
		
		//Boton Agregar
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Agregar(ActionEvent e);
				 
			}
		});
		btnAgregar.setBounds(30, 297, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(161, 297, 89, 23);
		contentPane.add(btnBorrar);
		
		JButton btnConsultar = new JButton("Consultar");
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
		
		 //ABRIR CONEXION CON BASE DE DATOS (INICIALIZACION DE CONEXION CON BD)
        try {
            //Crea la conexi�n con la base de datos
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Carga el driver de sql server en memoria
            String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Lavanderia;user=sebas;password=1234"; //Crea la cadena de conexión
            con = DriverManager.getConnection(connectionUrl); //Abre la conexi�n
            JOptionPane.showMessageDialog(null,"La conexi�n se llevo a cabo con �xito :P");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al conectarse con la bd: "+ e.toString());
        } catch (ClassNotFoundException cE) {
            JOptionPane.showMessageDialog(null,"Class Not Found Exception: "+ cE.toString());
        }
        
	}
	
		
}
