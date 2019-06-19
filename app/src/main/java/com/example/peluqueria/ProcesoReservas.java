package com.example.peluqueria;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.peluqueria.fragmen.CalendarFragment;
import com.example.peluqueria.fragmen.MenuFragment;

public class ProcesoReservas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_reservas);

        buttonReservas();
    }

    public void buttonReservas() {

        CalendarFragment fragments = CalendarFragment.newInstance();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();

        fragmentTransaction.replace(R.id.procereserva, fragments);

        fragmentTransaction.commit();
    }
}
