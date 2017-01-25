package com.bx.android.lesson5.baseadapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.bx.android.lesson5.R;

import java.util.Arrays;

/**
 * Created by pjohnson on 24/01/17.
 */

public class BaseAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter);
        ListView baseAdapterListView = (ListView) findViewById(R.id.baseAdapterList);
        baseAdapterListView.setAdapter(new BaseAdapterExample(this, Arrays.asList(getResources().getStringArray(R.array.lorem))));

    }
}
