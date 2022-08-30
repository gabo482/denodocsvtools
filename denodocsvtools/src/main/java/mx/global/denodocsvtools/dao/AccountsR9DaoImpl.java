package mx.global.denodocsvtools.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.global.denodocsvtools.entity.AccountR9;
import mx.global.denodocsvtools.util.*;

public class AccountsR9DaoImpl {

	private ConnDB con;
	private FileSQL f;

	private String getSQL() {

		String sql = "";
		f = new FileSQL();
		sql = f.readSQL("getAllAccountsDC");
		System.out.println(sql);
		return sql;
	}

	public List<AccountR9> getAll() {
		DenodoProperties d = new DenodoProperties();
		con = new ConnDB(d.getDriver(), d.getUrl(), d.getUser(), d.getPassword());

		List<AccountR9> accounts = new ArrayList<AccountR9>();

		try (Connection connection = con.getConnection()) {
			Statement st = connection.createStatement();
			String query = getSQL();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				AccountR9 account = new AccountR9();

				account.setCC_ID_C(rs.getString("CC_ID__c"));
				account.setCE_RFC__c(rs.getString("CE_RFC__c"));
				account.setName(rs.getString("Name"));				
				account.setCC_Nombre_del_Cliente_o_Razon_Social__c(rs.getString("CC_Nombre_del_Cliente_o_Razon_Social__c"));
				account.setCE_Region__c(rs.getString("CE_Region__c"));
				account.setCC_XO__C(rs.getString("CC_XO__C"));
				account.setCC_DCTSALESMANAGER__C(rs.getString("CC_DCTSALESMANAGER__C"));								
				account.setCC_DTCCUSTOMERID_C(rs.getString("CC_DTCCUSTOMERID_C"));														
				account.setCC_DCTSTATUS__C(rs.getString("CC_DCTSTATUS__C"));
				account.setCC_GRUPO__C(rs.getString("CC_GRUPO__C"));
				account.setCC_DCTBILLINGCYCLE__C(rs.getString("CC_DCTBILLINGCYCLE__C"));
				account.setCC_DCTRAPREFERENCE__C(rs.getString("CC_DCTRAPREFERENCE__C"));
				account.setCC_DCTSAPSPORADICCUSTOMER__C(rs.getString("CC_DCTSAPSPORADICCUSTOMER__C"));
				account.setCC_SUBDIRECTORACTUAL__C(rs.getString("CC_SUBDIRECTORACTUAL__C"));
				//account.setCC_CORREO_GERENCIA__C(rs.getString("CC_CORREO_GERENCIA__C"));
				account.setSPDR9_Estatus_Aplicacion_de_Pago__c(rs.getString("SPDR9_Estatus_Aplicacion_de_Pago__c"));
				account.setSP_DR9_Encuesta__c(rs.getString("SP_DR9_Encuesta__c"));
				account.setCC_DCTESTATUSCOBRANZA__C(rs.getString("cC_DCTESTATUSCOBRANZA__C"));
				account.setRecordTypeId(rs.getString("RecordTypeId"));
				//account.setRecordTypeId(rs.getString("RecordTypeId"));
				accounts.add(account);
			}

			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}

		// ;
		return accounts;
	}

	/*
	 * #CC_ID_C #Name #CC_Nombre_del_Cliente_o_Razon_Social__c
	 * #CE_RFC__c #CE_Region__c #SPDR9_Estatus_Aplicacion_de_Pago__c 
	 * #SP_DR9_Encuesta__c #CC_XO__C #CC_DCTSALESMANAGER__C 
	 * #CC_DTCCUSTOMERID_C #CC_DCTSTATUS__C
	 * #CC_GRUPO__C #CC_DCTBILLINGCYCLE__C #CC_DCTRAPREFERENCE__C
	 * #CCC_DCTSAPSPORADICCUSTOMER__C #CC_SUBDIRECTORACTUAL__C #CC_CORREO_GERENCIA__C
	 */

	public void insertAll(List<AccountR9> accounts) {
		FileSQL file = new FileSQL();
		String sql = file.readSQL("insertAccountR9");
		StringBuilder insertSQL = new StringBuilder();
		insertSQL.append(sql);
		String v;
		int cnt = 1;
		if (insertDetCarga()) {
			for (AccountR9 a : accounts) {
				StringBuilder sb = new StringBuilder();
				//sb.append("( nextval('id')"); //cnt
				sb.append("(");
				sb.append(cnt);
				sb.append(",(select last_value from carga_id)");
				sb.append(",'#cc_id__c'");
				sb.append(",'#Name'");
				sb.append(",'#CC_Nombre_del_Cliente_o_Razon_Social__c'");
				sb.append(",'#CE_RFC__c'");
				sb.append(",'#CE_Region__c'");
				sb.append(",'#SPDR9_Estatus_Aplicacion_de_Pago__c'");
				sb.append(",'#SP_DR9_Encuesta__c'");
				sb.append(",'#CCC_XO__C'");
				sb.append(",'#CC_DCTSALESMANAGER__C'");
				sb.append(",'#CC_DTCCUSTOMERID_C'");
				sb.append(",'#CC_DCTSTATUS__C'");
				sb.append(",'#CC_GRUPO__C'");
				sb.append(",'#CC_DCTBILLINGCYCLE__C'");
				sb.append(",'#CC_DCTRAPREFERENCE__C'");
				sb.append(",'#CC_DCTSAPSPORADICCUSTOMER__C'");
				sb.append(",'#CC_SUBDIRECTORACTUAL__C'");
				sb.append(",'#CC_CORREO_GERENCIA__C')");
				v = sb.toString();
				//v = v.replace("#cc_id__c", a.getCc_id_c());
				v = v.replace("#Name", a.getName());
				v = v.replace("#CC_Nombre_del_Cliente_o_Razon_Social__c",
						a.getCC_Nombre_del_Cliente_o_Razon_Social__c());
				v = v.replace("#CE_RFC__c", a.getCE_RFC__c());
				v = v.replace("#CE_Region__c", a.getCE_Region__c());
				v = v.replace("#SPDR9_Estatus_Aplicacion_de_Pago__c", a.getSPDR9_Estatus_Aplicacion_de_Pago__c());
				v = v.replace("#SP_DR9_Encuesta__c", a.getSP_DR9_Encuesta__c());
				v = v.replace("#CC_XO__C", a.getCC_XO__C());
				v = v.replace("#CC_DCTSALESMANAGER__C", a.getCC_DCTSALESMANAGER__C());
				v = v.replace("#CC_DTCCUSTOMERID_C", a.getCC_DTCCUSTOMERID_C());
				v = v.replace("#CC_DCTSTATUS__C", a.getCC_DCTSTATUS__C());
				v = v.replace("#CC_GRUPO__C", a.getCC_GRUPO__C());
				v = v.replace("#CC_DCTBILLINGCYCLE__C", a.getCC_DCTBILLINGCYCLE__C());
				v = v.replace("#CC_DCTRAPREFERENCE__C", a.getCC_DCTRAPREFERENCE__C());
				v = v.replace("#CC_DCTSAPSPORADICCUSTOMER__C", a.getCC_DCTSAPSPORADICCUSTOMER__C());
				v = v.replace("#CC_SUBDIRECTORACTUAL__C", a.getCC_SUBDIRECTORACTUAL__C());
				v = v.replace("#CC_CORREO_GERENCIA__C", a.getCC_CORREO_GERENCIA__C());
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