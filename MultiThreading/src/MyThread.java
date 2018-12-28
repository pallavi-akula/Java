class Thread1 {
   
   void display(int low, int high) {
     for(int i = low; i <= high; i++) {
         System.out.print("First " +i + " ");
      }
      System.out.println();
   }
}
class Thread2 {
	   
	   void display(int low, int high) {
		   for(int i = low; i <= high; i++) {
	         System.out.print("Second " +i + " ");
	      }
	      System.out.println();
	   }
	}


class Helper extends Thread {
   Thread1 r;
   int low, high;
      Helper(Thread1 r_obj, int low_limit, int high_limit) {
      r = r_obj;
      low = low_limit; high = high_limit;
   }
   public void run() {
      r.display(low, high);
   }
}
class Helper1 extends Thread {
	   
	   Thread2 r1;
	   int low, high;
	   
	   Helper1(Thread2 r1_obj, int low_limit, int high_limit) {
		      r1 = r1_obj;
		      low = low_limit; high = high_limit;
		   }
	   public void run() {
	     
	      r1.display(low, high);
	   }
	}

public class MyThread {
   public static void main(String args[]) {
     
      Thread1 obj = new Thread1();
      Thread2 obj1 = new Thread2();
      Helper th1 = new Helper(obj, 1, 10);
      
      Helper1 th2 = new Helper1(obj1, 11, 20);
      th1.start();
      th2.start();
   }
}