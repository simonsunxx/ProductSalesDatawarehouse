package entity;
import java.sql.*;

public class Sales_fact_hive {
	int SALES_FACT_ID;
	int CHANNEL_ID;
	int COUNTRY_ID;
	int CUSTOMER_ID;
	Date TIME_ID;
	int PRODUCT_ID;
	int AMOUNT_SOLD;
	int UNIT_PRICE;
	int UNIT_COST;
	String CHANNEL_DESC;
	String COUNTRY_REGION;
	int  COUNTRY_REGION_ID;
    String COUNTRY_NAME;
	String PRODUCT_NAME;
	int CALENDAR_MONTH_NUMBER;
    int CALENDAR_YEAR;
    int CATEGORY_ID;
    String CATEGORY_NAME;
    int TOTAL;
    
	public Sales_fact_hive(int sALES_FACT_ID, int cHANNEL_ID, int cOUNTRY_ID,
			int cUSTOMER_ID, Date tIME_ID, int pRODUCT_ID, int aMOUNT_SOLD,
			int uNIT_PRICE, int uNIT_COST, String cHANNEL_DESC,
			String cOUNTRY_REGION,int cOUNTRY_REGION_ID,String cOUNTRY_NAME,String pRODUCT_NAME,
			int cALENDAR_MONTH_NUMBER, int cALENDAR_YEAR, int cATEGORY_ID,String cATEGORY_NAME,int tOTAL) {
		super();
		SALES_FACT_ID = sALES_FACT_ID;
		CHANNEL_ID = cHANNEL_ID;
		COUNTRY_ID = cOUNTRY_ID;
		CUSTOMER_ID = cUSTOMER_ID;
		TIME_ID = tIME_ID;
		PRODUCT_ID = pRODUCT_ID;
		AMOUNT_SOLD = aMOUNT_SOLD;
		UNIT_PRICE = uNIT_PRICE;
		UNIT_COST = uNIT_COST;
		CHANNEL_DESC = cHANNEL_DESC;
		COUNTRY_REGION = cOUNTRY_REGION;
		COUNTRY_REGION_ID=cOUNTRY_REGION_ID;
		COUNTRY_NAME=cOUNTRY_NAME;
		PRODUCT_NAME = pRODUCT_NAME;
		CALENDAR_MONTH_NUMBER = cALENDAR_MONTH_NUMBER;
		CALENDAR_YEAR = cALENDAR_YEAR;
		CATEGORY_ID=cATEGORY_ID;
		CATEGORY_NAME=cATEGORY_NAME;
		TOTAL = tOTAL;
	}
	public int getSALES_FACT_ID() {
		return SALES_FACT_ID;
	}
	public void setSALES_FACT_ID(int sALES_FACT_ID) {
		SALES_FACT_ID = sALES_FACT_ID;
	}
	public int getCHANNEL_ID() {
		return CHANNEL_ID;
	}
	public void setCHANNEL_ID(int cHANNEL_ID) {
		CHANNEL_ID = cHANNEL_ID;
	}
	public int getCOUNTRY_ID() {
		return COUNTRY_ID;
	}
	public void setCOUNTRY_ID(int cOUNTRY_ID) {
		COUNTRY_ID = cOUNTRY_ID;
	}
	public int getCUSTOMER_ID() {
		return CUSTOMER_ID;
	}
	public void setCUSTOMER_ID(int cUSTOMER_ID) {
		CUSTOMER_ID = cUSTOMER_ID;
	}
	public Date getTIME_ID() {
		return TIME_ID;
	}
	public void setTIME_ID(Date tIME_ID) {
		TIME_ID = tIME_ID;
	}
	public int getPRODUCT_ID() {
		return PRODUCT_ID;
	}
	public void setPRODUCT_ID(int pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}
	public int getAMOUNT_SOLD() {
		return AMOUNT_SOLD;
	}
	public void setAMOUNT_SOLD(int aMOUNT_SOLD) {
		AMOUNT_SOLD = aMOUNT_SOLD;
	}
	public int getUNIT_PRICE() {
		return UNIT_PRICE;
	}
	public void setUNIT_PRICE(int uNIT_PRICE) {
		UNIT_PRICE = uNIT_PRICE;
	}
	public int getUNIT_COST() {
		return UNIT_COST;
	}
	public void setUNIT_COST(int uNIT_COST) {
		UNIT_COST = uNIT_COST;
	}
	public String getCHANNEL_DESC() {
		return CHANNEL_DESC;
	}
	public void setCHANNEL_DESC(String cHANNEL_DESC) {
		CHANNEL_DESC = cHANNEL_DESC;
	}
	public String getCOUNTRY_REGION() {
		return COUNTRY_REGION;
	}
	public void setCOUNTRY_REGION(String cOUNTRY_REGION) {
		COUNTRY_REGION = cOUNTRY_REGION;
	}
	public String getPRODUCT_NAME() {
		return PRODUCT_NAME;
	}
	public void setPRODUCT_NAME(String pRODUCT_NAME) {
		PRODUCT_NAME = pRODUCT_NAME;
	}
	public int getCALENDAR_MONTH_NUMBER() {
		return CALENDAR_MONTH_NUMBER;
	}
	public void setCALENDAR_MONTH_NUMBER(int cALENDAR_MONTH_NUMBER) {
		CALENDAR_MONTH_NUMBER = cALENDAR_MONTH_NUMBER;
	}
	public int getCALENDAR_YEAR() {
		return CALENDAR_YEAR;
	}
	public void setCALENDAR_YEAR(int cALENDAR_YEAR_NUMBER) {
		CALENDAR_YEAR = cALENDAR_YEAR_NUMBER;
	}
	public int getTOTAL() {
		return TOTAL;
	}
	public void setTOTAL(int tOTAL) {
		TOTAL = tOTAL;
	}
	public int getCOUNTRY_REGION_ID() {
		return COUNTRY_REGION_ID;
	}
	public void setCOUNTRY_REGION_ID(int cOUNTRY_REGION_ID) {
		COUNTRY_REGION_ID = cOUNTRY_REGION_ID;
	}
	
	public String getCATEGORY_NAME() {
		return CATEGORY_NAME;
	}
	public void setCATEGORY_NAME(String cATEGORY_NAME) {
		CATEGORY_NAME = cATEGORY_NAME;
	}
	public int getCATEGORY_ID() {
		return CATEGORY_ID;
	}
	public void setCATEGORY_ID(int cATEGORY_ID) {
		CATEGORY_ID = cATEGORY_ID;
	}
	public String getCOUNTRY_NAME() {
		return COUNTRY_NAME;
	}
	public void setCOUNTRY_NAME(String cOUNTRY_NAME) {
		COUNTRY_NAME = cOUNTRY_NAME;
	}
	
    
}
