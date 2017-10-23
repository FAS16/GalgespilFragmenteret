package com.example.fahadali.galgespilfragmenteret;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MenuFragment extends Fragment implements View.OnClickListener {

    private Button startKnap;
    private Button indstillingerKnap;
    private Button hjælpKnap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        startKnap = view.findViewById(R.id.startKnap);
        indstillingerKnap = view.findViewById(R.id.indstillingerKnap);
        hjælpKnap = view.findViewById(R.id.hjælpKnap);


        startKnap.setOnClickListener(this);
        indstillingerKnap.setOnClickListener(this);
        hjælpKnap.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        if(view == startKnap){
            getFragmentManager().beginTransaction()
                    .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                    .replace(R.id.fragment_indhold, new SpilFragment())
                    .addToBackStack(null)
                    .commit();
        }

        if(view == indstillingerKnap){
            getFragmentManager().beginTransaction()
                    .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                    .replace(R.id.fragment_indhold, new IndstillingerFragment())
                    .addToBackStack(null)
                    .commit();
        }

        if(view == hjælpKnap){
            getFragmentManager().beginTransaction()
                    .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                    .replace(R.id.fragment_indhold, new HjaelpFragment())
                    .addToBackStack(null)
                    .commit();
        }



    }
}
