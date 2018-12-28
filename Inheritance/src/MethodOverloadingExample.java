class test{
	void show(int a){
		System.out.println(a);
	}
	void show(int a,float b){
		System.out.println(a+b);
	}
	
}
class test1 extends test{
	void show(int a){
		System.out.println(a);
	}
}
public class MethodOverloadingExample {

	public static void main(String[] args) {
		test t = new test();
		t.show(2);
		t.show(1,0.2f);
		test1 t1=new test1();
		t1.show(8);

	}

}
