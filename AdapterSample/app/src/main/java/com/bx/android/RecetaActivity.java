package com.bx.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bx.android.adapter.RecetaAdapter;
import com.bx.android.model.Receta;
import com.bx.android.storage.RecetaRepo;

import java.util.List;

public class RecetaActivity extends AppCompatActivity {

    private ListView lviReceta;
    private List<Receta> recetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receta);
        ui();
        getRecetas();
    }

    private void getRecetas() {
        //origen de datos
        RecetaRepo recetaRepo= new RecetaRepo();
        recetas= recetaRepo.getRecetas();

        //adapter
        RecetaAdapter recetaAdapter= new RecetaAdapter(recetas,this);

        //setAdapter al view
        lviReceta.setAdapter(recetaAdapter);

    }

    private void ui() {
        lviReceta= (ListView) findViewById(R.id.lviReceta);
        //events
        lviReceta.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
