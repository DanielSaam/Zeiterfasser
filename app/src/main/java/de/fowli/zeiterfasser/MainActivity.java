package de.fowli.zeiterfasser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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

        return (String.valueOf(datum[0]) + "." +
                String.valueOf(datum[1] + 1) + "." +
                String.valueOf(datum[2]));
    }

    protected String initZeit () {
        Calendar kalender = Calendar.getInstance();

        int[] zeit = {kalender.get(Calendar.HOUR_OF_DAY),
                kalender.get(Calendar.MINUTE)};

        return (String.valueOf(zeit[0]) + ":" + String.valueOf(zeit[1]));
    }

    // Verstrichene Zeit ausrechnen
    protected void differenzBerechnung() {

    }

    // Button Events
    public void startzeitSetzen(View view){
        String datum = initDatum();
        String zeit = initZeit();
        String datumUhrzeit = (datum + " / " + zeit + " ");

        TextView textViewStartzeit = (TextView) findViewById(R.id.textStartzeitEdit);
        textViewStartzeit.setText(datumUhrzeit);
    }

    public void endzeitSetzen(View view) {
        String datum = initDatum();
        String zeit = initZeit();
        String datumUhrzeit = (datum + " / " + zeit + " ");

        TextView textViewEndzeit = (TextView) findViewById(R.id.textViewEndzeitEdit);
        textViewEndzeit.setText(datumUhrzeit);
    }
}