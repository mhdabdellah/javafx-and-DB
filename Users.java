package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Users {

	    public  SimpleIntegerProperty userID = new SimpleIntegerProperty();
	    public  SimpleStringProperty userName = new SimpleStringProperty();
	    public  SimpleStringProperty userEmail = new SimpleStringProperty();
	    public  SimpleStringProperty userPassword = new SimpleStringProperty();
	    public  SimpleStringProperty userType = new SimpleStringProperty();

		
		public int getuserID() {
	        return this.userID.get();
	     }
	    public void setuserID(int id) {
	          this.userID.set(id);
	     }

	    public String getuserName() {
	        return userName.get();
	     }
	    public void setuserName(String firstNameStr) {
	    	userName.set(firstNameStr);
	     }
	    public String getuserEmail() {
	        return userEmail.get();
	     }
	    public void setLastName(String lastNameStr) {
	    	userEmail.set(lastNameStr);
	     }
	    public String getuserPassword() {
	        return userPassword.get();
	     }
	    public void setuserPassword(String address) {
	          this.userPassword.set(address);
	     }
	    public void setuserType(String type) {
	          this.userType.set(type);
	     }

	    public String getuserType() {
	        return this.userType.get();
	     }
	    
//	    package application;
//
//	    import javafx.beans.property.SimpleIntegerProperty;
//	    import javafx.beans.property.SimpleStringProperty;
//
//	    public class Users {
//
////	    	 public  SimpleIntegerProperty userID = new SimpleIntegerProperty();
////	    	    public  SimpleStringProperty userName = new SimpleStringProperty();
////	    	    public  SimpleStringProperty userEmail = new SimpleStringProperty();
////	    	    public  SimpleStringProperty userPassword = new SimpleStringProperty();
////	    	    public  SimpleStringProperty userType = new SimpleStringProperty();
//
//	    	
//	    	    public  String userID ,userName, userEmail, userPassword, userType;
//	    	    
//	    	    public Users(String string, String string2, String string3, String string4, String string5) {
//	    			// TODO Auto-generated constructor stub
//	    			this.userID= string;
//	    			this.userName= string2;
//	    			this.userEmail= string3;
//	    			this.userPassword= string4;
//	    			this.userType= string5;
//	    		}
//	    		public String getuserID() {
//	    	        return this.userID;
//	    	     }
//	    	    public void setuserID(String id) {
//	    	          this.userID = id;
//	    	     }
//
//	    	    public String getuserName() {
//	    	        return this.userName;
//	    	     }
//	    	    public void setuserName(String firstNameStr) {
//	    	    	this.userName=firstNameStr;
//	    	     }
//	    	    public String getuserEmail() {
//	    	        return this.userEmail;
//	    	     }
//	    	    public void setLastName(String lastNameStr) {
//	    	    	this.userEmail=lastNameStr;
//	    	     }
//	    	    public String getuserPassword() {
//	    	        return this.userPassword;
//	    	     }
//	    	    public void setuserPassword(String address) {
//	    	          this.userPassword=address;
//	    	     }
//	    	    public void setuserType(String type) {
//	    	          this.userType=type;
//	    	     }
//
//	    	    public String getuserType() {
//	    	        return this.userType;
//	    	     }
//
//
//	    }



}
