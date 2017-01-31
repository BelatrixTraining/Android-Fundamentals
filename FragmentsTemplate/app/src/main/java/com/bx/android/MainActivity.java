package com.bx.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        app();
    }

    private void app() {
        //next(MessageActivity.class,null,true);
        //next(ColorActivity.class,null,true);
        //next(DynamicFragmentActivity.class,null,true);
        next(ContactsActivity.class,null,true);
    }
}
