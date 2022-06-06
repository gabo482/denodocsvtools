package mx.global.denodocsvtools.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.global.denodocsvtools.entity.Account;
import mx.global.denodocsvtools.util.*;


public class AccountsDaoImpl {

	private ConnDB c;
	private FileSQL f;

	public AccountsDaoImpl() {
		DenodoProperties d = new DenodoProperties();
		c = new ConnDB(d.getDriver(), d.getUrl(), d.getUser(), d.getPassword());
	}

	private String getSQL() {

		String sql = "";

		f = new FileSQL();
		sql = f.readSQL("Accounts");
		
		return sql;
	}

	public List<Account> getAll() {

		List<Account> accounts = new ArrayList<Account>();
		try {
			try (Connection connection = c.getConnection()) {
				Statement st = connection.createStatement();
				String query = getSQL();
				ResultSet rs = st.executeQuery(query);
				while (rs.next()) {
					Account account = new Account();

					account.setCartera_id(rs.getString("cartera_id"));
					account.setCc_id_c(rs.getString("cc_id_c"));
					account.setName(rs.getString("Name"));
					account.setCC_Nombre_del_Cliente_o_Razon_Social__c(
							rs.getString("CC_Nombre_del_Cliente_o_Razon_Social__c"));
					account.setCE_RFC__c(rs.getString("CE_RFC__c"));
					account.setCE_Region__c(rs.getString("CE_Region__c"));
					account.setCS_PropietarioCliente_Comercial__c(rs.getString("CS_PropietarioCliente_Comercial__c"));
					account.setCS_PropietarioCliente_Servicios__c(rs.getString("CS_PropietarioCliente_Servicios__c"));
					account.setSP_DR9_Encuesta__c(rs.getString("SP_DR9_Encuesta__c"));
					account.setSPDR9_Estatus_Aplicacion_de_Pago__c(rs.getString("SPDR9_Estatus_Aplicacion_de_Pago__c"));
					account.setCS_Segmento__c(rs.getString("CS_Segmento__c"));
					account.setCS_ClienteVIP__c(rs.getString("CS_ClienteVIP__c"));
					account.setCs_subdireccion_propietarioCliente__c(
							rs.getString("cs_subdireccion_propietarioCliente__c"));
					account.setCs_gerencia_propietarioCliente__c(rs.getString("Cs_gerencia_propietarioCliente__c"));
					account.setCE_TipoRFC__c(rs.getString("CE_TipoRFC__c"));
					account.setType(rs.getString("Type"));
					account.setCC_DCTSTATUS__C(rs.getString("CC_DCTSTATUS__C"));
					account.setRecordTypeId(rs.getString("RecordTypeId"));

					accounts.add(account);

				}
			} catch (ClassNotFoundException e) {

			}
		} catch (SQLException ex) {

		}
		// ;
		return accounts;
	}

}
