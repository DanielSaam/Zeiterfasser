package de.fowli.zeiterfasser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected String initDatum () {
        Calendar kalender = Calendar.getInstance();

        int[] datum = {kalender.get(Calendar.DAY_OF_MONTH),
                kalender.get(Calendar.MONTH),
                kalender.get(Calendar.YEAR)};

        String stringDatum = new String(String.valueOf(datum[0]) + "." +
                String.valueOf(datum[1]) + "." +
                String.valueOf(datum[2]));

        return stringDatum;
    }

    protected String initZeit () {
        Calendar kalender = Calendar.getInstance();

        int[] zeit = {kalender.get(Calendar.HOUR_OF_DAY),
                kalender.get(Calendar.MINUTE)};

        String stringZeit = new String(String.valueOf(zeit[0]) + ":" +
                String.valueOf(zeit[1]));

        return stringZeit;
    }

    // Button Events
    public void startzeitSetzen(View view){
        String datum = initDatum();
        String zeit = initZeit();

        // Button initialisieren
        // Button buttonStartzeit = (Button) findViewById(R.id.buttonStartzeit);
        TextView textViewStartzeit = (TextView) findViewById(R.id.textStartzeitEdit);
        textViewStartzeit.setText(datum + " / " +
                zeit + " ");
    }

    public void endzeitSetzen(View view) {
        // Button initialisieren
        Button buttonEndzeit = (Button) findViewById(R.id.buttonEndzeit);
    }
}