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

import net.sf.json.JSONObject;
import entity.Sales_fact_hive;
import entity.Sales_fact_hive_Mgr;

public class profitServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try{
			   req.setCharacterEncoding("utf-8");  
	           resp.setContentType("utf-8");  
	           resp.setCharacterEncoding("utf-8");          
	           PrintWriter write = resp.getWriter();    
	           List<String> yAxisData = new ArrayList<String>();  
	           List< JSONObject> seriesList = new ArrayList< JSONObject>();  
	           List<String> legendData=new ArrayList<String>(); 
	           String category=req.getParameter("op2");
	           int c=Integer.parseInt(category);
	           Sales_fact_hive_Mgr sfhm=new Sales_fact_hive_Mgr();
	           HashMap<Integer,Sales_fact_hive> map=new HashMap<Integer,Sales_fact_hive>();
	           map=sfhm.getProfit(Integer.parseInt(category));
	           Iterator it=map.keySet().iterator();
	           int i=0;
	           int j=0;
	           if(c==1)
	           {
	        	   HashMap<Integer,Integer> pro=new HashMap<Integer,Integer>();
	        	   List<Integer> count=new ArrayList<Integer>();
	        	   List<Integer> profit=new ArrayList<Integer>();
	        	   int maxyear=0;
	        	   while(it.hasNext())
	        	   {
	        		   Sales_fact_hive sfh=(Sales_fact_hive)map.get(it.next());	
	        		   pro.put(sfh.getCALENDAR_YEAR(), sfh.getTOTAL());
	        		   count.add(sfh.getCALENDAR_YEAR());
	        		   if(sfh.getCALENDAR_YEAR()>maxyear) maxyear=sfh.getCALENDAR_YEAR();
	        		   
	        	   }
	        	   Collections.sort(count);
	        	   for(int y=count.get(0);y<=maxyear;y++)
	        	   {
	        		   yAxisData.add(((Integer)y).toString());
	        		   profit.add(pro.get(y));
	        	   }
	        	   
	        		   legendData.add("profit");
	                   Series series1=new Series("profit",Series.TYPE_LINE,profit);
	                   JSONObject jsonObject2 = new JSONObject();
	                   jsonObject2.put("name", series1.toName());  
	                   jsonObject2.put("type","bar");  
	                   jsonObject2.put("data",series1.data);  
	                   seriesList.add(jsonObject2); 
	        		   
	        	   }	   	           
	           if(c==2)
	           {
	        	   List<Integer> count=new ArrayList<Integer>();
	        	   List<Integer> mprofit=new ArrayList<Integer>();
	        	   int maxyear=0;
	        	   int max=0;
	        	   int maxmonth=0;
	        	   HashMap<String,Integer> mpro=new HashMap<String,Integer>();
	        	   while(it.hasNext())
	        	   {
	        		   Sales_fact_hive sfh=(Sales_fact_hive)map.get(it.next());
	        		   if(maxyear<sfh.getCALENDAR_YEAR()) maxyear=sfh.getCALENDAR_YEAR();
	        		   if(maxmonth<sfh.getCALENDAR_MONTH_NUMBER()) maxmonth=sfh.getCALENDAR_MONTH_NUMBER(); 
	        		   count.add(sfh.getCALENDAR_YEAR());
	        		   mpro.put(sfh.getCALENDAR_YEAR()+"-"+sfh.getCALENDAR_MONTH_NUMBER(), sfh.getTOTAL());
	        	   }
	        	   Collections.sort(count);
	        	   for(int t=count.get(0);t<=maxyear;t++)
	        	   {
	        		  for(int s=1;s<=maxmonth;s++)
	        		  {
	        			  yAxisData.add(t+"-"+s);
	        			  mprofit.add(mpro.get(t+"-"+s));
	        		  }
	        	   }	        	  
	        		   legendData.add("profit");
	                   Series series1=new Series("profit",Series.TYPE_LINE,mprofit);
	                   JSONObject jsonObject2 = new JSONObject();
	                   jsonObject2.put("name", series1.toName());  
	                   jsonObject2.put("type","bar");  
	                   jsonObject2.put("data",series1.data);  
	                   seriesList.add(jsonObject2); 
	        		   
	        	      
	        	   
	           }
	           JSONObject jsonObject1 = new JSONObject();
	           jsonObject1.put("legendData", legendData);  
	           jsonObject1.put("yAxisData", yAxisData);  
	             
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
