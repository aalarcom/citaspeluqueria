package com.example.peluqueria.com.example.peluqueria.conectors;

import android.os.AsyncTask;

import com.example.peluqueria.com.example.peluqueria.interfaces.OnTaskCompleted;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ReservaConnection extends AsyncTask {

    private String username;
    private String password;
    private String fecha;
    private String hora;
    private String servicio;
    private String fullname;
    private OnTaskCompleted listener;

    public ReservaConnection(String fecha, String hora, String servicio, OnTaskCompleted listener){

        this.fecha=fecha;
        this.hora=hora;
        this.servicio=servicio;
        //this.fullname=fullname;

        this.listener=listener;
    }
    public ReservaConnection(String fecha, String hora, String servicio){

        this.fecha=fecha;
        this.hora=hora;
        this.servicio=servicio;
    }



    @Override
    protected Object doInBackground(Object[] objects) {
        try{
            String url="http://10.164.200.208:8080/APP/webresources/pruebacheck";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "text/plain");
            con.setRequestProperty("fecha", this.fecha);
            con.setRequestProperty("hora", this.hora);
            con.setRequestProperty("servicio", this.servicio);
            //con.setRequestProperty("fullname", this.fullname);

            String urlParameters = fecha + "," + hora + "," + servicio;

            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Post parameters : " + urlParameters);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream())); //recibimos datos esperando respuesta
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println(response);

            return response;

        } catch (IOException e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(Object objects){

        //listener.onTaskCompleted(((StringBuffer)objects).toString());

    }
}
