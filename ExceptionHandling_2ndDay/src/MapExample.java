import java.util.*;  
public class MapExample {
	public static void main(String[] args) {  
		    Map<Integer,String> map=new HashMap<Integer,String> ();  
		    //Adding elements to map  
		    map.put(1,"Amit");  
		    map.put(5,"Rahul");  
		    map.put(2,"Jai");  
		    map.put(6,"Amit");  
		    //Traversing Map  
		    Set set=map.entrySet();
		    Iterator itr=set.iterator();  
		     
		    map.replace(5, "Preethi");
		    map.remove("Rahul");
		    while(itr.hasNext()){  
		        Map.Entry entry=(Map.Entry)itr.next();  
		        System.out.println(entry.getKey()+" "+entry.getValue());  
		    }
		    
		}  
		 	

	}


