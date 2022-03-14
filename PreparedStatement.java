package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedStatement {

	//jar du connector mysql a connecter sur le site de mysql et à
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	//Url de notre base
	static final String DB_URL = "jdbc:mysql://localhost/gestion_produit";
	//Username pour acceder à la base
	static final String DB_USER = "root";
	//mot de passe
	static final String DB_PASSWORD = "";
	//objet d'accés à la base
//	private JdbcRowSet jdbcRowSet = null;
public static void main (String [] args) throws SQLException, IOException {
//	try (   
//			// une fonction se trouve dans la class DBinfo pour etablir la connection avec la base des donnees 
//			Connection con = DBinfo.connDB();
//			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY)){
//		// la requete sql
//		String sql = "insert into user(id,nom,prenom,email)"
//				+"values(1,'sidi','ali','sidiali@gmail.com')";
//		// execution de la requete 
//		st.executeUpdate(sql);
//	}catch (SQLException e) {
//		// TODO Auto-generated catch block
//		ErrorEx.errException(e);
//	}
//	DbConnection con = new DbConnection();
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con =DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//		Statement st = con.createStatement();
		BufferedReader bfreader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Entrer Nom");
		String name = bfreader.readLine();
		System.out.println("Entrer Prenom");
		String lastname = bfreader.readLine();
		System.out.println("Entrer Email");
		String Email = bfreader.readLine();
//		ResultSet rs = st.executeQuery("insert into user(nom,prenom,email) values('"+name+"','"+lastname+"','"+Email +"')");
		String sql = "insert into user(nom,prenom,email) values(?,?,?)";
		java.sql.PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,name);
		ps.setString(2,lastname);
		ps.setString(3,Email);
		
//		rs.next();
//		st.close();
//		con.close();
		System.out.println("les donnees sont inseree");
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
