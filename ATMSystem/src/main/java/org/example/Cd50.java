package org.example;

public class Cd50 extends CashDispenser{
    private String typeOfNote;

    Cd50(int notes) {
        super(notes);
        typeOfNote="50";
    }

    @Override
    public boolean dispenseAmount(int amt) {
        int requiredNotes = (int)amt / 50;
        if(notesCount >= requiredNotes){
            notesCount = notesCount - requiredNotes;
            System.out.println(requiredNotes + " notes of "+typeOfNote + " dispensed.");
            return true;
        }
        return false;
    }
}
