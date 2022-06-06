package mx.global.denodocsvtools.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import mx.global.denodocsvtools.entity.Account;
import java.io.File;

public class CreateCsvFile {

	public static void generateCsvFile(String fileName, List<Account> accounts) {

		FileWriter writer = null;

		@SuppressWarnings("unused")
		String idCartera = "";
		if (!accounts.isEmpty()) {
			try {

				writer = new FileWriter(new File(fileName));
				writer.append("cartera_id");
				writer.append(',');
				writer.append("cc_id_c");
				writer.append(',');
				writer.append("Name");
				writer.append(',');
				writer.append("CC_Nombre_del_Cliente_o_Razon_Social__c");
				writer.append(',');
				writer.append("CE_RFC__c");
				writer.append(',');
				writer.append("CE_Region__c");
				writer.append(',');
				writer.append("CS_PropietarioCliente_Comercial__c");
				writer.append(',');
				writer.append("CS_PropietarioCliente_Servicios__c");
				writer.append(',');
				writer.append("SP_DR9_Encuesta__c");
				writer.append(',');
				writer.append("SPDR9_Estatus_Aplicacion_de_Pago__c");
				writer.append(',');
				writer.append("CS_Segmento__c");
				writer.append(',');
				writer.append("CS_ClienteVIP__c");
				writer.append(',');
				writer.append("cs_subdireccion_propietarioCliente__c");
				writer.append(',');
				writer.append("Cs_gerencia_propietarioCliente__c");
				writer.append(',');
				writer.append("CE_TipoRFC__c");
				writer.append(',');
				writer.append("Type");
				writer.append(',');
				writer.append("CC_DCTSTATUS__C");
				writer.append(',');
				writer.append("RecordTypeId");
				writer.append('\n');

				for (Account account : accounts) {
					if (isNumeric(account.getCartera_id())) {
						idCartera = account.getCartera_id();
						writer.append("\"" + account.getCartera_id() + "\"");
						writer.append(',');
						writer.append("\"" + clearCharactersUnicode(account.getCc_id_c()) + "\"");
						writer.append(',');
						writer.append("\"" + clearCharactersUnicode(account.getName()) + "\"");
						writer.append(',');
						writer.append("\""
								+ clearCharactersUnicode(account.getCC_Nombre_del_Cliente_o_Razon_Social__c()) + "\"");
						writer.append(',');
						writer.append("\"" + clearCharactersUnicode(account.getCE_RFC__c()) + "\"");
						writer.append(',');
						writer.append("\"" + account.getCE_Region__c() + "\"");
						writer.append(',');
						writer.append("\"" + account.getCS_PropietarioCliente_Comercial__c() + "\"");
						writer.append(',');
						writer.append(
								"\"" + clearCharactersUnicode(account.getCS_PropietarioCliente_Servicios__c()) + "\"");
						writer.append(',');
						writer.append("\"" + account.getSP_DR9_Encuesta__c() + "\"");
						writer.append(',');
						writer.append("\"" + account.getSPDR9_Estatus_Aplicacion_de_Pago__c() + "\"");
						writer.append(',');
						writer.append("\"" + account.getCS_Segmento__c() + "\"");
						writer.append(',');
						writer.append("\"" + account.getCS_ClienteVIP__c() + "\"");
						writer.append(',');
						writer.append("\"" + account.getCs_subdireccion_propietarioCliente__c() + "\"");
						writer.append(',');
						writer.append("\"" + account.getCs_gerencia_propietarioCliente__c() + "\"");
						writer.append(',');
						writer.append("\"" + account.getCE_TipoRFC__c() + "\"");
						writer.append(',');
						writer.append("\"" + account.getType() + "\"");
						writer.append(',');
						writer.append("\"" + account.getCC_DCTSTATUS__C() + "\"");
						writer.append(',');
						writer.append("\"" + account.getRecordTypeId() + "\"");
						writer.append('\n');

					}
				}

				System.out.println("CSV file is created...");
				// Path path = Paths.get(fileName);
				// removeBom(path);

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					writer.flush();
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
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
