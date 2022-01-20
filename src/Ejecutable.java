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
	JLabel lblDeposito2;
	JButton btnLlenar1;
	JButton btnLlenar2;

	Deposito d1 = new Deposito(100, 70);
	Deposito d2 = new Deposito(100, 30);
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
//		l1.start();
//		v2.start();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 528, 347);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnLlenar1 = new JButton("Llenar");
		btnLlenar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				l1.getSuspendido().setSuspendido(false);
//				v2.getSuspendido().setSuspendido(false);
//				l2.getSuspendido().setSuspendido(true);
//				v1.getSuspendido().setSuspendido(true);
//				l1.start();
//				v2.start();
//				lblDeposito1.setText(d1.getCapacidad() + "%");

				if (d1.getCapacidad() == d1.getCapacidadMax()) {
					estadoBoton(btnLlenar1, false, "Lleno", 10);
				} else {
					if (!l1.isAlive() && !v2.isAlive()) {
						l1.start();
						v2.start();
					}
					l1.getSuspendido().setSuspendido(false);
					v2.getSuspendido().setSuspendido(false);

					estadoBoton(btnLlenar1, false, "Llenando", 10);
					estadoBoton(btnLlenar2, false, "Vaciándose", 9);

//					l1.getSuspendido().setSuspendido(false);
//					v2.getSuspendido().setSuspendido(false);

					if (!btnLlenar2.isEnabled()) {
						estadoBoton(btnLlenar2, true, "Llenar", 14);
					}
				}

			}
		});
		btnLlenar1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLlenar1.setBounds(82, 183, 91, 31);
		frame.getContentPane().add(btnLlenar1);

		btnLlenar2 = new JButton("Llenar");
		btnLlenar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				l2.getSuspendido().setSuspendido(false);
//				v1.getSuspendido().setSuspendido(false);
//				l1.getSuspendido().setSuspendido(true);
//				v2.getSuspendido().setSuspendido(true);
//				l2.start();
//				v1.start();
				if (d2.getCapacidad() == d2.getCapacidadMax()) {
					estadoBoton(btnLlenar2, false, "Lleno", 10);
				} else {
					if (!l2.isAlive() && !v1.isAlive()) {
						l2.start();
						v1.start();
					}
					l2.getSuspendido().setSuspendido(false);
					v1.getSuspendido().setSuspendido(false);

					estadoBoton(btnLlenar2, false, "Llenando", 10);
					estadoBoton(btnLlenar1, false, "Vaciandose", 9);
					

					if (!btnLlenar1.isEnabled()) {
						estadoBoton(btnLlenar1, true, "Llenar", 14);
					}
				}
			}
		});
		btnLlenar2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLlenar2.setBounds(336, 183, 91, 31);
		frame.getContentPane().add(btnLlenar2);

		JButton btnDetener = new JButton("Detener");
		btnDetener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				l1.getSuspendido().setSuspendido(true);
				l2.getSuspendido().setSuspendido(true);
				v1.getSuspendido().setSuspendido(true);
				v2.getSuspendido().setSuspendido(true);

				estadoBoton(btnLlenar1, true, "Llenar", 14);
				estadoBoton(btnLlenar2, true, "Llenar", 14);
				lblDeposito1.setText(d1.getCapacidad() + "%");
				lblDeposito2.setText(d2.getCapacidad() + "%");
				System.out.println("Proceso detenido");

			}
		});
		btnDetener.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDetener.setBounds(209, 225, 97, 31);
		frame.getContentPane().add(btnDetener);

		JButton btnReiniciar = new JButton("Finalizar");
		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnReiniciar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnReiniciar.setBounds(407, 269, 97, 31);
		frame.getContentPane().add(btnReiniciar);

		lblDeposito1 = new JLabel(d1.getCapacidad() + "%");
		lblDeposito1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeposito1.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblDeposito1.setBounds(78, 65, 102, 107);
		frame.getContentPane().add(lblDeposito1);

		lblDeposito2 = new JLabel(d2.getCapacidad() + "%");
		lblDeposito2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeposito2.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblDeposito2.setBounds(332, 65, 102, 107);
		frame.getContentPane().add(lblDeposito2);
	}

	public void estadoBoton(JButton button, boolean activo, String texto, int tamano) {
		button.setEnabled(activo);
		button.setText(texto);
		button.setFont(new Font("Verdana", Font.BOLD, tamano));
	}
}