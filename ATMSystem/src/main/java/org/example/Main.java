package org.example;

public class Main {
    public static void main(String[] args) {

        UserAccount acc1 = new UserAccount(1);
        acc1.addAmount(1000);
        acc1.addNewCard(new Card("123456789012","123456"));

        UserAccount acc2 = new UserAccount(1);
        acc2.addAmount(950);
        acc2.addNewCard(new Card("123456789013","123459"));

        BackendSystem bs = new BackendSystem();
        bs.addUserAccount(acc1);
        bs.addUserAccount(acc2);

        Card c1 = new Card("123456789012","123456");
        AtmSystem sys = AtmSystem.getAtmSystem(bs);

        int balance = sys.getUserAccountBalance(c1);
        sys.withdraw(750,c1);

        balance = sys.getUserAccountBalance(c1);
        System.out.println(balance);

        sys.addMoney(250, c1);
        System.out.println(sys.getUserAccountBalance(c1));
    }
}