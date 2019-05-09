package com.example.peluqueria.com.example.peluqueria.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.peluqueria.R;
import com.example.peluqueria.SimpleCalendar;

public class CitaDialog extends DialogFragment implements SimpleCalendar.DayClickListener{

    private ConstraintLayout rootlayout = null;
    private SimpleCalendar calendario = null;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction

        LayoutInflater inflater = getActivity().getLayoutInflater();


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder
                .setView(inflater.inflate(R.layout.activity_cita_dialog, null))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
//                        editUser = ((AlertDialog) dialog).findViewById(R.id.username);
//                        editPass = ((AlertDialog) dialog).findViewById(R.id.password);
//                        startConexion();
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it

        AlertDialog  dialog = builder.create();
        dialog.show();

        if(dialog.findViewById(R.id.rootlayout)==null){
            System.out.println("Es nulo");
        }else{
            System.out.println("No es nulo");
        }

        onViewCreated(((AlertDialog) dialog).findViewById(R.id.rootlayout), savedInstanceState);

        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        calendario = view.findViewById(R.id.calendar);

        calendario.setCallBack(this);

    }


    @Override
    public void onDayClick(View view) {
        System.out.println("HOLA");
    }
}
