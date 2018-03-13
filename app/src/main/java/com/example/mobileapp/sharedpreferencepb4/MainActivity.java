package com.example.mobileapp.sharedpreferencepb4;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText emailET, passET;
    private TextView showInfoTV;
    private UserPreferences userPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailET = findViewById(R.id.emailValue);
        passET = findViewById(R.id.passValue);
        showInfoTV = findViewById(R.id.showInfo);
        userPreferences = new UserPreferences(this);
    }

    public void saveUser(View view) {
        String email = emailET.getText().toString();
        String pass = passET.getText().toString();

        User user = new User(email,pass);

        /*String msg = userPreferences.saveUserInfo(email,pass);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();*/
        String msg = userPreferences.saveUserObject(user);
        emailET.setText("");
        passET.setText("");
    }

    public void showUser(View view) {
        /*String email = userPreferences.getUserEmail();
        String pass = userPreferences.getUserPassword();*/
        User user = userPreferences.getUserObject();
        //showInfoTV.setText(email+"\n"+pass);
        showInfoTV.setText(user.getUserEmail()+"\n"+user.getUserPassword());
    }

    public void resetUser(View view) {
        userPreferences.resetUserInfo();
    }
}
