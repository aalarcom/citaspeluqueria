package com.example.peluqueria;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

import com.example.peluqueria.com.example.peluqueria.beans.Evento;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import ru.cleverpumpkin.calendar.CalendarDate;


public class Calendar_prueba extends AppCompatActivity {

    CalendarView calender;
    TextView date_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_prueba);

        final ru.cleverpumpkin.calendar.CalendarView calendarView = findViewById(R.id.calendar_view);
        Calendar calendar = Calendar.getInstance();

// Initial date
        calendar.set(2018, Calendar.JUNE, 1);
        CalendarDate initialDate = new CalendarDate(calendar.getTime());

// Minimum available date
        calendar.set(2018, Calendar.MAY, 15);
        CalendarDate minDate = new CalendarDate(calendar.getTime());

// Maximum available date
        calendar.set(2018, Calendar.JULY, 15);
        CalendarDate maxDate = new CalendarDate(calendar.getTime());

// List of preselected dates that will be initially selected
        List<CalendarDate> preselectedDates  = new ArrayList<CalendarDate>();

// The first day of week
        int firstDayOfWeek = java.util.Calendar.MONDAY;

// Set up calendar with all available parameters
        calendarView.setupCalendar(initialDate, minDate, maxDate, ru.cleverpumpkin.calendar.CalendarView.SelectionMode.NON, preselectedDates, firstDayOfWeek, true);

        List<Evento> lista = new ArrayList<Evento>();

        Evento evento = new Evento(new CalendarDate(calendar.getTime()), Color.RED);
        Evento evento2 = new Evento(new CalendarDate(calendar.getTime()), Color.BLUE);
        lista.add(evento);
        lista.add(evento2);

        calendarView.setDatesIndicators(lista);

        calendarView.setOnDateClickListener(new Function1<CalendarDate, Unit>() {
            @Override
            public Unit invoke(CalendarDate date) {

                List<ru.cleverpumpkin.calendar.CalendarView.DateIndicator> eventos = calendarView.getDateIndicators(date);
                System.out.println(((Evento)eventos.get(0)).getCliente());

                return null;
            }
        });

//       calender = (CalendarView)
//                findViewById(R.id.calender);
//        date_view = (TextView)
//                findViewById(R.id.date_view);
//
//        // Add Listener in calendar
//        calender
//                .setOnDateChangeListener(
//                        new CalendarView
//                                .OnDateChangeListener() {
//                            @Override
//
//                            // In this Listener have one method
//                            // and in this method we will
//                            // get the value of DAYS, MONTH, YEARS
//                            public void onSelectedDayChange(
//                                    @NonNull CalendarView view,
//                                    int year,
//                                    int month,
//                                    int dayOfMonth)
//                            {
//
//                                // Store the value of date with
//                                // format in String type Variable
//                                // Add 1 in month because month
//                                // index is start with 0
//                                String Date
//                                        = dayOfMonth + "-"
//                                        + (month + 1) + "-" + year;
//
//                                // set this date in TextView for Display
//                                date_view.setText(Date);
//                            }
//                        });

    }
}
