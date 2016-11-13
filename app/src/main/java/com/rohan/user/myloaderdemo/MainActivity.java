package com.rohan.user.myloaderdemo;


import android.app.LoaderManager;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<String>> {
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) findViewById(R.id.textView);

        getLoaderManager().initLoader(0, null, this);
    }


    @Override
    public Loader<ArrayList<String>> onCreateLoader(int id, Bundle args) {
        RandomStringLoader loader = new RandomStringLoader(this);
        return loader;

    }

    @Override
    public void onLoadFinished(Loader<ArrayList<String>> loader, ArrayList<String> data) {
        txt.setText("");
        for(String text: data){
            txt.setText(txt.getText()+text);
        }


    }

    @Override
    public void onLoaderReset(Loader<ArrayList<String>> loader) {

    }
}