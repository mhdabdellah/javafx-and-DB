package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.stage.Stage;
import java.util.*;
import javax.security.auth.callback.Callback;

public class usersList extends Application {

	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	//Url de notre base
	static final String DB_URL = "jdbc:mysql://localhost/gestion_produit";
	//Username pour acceder à la base
	static final String DB_USER = "root";
	//mot de passe
	static final String DB_PASSWORD = "";
	
	// TABLE VIEW AND DATA 
	private ObservableList<ObservableList> data;
	private TableView<Persone> tableview = new TableView<>() ;
	
	// MAIN EXECUTOR 
	public void buildData() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		Connection con =DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from utilisateur ");
		// TABLE COLUMN ADDED DYNAMICALLY 
		for(int i=0; i<rs.getMetaData().getColumnCount(); i++) {
			// we are using non property style for making dynamic table 
			final int j = i;
			TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
			col.setCellValueFactory((javafx.util.Callback) new Callback(){
				public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param){
					return new SimpleStringProperty(((List<String>) param.getValue()).get(j).toString());
				}
			});
			
			tableview.getColumns().add(col);
			System.out.println("Column ["+ i +"]");
		}
		
		// data added to observableList
		
		while(rs.next()) {
			// Iterate Row
			ObservableList<String> row = FXCollections.observableArrayList();
			for(int i=1; i<rs.getMetaData().getColumnCount(); i++) {
				// Iterate Column
				row.add(rs.getString(i));
				
			}
			System.out.println("Row [1]");
			data.add(row);
		}
		// FINALLY ADDED TO TableView
		
		tableview.setItems(data);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		// TableView 
		buildData();
		Parent root = tableview;
		buildData();
		
		// Main Scene
		Scene scene = new Scene(root);
		
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
