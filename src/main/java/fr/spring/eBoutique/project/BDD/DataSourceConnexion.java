package fr.spring.eBoutique.project.BDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DataSourceConnexion {

private static DataSourceConnexion instance;
	
	private DataSourceConnexion() {
		
	}

	public static DataSourceConnexion getInstance() {
		
		if (instance == null) {
			
			return new DataSourceConnexion();
		}
		return instance;
	}
	

	public Connection getConnection() throws SQLException{
		
		Connection connexion = null;
		ResourceBundle rb=ResourceBundle.getBundle("fr.doranco.connect.dbfile");
		String login =rb.getString("login");
		String password=rb.getString("mdp");
		String url=rb.getString("url");

		try {
			connexion =DriverManager.getConnection(url, login, password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connexion;
	   
   }

	
}
