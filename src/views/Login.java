package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import config.Conexion;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frmAccesoADatos;
	private JTextField txtUsuario;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmAccesoADatos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAccesoADatos = new JFrame();
		frmAccesoADatos.getContentPane().setBackground(Color.ORANGE);
		frmAccesoADatos.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.DARK_GRAY);
		lblNombre.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblNombre.setBounds(92, 59, 55, 14);
		frmAccesoADatos.getContentPane().add(lblNombre);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(Color.DARK_GRAY);
		lblContrasea.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblContrasea.setBounds(92, 113, 78, 14);
		frmAccesoADatos.getContentPane().add(lblContrasea);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		txtUsuario.setBounds(221, 58, 134, 20);
		frmAccesoADatos.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		txtPassword.setColumns(10);
		txtPassword.setBounds(221, 112, 134, 20);
		frmAccesoADatos.getContentPane().add(txtPassword);
		
		JButton btnLogin = new JButton("ACCEDER");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				acceder();
			}
		});
		btnLogin.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		btnLogin.setBounds(120, 175, 197, 45);
		frmAccesoADatos.getContentPane().add(btnLogin);
		frmAccesoADatos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccesoADatos.setTitle("Acceso a Datos");
		frmAccesoADatos.setBounds(100, 100, 450, 300);
	}
	
	private void acceder()
	{
		Connection conn = new Conexion().conectar();

		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM user WHERE username=? AND password=?");
			ps.setString(1, txtUsuario.getText());
			ps.setString(2, txtPassword.getText());
			
			ResultSet rs = ps.executeQuery(); // Ejecutar la select
			if(rs.next())
			{
				Principal p = new Principal();
				p.frame.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "Error de Login");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}//Cierra clase
