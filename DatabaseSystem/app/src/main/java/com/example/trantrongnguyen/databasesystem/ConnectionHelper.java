package com.example.trantrongnguyen.databasesystem;

import android.content.Intent;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by TRAN TRONG NGUYEN on 5/27/2021.
 */

public class ConnectionHelper {
    Connection connection;
    public Connection connectionclass(String username, String password, String database, String ip){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Connection connection = null;
        String connectionURL = "";
        try{

            connectionURL= "jdbc:jtds:sqlserver://"+ ip + ";instance=MSSQLSERVER;user="+username+";password="+password+";databasename="+database+";";
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(connectionURL);
            Log.e("ASK", "Connection called");
        }
        catch (Exception e){
            Log.e("ASK", e.getMessage());
        }
        return connection;
    }
}
