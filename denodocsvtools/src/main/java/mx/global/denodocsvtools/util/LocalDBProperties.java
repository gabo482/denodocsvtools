package mx.global.denodocsvtools.util;

import java.io.IOException;
import java.util.Properties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class LocalDBProperties {

	private String driver;
	private String url;
	private String user;
	private String password;

	public LocalDBProperties() {

		Resource resource = new ClassPathResource("resources/db.properties");
		Properties propiedades = new Properties();
		try {
			propiedades.load(resource.getInputStream());
			driver = propiedades.getProperty("localdb.driver");
			url = propiedades.getProperty("localdb.url");
			user = propiedades.getProperty("localdb.username");
			password = propiedades.getProperty("localdb.password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//getters and setters

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
