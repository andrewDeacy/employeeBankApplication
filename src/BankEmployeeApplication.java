/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrew
 */
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;



public class BankEmployeeApplication {
    private final int exit =4;
    private Account example;
    private Scanner keyboard;
    private Money test;
    private String timeStamp = new SimpleDateFormat("dd-MM-yyyy 'at' hh:mm").format(new Date());
    
    public BankEmployeeApplication(){
        
        example = new Account("10001",test);//an example, need to create accounts and assign rando numbers for acc num
        keyboard = new Scanner(System.in);

}
    public void displayMenu(){
        int response = 0;
        while (response!=exit){
            //System.out.println("0: Create an account");
            System.out.println("1: Withdraw from account");
            System.out.println("2: Deposit to account");
            System.out.println("3: Display transactions");
            System.out.println("4: Exit");
            response = keyboard.nextInt();
            execute(response);
        }   
    }
    
    private void execute(int aResponse){
        Money amount = new Money();
        Money newAmount = new Money();
        String type = "";
        double enter;
        int dollars,cents;
        boolean cont =false;
        
        switch(aResponse){
             
            case 0:
            System.out.println("Please enter a initial deposit:");
            System.out.println("Enter the dollar amount");
            dollars = keyboard.nextInt();
            System.out.println("Enter the cents amount");
            cents = keyboard.nextInt();
            Money init = new Money(dollars,cents);
            Account newAccount = new Account();
            newAccount.deposit(init);//having trouble with new accounts other than example account.
            
            break;
            case 1:
            System.out.println("How much would you like to withdraw?");
            System.out.println("Enter the dollar amount");
            dollars = keyboard.nextInt();
            System.out.println("Enter the cents amount");
            cents = keyboard.nextInt();
            Money wAmt = new Money(dollars,cents);
            type = "Withdrawal";
            //making sure there is enough money in account to withdraw
            Money check = example.getcurrentAmount();
            if (cont = wAmt.lessThan(check))
                example.withdraw(wAmt);
            else
                System.out.println("You're too poor!! Not enough money in account.");
            
            
            break;
            
            case 2:
            System.out.println("How much would you like to deposit?");
            System.out.println("Enter the dollar amount");
            dollars = keyboard.nextInt();
            System.out.println("Enter the cents amount");
            cents = keyboard.nextInt();
            Money dAmt = new Money(dollars,cents);
            type = "Deposit";
            example.deposit(dAmt);
            break;
                
            case 3:
            example.display();
            break;
                
            case 4:
            break;
            
            default: 
            System.out.println("Invalid entry");
            break;
                
        }
        
    }
    
    public static void main(String[] args){
        BankEmployeeApplication bank = new BankEmployeeApplication();//perhaps I need to make this a 2d array and store the accounts in here. 
        bank.displayMenu();
        
        //BankEmployeeApplication bank[][] = new BankEmployeeApplication[20][];//20 acounts
        //for (int i=0; i < bank.length ; i++)
            //for (int j=0; j < bank[i].length ; j++)
                //bank[i][j] = new Account(String.valueOf(i),new Money());
    }
}

