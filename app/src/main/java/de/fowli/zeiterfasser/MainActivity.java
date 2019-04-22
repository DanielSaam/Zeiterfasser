package de.fowli.zeiterfasser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    // Setter und Getter
    //
    public String getDatumStart() {
        return datumStart;
    }

    public void setDatumStart(String datumStart) {
        this.datumStart = datumStart;
    }

    private String datumStart;
    //

    public String getDatumEnd() {
        return datumEnd;
    }

    public void setDatumEnd(String datumEnd) {
        this.datumEnd = datumEnd;
    }

    private String datumEnd;
    //

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    private String timeStart;
    //

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    private String timeEnd;
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Datum und die Zeit initialisieren
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
    protected String differenzZeitBerechnung() {

        // Die Strings werden gesplittet, damit man damit rechnen kann
        String stringZeitStartSplit = getTimeStart();
        String stringZeitEndeSplit = getTimeEnd();
        String[] arrayZeitStart;
        String[] arrayZeitEnde;
        int ergebnis;

        String delimiter = ":"; /* Das Trennzeichen */

        arrayZeitStart = stringZeitStartSplit.split(delimiter);
        arrayZeitEnde = stringZeitEndeSplit.split(delimiter);

        // Die Uhrzeit in String wird zu Integer umgewandelt
        int stundeStart = Integer.parseInt(arrayZeitStart[0]);
        int minuteStart = Integer.parseInt(arrayZeitStart[1]);
        int stundeEnde = Integer.parseInt(arrayZeitEnde[0]);
        int minuteEnde = Integer.parseInt(arrayZeitEnde[1]);

        // Es wird alles zusammengezählt
        int ergebnisStart = (stundeStart * 60) + minuteStart;
        int ergebnisEnde = (stundeEnde * 60) + minuteEnde;

        if (ergebnisStart > ergebnisEnde) {
            ergebnis =  ergebnisStart - ergebnisEnde;
        } else {
            ergebnis = ergebnisEnde - ergebnisStart;
        }

        return String.valueOf(ergebnis);
    }

    // Button Events
    public void startzeitSetzen(View view){
        String datum = initDatum();
        String zeit = initZeit();
        String datumUhrzeit = (datum + " / " + zeit + " ");

        TextView textViewStartzeit = (TextView) findViewById(R.id.textStartzeitEdit);
        textViewStartzeit.setText(datumUhrzeit);

        setDatumStart(datum);
        setTimeStart(zeit);
    }

    public void endzeitSetzen(View view) {
        String datum = initDatum();
        String zeit = initZeit();
        String datumUhrzeit = (datum + " / " + zeit + " ");

        TextView textViewEndzeit = (TextView) findViewById(R.id.textViewEndzeitEdit);
        textViewEndzeit.setText(datumUhrzeit);

        setDatumEnd(datum);
        setTimeEnd(zeit);

        TextView textViewStartzeit = (TextView) findViewById(R.id.textStartzeitEdit);
        textViewStartzeit.setText(differenzZeitBerechnung());
    }
}