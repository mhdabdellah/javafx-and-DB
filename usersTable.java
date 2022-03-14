package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class usersTable implements Initializable {
	
	//jar du connector mysql a connecter sur le site de mysql et à
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	//Url de notre base
	static final String DB_URL = "jdbc:mysql://localhost/gestion_produit";
	//Username pour acceder à la base
	static final String DB_USER = "root";
	//mot de passe
	static final String DB_PASSWORD = "";
	
	@FXML
	private TableView<Users> usertable;
	
	@FXML
	private TableColumn<Users, String> userid;
	
	@FXML
	private TableColumn<Users, String> userName;
	
	@FXML
	private TableColumn<Users, String> userPassword;
	
	@FXML
	private TableColumn<Users, String> userEmail;
	
	@FXML
	private TableColumn<Users, String> userType;
	
	// initializes the usersTable class
	private ArrayList<String> data;
	
	
   
   


	@Override
    public void initialize(URL url, ResourceBundle rb) {
        data = FXCollections.observableArrayList();
       try{
    	   Class.forName("com.mysql.jdbc.Driver");
    		Connection con =DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    		Statement st = con.createStatement();
    		ResultSet rs = st.executeQuery("SELECT * FROM utilisateur");
           while(rs.next()){
               data.add(new Users(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getString("type")
               ));
           }
//           userid.setCellValueFactory(new PropertyValueFactory<Users, String>("userID"));
//           userName.setCellValueFactory(new PropertyValueFactory<Users, String>("userName"));
//           userPassword.setCellValueFactory(new PropertyValueFactory<Users, String>("userPassword"));
//           userEmail.setCellValueFactory(new PropertyValueFactory<Users, String>("userEmail"));
//           userType.setCellValueFactory(new PropertyValueFactory<Users, String>("userType"));
           System.out.println(data);
           System.out.println(rs.getString("id"));

           usertable.setItems(data);             

       }catch (Exception e){
           e.printStackTrace();;
           System.out.println("error");
       }

    }    


}
