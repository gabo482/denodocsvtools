package mx.global.denodocsvtools.entity;

public class AccountR9 {

	private String CC_ID_C;
	private String Name;
	private String CC_Nombre_del_Cliente_o_Razon_Social__c;
	private String CE_RFC__c;
	private String CE_Region__c;
	private String SPDR9_Estatus_Aplicacion_de_Pago__c;
	private String SP_DR9_Encuesta__c;
	private String CC_XO__C;
	private String CC_DCTSALESMANAGER__C;
	private String RecordTypeId;
	private String CC_DTCCUSTOMERID_C;
	private String CC_DCTSTATUS__C;
	private String CC_GRUPO__C;
	private String CC_DCTESTATUSCOBRANZA__C;
	private String CC_DCTBILLINGCYCLE__C;
	private String CC_DCTRAPREFERENCE__C;
	private String CC_DCTSAPSPORADICCUSTOMER__C;
	private String CC_SUBDIRECTORACTUAL__C;
	private String CC_CORREO_GERENCIA__C;
	private String stat_cobranza;

	public String getCC_ID_C() {
		return CC_ID_C;
	}

	public void setCC_ID_C(String cC_ID_C) {
		CC_ID_C = cC_ID_C;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCC_Nombre_del_Cliente_o_Razon_Social__c() {
		return CC_Nombre_del_Cliente_o_Razon_Social__c;
	}

	public void setCC_Nombre_del_Cliente_o_Razon_Social__c(String cC_Nombre_del_Cliente_o_Razon_Social__c) {
		CC_Nombre_del_Cliente_o_Razon_Social__c = cC_Nombre_del_Cliente_o_Razon_Social__c;
	}

	public String getCE_RFC__c() {
		return CE_RFC__c;
	}

	public void setCE_RFC__c(String cE_RFC__c) {
		CE_RFC__c = cE_RFC__c;
	}

	public String getCE_Region__c() {
		return CE_Region__c;
	}

	public void setCE_Region__c(String cE_Region__c) {
		CE_Region__c = cE_Region__c;
	}

	public String getSPDR9_Estatus_Aplicacion_de_Pago__c() {
		return SPDR9_Estatus_Aplicacion_de_Pago__c;
	}

	public void setSPDR9_Estatus_Aplicacion_de_Pago__c(String sPDR9_Estatus_Aplicacion_de_Pago__c) {
		SPDR9_Estatus_Aplicacion_de_Pago__c = sPDR9_Estatus_Aplicacion_de_Pago__c;
	}

	public String getSP_DR9_Encuesta__c() {
		return SP_DR9_Encuesta__c;
	}

	public void setSP_DR9_Encuesta__c(String sP_DR9_Encuesta__c) {
		SP_DR9_Encuesta__c = sP_DR9_Encuesta__c;
	}

	public String getCC_XO__C() {
		return CC_XO__C;
	}

	public void setCC_XO__C(String cC_XO__C) {
		CC_XO__C = cC_XO__C;
	}

	public String getCC_DCTSALESMANAGER__C() {
		return CC_DCTSALESMANAGER__C;
	}

	public void setCC_DCTSALESMANAGER__C(String cC_DCTSALESMANAGER__C) {
		CC_DCTSALESMANAGER__C = cC_DCTSALESMANAGER__C;
	}

	public String getRecordTypeId() {
		return RecordTypeId;
	}

	public void setRecordTypeId(String recordTypeId) {
		RecordTypeId = recordTypeId;
	}

	public String getCC_DTCCUSTOMERID_C() {
		return CC_DTCCUSTOMERID_C;
	}

	public void setCC_DTCCUSTOMERID_C(String cC_DTCCUSTOMERID_C) {
		CC_DTCCUSTOMERID_C = cC_DTCCUSTOMERID_C;
	}

	public String getCC_DCTSTATUS__C() {
		return CC_DCTSTATUS__C;
	}

	public void setCC_DCTSTATUS__C(String cC_DCTSTATUS__C) {
		CC_DCTSTATUS__C = cC_DCTSTATUS__C;
	}

	public String getCC_GRUPO__C() {
		return CC_GRUPO__C;
	}

	public void setCC_GRUPO__C(String cC_GRUPO__C) {
		CC_GRUPO__C = cC_GRUPO__C;
	}

	public String getCC_DCTESTATUSCOBRANZA__C() {
		return CC_DCTESTATUSCOBRANZA__C;
	}

	public void setCC_DCTESTATUSCOBRANZA__C(String cC_DCTESTATUSCOBRANZA__C) {
		CC_DCTESTATUSCOBRANZA__C = cC_DCTESTATUSCOBRANZA__C;
	}

	public String getCC_DCTBILLINGCYCLE__C() {
		return CC_DCTBILLINGCYCLE__C;
	}

	public void setCC_DCTBILLINGCYCLE__C(String cC_DCTBILLINGCYCLE__C) {
		CC_DCTBILLINGCYCLE__C = cC_DCTBILLINGCYCLE__C;
	}

	public String getCC_DCTRAPREFERENCE__C() {
		return CC_DCTRAPREFERENCE__C;
	}

	public void setCC_DCTRAPREFERENCE__C(String cC_DCTRAPREFERENCE__C) {
		CC_DCTRAPREFERENCE__C = cC_DCTRAPREFERENCE__C;
	}

	public String getCC_DCTSAPSPORADICCUSTOMER__C() {
		return CC_DCTSAPSPORADICCUSTOMER__C;
	}

	public void setCC_DCTSAPSPORADICCUSTOMER__C(String cC_DCTSAPSPORADICCUSTOMER__C) {
		CC_DCTSAPSPORADICCUSTOMER__C = cC_DCTSAPSPORADICCUSTOMER__C;
	}

	public String getCC_SUBDIRECTORACTUAL__C() {
		return CC_SUBDIRECTORACTUAL__C;
	}

	public void setCC_SUBDIRECTORACTUAL__C(String cC_SUBDIRECTORACTUAL__C) {
		CC_SUBDIRECTORACTUAL__C = cC_SUBDIRECTORACTUAL__C;
	}

	public String getCC_CORREO_GERENCIA__C() {
		return CC_CORREO_GERENCIA__C;
	}

	public void setCC_CORREO_GERENCIA__C(String cC_CORREO_GERENCIA__C) {
		CC_CORREO_GERENCIA__C = cC_CORREO_GERENCIA__C;
	}

	
	
	

	public String rowCSV() {
		return  "\"" +CC_ID_C+"\","+				
				"\"" +CE_RFC__c+ "\","+
				"\"" +Name+ "\" ,"+
				"\"" +CC_Nombre_del_Cliente_o_Razon_Social__c+ "\","+
				"\"" +CE_Region__c+ "\","+
				"\"" +CC_XO__C+ "\","+						
				"\"" +CC_DCTSALESMANAGER__C+ "\","+				
				"\"" +CC_DTCCUSTOMERID_C+ "\","+
				"\"" +CC_DCTSTATUS__C+ "\","+				
				"\"" +CC_GRUPO__C+ "\","+
				"\"" +CC_DCTESTATUSCOBRANZA__C+ "\","+	
				"\"" +CC_DCTBILLINGCYCLE__C+ "\","+
				"\"" +CC_DCTRAPREFERENCE__C+ "\" ,"+
				"\"" +CC_DCTSAPSPORADICCUSTOMER__C+ "\","+
				"\"" +CC_SUBDIRECTORACTUAL__C+ "\","+							
				//"\"" +CC_CORREO_GERENCIA__C+ "\" ,"+
				"\"" +SP_DR9_Encuesta__c+ "\","+
				"\"" +SPDR9_Estatus_Aplicacion_de_Pago__c+ "\","+								
				"\"" +RecordTypeId+ "\"\n";	
	}
	
	
	@Override
	public String toString() {
		return "AccountR9 [CC_ID_C=" + CC_ID_C + ", Name=" + Name + ", CC_Nombre_del_Cliente_o_Razon_Social__c="
				+ CC_Nombre_del_Cliente_o_Razon_Social__c + ", CE_RFC__c=" + CE_RFC__c + ", CE_Region__c="
				+ CE_Region__c + ", SPDR9_Estatus_Aplicacion_de_Pago__c=" + SPDR9_Estatus_Aplicacion_de_Pago__c
				+ ", SP_DR9_Encuesta__c=" + SP_DR9_Encuesta__c + ", CC_XO__C=" + CC_XO__C + ", CC_DCTSALESMANAGER__C="
				+ CC_DCTSALESMANAGER__C + ", RecordTypeId=" + RecordTypeId + ", CC_DTCCUSTOMERID_C="
				+ CC_DTCCUSTOMERID_C + ", CC_DCTSTATUS__C=" + CC_DCTSTATUS__C + ", CC_GRUPO__C=" + CC_GRUPO__C
				+ ", CC_DCTESTATUSCOBRANZA__C=" + CC_DCTESTATUSCOBRANZA__C + ", CC_DCTBILLINGCYCLE__C="
				+ CC_DCTBILLINGCYCLE__C + ", CC_DCTRAPREFERENCE__C=" + CC_DCTRAPREFERENCE__C
				+ ", CC_DCTSAPSPORADICCUSTOMER__C=" + CC_DCTSAPSPORADICCUSTOMER__C + ", CC_SUBDIRECTORACTUAL__C="
				+ CC_SUBDIRECTORACTUAL__C + ", CC_CORREO_GERENCIA__C=" + CC_CORREO_GERENCIA__C + ", stat_cobranza="
				+ stat_cobranza + "]";
	}
	
	
}