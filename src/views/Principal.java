package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.BevelBorder;

public class Principal {

	public JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "Usuario", "Contrase\u00F1a", "Status"},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(40, 68, 332, 136);
		frame.getContentPane().add(table);
		
		JLabel lblTodoOk = new JLabel("Todo OK!");
		lblTodoOk.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTodoOk.setBounds(10, 11, 121, 14);
		frame.getContentPane().add(lblTodoOk);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
