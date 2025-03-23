package org.example;

public class AtmSystem {

    private BackendSystem bs;
    private Cd500 cd;

    private static volatile AtmSystem atm = new AtmSystem();
    private AtmSystem(){}

    public static synchronized AtmSystem getAtmSystem(BackendSystem bs){
        atm.setBs(bs);
        atm.setCashDispenser();
        return atm;
    }

    private void setCashDispenser() {
        cd = new Cd500(10);
    }

    public void setBs(BackendSystem bs){
        this.bs = bs;
    }

    public int getUserAccountBalance(Card card){
        UserAccount account = bs.getUserAccount(card);
        if(account != null)
            return account.getBalance();

        return 0;
    }

    public synchronized void addMoney(int amount, Card card){
        UserAccount account = bs.getUserAccount(card);
        bs.addBalanceToAccount(amount,account);
    }

    public synchronized void withdraw(int amt, Card card){
       UserAccount account = bs.getUserAccount(card);

       if(account!=null && account.getBalance() >= amt){
           boolean isDispensed = cd.dispenseAmount(amt);
           if(isDispensed)
               account.deductAmount(amt);
           else
               System.out.println("ATM is out of notes. Your amount will not be deducted.");
       }else{
           System.out.println("Invalid card or insufficient balance.");
       }
    }
}
