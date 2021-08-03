package com.example.trantrongnguyen.databasesystem.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.trantrongnguyen.databasesystem.ConnectionHelper;
import com.example.trantrongnguyen.databasesystem.CreditCard;
import com.example.trantrongnguyen.databasesystem.CreditCardAdapter;
import com.example.trantrongnguyen.databasesystem.R;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewFragment extends Fragment {

    RecyclerView recycle_view;
    CreditCardAdapter adapter;
    public ViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_view, container, false);
        recycle_view = v.findViewById(R.id.recycle_view);
        setRecyclerView();
        return v;
    }
    private void setRecyclerView() {
        recycle_view.setHasFixedSize(true);
        recycle_view.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new CreditCardAdapter(getActivity(), getList());
        recycle_view.setAdapter(adapter);

    }

    private List<CreditCard> getList() {
        List<CreditCard> creditCardList = new ArrayList<>();
        ConnectionHelper con1 = new ConnectionHelper();
        Connection con = con1.connectionclass(getArguments().getString("username"), getArguments().getString("password"),
                getArguments().getString("database"), getArguments().getString("ip"));
        try{
            if(con == null){
                System.out.println("connection null");
            }
            else{
                String query = "SELECT * FROM EBook.CreditCard";
                Statement stm = con.createStatement();
                ResultSet resultSet = stm.executeQuery(query);
                while (resultSet.next()){
                    creditCardList.add(new CreditCard(resultSet.getString(1),resultSet.getString(7),
                            resultSet.getString(4), resultSet.getString(3),
                            resultSet.getString(6), resultSet.getString(5),resultSet.getString(2)));
                }
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return creditCardList;
    }

}
