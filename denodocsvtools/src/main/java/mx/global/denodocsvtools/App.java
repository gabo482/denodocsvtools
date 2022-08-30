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
import mx.global.denodocsvtools.service.DCR9;

/**
 * Hello world!
 *
 */
public class App {
		
	private String pathExtractCSV ;
	
	
	public String getLocation() {
		String location="";
		Resource resource = new ClassPathResource("resources/filePath.properties");		
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
		
	public  void getAccounts(String location) {
		
		List<Account> accounts = new ArrayList<>();
		
		AccountsDaoImpl dao = new AccountsDaoImpl();
		accounts = dao.getAll();
		if (!accounts.isEmpty()) {
			CreateCsvFile.generateCsvFile(location, accounts);
			System.out.println(location);
//			try {
//				dao.insertAll(accounts);
//			}catch(Exception e) {
//				System.out.println(e.getMessage());
//			}
		}
	}
	
	
	public static void main(String[] args) {
		App app = new App();
		String location = app.getLocation();
		app.getAccounts(location);
		DCR9 dc = new DCR9();
		location = dc.getLocation();
		dc.getAccounts(location);

	}
}
