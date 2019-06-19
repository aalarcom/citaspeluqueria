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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.peluqueria.Calendar_prueba;
import com.example.peluqueria.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class CitaDay extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private int[] fecha;

    private String mParam2;

    private TextView texto;

    private ListView listView;

    private Spinner servicelist;
    //private ExpandableListView servicelist;

    public CitaDay() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CitaDay.
     */
    // TODO: Rename and change types and number of parameters
    public static CitaDay newInstance() {
        CitaDay fragment = new CitaDay();
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
            fecha = getArguments().getIntArray("fecha");
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cita_day, container, false);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        texto = view.findViewById(R.id.fechainicio);
        texto.setText(fecha[0]+"-"+(fecha[1]+1)+"-"+fecha[2]);

        listView = (ListView)getView().findViewById(R.id.hourslist);

        final ArrayList<String> arrayList=new ArrayList<>();

        arrayList.add("9:00");
        arrayList.add("9:30");
        arrayList.add("10:30");
        arrayList.add("10:30");
        arrayList.add("11:00");
        arrayList.add("11:30");
        arrayList.add("12:00");
        arrayList.add("12:30");
        arrayList.add("13:00");
        arrayList.add("13:30");
        arrayList.add("14:00");
        arrayList.add("14:30");
        arrayList.add("15:00");
        arrayList.add("15:30");
        arrayList.add("16:00");
        arrayList.add("16:30");
        arrayList.add("17:00");
        arrayList.add("17:30");
        arrayList.add("18:00");
        arrayList.add("18:30");
        arrayList.add("19:00");
        arrayList.add("19:30");
        arrayList.add("20:00");
        arrayList.add("20:30");
        arrayList.add("21:00");
        arrayList.add("21:30");

       ArrayAdapter arrayAdapter=new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),"clicket item:"+position+" "+arrayList.get(position).toString(),Toast.LENGTH_SHORT).show();
                displayFragment5(arrayList.get(position),(String) servicelist.getSelectedItem()); //pasamos como parámetro la posición que pulsamos en la listview
            }
        });

        servicelist = (Spinner) getView().findViewById(R.id.servicio);

        final ArrayList<String> servicio = new ArrayList<>();
        servicio.add("Corte de pelo");
        servicio.add("arreglo de barba");
        servicio.add("patillas, cuello ó cejas");
        servicio.add("tinte");
        servicio.add("Masaje capilar");

        ArrayAdapter arrayAdapter2=new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,servicio);

        servicelist.setAdapter(arrayAdapter2);

    }

    public void displayFragment5(String hora, String servicio) {

        DatosUsuario fragment5 = DatosUsuario.newInstance();

        Bundle bundle = new Bundle();
        bundle.putString("fecha", texto.getText().toString());//le pasamos texto como la fecha como un string y le decimos que es un string con tostring.
        bundle.putString("hora", hora);//cogemos la hora pasado como parámetro.
        bundle.putString("servicio", servicio);



        fragment5.setArguments(bundle);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();


        fragmentTransaction.replace(R.id.procereserva, fragment5);//Este es el contenedor donde reemplazo los fragmentos
        System.out.println("ADIOS");
        fragmentTransaction.addToBackStack("HECHO2").commit();

    }


}
