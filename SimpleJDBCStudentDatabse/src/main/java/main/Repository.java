package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class Repository {
	protected Connection connection;
	protected String database_url ="jdbc:sqlite:university.db";
	protected SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
	
	public Repository()  {
		try {
			connection = DriverManager.getConnection(database_url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
}

protected void finalize() throws SQLException {
	connection.close();
}

}
