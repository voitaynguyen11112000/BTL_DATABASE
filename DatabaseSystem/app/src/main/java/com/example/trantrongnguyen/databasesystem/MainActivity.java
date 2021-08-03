package com.example.trantrongnguyen.databasesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.trantrongnguyen.databasesystem.fragment.InsertFragment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {
    public Connection connection;
    Button btnConnection;
    String connectionResult = "";
    public String ip, database, username,password;
    public EditText editIP, editDBName, editUser, editPass;
    TextView txtViewNofi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnConnection = findViewById(R.id.btnConnection);
        editIP = findViewById(R.id.editIP);
        editDBName = findViewById(R.id.editDBName);
        editUser = findViewById(R.id.editUser);
        editPass = findViewById(R.id.editPass);
        editPass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        txtViewNofi=findViewById(R.id.txtViewNofi);
        btnConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ip = editIP.getText().toString();
                database = editDBName.getText().toString();
                username = editUser.getText().toString();
                password = editPass.getText().toString();
                ConnectionHelper connectionHelper = new ConnectionHelper();
                connection = connectionHelper.connectionclass(username, password, database, ip);
                if(connection!=null){
                    System.out.println("Success connection");
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    Bundle data1 = new Bundle();
                    data1.putString("username",username);
                    data1.putString("password",password);
                    data1.putString("database",database);
                    data1.putString("ip",ip);
                    intent.putExtras(data1);
                    startActivity(intent);
                }
                else{
                    System.out.println("Fail to connection");
                    txtViewNofi.setText("Fail to connection");
                }
            }
        });
    }
}
