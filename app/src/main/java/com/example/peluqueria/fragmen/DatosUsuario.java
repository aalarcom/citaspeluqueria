package com.example.peluqueria.fragmen;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.peluqueria.R;
import com.example.peluqueria.com.example.peluqueria.conectors.RegisterConection;
import com.example.peluqueria.com.example.peluqueria.conectors.ReservaConnection;

import java.sql.SQLOutput;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DatosUsuario.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DatosUsuario#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DatosUsuario extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private String fecha;
    private String hora;
    private TextView reservafecha;
    private TextView reservahora;
    private TextView reservaservicio;
    private String servicio;
    private Button guardarcita;


    public DatosUsuario() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DatosUsuario.
     */
    // TODO: Rename and change types and number of parameters
    public static DatosUsuario newInstance() {
        DatosUsuario fragment = new DatosUsuario();
        /*Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);*/
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            //mParam1 = getArguments().getString(ARG_PARAM1);
            //mParam2 = getArguments().getString(ARG_PARAM2);
            fecha = getArguments().getString("fecha");
            hora = getArguments().getString("hora");
            servicio = getArguments().getString("servicio");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_datos_usuario, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        reservafecha = view.findViewById(R.id.fechareserva);
        reservafecha.setText(fecha);


        reservahora = view.findViewById(R.id.horareserva);
        reservahora.setText(hora);


        reservaservicio = view.findViewById(R.id.servicioreserva);
        reservaservicio.setText(servicio);

        guardarcita = view.findViewById(R.id.confirmareserva);

        guardarcita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startConexion();
            }
        });

    }

    private void startConexion(){

        if(!reservafecha.getText().toString().equals("") && !reservahora.getText().toString().equals("")&& !reservaservicio.getText().toString().equals("")){

            System.out.println(reservafecha.getText().toString());

            ReservaConnection inserta = new ReservaConnection(reservafecha.getText().toString(),reservahora.getText().toString(),reservaservicio.getText().toString());
            inserta.execute();

            getActivity().onBackPressed();

        }

    }
}
