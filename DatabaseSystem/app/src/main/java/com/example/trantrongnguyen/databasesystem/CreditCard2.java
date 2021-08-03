package com.example.trantrongnguyen.databasesystem;

/**
 * Created by TRAN TRONG NGUYEN on 6/5/2021.
 */

public class CreditCard2 {
    String numberCard, idpayment;
    public CreditCard2(String numberCard, String idpayment){
        this.numberCard = numberCard;
        this.idpayment = idpayment;

    }
    public String getNumberCard(){
        return numberCard;
    }
    public String getIDPayment(){
        return idpayment;
    }
}
