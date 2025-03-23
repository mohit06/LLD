package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserAccount {
    private long id;
    private List<Card> cards;
    private int totalAmt;

    public UserAccount(long id){
        this.id = id;
        cards = new ArrayList<Card>();
        totalAmt = 0;
    }

    public void addNewCard(Card c){
        cards.add(c);
    }

    public List<Card> getCards(){
        return cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAccount that)) return false;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public synchronized void addAmount(int amt){
        totalAmt += amt;
    }

    public synchronized boolean deductAmount(int amt){
        if(amt <= totalAmt){
            totalAmt -= amt;
            return true;
        }else{
            System.out.println("You do not have enough balance.");
        }
        return false;
    }

    public int getBalance(){
        return totalAmt;
    }
}
