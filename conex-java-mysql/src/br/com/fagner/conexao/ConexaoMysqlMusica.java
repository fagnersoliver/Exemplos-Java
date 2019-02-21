package br.com.fagner.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoMysqlMusica {

	private final static String url = "jdbc:mysql://localhost:3306/blobs?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";

	private final static String name = "root";
	private final static String password = "123456";

	private Connection con;
	private Statement stmt;


	public static void main(String[] args) {

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			ConexaoMysqlMusica  conexao = new ConexaoMysqlMusica();
			
			conexao.AbrirBanco();
			conexao.Salva();
			conexao.FechaBD();
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Não foi possível carregar o driver");
			e.printStackTrace();
		}
		
	}

	public void AbrirBanco() {

		try {
  
			con = DriverManager.getConnection(url, name, password);
			stmt = con.createStatement();
			System.out.println("Conexao efetuada com sucesso");

		} catch (SQLException e) {

			System.out.println("Erro ao estabelecer a conexao");
			System.exit(1);
		}
	}

	public void Salva() {

		String querie;

		try {

			querie = "SELECT Na_Imagem INTO OUTFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/IC_01_INTRO_MST_02.mp3' FROM teste WHERE Id_Blob = 3;";
			con = DriverManager.getConnection(url, name, password);
			stmt.executeQuery(querie);
			System.out.println("Salvo com sucesso");

		} catch (SQLException e) {

			System.out.println("Erro ao excutar a querie");
			System.exit(1);
		}

	}

	public void FechaBD() {

		try {

			con.close();

		} catch (SQLException e) {

			System.out.println("Erro fechar conexao");

		}

	}

}
