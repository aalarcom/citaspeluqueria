package com.example.peluqueria.fragmen;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.peluqueria.MainActivity;
import com.example.peluqueria.R;
import com.example.peluqueria.SimpleCalendar;


public class CalendarFragment extends Fragment implements SimpleCalendar.DayClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private SimpleCalendar calendario = null;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalendarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CalendarFragment newInstance() {
        CalendarFragment fragment = new CalendarFragment();
        /*Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);*/
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup procereserva,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calendar, procereserva, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        calendario = view.findViewById(R.id.calendar);

        if(calendario != null){
            System.out.println("El calendario no es null");
        }

        calendario.setCallBack(this);

    }


    @Override
    public void onDayClick(View view) {

        CitaDay fragmento = CitaDay.newInstance();

        Bundle bundle = new Bundle();
        int[] tag = (int[]) view.getTag();
        bundle.putIntArray("fecha", tag);

        fragmento.setArguments(bundle);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();

        fragmentTransaction.replace(R.id.procereserva, fragmento);

        fragmentTransaction.addToBackStack("HECHO2").commit();

        //CitaDay dialogo = new CitaDay();

        //dialogo.show(getActivity().getSupportFragmentManager(), "1");//getSupportFragmentManager para reconocer los fragmentos

    }

}
