

import java.util.Scanner;

public class BankingApplication {

	public static void main(String[] args) {
		Scanner sc1=new Scanner(System.in);
		System.out.println("please enter your name: ");
		String cn=sc1.next();
		System.out.println("please enter id: ");
		String ci=sc1.next();
		Bankacc obj=new Bankacc(cn,ci);
		obj.showmenu();

	}

}
class Bankacc{
	int balance;
	int previousTransaction;
	String customerName;
	String customerId;
	//constructor for welcoming message
	Bankacc(String cname,String cid){
		customerName=cname;
		customerId=cid;
		
	}
	//deposting method
	void deposit(int amount) {
		balance+=amount;
		previousTransaction=amount;
	}
	//withdrawn method
	void withdraw(int amount) {
		balance-=amount;
		previousTransaction=-amount;
	}
	//viewing previous transactions
	void viewPrevTran(){
		if(previousTransaction>0) {
			System.out.println("Deposited :"+ previousTransaction);
		}
		else if(previousTransaction<0) {
			System.out.println("Withdrawn :"+ Math.abs(previousTransaction));
			
		}
		else {
			System.out.println("No transcations occured");
		}
	}
	//showing the available options
	void showmenu() {
		char option='\0';
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome!"+customerName);
		System.out.println("Your ID is "+customerId);
		System.out.println("\n");
		System.out.println("A.Check Balance");
		System.out.println("B.Deposit");
		System.out.println("C.Withdrawn");
		System.out.println("D.Previous Transaction");
		System.out.println("E.Exit");
		do {
			System.out.println("========================================================");
			System.out.println("Enter an option");
			System.out.println("========================================================");
			option=sc.next().charAt(0);
			System.out.println("\n");
			switch(option) {
			case 'A':
				System.out.println("-------------------------------------------------------");
				System.out.println("Your Balance amounnt is:"+ balance);
				System.out.println("-------------------------------------------------------");
				System.out.println("\n");
				break;
			
			case 'B':
				System.out.println("-------------------------------------------------------");
				System.out.println("Enter amount to be deposited");
				System.out.println("-------------------------------------------------------");
				int amount=sc.nextInt();
				deposit(amount);
				System.out.println("\n");
				break;
			
	         case 'C':
				System.out.println("-------------------------------------------------------");
				System.out.println("Enter amount to be withdrawn");
				System.out.println("-------------------------------------------------------");
				int amount2=sc.nextInt();
				withdraw(amount2);
				break;
				
						
	         case 'D':
						System.out.println("-------------------------------------------------------");
						viewPrevTran();
						System.out.println("-------------------------------------------------------");
						System.out.println("\n");
						break;
	         case 'E':
	        	 System.out.println("=====================================================");
	        	 break;
			default:
				System.out.println("Invalid Option Entered! TRY AGAIN");
			break;
		}
			
	}while(option!='E');
		System.out.println("thank you for using our services!");
}
}
