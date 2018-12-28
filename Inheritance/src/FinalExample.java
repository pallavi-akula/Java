final class Example{
	
}
class example1{
	final void show(){
		System.out.println("Parent Method");
	}
}
public class FinalExample extends example1 {
	

	public static void main(String[] args) {
		final int a;
		a = 20;
		System.out.println(a);
		FinalExample c = new FinalExample();
		c.show();
	}

}
