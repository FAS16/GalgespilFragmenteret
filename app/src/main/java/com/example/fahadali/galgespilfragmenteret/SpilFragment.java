package com.example.fahadali.galgespilfragmenteret;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SpilFragment extends Fragment implements View.OnClickListener {
    Galgelogik logik = new Galgelogik();
    private EditText gætteFelt;
    private ImageView grafik;
    private TextView info;
    private TextView brugteBogstaver;
    private TextView ordet;
    private Button spilleKnap;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_spil, container, false);

        gætteFelt = view.findViewById(R.id.gætteFelt_editText);
        gætteFelt.setFilters(new InputFilter[]{new InputFilter.AllCaps(){}});
        grafik = view.findViewById(R.id.grafik_imageView);
        info = view.findViewById(R.id.info_textView);
        brugteBogstaver = view.findViewById(R.id.brugteBogstaver_textView);
        ordet = view.findViewById(R.id.ordet_textView);
        spilleKnap = view.findViewById(R.id.spil_btn);

        ordet.setText("Gæt ordet: " + logik.getSynligtOrd());
        spilleKnap.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        if (view == spilleKnap) {
            String bogstav = gætteFelt.getText().toString();
            if (bogstav.length() != 1) {
                gætteFelt.setError("Du kan kun gætte på et bogstav");
                return;
            }
            logik.gætBogstav(bogstav);
            gætteFelt.setText("");
            gætteFelt.setError(null);
            opdaterSkærm();
        }
    }

    public void opdaterSkærm() {

        if (logik.erSpilletVundet()) {
            info.setTextColor(Color.GREEN);
            info.setText("Du vandt!");
            ordet.setTextColor(Color.parseColor("#00FFFF"));
            ordet.setText(logik.getOrdet());
            grafik.setImageResource(R.drawable.vundet);
        } else {

            ordet.setText(logik.getSynligtOrd());

            if(logik.getAntalForkerteBogstaver() > 0) {
                brugteBogstaver.setText("Du har " + logik.getAntalForkerteBogstaver() + " forkert(e):  " + logik.getForkerteBogstaver());
            }


            switch (logik.getAntalForkerteBogstaver()) {
                case 1:
                    grafik.setImageResource(R.drawable.forkert1);
                    break;
                case 2:
                    grafik.setImageResource(R.drawable.forkert2);
                    break;
                case 3:
                    grafik.setImageResource(R.drawable.forkert3);
                    break;
                case 4:
                    grafik.setImageResource(R.drawable.forkert4);
                    break;
                case 5:
                    grafik.setImageResource(R.drawable.forkert5);
                    break;
                case 6:
                    grafik.setImageResource(R.drawable.forkert6doed);
                    info.setTextColor(Color.RED);
                    info.setText("Du har tabt!");
                    ordet.setTextColor(Color.parseColor("#00FFFF"));
                    ordet.setText(logik.getOrdet());

                    break;
                default:

            }

        }

    }

}
