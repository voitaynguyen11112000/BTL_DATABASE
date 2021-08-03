package com.example.trantrongnguyen.databasesystem;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by TRAN TRONG NGUYEN on 6/5/2021.
 */

public class CreditCardAdapter2 extends RecyclerView.Adapter<CreditCardAdapter2.ViewHolder> {
    Context context;
    List<CreditCard2> creditCardsList;

    public CreditCardAdapter2(Context context , List<CreditCard2> creditCardsList) {
        this.context = context;
        this.creditCardsList = creditCardsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.creditcard_layout2,viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        if(creditCardsList != null && creditCardsList.size()>0){
            CreditCard2 creditCard = creditCardsList.get(i);
            viewHolder.number_card.setText(creditCard.getNumberCard());
            viewHolder.id_payment.setText(creditCard.getIDPayment());
        }else{
            return;
        }
    }

    @Override
    public int getItemCount() {
        return creditCardsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView number_card, id_payment;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            number_card = itemView.findViewById(R.id.number_card);
            id_payment = itemView.findViewById(R.id.id_payment);
        }
    }
}
