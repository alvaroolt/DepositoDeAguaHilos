import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejecutable {

	private JFrame frame;
	JLabel lblDeposito1;
	
	Deposito d1 = new Deposito(100, 49);
	Deposito d2 = new Deposito(100, 51);
	Llenar l1 = new Llenar(d1);
	Llenar l2 = new Llenar(d2);
	Vaciar v1 = new Vaciar(d1);
	Vaciar v2 = new Vaciar(d2);

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
		
		JButton btnLlenar1 = new JButton("Llenar");
		btnLlenar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				l1.start();
				lblDeposito1.setText(d1.getCapacidad() + "%");
			}
		});
		btnLlenar1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLlenar1.setBounds(82, 183, 91, 31);
		frame.getContentPane().add(btnLlenar1);
		
		JButton btnLlenar2 = new JButton("Llenar");
		btnLlenar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				l1.start();
				lblDeposito1.setText(d1.getCapacidad() + "%");
			}
		});
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
		
		lblDeposito1 = new JLabel(d1.getCapacidad() + "%");
		lblDeposito1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeposito1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblDeposito1.setBounds(78, 65, 102, 107);
		frame.getContentPane().add(lblDeposito1);
		
		JLabel lblDeposito2 = new JLabel("50%");
		lblDeposito2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeposito2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblDeposito2.setBounds(332, 65, 102, 107);
		frame.getContentPane().add(lblDeposito2);
	}
}
