import java.util.Scanner;
public class BankAccount {

	public static void main(String[] args) {
		 double diposit, withdraw;
		 double balance=0;
		 public BankAccount(double balance)
		 {
		     this.balance=balance;
		 }
		  void deposit(double amount)
		  {
		       Scanner b=new Scanner(System.in);
		    System.out.println("diposit a amount");
		     amount=b.nextInt();
		     balance +=amount;
		}
		 void withdraw(double amount)
		{
		       Scanner b=new Scanner(System.in);
		    System.out.println("withdraw a amount");
		     amount=b.nextInt();
		     balance +=amount;
		}

		  void display()
		  {
		      System.out.println(balance);
		  	}
		  throw new InsufficientBalanceException();
		  void withdraw (double amount) throws InsufficientBalanceException
		  {
		      if (amount > balance)
		          throw new InsufficientBalanceException();
		      else
		          balance -= amount;
		  }

}
}