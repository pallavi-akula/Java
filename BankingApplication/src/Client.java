import java.util.Scanner;

public class Client {

    private static Scanner sc;

    public static void main(String[] args) throws InsufficientBalanceException {
        ICICIBank bank = new ICICIBank();
        
        System.out.println(bank.createAccount(101, 3000));
        System.out.println(bank.createAccount(102, 4000));
        int op=0;
        while( op == 0){    
System.out.println("Enter your choice : 1.Deposit \n 2.Withdrawamount \n 3.FundTransfer \n 4.Default");
        
      Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        
        switch(option)  {
    
    case 1 :
      //  System.out.println("Enter the account number:");
            try
    
        {   
            System.out.println("New Balance = "+bank.depositAmount(101, 2000));

        }catch(InvalidAccountNumberException i)
        {
            System.out.println("Invalid account number ");
        }
        break; 
    
    
    case 2 :    try
        {
            System.out.println("Balance = "+bank.withdrawAmount(101, 220));
        }
        catch(InvalidAccountNumberException i)
        {
            System.out.println("Invalid account number ");
        }
        catch(InsufficientBalanceException ibe){
            System.out.println("insufficient balance");
        }
        break;
    
    
case 3 :
            try {
                System.out.println("Balance = " + bank.fundTransfer(101,102,300));
            } catch (Exception e) {
                                e.printStackTrace();
            }
                break;
                
                
    default : System.out.println("No transcation is done");
        
    
        }
        System.out.println("to continue give option = 0");
    op = sc.nextInt();
    
    }

    }
}

