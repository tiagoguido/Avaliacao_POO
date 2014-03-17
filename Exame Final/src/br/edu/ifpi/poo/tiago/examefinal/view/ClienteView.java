package br.edu.ifpi.poo.tiago.examefinal.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import br.edu.ifpi.poo.tiago.examefinal.dao.ClienteJPADAO;
import br.edu.ifpi.poo.tiago.examefinal.model.Cliente;
import br.edu.ifpi.poo.tiago.examefinal.model.Dados;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClienteView extends JFrame {

	private JPanel contentPane;
	private JTextField txfCodigo;
	private JTextField txfNome;
	private JTextField txfCpf;
	private JTextField txfEndereco;
	private JTextField txfTelefone;
	private JTextField txfProfissao;
	private JTextField txfIdade;
	private ClienteJPADAO clienteDAO = new ClienteJPADAO();
	private JButton btnSalvar;
	private JButton btnNovo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteView frame = new ClienteView();
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
	public ClienteView() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				clienteDAO.open();
			}
			@Override
			public void windowClosed(WindowEvent e) {
				clienteDAO.close();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cadastro de Clientes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(105, 22, 147, 14);
		contentPane.add(lblNewLabel);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(25, 76, 46, 14);
		contentPane.add(lblCodigo);

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(25, 101, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setBounds(25, 126, 46, 14);
		contentPane.add(lblCpf);
		

		JLabel lblEndereco = new JLabel("Endereco:");
		lblEndereco.setBounds(25, 151, 46, 14);
		contentPane.add(lblEndereco);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(25, 176, 46, 14);
		contentPane.add(lblTelefone);

		JLabel lblProfissao = new JLabel("Profissao:");
		lblProfissao.setBounds(25, 201, 64, 14);
		contentPane.add(lblProfissao);

		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(25, 226, 74, 14);
		contentPane.add(lblIdade);

		txfCodigo = new JTextField();
		txfCodigo.setBounds(81, 77, 86, 20);
		contentPane.add(txfCodigo);
		txfCodigo.setColumns(10);

		txfNome = new JTextField();
		txfNome.setEnabled(false);
		txfNome.setBounds(81, 105, 225, 20);
		contentPane.add(txfNome);
		txfNome.setColumns(10);

		txfCpf = new JTextField();
		txfCpf.setEnabled(false);
		txfCpf.setBounds(81, 127, 139, 20);
		contentPane.add(txfCpf);
		txfCpf.setColumns(10);

		txfEndereco = new JTextField();
		txfEndereco.setEnabled(false);
		txfEndereco.setBounds(81, 152, 225, 20);
		contentPane.add(txfEndereco);
		txfEndereco.setColumns(10);

		txfTelefone = new JTextField();
		txfTelefone.setEnabled(false);
		txfTelefone.setBounds(81, 177, 225, 20);
		contentPane.add(txfTelefone);
		txfTelefone.setColumns(10);

		txfProfissao = new JTextField();
		txfProfissao.setEnabled(false);
		txfProfissao.setBounds(104, 202, 202, 20);
		contentPane.add(txfProfissao);
		txfProfissao.setColumns(10);

		txfIdade = new JTextField();
		txfIdade.setEnabled(false);
		txfIdade.setBounds(114, 227, 132, 20);
		contentPane.add(txfIdade);
		txfIdade.setColumns(10);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String codigo = txfCodigo.getText();
				if (codigo.isEmpty()) {
					JOptionPane
							.showMessageDialog(
									null,
									"Campo Código está vazio!");

					return;
				}
				Long id;
				try{
					id = Long.parseLong(codigo);
				}catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(null, "Numero em formato incorreto");
					return;
				}
				
				Cliente cliente = clienteDAO.pesquisar(id);
				if(cliente == null){
					JOptionPane.showMessageDialog(null, "Cliente não cadastrado");
					return;
				}
				txfNome.setText(cliente.getNome());
				txfCpf.setText(cliente.getDados().getCpf());
				txfEndereco.setText(cliente.getDados().getEndereco());
				txfTelefone.setText(cliente.getDados().getTelefone());
				txfProfissao.setText(cliente.getDados().getProfissao());
				txfIdade.setText(cliente.getDados().getIdade());
				
				habilitarDesabilitar(true);
				btnSalvar.setEnabled(true);
			}
		});
		btnConsultar.setBounds(200, 76, 89, 23);
		contentPane.add(btnConsultar);

		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				habilitarDesabilitar(true);			
			}
		});
		btnNovo.setBounds(49, 251, 89, 23);
		contentPane.add(btnNovo);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setFocusCycleRoot(true);
		btnSalvar.setEnabled(false);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Long codigo = null;
				
				try{
					codigo = Long.parseLong(txfCodigo.getText());
				}catch(NumberFormatException ex){
					
				}
								
				String nome = txfNome.getText();
				String cpf = txfCpf.getText();
				String endereco = txfEndereco.getText();
				String telefone = txfTelefone.getText();
				String profissao = txfProfissao.getText();
				String idade = txfIdade.getText();

				Dados dados = new Dados(cpf, endereco, telefone,
						profissao, idade);
				Cliente cliente;
				if(codigo != null){
					cliente = new Cliente(codigo, nome, dados);					
					clienteDAO.atualizar(cliente);
					JOptionPane.showMessageDialog(null, "Cliente " + cliente.getNome() + " atualizado");;
				}else{
					cliente = new Cliente(nome, dados);
					clienteDAO.salvar(cliente);
					JOptionPane.showMessageDialog(null, "Cliente " + cliente.getNome() + " cadastrado");;
				}
				habilitarDesabilitar(false);
				
				clienteDAO.commit();

			}
		});
		btnSalvar.setBounds(148, 251, 89, 23);
		contentPane.add(btnSalvar);

		JButton btnApagar = new JButton("Apagar");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Long cod = Long.parseLong(txfCodigo.getText());
				Cliente cliente = clienteDAO.pesquisar(cod);
				if(cliente == null){
					JOptionPane.showMessageDialog(null, "Não existente!");
					return;
				}
				clienteDAO.remover(cliente);
			}
		});
		btnApagar.setBounds(247, 251, 89, 23);
		contentPane.add(btnApagar);
	}

	public void habilitarDesabilitar(boolean codigo) {
		txfCodigo.setEnabled(!codigo);
		txfNome.setEnabled(codigo);
		txfCpf.setEnabled(codigo);
		txfEndereco.setEnabled(codigo);
		txfTelefone.setEnabled(codigo);
		txfProfissao.setEnabled(codigo);
		txfIdade.setEnabled(codigo);
		btnNovo.setEnabled(!codigo);
		btnSalvar.setEnabled(codigo);
	}
}
