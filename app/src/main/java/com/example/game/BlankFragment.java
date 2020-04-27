package com.example.game;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;



/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {

     TextView textView,textView2;
     static int points = 0 ;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private Integer mParam1;
//    private String mParam2;

    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView2 = view.findViewById(R.id.points);
        textView = view.findViewById(R.id.fragmentText);
        Random random = new Random();
        int randomIndex = random.nextInt((100) + 1);
        int raznica;
        raznica = randomIndex - mParam1;
        Log.d("ololo", "otvet: "+ randomIndex);
        if (randomIndex == mParam1){
            textView.setText("Угадал");
            points = points + 100;
            textView2.setText(String.valueOf(points));
        }else if (raznica <= 10 && raznica >= -10){
            textView.setText("Почти угадал");
            points = points + 50;
            textView2.setText(String.valueOf(points));
        }else {
            textView.setText("Не угадал");
            points = points - 10;
            textView2.setText(String.valueOf(points));
        }

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(Integer param1) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
            randomizer(mParam1);
            Log.d("olo", "From fragment");
            Log.d("olo",""+ mParam1);
        }
    }

    private void randomizer(int s) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return
                inflater.inflate(R.layout.fragment_blank, container, false);
    }
}
