package com.reactlibrary;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class RNDivaMobilePaxScannerReceiver extends BroadcastReceiver {
    
    private static final String BARCODE_READ_SUCCESS = "barcodeReadSuccess";
    private static final String BARCODE_READ_FAIL = "barcodeReadFail";

    /**
     * Send event to javascript
     * @param eventName Name of the event
     * @param params Additional params
     */
    private void sendEvent(String eventName, @Nullable WritableMap params) {
        if (mReactContext.hasActiveCatalystInstance()) {
            if (D) Log.d(NAME, "Sending event: " + eventName);
            mReactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);
        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        
        try{
            //Log.d("Barcode BroadCast", intent.getAction() + " " + intent.getStringExtra("BARCODE") + " " + intent.getStringExtra("CODE_FORMAT"));
            
            WritableMap params = Arguments.createMap();
            params.putString("data", intent.getStringExtra("BARCODE"));
            sendEvent(BARCODE_READ_SUCCESS, params);
        }

        catch(Exception e){
            WritableMap params = Arguments.createMap();
            params.putString("error", e.getMessage());
            sendEvent(BARCODE_READ_FAIL, params);
        }
    }
}