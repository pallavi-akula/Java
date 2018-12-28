
public class Demo1 {
	Demo1() {
		System.out.println("Constructor method");
	}
	
	{
		System.out.println("Instance Method");
	}
	static void show(){
		System.out.println("Static method");
	}

	public static void main(String[] args) {
	Demo1 d = new Demo1();
	show();
	d.show();
	
	

	}

}
