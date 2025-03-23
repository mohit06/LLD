package org.example;

public class Cd500 extends CashDispenser {
    private String typeOfNote;
    private Cd100 cd;
    Cd500(int notes) {
        super(notes);
        typeOfNote="500";
        cd = new Cd100(10);
    }

    @Override
    public boolean dispenseAmount(int amt) {
        int requiredNotes = (int)amt / 500;
        if(notesCount >= requiredNotes){
            notesCount = notesCount - requiredNotes;
            System.out.println(requiredNotes + " notes of "+typeOfNote + " dispensed.");
        }

        return cd.dispenseAmount(amt - requiredNotes*500);
    }
}
