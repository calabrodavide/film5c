package com.example.film5c;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] film = {
            "Spiderman",
            "Titanic",
            "Catwoman",
            "Superman"
    };

    ListView listFilm;
    Button btnFilm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listFilm = (ListView) findViewById(R.id.listFilm);
        ArrayAdapter<String> adapterFilm = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, film);
        listFilm.setAdapter(adapterFilm);

        listFilm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String titolo = listFilm.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), titolo, Toast.LENGTH_LONG).show();
                Log.d("Cliccone", "Hai premuto " + titolo);
            }
        });

        btnFilm = (Button) findViewById(R.id.btnFilm);

        btnFilm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Testone", Toast.LENGTH_LONG).show();
            }
        });
    }


}