package mx.global.denodocsvtools.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.global.denodocsvtools.entity.Account;
import mx.global.denodocsvtools.util.*;

public class AccountsDaoImpl {

	private ConnDB con;
	private FileSQL f;

	private String getSQL() {

		String sql = "";
		f = new FileSQL();
		sql = f.readSQL("getAllAccounts");

		return sql;
	}

	public List<Account> getAll() {
		DenodoProperties d = new DenodoProperties();
		con = new ConnDB(d.getDriver(), d.getUrl(), d.getUser(), d.getPassword());

		List<Account> accounts = new ArrayList<Account>();

		try (Connection connection = con.getConnection()) {
			Statement st = connection.createStatement();
			String query = getSQL();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Account account = new Account();

				account.setCartera_id(rs.getString("cartera_id"));
				account.setCc_id_c(rs.getString("CC_ID__c"));
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
				account.setCs_subdireccion_propietarioCliente__c(rs.getString("cs_subdireccion_propietarioCliente__c"));
				account.setCs_gerencia_propietarioCliente__c(rs.getString("Cs_gerencia_propietarioCliente__c"));
				account.setCE_TipoRFC__c(rs.getString("CE_TipoRFC__c"));
				account.setType(rs.getString("Type"));
				account.setCC_DCTSTATUS__C(rs.getString("CC_DCTSTATUS__C"));
				account.setRecordTypeId(rs.getString("RecordTypeId"));

				accounts.add(account);
			}

			connection.close();
		} catch (ClassNotFoundException | SQLException e) {

		}

		// ;
		return accounts;
	}

	/*
	 * #cc_id__c #cartera_id #Name #CC_Nombre_del_Cliente_o_Razon_Social__c
	 * #CE_RFC__c #CE_Region__c #CS_PropietarioCliente_Comercial__c
	 * #CS_PropietarioCliente_Servicios__c #SP_DR9_Encuesta__c
	 * #SPDR9_Estatus_Aplicacion_de_Pago__c #CS_Segmento__c #CS_ClienteVIP__c
	 * #cs_subdireccion_propietarioCliente__c #Cs_gerencia_propietarioCliente__c
	 * #CE_TipoRFC__c #Type #CC_DCTSTATUS__C #RecordTypeId
	 */

	public void insertAll(List<Account> accounts) {
		FileSQL file = new FileSQL();
		String sql = file.readSQL("insertAccount");
		StringBuilder insertSQL = new StringBuilder();
		insertSQL.append(sql);
		String v;
		int cnt = 1;
		if (insertDetCarga()) {
			for (Account a : accounts) {
				StringBuilder sb = new StringBuilder();
				//sb.append("( nextval('id')"); //cnt
				sb.append("(");
				sb.append(cnt);
				sb.append(",(select last_value from carga_id)");
				sb.append(",#cartera_id");
				sb.append(",'#cc_id__c'");
				sb.append(",'#Name'");
				sb.append(",'#CC_Nombre_del_Cliente_o_Razon_Social__c'");
				sb.append(",'#CE_RFC__c'");
				sb.append(",'#CE_Region__c'");
				sb.append(",'#CS_PropietarioCliente_Comercial__c'");
				sb.append(",'#CS_PropietarioCliente_Servicios__c'");
				sb.append(",'#SP_DR9_Encuesta__c'");
				sb.append(",'#SPDR9_Estatus_Aplicacion_de_Pago__c'");
				sb.append(",'#CS_Segmento__c'");
				sb.append(",'#CS_ClienteVIP__c'");
				sb.append(",'#cs_subdireccion_propietarioCliente__c'");
				sb.append(",'#Cs_gerencia_propietarioCliente__c'");
				sb.append(",'#CE_TipoRFC__c'");
				sb.append(",'#Type'");
				sb.append(",'#CC_DCTSTATUS__C'");
				sb.append(",'#RecordTypeId')");
				v = sb.toString();
				v = v.replace("#cartera_id", a.getCartera_id());
				v = v.replace("#cc_id__c", a.getCc_id_c());
				v = v.replace("#Name", a.getName());
				v = v.replace("#CC_Nombre_del_Cliente_o_Razon_Social__c",
						a.getCC_Nombre_del_Cliente_o_Razon_Social__c());
				v = v.replace("#CE_RFC__c", a.getCE_RFC__c());
				v = v.replace("#CE_Region__c", a.getCE_Region__c());
				v = v.replace("#CS_PropietarioCliente_Comercial__c", a.getCS_PropietarioCliente_Comercial__c());
				v = v.replace("#CS_PropietarioCliente_Servicios__c", a.getCS_PropietarioCliente_Servicios__c());
				v = v.replace("#SP_DR9_Encuesta__c", a.getSP_DR9_Encuesta__c());
				v = v.replace("#SPDR9_Estatus_Aplicacion_de_Pago__c", a.getSPDR9_Estatus_Aplicacion_de_Pago__c());
				v = v.replace("#CS_Segmento__c", a.getCS_Segmento__c());
				v = v.replace("#CS_ClienteVIP__c", a.getCS_ClienteVIP__c());
				v = v.replace("#cs_subdireccion_propietarioCliente__c", a.getCs_subdireccion_propietarioCliente__c());
				v = v.replace("#Cs_gerencia_propietarioCliente__c", a.getCs_gerencia_propietarioCliente__c());
				v = v.replace("#CE_TipoRFC__c", a.getCE_TipoRFC__c());
				v = v.replace("#Type", a.getType());
				v = v.replace("#CC_DCTSTATUS__C", a.getCC_DCTSTATUS__C());
				v = v.replace("#RecordTypeId", a.getRecordTypeId());
				if (cnt == 1) {
					insertSQL.append(v);
					insertSQL.append("\n");
				} else {
					insertSQL.append(",");
					insertSQL.append(v);
					insertSQL.append("\n");
				}
				cnt++;
			}
			insertSQL.append(";");
			//System.out.println(insertSQL.toString());
		} // insertDetCarga

		/*
		*/
		LocalDBProperties db = new LocalDBProperties();

		con = new ConnDB(db.getDriver(), db.getUrl(), db.getUser(), db.getPassword());

		try (Connection connection = con.getConnection();
				PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSQL.toString());) {

			prepsInsertProduct.execute();

		} catch (ClassNotFoundException | SQLException e) {

		}

	}

	public boolean insertDetCarga() {

		LocalDBProperties db = new LocalDBProperties();
		FileSQL file = new FileSQL();
		String insertSql = file.readSQL("insertDetCarga");
		con = new ConnDB(db.getDriver(), db.getUrl(), db.getUser(), db.getPassword());

		try (Connection connection = con.getConnection();
				PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql);) {

			prepsInsertProduct.execute();

			return true;
		} catch (ClassNotFoundException | SQLException e) {

		}

		return false;
	}

}
