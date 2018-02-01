package entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import DB.dbtest;

public class Customer_Mgr {
	public HashMap getCustomerList()
	{
		HashMap<Integer,Customer> map=new HashMap<Integer,Customer>();
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		Product product=null;
		try{ 
			con=dbtest.getconnect();
			String sql="";
			sql="select customer_id, country_id from Customers";

			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				Customer c=new Customer(rs.getInt(1),rs.getInt(2));
				map.put(rs.getInt(1), c);
				
			}
			
		}catch(Exception se)
		{
			se.printStackTrace();
		}	
		return map;
	}

}
