package com.example.berat.whatstalk;

import android.app.Application;

import com.onesignal.OneSignal;

public class ApplicationClass extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // TODO: Add OneSignal initialization here
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();
    }
}