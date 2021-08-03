package com.example.trantrongnguyen.databasesystem.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.trantrongnguyen.databasesystem.ConnectionHelper;
import com.example.trantrongnguyen.databasesystem.Main2Activity;
import com.example.trantrongnguyen.databasesystem.MainActivity;
import com.example.trantrongnguyen.databasesystem.R;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * A simple {@link Fragment} subclass.
 */
public class InsertFragment extends Fragment {

    Button btnInsert;
    EditText insertNumberCard, insertIDCustomer, insertNameOwner,insertNameBank, insertNameBranch;
    EditText insertStartTime, insertEndTime;
    View mView;
    Connection con;

    public InsertFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_insert, container, false);
        btnInsert =  mView.findViewById(R.id.btnInsert);
        insertNumberCard = mView.findViewById(R.id.insertNumberCard);
        insertIDCustomer = mView.findViewById(R.id.insertIDCustomer);
        insertNameOwner = mView.findViewById(R.id.insertNameOwner);
        insertNameBank = mView.findViewById(R.id.insertNameBank);
        insertNameBranch = mView.findViewById(R.id.insertNameBranch);
        insertStartTime = mView.findViewById(R.id.insertStartTime);
        insertEndTime = mView.findViewById(R.id.insertEndTime);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectionHelper con1 = new ConnectionHelper();
                con = con1.connectionclass(getArguments().getString("username"), getArguments().getString("password"),
                        getArguments().getString("database"), getArguments().getString("ip"));
                try{
                    if(con == null){
                        System.out.println("connection null");
                    }
                    else{
                        String query = "INSERT INTO EBook.CreditCard(NumberCard, EndTime, NameBank, NameOwer, StartTime, NameBranch, IDCustomer)" +
                                "VALUES ('"+insertNumberCard.getText().toString()+"', CONVERT(datetime, '"+insertEndTime.getText().toString()+
                                "', 105), '"+insertNameBank.getText().toString().toUpperCase()+"', '"+insertNameOwner.getText().toString().toUpperCase()+"'," +
                                "CONVERT(datetime, '"+insertStartTime.getText().toString()+"', 105), '"+insertNameBranch.getText().toString().toUpperCase()+
                                "', '"+insertIDCustomer.getText().toString()+"')";
                        Statement stm = con.createStatement();
                        stm.executeUpdate(query);
                        Snackbar snackbar = Snackbar
                                .make(v, "Insert success", Snackbar.LENGTH_LONG);
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
        return mView;
    }

}
