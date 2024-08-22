package com.divamobilepaxscanner;

import com.facebook.react.bridge.Callback;
import androidx.annotation.NonNull;
import javax.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Build;
import android.util.Log;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import android.os.Bundle;

import com.pax.dal.IDAL;
import com.pax.neptunelite.api.NeptuneLiteUser;

public class DivaMobilePaxScannerModule extends ReactContextBaseJavaModule {

  public static final String NAME = "DivaMobilePaxScanner";
  private static ReactApplicationContext reactContext;

  public DivaMobilePaxScannerModule(ReactApplicationContext reactContext) {
    super(reactContext);
    DivaMobilePaxScannerModule.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return NAME;
  }

  protected static void sendEvent(String eventName, @Nullable WritableMap params) {
      DivaMobilePaxScannerModule.reactContext
              ?.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
              .emit(eventName, params);
    }

  @ReactMethod
  public void init(final Promise promise) {
    try 
    {
      IDAL idal = NeptuneLiteUser.getInstance().getDal(DivaMobilePaxScannerModule.reactContext);
      idal.getSys().setScanResultMode(1);
      promise.resolve(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @ReactMethod
  public void finalize(Promise promise) {
    try 
    {
      IDAL idal = NeptuneLiteUser.getInstance().getDal(DivaMobilePaxScannerModule.reactContext);
      promise.resolve(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
