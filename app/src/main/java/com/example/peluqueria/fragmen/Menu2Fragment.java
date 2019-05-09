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
import android.widget.EditText;

import com.example.peluqueria.MainActivity;
import com.example.peluqueria.R;
import com.example.peluqueria.com.example.peluqueria.dialogs.CitaDialog;
import com.example.peluqueria.com.example.peluqueria.dialogs.RegisterDialog;
import com.example.peluqueria.com.example.peluqueria.interfaces.OnTaskCompleted;


public class Menu2Fragment extends Fragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button showDialogBT;
    private EditText username=null;
    private EditText password=null;
    private Button loginButton;
    private Button citaButton;

    //private OnFragmentInteractionListener mListener;

    public Menu2Fragment() {
        // Required empty public constructor
    }

    public static Menu2Fragment newInstance() {
        Menu2Fragment fragment = new Menu2Fragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu2, container, false);
    }



    public void openDialog(){

        RegisterDialog dialogo = new RegisterDialog();

        dialogo.show(getActivity().getSupportFragmentManager(),"1");//getSupportFragmentManager para reconocer los fragmentos

//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
    public void openLoginDialog() {

        MainActivity dialogo = new MainActivity();

        System.out.println("dialogo login creado");

        dialogo.show(getActivity().getSupportFragmentManager(), "1");//getSupportFragmentManager para reconocer los fragmentos
    }

    public void openCitaDialog() {

        CitaDialog dialogo = new CitaDialog();

        System.out.println("dialogo cita creado");

        dialogo.show(getActivity().getSupportFragmentManager(), "1");//getSupportFragmentManager para reconocer los fragmentos
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        showDialogBT = view.findViewById(R.id.button2);

        loginButton = view.findViewById(R.id.loginbutton);

        citaButton = view.findViewById(R.id.citabutton);



        showDialogBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("pulsamos login");
                openLoginDialog();
            }
        });

        citaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("pulsamos cita");
                openCitaDialog();
            }
        });



    }


}
