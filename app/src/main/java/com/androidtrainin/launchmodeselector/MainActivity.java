package com.androidtrainin.launchmodeselector;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.EventListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View view) {
        String currentPackage = "";

        switch (view.getId()){
            case R.id.btnStandard:
                currentPackage = "com.androidtrainin.standardlaunchmode";
                break;
            case R.id.btnSingleTop:
                currentPackage = "com.androidtrainin.singletoplaunchmode";
                break;
            case R.id.btnSingleTask:
                currentPackage = "com.androidtrainin.singletasklaunchmode";
                break;
            case R.id.btnSingleInstance:
                currentPackage = "com.androidtrainin.singleinstancelaunchmode";
                break;
            case R.id.btnIntentFlags:
                currentPackage = "com.androidtrainin.intentflagslaunchmode";
                break;
        }

        Intent launchIntent = getPackageManager().getLaunchIntentForPackage(currentPackage);
        if (launchIntent != null) {
            startActivity(launchIntent);//null pointer check in case package name was not found
        }
    }
}
