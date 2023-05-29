import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
	    setBounds(100, 100, 555, 429);
	    contentPane = (JPanel) getContentPane();
	    contentPane.setLayout(new BorderLayout());
	    
	}
	   
	//Polimorfismo
	@Override
	public void Agregar(ActionEvent e) {
		 if (e.getSource() == btnAgregar) //Permite identificar que elemento del formulario disparó el evento
	        {
	            try
	            {
	                String strSQL = "INSERT INTO Clientes (Id,Nombre) VALUES ('" + txtID.getText() + "','" + txtNombre.getText() + "')";
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
		 String strSQL = "UPDATE Clientes SET Nombre = '" + txtNombre.getText() + "' where Id = '" + txtID.getText() + "'";
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
                String SQL = "SELECT * FROM Clientes where Id ='" + txtID.getText() + "'"; //Texto de sentencia SQL (query)
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
                String strSQL = "DELETE from Clientes where Id = '" + txtID.getText() + "'";
                Statement stmt = con.createStatement(); //Declaración de variable y preparación de sentencia SQL
                int rowsEffected = stmt.executeUpdate(strSQL);
                JOptionPane.showMessageDialog(null,rowsEffected + "Linea Borrada");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Error al conectarse con la bd: "+ ex.toString());
            }
        }
      }
}
