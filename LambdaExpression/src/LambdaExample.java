interface add{
	public int operations(int a,int b); 
}
class Test implements add{
	public int operations(int a,int b){
		return a+b;
	}
}
public class LambdaExample {

	public static void main(String[] args) {
		add a1 = new add(){
		
		@Override
		public int operations(int a,int b){
			return a+b;
		}
		
		
		
	};

		System.out.println(a1.operations(5, 5));
	add a2 = (int a,int b)->{
		return a+b;
	};
	System.out.println(a2);
	}
	

	}