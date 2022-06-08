package mx.global.denodocsvtools.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnDB {

	private String driver;
	private String url;
	private String user;
	private String password;

	public ConnDB(String driver, String url, String user, String password) {
		super();
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.password = password;
	}

	public Connection getConnection() throws ClassNotFoundException {
		Connection conn = null;

		try {

			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("SUCCESS : " + driver);

		} catch (SQLException e) {
			throw new Error("Problem", e);
		}

		return conn;
	}

	public static void closeResources(Connection conn, Statement stmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException er) {
				System.out.println(er.getMessage());

			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException es) {
				System.out.println(es.getMessage());

			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException ec) {
				System.out.println(ec.getMessage());
			}
		}
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
