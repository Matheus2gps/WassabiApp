package com.treinamentonetbiis.wassabi.frontend;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JTable;
import java.awt.Label;
import java.awt.Panel;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.ClientFactory;
import com.treinamentonetbiis.wassabi.*;

import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;

public class WassabiHome extends JFrame {
	private JTable tabela_produtos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WassabiHome frame = new WassabiHome();
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
	public WassabiHome() {
		setResizable(false);
		setTitle("Wassabi App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 755, 434);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel pagina_inicial = new JPanel();
		pagina_inicial.setBounds(0, 22, 739, 373);
		panel.add(pagina_inicial);
		pagina_inicial.setLayout(null);
		
		JPanel lista_produtos = new JPanel();
		lista_produtos.setBackground(new Color(255, 255, 255));
		lista_produtos.setBounds(147, 42, 426, 290);
		pagina_inicial.add(lista_produtos);
		
		JButton btn_carrinho_compra = new JButton("");
		btn_carrinho_compra.setBounds(191, 224, 39, 32);
		btn_carrinho_compra.setIcon(new ImageIcon("C:\\Git\\WassabiApp\\Icones\\shopping-cart.png"));
		btn_carrinho_compra.setBackground(new Color(255, 255, 255));
		
		JPanel insere_clientes = new JPanel();
		insere_clientes.setLayout(null);
		insere_clientes.setBounds(147, 22, 426, 324);
		pagina_inicial.add(insere_clientes);
		
		JButton btn_confirma_cliente = new JButton("Confirmar");
		
		btn_confirma_cliente.setBackground(new Color(222, 220, 252));
		btn_confirma_cliente.setBounds(289, 290, 95, 23);
		insere_clientes.add(btn_confirma_cliente);
		
		JButton btnNewButton_2_1 = new JButton("Cancelar");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2_1.setBackground(new Color(231, 169, 175));
		btnNewButton_2_1.setBounds(22, 290, 89, 23);
		insere_clientes.add(btnNewButton_2_1);
		
		JPanel p_cadastra_cliente = new JPanel();
		p_cadastra_cliente.setBounds(0, 0, 426, 290);
		insere_clientes.add(p_cadastra_cliente);
		p_cadastra_cliente.setLayout(null);
		
		Label label = new Label("Nome");
		label.setFont(new Font("Arial", Font.BOLD, 12));
		label.setBounds(20, 51, 41, 22);
		p_cadastra_cliente.add(label);
		
		Label label_1 = new Label("Cadastro de Clientes");
		label_1.setAlignment(Label.CENTER);
		label_1.setFont(new Font("Arial", Font.BOLD, 12));
		label_1.setBounds(132, 10, 181, 22);
		p_cadastra_cliente.add(label_1);
		
		Label label_2 = new Label("__________________________________________________");
		label_2.setFont(new Font("Arial", Font.BOLD, 12));
		label_2.setBounds(44, 23, 337, 22);
		p_cadastra_cliente.add(label_2);
		
		JTextPane txt_nome = new JTextPane();
		
		txt_nome.setBounds(67, 51, 314, 20);
		p_cadastra_cliente.add(txt_nome);
		
		JTextPane txt_cpf = new JTextPane();
		
		txt_cpf.setBounds(67, 93, 314, 20);
		p_cadastra_cliente.add(txt_cpf);
		
		Label label_3 = new Label("CPF");
		label_3.setFont(new Font("Arial", Font.BOLD, 12));
		label_3.setBounds(20, 93, 41, 22);
		p_cadastra_cliente.add(label_3);
		
		JTextPane txt_telefone = new JTextPane();
		txt_telefone.setBounds(89, 142, 292, 20);
		p_cadastra_cliente.add(txt_telefone);
		
		Label label_3_1 = new Label("Telefone");
		label_3_1.setFont(new Font("Arial", Font.BOLD, 12));
		label_3_1.setBounds(20, 142, 63, 22);
		p_cadastra_cliente.add(label_3_1);
		
		Label label_3_1_1 = new Label("CEP");
		label_3_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		label_3_1_1.setBounds(20, 190, 41, 22);
		p_cadastra_cliente.add(label_3_1_1);
		
		JTextPane txt_cep = new JTextPane();
		txt_cep.setBounds(67, 190, 314, 20);
		p_cadastra_cliente.add(txt_cep);
		
		Label label_4 = new Label("X");
		
		
		label_4.setAlignment(Label.CENTER);
		label_4.setFont(new Font("Arial", Font.BOLD, 12));
		label_4.setBounds(391, 4, 35, 22);
		p_cadastra_cliente.add(label_4);
		
		JTextPane txt_endereco = new JTextPane();
		txt_endereco.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txt_endereco.setEditable(false);
		txt_endereco.setBounds(20, 221, 363, 58);
		p_cadastra_cliente.add(txt_endereco);
		
		//acao facilitadora do enter
		txt_nome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					txt_cpf.grabFocus();
				}
			}
		});
		txt_cpf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					txt_telefone.grabFocus();
				}
			}
		});
		txt_telefone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					txt_cep.grabFocus();
				}
			}
		});
		txt_cep.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					txt_endereco.setText(buscarCep(txt_cep.getText()));
					btn_confirma_cliente.grabFocus();
				}
			}
		});
		
		
		//fechar painel de cadastro de cliente
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				normalizar(insere_clientes, lista_produtos);
			}
		});
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				normalizar(insere_clientes, lista_produtos);
			}
		});
		
		
		//confirma cadastro de clientes
		btn_confirma_cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes cliente_ = new Clientes(txt_nome.getText(),txt_cpf.getText(),txt_telefone.getText(),(txt_endereco.getText().length() > 1)?txt_endereco.getText():"N�o encontrado");
				try {
					WassabiDAO.inserirClientes(cliente_);
					JOptionPane.showMessageDialog(null,"Cliente cadastrado com sucesso.");
					limpar_cliente(txt_nome, txt_cpf, txt_telefone, txt_cep, txt_endereco);
					normalizar(insere_clientes, lista_produtos);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}
		});
		
		//normalizar
		normalizar(insere_clientes, lista_produtos);
		
		JButton btn_slide_right = new JButton("");
		btn_slide_right.setBounds(377, 107, 39, 32);
		
		btn_slide_right.setIcon(new ImageIcon("C:\\Git\\WassabiApp\\next.png"));
		btn_slide_right.setFont(new Font("Arial", Font.BOLD, 12));
		
		JButton btn_slide_left = new JButton("");
		btn_slide_left.setBounds(10, 112, 39, 32);
		btn_slide_left.setIcon(new ImageIcon("C:\\Git\\WassabiApp\\back.png"));
		btn_slide_left.setFont(new Font("Arial", Font.BOLD, 12));
		
		Label lbl_categoria = new Label("Categoria");
		lbl_categoria.setBounds(108, 13, 204, 22);
		lbl_categoria.setFont(new Font("Arial", Font.BOLD, 12));
		lbl_categoria.setAlignment(Label.CENTER);
		
		Label lbl_categoria_1 = new Label("__________________________________________________");
		lbl_categoria_1.setBounds(46, 23, 337, 22);
		lbl_categoria_1.setFont(new Font("Arial", Font.BOLD, 12));
		lbl_categoria_1.setAlignment(Label.CENTER);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 739, 373);
		pagina_inicial.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Git\\WassabiApp\\f.jpg"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 739, 22);
		panel.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Consulta");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Produtos");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Clientes");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Pedidos");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("Cadastro");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Produtos");
		
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Clientes");
		
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Pedidos");
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_2 = new JMenu("Ajustes");
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("Produtos");
		mnNewMenu_2.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Alterar");
		mnNewMenu_3.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Excluir");
		mnNewMenu_3.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_4 = new JMenu("Clientes");
		mnNewMenu_2.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Alterar");
		mnNewMenu_4.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Excluir");
		mnNewMenu_4.add(mntmNewMenuItem_9);
		
		JMenu mnNewMenu_5 = new JMenu("Outras Informa\u00E7\u00F5es");
		menuBar.add(mnNewMenu_5);
		
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//JOptionPane.showMessageDialog(null, "Uhuu");
			pagina_inicial.setVisible(false);
			}
			
		});
		
		//Evento ao clicar no botao de proxima categoria
		btn_slide_right.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ProximaCategoria(lbl_categoria,btn_slide_right,btn_slide_left);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//Evento ao clicar no botao de categoria anterior
				btn_slide_left.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							AnteriorCategoria(lbl_categoria,btn_slide_right,btn_slide_left);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				
		
		//Quando o botao de cadastro de cliente e acionado
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insere_clientes.setVisible(true);
				lista_produtos.setVisible(false);
			}
		});
		lista_produtos.setLayout(null);
		//insere_clientes.setVisible(false);
		//lista_produtos.setVisible(true);
		
		//carrega categorias
		CarregaCategorias(lbl_categoria);
		lista_produtos.add(lbl_categoria);
		lista_produtos.add(lbl_categoria_1);
		lista_produtos.add(btn_slide_left);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 51, 311, 151);
		lista_produtos.add(scrollPane);
		
		tabela_produtos = new JTable();
		scrollPane.setViewportView(tabela_produtos);
		tabela_produtos.setFillsViewportHeight(true);
		tabela_produtos.setToolTipText("");
		tabela_produtos.setFont(new Font("Arial", Font.PLAIN, 16));
		//tabela_produtos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		tabela_produtos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				JOptionPane.showMessageDialog(null, tabela_produtos.getValueAt(tabela_produtos.getSelectedRow(), 0));
				
			
			}
		});
		tabela_produtos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabela_produtos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\uD83C\uDF63 \uD83C\uDF64 \uD83C\uDF65 \uD83E\uDD6E \uD83C\uDF61 \uD83C\uDF59 \uD83C\uDF71 \uD83C\uDF5C"
			}
		));
		tabela_produtos.setBorder(null);
		tabela_produtos.setBackground(new Color(255, 255, 255));
		lista_produtos.add(btn_slide_right);
		lista_produtos.add(btn_carrinho_compra);
		
		Label lbl_categoria_1_1 = new Label("__________________________________________________");
		lbl_categoria_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lbl_categoria_1_1.setAlignment(Label.CENTER);
		lbl_categoria_1_1.setBounds(46, 258, 337, 22);
		lista_produtos.add(lbl_categoria_1_1);
		
		
		
		//carrega produtos
		try {
			CarregaTabelaProdutos();
			btn_slide_left.setEnabled(false);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	List<String> lista_de_categorias;
	int index_categoria = 0;
	
	public void CarregaCategorias(Label lbl_categoria) {
		try {
			WassabiDAO.conectar();
			lista_de_categorias = WassabiDAO.consultarTodasCategorias();

			lbl_categoria.setText(lista_de_categorias.get(index_categoria));
			//readJTableCategoria();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ProximaCategoria(Label lbl_categoria, JButton jb_next, JButton jb_back) throws SQLException {
		
		if (jb_next.isEnabled()) {
			index_categoria++;
			CarregaTabelaProdutos();
		}
		
		lbl_categoria.setText(lista_de_categorias.get(index_categoria));
		
		if (index_categoria == 3) {
			jb_next.setEnabled(false);
		}
		
		if(index_categoria > 0) {
			jb_back.setEnabled(true);
		}
	}
	
	public void AnteriorCategoria(Label lbl_categoria, JButton jb_next, JButton jb_back) throws SQLException {
		if (jb_back.isEnabled()) {
			index_categoria--;
			CarregaTabelaProdutos();
		}
		
		lbl_categoria.setText(lista_de_categorias.get(index_categoria));
		
		if (index_categoria == 0) {
			jb_back.setEnabled(false);
		}
		
		if (index_categoria < 3) {
			jb_next.setEnabled(true);
		}
	}
	
		 public String buscarCep(String cep) 
		    {
		        String json;        

		        try {
		            URL url = new URL("http://viacep.com.br/ws/"+ cep +"/json");
		            URLConnection urlConnection = url.openConnection();
		            InputStream is = urlConnection.getInputStream();
		            BufferedReader br = new BufferedReader(new InputStreamReader(is));

		            StringBuilder jsonSb = new StringBuilder();

		            br.lines().forEach(l -> jsonSb.append(l.trim()));
		            json = jsonSb.toString();
		            
		           
		            
		            json = json.replaceAll("[{},:]", "");
		            json = json.replaceAll("\"", "\n");                       
		            String array[] = new String[60];
		            array = json.split("\n");
		     
		            String cep_ = array[3];                 
		            String logradouro = array[7];            
		            String bairro = array[15];
		            String cidade = array[19]; 
		            String uf = array[23];
		            String cod_munic = array[27];
		            //jTxtLogradouro.setText(logradouro);
		            //jTxtBairro.setText(bairro);
		            //jTxtCidade.setText(cidade);
		            //jTxtEstado.setText(uf);
		            //JOptionPane.showMessageDialog(null, "CEP: "+cep_+"\nLogradouro: "+logradouro + "\nBairro: " + bairro + "\nCidade: " + cidade + "\nCodigo Municipio: "+cod_munic+"\nUF: " + uf);
		            return "CEP: "+cep_+" Logradouro: "+logradouro + " Bairro: " + bairro + " Cidade: " + cidade + " Codigo Municipio: "+cod_munic+" UF: " + uf;
		        } catch (Exception e) {
		            throw new RuntimeException(e);
		            
		        }
		    }
		
	
	
	public void normalizar(JPanel jp1,JPanel jp2) {
		jp1.setVisible(false);
	}
	
	public void limpar_cliente(JTextPane jt1,JTextPane jt2,JTextPane jt3,JTextPane jt4,JTextPane jt5) {
		jt1.setText("");
		jt2.setText("");
		jt3.setText("");
		jt4.setText("");
		jt5.setText("");
	}
	
	public void CarregaTabelaProdutos() throws SQLException{
		DefaultTableModel modelo = (DefaultTableModel) tabela_produtos.getModel();
		modelo.setNumRows(0);
		WassabiDAO.conectar();
		var resultado = WassabiDAO.ConsultarProdutosPorCategoria(index_categoria);
		
		for (Produtos produtos : resultado) {
			modelo.addRow(new Object[] {
				produtos.nome()
			});
		}
	}
	
	public void readJTableCategoria() throws SQLException {
		DefaultTableModel modelo = (DefaultTableModel) tabela_produtos.getModel();
		modelo.setNumRows(0);
		WassabiDAO.conectar();
		var resultado = WassabiDAO.consultarTodasCategorias();
		
		/*for (CategoriaPedido categoriaPedido : resultado) {
			modelo.addRow(new Object[] {
					categoriaPedido.idCategoria(),
					categoriaPedido.nome()
			});
		}*/
	}
}
