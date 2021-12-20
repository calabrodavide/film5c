package com.example.film5c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;

public class dettaglio_film extends AppCompatActivity {

    Intent i;
    ImageView img;
    TextView ltitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dettaglio_film);

        //find views by their ID
        img = (ImageView) findViewById(R.id.locanda);
        ltitle = (TextView) findViewById(R.id.ltitle);

        //gets the intent that generated this view
        i = getIntent();

        //gets the previously added string in the intent
        String titolo = i.getStringExtra("titolo");

        //appends the selected string to the TextView
        ltitle.append(titolo);

        //this toast uses the current view context
        Toast.makeText(dettaglio_film.this, "hai ricevuto: " + titolo, Toast.LENGTH_SHORT).show();

        //statically applied image
        //img.setImageResource(R.drawable.spiderman);

        //dynamically applied image
        img.setImageResource(getResources().getIdentifier(titolo.toLowerCase(Locale.ROOT), "drawable", getPackageName()));

    }
}