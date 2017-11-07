package com.example.fahadali.galgespilfragmenteret;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.widget.TextView;

public class HovedAktivitet extends Activity{

    public static TextView øversteBanner;
    public static TextView nedersteBanner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoved_aktivitet);

        øversteBanner = findViewById(R.id.øversteBanner);
        nedersteBanner = findViewById(R.id.nedersteBanner);

        if (savedInstanceState == null) {
            Fragment menuFragment = new MenuFragment(); //Henter fragment i hovedaktiviteten
            getFragmentManager().beginTransaction()
                    .add(R.id.fragment_indhold, menuFragment)  // tom container i layout
                    .commit();
        }
    }
}
