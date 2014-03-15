
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrew
 */
public class Account {
    private String accountNumber;
    private Money currentAmount;
    private Transaction[] bankLedger;
    private int ledgerCount;
    private final int max = 100;
    private String timeStamp = new SimpleDateFormat("dd-MM-yyyy 'at' hh:mm").format(new Date());
    
    //construct
    public Account(){
        accountNumber ="";
        currentAmount = new Money();        
        ledgerCount =0; 
        createAccount();
        
    }
    //overload construct
    public Account (String AccNum, Money amt){
        accountNumber = AccNum;
        currentAmount = new Money();
        ledgerCount = 0;
        createAccount();
    }
            
    public void createAccount(){
        bankLedger = new Transaction[max];
        bankLedger[ledgerCount] = new Transaction();
        bankLedger[ledgerCount].addEntry("Initial Deposit", timeStamp, currentAmount, currentAmount);//need to create addEntery method
        ledgerCount +=1;
    }    
    public void deposit(Money Damt){
        //add deposit to currnet amt
        currentAmount = Money.add(currentAmount,Damt);//testing
        bankLedger[ledgerCount] = new Transaction();
        bankLedger[ledgerCount].addEntry("Deposit", timeStamp, Damt, currentAmount);
        ledgerCount +=1;
    }
    
    public void withdraw(Money Wamt){
        //add deposit to currnet amt
        currentAmount = Transaction.withdraw(currentAmount,Wamt);
        bankLedger[ledgerCount] = new Transaction();
        bankLedger[ledgerCount].addEntry("Withdrawal", timeStamp, Wamt, currentAmount);
        ledgerCount +=1;
    }
    //loop and display 
    public void display(){
        System.out.println("AccountNumber: " + getAccountNumber());
        for(int i=0; i<ledgerCount; i++){
            bankLedger[i].displayEntry();//why u no work???
            //System.out.println("test");
        }
        System.out.println("****Current balance: " + getcurrentAmount());
    }
    
    //accessor/mutator methods
    public String getAccountNumber(){
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }
    public Money getcurrentAmount(){
        return currentAmount;
    }
    public void setCurrentAmount(Money currentAmount){
        this.currentAmount = currentAmount;
    }
    public String getTime(){
        return timeStamp;
    }
    public void setTime(String timeStamp){
        this.timeStamp = timeStamp;
    }
}
