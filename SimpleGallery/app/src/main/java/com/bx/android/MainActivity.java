package com.bx.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String TAG="CONSOLE";
    private ImageView img;
    private Button btnImg;
    private TextView txtImg;
    private int count;
    private int[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        app();
    }

    private void app() {

        images= new int[]{
                R.mipmap.sample_0,
                R.mipmap.sample_1,
                R.mipmap.sample_2,
                R.mipmap.sample_3,
                R.mipmap.sample_4,
                R.mipmap.sample_5,
                R.mipmap.sample_6,
                R.mipmap.sample_7};

        img= (ImageView)findViewById(R.id.img);
        btnImg= (Button)findViewById(R.id.butImg);
        txtImg = (TextView)findViewById(R.id.txtImg);

        img.setImageResource(images[0]);
        count=0;

        txtImg.setText("Imagen " + count);
        img.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                count++;
                if (count >= images.length) {
                    count = 0;
                }
                img.setImageResource(images[count]);
                txtImg.setText("Image " + count);

                Log.v(TAG, " count " + count);

            }
        });
    }

    public void  onClickHandler(View v)
    {
        Toast.makeText(this, "Oaaa Bx", Toast.LENGTH_LONG).show();
    }
}
