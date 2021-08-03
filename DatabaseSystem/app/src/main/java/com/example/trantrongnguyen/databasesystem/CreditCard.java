package com.example.trantrongnguyen.databasesystem;

/**
 * Created by TRAN TRONG NGUYEN on 6/5/2021.
 */

public class CreditCard {
    String numberCard, id, nameOwner, nameBank, nameBranch, startTime, endTime;
    public CreditCard(String numberCard, String id, String nameOwner, String nameBank, String nameBranch, String startTime, String endTime){
        this.numberCard = numberCard;
        this.id = id;
        this.nameOwner = nameOwner;
        this.nameBank = nameBank;
        this.nameBranch = nameBranch;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public String getNumberCard(){
        return numberCard;
    }
    public String getID(){
        return id;
    }
    public String getNameOwner(){
        return nameOwner;
    }
    public String getNameBank(){
        return nameBank;
    }
    public String getNameBranch(){
        return nameBranch;
    }
    public String getStartTime(){
        return startTime;
    }
    public String getEndTime(){
        return endTime;
    }
}
