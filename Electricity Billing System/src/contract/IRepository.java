package contract;

import java.sql.ResultSet;
import java.sql.Statement;

public interface IRepository {
	/**
	 * Try to get connexion to database

	 * @return statement
	 */
	 public Statement databaseConnexion();
	 
	 /**
	  * Execute query to select data from database
	  * @param selectRequest
	  * @return
	  */
	 public ResultSet executeQuery(String selectRequest);
	 
	 /**
	  * execute request to update, delete, and insert data
	  * @param updateRequest
	  * @return
	  */
	 public int executeUpdate(String updateRequest);
}
