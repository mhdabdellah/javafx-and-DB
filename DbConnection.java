package application;

import java.sql.*;


public class DbConnection {
	
	//jar du connector mysql a connecter sur le site de mysql et à
			static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
			//Url de notre base
			static final String DB_URL = "jdbc:mysql://localhost/gestion_produit";
			//Username pour acceder à la base
			static final String DB_USER = "root";
			//mot de passe
			static final String DB_PASSWORD = "";
			//objet d'accés à la base
//			private JdbcRowSet jdbcRowSet = null;
		public static void main (String [] args) throws SQLException {
//			DbConnection con = new DbConnection();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con =DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM produit");
				
				while(rs.next()) {
				int id = rs.getInt("id");
				int code = rs.getInt("code_produit");
				String reference = rs.getString("reference");
				String deseignation = rs.getString("deseignation");
				String rangement = rs.getString("rangement");
				String fournisseur = rs.getString("fournisseur");
				int remise = rs.getInt("remise");
				int prix = rs.getInt("prix");
				int stock = rs.getInt("stock");
				
				System.out.println("id:"+id+" code_produit:"+code+" reference:"+reference+" deseignation:"+deseignation+" rangement:"+rangement+" fournisseur:"+fournisseur+" remise:"+remise+" prix:"+prix+" stock:"+stock);
				}
				st.close();
				con.close();
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block utilisateur
				e.printStackTrace();
			}
			
		}

}
