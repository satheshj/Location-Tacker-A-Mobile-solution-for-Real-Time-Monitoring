package com.hellotracks.screens.map;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import cn.pedant.SweetAlert.SweetAlertDialog;
import com.bumptech.glide.load.Key;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hellotracks.App;
import com.hellotracks.R;
import com.hellotracks.controllers.SharedPreferences$OnSharedPreferenceChangeListenerC3612c;
import com.hellotracks.screens.group.C3657c;
import com.hellotracks.screens.intro.IntroScreen;
import com.hellotracks.screens.map.C3669c;
import com.hellotracks.screens.places.PlacesScreen;
import com.hellotracks.screens.settings.SettingsActivity;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p006a5.C0375b;
import p006a5.C0378d;
import p006a5.C0381f;
import p020b5.C2752j;
import p020b5.C2767s;
import p021b6.C2795i;
import p030c5.C2927f;
import p046d5.EnumC4009a;
import p047d6.C4034l;
import p056e5.EnumC4158d;
import p076g5.C4469a;
import p077g6.C4488i;
import p077g6.C4502q;
import p077g6.C4503r;
import p077g6.C4512y;
import p077g6.EnumC4478d;
import p087h6.AbstractRunnableC4697j;
import p087h6.C4695i;
import p087h6.C4699l;
import p107j6.C4925i;
import p116k5.C5083f;
import p116k5.C5090k;
import p116k5.C5091l;
import p136m5.AbstractActivityC5510b;
import p176q5.C6494b;
import p196s5.C7046k1;
import p196s5.C7068s;
import p196s5.DialogInterface$OnClickListenerC7062q;

/* renamed from: com.hellotracks.screens.map.c */
/* loaded from: classes2.dex */
public class C3669c {

    /* renamed from: com.hellotracks.screens.map.c$a */
    /* loaded from: classes2.dex */
    class C3670a extends C2767s {

        /* renamed from: e */
        final /* synthetic */ SweetAlertDialog f9997e;

        /* renamed from: f */
        final /* synthetic */ Context f9998f;

        /* renamed from: g */
        final /* synthetic */ Runnable f9999g;

        C3670a(SweetAlertDialog sweetAlertDialog, Context context, Runnable runnable) {
            this.f9997e = sweetAlertDialog;
            this.f9998f = context;
            this.f9999g = runnable;
        }

        @Override // p020b5.C2767s
        /* renamed from: a */
        public void mo692a() {
            this.f9997e.dismissWithAnimation();
        }

        @Override // p020b5.C2767s
        /* renamed from: b */
        public void mo691b(int i) {
            this.f9997e.dismissWithAnimation();
        }

