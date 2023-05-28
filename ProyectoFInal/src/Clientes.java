import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//Estamos heredando el formulario padre
public class Clientes extends abcPadre {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes frame = new Clientes("");
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
	public Clientes(String nombre) {
		super("Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}
	//Polimorfismo
	@Override
	public void Agregar(ActionEvent e) {
		 if (e.getSource() == btnAgregar) //Permite identificar que elemento del formulario disparó el evento
	        {
	            try
	            {
	                String strSQL = "INSERT INTO Clientes (clave,nombre) VALUES ('" + txtID.getText() + "','" + txtNombre.getText() + "')";
	                Statement stmt = con.createStatement(); //Declaración de variable y preparación de sentencia SQL
	                int rowsEffected = stmt.executeUpdate(strSQL); //Es el que dispara la sentencia SQL contra la base de datos
	                JOptionPane.showMessageDialog(null,rowsEffected + " rows effected");
	            } catch (SQLException ex) {
	                JOptionPane.showMessageDialog(null,"Error al conectarse con la bd: " + ex.toString());
	            }
	        }
	}
}
