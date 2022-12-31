import java.util.Scanner;

class AtmInterface
{
	Scanner sc=new Scanner(System.in);
	float init_amt=30000;
	String trans="";

	public void deposit()
	{
		System.out.print("\nEnter amount to Deposit: ");
		int dept_amt = sc.nextInt();
		init_amt+=dept_amt;
		System.out.println("Amount deposited successfully...");
		System.out.println("Your current balance: "+init_amt);
		trans+="You deposited "+Float.toString(init_amt)+" successfully \n";
	}
	
	public void withdraw()
	{
		System.out.println("\nEnter amount to Withdraw: ");
		int with_amt = sc.nextInt();
		if(with_amt % 10!= 0)
		{
			System.out.println("\n***Enter the amount in range of multiplied by 10***");
		}
		else if(with_amt > init_amt)
		{
			System.out.println("\nYour Balance is Insufficent");
		}
		else
		{
			init_amt -= with_amt;
			System.out.println("\nGet your cash...");
			System.out.println("Your current balance: "+init_amt);
			trans+="You withdrawn "+Float.toString(with_amt)+" successfully \n";
		}
	}

	public void transfer()
	{
    Scanner s=new Scanner(System.in);
		System.out.print("\nEnter Receipent's account number : ");
		String rec = s.nextLine();
		System.out.print("\nEnter amount to transfer : ");
		int trans_amt = s.nextInt();
		if ( init_amt >= trans_amt ) 
		{
			if ( trans_amt <= 100000 ) 
			{
				init_amt -= trans_amt;
				System.out.println("\nAmount is Successfully Transfered to " + rec);
				System.out.println("Your current balance: "+init_amt);
				trans+="Transferred "+Float.toString(trans_amt)+" to "+rec+" successfully \n";
			}
			else 
			{
				System.out.println("\nYou can only transfer upto 100000");
			}
		}
		else 
		{
			System.out.println("\nYour Balance is Insufficient");
		}
	}
	
	public void history()
	{
		System.out.println("*****Transaction History*****\n");
		if(trans=="")
			System.out.println("No transactions done so far");
		else
			System.out.println(trans);
	}
}

class AtmTask
{
	public static void main(String args[]) 
	{
		int id = 1234567891;
		int pin = 1234;
    int enter_id, enter_pin,ch;
		Scanner sc = new Scanner(System.in);
		AtmInterface user = new AtmInterface();
		do
		{
		 	System.out.print("Enter ID: ");
			enter_id = sc.nextInt();
			System.out.print("Enter PIN: ");
			enter_pin = sc.nextInt();
			if(enter_id!=id || enter_pin!=pin)
			{
				System.out.println("***ENTER VALID CREDENTIALS***");
			}
		}while(enter_id!=id || enter_pin!=pin);
		do
		{
			System.out.println("\n***** WELCOME *****\n");
			System.out.println("1. Transaction History");
			System.out.println("2. Withdraw");
			System.out.println("3. Deposit");
			System.out.println("4. Transfer");
			System.out.println("5. Quit");
			System.out.println("\nEnter your Choice: ");
			ch = sc.nextInt();

			switch(ch)
			{
				case 1:
					user.history();
					break;
					
				case 2:
					user.withdraw();
					break;

				case 3:
					user.deposit();
					break;

				case 4:
					user.transfer();
					break;

				case 5:
					System.out.println("Thank you...Please visit again");
					break;

				default:
					System.out.println("Invalid choice, Please enter valid choice");
			}
		}while(ch!=5);
	}
}
