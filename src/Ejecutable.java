import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Ejecutable {

	private JFrame frame;
	private JTextField textFieldCapacity1;
	private JTextField textFieldCapacity2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejecutable window = new Ejecutable();
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
	public Ejecutable() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 528, 347);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textFieldCapacity1 = new JTextField();
		textFieldCapacity1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCapacity1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textFieldCapacity1.setText("50%");
		textFieldCapacity1.setBounds(67, 31, 124, 142);
		frame.getContentPane().add(textFieldCapacity1);
		textFieldCapacity1.setColumns(10);
		
		textFieldCapacity2 = new JTextField();
		textFieldCapacity2.setText("50%");
		textFieldCapacity2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCapacity2.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textFieldCapacity2.setColumns(10);
		textFieldCapacity2.setBounds(321, 31, 124, 142);
		frame.getContentPane().add(textFieldCapacity2);
		
		JButton btnLlenar1 = new JButton("Llenar");
		btnLlenar1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLlenar1.setBounds(82, 183, 91, 31);
		frame.getContentPane().add(btnLlenar1);
		
		JButton btnLlenar2 = new JButton("Llenar");
		btnLlenar2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLlenar2.setBounds(336, 183, 91, 31);
		frame.getContentPane().add(btnLlenar2);
		
		JButton btnDetener = new JButton("Detener");
		btnDetener.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDetener.setBounds(209, 225, 97, 31);
		frame.getContentPane().add(btnDetener);
		
		JButton btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnReiniciar.setBounds(407, 269, 97, 31);
		frame.getContentPane().add(btnReiniciar);
		
		JLabel lblImage = new JLabel("Image");
		lblImage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblImage.setBounds(232, 95, 45, 13);
		frame.getContentPane().add(lblImage);
	}
}
