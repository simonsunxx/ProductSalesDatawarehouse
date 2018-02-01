package entity;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import DB.dbtest;

public class Sales_fact_hive_Mgr {
	public HashMap getSalesFactChannel(int option)
	{
		HashMap SALES_FACT=new HashMap();
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		Sales_fact_hive sfh=null;
		try{ 
			con=dbtest.getconnect();
			String sql="";
			if(option==2)
			{
				sql="select SALES_FACT_ID,CHANNEL_ID,CHANNEL_DESC,TIME_ID,CALENDAR_MONTH_NUMBER"
						+ ",CALENDAR_YEAR,TOTAL from salesfact_channel_by_month";
				
			}
			else
			{
				sql="select SALES_FACT_ID,CHANNEL_ID,CHANNEL_DESC,TIME_ID,CALENDAR_MONTH_NUMBER"
						+ ",CALENDAR_YEAR,TOTAL from salesfact_channel_by_year";
			}

			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				sfh=new Sales_fact_hive(rs.getInt(1),rs.getInt(2),0,0,rs.getDate(4),0,0,0,0,rs.getString(3)," ",0,""," ",
						rs.getInt(5),rs.getInt(6),0,"",rs.getInt(7));
				SALES_FACT.put(rs.getInt(1), sfh);
				
			}

			
		}catch(Exception se)
		{
			se.printStackTrace();
		}
		return SALES_FACT;
		
		
	}
	public HashMap getSalesFactCustomer(int option)

	{
		HashMap SALES_FACT=new HashMap();
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		Sales_fact_hive sfh=null;
		try{ 
			con=dbtest.getconnect();
			String sql="";
			if(option==2)
			{
				sql="select country_region,TIME_ID,CALENDAR_MONTH_NUMBER,CALENDAR_YEAR,COUNTRY_REGION_ID,total,sales_fact_id from salesfact_customer_by_month";
				
			}
			else
			{
				sql="select ii.country_region,iii.TIME_ID,v.CALENDAR_MONTH_NUMBER,v.CALENDAR_YEAR,ii.COUNTRY_REGION_ID,SUM(iii.UNIT_PRICE*iii.AMOUNT_SOLD) as total,iii.sales_fact_id from ((customers as i join countries as ii on i.COUNTRY_ID=ii.COUNTRY_ID)"
				         +"join sales_fact as iii on i.CUSTOMER_ID=iii.CUSTOMER_ID)"
				         + "join times as v  on iii.TIME_ID=v.TIME_ID GROUP BY ii.COUNTRY_REGION_ID,v.CALENDAR_YEAR";
			}

			st=con.createStatement();
			rs=st.executeQuery(sql);
			int i=0;
			while(rs.next()){
				i++;
				sfh=new Sales_fact_hive(rs.getInt(7),0,0,0,rs.getDate(2),0,0,0,0," ",rs.getString(1),rs.getInt(5),""," ",
						rs.getInt(3),rs.getInt(4),0,"",rs.getInt(6));
				SALES_FACT.put(i, sfh);
				
			}

			
		}catch(Exception se)
		{
			se.printStackTrace();
		}
		return SALES_FACT;
		
		
	}
    public HashMap getSalesFactAmount()
    {
		HashMap SALES_FACT=new HashMap();
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		Sales_fact_hive sfh=null;
		try{ 
			con=dbtest.getconnect();
			String sql="";
			sql="select total,CATEGORY_ID,CATEGORY_NAME,CALENDAR_YEAR,TIME_ID,sales_fact_id from salesfact_amount";

			st=con.createStatement();
			rs=st.executeQuery(sql);
			int i=0;
			while(rs.next()){
				sfh=new Sales_fact_hive(rs.getInt(5),0,0,0,rs.getDate(5),0,0,0,0,""," ",0,""," ",
						0,rs.getInt(4),rs.getInt(2),rs.getString(3),rs.getInt(1));
				i++;
				SALES_FACT.put(i, sfh);
				
			}

			
		}catch(Exception se)
		{
			se.printStackTrace();
		}
		return SALES_FACT;
    }
    public HashMap getSalesFactAmount2()
    {
    	HashMap SALES_FACT=new HashMap();
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		Sales_fact_hive sfh=null;
		try{ 
			con=dbtest.getconnect();
			String sql="";
			sql="select  total,CATEGORY_ID,CATEGORY_NAME,CALENDAR_YEAR,TIME_ID,sales_fact_id from salesfact_amount";

			st=con.createStatement();
			rs=st.executeQuery(sql);
			int i=0;
			while(rs.next()){
				sfh=new Sales_fact_hive(rs.getInt(5),0,0,0,rs.getDate(5),0,0,0,0,""," ",0,""," ",
						0,rs.getInt(4),rs.getInt(2),rs.getString(3),rs.getInt(1));
				i++;
				SALES_FACT.put(i, sfh);
				
			}

			
		}catch(Exception se)
		{
			se.printStackTrace();
		}
		return SALES_FACT;
    }
    public HashMap getSalesFactList()
    {
    	HashMap SALES_FACT=new HashMap();
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		Sales_fact_hive sfh=null;
		try{ 
			con=dbtest.getconnect();
			String sql="";
				sql="select sales_fact_id,channel_id,product_id,customer_id,unit_price,amount_sold,time_id from sales_fact";

			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				sfh=new Sales_fact_hive(rs.getInt(1),rs.getInt(2),0,rs.getInt(4),rs.getDate(7),rs.getInt(3),rs.getInt(6),rs.getInt(5),0,rs.getString(3)," ",0,""," ",
						rs.getInt(5),rs.getInt(6),0,"",rs.getInt(7));
				SALES_FACT.put(rs.getInt(1), sfh);
				
			}

			
		}catch(Exception se)
		{
			se.printStackTrace();
		}
		return SALES_FACT;
		
		
}
    public HashMap getSalesCountry()
    {
    	HashMap SALES_FACT=new HashMap();
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		Sales_fact_hive sfh=null;
		try{ 
			con=dbtest.getconnect();
			String sql="";
			sql="select sales_fact_id,COUNTRY_ID,country_name, total from  salesfact_country";

			st=con.createStatement();
			rs=st.executeQuery(sql);
			Date d=null;
			while(rs.next()){
				sfh=new Sales_fact_hive(rs.getInt(1),0,rs.getInt(2),0,d,0,0,0,0,"","",0,rs.getString(3),"",0,0,0,"",rs.getInt(4));
				SALES_FACT.put(rs.getInt(1), sfh);
				
			}

			
		}catch(Exception se)
		{
			se.printStackTrace();
		}
		return SALES_FACT;
    }
    public int addSaleFact(int pid,int cid,int chid,int as,String date)
    {
    	int result=0;
		Connection con=null;
		Statement st=null;
		Statement st2=null;
		Statement st3=null;
		ResultSet rs=null;
		ResultSet rs2=null;
		ResultSet urs=null;
		try{ 
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-mm-dd");
			Calendar cl=Calendar.getInstance();
			cl.setTime(sf.parse(date));
			int week=cl.get(Calendar.WEEK_OF_YEAR);
			int month=cl.get(Calendar.MONTH+1);
			int year=cl.get(Calendar.YEAR);
			con=dbtest.getconnect();
			Product_Mgr pm=new Product_Mgr();
			String sql1="";
			sql1="select * from times where time_id='"+date+"'";
			String sql2="";
			sql2="select max(sales_fact_id) from sales_fact";			
			st=con.createStatement();
			st2=con.createStatement();
			st3=con.createStatement();
			rs=st.executeQuery(sql1);
			rs2=st2.executeQuery(sql2);
			int sfid=0;
			if(rs2.next()) sfid=rs2.getInt(1)+1; 
			if(rs.next())
			{
				
				String sql3="insert into sales_fact(sales_fact_id,channel_id,customer_id,product_id,amount_sold,unit_price,unit_cost,time_id)"+
				            "values("+sfid+", "+chid+", "+cid+", "+pid+", "+as+", "+pm.getProductPrice(pid)+","+pm.getProductCost(pid)+", '"+date+"')";				
				result=st3.executeUpdate(sql3);
				System.out.println("sql3"+result);
				
			}
			else
			{
				String sql4="insert into times(time_id,calendar_month_number,calendar_year)"+"values( '"+date+"',"+month+", "+year+")";
				st3.execute(sql4);
				String sql3="insert into sales_fact(sales_fact_id,channel_id,customer_id,product_id,amount_sold,unit_price,unit_cost,time_id)"+
			            "values("+sfid+", "+chid+", "+cid+", "+pid+", "+as+", "+pm.getProductPrice(pid)+","+pm.getProductCost(pid)+", '"+date+"')";
				result=st3.executeUpdate(sql3);
				System.out.println("sql4"+result);
			}
			
		}catch(Exception se)
		{
			se.printStackTrace();
		}
    	return result;
    }
    public HashMap getSalesScatter()
    {
    	HashMap SALES_FACT=new HashMap();
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		Sales_fact_hive sfh=null;
		try{ 
			con=dbtest.getconnect();
			String sql="";
				sql="select sales_fact_id,channel_id,product_id,customer_id,unit_price,amount_sold,time_id from sales_fact";

			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				sfh=new Sales_fact_hive(rs.getInt(1),rs.getInt(2),0,rs.getInt(4),rs.getDate(7),rs.getInt(3),rs.getInt(6),rs.getInt(5),0,rs.getString(3)," ",0,""," ",
						rs.getInt(5),rs.getInt(6),0,"",rs.getInt(7));
				SALES_FACT.put(rs.getInt(1), sfh);
				
			}

			
		}catch(Exception se)
		{
			se.printStackTrace();
		}
		return SALES_FACT;
    }
    public int deleteSaleFact(int sid)
    {
    	int result=0;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;		
		try{ 
			con=dbtest.getconnect();
			String sql="";
				sql="delete from sales_fact where sales_fact_id="+sid;

			st=con.createStatement();
			result=st.executeUpdate(sql);			
		}catch(Exception se)
		{
			se.printStackTrace();
		}
		return result;
    }
    public HashMap getProfit(int option)
    {
    	HashMap SALES_FACT=new HashMap();
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		Sales_fact_hive sfh=null;
		try{ 
			con=dbtest.getconnect();
			String sql="";
			if(option==2)
			{
				sql="select SALES_FACT_ID,CHANNEL_ID,i.TIME_ID,CALENDAR_MONTH_NUMBER"
						+ ",CALENDAR_YEAR, SUM(AMOUNT_SOLD*(UNIT_PRICE-UNIT_COST)) AS TOTAL from sales_fact as i join times as ii on i.time_id=ii.time_id  group by calendar_month_number,calendar_year" ;
				
			}
			else
			{
				sql="select SALES_FACT_ID,CHANNEL_ID,i.TIME_ID,CALENDAR_MONTH_NUMBER"
						+ ",CALENDAR_YEAR, SUM(AMOUNT_SOLD*(UNIT_PRICE-UNIT_COST)) AS TOTAL from sales_fact as i join times as ii on i.time_id=ii.time_id group by calendar_year";
			}

			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				sfh=new Sales_fact_hive(rs.getInt(1),rs.getInt(2),0,0,rs.getDate(3),0,0,0,0,""," ",0,""," ",
						rs.getInt(4),rs.getInt(5),0,"",rs.getInt(6));
				SALES_FACT.put(rs.getInt(1), sfh);
				
			}

			
		}catch(Exception se)
		{
			se.printStackTrace();
		}
		return SALES_FACT;
    }
}
