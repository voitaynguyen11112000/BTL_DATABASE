package com.example.trantrongnguyen.databasesystem.fragment;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.trantrongnguyen.databasesystem.ConnectionHelper;
import com.example.trantrongnguyen.databasesystem.R;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteFragment extends Fragment {

    EditText deleteNumberCard;
    Button btnDelete;
    public DeleteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_delete, container, false);
        deleteNumberCard = v.findViewById(R.id.deleteNumberCard);
        btnDelete = v.findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
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
                        String query = "DELETE FROM EBook.CreditCard WHERE NumberCard='"+deleteNumberCard.getText().toString()+"'";
                        Statement stm = con.createStatement();
                        System.out.println(query);
                        int result = stm.executeUpdate(query);
                        System.out.println(result);
                        if(result == 0){
                            Snackbar snackbar = Snackbar
                                    .make(v, "Delete fail", Snackbar.LENGTH_LONG);
                            snackbar.show();
                        }
                        else {
                            Snackbar snackbar = Snackbar
                                    .make(v, "Delete success", Snackbar.LENGTH_LONG);
                            snackbar.show();
                        }

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
