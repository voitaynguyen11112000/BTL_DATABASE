package com.example.trantrongnguyen.databasesystem;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.trantrongnguyen.databasesystem.fragment.UpdateFragment;

import java.util.List;

/**
 * Created by TRAN TRONG NGUYEN on 6/5/2021.
 */

public class CreditCardAdapter extends RecyclerView.Adapter<CreditCardAdapter.ViewHolder> {
    Context context;
    List<CreditCard> creditCardsList;

    public CreditCardAdapter(Context context , List<CreditCard> creditCardsList) {
        this.context = context;
        this.creditCardsList = creditCardsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.creditcard_layout,viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        if(creditCardsList != null && creditCardsList.size()>0){
            CreditCard creditCard = creditCardsList.get(i);
            viewHolder.number_card.setText(creditCard.getNumberCard());
            viewHolder.id_customer.setText(creditCard.getID());
            viewHolder.name_owner.setText(creditCard.getNameOwner());
            viewHolder.name_bank.setText(creditCard.getNameBank());
            viewHolder.name_branch.setText(creditCard.getNameBranch());
            viewHolder.start_time.setText(creditCard.getStartTime());
            viewHolder.end_time.setText(creditCard.getEndTime());
        }else{
            return;
        }
    }

    @Override
    public int getItemCount() {
        return creditCardsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView number_card, id_customer, name_owner, name_bank, name_branch, start_time, end_time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            number_card = itemView.findViewById(R.id.number_card);
            id_customer = itemView.findViewById(R.id.id_customer);
            name_owner = itemView.findViewById(R.id.name_owner);
            name_bank = itemView.findViewById(R.id.name_bank);
            name_branch = itemView.findViewById(R.id.name_branch);
            start_time = itemView.findViewById(R.id.start_time);
            end_time = itemView.findViewById(R.id.end_time);
        }
    }
}
