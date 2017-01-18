package com.bx.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

//public class MainActivity extends AppCompatActivity implements OnDialogListener{
public class MainActivity extends AppCompatActivity{

    private static final String TAG = "MainActivity";
    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String applicationiD= BuildConfig.APPLICATION_ID;

        Log.v(TAG, "applicationiD "+applicationiD);
    }

    /*@Override
    public void onPositiveAction(Object object) {

    }

    @Override
    public void onNegativeAction(Object object) {

    }*/


    /**
     * Live template
     */
    private void extras(){
        if(getIntent()!=null){
            if(getIntent().getExtras()!=null){
                Bundle bundle= getIntent().getExtras();

                userId=bundle.getInt("USERID");
            }
        }
    }
}
