import java.util.HashSet;
import java.util.Iterator;



public class HashSetExample {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add("Ravi");
		set.add("Vijay");
		set.add("Ravi");
		set.add("Ajay");
		System.out.println(set);
		set.remove("Ajay");
		System.out.println(set);
		//set.replace()
		//set.set(1,"Vinay");

		Iterator<String> itr=set.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
		



	}

}
