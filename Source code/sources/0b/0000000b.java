package com.hellotracks.tracking;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.IBinder;
import android.preference.PreferenceManager;
import com.hellotracks.tracking.TrackingService;
import p006a5.C0375b;
import p006a5.C0378d;
import p006a5.C0381f;
import p047d6.C4027f;
import p057e6.AbstractC4167e;
import p057e6.C4160b;
import p057e6.C4164d;
import p057e6.C4169g;
import p057e6.C4173i;
import p057e6.C4177k;
import p076g5.C4469a;
import p077g6.C4512y;

/* loaded from: classes2.dex */
public class TrackingService extends Service {

    /* renamed from: r */
    private static boolean f10408r = false;

    /* renamed from: o */
    private PendingIntent f10410o;

    /* renamed from: p */
    private SharedPreferences f10411p;

    /* renamed from: n */
    private final IBinder f10409n = new BinderC3805a();

    /* renamed from: q */
    private final SharedPreferences.OnSharedPreferenceChangeListener f10412q = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: d6.m
        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            TrackingService.this.m12920d(sharedPreferences, str);
        }
    };

    /* renamed from: com.hellotracks.tracking.TrackingService$a */
    /* loaded from: classes2.dex */
    public class BinderC3805a extends Binder {
        public BinderC3805a() {
        }
    }

    /* renamed from: b */
    private void m12922b(boolean z) {
        for (AbstractC4167e abstractC4167e : m12921c()) {
            try {
                abstractC4167e.m11769b(z);
            } catch (Exception e) {
                C0375b.m22345l("TrackingService", e);
            }
        }
        C4469a.m11102i();
    }

    /* renamed from: c */
    public static AbstractC4167e[] m12921c() {
        AbstractC4167e[] abstractC4167eArr = {C4160b.m11778m(), C4177k.m11749o(), C4173i.m11757n(), C4169g.m11762n(), C4164d.m11771m()};
        f10408r = true;
        return abstractC4167eArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m12920d(SharedPreferences sharedPreferences, String str) {
        if ("statusOnOff".equals(str) || "mode".equals(str) || "working_hours_eval_ts".equals(str) || "battery_save".equals(str) || "turn_off_gps_while_stationary".equals(str) || "turn_off_track_recording".equals(str) || C0378d.EnumC0379a.m22320a(str) || "power_connection_location_manager".equals(str)) {
            m12919e("pref-change: " + str);
        }
    }

    /* renamed from: e */
    private void m12919e(String str) {
        C0375b.m22342o("TrackingService", "ensure tracking reason: " + str);
        boolean m22304P = C0381f.m22291b().m22304P();
        PendingIntent pendingIntent = this.f10410o;
        if (pendingIntent == null && m22304P) {
            m12916h();
            m12918f(300);
        } else if (pendingIntent != null && !m22304P) {
            m12916h();
        }
        if (m22304P && C0381f.m22291b().m22313G() && !C0381f.m22291b().m22310J()) {
            m12917g();
        } else {
            m12915i();
        }
        ((NotificationManager) getSystemService("notification")).notify(100, C4469a.m11108c());
    }

    /* renamed from: f */
    private void m12918f(int i) {
        C0375b.m22342o("TrackingService", "starting always send - send broadcast event in " + i + " seconds");
        this.f10410o = C4512y.m10943G(TrackingBroadcastReceiver.class, "com.hellotracks.send", i);
    }

    /* renamed from: g */
    private void m12917g() {
        if (!C4512y.m10924r()) {
            C0375b.m22352e("TrackingService", "start tracking prevented because no permission");
        } else if (!C4512y.m10920v()) {
            C0375b.m22352e("TrackingService", "start tracking prevented because no provider available");
        } else {
            m12922b(true);
        }
    }

    /* renamed from: h */
    private void m12916h() {
        C0375b.m22342o("TrackingService", "stopping sendAlwaysIntent");
        C4512y.m10941a(this.f10410o);
        this.f10410o = null;
    }

    /* renamed from: i */
    private void m12915i() {
        C0375b.m22342o("TrackingService", "stop tracking");
        m12922b(false);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f10409n;
    }

    @Override // android.app.Service
    public void onCreate() {
        C0375b.m22342o("TrackingService", "creating track service");
        super.onCreate();
        if (C4027f.m12261c()) {
            startForeground(100, C4469a.m11108c());
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        this.f10411p = defaultSharedPreferences;
        defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this.f10412q);
        m12919e("creating service");
    }

    @Override // android.app.Service
    public void onDestroy() {
        C0375b.m22342o("TrackingService", "destroying track service");
        m12915i();
        if (C0381f.m22291b().m22305O()) {
            m12916h();
        } else {
            C0375b.m22342o("TrackingService", "try to restart in 30 seconds");
            C4512y.m10944F(TrackingBroadcastReceiver.class, "com.hellotracks.send", 30);
        }
        this.f10411p.unregisterOnSharedPreferenceChangeListener(this.f10412q);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        m12919e("onStartCommand");
        return 1;
    }
}