package entity;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import DB.dbtest;

public class User_Mgr {
	public HashMap getUserList()
	{
    	HashMap User_List=new HashMap();
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		User user=null;
		try{ 
			con=dbtest.getconnect();
			String sql="";
			sql="select user_id,user_password,user_permission,user_name from user";

			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				user=new User(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4));
				User_List.put(rs.getInt(1), user);
				
			}

			
		}catch(Exception se)
		{
			se.printStackTrace();
		}
		return User_List;
	}
    public int verifyUser(int id,int password){
    	int result=0;
    	Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try{ 
			con=dbtest.getconnect();
			String sql="";
			sql="select user_permission from user where user_id="+id+" and user_password="+password;
			st=con.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next())
			{
				result=rs.getInt(1);
			}
			
		}catch(Exception se)
		{
			se.printStackTrace();
		}
		return result;
    }
    public int editUser(User user)
    {
    	int result=0;
    	Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try{ 
			con=dbtest.getconnect();
			String sql="";
			sql="update user set user_password="+user.getUser_password()+", user_name='"+user.getUser_name()+"'"
				+" where user_id="+user.getUser_id();
			st=con.createStatement();
			result=st.executeUpdate(sql);
		}catch(Exception se)
		{
			se.printStackTrace();
		}
    	return result;
    }
    public int deleteUser(User user)
    {
    	int result=0;
    	Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try{ 
			con=dbtest.getconnect();
			String sql="";
			sql="delete from USER where user_id="+user.getUser_id();
			st=con.createStatement();
			result=st.executeUpdate(sql);
		}catch(Exception se)
		{
			se.printStackTrace();
		}
    	return result;
    }
}