        @Override // p020b5.C2767s
        /* renamed from: c */
        public void mo690c(String str) {
            this.f9997e.setContentText(this.f9998f.getString(R.string.Created));
            this.f9997e.changeAlertType(2);
            Handler handler = new Handler();
            final SweetAlertDialog sweetAlertDialog = this.f9997e;
            handler.postDelayed(new Runnable() { // from class: com.hellotracks.screens.map.b
                @Override // java.lang.Runnable
                public final void run() {
                    SweetAlertDialog.this.dismissWithAnimation();
                }
            }, 1500L);
            this.f9999g.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.hellotracks.screens.map.c$b */
    /* loaded from: classes2.dex */
    public class C3671b extends C2767s {

        /* renamed from: e */
        final /* synthetic */ String f10000e;

        /* renamed from: f */
        final /* synthetic */ HomeMapScreen f10001f;

        C3671b(String str, HomeMapScreen homeMapScreen) {
            this.f10000e = str;
            this.f10001f = homeMapScreen;
        }

        @Override // p020b5.C2767s
        /* renamed from: c */
        public void mo690c(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.has("gpxurl")) {
                    return;
                }
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.TEXT", this.f10000e + "\n\n" + this.f10001f.getString(R.string.GpxRoute) + ": " + jSONObject.getString("gpxurl"));
                HomeMapScreen homeMapScreen = this.f10001f;
                homeMapScreen.startActivity(Intent.createChooser(intent, homeMapScreen.getResources().getString(R.string.MissingShare)));
            } catch (JSONException e) {
                C0375b.m22345l("gpx response corrupt:" + str, e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.hellotracks.screens.map.c$c */
    /* loaded from: classes2.dex */
    public class C3672c extends C2767s {

        /* renamed from: e */
        final /* synthetic */ AbstractActivityC5510b f10002e;

        C3672c(AbstractActivityC5510b abstractActivityC5510b) {
            this.f10002e = abstractActivityC5510b;
        }

        @Override // p020b5.C2767s
        /* renamed from: b */
        public void mo691b(int i) {
            if (this.f10002e.m7809W()) {
                C4925i.m9698E(this.f10002e, R.string.PasswordRecovery, R.string.PasswordRecoveryNoUserFound, 3);
            }
        }

        @Override // p020b5.C2767s
        /* renamed from: e */
        public void mo5082e(JSONObject jSONObject) {
            if (this.f10002e.m7809W()) {
                String string = this.f10002e.getString(R.string.PasswordRecoveryResult, new Object[]{((String) C4488i.m11042b(jSONObject, Scopes.EMAIL, "")) + " " + ((String) C4488i.m11042b(jSONObject, "phone", ""))});
                AbstractActivityC5510b abstractActivityC5510b = this.f10002e;
                C4925i.m9699D(abstractActivityC5510b, abstractActivityC5510b.getString(R.string.PasswordRecovery), string, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.hellotracks.screens.map.c$d */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C3673d {

        /* renamed from: a */
        static final /* synthetic */ int[] f10003a;

        static {
            int[] iArr = new int[C0381f.EnumC0386e.values().length];
            f10003a = iArr;
            try {
                iArr[C0381f.EnumC0386e.BICYCLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10003a[C0381f.EnumC0386e.PEDESTRIAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* renamed from: A */
    public static void m13397A(String str, C2767s c2767s, boolean z, String... strArr) {
        try {
            JSONObject m14656L = C2752j.m14656L();
            m14656L.put("msg", str);
            if (strArr.length == 1) {
                m14656L.put("receiver", strArr[0]);
            } else {
                JSONArray jSONArray = new JSONArray();
                for (String str2 : strArr) {
                    jSONArray.put(str2);
                }
                m14656L.put("receivers", jSONArray);
            }
            if (z) {
                C2752j.m14637z("sendmsg", m14656L, c2767s);
            } else {
                C2752j.m14641v("sendmsg", m14656L, c2767s);
            }
        } catch (Exception e) {
            C0375b.m22334w(e);
        }
    }

    /* renamed from: B */
    public static void m13396B(String str, C2767s c2767s, String... strArr) {
        m13397A(str, c2767s, true, strArr);
    }

    /* renamed from: C */
    public static void m13395C(long j, String str) {
        EnumC4478d.m11082g("gpx");
        try {
            HomeMapScreen m13838b = SharedPreferences$OnSharedPreferenceChangeListenerC3612c.m13839a().m13838b();
            JSONObject m14656L = C2752j.m14656L();
            m14656L.put("track", j);
            m14656L.put("gpx", true);
            C2752j.m14641v("edittrack", m14656L, new C3671b(str, m13838b));
        } catch (Exception e) {
            C0375b.m22349h(e);
        }
    }

    /* renamed from: D */
    public static void m13394D(C2795i c2795i) {
        m13395C(c2795i.f9011a, c2795i.m14552d() + "\n\n" + c2795i.m14555a());
    }

    /* renamed from: E */
    public static void m13393E(Activity activity, String str) {
        EnumC4478d.share.m11087b("invite_code");
        String string = activity.getString(R.string.ShareInviteCodeShareText, new Object[]{str, C3657c.m13620b(str)});
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", string);
        intent.setType("text/plain");
        activity.startActivity(Intent.createChooser(intent, activity.getString(R.string.ShareInviteCode)));
    }

    /* renamed from: F */
    public static void m13392F(Activity activity, String str, double d, double d2) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", str + " " + ("https://www.google.com/maps/place/" + (d + "," + d2)));
            intent.setType("text/plain");
            activity.startActivity(intent);
        } catch (Exception e) {
            C0375b.m22344m(e);
        }
    }

    /* renamed from: G */
    public static void m13391G(final Activity activity) {
        final String[] strArr = {activity.getString(R.string.ShareValidFor2Hours), activity.getString(R.string.ShareValidForToday), activity.getString(R.string.ShareValidForever)};
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(R.string.ShareLocationAsURL).setItems(strArr, new DialogInterface.OnClickListener() { // from class: s5.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                C3669c.m13381Q(activity, strArr, dialogInterface, i);
            }
        });
        AlertDialog create = builder.setCancelable(true).create();
        create.setCanceledOnTouchOutside(true);
        create.show();
    }

    /* renamed from: H */
    public static void m13390H(HomeMapScreen homeMapScreen) {
        homeMapScreen.m13602A1();
        IntroScreen.m13610j0(homeMapScreen);
    }

    /* renamed from: I */
    public static void m13389I(Activity activity, boolean z) {
        Intent intent = new Intent(activity, PlacesScreen.class);
        intent.putExtra("openAsAddPlace", z);
        activity.startActivityForResult(intent, 200);
    }

    /* renamed from: J */
    public static void m13388J(AbstractActivityC3663a abstractActivityC3663a, String str, String str2) {
        C7046k1 m13404v0 = abstractActivityC3663a.m13404v0(C4512y.m10931k(str));
        if (m13404v0 != null) {
            abstractActivityC3663a.mo13427T0(m13404v0.f18554i, true);
        }
    }

    /* renamed from: K */
    public static void m13387K(Activity activity, String str) {
        Intent intent = new Intent(activity, SettingsActivity.class);
        intent.putExtra("filter", str);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L */
    public static /* synthetic */ void m13386L(Activity activity, String[] strArr, DialogInterface dialogInterface, int i) {
        if (i == 0) {
            m13354i0(activity);
        } else if (i == strArr.length - 1) {
            C0381f.m22291b().m22284e0("");
            m13358g0();
        } else {
            C0381f.m22291b().m22284e0(strArr[i]);
            m13358g0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M */
    public static /* synthetic */ void m13385M(long j, Runnable runnable, DialogInterface dialogInterface, int i) {
        JSONObject m14656L = C2752j.m14656L();
        C4488i.m11031m(m14656L, "track", Long.valueOf(j));
        C4488i.m11031m(m14656L, "deltrack", Boolean.TRUE);
        C2752j.m14641v("edittrack", m14656L, new C2767s(runnable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public static /* synthetic */ void m13384N(CheckBox checkBox, double d, double d2, Activity activity, DialogInterface dialogInterface, int i) {
        if (checkBox.isChecked()) {
            C0378d.m22324b().edit().putInt("navigation.preferred", i).apply();
        }
        m13375W(i, d, d2, activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O */
    public static /* synthetic */ void m13383O(long j, long j2, Runnable runnable, Context context, DialogInterface dialogInterface, int i) {
        try {
            JSONObject m14656L = C2752j.m14656L();
            m14656L.put("track1", j);
            m14656L.put("track2", j2);
            C2752j.m14641v("mergetracks", m14656L, new C2767s(runnable));
            Toast.makeText(context, (int) R.string.OK, 0).show();
        } catch (Exception e) {
            C0375b.m22349h(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P */
    public static /* synthetic */ void m13382P(DialogInterface dialogInterface, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q */
    public static /* synthetic */ void m13381Q(Activity activity, String[] strArr, DialogInterface dialogInterface, int i) {
        String str;
        try {
            if (i == 0) {
                long m10980w = C4503r.m10980w() + C4503r.m10983t(2);
                str = C4503r.m11001b(m10980w) + "" + C4503r.m10979x(m10980w);
            } else {
                str = i == 1 ? String.valueOf(C4503r.m11000c()) : "0";
            }
            String m22266s = C0381f.m22291b().m22266s();
            String m22298V = C0381f.m22291b().m22298V(str);
            StringBuilder sb = new StringBuilder();
            sb.append("https://hellotracks.com/live.html");
            sb.append("?usr=");
            sb.append(URLEncoder.encode(m22266s, Key.STRING_CHARSET_NAME));
            sb.append("&pwd=");
            sb.append(URLEncoder.encode(m22298V, Key.STRING_CHARSET_NAME));
            sb.append("&tok=");
            sb.append(URLEncoder.encode(str, Key.STRING_CHARSET_NAME));
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", C0381f.m22291b().m22275j() + "\n" + ((Object) sb));
            intent.setType("text/plain");
            activity.startActivity(intent);
            EnumC4478d.m11083f(FirebaseAnalytics.Event.SHARE, FirebaseAnalytics.Param.LOCATION, strArr[i]);
        } catch (Exception e) {
            C0375b.m22344m(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R */
    public static /* synthetic */ void m13380R(EditText editText, AbstractActivityC5510b abstractActivityC5510b, DialogInterface dialogInterface, int i) {
        String trim = editText.getText().toString().trim();
        if (C4502q.m11003i(trim)) {
            JSONObject jSONObject = new JSONObject();
            C4488i.m11031m(jSONObject, "usr", trim);
            C2752j.m14641v("requestpassword", jSONObject, new C3672c(abstractActivityC5510b));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S */
    public static /* synthetic */ void m13379S(AlertDialog alertDialog, View view, boolean z) {
        if (z) {
            alertDialog.getWindow().setSoftInputMode(5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T */
    public static /* synthetic */ void m13378T(HashSet hashSet) {
        m13362e0((String[]) hashSet.toArray(new String[hashSet.size()]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U */
    public static /* synthetic */ void m13377U() {
        final HashSet hashSet = new HashSet();
        for (C2927f c2927f : App.m13903c().mo13822D().selectAllPersons()) {
            String str = c2927f.uid;
            if (str != null && !str.equals(C0381f.m22291b().m22267r())) {
                hashSet.add(c2927f.uid);
            }
        }
        C0375b.m22356a("sending PANIC with receivers from db: " + hashSet);
        C4699l.m10386e(new AbstractRunnableC4697j() { // from class: s5.j
            @Override // p087h6.AbstractRunnableC4697j, java.lang.Runnable
            public final void run() {
                C3669c.m13378T(hashSet);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V */
    public static /* synthetic */ void m13376V(EditText editText, DialogInterface dialogInterface, int i) {
        String obj = editText.getText().toString();
        LinkedList<String> m22273l = C0381f.m22291b().m22273l();
        LinkedList<String> m22274k = C0381f.m22291b().m22274k();
        if (!m22273l.contains(obj) && !m22274k.contains(obj)) {
            m22273l.addFirst(obj);
            if (m22273l.size() > 5) {
                m22273l.removeLast();
            }
        }
        C0378d.m22324b().edit().putString("recently_used_status_labels", C4502q.m11006f(m22273l)).apply();
        C0381f.m22291b().m22284e0(obj);
        m13358g0();
    }

    /* renamed from: W */
    private static void m13375W(int i, double d, double d2, Activity activity) {
        if (i == 0) {
            String str = "google.navigation:q=" + d + "," + d2;
            int i2 = C3673d.f10003a[C0381f.m22291b().m22268q().ordinal()];
            if (i2 == 1) {
                str = str + "&mode=b";
            } else if (i2 == 2) {
                str = str + "&mode=w";
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setPackage("com.google.android.apps.maps");
            intent.setData(Uri.parse(str));
            if (intent.resolveActivity(activity.getPackageManager()) != null) {
                activity.startActivity(intent);
            } else {
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.android.apps.maps")));
            }
        }
        if (i == 1) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setPackage("com.google.android.apps.maps");
            intent2.setData(Uri.parse("geo:0,0?q=" + d + "," + d2));
            if (intent2.resolveActivity(activity.getPackageManager()) != null) {
                activity.startActivity(intent2);
            } else {
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.android.apps.maps")));
            }
        }
        if (i == 2) {
            Intent intent3 = new Intent("android.intent.action.VIEW", Uri.parse("waze://?ll=" + d + "," + d2 + "&navigate=yes"));
            intent3.setPackage("com.waze");
            if (intent3.resolveActivity(activity.getPackageManager()) != null) {
                activity.startActivity(intent3);
            } else {
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.waze")));
            }
        }
    }

    /* renamed from: X */
    public static void m13374X(Context context, String str, double d, double d2, boolean z, Runnable runnable) {
        try {
            String m22266s = C0381f.m22291b().m22266s();
            JSONObject jSONObject = new JSONObject();
            Locale locale = Locale.getDefault();
            TimeZone timeZone = TimeZone.getDefault();
            jSONObject.put("language", locale.getLanguage());
            jSONObject.put("country", locale.getCountry());
            jSONObject.put("timezone", timeZone.getID());
            jSONObject.put("accounttype", "place");
            jSONObject.put(AppMeasurementSdk.ConditionalUserProperty.NAME, str);
            jSONObject.put("owner", m22266s);
            jSONObject.put("extension", 200);
            if (z) {
                jSONObject.put("visibility", "network");
            }
            if (d + d2 != 0.0d) {
                jSONObject.put("latitude", d);
                jSONObject.put("longitude", d2);
            }
            jSONObject.put("notify_checkin", true);
            SweetAlertDialog showCancelButton = new SweetAlertDialog(context, 5).setContentText(context.getString(R.string.JustASecond)).showCancelButton(true);
            showCancelButton.setTitleText(str);
            showCancelButton.show();
            C2752j.m14637z("register", jSONObject, new C3670a(showCancelButton, context, runnable));
        } catch (Exception e) {
            C0375b.m22334w(e);
        }
    }

    /* renamed from: Y */
    public static void m13373Y(final AbstractActivityC5510b abstractActivityC5510b, String str) {
        final EditText editText = new EditText(abstractActivityC5510b);
        editText.setText(str);
        LinearLayout linearLayout = new LinearLayout(abstractActivityC5510b);
        int m9685j = C4925i.m9685j(20.0f, abstractActivityC5510b);
        linearLayout.setPadding(m9685j, m9685j, m9685j, m9685j);
        linearLayout.addView(editText);
        editText.getLayoutParams().width = -1;
        final AlertDialog create = new AlertDialog.Builder(abstractActivityC5510b).setMessage(R.string.EnterEmailToReceivePassword).setView(linearLayout).setPositiveButton(abstractActivityC5510b.getString(R.string.OK), new DialogInterface.OnClickListener() { // from class: s5.p
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                C3669c.m13380R(editText, abstractActivityC5510b, dialogInterface, i);
            }
        }).create();
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: s5.r
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                C3669c.m13379S(create, view, z);
            }
        });
        create.show();
        create.getWindow().getAttributes().gravity = 49;
        create.getWindow().getAttributes().y = C4925i.m9685j(80.0f, App.m13901f());
        create.show();
    }

    /* renamed from: Z */
    public static void m13372Z(EnumC4009a enumC4009a, HashMap<String, String> hashMap) {
        JSONObject m14656L = C2752j.m14656L();
        try {
            m14656L.put("action", enumC4009a.name());
            for (String str : hashMap.keySet()) {
                m14656L.put(str, hashMap.get(str));
            }
            C2752j.m14638y("statusevent", m14656L);
        } catch (JSONException e) {
            C0375b.m22345l("Actions", e);
        }
    }

    /* renamed from: a0 */
    public static void m13370a0() {
        m13372Z(EnumC4009a.dummy, new HashMap());
    }

    /* renamed from: b0 */
    public static void m13368b0(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("status", String.valueOf(z));
        hashMap.put("ts", String.valueOf(C4503r.m10980w()));
        m13372Z(EnumC4009a.login_status_change, hashMap);
    }

    /* renamed from: c0 */
    public static void m13366c0(String str, boolean z, long j, Location location) {
        HashMap hashMap = new HashMap();
        hashMap.put("ts", String.valueOf(j));
        hashMap.put("lat", String.valueOf(location.getLatitude()));
        hashMap.put("lng", String.valueOf(location.getLongitude()));
        hashMap.put("job", str);
        hashMap.put("type", z ? "manual_checkin" : "manual_checkout");
        m13372Z(EnumC4009a.job_check, hashMap);
    }

    /* renamed from: d0 */
    public static void m13364d0() {
        String string = C0378d.m22324b().getString("emergency_receivers", "");
        if (string.length() > 0) {
            C0375b.m22356a("sending PANIC with receiverString: " + string);
            m13362e0(string.split(","));
            return;
        }
        C4695i.m10393g(C7068s.f18601n);
    }

    /* renamed from: e0 */
    private static void m13362e0(String... strArr) {
        String m10939c = C4512y.m10939c(C4034l.m12241b().m12240c(), R.string.IAmHere, R.string.INeedHelp);
        Toast.makeText(App.m13901f(), (int) R.string.EmergencySent, 1).show();
        m13396B(m10939c, null, strArr);
    }

    /* renamed from: f0 */
    public static void m13360f0() {
        HashMap hashMap = new HashMap();
        hashMap.put("ts", String.valueOf(C4503r.m10980w()));
        m13372Z(EnumC4009a.reboot_event, hashMap);
    }

    /* renamed from: g0 */
    public static void m13358g0() {
        try {
            JSONObject m14656L = C2752j.m14656L();
            m14656L.put("status_label", C0381f.m22291b().m22272m());
            m14656L.put("status_label_ts", C4503r.m10980w());
            C2752j.m14638y("setvalue", m14656L);
        } catch (JSONException e) {
            C0375b.m22349h(e);
        }
    }

    /* renamed from: h0 */
    public static void m13356h0(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("status", String.valueOf(z));
        hashMap.put("ts", String.valueOf(C4503r.m10980w()));
        m13372Z(EnumC4009a.tracking_status_change, hashMap);
    }

    /* renamed from: i0 */
    private static void m13354i0(Activity activity) {
        final EditText editText = new EditText(activity);
        editText.setText(C0381f.m22291b().m22272m());
        editText.setGravity(17);
        editText.setInputType(8193);
        editText.setSelection(editText.getText().length());
        editText.selectAll();
        AlertDialog create = new AlertDialog.Builder(activity).setMessage(R.string.EnterNewStatus).setView(editText).setPositiveButton(activity.getString(R.string.OK), new DialogInterface.OnClickListener() { // from class: s5.o
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                C3669c.m13376V(editText, dialogInterface, i);
            }
        }).setNegativeButton(R.string.Cancel, (DialogInterface.OnClickListener) null).create();
        create.getWindow().setSoftInputMode(4);
        create.show();
        editText.requestFocus();
    }

    /* renamed from: j0 */
    public static void m13352j0(Activity activity) {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + App.m13901f().getPackageName()));
            activity.startActivity(intent);
        } catch (Exception e) {
            C0375b.m22346k("Actions", "startApplicationDetailsActivity", e);
        }
    }

    /* renamed from: k0 */
    public static void m13350k0(String str, double d, double d2) {
        try {
            JSONObject m14656L = C2752j.m14656L();
            m14656L.put("account", str);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lat", d);
            jSONObject.put("lng", d2);
            m14656L.put(FirebaseAnalytics.Param.LOCATION, jSONObject);
            C2752j.m14641v("editprofile", m14656L, new C2767s());
        } catch (Exception e) {
            C0375b.m22334w(e);
        }
    }

    /* renamed from: l */
    public static void m13349l(final Activity activity) {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(C0381f.m22291b().m22274k());
        linkedList.addAll(C0381f.m22291b().m22273l());
        if (linkedList.size() > 0) {
            linkedList.addFirst(activity.getString(R.string.EnterNewStatus));
            linkedList.addLast(activity.getString(R.string.ClearStatus));
            final String[] strArr = (String[]) linkedList.toArray(new String[linkedList.size()]);
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setTitle(R.string.ChooseYourCurrentStatus).setItems(strArr, new DialogInterface.OnClickListener() { // from class: s5.l
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    C3669c.m13386L(activity, strArr, dialogInterface, i);
                }
            });
            AlertDialog create = builder.setCancelable(true).create();
            create.setCanceledOnTouchOutside(true);
            create.show();
            return;
        }
        m13354i0(activity);
    }

    /* renamed from: l0 */
    public static void m13348l0(C6494b c6494b, double d, double d2) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("lat", d);
            jSONObject2.put("lng", d2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(FirebaseAnalytics.Param.LOCATION, jSONObject2);
            jSONObject.put(c6494b.f17416a, jSONObject3);
            JSONObject m14656L = C2752j.m14656L();
            m14656L.put("jobs", jSONObject);
            C2752j.m14638y("editjobs", m14656L);
        } catch (Exception e) {
            C0375b.m22334w(e);
        }
    }

    /* renamed from: m */
    public static void m13347m(C5091l c5091l, double d, double d2, int i, String str, String str2) {
        try {
            ArrayList<Geofence> arrayList = new ArrayList<>();
            C5090k c5090k = new C5090k(str, 1, d, d2, i == 0 ? 100 : i, -1L, 3, str2);
            arrayList.add(c5090k.m8990i(App.m13901f()));
            new C5083f().m9014c(arrayList);
            c5091l.m8983g(str, c5090k);
            C0375b.m22343n("place geofence added: " + str2);
        } catch (Exception e) {
            C0375b.m22345l("doAddGeofence", e);
        }
    }

    /* renamed from: n */
    public static void m13346n(Context context, C6494b c6494b) {
        try {
            ArrayList<Geofence> arrayList = new ArrayList<>();
            C5090k c5090k = new C5090k(c6494b.f17416a, 2, c6494b.f17458r, c6494b.f17460s, c6494b.f17364A, C4503r.m10983t(24), 7, c6494b.m5496w());
            arrayList.add(c5090k.m8990i(context));
            new C5083f().m9014c(arrayList);
            new C5091l(context).m8983g(c6494b.f17416a, c5090k);
        } catch (Exception e) {
            C0375b.m22344m(e);
        }
    }

    /* renamed from: o */
    public static void m13345o(Context context, String str, String str2, boolean z, Location location) {
        try {
            JSONObject m14656L = C2752j.m14656L();
            if (str == null) {
                str = "";
            }
            m14656L.put("text", str);
            m14656L.put("place", str2);
            m14656L.put("ts", location.getTime());
            m14656L.put("lat", location.getLatitude());
            m14656L.put("lng", location.getLongitude());
            m14656L.put("manual", z);
            C2752j.m14638y("checkin", m14656L);
            if (!z) {
                return;
            }
            C4469a.m11103h();
            if (!(context instanceof Activity)) {
                return;
            }
            C4925i.m9700C((Activity) context, context.getString(R.string.CheckInOK), "");
        } catch (Exception e) {
            C0375b.m22349h(e);
        }
    }

    /* renamed from: p */
    public static void m13344p(Context context, String str, String str2, boolean z, Location location) {
        try {
            JSONObject m14656L = C2752j.m14656L();
            if (str == null) {
                str = "";
            }
            m14656L.put("text", str);
            m14656L.put("place", str2);
            m14656L.put("ts", location.getTime());
            m14656L.put("lat", location.getLatitude());
            m14656L.put("lng", location.getLongitude());
            m14656L.put("manual", z);
            if (z) {
                C4469a.m11103h();
                if (context instanceof Activity) {
                    C4925i.m9700C((Activity) context, context.getString(R.string.CheckOutOK), "");
                }
            }
            C2752j.m14638y("checkout", m14656L);
        } catch (Exception e) {
            C0375b.m22349h(e);
        }
    }

    /* renamed from: q */
    public static void m13343q(C2767s c2767s) {
        try {
            C2752j.m14641v("cleartrackhistory", C2752j.m14656L(), c2767s);
        } catch (Exception e) {
            C0375b.m22334w(e);
        }
    }

    /* renamed from: r */
    public static void m13342r(AbstractActivityC3663a abstractActivityC3663a, final long j, final Runnable runnable) {
        EnumC4478d.m11082g("delete_track");
        AlertDialog.Builder builder = new AlertDialog.Builder(abstractActivityC3663a);
        builder.setTitle(R.string.DeleteTrackPermanently);
        builder.setNegativeButton(R.string.Cancel, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(R.string.Delete, new DialogInterface.OnClickListener() { // from class: s5.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                C3669c.m13385M(j, runnable, dialogInterface, i);
            }
        });
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(true);
        create.show();
    }

    /* renamed from: s */
    public static void m13341s(Activity activity, boolean z) {
        SharedPreferences$OnSharedPreferenceChangeListenerC3612c.m13839a().m13832h();
        if (activity == null || !z) {
            return;
        }
        activity.finish();
    }

    /* renamed from: t */
    public static void m13340t(Activity activity, String str) {
        if (str == null || str.trim().length() <= 0) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.DIAL");
            intent.setData(Uri.parse("tel:" + str.trim()));
            activity.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(activity, (int) R.string.NotAvailable, 0).show();
        }
    }

    /* renamed from: u */
    public static void m13339u(final Activity activity, final double d, final double d2) {
        int i = C0378d.m22324b().getInt("navigation.preferred", -1);
        if (i >= 0) {
            m13375W(i, d, d2, activity);
            return;
        }
        View inflate = activity.getLayoutInflater().inflate(R.layout.checkbox_remember, (ViewGroup) null);
        final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.checkbox);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(R.string.Directions).setItems(new String[]{"Google Navigation", "Google Maps", "Waze"}, new DialogInterface.OnClickListener() { // from class: s5.n
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                C3669c.m13384N(checkBox, d, d2, activity, dialogInterface, i2);
            }
        });
        AlertDialog create = builder.create();
        create.setView(inflate);
        create.show();
    }

    /* renamed from: v */
    public static void m13338v(Activity activity) {
        activity.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
    }

    /* renamed from: w */
    public static void m13337w(final AbstractActivityC5510b abstractActivityC5510b, final long j, final long j2, final Runnable runnable) {
        AlertDialog.Builder builder = new AlertDialog.Builder(abstractActivityC5510b);
        builder.setTitle(R.string.MergeTracks);
        builder.setMessage(R.string.MergeText);
        builder.setPositiveButton(abstractActivityC5510b.getResources().getString(R.string.MergeNow), new DialogInterface.OnClickListener() { // from class: s5.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                C3669c.m13383O(j, j2, runnable, abstractActivityC5510b, dialogInterface, i);
            }
        });
        builder.setNegativeButton(abstractActivityC5510b.getResources().getString(R.string.Cancel), DialogInterface$OnClickListenerC7062q.f18589n);
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(true);
        create.show();
    }

    /* renamed from: x */
    public static void m13336x(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.hellotracks"));
        intent.addFlags(1073741824);
        context.startActivity(intent);
    }

    /* renamed from: y */
    public static void m13335y(String str) {
        m13397A(EnumC4158d.ping.f12012n, null, false, str);
    }

    /* renamed from: z */
    public static void m13334z(Context context, C6494b c6494b) {
        new C5091l(context).m8984f(c6494b.f17416a);
        C0375b.m22343n("job geofence removed");
    }
}