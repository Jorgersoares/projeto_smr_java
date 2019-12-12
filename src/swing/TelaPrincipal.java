package swing;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programa��o Orientada a Objetos
 * Prof. Fausto Maranh�o Ayres
 **********************************/

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import aplicacao_console.TesteConsole;
import fachada.Fachada;

public class TelaPrincipal {
	private JFrame frame;
	private JLabel label;
	private JMenu mnUsuario;
	private JMenuItem menuItem;
	private JMenuItem menuItem_1;
	private JMenuItem menuItem_2;
	private JMenuItem menuItem_3;
	private JMenu mnMensagem;
	private JMenuItem mnEnviar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
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
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("SMR");

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				try{
					//  pre-cadastro
					TesteConsole teste = new TesteConsole();
					teste.cadastrar();
					//nenhum usuario esta logado
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			@Override
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(null, "at� breve !");
			}
		});

		frame.setBounds(100, 100, 384, 271);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/*
		//imagem de fundo
		label = new JLabel("");
		label.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		ImageIcon imagem = new ImageIcon(getClass().getResource("/imagens/imagem1.jpg"));
		imagem = new ImageIcon(imagem.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(imagem);
		frame.getContentPane().add(label);
		frame.setResizable(false);
		*/

		//-------------BARRA DE MENU-----------------------------------
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		//-------------MENU-----------------------------------
		mnMensagem = new JMenu("Opções Mensagem");
		menuBar.add(mnMensagem);

		mnEnviar = new JMenuItem("Enviar nova mensagem");
		mnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Fachada.getLogado()==null)
					JOptionPane.showMessageDialog(frame, "voce precisa se logar");
				
				else {
					TelaCadastroProduto j = new TelaCadastroProduto();
					j.setVisible(true);
				}
			}
		});
		mnMensagem.add(mnEnviar);

		
		//-------------MENU-----------------------------------
		JMenu mnConsulta = new JMenu("Consulta");
		menuBar.add(mnConsulta);
		mnConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				TelaConsulta j = new TelaConsulta();
				j.setVisible(true);
			}
		});

		//-------------MENU-----------------------------------
		mnUsuario = new JMenu("Usuario");
		menuBar.add(mnUsuario);

		menuItem = new JMenuItem("Login");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaLogin j = new TelaLogin();
				j.setVisible(true);
			}
		});
		mnUsuario.add(menuItem);

		menuItem_1 = new JMenuItem("Logoff");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaLogin j = new TelaLogin();
				j.setVisible(true);
			}
		});
		mnUsuario.add(menuItem_1);

		menuItem_2 = new JMenuItem("Cadastrar");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroUsuario j = new TelaCadastroUsuario();
				j.setVisible(true);
			}
		});
		mnUsuario.add(menuItem_2);

		menuItem_3 = new JMenuItem("Listar");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListagem j = new TelaListagem();
				j.setVisible(true);
			}
		});
		mnUsuario.add(menuItem_3);


	}
}
