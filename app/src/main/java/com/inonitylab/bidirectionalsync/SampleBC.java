package com.inonitylab.bidirectionalsync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.BaseJsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by ruhul on 12/28/16.
 */

public class SampleBC extends BroadcastReceiver {
    static int noOfTimes = 0;

    // Method gets called when Broad Case is issued from MainActivity for every 10 seconds
    @Override
    public void onReceive(final Context context, Intent intent) {
        // TODO Auto-generated method stub
        noOfTimes++;
        Toast.makeText(context, "BC Service Running for " + noOfTimes + " times", Toast.LENGTH_SHORT).show();
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        // Checks if new records are inserted in Remote MySQL DB to proceed with Sync operation
        client.post("http://api.inonity.com/BiDirectionalSync/getdbrowcount.php",params ,new BaseJsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, String rawJsonResponse, Object response) {
                Log.d("Sample BC on receive"," response ......................... "+rawJsonResponse);
                try {
                    // Create JSON object out of the response sent by getdbrowcount.php
                    JSONObject obj = new JSONObject(rawJsonResponse);
                    System.out.println(obj.get("count"));
                    // If the count value is not zero, call MyService to display notification
                    if(obj.getInt("count") != 0){
                        final Intent intnt = new Intent(context, MyService.class);
                        // Set unsynced count in intent data
                        intnt.putExtra("intntdata", "Unsynced Rows Count "+obj.getInt("count"));
                        // Call MyService
                        context.startService(intnt);
                    }else{
                        Toast.makeText(context, "Sync not needed", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, String rawJsonData, Object errorResponse) {

                // TODO Auto-generated method stub
                if(statusCode == 404){
                    Toast.makeText(context, "404", Toast.LENGTH_SHORT).show();
                }else if(statusCode == 500){
                    Toast.makeText(context, "500", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "Error occured!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            protected Object parseResponse(String rawJsonData, boolean isFailure) throws Throwable {
                return null;
            }

        });
    }
}