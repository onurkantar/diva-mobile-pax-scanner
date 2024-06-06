package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import android.os.Bundle;

import com.pax.dal.IDAL;
import com.pax.neptunelite.api.NeptuneLiteUser;

public class RNDivaMobilePaxScannerModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;
  public static final String NAME = "DivaMobilePaxScanner";

  public RNDivaMobilePaxScannerModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return NAME;
  }

    @ReactMethod
    public void init(final Promise promise) {
      try 
      {
        IDAL idal = NeptuneLiteUser.getInstance().getDal(getApplicationContext());
        idal.getSys().setScanResultMode(1);
        promise.resolve(true);
      } catch (Exception e) {
        e.printStackTrace();
        promise.reject();
      }
    }

    @ReactMethod
    public void finalize(Promise promise) {
      try 
      {
        IDAL idal = NeptuneLiteUser.getInstance().getDal(getApplicationContext());
        idal.getSys().setScanResultMode(0);
        promise.resolve(true);
      } catch (Exception e) {
        e.printStackTrace();
        promise.reject();
      }
    }
}