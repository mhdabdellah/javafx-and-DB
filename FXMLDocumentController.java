/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Prof-Virus
 */
public class FXMLDocumentController implements Initializable {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	//Url de notre base
	static final String DB_URL = "jdbc:mysql://localhost/gestion_produit";
	//Username pour acceder à la base
	static final String DB_USER = "root";
	//mot de passe
	static final String DB_PASSWORD = "";
    
    String pname = "Eggs"; 
    int qty = 1; 
    Double price = 2.50;

    @FXML
    private Label label;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnRemove;
    @FXML
    private Button btnPrint;
    @FXML
    private TableView<Product> tbView;
    @FXML
    private TableColumn<Product, String> colProduct;
    @FXML
    private TableColumn<Product, Integer> colQty;
    @FXML
    private TableColumn<Product, Double> colPrice;
    @FXML
    private Button btnCancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	
    	showPrices();
    }    

    @FXML
    private void handleAddAction(ActionEvent event) {
        //String pname = "Eggs";
        //int qty = 1;
        //Double price = 2.50;
        addCart();
        showPrices();
        System.out.println(sumPrice());
    }

    @FXML
    private void handleRemoveAction(ActionEvent event) {
        removeSelectedItem();
    }

    @FXML
    private void handlePrintAction(ActionEvent event) {
    }

    @FXML
    private void handleCancelAction(ActionEvent event) {
        System.exit(0);
    }
    
    /////////////////////////////////////////////////////////////////
    public Connection getConnection(){
        
        Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_produit","root","");
            return conn;
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return null;
        
    }
    
   //////////////////////////////////////////////////////////////////////
        public ObservableList<Product> getProductList(){
        ObservableList<Product> productList = FXCollections.observableArrayList();
//        Connection conn = getConnection();
        String query = "SELECT * FROM temporary";
//        Statement st;
////        ResultSet rs;
//        Class.forName("com.mysql.jdbc.Driver");
//		Connection con =DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//		Statement st = con.createStatement();
        try{
        	Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
            
            Product product;
            
            while(rs.next()){
                product = new Product(rs.getString("pname"), rs.getInt("qty"), rs.getDouble("price"));
//                productList.add(product);
                System.out.println(product.getQty());
                System.out.println(product.getPrice());
                System.out.println(product.getProduct());
                productList.add(0, product);
            }
        }catch(SQLException e){
        	System.err.format("SQL State: %s\n%s", e.getSQLState(),e.getMessage());
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return productList;

}
//////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////
public void showPrices(){
        ObservableList<Product> list = getProductList();
        colProduct.setCellValueFactory(new PropertyValueFactory<Product, String>("product"));
        colQty.setCellValueFactory(new PropertyValueFactory<Product, Integer>("qty"));
        colPrice.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
        
        tbView.setItems(list);
        
    } 
//////////////////////////////////////////////////////////////////////////////////////////
public void addCart(){
   // this.pname = pname;
   
    checkCopy();
    Connection conn = getConnection();
        String query = "INSERT INTO temporary (pname, qty, price) VALUES ('"+ pname +"','"+qty+"', '"+price+"')";
        Statement st;
        //ResultSet rs;
        
        try{
            if(checkCopy().equals("Eggs")){
                qty += 1;
                double mutengo = 2.50 * qty;
               st = conn.createStatement();
               st.executeUpdate("UPDATE temporary SET qty = '"+qty+"', price = '"+mutengo+"' WHERE pname = 'Eggs'"); 
            }else{
            st = conn.createStatement();
            st.executeUpdate(query);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        
        //return null;
    
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
private String checkCopy(){
    Connection conn = getConnection();
        String query = "SELECT * FROM temporary WHERE pname = 'Eggs'";
        Statement st;
        ResultSet rs;
        String product = "";
        String emptyProduct = "zero";
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            
            
            while(rs.next()){
                product = rs.getString("pname");
                if(product.isEmpty()){
                    return emptyProduct;
                }else{
                    return product;
                }
                
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return product;
        
        
        
}
///////////////////////////////////////////////////////////////////////////////////////////////////
private void removeSelectedItem() {
    try{
        Connection conn = getConnection();
        
        
    
    Product prd = (Product)tbView.getSelectionModel().getSelectedItem();
    String nameOfproduct = prd.getProduct();
    System.out.println(nameOfproduct);
    PreparedStatement st;
    st = conn.prepareStatement("DELETE FROM temporary WHERE pname = '"+nameOfproduct+"'");
    st.executeUpdate();
    //st = conn.createStatement();
    //st.executeUpdate(query);
    
    tbView.getItems().removeAll(tbView.getSelectionModel().getSelectedItem());
    
    }catch(SQLException e){
        System.out.println(e);
    }
    
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////
private Double sumPrice(){

    Double total = 0.0 ;
    for (Product item : tbView.getItems()) {
        total = total + item.getPrice();
    }
return total;
}
    
}
