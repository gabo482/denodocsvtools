package mx.global.denodocsvtools.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import mx.global.denodocsvtools.dao.AccountsR9DaoImpl;
import mx.global.denodocsvtools.entity.AccountR9;
import mx.global.denodocsvtools.util.CreateR9CsvFile;

public class DCR9 {
	
	
	private String pathExtractCSV ;
	
	public void getAccounts(String location) {
		
		List<AccountR9> accounts = new ArrayList<>();		
		AccountsR9DaoImpl dao = new AccountsR9DaoImpl();
		accounts = dao.getAll();
		
		
			if (!accounts.isEmpty()) {
				System.out.println("Recibidos:"+accounts.size());				
				CreateR9CsvFile.generateCsvFile(location, accounts);
				System.out.println(location);
//				dao.insertAll(accounts);
			}				

	}
	
	public String getLocation() {
		String location="";
		Resource resource = new ClassPathResource("resources/filePath.properties");		
		Properties propiedades = new Properties();
		try {
			propiedades.load(resource.getInputStream());
			pathExtractCSV = propiedades.getProperty("path.extract.dc.csv");
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
		    nameFile = "dcr9_"+formatter.format(date)+".csv";  		
		return nameFile;
	}
	
}
