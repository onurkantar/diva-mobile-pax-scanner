package com.reactlibrary;


import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;

import javax.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.facebook.react.modules.core.DeviceEventManagerModule;

public class RNDivaMobilePaxScannerReceiver extends BroadcastReceiver {
    
    private static final String BARCODE_READ_SUCCESS = "barcodeReadSuccess";
    private static final String BARCODE_READ_FAIL = "barcodeReadFail";

    private ReactApplicationContext reactApplicationContext;

    public RNDivaMobilePaxScannerReceiver(ReactApplicationContext reactApplicationContext) {
        this.reactApplicationContext = reactApplicationContext;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        
        try{
            //Log.d("Barcode BroadCast", intent.getAction() + " " + intent.getStringExtra("BARCODE") + " " + intent.getStringExtra("CODE_FORMAT"));
            WritableMap params = Arguments.createMap();
            params.putString("data", intent.getStringExtra("BARCODE"));
            RNDivaMobilePaxScannerModule.sendEvent(BARCODE_READ_SUCCESS, params);
        }

        catch(Exception e){
            WritableMap params = Arguments.createMap();
            params.putString("error", e.getMessage());
            RNDivaMobilePaxScannerModule.sendEvent(BARCODE_READ_FAIL, params);
        }
    }
}