
package com.coopcycle.pin;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import android.os.Build;
import android.view.WindowManager;
import android.app.Activity;

public class RNPinScreenModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNPinScreenModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNPinScreen";
  }

  @ReactMethod
  public void pin() {
    final Activity activity = getCurrentActivity();
    if (activity != null) {
      activity.runOnUiThread(new Runnable() {
        @Override
        public void run() {
          if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
            activity.setShowWhenLocked(true);
          } else {
            activity.getWindow().addFlags(
              WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD |
                WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
            );
          }
        }
      });
    }
  }

  @ReactMethod
  public void unpin() {
    final Activity activity = getCurrentActivity();
    if (activity != null) {
      activity.runOnUiThread(new Runnable() {
        @Override
        public void run() {
          if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
            activity.setShowWhenLocked(false);
          } else {
            activity.getWindow().clearFlags(
              WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD |
                WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
            );
          }
        }
      });
    }
  }
}
