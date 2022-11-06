package com.treinamentonetbiis.wassabi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public sealed class AcessoBD permits WassabiDAO
/*********************************************************/
{
	static String url = "jdbc:mysql://127.0.0.1:3306/dbwassabi"; 
	static String usuario = "admin";
	static String senha = "admin";	 
	static Connection conexao;
	
	/************************************************/
	public static void conectar() throws SQLException
	/************************************************/
	{
		conexao = DriverManager.getConnection(url,usuario,senha);
		conexao.setAutoCommit(false);
	}
	
	/****************************************************/
	public static void desconectar() throws SQLException
	/****************************************************/
	{
		conexao.close();
	}
}