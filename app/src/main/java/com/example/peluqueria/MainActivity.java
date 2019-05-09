package com.example.peluqueria;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.peluqueria.com.example.peluqueria.conectors.LoginConnection;
import com.example.peluqueria.com.example.peluqueria.dialogs.RegisterDialog;
import com.example.peluqueria.com.example.peluqueria.interfaces.OnTaskCompleted;



public class MainActivity extends DialogFragment implements OnTaskCompleted {

    private EditText username=null;
    private EditText password=null;


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        Button showDialogBT;
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        username = (EditText)findViewById(R.id.editText);
//        password = (EditText)findViewById(R.id.editText3);
//
//
//
//        Button btn = (Button) findViewById(R.id.button);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                login();
//
//            }
//        });
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                login();
//            }
//        });
//
//        showDialogBT = findViewById(R.id.button2);
//
//        showDialogBT.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openDialog();
//            }
//        });
//
//    }

    public void openDialog(){

        RegisterDialog dialogo = new RegisterDialog();

        dialogo.show(getActivity().getSupportFragmentManager(),"1");//getSupportFragmentManager para reconocer los fragmentos
    }

    public void login(){
        LoginConnection login = new LoginConnection(username.getText().toString(),password.getText().toString(),this);
        login.execute();

        if(username.getText().toString().equals("admin")&& password.getText().toString().equals("admin")){
            System.out.println("Credenciales correctas");
        }else{
            System.out.println("Credenciales incorrectas");
        }
    }

    public void register(){
        LoginConnection register = new LoginConnection(username.getText().toString(),password.getText().toString(),this);
        register.execute();


    }


    @Override
    public void onTaskCompleted(String send) {
        System.out.println("Final");

        if(send.equals("acceso correcto")){
            Intent intent = new Intent(getActivity().getBaseContext(),Acceso.class);
            startActivityForResult(intent, 0);
        }else{
            username.setText("ERROR");
        }
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction

        LayoutInflater inflater = getActivity().getLayoutInflater();


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("CREA USUARIO")
                .setView(inflater.inflate(R.layout.activity_main, null))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        username = ((AlertDialog) dialog).findViewById(R.id.username);
                        password = ((AlertDialog) dialog).findViewById(R.id.password);
                        //startConexion();
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
}
