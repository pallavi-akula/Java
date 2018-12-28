import java.io.*;
import java.util.concurrent.SynchronousQueue; 
  
public class ExampleNullPointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  String ptr = null; 
		  int array[] = {20,20,40};
	      int num1 = 15, num2 = 10;
	      int result = 10;
		  try
	        { 
	           
	            if (ptr.equals("gfg")) 
	                System.out.print("Same"); 
	            else 
	                System.out.print("Not Same"); 
	            result = num1/num2;
	            System.out.println("The result is" +result);
	            for(int i = 5; i >=0; i--) {
	               System.out.println("The value of array is" +array[i]);
	            }
	        } 
		  catch(NullPointerException e) 
	        { 
	            System.out.print("NullPointerException Caught"); 
	        } 
		  catch (ArrayIndexOutOfBoundsException e) {
		         System.out.println("Array is out of Bounds"+e);

	}
		  catch (ArithmeticException e) {
		         System.out.println ("Can't divide by Zero"+e);

}
	
		  finally{
			  System.out.println("Finally block is executed");
		  }
	}

}
       
     