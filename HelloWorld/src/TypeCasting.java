import java.util.Scanner;

public class TypeCasting {

	public static void main(String[] args) {
		int a,b;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Two numbers");
		a = sc.nextInt();
		b = sc.nextInt();
		float c;
		c = (float) a/b;
		System.out.println(c);

	}

}
