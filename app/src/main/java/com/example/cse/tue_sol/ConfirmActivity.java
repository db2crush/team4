package com.example.cse.tue_sol;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by erunn on 2017-06-22.
 */

public class ConfirmActivity extends Activity {
    private static String TAG = "phptest_MainActivity";
    private SQLiteHandler db;
    private SessionManager session;
    private SQLiteDatabase sqlDB;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);



    }

    public void selectFlag(View view){
        Fragment fragment;

        if(view == findViewById(R.id.up_ticket)){

            fragment = new TicketFragment();
        }
        else
            fragment = new SeasonTicketFragment();





        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_scene, fragment);
        fragmentTransaction.commit();

    }



}
