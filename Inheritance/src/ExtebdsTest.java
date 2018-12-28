class B {}
class B1 extends B {}
class B2 extends B {}
public class ExtebdsTest
{
  public static void main(String args[])

  {
	     B b = new B();
	     B1 b1 = new B1();
	     B2 b2 = new B2();
	     // insert statement here
	    b1 =(B1) b;
	  }
}
