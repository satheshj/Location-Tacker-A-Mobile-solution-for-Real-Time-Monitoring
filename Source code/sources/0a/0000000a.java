package com.hellotracks.tracking;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.hellotracks.screens.map.C3669c;
import p006a5.C0375b;
import p006a5.C0381f;
import p047d6.C4027f;

/* loaded from: classes2.dex */
public class TrackingAutoStarter extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C0375b.m22356a("boot received");
        C4027f.m12262b();
        if (C0381f.m22291b().m22313G()) {
            C3669c.m13360f0();
        }
    }
}