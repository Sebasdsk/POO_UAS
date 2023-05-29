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

public class Proveedores extends abcPadre {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proveedores frame = new Proveedores("");
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
	public Proveedores(String nombre) {
		super("Proveedores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
	}

	//Polimorfismo
	@Override
	public void Agregar(ActionEvent e) {
		 if (e.getSource() == btnAgregar) //Permite identificar que elemento del formulario disparó el evento
	        {
	            try
	            {
	                String strSQL = "INSERT INTO Proveedores (Id,Nombre) VALUES ('" + txtID.getText() + "','" + txtNombre.getText() + "')";
	                Statement stmt = con.createStatement(); //Declaración de variable y preparación de sentencia SQL
	                int rowsEffected = stmt.executeUpdate(strSQL); //Es el que dispara la sentencia SQL contra la base de datos
	                JOptionPane.showMessageDialog(null,rowsEffected + " rows effected");
	            } catch (SQLException ex) {
	                JOptionPane.showMessageDialog(null,"Error al conectarse con la bd: " + ex.toString());
	            }
	        }
	} 


        @Override
    	public void Modificar(ActionEvent e){ 
         if (e.getSource() == btnModificar)
		 {   
			 try
			 {
		 String strSQL = "UPDATE Proveedores SET Nombre = '" + txtNombre.getText() + "' where ID = '" + txtID.getText() + "'";
                Statement stmt = con.createStatement(); //Declaración de variable y preparación de sentencia SQL
                int rowsEffected = stmt.executeUpdate(strSQL);
                JOptionPane.showMessageDialog(null,rowsEffected + " Linea Modificada");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Error al conectarse con la bd: "+ ex.toString());
            }
        }
    }

	 @Override
     public void Consultar(ActionEvent e){
         if (e.getSource() == btnConsultar) //Varia un poco
        {
            try
            {
                String SQL = "SELECT * FROM Proveedores where ID ='" + txtID.getText() + "'"; //Texto de sentencia SQL (query)
                Statement stmt = con.createStatement(); //Declaración de variable y preparación de sentencia SQL
                ResultSet rs = stmt.executeQuery(SQL); //Declaración de variable para guardar resultados de sentencia SQL y ejecución
                rs.next(); //Accede (se posiciona) a la tupla en el resultset después de ejecutar el select contra la base de datos (de manera inicial no se puede acceder hasta llamar a "next"
                txtNombre.setText(rs.getString("Nombre")); //Toma el valor del campo "nombre" y se muestra en el textbox correspondiente
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Error al conectarse con la bd: "+ ex.toString());
            }
        }
     }

	 @Override
      public void Borrar(ActionEvent e){
            if (e.getSource() == btnBorrar) //Lo mismo que el anterior
        {
            try
            {
                String strSQL = "DELETE from Proveedores where ID = '" + txtID.getText() + "'";
                Statement stmt = con.createStatement(); //Declaración de variable y preparación de sentencia SQL
                int rowsEffected = stmt.executeUpdate(strSQL);
                JOptionPane.showMessageDialog(null,rowsEffected + "Linea Borrada");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Error al conectarse con la bd: "+ ex.toString());
            }
        }
      }
}
