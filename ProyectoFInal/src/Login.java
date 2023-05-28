import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 295);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(40, 40, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setBounds(40, 100, 56, 14);
		contentPane.add(lblNewLabel_1);
		
		txtUser = new JTextField();
		txtUser.setBounds(135, 37, 109, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(135, 97, 109, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnLogin = new JButton("Acceder");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user;		//Variable de Usuario
				String password;	//Variable de Contraseña
				
				//Obtenemos los datos del usuario
				user = txtUser.getText();	
				password = txtPassword.getText();
				
				//Compara los datos del introducidos con los que deben de ser para acceder
				if(user.equals("Sebas")&&(password.equals("1234")))
				{	
					//Si los datos son correctos envia un mensaje de confirmacion
					JOptionPane.showMessageDialog(null, "Inicio de Sesion exitoso");
				
				}
				else
				{
					//Si el usuario se equivoca o no introduce bien los datos
					JOptionPane.showMessageDialog( null, "Usuario o Contraseña Incorrecto"); 
				}
					
				}
				
			
		});
		btnLogin.setBounds(94, 192, 89, 23);
		contentPane.add(btnLogin);
	}
}
