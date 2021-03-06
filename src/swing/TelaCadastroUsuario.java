package swing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Pessoa;

import javax.swing.JPasswordField;

public class TelaCadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNome;
	private JLabel lblPreco;
	private JButton button;
	private JLabel lblmsg;
	private JPasswordField passwordField;
	private JLabel label;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					TelaCadastroProduto frame = new TelaCadastroProduto();
	//					frame.setVisible(true);
	//				} catch (Exception e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		});
	//	}

	/**
	 * Create the frame.
	 */
	public TelaCadastroUsuario() {
		setTitle("Cadastrar Usuario");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 304, 214);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(72, 11, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(72, 36, 86, 20);
		contentPane.add(passwordField);
				
		textField_1 = new JTextField();
		textField_1.setBounds(72, 63, 139, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		label = new JLabel("Email");
		label.setBounds(10, 65, 66, 15);
		contentPane.add(label);		

		lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 14, 46, 14);
		contentPane.add(lblNome);

		lblPreco = new JLabel("Senha");
		lblPreco.setBounds(10, 39, 46, 14);
		contentPane.add(lblPreco);

		lblmsg = new JLabel("");
		lblmsg.setBounds(10, 101, 273, 14);
		contentPane.add(lblmsg);

		button = new JButton("Cadastrar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(textField.getText().isEmpty() )
						lblmsg.setText("campo vazio");
					else {
						String nome = textField.getText();
						String email = textField_1.getText();
						String senha = new String( passwordField.getPassword() );
						Pessoa usuario = Fachada.cadastrarPessoa(email,senha,nome);
						lblmsg.setText("cadastrou: "+usuario.getEmail());
						textField.setText("");
						passwordField.setText("");
						textField.requestFocus();
						textField_1.setText("");
					}
				}
				catch(Exception erro){
					lblmsg.setText(erro.getMessage());
				}
			}
		});
		button.setBounds(90, 149, 115, 23);
		contentPane.add(button);
		
		
	}
}
