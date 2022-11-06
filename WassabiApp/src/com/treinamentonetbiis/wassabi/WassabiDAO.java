package com.treinamentonetbiis.wassabi;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


public final class WassabiDAO extends AcessoBD{

	/********************************************************/
	public static List<String> consultarTodasCategorias() throws SQLException
	/********************************************************/
	{
		String sql = "select * from categoria";
		Statement statement = conexao.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		List<String> categoria = new LinkedList<>();
		while(rs.next()) {   
			//System.out.println(rs.getInt(1)+"<=>"+rs.getString(2));
			
			categoria.add(rs.getString(2));
		}
		return categoria;
	}
	
	/*****************************************************************/
	public static void inserirProdutos(Produtos produtos) throws SQLException{
	/*****************************************************************/	
		String sql = "insert into produtos values ("+produtos.idProdutos()+","+produtos.nome()+","+produtos.descricao()+","
				+produtos.valor()+"')";
		Statement statement = conexao.createStatement();
		statement.execute(sql);
		conexao.commit();
	}
	
	/*****************************************************************/
	public static void inserirClientes(Clientes clientes) throws SQLException{
	/*****************************************************************/	
		String sql = "insert into cliente (nome,cpf,telefone,endereco) values ('"+clientes.nome()+"','"+clientes.cpf()+"','"
				+clientes.telefone()+"','"+clientes.endereco()+"')";
		Statement statement = conexao.createStatement();
		statement.execute(sql);
		conexao.commit();
	}
	
	public static List<Clientes> consultarTodosClientes() throws SQLException
	/********************************************************/
	{
		String sql = "select * from cliente";
		Statement statement = conexao.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		List<Clientes> cliente = new LinkedList<>();
		while(rs.next()) {   
			System.out.println(rs.getInt(1)+"<=>"+rs.getString(2));
			Clientes clie_ = new Clientes(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
			cliente.add(clie_);
		}
		return cliente;
	}
	
	public static List<Produtos> ConsultarProdutosPorCategoria(int categoria) throws SQLException
	/********************************************************/
	{
		String sql = "select * from produtos where categoria ="+categoria;
		Statement statement = conexao.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		List<Produtos> produto = new LinkedList<>();
		while(rs.next()) {   
			System.out.println(rs.getInt(1)+"<=>"+rs.getString(2));
			Produtos prod = new Produtos(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
			produto.add(prod);
		}
		return produto;
	}
	
	
}
