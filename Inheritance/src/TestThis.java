
public class TestThis {
	int a;
	int b;
	
	TestThis(){
		this(10, 20);
		System.out.println("Default Constructor\n");
	}
	TestThis(int a,int b){
		this.a=a;
		this.b=b;
		System.out.println("Parameterized Constructor");
	}

	public static void main(String[] args) {
		TestThis t = new TestThis();
		
		

	}

}
