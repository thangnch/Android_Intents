package com.example.myapplication;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

public class ReceiveCall extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        TelephonyManager tm =  (TelephonyManager) context.getSystemService(Service.TELEPHONY_SERVICE);

        switch (tm.getCallState()) {

            case TelephonyManager.CALL_STATE_RINGING:


                String incoming_number = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);

                Log.i("OK", "RINGING :" + incoming_number);

                break;

        }
    }
}
