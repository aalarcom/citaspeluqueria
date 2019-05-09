package com.example.peluqueria.com.example.peluqueria.conectors;

import android.os.AsyncTask;

import com.example.peluqueria.com.example.peluqueria.interfaces.OnTaskCompleted;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RegisterConection  extends AsyncTask {

    private String username;
    private String password;
    private OnTaskCompleted listener;

    public RegisterConection(String username, String password, OnTaskCompleted listener){

        this.username=username;
        this.password=password;
        this.listener=listener;
    }
    public RegisterConection(String username, String password){

        this.username=username;
        this.password=password;
    }



    @Override
    protected Object doInBackground(Object[] objects) {
        try{
            String url="http://10.164.200.208:8080/APP/webresources/register";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "text/plain");
            con.setRequestProperty("username", this.username);
            con.setRequestProperty("password", this.password);

            String urlParameters = username + "," + password;

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
                    new InputStreamReader(con.getInputStream()));
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
