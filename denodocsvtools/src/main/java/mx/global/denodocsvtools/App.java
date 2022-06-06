package mx.global.denodocsvtools;


import java.util.List;
import java.util.Properties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;  
import  mx.global.denodocsvtools.dao.*;
import mx.global.denodocsvtools.entity.Account;
import mx.global.denodocsvtools.util.CreateCsvFile;

/**
 * Hello world!
 *
 */
public class App {
		
	private String pathExtractCSV ;

	public String getLocation() {
		String location="";
		Resource resource = new ClassPathResource("resources/path.properties");
		Properties propiedades = new Properties();
		try {
			propiedades.load(resource.getInputStream());
			pathExtractCSV = propiedades.getProperty("path.extract.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		location = pathExtractCSV+"\\"+ getNameFile();
		return location;
	}
	
	public  String getNameFile() {
		String nameFile ="";
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");  
		    Date date = new Date();  
		    nameFile = "extract_SC_denodo_"+formatter.format(date)+".csv";  		
		return nameFile;
	}
		
	public static void main(String[] args) {
		App app = new App();
		List<Account> list = new ArrayList<>();
		String location =app.getLocation();
		AccountsDaoImpl dao = new AccountsDaoImpl();
		list = dao.getAll();
		
		CreateCsvFile.generateCsvFile(location,list);
		
		System.out.println(location);
	}
}
