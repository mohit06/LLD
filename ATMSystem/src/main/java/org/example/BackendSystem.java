package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BackendSystem {
    private List<UserAccount> userAccounts;

    public BackendSystem(){
        userAccounts = new ArrayList<>();
    }

    public UserAccount getUserAccount(Card card){
        for(UserAccount acc : userAccounts){
            List<Card> cards = acc.getCards();
            long cnt = cards.stream().filter(c -> c.equals(card)).count();
            if(cnt!=0)
                return acc;
        }
        System.out.println("Invalid Card or PIN.");
        return null;
    }

    public synchronized void addBalanceToAccount(int amt, UserAccount account){
        Optional<UserAccount> accContainer = userAccounts.stream().filter(a -> a.equals(account)).findFirst();
        accContainer.ifPresentOrElse(a -> a.addAmount(amt),()-> System.out.println("Account does not exist."));
    }

    public synchronized void withdrawFromAccount(int amt, UserAccount account){
        Optional<UserAccount> accContainer = userAccounts.stream().filter(a -> a.equals(account)).findFirst();
        accContainer.ifPresentOrElse(a -> a.deductAmount(amt),()-> System.out.println("Account does not exist."));
    }

    public void addUserAccount(UserAccount acc){
        userAccounts.add(acc);
    }

}
