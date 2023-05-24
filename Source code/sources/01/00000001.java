package com.hellotracks;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import androidx.room.C2425g0;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hellotracks.comm.gcm.util.C3599a;
import com.hellotracks.controllers.SharedPreferences$OnSharedPreferenceChangeListenerC3612c;
import com.hellotracks.p039db.AppDatabase;
import com.hellotracks.tracking.TrackingBroadcastReceiver;
import java.util.List;
import net.gotev.uploadservice.C5680f;
import net.gotev.uploadservice.C5687j;
import net.gotev.uploadservice.UploadService;
import p006a5.C0374a;
import p006a5.C0375b;
import p006a5.C0378d;
import p047d6.C4023b;
import p047d6.C4024c;
import p047d6.C4025d;
import p047d6.C4027f;
import p067f6.C4247b;
import p069f8.C4306h;
import p076g5.C4469a;
import p077g6.C4471a;
import p077g6.C4489j;
import p077g6.C4490k;
import p086h5.C4655j;
import p087h6.C4695i;
import p096i5.C4825c;
import p096i5.C4827e;

/* loaded from: classes2.dex */
public class App extends Application implements C4490k.AbstractC4492b {

    /* renamed from: q */
    private static volatile App f9733q = null;

    /* renamed from: r */
    private static FirebaseAnalytics f9734r = null;

    /* renamed from: s */
    private static int f9735s = -1;

    /* renamed from: t */
    private static String f9736t;

    /* renamed from: u */
    private static String f9737u;

    /* renamed from: n */
    private AppDatabase f9738n;

    /* renamed from: o */
    private C4489j f9739o;

    /* renamed from: p */
    private C4471a f9740p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.hellotracks.App$a */
    /* loaded from: classes2.dex */
    public class C3598a extends C5687j {
        C3598a() {
        }

        @Override // net.gotev.uploadservice.C5687j, p069f8.AbstractC4310j
        /* renamed from: c */
        public void mo7379c(Context context, C5680f c5680f, C4306h c4306h) {
            C0375b.m22356a("received completed file upload id=" + c5680f.m7403g());
        }
    }

    /* renamed from: b */
    private void m13904b() {
        int m13900g = m13900g();
        int i = C0378d.m22324b().getInt("current_app_version", -1);
        C0375b.m22356a("saved app version: " + i + " real app version: " + m13900g);
        if (m13900g > i) {
            C0375b.m22356a("starting migration");
            if (i < 127) {
                C0375b.m22356a("migration: invalidate current token");
                C3599a.m13880b().m13875g(C3599a.EnumC3600a.INVALIDATE_CURRENT_TOKEN);
            }
            C0378d.m22324b().edit().putInt("current_app_version", m13900g).apply();
        }
    }

    /* renamed from: c */
    public static AppDatabase m13903c() {
        return f9733q.f9738n;
    }

    /* renamed from: d */
    public static String m13902d() {
        return "api.hellotracks.com";
    }

    /* renamed from: f */
    public static App m13901f() {
        return f9733q;
    }

    /* renamed from: g */
    public static int m13900g() {
        if (f9735s < 0) {
            try {
                f9735s = m13901f().getPackageManager().getPackageInfo(m13901f().getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException e) {
                C0375b.m22344m(e);
                return 0;
            }
        }
        return f9735s;
    }

    /* renamed from: h */
    public static String m13899h() {
        if (f9736t == null) {
            try {
                f9736t = m13901f().getPackageManager().getPackageInfo(m13901f().getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                C0375b.m22344m(e);
                return "";
            }
        }
        return f9736t;
    }

    /* renamed from: i */
    public static String m13898i() {
        if (f9737u == null) {
            try {
                f9737u = m13901f().getPackageManager().getInstallerPackageName(m13901f().getPackageName());
                C0375b.m22343n("installer=" + f9737u);
                if (f9737u == null) {
                    f9737u = "";
                }
            } catch (Exception e) {
                C0375b.m22344m(e);
            }
        }
        return f9737u;
    }

    /* renamed from: j */
    public static FirebaseAnalytics m13897j() {
        return f9734r;
    }

    /* renamed from: k */
    public static String m13896k(String str) {
        return "https://" + m13902d() + ("/" + str + "/");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public static /* synthetic */ void m13894m() {
        C4247b[] m9846l = C4825c.m9852f().m9846l(100000, C4247b.EnumC4248a.QUEUED, null);
        if (m9846l.length > 0) {
            C4825c.m9852f().m9843o(null, C4247b.EnumC4248a.NEW, m9846l);
        }
    }

    /* renamed from: n */
    private void m13893n() {
        C0375b.m22356a("app prepare");
        this.f9738n = (AppDatabase) C2425g0.m15531a(getApplicationContext(), AppDatabase.class, "hellotracks-db").m15503b(C4827e.m9841a()).m15500e().m15501d();
        m13904b();
        f9734r = FirebaseAnalytics.getInstance(this);
        C0375b.m22340q();
        C3599a.m13880b().m13876f();
        C4490k.m11026b(this);
        C4490k.m11023e(this);
        C4695i.m10393g(C0374a.f1245n);
        UploadService.f15237x = "com.hellotracks";
        new C3598a().m7377e(this);
        C4655j.m10467g();
    }

    /* renamed from: o */
    public static C4471a m13892o() {
        return f9733q.f9740p;
    }

    /* renamed from: p */
    public static String m13891p() {
        return "wss://ws.hellotracks.com";
    }

    @Override // p077g6.C4490k.AbstractC4492b
    /* renamed from: e */
    public void mo2356e(boolean z) {
        C4027f.m12262b();
        if (z) {
            C3599a.m13880b().m13881a();
            C4025d.m12264b();
        }
    }

    /* renamed from: l */
    public boolean m13895l() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        String packageName = getPackageName();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.equals(packageName)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.app.Application
    public void onCreate() {
        f9733q = this;
        super.onCreate();
        m13893n();
        C4469a.m11109b(this);
        TrackingBroadcastReceiver trackingBroadcastReceiver = new TrackingBroadcastReceiver();
        registerReceiver(trackingBroadcastReceiver, new IntentFilter("smartlocation.DETECTED_ACTIVITY"));
        registerReceiver(trackingBroadcastReceiver, new IntentFilter("smartlocation.LOCATION_UPDATE"));
        registerReceiver(trackingBroadcastReceiver, new IntentFilter("smartlocation.LOCATION_UDATE_FROM_ONE_FIX"));
        registerReceiver(trackingBroadcastReceiver, new IntentFilter("smartlocation.LOCATION_UPDATE_FROM_ACTIVITY"));
        registerReceiver(trackingBroadcastReceiver, new IntentFilter("smartlocation.LOCATION_UPDATE_FROM_POWER_CONNECTION"));
        registerReceiver(trackingBroadcastReceiver, new IntentFilter("smartlocation.LOCATION_UPDATE_FROM_SIGNIFICANT_MOVEMENT"));
        registerReceiver(trackingBroadcastReceiver, new IntentFilter("smartlocation.LOCATION_UDATE_FROM_ALWAYS_ON"));
        C4024c c4024c = new C4024c();
        registerReceiver(c4024c, new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED"));
        registerReceiver(c4024c, new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED"));
        registerReceiver(new C4023b(), new IntentFilter("android.location.PROVIDERS_CHANGED"));
        C0375b.m22356a("app create");
        this.f9739o = new C4489j(this);
        this.f9740p = new C4471a();
        SharedPreferences$OnSharedPreferenceChangeListenerC3612c.m13839a().m13836d();
    }
}