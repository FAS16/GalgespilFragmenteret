package com.example.fahadali.galgespilfragmenteret;


import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;


public class IndstillingerFragment extends Fragment implements CompoundButton.OnCheckedChangeListener {

    Switch bannerSwitch;
    static boolean rødeBannere;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_indstillinger,container,false);

        bannerSwitch = view.findViewById(R.id.bannerSwitch);
        bannerSwitch.setOnCheckedChangeListener(this);
        if(rødeBannere) bannerSwitch.setChecked(true);

        return view;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


        if(b){
            HovedAktivitet.øversteBanner.setBackgroundColor(Color.parseColor("#991818"));
            HovedAktivitet.nedersteBanner.setBackgroundColor(Color.parseColor("#991818"));
            rødeBannere = true;
        }
        else{
            HovedAktivitet.øversteBanner.setBackgroundColor(Color.parseColor("#9b9b9b"));
            HovedAktivitet.nedersteBanner.setBackgroundColor(Color.parseColor("#9b9b9b"));
            rødeBannere = false;
        }

    }
}
