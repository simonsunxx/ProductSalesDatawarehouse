package entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import DB.dbtest;

public class Product_Mgr {
	public HashMap getProductList()
	{
		HashMap<Integer,Product> map=new HashMap<Integer,Product>();
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		Product product=null;
		try{ 
			con=dbtest.getconnect();
			String sql="";
			sql="select product_id,product_name,product_description,list_price,min_price from products";

			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				product=new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
				map.put(rs.getInt(1), product);
				
			}

			
		}catch(Exception se)
		{
			se.printStackTrace();
		}		
		return map;
	}
    public int getProductPrice(int pid)
    {
    	int price=0;
    	Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		Product product=null;
		try{ 
			con=dbtest.getconnect();
			String sql="";
			sql="select list_price from products where product_id="+pid;

			st=con.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()) price=rs.getInt(1);
			
		}catch(Exception se)
		{
			se.printStackTrace();
		}
		return price;
    }
    public int getProductCost(int pid)
    {
    	int cost=0;
    	Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		Product product=null;
		try{ 
			con=dbtest.getconnect();
			String sql="";
			sql="select min_price from products where product_id="+pid;

			st=con.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()) cost=rs.getInt(1);
			
		}catch(Exception se)
		{
			se.printStackTrace();
		}
		return cost;
    }
}
