package com.divamobilepaxscanner;

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

public class DivaMobilePaxScannerReceiver extends BroadcastReceiver {
    
    private static final String BARCODE_READ_SUCCESS = "barcodeReadSuccess";
    private static final String BARCODE_READ_FAIL = "barcodeReadFail";

    @Override
    public void onReceive(Context context, Intent intent) {
    if (intent == null || context == null) {
        Log.e("BarcodeReceiver", "Intent or context is null");
        return;
    }

    try {
        Log.d("BarcodeReceiver", "Received action: " + intent.getAction());
        Log.d("BarcodeReceiver", "Barcode: " + intent.getStringExtra("BARCODE"));

        WritableMap params = Arguments.createMap();
        params.putString("data", intent.getStringExtra("BARCODE"));

        // Send success event
        DivaMobilePaxScannerModule.sendEvent(BARCODE_READ_SUCCESS, params);
    } catch (Exception e) {
        Log.e("BarcodeReceiver", "Error in onReceive: " + e.getMessage());
        WritableMap params = Arguments.createMap();
        params.putString("error", e.getMessage());
        DivaMobilePaxScannerModule.sendEvent(BARCODE_READ_FAIL, params);
    }
    }
}