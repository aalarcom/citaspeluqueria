package com.example.peluqueria.com.example.peluqueria.beans;

import android.graphics.Color;

import org.jetbrains.annotations.NotNull;


import ru.cleverpumpkin.calendar.CalendarDate;
import ru.cleverpumpkin.calendar.CalendarView;

public class Evento implements CalendarView.DateIndicator {
    private CalendarDate date=null;
    private int color=0;

    private String cliente = "Angel";

    @Override
    public int getColor() {
        return color;
    }

    @NotNull
    @Override
    public CalendarDate getDate() {
        return date;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Evento(CalendarDate date, int color){
        this.color = color;
        this.date = date;
    }
}
