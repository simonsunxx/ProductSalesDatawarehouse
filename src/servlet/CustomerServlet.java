package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Sales_fact_hive;
import entity.Sales_fact_hive_Mgr;
import net.sf.json.JSONObject;

public class CustomerServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try{
			   req.setCharacterEncoding("utf-8");  
	           resp.setContentType("utf-8");  
	           resp.setCharacterEncoding("utf-8");          
	           PrintWriter write = resp.getWriter();    
	           List<String> xAxisData = new ArrayList<String>();  
	           List< JSONObject> seriesList = new ArrayList< JSONObject>();  
	           List<String> legendData=new ArrayList<String>(); 
	           String category=req.getParameter("op2");
	           int c=Integer.parseInt(category);
	           Sales_fact_hive_Mgr sfhm=new Sales_fact_hive_Mgr();
	           HashMap<Integer,Sales_fact_hive> map=new HashMap<Integer,Sales_fact_hive>();
	           map=sfhm.getSalesFactCustomer(Integer.parseInt(category));
	           Iterator it=map.keySet().iterator();
	           int i=0;
	           int j=0;
	           List<Integer> year1=new ArrayList<Integer>();
	           List<Integer> year2=new ArrayList<Integer>();
	           if(c==1)
	           {
	        	   List<Integer> count=new ArrayList<Integer>();
	        	   int maxyear=0;
	        	   int max=0;
	        	   while(it.hasNext())
	        	   {
	        		   Sales_fact_hive sfh=(Sales_fact_hive)map.get(it.next());
	        		   if(max<sfh.getCOUNTRY_REGION_ID()) max=sfh.getCOUNTRY_REGION_ID();
	        		   count.add(sfh.getCALENDAR_YEAR());
	        		   maxyear++;
	        	   }
	        	   Collections.sort(count);
	        	   for(int t=count.get(0);t<=count.get(maxyear-1);t++)
	        	   {
	        		   xAxisData.add(((Integer)t).toString());
	        	   }
	        	   it=map.keySet().iterator();
	        	   for(int t=1;t<=max;t++)
	        	   {
	        		   HashMap<Integer,Integer> sales=new HashMap<Integer,Integer>();
	        		   it=map.keySet().iterator();
	        		   int temp=0;
	        		   List<Integer> tempcount=new ArrayList<Integer>();
	        		   List<Integer> salecus=new ArrayList<Integer>();
	        		   String regionname="";
	        		   while(it.hasNext())
	        		   {
	        			   Sales_fact_hive sfh=(Sales_fact_hive)map.get(it.next());
	        			   if(sfh.getCOUNTRY_REGION_ID()==t)
	        			   {
	        				   sales.put(sfh.getCALENDAR_YEAR(), sfh.getTOTAL());
	        				   regionname=sfh.getCOUNTRY_REGION();
	        				   tempcount.add(sfh.getCALENDAR_YEAR());
	        				   temp++;
	        				   
	        			   }
	        		   }
	        		   Collections.sort(tempcount);
	        		   for(int l=0;l<temp;l++)
	        		   {
	        			   salecus.add(sales.get(tempcount.get(l)));
	        		   }
	        		   legendData.add(regionname);
	                   Series series1=new Series(regionname,Series.TYPE_LINE,salecus);
	                   JSONObject jsonObject2 = new JSONObject();
	                   jsonObject2.put("name", series1.toName());  
	                   jsonObject2.put("type","bar");  
	                   jsonObject2.put("data",series1.data);  
	                   seriesList.add(jsonObject2); 
	        		   
	        	   }	   
	           }
	           if(c==2)
	           {
	        	   List<Integer> count=new ArrayList<Integer>();
	        	   int maxyear=0;
	        	   int max=0;
	        	   int maxmonth=0;
	        	   while(it.hasNext())
	        	   {
	        		   Sales_fact_hive sfh=(Sales_fact_hive)map.get(it.next());
	        		   if(max<sfh.getCOUNTRY_REGION_ID()) max=sfh.getCOUNTRY_REGION_ID();
	        		   if(maxyear<sfh.getCALENDAR_YEAR()) maxyear=sfh.getCALENDAR_YEAR();
	        		   if(maxmonth<sfh.getCALENDAR_MONTH_NUMBER()) maxmonth=sfh.getCALENDAR_MONTH_NUMBER(); 
	        		   count.add(sfh.getCALENDAR_YEAR());
	        	   }
	        	   Collections.sort(count);
	        	   for(int t=count.get(0);t<=maxyear;t++)
	        	   {
	        		  for(int s=1;s<=maxmonth;s++)
	        		  {
	        			  xAxisData.add(t+"-"+s);
	        		  }
	        	   }
	        	   it=map.keySet().iterator();
	        	   for(int t=1;t<=max;t++)
	        	   {
	        		   HashMap<String,Integer> sales=new HashMap<String,Integer>();
	        		   it=map.keySet().iterator();
	        		   int temp=0;
	        		   List<Integer> salecus=new ArrayList<Integer>();//销售额
	        		   String regionname="";//销售地区
	        		   String yearandmonth="";
	        		   while(it.hasNext())
	        		   {
	        			   Sales_fact_hive sfh=(Sales_fact_hive)map.get(it.next());
	        			   if(sfh.getCOUNTRY_REGION_ID()==t)
	        			   {
	        				   yearandmonth=sfh.getCALENDAR_YEAR()+"-"+sfh.getCALENDAR_MONTH_NUMBER();
	        				   sales.put(yearandmonth,sfh.getTOTAL());
	        				   regionname=sfh.getCOUNTRY_REGION();
	        			   }
	        		   }
	        		   for(int m=count.get(0);m<=maxyear;m++)
	        		   {
	        			   {
	        				   for(int n=1;n<=maxmonth;n++)
	        				   {
	        					   salecus.add(sales.get(m+"-"+n));
	        				   }
	        			   }
	        		   }
	        		   legendData.add(regionname);
	                   Series series1=new Series(regionname,Series.TYPE_LINE,salecus);
	                   JSONObject jsonObject2 = new JSONObject();
	                   jsonObject2.put("name", series1.toName());  
	                   jsonObject2.put("type","bar");  
	                   jsonObject2.put("data",series1.data);  
	                   seriesList.add(jsonObject2); 
	        		   
	        	   }	   
	        	   
	           }
	           JSONObject jsonObject1 = new JSONObject();
	           jsonObject1.put("legendData", legendData);  
	           jsonObject1.put("xAxisData", xAxisData);  
	             
	           jsonObject1.put("seriesList", seriesList);  
	           //System.out.println(1235156);
	           System.out.print(jsonObject1.toString());
	           //发送给前台  
	           write.write(jsonObject1.toString());  
	           write.flush();  
	           write.close();  
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	

}
