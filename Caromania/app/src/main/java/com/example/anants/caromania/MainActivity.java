/**
 * this file is for second activity i.e the main activity
 */
package com.example.anants.caromania;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.io.ByteArrayOutputStream;

import android.net.Uri;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    /**
     * this class provides various methods and variables to handle main activity
     */

    private ImageView mCarImage;
    private EditText mCarTitle;
    private EditText mAboutCar;
    private EditText mEngineDisplacement;
    private EditText mMaximumPower;
    private EditText mMaximumTorque;
    private EditText mTopSpeed;
    private EditText mAcceleration;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Button mEditButton;
    private Button mSaveButton;
    private RelativeLayout main;
    private static final int SELECT_PICTURE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // function call to initilise all the widgets
        init();

        // Code to hide the keyboard
        this.getWindow().setSoftInputMode(WindowManager
                .LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //defining shared preferences
        pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        editor = pref.edit();

        //making Edit text ---> uneditable
        unedit();

        // Setting the content from the shared preference if stored
        try {
            getPref();
        }catch (Exception e){

        }

        //edit button onClick listener
        mEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit();
                mSaveButton.setVisibility(View.VISIBLE);
                mEditButton.setVisibility(View.GONE);
            }
        });

        //save button onClick listener
        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPref();
                getPref();
                unedit();
                mSaveButton.setVisibility(View.GONE);
                mEditButton.setVisibility(View.VISIBLE);
                Snackbar.make(main,getResources().getString(R.string.saved),
                        Snackbar.LENGTH_LONG).show();
            }
        });
    }

    /*initialising all the widgets*/
    private void init() {
        mCarImage = (ImageView) findViewById(R.id.imageView2);
        mCarTitle = (EditText) findViewById(R.id.carTitle);
        mAboutCar = (EditText) findViewById(R.id.aboutCar);
        mEngineDisplacement = (EditText) findViewById(R.id.enginedisplacement);
        mMaximumPower = (EditText) findViewById(R.id.maximumpower);
        mMaximumTorque = (EditText) findViewById(R.id.maximumtorque);
        mTopSpeed = (EditText) findViewById(R.id.topspeed);
        mAcceleration = (EditText) findViewById(R.id.acceleration);
        mEditButton = (Button) findViewById(R.id.editButton);
        mSaveButton = (Button) findViewById(R.id.saveButton);
        main = (RelativeLayout) findViewById(R.id.mainLayout);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        /*Handle navigation view item clicks here*/
        int id = item.getItemId();
        if (id == R.id.nav_home ) {
            /*Handle the camera action*/
        }else if (id == R.id.nav_logout) {
            editor.putString("flag","0");
            editor.commit();
            Intent i=new Intent(this,Login.class);
            startActivity(i);
            Toast.makeText(this,getResources().getString(R.string.logout_successfull),
                    Toast.LENGTH_LONG).show();
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /*method to convert bitmap into base64 string*/
    public String encodeTobase64() {
        Bitmap immage = ((BitmapDrawable) mCarImage.getDrawable()).getBitmap();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        immage.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);
        Log.d("Image Log:", imageEncoded);
        return imageEncoded;
    }

    /*method to convert base64 string to bitmap*/
    public Bitmap decodeBase64(String input) {
        byte[] decodedByte = Base64.decode(input, 0);
        return BitmapFactory
                .decodeByteArray(decodedByte, 0, decodedByte.length);
    }

    /*function to make Edit Text --> uneditable*/
    public void unedit(){
        mCarTitle.setEnabled(false);
        mAboutCar.setEnabled(false);
        mEngineDisplacement.setEnabled(false);
        mMaximumPower.setEnabled(false);
        mMaximumTorque.setEnabled(false);
        mAcceleration.setEnabled(false);
        mTopSpeed.setEnabled(false);
    }

    /*function to make Edit Text --> editable*/
    public void edit(){
        mCarTitle.setEnabled(true);
        mAboutCar.setEnabled(true);
        mEngineDisplacement.setEnabled(true);
        mMaximumPower.setEnabled(true);
        mMaximumTorque.setEnabled(true);
        mAcceleration.setEnabled(true);
        mTopSpeed.setEnabled(true);
    }

    /*function to get data from the view and save it in the shared preference*/
    public void setPref(){
        editor.putString("carTitle",mCarTitle.getText().toString());
        editor.putString("aboutCar",mAboutCar.getText().toString());
        editor.putString("engineDisplacement",
                mEngineDisplacement.getText().toString());
        editor.putString("maximumPower",mMaximumPower.getText().toString());
        editor.putString("maximumTorque",mMaximumTorque.getText().toString());
        editor.putString("topspeed",mTopSpeed.getText().toString());
        editor.putString("acceleration",mAcceleration.getText().toString());
        editor.commit();
    }

    /*function to get data from shared preference and setting it in the view*/
    public void getPref(){
        mCarTitle.setText(pref.getString("carTitle",""));
        mAboutCar.setText(pref.getString("aboutCar",""));
        mEngineDisplacement.setText(pref.getString("engineDisplacement",""));
        mMaximumTorque.setText(pref.getString("maximumTorque",""));
        mMaximumPower.setText(pref.getString("maximumPower",""));
        mAcceleration.setText(pref.getString("acceleration",""));
        mTopSpeed.setText(pref.getString("topspeed",""));
        mCarImage.setImageBitmap(decodeBase64(
                pref.getString("imagePreferance","")));
    }

    /*function to select image from gallery*/
    public void openImageChooser(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,
                "Select Picture"), SELECT_PICTURE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                /*Get the url from data*/
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    /*setting the image in imageView and saving it in base64 coding in shared Preference*/
                    mCarImage.setImageURI(selectedImageUri);
                    editor.putString("imagePreferance", encodeTobase64());
                    editor.commit();
                    Snackbar.make(main,getResources().getString(R.string.image_saved),Snackbar.LENGTH_LONG).show();
                }
            }
        }
    }


}
