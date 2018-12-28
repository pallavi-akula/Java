abstract class Bank{
	abstract int getRateOfInterest();
}
class SBI extends Bank{
	int getRateOfInterest(){
		return 7;
	}
}
class FNB extends Bank{
	int getRateOfInterest(){
		return 8;
	}
}
public class TestBank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Bank b=new SBI();

		int interest = b.getRateOfInterest();
		System.out.println("Rate of Interest is "+interest+"%");
	}

}
