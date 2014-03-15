/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrew
 */


public class Transaction {
    private Money transAmount;
    private Money newAmount;
    private String transType;
    private String timestamp;

    //constructor
    public Transaction(){
        transType = "";
        transAmount = new Money();
        newAmount = new Money();
        timestamp = "";


    }
    //overload
    public void addEntry(String type1, String date, Money amount1, Money newAmount1){
        
        timestamp = date;
        transType = type1;
        transAmount = amount1;
        newAmount = newAmount1;
        
    }
    //display
    public void displayEntry(){
        System.out.println(transType + " of " + transAmount + " on " + timestamp + ". Updated balance: " +newAmount);
        System.out.println("---------------------------------------------------------------------=---");
        //System.out.println(transAmount);
        //System.out.println(newAmount);
    }
    public static Money deposit(Money m1, Money m2){
        Money m3 = Money.add(m1,m2);
        return m3;
    }
    public static Money withdraw(Money m1, Money m2){
        Money m3 = Money.subtract(m1,m2);
        return m3;
    }
}

