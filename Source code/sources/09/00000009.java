package com.hellotracks.tracking;

import android.content.Context;
import android.util.Log;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.hellotracks.controllers.PeriodicController;
import p006a5.C0378d;
import p006a5.C0381f;
import p047d6.C4026e;
import p047d6.C4027f;
import p047d6.C4031j;
import p087h6.C4699l;

/* loaded from: classes2.dex */
public class SendGpsWorker extends Worker {
    public SendGpsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public static /* synthetic */ void m12925s() {
        PeriodicController.m13872e().m13869k(PeriodicController.EnumC3604d.SEND_GPS);
    }

    @Override // androidx.work.Worker
    /* renamed from: q */
    public ListenableWorker.AbstractC2641a mo12927q() {
        if (!C0381f.m22291b().m22313G()) {
            Log.w("SendGpsWorker", "preventing because logged out");
            return ListenableWorker.AbstractC2641a.m14945a();
        }
        Log.d("SendGpsWorker", "doWork");
        C4027f.m12262b();
        if (C0378d.m22324b().getBoolean("inbox_next_as_api_call", false)) {
            C4031j.m12245m();
        } else {
            C4031j.m12246l();
        }
        C4699l.m10386e(C4026e.f11587n);
        return ListenableWorker.AbstractC2641a.m14943c();
    }
}