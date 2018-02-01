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

public class SaleAmountServlet extends HttpServlet {

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
	        List<String> timetoolData=new ArrayList<String>();
	        Sales_fact_hive_Mgr sfhm=new Sales_fact_hive_Mgr();
	        HashMap<Integer,Sales_fact_hive> map=new HashMap<Integer,Sales_fact_hive>();
	        map=sfhm.getSalesFactAmount();
	        Iterator it=map.keySet().iterator();
	        List<Integer> countyear=new ArrayList<Integer>();
	        int count=0;
	        List<Integer> countid=new ArrayList<Integer>();
	        HashMap<Integer,String> cate=new HashMap<Integer,String>();
	        while(it.hasNext())
	        {
	        	Sales_fact_hive sfh=(Sales_fact_hive)map.get(it.next());
	        	countyear.add(sfh.getCALENDAR_YEAR());
	        	count++;
	        	countid.add(sfh.getCATEGORY_ID());
	        }
	        Collections.sort(countyear);
	        Collections.sort(countid);
	        it=map.keySet().iterator();
	        int countl=0;
	        for(int y=countyear.get(0);y<=countyear.get(count-1);y++)
	        {
	        	
	        	List<JSONObject> jj=new ArrayList<JSONObject>();
	        	it=map.keySet().iterator();
	        	while(it.hasNext())
	        	{
	        		Sales_fact_hive sfh=(Sales_fact_hive)map.get(it.next());
	        		
	        		if(sfh.getCALENDAR_YEAR()==y)
	        		{
	        			JSONObject js=new JSONObject();
	        			js.put("value",sfh.getTOTAL());
	        			js.put("name", sfh.getCATEGORY_NAME());	        			
	        			jj.add(js);
	        			/*Series se=new Series(sfh.getCATEGORY_NAME(),Series.TYPE_PIE,js);
	        			JSONObject jso=new JSONObject();
	        			jso.put("year", y);
	        			jso.put("type", "pie");
	        			jso.put("data", se.jsonobject);
	        			seriesList.add(jso);*/
	        			cate.put(sfh.getCATEGORY_ID(), sfh.getCATEGORY_NAME());
	        		}
	        		
	        	}
	        	Series se=new Series(y,Series.TYPE_PIE,jj);
	        	List<String> center=new ArrayList<String>();
	        	center.add("50%");
	        	center.add("45%");
	        	JSONObject jso=new JSONObject();
	        	String name=((Integer)y).toString();
    			jso.put("name", name);
    			jso.put("type", "pie");
    			jso.put("center", center);
    			jso.put("radius", "50%");
    			jso.put("data", se.jsonobject);
    			seriesList.add(jso);
	        	timetoolData.add(((Integer)y).toString());
	        	countl++;
	        }
	        
	        for(int c=countid.get(0);c<=countid.get(count-1);c++)
	        {
	        	if(cate.get(c)!=null)
	        	{
	        		legendData.add(cate.get(c));	        		
	        	}
	        }
	           JSONObject jsonObject1 = new JSONObject();
	           jsonObject1.put("legendData", legendData);
	           jsonObject1.put("lsize", countl);
	           jsonObject1.put("timetoolData", timetoolData);  	             
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
