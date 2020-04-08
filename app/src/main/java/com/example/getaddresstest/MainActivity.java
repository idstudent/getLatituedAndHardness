package com.example.getaddresstest;

import android.Manifest;
import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationManager;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    Geocoder mCoder;
    private List<Address> addr = new ArrayList<>();
    private ArrayList<Address> addrList = new ArrayList();
    private ArrayList<String> testAddrList = new ArrayList();


    private Address lating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        mCoder= new Geocoder(this);

        testAddrList.add("경기도 수원시 팔달구 교동 130-4");
        testAddrList.add("경기도 수원시 팔달구 교동 매산로 132");

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try{
                    for(int i=0; i<testAddrList.size(); i++) {
                        addr = mCoder.getFromLocationName(testAddrList.get(i), 5);
                        addrList.addAll(addr);
                    }


                    for(int i=0; i<addrList.size() ; i++) {
                        Log.e("tag", "s"+i);
                        lating = addrList.get(i);

                        double lat = lating.getLatitude();
                        double lon = lating.getLongitude();
                        Log.e("tag", "위도 "+lat + " 경도 "+ lon);
                        Toast.makeText(getApplicationContext(), "위도 "+lat + " 경도 "+ lon, Toast.LENGTH_SHORT).show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
