package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

public class SaleCountryServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try{
			req.setCharacterEncoding("utf-8");  
	        resp.setContentType("utf-8");  
	        resp.setCharacterEncoding("utf-8");          
	        PrintWriter write = resp.getWriter();    	          
	        List< JSONObject> seriesList = new ArrayList< JSONObject>();  
	        List<String> legendData=new ArrayList<String>(); 
	        Sales_fact_hive_Mgr sfhm=new Sales_fact_hive_Mgr();
	        HashMap<Integer,Sales_fact_hive> map=new HashMap<Integer,Sales_fact_hive>();
	        map=sfhm.getSalesCountry();
	        Iterator it=map.keySet().iterator();
	        List<JSONObject> jj=new ArrayList<JSONObject>();
	        while(it.hasNext())
	        {
	        	Sales_fact_hive sfh=(Sales_fact_hive)map.get(it.next());
	        	JSONObject jo=new JSONObject();
	        	String first=sfh.getCOUNTRY_NAME().substring(0,1);
	        	String rest=sfh.getCOUNTRY_NAME().substring(1,sfh.getCOUNTRY_NAME().length()).toLowerCase();
	        	String country= new StringBuffer(first).append(rest).toString();
	        	if(country.equals("America")) country="United States of America";
	        	jo.put("name", country);
	        	jo.put("value", sfh.getTOTAL());
	        	jj.add(jo);
	        }
	        	Series se=new Series(0,Series.TYPE_PIE,jj);
	        	JSONObject jso=new JSONObject();	        	
    			jso.put("name", "销量地图");
    			jso.put("data", se.jsonobject);
    			seriesList.add(jso);	        		        	        
	           JSONObject jsonObject1 = new JSONObject();  	             
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
