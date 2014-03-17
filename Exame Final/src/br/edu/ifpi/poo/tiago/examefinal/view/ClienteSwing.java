package br.edu.ifpi.poo.tiago.examefinal.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import br.edu.ifpi.poo.tiago.examefinal.model.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClienteSwing extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txfNome;
	private JTextField txfCpf;
	private JTextField txfEndereco;
	private JTextField txfTelefone;
	private JTextField txfProfissao;
	private JTextField txfIdade;
	Cliente cliente;
	Dados dados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteSwing frame = new ClienteSwing();
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
	public ClienteSwing() {
		setTitle("Gerenciador de Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cadastro de Cliente");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel.setBounds(119, 11, 158, 14);
		contentPane.add(lblNewLabel);

		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(24, 43, 46, 14);
		contentPane.add(lblCdigo);

		textField = new JTextField();
		textField.setBounds(109, 40, 106, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(24, 82, 46, 14);
		contentPane.add(lblNome);

		JLabel lblCpf = new JLabel("Cpf");
		lblCpf.setBounds(24, 114, 46, 14);
		contentPane.add(lblCpf);

		JLabel lblEndereco = new JLabel("Endereco:");
		lblEndereco.setBounds(24, 139, 46, 14);
		contentPane.add(lblEndereco);

		JLabel lblTelefone = new JLabel("Telefone :");
		lblTelefone.setBounds(24, 167, 46, 14);
		contentPane.add(lblTelefone);

		JLabel lblProfissao = new JLabel("Profissao :");
		lblProfissao.setBounds(10, 192, 89, 14);
		contentPane.add(lblProfissao);

		txfNome = new JTextField();
		txfNome.setBounds(109, 79, 86, 20);
		contentPane.add(txfNome);
		txfNome.setColumns(10);

		txfCpf = new JTextField();
		txfCpf.setBounds(109, 111, 86, 20);
		contentPane.add(txfCpf);
		txfCpf.setColumns(10);

		txfEndereco = new JTextField();
		txfEndereco.setBounds(109, 136, 86, 20);
		contentPane.add(txfEndereco);
		txfEndereco.setColumns(10);

		txfTelefone = new JTextField();
		txfTelefone.setBounds(109, 164, 86, 20);
		contentPane.add(txfTelefone);
		txfTelefone.setColumns(10);

		txfProfissao = new JTextField();
		txfProfissao.setBounds(109, 189, 86, 20);
		contentPane.add(txfProfissao);
		txfProfissao.setColumns(10);

		txfIdade = new JTextField();
		txfIdade.setBounds(109, 226, 86, 20);
		contentPane.add(txfIdade);
		txfIdade.setColumns(10);

		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cliente = new Cliente(txfNome.getText(), new Dados(txfCpf
						.getText(), txfEndereco.getText(), txfTelefone.getText(),
						txfProfissao.getText(), txfIdade.getText()));

			}
		});
		btnNovo.setBounds(48, 320, 89, 23);
		contentPane.add(btnNovo);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvar.setBounds(171, 320, 89, 23);
		contentPane.add(btnSalvar);

		JButton btnApagar = new JButton("Apagar");
		btnApagar.setBounds(287, 320, 89, 23);
		contentPane.add(btnApagar);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConsultar.setBounds(287, 39, 89, 23);
		contentPane.add(btnConsultar);

		JLabel lblComplemento = new JLabel("Complemento :");
		lblComplemento.setBounds(24, 229, 75, 14);
		contentPane.add(lblComplemento);
	}
}
