/**
 * this files handles the first activity which is the mLogin activity of the application
 */
package com.example.anants.caromania;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    /**
     * this class provides variables and methods for handling mLogin
     */
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private TextView mUname;
    private TextView mUpass;
    private String mUsername;
    private String mPassword;
    private TextInputLayout floatingUsernameLabel;
    private TextInputLayout floatingUsernameLabe2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Code to hide the title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //setting the view
        setContentView(R.layout.activity_login);
        // initialising all the widgets
        init();
        //defining shared preferences
        pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        editor = pref.edit();
        //putting key value pair in shared preferences
        editor.putString("mUsername","anant");
        editor.putString("mPassword","mindfire");
        editor.commit();
        try {
            if (pref.getString("flag", "").equals("1")) {
                Intent i = new Intent(Login.this , MainActivity.class);
                //starting main activity on success
                startActivity(i);
                finish();
            }
        }catch (Exception e){

        }
    }

    private void getdata() {
        mUsername = mUname.getText().toString();
        mPassword = mUpass.getText().toString();
    }

    private void init() {
        mUname = (TextView) findViewById(R.id.username);
        mUpass = (TextView) findViewById(R.id.password);
        floatingUsernameLabel = (TextInputLayout) findViewById(R.id.usernameText);
        floatingUsernameLabe2 = (TextInputLayout) findViewById(R.id.passwordText);
    }

    public void login(View view){

        // code to hide the soft input keyboard
        InputMethodManager imm = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

        //function call to get the text from the edit text
        getdata();
        if (mUsername.equals("")){
            floatingUsernameLabel.setError(getResources().getString(R.string.username_required));
            floatingUsernameLabel.setErrorEnabled(true);
        }
        else if(mPassword.equals("")){
            floatingUsernameLabe2.setError(getResources().getString(R.string.password_requireed));
            floatingUsernameLabe2.setErrorEnabled(true);
        }
        else {
            // condition to check if the mUsername , mPassword is correct or not from shared preference
            if ((pref.getString("mUsername", "").equals(mUsername)) &&
                    (pref.getString("mPassword", "").equals(mPassword))) {
                editor.putString("flag", "1");
                editor.commit();
                Intent i = new Intent(Login.this, MainActivity.class);

                //starting main activity on success
                startActivity(i);
                Toast.makeText(this,getResources().getString(R.string.login_successfull),Toast.LENGTH_LONG).show();
                finish();
            } else {

                //message to notify user using toast
                mUname.setText("");
                mUpass.setText("");
                Toast.makeText(this,getResources().getString(R.string.login_error), Toast.LENGTH_LONG).show();
            }
        }
        mUname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                floatingUsernameLabel.setErrorEnabled(false);
            }
        });
        mUpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                floatingUsernameLabe2.setErrorEnabled(false);
            }
        });
    }
}
