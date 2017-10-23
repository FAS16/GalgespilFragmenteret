package com.example.fahadali.galgespilfragmenteret;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HovedAktivitet extends AppCompatActivity {

    public static TextView øversteBanner;
    public static TextView nedersteBanner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoved_aktivitet);

        øversteBanner = (TextView) findViewById(R.id.øversteBanner);
        nedersteBanner = (TextView) findViewById(R.id.nedersteBanner);

        if (savedInstanceState == null) {
            Fragment menuFragment = new MenuFragment(); //Henter fragment i hovedaktiviteten
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_indhold, menuFragment)  // tom container i layout
                    .commit();
        }
    }
}
