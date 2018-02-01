package servlet;
import java.util.List;  
import net.sf.json.JSONObject;
  
public class Series {  
      
    public String name;  
    public String type; 
    public int year;
    public List<Integer> data;  
    public static String TYPE_LINE = "line";  
    public static String TYPE_BAR = "bar";  
    public static String TYPE_PIE="pie";
    public List<JSONObject> jsonobject;
public Series(int year,String type,List<JSONObject> jsonobject)
{
	this.year=year;
	this.type=type;
	this.jsonobject=jsonobject;
}
public Series( String name, String type, List<Integer> data) {    
      
    this.name = name;    
    this.type = type;    
    this.data = data;    
}    
public String toName(){  
    return name;  
}  
  
} 