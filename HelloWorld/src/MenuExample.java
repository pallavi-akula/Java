import java.util.Scanner;

public class MenuExample {

	public static void main(String[] args) {
		int a,b,choice;
		Scanner sc = new Scanner(System.in);
		while(true){
		System.out.println("Enter two numbers:");
		a = sc.nextInt();
		b = sc.nextInt();
		System.out.println("Enter 1 for addition:");
		System.out.println("Enter 2 for Substraction:");
		System.out.println("Enter 3 for Multiplication:");
		System.out.println("Enter 4 for exit:");
		choice = sc.nextInt();
		switch(choice){
		case 1:
			System.out.println(a+b);
			break;
		case 2:
			System.out.println(a-b);
			break;
		case 3:
			System.out.println(a*b);
			break;
		case 4:
			System.exit(0);
		}
	
			
		}

	}

}
