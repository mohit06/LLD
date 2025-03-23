package org.example;

public abstract class CashDispenser {
    public int notesCount;
    CashDispenser(int notes){
        notesCount=notes;
    }
    public abstract boolean dispenseAmount(int amt);
}
