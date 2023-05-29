import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	
	Clientes clientes = new Clientes(null);
	Empleados ep = new Empleados(null);
	Finanzas f = new Finanzas(null);
	Proveedores p = new Proveedores(null);
	Inventario iv = new Inventario(null);
	
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setBounds(294, 34, 45, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientes.setVisible(true);
				dispose();
			}
		});
		btnClientes.setBounds(63, 114, 95, 59);
		contentPane.add(btnClientes);
		
		JButton btnFinanzas = new JButton("Finanzas");
		btnFinanzas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(true);
				dispose();
			}
		});
		btnFinanzas.setBounds(63, 318, 95, 59);
		contentPane.add(btnFinanzas);
		
		JButton btnEmpleados = new JButton("Empleados");
		btnEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ep.setVisible(true);
				dispose();
			}
		});
		btnEmpleados.setBounds(447, 114, 95, 59);
		contentPane.add(btnEmpleados);
		
		JButton btnProvedores = new JButton("Proveedores");
		btnProvedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.setVisible(true);
				dispose();
			}
		});
		btnProvedores.setBounds(447, 318, 95, 59);
		contentPane.add(btnProvedores);
		
		JButton btnInventario = new JButton("Inventario");
		btnInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iv.setVisible(true);
				dispose();
			}
		});
		btnInventario.setBounds(250, 220, 113, 45);
		contentPane.add(btnInventario);
	}
}
