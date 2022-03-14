package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateData {

	//jar du connector mysql a connecter sur le site de mysql et à
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	//Url de notre base
	static final String DB_URL = "jdbc:mysql://localhost/gestion_produit";
	//Username pour acceder à la base
	static final String DB_USER = "root";
	//mot de passe
	static final String DB_PASSWORD = "";

	public static void main (String [] args) throws SQLException, IOException {
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			Statement st = con.createStatement();
			BufferedReader bfreader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Entrer Id");
			String Id = bfreader.readLine();
			System.out.println("Entrer Nom");
			String name = bfreader.readLine();
			System.out.println("Entrer Prenom");
			String lastname = bfreader.readLine();
			System.out.println("Entrer Email");
			String Email = bfreader.readLine();
			ResultSet rs = st.executeQuery("update user set nom='"+name+"', prenom='"+lastname+"', email='"+Email +"' where id='"+ Id);
			
			rs.next();
	
			System.out.println("les donnees sont modifiees");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
