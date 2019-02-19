package br.com.teste.banco.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String URL = "jdbc:mysql://localhost:3306/teste?useTimezone=true&serverTimezone=UTC";
	private static final String USUARIO = "root";
	private static final String SENHA = "";

	public static Connection conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			return DriverManager.getConnection(URL, USUARIO, SENHA);
		} catch (SQLException e) {
			System.out.println("Erro ao conectar no banco");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Erro ao buscar driver");
			e.printStackTrace();
		}
		return null;
	}

}
