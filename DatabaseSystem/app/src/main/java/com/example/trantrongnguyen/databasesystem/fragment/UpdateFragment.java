package com.example.trantrongnguyen.databasesystem.fragment;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.trantrongnguyen.databasesystem.ConnectionHelper;
import com.example.trantrongnguyen.databasesystem.CreditCard;
import com.example.trantrongnguyen.databasesystem.CreditCardAdapter;
import com.example.trantrongnguyen.databasesystem.R;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateFragment extends Fragment {

    TextView updateNumberCard, updateIDCustomer, updateNameOwner, updateNameBank;
    TextView updateNameBranch, updateStartTime, updateEndTime;
    Button btnUpdate;
    public UpdateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_update, container, false);
        updateNumberCard = v.findViewById(R.id.updateNumberCard);
        updateIDCustomer = v.findViewById(R.id.updateIDCustomer);
        updateNameOwner = v.findViewById(R.id.updateNameOwner);
        updateNameBank = v.findViewById(R.id.updateNameBank);
        updateNameBranch = v.findViewById(R.id.updateNameBranch);
        updateStartTime = v.findViewById(R.id.updateStartTime);
        updateEndTime = v.findViewById(R.id.updateEndTime);
        btnUpdate = v.findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectionHelper con1 = new ConnectionHelper();
                Connection con = con1.connectionclass(getArguments().getString("username"), getArguments().getString("password"),
                        getArguments().getString("database"), getArguments().getString("ip"));
                try{
                    if(con == null){
                        System.out.println("connection null");
                    }
                    else{
                        String query = "UPDATE EBook.CreditCard set EndTime='"+updateEndTime.getText().toString()+
                                "', NameBank='"+updateNameBank.getText().toString().toUpperCase()+
                                "', NameOwer='"+updateNameOwner.getText().toString().toUpperCase()+
                                "', StartTime='"+updateStartTime.getText().toString()+
                                "', NameBranch='"+updateNameBranch.getText().toString().toUpperCase()+
                                "', IDCustomer='"+updateIDCustomer.getText().toString()+
                                "' WHERE NumberCard = '" + updateNumberCard.getText().toString()+"'";
                        Statement stm = con.createStatement();
                        stm.executeUpdate(query);
                        Snackbar snackbar = Snackbar
                                .make(v, "Update success", Snackbar.LENGTH_LONG);
                        snackbar.show();
                    }
                }
                catch (SQLException e){

                    Snackbar snackbar = Snackbar
                            .make(v, e.getMessage(), Snackbar.LENGTH_LONG);
                    snackbar.show();
                    System.out.println(e.getMessage());

                }
            }
        });
        return v;
    }



}
