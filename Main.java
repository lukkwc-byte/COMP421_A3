
import java.sql.* ;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
// javac -cp ~/comp421/postgresql-9.4.1208.jre6.jar simpleJDBC.java


public class simpleJDBC {
	public static void main ( String [ ] args ) throws SQLException{
		// Unique table names.  Either the user supplies a unique identifier as a command line argument, or the program makes one up.
		String tableName = "";
	    int sqlCode=0;      		// Variable to hold SQLCODE
	    String sqlState="00000";  	// Variable to hold SQLSTATE

		if ( args.length > 0 ){
		    tableName += args [ 0 ] ;
		}
		else {
		    tableName += "example3.tbl";
		}
		
		
		// Registering the driver.
		try {
	    		DriverManager.registerDriver ( new org.postgresql.Driver() ) ;
		} 
		catch (Exception cnfe){
	    		System.out.println("Class not found");
	    	}
		
		//Login info
		//String usernamestring = "cs421g52";
		//String passwordstring = "ace42116";
		String usernamestring = "fma27";
		String passwordstring = "dash8645";
		String url = "jdbc:postgresql://comp421.cs.mcgill.ca:5432/cs421?searchpath=cs421g52";
		
		//Connection to the database
		Connection con = DriverManager.getConnection (url,usernamestring, passwordstring) ;
		Statement statement = con.createStatement ( ) ;
		String[] userInput= new String[20];
		Scanner in = new Scanner(System.in);

		while (true){
		// getcmd(userInput);
			userInput = in.nextLine().split(" ");
			System.out.println(userInput[0]);

		 	if ("exit".equals(userInput[0])){
		 	break; 
		 	} 
		 	
		 	else if ("admit".equals(userInput[0])){
		 		System.out.println(userInput[0]);
		 	}
		 	
		 	else if ("list".equals(userInput[0])){
		 		System.out.println(userInput[0]);
		 	} 
		 	
		 	// Creating a table
		 	else if ("test".equals(userInput[0])){
				try {
				    String createSQL = "CREATE TABLE " + tableName + " (id INTEGER, name VARCHAR (25)) ";
				    System.out.println (createSQL ) ;
				    statement.executeUpdate (createSQL ) ;
				    System.out.println ("DONE");
				} 
				
				catch (SQLException e){
					sqlCode = e.getErrorCode(); // Get SQLCODE
				    sqlState = e.getSQLState(); // Get SQLSTATE
				        
				    // Your code to handle errors comes here;
				    // something more meaningful than a print would be good
				    System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
				}
			}

			// Inserting Data into the table
			try {
			    String insertSQL = "INSERT INTO " + tableName + " VALUES ( 1 , \'Vicki\' ) " ;
			    System.out.println ( insertSQL ) ;
			    statement.executeUpdate ( insertSQL ) ;
			    System.out.println ( "DONE" ) ;

			    insertSQL = "INSERT INTO " + tableName + " VALUES ( 2 , \'Vera\' ) " ;
			    System.out.println ( insertSQL ) ;
			    statement.executeUpdate ( insertSQL ) ;
			    System.out.println ( "DONE" ) ;
			    insertSQL = "INSERT INTO " + tableName + " VALUES ( 3 , \'Franca\' ) " ;
			    System.out.println ( insertSQL ) ;
			    statement.executeUpdate ( insertSQL ) ;
			    System.out.println ( "DONE" ) ;

			} 
			catch (SQLException e){
			        sqlCode = e.getErrorCode(); // Get SQLCODE
			        sqlState = e.getSQLState(); // Get SQLSTATE
			        
			        // Your code to handle errors comes here;
			        // something more meaningful than a print would be good
			        System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
			    }

			// Querying a table
			try {
			    String querySQL = "SELECT id, name from " + tableName + " WHERE NAME = \'Vicki\'";
			    System.out.println (querySQL) ;
			    java.sql.ResultSet rs = statement.executeQuery ( querySQL ) ;
			    while ( rs.next ( ) ) {
				int id = rs.getInt ( 1 ) ;
				String name = rs.getString (2);
				System.out.println ("id:  " + id);
				System.out.println ("name:  " + name);
			    }
			    System.out.println ("DONE");
			} 
			catch (SQLException e){
				sqlCode = e.getErrorCode(); // Get SQLCODE
				sqlState = e.getSQLState(); // Get SQLSTATE
			        
				// Your code to handle errors comes here;
				// something more meaningful than a print would be good
				System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
			}

			//Updating a table
		   	try {
			    String updateSQL = "UPDATE " + tableName + " SET NAME = \'Mimi\' WHERE id = 3";
			    System.out.println(updateSQL);
			    statement.executeUpdate(updateSQL);
			    System.out.println("DONE");

			    // Dropping a table
			    String dropSQL = "DROP TABLE " + tableName;
			    System.out.println ( dropSQL ) ;
			    statement.executeUpdate ( dropSQL ) ;
			    System.out.println ("DONE");
			} 
			catch (SQLException e){
				//String usernamestring = "cs421g52";
				//String passwordstring = "ace42116";
				sqlCode = e.getErrorCode(); // Get SQLCODE
				sqlState = e.getSQLState(); // Get SQLSTATE
			        
				// Your code to handle errors comes here;
				// something more meaningful than a print would be good
				System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
			}
		}
	// Finally but importantly close the statement and connection
	statement.close() ;
	con.close() ;
	}
}
