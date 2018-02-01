package servlet;
import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.ArrayList;  
import java.util.Collections;
import java.util.HashMap;  
import java.util.Iterator;
import java.util.List;  
import java.util.Map;  
  
  





import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession; 

import entity.Sales_fact_hive;
import entity.Sales_fact_hive_Mgr;
import net.sf.json.JSONObject;
public class ChannelServlet extends HttpServlet {
	JSONObject jsonObject=null;  
    public void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{  
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
            map=sfhm.getSalesFactChannel(Integer.parseInt(category));
            Iterator it=map.keySet().iterator();
            HashMap<Integer,Integer> sale1=new HashMap<Integer,Integer>();
            HashMap<Integer,Integer> sale2=new HashMap<Integer,Integer>();
            HashMap<String,Integer> sales1=new HashMap<String,Integer>();
            HashMap<String,Integer> sales2=new HashMap<String,Integer>(); 
            int i=0;
            int j=0;
            List<Integer> year1=new ArrayList<Integer>();
            List<Integer> year2=new ArrayList<Integer>();
            if(c==1)
            {
            	 while(it.hasNext())
                 {
                 	Sales_fact_hive sfh=(Sales_fact_hive) map.get(it.next());
                 	if(sfh.getCHANNEL_ID()==1)
                 	{
                 		sale1.put(sfh.getCALENDAR_YEAR(), sfh.getTOTAL());
                 		year1.add(sfh.getCALENDAR_YEAR());
                 		//System.out.println(sfh.getTOTAL());
                 		i++;
                 	}
                 	if(sfh.getCHANNEL_ID()==2)
                 	{
                 		sale2.put(sfh.getCALENDAR_YEAR(), sfh.getTOTAL());
                 		year2.add(sfh.getCALENDAR_YEAR());
                 		j++;
                 	}
                 }
            	 Collections.sort(year1);
            	 Collections.sort(year2);
            	 if(j>i)
            	 {
            		 for(int t=0;t<j;t++)
            		 {
            			 xAxisData.add(year2.get(t).toString());
            		 }
            	 }
            	 else
            	 {
            		 for(int t=0;t<i;t++)
            		 {
            			 xAxisData.add(year1.get(t).toString());
            		 }
            	 };
            	  List<Integer> list1=new ArrayList<Integer>();
                  List<Integer> list2=new ArrayList<Integer>();
                  for(int t=0;t<i;t++)
                  {
                  	list1.add((Integer)sale1.get(year1.get(t)));
                  }
                  Series series1=new Series("直销",Series.TYPE_LINE,list1);
                  JSONObject jsonObject2 = new JSONObject();
                  jsonObject2.put("name", series1.toName());  
                  jsonObject2.put("type","bar");  
                  jsonObject2.put("data",series1.data);  
                  seriesList.add(jsonObject2); 
                  for(int t=0;t<j;t++)
                  {
                  	list2.add((Integer)sale2.get(year2.get(t)));
                  }
                  Series series2=new Series("分销",Series.TYPE_LINE,list2);
                  JSONObject jsonObject3 = new JSONObject();
                  jsonObject3.put("name", series2.toName());  
                  jsonObject3.put("type","bar");  
                  jsonObject3.put("data",series2.data);  
                  seriesList.add(jsonObject3);  
            	 
            }
            if(c==2)
            {
            int maxyear=0;
            int maxmonth=0;
            List<Integer> countyear=new ArrayList<Integer>();
            while(it.hasNext())
            {
            	Sales_fact_hive sfh=(Sales_fact_hive) map.get(it.next());
            	countyear.add(sfh.getCALENDAR_YEAR());
            	if(maxyear<sfh.getCALENDAR_YEAR()) maxyear=sfh.getCALENDAR_YEAR();
            	if(maxmonth<sfh.getCALENDAR_MONTH_NUMBER()) maxmonth=sfh.getCALENDAR_MONTH_NUMBER();
            }
            Collections.sort(countyear);
            it=map.keySet().iterator();
            while(it.hasNext())
            {
            	Sales_fact_hive sfh=(Sales_fact_hive) map.get(it.next());
            	String yearandmonth="";
            	if(sfh.getCHANNEL_ID()==1)
            	{
            		yearandmonth=sfh.getCALENDAR_YEAR()+"-"+sfh.getCALENDAR_MONTH_NUMBER();
            		sales1.put(yearandmonth,sfh.getTOTAL());
            		System.out.println(sfh.getTOTAL());
            		
            	}
            	if(sfh.getCHANNEL_ID()==2)
            	{
            		yearandmonth=sfh.getCALENDAR_YEAR()+"-"+sfh.getCALENDAR_MONTH_NUMBER();
            		sales2.put(yearandmonth,sfh.getTOTAL());
            		//System.out.println(sfh.getTOTAL());
            	}
            }
            
            //System.out.print(i);
            List<Integer> list1=new ArrayList<Integer>();
            List<Integer> list2=new ArrayList<Integer>();
            for(int t=countyear.get(0);t<=maxyear;t++)
            {
            	for(int l=1;l<=maxmonth;l++)
            	{
            		list1.add(sales1.get(t+"-"+l));
            	}
            }
            Series series1=new Series("直销",Series.TYPE_LINE,list1);
            JSONObject jsonObject2 = new JSONObject();
            jsonObject2.put("name", series1.toName());  
            jsonObject2.put("type","bar");  
            jsonObject2.put("data",series1.data);  
            seriesList.add(jsonObject2); 
            for(int t=countyear.get(0);t<=maxyear;t++)
            {
            	for(int l=1;l<=maxmonth;l++)
            	{
            		list2.add(sales2.get(t+"-"+l));
            		xAxisData.add(t+"-"+l);
            	}
            }   
            Series series2=new Series("分销",Series.TYPE_LINE,list2);
            JSONObject jsonObject3 = new JSONObject();
            jsonObject3.put("name", series2.toName());  
            jsonObject3.put("type","bar");  
            jsonObject3.put("data",series2.data);  
            seriesList.add(jsonObject3);  
            }
legendData.add("直销");
legendData.add("分销");
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
}catch (IOException e) {  
e.printStackTrace();  
}  
}
    
    
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}
    

}
