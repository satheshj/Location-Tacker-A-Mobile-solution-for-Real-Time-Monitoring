package com.hellotracks.tracking;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.util.Log;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.LocationResult;
import p006a5.C0375b;
import p047d6.C4025d;
import p047d6.C4027f;
import p047d6.C4034l;
import p057e6.C4160b;
import p057e6.C4169g;
import p057e6.C4177k;

/* loaded from: classes2.dex */
public class TrackingBroadcastReceiver extends BroadcastReceiver {
    /* renamed from: a */
    private Location m12924a(Intent intent, int i) {
        try {
            if (!LocationResult.hasResult(intent)) {
                return null;
            }
            LocationResult extractResult = LocationResult.extractResult(intent);
            C0375b.m22342o("TrackingBroadcastRec", "location result received: " + extractResult + " sensor: " + i);
            for (Location location : extractResult.getLocations()) {
                C4034l.m12241b().m12237f(location, i);
            }
            return extractResult.getLastLocation();
        } catch (Exception e) {
            C0375b.m22345l("TrackingBroadcastRec", e);
            return null;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        DetectedActivity detectedActivity;
        C4027f.m12262b();
        C4025d.m12264b();
        if (intent != null) {
            Log.i("TrackingBroadcastRec", "received broadcast action: " + intent.getAction());
            if ("smartlocation.LOCATION_UPDATE_FROM_ACTIVITY".equals(intent.getAction())) {
                m12924a(intent, 10);
            } else if ("smartlocation.LOCATION_UPDATE_FROM_SIGNIFICANT_MOVEMENT".equals(intent.getAction())) {
                C4177k.m11749o().m11747q(m12924a(intent, 9));
            } else if ("smartlocation.LOCATION_UPDATE_FROM_POWER_CONNECTION".equals(intent.getAction())) {
                m12924a(intent, 40);
            } else if ("smartlocation.LOCATION_UDATE_FROM_ALWAYS_ON".equals(intent.getAction())) {
                m12924a(intent, 70);
            } else if ("smartlocation.LOCATION_UDATE_FROM_ONE_FIX".equals(intent.getAction())) {
                C4169g.m11762n().m11761o(m12924a(intent, 60));
            } else if ("smartlocation.LOCATION_UPDATE".equals(intent.getAction())) {
                m12924a(intent, 0);
            } else if (!"smartlocation.DETECTED_ACTIVITY".equals(intent.getAction())) {
            } else {
                if (ActivityRecognitionResult.hasResult(intent)) {
                    ActivityRecognitionResult extractResult = ActivityRecognitionResult.extractResult(intent);
                    detectedActivity = extractResult.getMostProbableActivity();
                    C0375b.m22342o("TrackingBroadcastRec", "received most probable activity: " + detectedActivity);
                    if (detectedActivity.getType() == 5 && extractResult.getProbableActivities().size() > 1) {
                        detectedActivity = extractResult.getProbableActivities().get(1);
                        C0375b.m22342o("TrackingBroadcastRec", "switching to second most probable activity: " + detectedActivity);
                    }
                } else {
                    detectedActivity = (DetectedActivity) intent.getParcelableExtra("activity");
                    C0375b.m22342o("TrackingBroadcastRec", "received direct activity: " + detectedActivity);
                }
                if (detectedActivity == null) {
                    return;
                }
                C4160b.m11778m().m11772s(detectedActivity);
            }
        }
    }
}