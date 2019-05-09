package com.example.peluqueria.com.example.peluqueria.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.widget.EditText;
import com.example.peluqueria.R;
import com.example.peluqueria.com.example.peluqueria.conectors.RegisterConection;


public class RegisterDialog extends DialogFragment {

    private EditText editUser=null;
    private EditText editPass=null;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction

        LayoutInflater inflater = getActivity().getLayoutInflater();


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("CREA USUARIO")
                .setView(inflater.inflate(R.layout.register_dialog, null))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        editUser = ((AlertDialog) dialog).findViewById(R.id.username);
                        editPass = ((AlertDialog) dialog).findViewById(R.id.password);
                        startConexion();
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }


    private void startConexion(){

        if(!editUser.getText().toString().equals("") && !editPass.getText().toString().equals("")){

            RegisterConection inserta = new RegisterConection(editUser.getText().toString(),editPass.getText().toString());
            inserta.execute();

        }

    }

}
