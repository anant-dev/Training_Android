package com.example.anants.caromania;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    TextView uname;
    TextView upass;
    Button login;
    String username;
    String password;
    TextInputLayout floatingUsernameLabel;
    TextInputLayout floatingUsernameLabe2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Code to hide the title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //setting the view
        setContentView(R.layout.activity_login);
        // initialising all the widgets
        init();
        //defining shared preferences
        pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        editor = pref.edit();
        //putting key value pair in shared preferences
        editor.putString("username","anant");
        editor.putString("password","mindfire");
        editor.commit();
        try {
            if (pref.getString("flag", "").equals("1")) {
                Intent i = new Intent(Login.this,MainActivity.class);
                //starting main activity on success
                startActivity(i);
                finish();
            }
        }catch (Exception e){

        }
    }

    private void getdata() {
        username= uname.getText().toString();
        password=upass.getText().toString();
    }

    private void init() {
        uname=(TextView) findViewById(R.id.username);
        upass=(TextView) findViewById(R.id.password);
        login=(Button) findViewById(R.id.login);
        floatingUsernameLabel = (TextInputLayout) findViewById(R.id.usernameText);
        floatingUsernameLabe2 = (TextInputLayout) findViewById(R.id.passwordText);
    }

    public void login(View view){
        // code to hide the soft input keyboard
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        //function call to get the text from the edit text
        getdata();
        if (username.equals("")){
            floatingUsernameLabel.setError(getResources().getString(R.string.username_required));
            floatingUsernameLabel.setErrorEnabled(true);
        }
        else if(password.equals("")){
            floatingUsernameLabe2.setError(getResources().getString(R.string.password_requireed));
            floatingUsernameLabe2.setErrorEnabled(true);
        }
        else {
            // condition to check if the username , password is correct or not from shared preference
            if (pref.getString("username", "").equals(username) && pref.getString("password", "").equals(password)) {
                editor.putString("flag", "1");
                editor.commit();
                Intent i = new Intent(Login.this, MainActivity.class);
                //starting main activity on success
                startActivity(i);
                Toast.makeText(this,getResources().getString(R.string.login_successfull),Toast.LENGTH_LONG).show();
                finish();
            } else {
            /*Snackbar.make(view, "Incorrect Username or password", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();*/
                //message to notify user using toast
                uname.setText("");
                upass.setText("");
                Toast.makeText(this,getResources().getString(R.string.login_error), Toast.LENGTH_LONG).show();
            }
        }
        uname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                floatingUsernameLabel.setErrorEnabled(false);
            }
        });
        upass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                floatingUsernameLabe2.setErrorEnabled(false);
            }
        });
    }
}
