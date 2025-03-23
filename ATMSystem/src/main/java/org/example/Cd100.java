package org.example;

public class Cd100 extends CashDispenser{
    private String typeOfNote;
    private Cd50 cd;
    Cd100(int notes) {
        super(notes);
        typeOfNote="100";
        cd = new Cd50(10);
    }

    @Override
    public boolean dispenseAmount(int amt) {
        int requiredNotes = (int)amt / 100;
        if(notesCount >= requiredNotes){
            notesCount = notesCount - requiredNotes;
            System.out.println(requiredNotes + " notes of "+typeOfNote + " dispensed.");
        }
        return cd.dispenseAmount(amt - requiredNotes*100);
    }
}
