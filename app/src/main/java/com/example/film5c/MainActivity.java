package com.example.film5c;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String[] film = {
            "Spiderman",
            "Titanic",
            "Catwoman",
            "Superman"
    };

    ListView listFilm;
    Button btnFilm;
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //find views by their ID
        listFilm = (ListView) findViewById(R.id.listFilm);
        btnFilm = (Button) findViewById(R.id.btnFilm);

        //constructor uses application context, a layout, an array
        ArrayAdapter<String> adapterFilm = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, film);

        //adapt the array to a ListView using the previously selected layout
        listFilm.setAdapter(adapterFilm);

        //Listen for a click in a single item of an AdapterView
        listFilm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //set titolo to the string in "position" position
                String titolo = listFilm.getItemAtPosition(position).toString();

                //this toast uses the application context
                Toast.makeText(getApplicationContext(), titolo, Toast.LENGTH_SHORT).show();

                //logs the item pressed with the tag "Cliccone"
                Log.d("Cliccone", "Hai premuto " + titolo);

                //this creates a new Intnet using as his constructor parameters the application context and the class of the new view
                i = new Intent(getApplicationContext(), dettaglio_film.class);

                //add a string to the existing intent
                i.putExtra("titolo", titolo);

                //start the new intent switching views
                startActivity(i);

            }
        });

        //listen for a click
        btnFilm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //this toast uses the current view context
                Toast.makeText(MainActivity.this, "Testone", Toast.LENGTH_LONG).show();

            }
        });
    }


}