package mx.global.denodocsvtools.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import mx.global.denodocsvtools.entity.AccountR9;
import java.io.File;

public class CreateR9CsvFile {

	public static void generateCsvFile(String fileName, List<AccountR9> accounts) {

		FileWriter writer = null;

		
		if (!accounts.isEmpty()) {
			try {

				writer = new FileWriter(new File(fileName));				
				writer.append("CC_ID__c");
				writer.append(',');				
				writer.append("CE_RFC__c");
				writer.append(',');
				writer.append("Name");
				writer.append(',');
				writer.append("CC_Nombre_del_Cliente_o_Razon_Social__c");
				writer.append(',');
				writer.append("CE_Region__c");
				writer.append(',');
				writer.append("CC_XO__C");
				writer.append(',');
				writer.append("CC_DCTSALESMANAGER__C");
				writer.append(',');
				writer.append("CC_DTCCUSTOMERID_C");
				writer.append(',');
				writer.append("CC_DCTSTATUS__C");
				writer.append(',');
				writer.append("CC_GRUPO__C");
				writer.append(',');
				writer.append("cC_DCTESTATUSCOBRANZA__C");
				writer.append(',');	
				writer.append("CC_DCTBILLINGCYCLE__C");
				writer.append(',');
				writer.append("CC_DCTRAPREFERENCE__C");
				writer.append(',');
				writer.append("CC_DCTSAPSPORADICCUSTOMER__C");
				writer.append(',');
				writer.append("CC_SUBDIRECTORACTUAL__C");
				writer.append(',');				
				writer.append("SP_DR9_Encuesta__c");
				writer.append(',');
				writer.append("SPDR9_Estatus_Aplicacion_de_Pago__c");
				writer.append(',');								
				writer.append("RecordTypeId");
				writer.append('\n');

				for (AccountR9 account : accounts) {
					writer.append(account.rowCSV());
				}

				System.out.println("CSV file is created...");				
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			} finally {
				if (writer != null) {
					try {
						writer.flush();
						writer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		} else {

			System.out.println("No hay datos");
		}
	}

	public static String clearCharactersUnicode(String s) {
		if (s != null)
			if (s.contains("\u00C3") || s.contains("\u00D1") || s.contains("\u00D3") || s.contains("\u00C9")
					|| s.contains("\u00DA") || s.contains("\u00C1") || s.contains("\u00CD") || s.contains("\u0026")
					|| s.contains("\u0040") || s.contains("\u002C")) {
				s = s.replace("\u0026", "");
				s = s.replace("\u00C1", "A");
				s = s.replace("\u00C9", "E");
				s = s.replace("\u00CD", "I");
				s = s.replace("\u00D3", "O");
				s = s.replace("\u00DA", "U");
				s = s.replace("\u00C3\u2018", "N");
				s = s.replace("\u00D1", "N");
				s = s.replace("\u0040", "");
				s = s.replace("\u002C", "");
			}

		return s;
	}
	// validar si es tipo numerico

	public static boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			@SuppressWarnings("unused")
			double d = Double.parseDouble(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

}