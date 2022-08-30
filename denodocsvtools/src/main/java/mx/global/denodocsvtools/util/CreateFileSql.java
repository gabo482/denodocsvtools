package mx.global.denodocsvtools.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class CreateFileSql {
	
	
	
	private static String getNameFile() {
		String nameFile ="";
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");  
		    Date date = new Date();  
		    nameFile = "insert_bd_local_sql_"+formatter.format(date)+".sql";  		
		return nameFile;
	}
	
	public static void write (StringBuilder sb) {
			
		Resource resource = new ClassPathResource("resources/filePath.properties");
		Properties propiedades = new Properties();

		try {
			propiedades.load(resource.getInputStream());
			String pathFile = propiedades.getProperty("path.insert.sql");
			pathFile = pathFile+getNameFile();
			File fileInsertSql = new File(pathFile);
			fileInsertSql.createNewFile();
			FileWriter fw = new FileWriter(fileInsertSql );
			BufferedWriter bw = new BufferedWriter(fw);			
				bw.write(sb.toString());
			bw.close();	
			System.out.println(pathFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	
	
}
