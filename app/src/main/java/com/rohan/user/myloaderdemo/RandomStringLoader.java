package com.rohan.user.myloaderdemo;

import android.content.Context;
import android.content.AsyncTaskLoader;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by User on 11/11/2016.
 */

public class RandomStringLoader extends AsyncTaskLoader<ArrayList<String>> {

    public RandomStringLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
        super.onStartLoading();
    }

    @Override
    public ArrayList<String> loadInBackground() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<String> array = new ArrayList<>();
        char[] chars = "dufgarhgeaslhbaohlfsfvbgaslhsvad".toCharArray();
        Random random = new Random();
        for(int i=0 ; i<10 ; i++){
            String ran = "";
            for(int j=0;j<10;j++){
            ran = ran+chars[random.nextInt(chars.length)];
            }
            ran += "\n";
            array.add(ran);
        }
        return array;
    }

    @Override
    public void deliverResult(ArrayList<String> data) {
        if(isStarted()){
            super.deliverResult(data);
        }

    }
}
