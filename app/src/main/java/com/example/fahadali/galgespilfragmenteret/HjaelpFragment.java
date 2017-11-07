package com.example.fahadali.galgespilfragmenteret;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HjaelpFragment extends Fragment {

    TextView hjaelpeTekst;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hjaelp,container,false);

        hjaelpeTekst = view.findViewById(R.id.bannerSwitch);

        return view;
    }

}
