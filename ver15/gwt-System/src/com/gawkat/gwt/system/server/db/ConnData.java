package com.gawkat.gwt.system.server.db;

/**
 * data connection information
 * 
 * @author branflake2267
 *
 */
public class ConnData {

	// what server/computer is the database on?
	public String host = null;
	public int port = 0;
	
	// whatis the jdbc driver you are using
	// mysql: com.mysql.jdbc.Driver
	// mssql: com.microsoft.sqlserver.jdbc.SQLServerDriver
	//        depends on which jdbc you download (sql server 2000 or 2005+)
	public String driver;
	
	// credentials
	public String username = null;
	public String password = null;
	
	// database to use
	public String database = null;
	
	/**
	 * get connection url
	 * 
	 * @return connection url string
	 */
	public String getUrl() {
		String type = driver.toLowerCase();
		String url = "";
		if (type.contains("mysql")) {
			url = "jdbc:mysql://" + host + ":" + port + "/" + database;
		} else if (type.contains("microsoft")) {
			url = "jdbc:sqlserver://" + host + ";user=" + username + ";password=" + password + ";databaseName=" + database;
		}
		return url;
	}
}
