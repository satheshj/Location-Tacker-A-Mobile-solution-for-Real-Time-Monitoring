package com.hellotracks.geofence;

import android.app.IntentService;
import android.content.Intent;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;
import com.hellotracks.controllers.C3606a;
import java.util.List;
import p006a5.C0375b;
import p006a5.C0381f;
import p047d6.C4027f;
import p057e6.C4177k;
import p087h6.C4699l;
import p116k5.C5089j;
import p116k5.C5090k;
import p116k5.C5091l;

/* loaded from: classes2.dex */
public class ReceiveTransitionsIntentService extends IntentService {
    public ReceiveTransitionsIntentService() {
        super("ReceiveTransitionsIntentService");
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        C0375b.m22342o("ReceiveTransitions", "handle transition");
        C4027f.m12262b();
        C4699l.m10386e(C5089j.f14032n);
        if (C0381f.m22291b().m22305O()) {
            C0375b.m22332y("ReceiveTransitions", "receiving transition but tracking off");
            return;
        }
        GeofencingEvent fromIntent = GeofencingEvent.fromIntent(intent);
        if (fromIntent == null) {
            C0375b.m22347j("ReceiveTransitions", "geofencingEvent is null");
        } else if (fromIntent.hasError()) {
            int errorCode = fromIntent.getErrorCode();
            C0375b.m22352e("ReceiveTransitions", "handle transition error=" + errorCode);
        } else {
            List<Geofence> triggeringGeofences = fromIntent.getTriggeringGeofences();
            if (triggeringGeofences == null) {
                C0375b.m22352e("ReceiveTransitions", "getTriggeringGeofences is null on receiving transition");
                return;
            }
            int geofenceTransition = fromIntent.getGeofenceTransition();
            C5091l c5091l = new C5091l(getApplicationContext());
            for (Geofence geofence : triggeringGeofences) {
                String requestId = geofence.getRequestId();
                C5090k m8986d = c5091l.m8986d(requestId);
                if (m8986d == null) {
                    C0375b.m22347j("ReceiveTransitions", "fence is null for id " + requestId);
                } else if (m8986d.m8991h() != 3) {
                    C3606a.m13850r().m13842z(m8986d, geofenceTransition, fromIntent.getTriggeringLocation());
                } else if (geofenceTransition == 2) {
                    C4177k.m11749o().m11743u();
                }
            }
        }
    }
}