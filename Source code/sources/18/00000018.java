package com.hellotracks.screens.map;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.location.Location;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.C0637b;
import androidx.drawerlayout.widget.DrawerLayout;
import com.facebook.rebound.SpringSystem;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.firebase.messaging.Constants;
import com.google.maps.android.collections.MarkerManager;
import com.google.maps.android.p038ui.IconGenerator;
import com.hellotracks.App;
import com.hellotracks.R;
import com.hellotracks.controllers.AbstractC3614d;
import com.hellotracks.controllers.PeriodicController;
import com.hellotracks.controllers.SharedPreferences$OnSharedPreferenceChangeListenerC3612c;
import com.hellotracks.screens.intro.IntroScreen;
import com.hellotracks.screens.map.AbstractActivityC3663a;
import com.hellotracks.screens.map.HomeMapScreen;
import com.hellotracks.screens.messaging.MessagesScreen;
import com.hellotracks.screens.other.PanicScreen;
import com.hellotracks.views.BadgeView;
import de.greenrobot.event.EventBus;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
import p006a5.C0375b;
import p006a5.C0378d;
import p006a5.C0381f;
import p006a5.EnumC0377c;
import p020b5.C2754k;
import p021b6.C2795i;
import p030c5.C2919a;
import p030c5.C2927f;
import p047d6.C4027f;
import p077g6.C4472b;
import p077g6.C4479e;
import p077g6.C4480f;
import p077g6.C4485h;
import p077g6.C4490k;
import p077g6.C4503r;
import p077g6.C4512y;
import p077g6.EnumC4478d;
import p086h5.C4642c0;
import p086h5.C4652h;
import p086h5.C4665n;
import p086h5.C4673t;
import p086h5.C4684z;
import p087h6.AbstractRunnableC4692f;
import p087h6.AbstractRunnableC4697j;
import p087h6.C4695i;
import p087h6.C4699l;
import p097i6.AbstractC4834a;
import p106j5.C4902a;
import p106j5.C4906e;
import p106j5.C4907f;
import p106j5.C4908g;
import p106j5.C4910i;
import p106j5.C4911j;
import p106j5.C4913l;
import p106j5.C4916o;
import p107j6.C4917a;
import p107j6.C4925i;
import p116k5.C5091l;
import p176q5.C6494b;
import p186r5.C6710a;
import p196s5.C7033g0;
import p196s5.C7042j0;
import p196s5.C7043j1;
import p196s5.C7046k1;
import p196s5.C7071t;
import p196s5.C7073t1;
import p196s5.C7085w1;

/* loaded from: classes2.dex */
public class HomeMapScreen extends AbstractActivityC3663a implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: A0 */
    private SharedPreferences$OnSharedPreferenceChangeListenerC3691o f9923A0;

    /* renamed from: B0 */
    private SharedPreferences$OnSharedPreferenceChangeListenerC3674d f9924B0;

    /* renamed from: c0 */
    private BadgeView f9930c0;

    /* renamed from: d0 */
    private ImageButton f9931d0;

    /* renamed from: e0 */
    private ImageButton f9932e0;

    /* renamed from: f0 */
    private ImageButton f9933f0;

    /* renamed from: g0 */
    private ImageButton f9934g0;

    /* renamed from: h0 */
    private View f9935h0;

    /* renamed from: i0 */
    private View[] f9936i0;

    /* renamed from: j0 */
    private View f9937j0;

    /* renamed from: k0 */
    private C0637b f9938k0;

    /* renamed from: l0 */
    private C5091l f9939l0;

    /* renamed from: m0 */
    private DrawerLayout f9940m0;

    /* renamed from: o0 */
    private LeftDrawerFragment f9942o0;

    /* renamed from: p0 */
    private View f9943p0;

    /* renamed from: q0 */
    private TextView f9944q0;

    /* renamed from: x0 */
    private TextView f9951x0;

    /* renamed from: y0 */
    private PowerManager.WakeLock f9952y0;

    /* renamed from: Z */
    private final SharedPreferences$OnSharedPreferenceChangeListenerC3685k f9927Z = SharedPreferences$OnSharedPreferenceChangeListenerC3685k.m13281m();

    /* renamed from: a0 */
    private final HashMap<String, Marker> f9928a0 = new HashMap<>();

    /* renamed from: b0 */
    private final SharedPreferences$OnSharedPreferenceChangeListenerC3678h f9929b0 = SharedPreferences$OnSharedPreferenceChangeListenerC3678h.m13315i();

    /* renamed from: n0 */
    protected final BroadcastReceiver f9941n0 = new C3659a();

    /* renamed from: r0 */
    private boolean f9945r0 = false;

    /* renamed from: s0 */
    private Runnable f9946s0 = null;

    /* renamed from: t0 */
    private float f9947t0 = BitmapDescriptorFactory.HUE_RED;

    /* renamed from: u0 */
    private int f9948u0 = -1;

    /* renamed from: v0 */
    private final SpringSystem f9949v0 = SpringSystem.create();

    /* renamed from: w0 */
    private boolean f9950w0 = false;

    /* renamed from: z0 */
    private Paint f9953z0 = null;

    /* renamed from: C0 */
    private final Object f9925C0 = new C3660b();

    /* renamed from: D0 */
    private final AbstractC3614d f9926D0 = new C3661c();

    /* renamed from: com.hellotracks.screens.map.HomeMapScreen$a */
    /* loaded from: classes2.dex */
    class C3659a extends BroadcastReceiver {
        C3659a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C7046k1[] c7046k1Arr;
            String string = intent.getExtras().getString("account");
            if (string != null) {
                for (C7046k1 c7046k1 : (C7046k1[]) HomeMapScreen.this.f9972Q.values().toArray(new C7046k1[0])) {
                    if (c7046k1.f18546a.equals(string)) {
                        HomeMapScreen.this.m13577V1(c7046k1.f18554i);
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: com.hellotracks.screens.map.HomeMapScreen$c */
    /* loaded from: classes2.dex */
    class C3661c implements AbstractC3614d {

        /* renamed from: n */
        int f9956n = 0;

        C3661c() {
        }

        @Override // com.hellotracks.controllers.AbstractC3614d
        /* renamed from: a */
        public /* synthetic */ void mo2360a() {
            C4665n.m10456a(this);
        }

        @Override // com.hellotracks.controllers.AbstractC3614d
        /* renamed from: b */
        public /* synthetic */ void mo2359b() {
            C4665n.m10451f(this);
        }

        @Override // com.hellotracks.controllers.AbstractC3614d
        /* renamed from: c */
        public /* synthetic */ void mo2358c(HomeMapScreen homeMapScreen) {
            C4665n.m10455b(this, homeMapScreen);
        }

        @Override // com.hellotracks.controllers.AbstractC3614d
        /* renamed from: d */
        public /* synthetic */ void mo2357d() {
            C4665n.m10453d(this);
        }

        @Override // com.hellotracks.controllers.AbstractC3614d
        /* renamed from: f */
        public /* synthetic */ void mo2355f() {
            C4665n.m10452e(this);
        }

        @Override // com.hellotracks.controllers.AbstractC3614d
        /* renamed from: h */
        public void mo2354h(PeriodicController.EnumC3604d enumC3604d) {
            HomeMapScreen homeMapScreen = HomeMapScreen.this;
            int i = this.f9956n;
            this.f9956n = i + 1;
            homeMapScreen.m13581R1(i);
        }

        @Override // com.hellotracks.controllers.AbstractC3614d
        /* renamed from: i */
        public /* synthetic */ void mo2353i() {
            C4665n.m10449h(this);
        }

        @Override // com.hellotracks.controllers.AbstractC3614d
        public /* synthetic */ void onDestroy() {
            C4665n.m10454c(this);
        }

        @Override // com.hellotracks.controllers.AbstractC3614d
        public /* synthetic */ void onMapReady(GoogleMap googleMap) {
            C4665n.m10450g(this, googleMap);
        }

        @Override // com.hellotracks.controllers.AbstractC3614d
        public /* synthetic */ void onPause() {
            C4665n.m10448i(this);
        }

        @Override // com.hellotracks.controllers.AbstractC3614d
        public /* synthetic */ void onResume() {
            C4665n.m10446k(this);
        }

        @Override // com.hellotracks.controllers.AbstractC3614d
        public /* synthetic */ void onStart() {
            C4665n.m10445l(this);
        }

        @Override // com.hellotracks.controllers.AbstractC3614d
        public /* synthetic */ void onStop() {
            C4665n.m10444m(this);
        }
    }

    /* renamed from: A2 */
    private void m13601A2(SharedPreferences sharedPreferences, boolean z) {
        this.f9924B0.m13331a().m3227y();
        boolean m22304P = C0381f.m22291b().m22304P();
        if (this.f9943p0.isHardwareAccelerated()) {
            if (m22304P && this.f9953z0 != null) {
                View view = this.f9943p0;
                this.f9953z0 = null;
                view.setLayerType(2, null);
            } else if (C0381f.m22291b().m22300T() && !m22304P && this.f9953z0 == null) {
                View view2 = this.f9943p0;
                Paint m13598C1 = m13598C1();
                this.f9953z0 = m13598C1;
                view2.setLayerType(2, m13598C1);
            }
        }
        if (m22304P) {
            m7807Y();
        } else {
            m7802d0();
        }
        this.f9942o0.m13490Z(m22304P);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B1 */
    public Runnable m13600B1(final LinkedList<C2919a> linkedList) {
        return new Runnable() { // from class: s5.a0
            @Override // java.lang.Runnable
            public final void run() {
                HomeMapScreen.this.m13576W1(linkedList);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B2 */
    public void m13599B2() {
        this.f9924B0.m13331a().m3226z();
    }

    /* renamed from: C1 */
    private Paint m13598C1() {
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        float[] fArr = {0.1965f, 0.3845f, 0.0945f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0.1745f, 0.343f, 0.084f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0.136f, 0.267f, 0.0655f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f};
        colorMatrix.set(fArr);
        paint.setColorFilter(new ColorMatrixColorFilter(fArr));
        return paint;
    }

    /* renamed from: C2 */
    private void m13597C2() {
        String str;
        if (C0381f.m22291b().m22310J()) {
            boolean m22306N = C0381f.m22291b().m22306N();
            C4503r.C4504a m22265t = C0381f.m22291b().m22265t();
            if (m22265t.m10974c()) {
                str = getString(R.string.TodayOff);
            } else {
                str = C4503r.m10987p(m22265t.f12676a, m22265t.f12677b, m22306N);
            }
            this.f9944q0.setText(getString(R.string.OffDutyLocatingOff, new Object[]{str}));
            this.f9944q0.setVisibility(0);
            return;
        }
        this.f9944q0.setVisibility(8);
    }

    /* renamed from: E1 */
    private void m13594E1() {
        if (m13401y0()) {
            C0375b.m22343n("ensure all markers");
            C4695i.m10393g(new AbstractRunnableC4692f() { // from class: s5.e0
                @Override // p087h6.AbstractRunnableC4692f, java.lang.Runnable
                public final void run() {
                    HomeMapScreen.this.m13572Z1();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F1 */
    public void m13593F1(C6494b c6494b) {
        try {
            if (this.f9928a0.containsKey(c6494b.f17416a)) {
                this.f9928a0.get(c6494b.f17416a).remove();
            }
            IconGenerator iconGenerator = new IconGenerator(this);
            if (c6494b.m5534J()) {
                iconGenerator.setStyle(5);
            } else if (c6494b.m5535I()) {
                iconGenerator.setStyle(3);
            } else if (c6494b.m5529O()) {
                iconGenerator.setStyle(7);
            } else if (c6494b.m5537G()) {
                iconGenerator.setStyle(4);
            } else {
                iconGenerator.setStyle(2);
            }
            iconGenerator.setContentRotation(-90);
            this.f9928a0.put(c6494b.f17416a, this.f9977V.addMarker(new MarkerOptions().title(c6494b.m5502q()).snippet(c6494b.m5509j()).position(new LatLng(c6494b.f17458r, c6494b.f17460s)).draggable(false).icon(BitmapDescriptorFactory.fromBitmap(iconGenerator.makeIcon(c6494b.m5501r())))));
        } catch (Exception e) {
            C0375b.m22344m(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G1 */
    public void m13592G1() {
        final List<C6494b> selectAll = App.m13903c().mo13823C().selectAll();
        C4699l.m10386e(new AbstractRunnableC4697j() { // from class: s5.i0
            @Override // p087h6.AbstractRunnableC4697j, java.lang.Runnable
            public final void run() {
                HomeMapScreen.this.m13570a2(selectAll);
            }
        });
    }

    /* renamed from: H1 */
    private void m13591H1(List<C6494b> list) {
        String[] strArr;
        try {
            for (C6494b c6494b : list) {
                m13593F1(c6494b);
            }
            for (String str : (String[]) this.f9928a0.keySet().toArray(new String[0])) {
                Iterator<C6494b> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().f17416a.equals(str)) {
                            break;
                        }
                    } else {
                        this.f9928a0.get(str).remove();
                        this.f9928a0.remove(str);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            C0375b.m22344m(e);
        }
    }

    /* renamed from: I1 */
    private void m13590I1(List<C2927f> list) {
        boolean z;
        Set<Integer> set;
        C0381f.C0385d[] c0385dArr;
        Set<Integer> set2;
        C0381f.C0385d[] c0385dArr2;
        C2927f c2927f;
        try {
            C0375b.m22342o("HomeMapScreen", "ensure mappable markers " + list.size());
            boolean m22315E = C0381f.m22291b().m22315E();
            Location m7815Q = m7815Q();
            C0381f.C0385d[] m22271n = C0381f.m22291b().m22271n();
            Set<Integer> m22279h = C0381f.m22291b().m22279h();
            boolean m22317C = C0381f.m22291b().m22317C();
            Iterator<C2927f> it = list.iterator();
            int i = 0;
            while (true) {
                z = true;
                if (!it.hasNext()) {
                    break;
                } else if (it.next().marker_type == 1) {
                    i++;
                }
            }
            if (i >= 30) {
                z = false;
            }
            for (C2927f c2927f2 : list) {
                C7046k1 c7046k1 = this.f9972Q.get(c2927f2.uid);
                if (c7046k1 != null) {
                    String str = c7046k1.f18548c;
                    if (c2927f2.isMapable()) {
                        C0375b.m22337t(c2927f2.uid + " " + c2927f2.name + " is mappable");
                        LatLng latLng = c7046k1.f18550e;
                        double d = latLng.latitude;
                        c0385dArr2 = m22271n;
                        set2 = m22279h;
                        double d2 = latLng.longitude;
                        c7046k1.m4332e(c2927f2, this, m7815Q);
                        if (!str.equals(c7046k1.f18548c)) {
                            mo13407s0(c7046k1, z);
                        }
                        LatLng latLng2 = c7046k1.f18550e;
                        if (d != latLng2.latitude || d2 != latLng2.longitude) {
                            m13411o0(latLng2, c7046k1.f18554i, 1000);
                        }
                        c2927f = c2927f2;
                    } else {
                        c0385dArr2 = m22271n;
                        set2 = m22279h;
                        m13534s2(c7046k1, false);
                        m22271n = c0385dArr2;
                        m22279h = set2;
                    }
                } else {
                    c0385dArr2 = m22271n;
                    set2 = m22279h;
                    if (c2927f2.isMapable()) {
                        c2927f = c2927f2;
                        c7046k1 = new C7046k1(C0381f.m22291b().m22311I(c2927f.uid));
                        c7046k1.m4332e(c2927f, this, m7815Q);
                        m13413m0(c7046k1, m22315E, z);
                        this.f9972Q.put(c2927f.uid, c7046k1);
                        C0375b.m22343n(c2927f.name + " " + c2927f.uid + " is mappable but with null entry");
                    } else {
                        c0385dArr = c0385dArr2;
                        set = set2;
                        C0375b.m22337t(c2927f2.name + " not mappable skip " + c2927f2.name);
                        m22271n = c0385dArr;
                        m22279h = set;
                    }
                }
                Marker marker = c7046k1.f18554i;
                if (marker == null) {
                    C0375b.m22348i("entry.marker is null: " + c2927f.uid);
                    m22271n = c0385dArr2;
                    m22279h = set2;
                } else {
                    marker.setTitle(c7046k1.f18549d);
                    if (!c7046k1.m4334c() || !m22317C) {
                        c0385dArr = c0385dArr2;
                        set = set2;
                    } else {
                        c0385dArr = c0385dArr2;
                        set = set2;
                        c7046k1.f18554i.setVisible(C0381f.m22309K(c0385dArr, set, c7046k1.m4336a()));
                    }
                    m22271n = c0385dArr;
                    m22279h = set;
                }
            }
            if (list.size() <= 0) {
                return;
            }
            this.f9971P.post(new Runnable() { // from class: s5.y
                @Override // java.lang.Runnable
                public final void run() {
                    HomeMapScreen.this.m13568b2();
                }
            });
        } catch (Exception e) {
            C0375b.m22349h(e);
        }
    }

    /* renamed from: P1 */
    private void m13583P1(Location location) {
        if (location == null || System.currentTimeMillis() - location.getTime() >= 20000) {
            return;
        }
        this.f9947t0 = location.getBearing() != BitmapDescriptorFactory.HUE_RED ? location.getBearing() : this.f9947t0;
        m13406t0().animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(new LatLng(location.getLatitude(), location.getLongitude())).zoom(18.0f).tilt(70.0f).bearing(this.f9947t0).build()));
        if (C0381f.m22291b().m22316D()) {
            TextView textView = this.f9951x0;
            textView.setText(((int) (location.getSpeed() * 2.23694d)) + " mph");
            return;
        }
        TextView textView2 = this.f9951x0;
        textView2.setText(((int) (location.getSpeed() * 3.6d)) + " km/h");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R1 */
    public void m13581R1(int i) {
        if (!m7809W()) {
            return;
        }
        if (C0381f.m22291b().m22312H()) {
            if (!m7812T()) {
                return;
            }
            C3669c.m13390H(this);
            return;
        }
        m13422Y0();
        this.f9924B0.m13331a().m3253A();
        if (i % 5 == 0) {
            m13595D2(false);
        }
        Location m7815Q = m7815Q();
        long m10980w = C4503r.m10980w() - C0378d.m22324b().getLong("last_drivingview_switch_ts", 0L);
        if (m7815Q != null && m10980w > 300000) {
            if ((m7815Q.getSpeed() > 10.0f && !this.f9950w0 && C0378d.m22324b().getBoolean("auto_drivingview", true)) || (m7815Q.getSpeed() == BitmapDescriptorFactory.HUE_RED && this.f9950w0)) {
                onDriving(this.f9934g0);
                C0378d.m22324b().edit().putLong("last_drivingview_switch_ts", 0L).apply();
            }
        } else if (m7815Q != null && m7815Q.getSpeed() > 10.0f) {
            C0378d.m22324b().edit().putLong("last_drivingview_switch_ts", C4503r.m10980w()).apply();
        }
        if (this.f9950w0) {
            m13583P1(m7815Q);
        }
        if (i == 4 && C0378d.m22324b().getInt("info_read", 0) < 1) {
            this.f9937j0.setVisibility(0);
            this.f9937j0.startAnimation(C4917a.m9714b());
        }
        m13597C2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W1 */
    public /* synthetic */ void m13576W1(LinkedList linkedList) {
        C7046k1 c7046k1;
        List<C2927f> m14636a = C2754k.m14636a(linkedList);
        m13590I1(m14636a);
        if (!this.f9945r0 && m14636a.size() > 0) {
            for (C7046k1 c7046k12 : this.f9972Q.values()) {
                if (c7046k12.m4334c() && !c7046k12.m4335b()) {
                    C3669c.m13335y(c7046k12.f18546a);
                }
            }
            this.f9945r0 = true;
        }
        View findViewById = findViewById(R.id.contextualPerson);
        if (findViewById.getVisibility() != 0 || !(findViewById.getTag() instanceof String)) {
            return;
        }
        String str = (String) findViewById.getTag();
        for (C2927f c2927f : m14636a) {
            if (str.endsWith(c2927f.uid) && (c7046k1 = this.f9972Q.get(c2927f.uid)) != null) {
                C7071t.m4322b(this, c7046k1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X1 */
    public /* synthetic */ void m13575X1(C7046k1 c7046k1, boolean z, Bitmap bitmap) {
        if (m7809W()) {
            m13532t2(c7046k1, bitmap);
        }
        C4472b m11093b = C4472b.m11093b();
        m11093b.m11091d(C4472b.EnumC4474b.Marker_url_ + c7046k1.f18548c, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y1 */
    public /* synthetic */ void m13574Y1(List list) {
        if (m7809W()) {
            m13590I1(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z1 */
    public /* synthetic */ void m13572Z1() {
        final List<C2927f> selectAllAndReduce = App.m13903c().mo13822D().selectAllAndReduce();
        C4699l.m10386e(new AbstractRunnableC4697j() { // from class: s5.h0
            @Override // p087h6.AbstractRunnableC4697j, java.lang.Runnable
            public final void run() {
                HomeMapScreen.this.m13574Y1(selectAllAndReduce);
            }
        });
        if (C0381f.m22291b().m22315E()) {
            m13592G1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a2 */
    public /* synthetic */ void m13570a2(List list) {
        if (!m7809W() || !m13401y0()) {
            return;
        }
        m13591H1(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b2 */
    public /* synthetic */ void m13568b2() {
        if (m7809W()) {
            this.f9923A0.m13257p();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d2 */
    public /* synthetic */ void m13564d2() {
        if (m7809W()) {
            this.f9923A0.m13262k();
            m13586M1().m13284j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e2 */
    public /* synthetic */ void m13562e2(View view) {
        C0378d.m22324b().edit().putInt("info_read", 1).apply();
        this.f9937j0.startAnimation(C4917a.m9711e());
        this.f9937j0.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f2 */
    public /* synthetic */ void m13560f2(View view) {
        m13540p2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g2 */
    public /* synthetic */ boolean m13558g2(View view) {
        m13542o2();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h2 */
    public /* synthetic */ void m13556h2() {
        if (m7809W()) {
            m13425V0(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i2 */
    public /* synthetic */ void m13554i2() {
        if (m7809W()) {
            m13594E1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j2 */
    public /* synthetic */ void m13552j2(boolean z) {
        if (!z) {
            C3669c.m13341s(this, false);
            C3669c.m13390H(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k2 */
    public static /* synthetic */ void m13550k2(C7046k1 c7046k1) {
        c7046k1.f18561p.setUnmapable();
        App.m13903c().mo13822D().save(c7046k1.f18561p);
    }

    /* renamed from: q2 */
    private void m13538q2() {
        PowerManager.WakeLock wakeLock = this.f9952y0;
        if (wakeLock != null) {
            try {
                if (wakeLock.isHeld()) {
                    this.f9952y0.release();
                }
            } catch (Exception e) {
                C0375b.m22349h(e);
            }
            this.f9952y0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s2 */
    public void m13534s2(final C7046k1 c7046k1, boolean z) {
        m13433N0(c7046k1.f18554i);
        if (z) {
            this.f9923A0.m13257p();
        }
        if (c7046k1.f18561p != null) {
            C4695i.m10393g(new AbstractRunnableC4692f() { // from class: s5.f0
                @Override // p087h6.AbstractRunnableC4692f, java.lang.Runnable
                public final void run() {
                    HomeMapScreen.m13550k2(C7046k1.this);
                }
            });
        }
    }

    /* renamed from: t2 */
    private void m13532t2(C7046k1 c7046k1, Bitmap bitmap) {
        Marker marker = c7046k1.f18554i;
        if (marker != null) {
            try {
                marker.setIcon(BitmapDescriptorFactory.fromBitmap(bitmap));
                c7046k1.f18554i.setAnchor(0.5f, 1.0f);
            } catch (IllegalArgumentException e) {
                C0375b.m22350g("HomeMapScreen", e);
            }
        }
    }

    /* renamed from: y1 */
    private void m13523y1() {
        try {
            PowerManager.WakeLock newWakeLock = ((PowerManager) getSystemService("power")).newWakeLock(26, "hellotracks:driving");
            this.f9952y0 = newWakeLock;
            if (newWakeLock.isHeld()) {
                return;
            }
            this.f9952y0.acquire();
        } catch (Exception e) {
            C0375b.m22349h(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: A1 */
    public void m13602A1() {
        this.f9973R.clear();
        this.f9972Q.clear();
        this.f9923A0.m13257p();
        m13409q0();
    }

    /* renamed from: D1 */
    protected AbstractActivityC3663a.C3667d m13596D1(String str, C2795i c2795i) {
        AbstractActivityC3663a.C3667d c3667d = new AbstractActivityC3663a.C3667d(c2795i);
        c3667d.f9992f = C4479e.m11078b(str);
        c3667d.f9993g = str;
        PolylineOptions polylineOptions = new PolylineOptions();
        for (LatLng latLng : c3667d.f9992f) {
            polylineOptions.add(latLng);
        }
        polylineOptions.color(getResources().getColor(R.color.track_outer));
        polylineOptions.width(C4925i.m9685j(9.0f, this));
        c3667d.f9991e = m13406t0().addPolyline(polylineOptions);
        c3667d.f9994h = R.color.track_outer;
        polylineOptions.width(C4925i.m9685j(7.0f, this));
        polylineOptions.color(getResources().getColor(R.color.track_inner));
        c3667d.f9990d = m13406t0().addPolyline(polylineOptions);
        if (c3667d.f9992f.size() >= 2) {
            Marker addMarker = this.f9977V.addMarker(new MarkerOptions().zIndex(100.0f).position(c3667d.f9992f.get(0)).title("A").snippet(c2795i.f9019i).anchor(0.5f, 0.5f).icon(C4925i.m9681n()));
            c3667d.f9988b = addMarker;
            addMarker.showInfoWindow();
            MarkerManager.Collection collection = this.f9977V;
            MarkerOptions zIndex = new MarkerOptions().zIndex(100.0f);
            List<LatLng> list = c3667d.f9992f;
            c3667d.f9989c = collection.addMarker(zIndex.position(list.get(list.size() - 1)).title("B").snippet(c2795i.f9020j).anchor(0.5f, 0.5f).icon(C4925i.m9680o()));
        }
        this.f9974S.put(Long.valueOf(c2795i.f9011a), c3667d);
        return c3667d;
    }

    /* renamed from: D2 */
    public void m13595D2(boolean z) {
        C4695i.m10393g(C7033g0.f18527n);
    }

    /* renamed from: J1 */
    public void m13589J1(C2795i c2795i) {
        AbstractActivityC3663a.C3667d c3667d = this.f9974S.get(Long.valueOf(c2795i.f9011a));
        if (c3667d != null) {
            C7043j1.m4338a(m13406t0(), c3667d.f9992f);
        }
    }

    @Override // com.hellotracks.screens.map.AbstractActivityC3663a
    /* renamed from: K0 */
    protected void mo13436K0(GoogleMap googleMap, LatLng latLng) {
        this.f9924B0.m13329c();
        super.m13439H0(googleMap, latLng);
    }

    /* renamed from: K1 */
    public View[] m13588K1() {
        return this.f9936i0;
    }

    /* renamed from: L1 */
    public C7046k1[] m13587L1() {
        return (C7046k1[]) this.f9972Q.values().toArray(new C7046k1[this.f9972Q.size()]);
    }

    /* renamed from: M1 */
    public SharedPreferences$OnSharedPreferenceChangeListenerC3685k m13586M1() {
        return this.f9927Z;
    }

    /* renamed from: N1 */
    public SpringSystem m13585N1() {
        return this.f9949v0;
    }

    /* renamed from: O1 */
    public SharedPreferences$OnSharedPreferenceChangeListenerC3691o m13584O1() {
        return this.f9923A0;
    }

    @Override // com.hellotracks.screens.map.AbstractActivityC3663a
    /* renamed from: P0 */
    public void mo13431P0() {
        if (m13401y0()) {
            if (this.f9948u0 < 0) {
                this.f9948u0 = C4925i.m9685j(10.0f, this);
            }
            int i = this.f9948u0 * 10;
            GoogleMap m13406t0 = m13406t0();
            int m13266g = this.f9923A0.m13266g() + this.f9923A0.m13269d();
            m13406t0.setPadding(0, m13266g, 0, i);
            this.f9927Z.m13275s(0, 0, m13266g, i);
        }
    }

    /* renamed from: Q1 */
    void m13582Q1(Intent intent) {
        if (intent == null) {
            C0375b.m22347j("HomeMapScreen", "handleNewIntent with null intent");
        } else if (!intent.hasExtra("src") || !"jobs_updated".equals(intent.getStringExtra("src"))) {
        } else {
            C4699l.m10387d(C7042j0.f18542n, 1000L);
        }
    }

    /* renamed from: S1 */
    public void m13580S1() {
        getWindow().setSoftInputMode(3);
        this.f9927Z.m13284j();
        m13434M0();
        if (MainTabs.m13455e()) {
            C7071t.m4323a(this);
        }
    }

    @Override // com.hellotracks.screens.map.AbstractActivityC3663a
    /* renamed from: T0 */
    protected void mo13427T0(Marker marker, boolean z) {
        if (marker == null) {
            return;
        }
        if (this.f9973R.containsKey(marker)) {
            marker.showInfoWindow();
            C7073t1.m4313c(this, marker, false);
        }
        C7046k1 c7046k1 = this.f9973R.get(marker);
        marker.setVisible(true);
        if (c7046k1 != null && !c7046k1.f18562q && c7046k1.m4334c()) {
            mo13407s0(c7046k1, true);
        }
        m13526w2((z || c7046k1 == null || c7046k1.m4333d()) ? m13400z0(marker) ? 80 : 250 : 200);
        if (this.f9928a0.containsValue(marker)) {
            Iterator<String> it = this.f9928a0.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (this.f9928a0.get(next).equals(marker)) {
                    EventBus.getDefault().post(new C4906e(next));
                    break;
                }
            }
        } else {
            C7071t.m4322b(this, c7046k1);
        }
        m13445B0(marker.getPosition());
    }

    /* renamed from: T1 */
    public boolean m13579T1() {
        return C0381f.m22291b().m22304P();
    }

    /* renamed from: U1 */
    public boolean m13578U1(long j) {
        return this.f9974S.get(Long.valueOf(j)) != null;
    }

    /* renamed from: V1 */
    public void m13577V1(Marker marker) {
        mo13427T0(marker, false);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
    }

    /* renamed from: m2 */
    protected void m13546m2() {
        setResult(-1);
        C3669c.m13341s(this, true);
    }

    /* renamed from: n2 */
    public void m13544n2(JSONObject jSONObject) {
        try {
            if (!m7809W()) {
                return;
            }
            int i = jSONObject.has("unreadmsg") ? jSONObject.getInt("unreadmsg") : 0;
            int i2 = (jSONObject.has("requests") ? jSONObject.getInt("requests") : 0) + (jSONObject.has("suggestions") ? jSONObject.getInt("suggestions") : 0);
            this.f9923A0.m13256q(i2 > 0, i2);
            int i3 = 8;
            if (i > 0) {
                this.f9930c0.setText(String.valueOf(i));
                this.f9930c0.m12909f();
                this.f9931d0.setVisibility(0);
            } else {
                this.f9930c0.setText("");
                this.f9930c0.m12911d();
                this.f9931d0.setVisibility(8);
            }
            SharedPreferences m22324b = C0378d.m22324b();
            if (jSONObject.has("app_version")) {
                findViewById(R.id.updateAvailableButton).setVisibility(jSONObject.getInt("app_version") > App.m13900g() ? 0 : 8);
            }
            if (jSONObject.has("rate_us") && "com.android.vending".equals(App.m13898i())) {
                boolean z = jSONObject.getBoolean("rate_us");
                View findViewById = findViewById(R.id.rateUsButton);
                if (z && !m22324b.getBoolean("rateus_button_clicked", false)) {
                    i3 = 0;
                }
                findViewById.setVisibility(i3);
            }
            m13599B2();
            m13601A2(m22324b, false);
        } catch (Exception e) {
            C0375b.m22334w(e);
        }
    }

    /* renamed from: o2 */
    public void m13542o2() {
        try {
            EnumC4478d.m11082g("panic");
            PanicScreen.m13239f0(this);
        } catch (Exception e) {
            C0375b.m22334w(e);
        }
    }

    @Override // com.hellotracks.screens.map.AbstractActivityC3663a, androidx.fragment.app.ActivityC2104e, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        try {
            C0375b.m22343n("HMS.onActivityResult.requestCode=" + i + " resultCode=" + i2);
            if (i2 == -1 && new C4480f(this).m11072a(i, intent)) {
                return;
            }
            if (i == 200 && i2 == -1 && intent != null) {
                mo13408r0();
                String stringExtra = intent.getStringExtra(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
                if (stringExtra.indexOf(",") > 0) {
                    stringExtra = stringExtra.substring(0, stringExtra.indexOf(","));
                }
                LatLng latLng = new LatLng(intent.getDoubleExtra("lat", 0.0d), intent.getDoubleExtra("lng", 0.0d));
                m13424W0(latLng, stringExtra, true);
                m13446A0(latLng);
            }
            if (i2 != -1000) {
                return;
            }
            m13546m2();
        } catch (Exception e) {
            C0375b.m22346k("HomeMapScreen", "onActivityResult reqCode=" + i, e);
        }
    }

    public void onCloseList(View view) {
        findViewById(R.id.layoutList).setVisibility(8);
        ((ListView) findViewById(R.id.listView)).setAdapter((ListAdapter) null);
    }

    @Override // androidx.appcompat.app.ActivityC0646d, androidx.fragment.app.ActivityC2104e, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f9938k0.m21806f(configuration);
        if (m13401y0()) {
            mo13431P0();
        }
        this.f9971P.postDelayed(new Runnable() { // from class: s5.x
            @Override // java.lang.Runnable
            public final void run() {
                HomeMapScreen.this.m13564d2();
            }
        }, 200L);
    }

    @Override // p136m5.AbstractActivityC5510b, com.google.android.gms.common.api.internal.ConnectionCallbacks
    public void onConnected(Bundle bundle) {
        super.onConnected(bundle);
        this.f9929b0.m13303u();
    }

    @Override // p136m5.AbstractActivityC5510b, androidx.fragment.app.ActivityC2104e, androidx.activity.ComponentActivity, androidx.core.app.ActivityC1600g, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().getDecorView().setSystemUiVisibility(9488);
        getWindow().setStatusBarColor(getResources().getColor(R.color.toolbar_bg));
        getWindow().setNavigationBarColor(getResources().getColor(R.color.clouds));
        overridePendingTransition(R.anim.no_anim, R.anim.no_anim);
        setContentView(R.layout.screen_main);
        SharedPreferences$OnSharedPreferenceChangeListenerC3612c.m13839a().m13837c(this.f9926D0);
        SharedPreferences$OnSharedPreferenceChangeListenerC3612c.m13839a().m13835e(this);
        this.f9924B0 = new SharedPreferences$OnSharedPreferenceChangeListenerC3674d(this);
        this.f9927Z.m13277q(this);
        this.f9929b0.m13305s(this);
        this.f9945r0 = false;
        SharedPreferences m22324b = C0378d.m22324b();
        String string = m22324b.getString("mode", null);
        EnumC0377c enumC0377c = EnumC0377c.automatic;
        if (!enumC0377c.toString().equals(string)) {
            m22324b.edit().putString("mode", enumC0377c.toString()).apply();
            m7807Y();
        }
        m13582Q1(getIntent());
        if (C4490k.m11024d(this, false)) {
            m22324b.edit().remove("gcm.failure.counter").apply();
        }
        this.f9939l0 = new C5091l(this);
        m13410p0();
        this.f9932e0 = (ImageButton) findViewById(R.id.buttonLayers);
        this.f9933f0 = (ImageButton) findViewById(R.id.buttonMyLocation);
        this.f9931d0 = (ImageButton) findViewById(R.id.buttonOpenMessages);
        this.f9934g0 = (ImageButton) findViewById(R.id.buttonDriving);
        this.f9935h0 = findViewById(R.id.viewGlowDriving);
        BadgeView badgeView = new BadgeView(this, findViewById(R.id.placeholderMessageBadge));
        this.f9930c0 = badgeView;
        this.f9936i0 = new View[]{this.f9933f0, this.f9932e0, this.f9934g0, this.f9931d0, this.f9935h0, (ViewGroup) badgeView.getParent()};
        this.f9943p0 = findViewById(R.id.content_frame);
        this.f9944q0 = (TextView) findViewById(R.id.textOffDuty);
        this.f9942o0 = (LeftDrawerFragment) m16711u().m16567i0(R.id.left_drawer);
        registerReceiver(this.f9941n0, new IntentFilter("ht.showMap"));
        C4512y.m10940b(this);
        EventBus.getDefault().register(this.f9925C0);
        this.f9923A0 = new SharedPreferences$OnSharedPreferenceChangeListenerC3691o(this);
        m13530u2();
        View findViewById = findViewById(R.id.textHowItWorks);
        this.f9937j0 = findViewById;
        findViewById.findViewById(R.id.buttonClose).setOnClickListener(new View.OnClickListener() { // from class: s5.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeMapScreen.this.m13562e2(view);
            }
        });
        this.f9937j0.findViewById(R.id.text).setOnClickListener(new View.OnClickListener() { // from class: s5.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeMapScreen.this.m13560f2(view);
            }
        });
        m22324b.registerOnSharedPreferenceChangeListener(this);
        if (bundle == null && (m22324b.getBoolean("activateOnLogin", false) || m22324b.getString("mode", null) == null)) {
            m22324b.edit().putBoolean("statusOnOff", true).apply();
        }
        this.f9934g0.setOnLongClickListener(new View.OnLongClickListener() { // from class: s5.c0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean m13558g2;
                m13558g2 = HomeMapScreen.this.m13558g2(view);
                return m13558g2;
            }
        });
        this.f9951x0 = (TextView) findViewById(R.id.textSpeed);
        int i = m22324b.getInt("app_launch_counter", 0);
        if (i < 2 && !this.f9940m0.m17130C(3)) {
            this.f9940m0.m17122K(3);
        }
        m22324b.edit().putInt("app_launch_counter", i + 1).apply();
        if (bundle == null) {
            C4925i.m9695H(findViewById(R.id.drawer_layout));
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        this.f9923A0.m13261l(menu);
        m13599B2();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p136m5.AbstractActivityC5510b, androidx.appcompat.app.ActivityC0646d, androidx.fragment.app.ActivityC2104e, android.app.Activity
    public void onDestroy() {
        m13409q0();
        unregisterReceiver(this.f9941n0);
        C0378d.m22324b().unregisterOnSharedPreferenceChangeListener(this);
        EventBus.getDefault().unregister(this.f9925C0);
        SharedPreferences$OnSharedPreferenceChangeListenerC3612c.m13839a().m13824p(this.f9926D0);
        SharedPreferences$OnSharedPreferenceChangeListenerC3612c.m13839a().m13834f();
        this.f9923A0.m13260m();
        this.f9927Z.m13276r();
        this.f9924B0.m13330b();
        this.f9929b0.m13304t();
        super.onDestroy();
    }

    public void onDriving(View view) {
        int i;
        try {
            boolean z = !this.f9950w0;
            this.f9950w0 = z;
            if (z) {
                view.startAnimation(C4917a.m9713c());
                this.f9951x0.setVisibility(0);
                this.f9934g0.setImageResource(R.drawable.vec_wheel_24dp);
                this.f9934g0.setBackgroundColor(getResources().getColor(R.color.blue));
                this.f9935h0.setVisibility(0);
                i = R.string.DrivingModeOn;
                m13523y1();
            } else {
                m13538q2();
                this.f9951x0.setVisibility(8);
                this.f9934g0.setImageResource(R.drawable.vec_wheel_asphalt_24dp);
                this.f9934g0.setBackgroundResource(R.drawable.custom_button_trans_light);
                this.f9935h0.setVisibility(8);
                i = R.string.DrivingModeOff;
                if (m13401y0()) {
                    m13406t0().animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().zoom(14.0f).target(m13406t0().getCameraPosition().target).tilt(10.0f).bearing(BitmapDescriptorFactory.HUE_RED).build()));
                }
            }
            C0378d.m22324b().edit().putLong("last_drivingview_switch_ts", System.currentTimeMillis()).apply();
            C4925i.m9696G(i, 0);
        } catch (Exception e) {
            C0375b.m22344m(e);
        }
    }

    @Override // p136m5.AbstractActivityC5510b, androidx.appcompat.app.ActivityC0646d, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            if (i == 82) {
                m13520z2();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        if (this.f9950w0) {
            onDriving(null);
        } else if (C7071t.m4318f(this)) {
            m13580S1();
        } else if (!this.f9927Z.m13280n().m12830D() && !this.f9927Z.m13280n().m12831C()) {
            if (this.f9940m0.m17130C(3)) {
                m13520z2();
            } else {
                finish();
            }
        } else {
            this.f9927Z.m13280n().m12809o();
        }
        return true;
    }

    public void onLayers(View view) {
        EnumC4478d.m11082g("layers");
        MainTabs.m13448l();
        this.f9927Z.m13286h();
        C7071t.m4323a(this);
    }

    @Override // com.hellotracks.screens.map.AbstractActivityC3663a, com.google.android.gms.maps.OnMapReadyCallback
    public void onMapReady(GoogleMap googleMap) {
        super.onMapReady(googleMap);
        Runnable runnable = this.f9946s0;
        if (runnable != null) {
            runnable.run();
            this.f9946s0 = null;
        }
        if (m7812T()) {
            m13594E1();
        }
        this.f9923A0.m13257p();
        googleMap.setOnMyLocationChangeListener(new C3677g());
        googleMap.setTrafficEnabled(C0378d.m22324b().getBoolean("show_traffic", false));
        this.f9971P.postDelayed(new Runnable() { // from class: s5.z
            @Override // java.lang.Runnable
            public final void run() {
                HomeMapScreen.this.m13556h2();
            }
        }, 300L);
        SharedPreferences$OnSharedPreferenceChangeListenerC3612c.m13839a().m13831i(googleMap);
        this.f9924B0.m13328d();
    }

    public void onMessages(View view) {
        EnumC4478d.m11082g("new_messages");
        startActivity(new Intent(this, MessagesScreen.class));
    }

    public void onMyLocation(View view) {
        this.f9927Z.m13284j();
        if (m7815Q() == null || !m13401y0()) {
            return;
        }
        m13406t0().animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.builder().zoom(16.0f).target(new LatLng(m7815Q().getLatitude(), m7815Q().getLongitude())).build()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.ActivityC2104e, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        m13582Q1(intent);
    }

    @Override // p136m5.AbstractActivityC5510b, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return true;
        }
        m13520z2();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p136m5.AbstractActivityC5510b, androidx.fragment.app.ActivityC2104e, android.app.Activity
    public void onPause() {
        super.onPause();
        SharedPreferences$OnSharedPreferenceChangeListenerC3612c.m13839a().m13829k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.ActivityC0646d, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.f9938k0.m21801k();
    }

    @Override // androidx.fragment.app.ActivityC2104e, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        new C4480f(this).m11072a(i, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p136m5.AbstractActivityC5510b, androidx.fragment.app.ActivityC2104e, android.app.Activity
    public void onResume() {
        this.f9929b0.m13302v();
        if (C0381f.m22291b().m22266s().length() > 0) {
            m13601A2(C0378d.m22324b(), false);
        } else {
            C3669c.m13390H(this);
        }
        this.f9971P.postDelayed(new Runnable() { // from class: s5.w
            @Override // java.lang.Runnable
            public final void run() {
                HomeMapScreen.this.m13554i2();
            }
        }, 500L);
        super.onResume();
        if (C0381f.m22291b().m22313G()) {
            C4673t.m10434f().m10436d(this, new C4673t.AbstractC4674a() { // from class: s5.d0
                @Override // p086h5.C4673t.AbstractC4674a
                /* renamed from: a */
                public final void mo4339a(boolean z) {
                    HomeMapScreen.this.m13552j2(z);
                }
            });
        }
        C4642c0.m10486d().m10487c(this);
        C4652h.m10477c().m10472h(this);
        SharedPreferences$OnSharedPreferenceChangeListenerC3612c.m13839a().m13827m();
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        Log.d("HomeMapScreen", "pref change of " + str);
        try {
            if (!m7809W()) {
                return;
            }
            if (!"statusOnOff".equals(str) && !"mode".equals(str) && !"username".equals(str)) {
                if ("show_traffic".equals(str) && m13401y0()) {
                    if (!m13401y0()) {
                        return;
                    }
                    m13406t0().setTrafficEnabled(C0378d.m22324b().getBoolean("show_traffic", false));
                    return;
                } else if ("map_type".equals(str) && m13401y0()) {
                    m13423X0();
                    return;
                } else if ("teams_filtered".equals(str) && m13401y0()) {
                    m13594E1();
                    return;
                } else if ("status_label".equals(str)) {
                    this.f9942o0.m13484c0();
                    return;
                } else if (!"availability".equals(str)) {
                    return;
                } else {
                    m13597C2();
                    return;
                }
            }
            C0378d.m22324b().edit().putLong("tracking_autostop_at", 0L).apply();
            if (m13401y0()) {
                m13430Q0();
            }
            m13601A2(sharedPreferences, true);
        } catch (Exception e) {
            C0375b.m22345l("", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p136m5.AbstractActivityC5510b, androidx.appcompat.app.ActivityC0646d, androidx.fragment.app.ActivityC2104e, android.app.Activity
    public void onStart() {
        super.onStart();
        SharedPreferences$OnSharedPreferenceChangeListenerC3612c.m13839a().m13826n();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p136m5.AbstractActivityC5510b, androidx.appcompat.app.ActivityC0646d, androidx.fragment.app.ActivityC2104e, android.app.Activity
    public void onStop() {
        if (C0381f.m22291b().m22305O()) {
            m7802d0();
        }
        super.onStop();
        m13538q2();
        SharedPreferences$OnSharedPreferenceChangeListenerC3612c.m13839a().m13825o();
    }

    /* renamed from: p2 */
    public void m13540p2() {
        C0378d.m22324b().edit().putInt("info_read", 1).apply();
        this.f9937j0.startAnimation(C4917a.m9711e());
        this.f9937j0.setVisibility(8);
        IntroScreen.m13609k0(this);
    }

    @Override // com.hellotracks.screens.map.AbstractActivityC3663a
    /* renamed from: r0 */
    public void mo13408r0() {
        if (this.f9940m0.m17130C(3)) {
            m13520z2();
        }
    }

    /* renamed from: r2 */
    public void m13536r2() {
        for (AbstractActivityC3663a.C3667d c3667d : (AbstractActivityC3663a.C3667d[]) this.f9974S.values().toArray(new AbstractActivityC3663a.C3667d[0])) {
            m13432O0(c3667d);
        }
    }

    @Override // com.hellotracks.screens.map.AbstractActivityC3663a
    /* renamed from: s0 */
    public void mo13407s0(final C7046k1 c7046k1, boolean z) {
        if (c7046k1.f18554i == null) {
            C0375b.m22352e("HomeMapScreen", "marker is null in createMarkerImageRequest");
            return;
        }
        C4472b m11093b = C4472b.m11093b();
        Bitmap m11094a = m11093b.m11094a(C4472b.EnumC4474b.Marker_url_ + c7046k1.f18548c);
        if (m11094a != null) {
            m13532t2(c7046k1, m11094a);
            C0375b.m22342o("HomeMapScreen", "marker icon from cache");
            return;
        }
        C0375b.m22342o("HomeMapScreen", "create marker image request " + c7046k1.f18549d);
        c7046k1.f18562q = true;
        C4485h.m11054l(c7046k1.f18548c, z, new AbstractC4834a() { // from class: s5.v
            @Override // p097i6.AbstractC4834a
            /* renamed from: a */
            public final void mo2622a(boolean z2, Object obj) {
                HomeMapScreen.this.m13575X1(c7046k1, z2, (Bitmap) obj);
            }
        });
    }

    /* renamed from: u2 */
    protected void m13530u2() {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        this.f9940m0 = drawerLayout;
        drawerLayout.setDrawerShadow(R.drawable.drawer_shadow, 8388611);
        C0637b c0637b = new C0637b(this, this.f9940m0, this.f9923A0.m13267f(), R.string.Open, R.string.Close);
        this.f9938k0 = c0637b;
        this.f9940m0.setDrawerListener(c0637b);
        this.f9938k0.m21803i(true);
    }

    /* renamed from: v2 */
    public void m13528v2() {
        LinkedList linkedList = new LinkedList();
        for (Marker marker : this.f9928a0.values()) {
            linkedList.add(marker.getPosition());
        }
        C7043j1.m4338a(m13406t0(), linkedList);
    }

    /* renamed from: w2 */
    public void m13526w2(int i) {
        mo13408r0();
        this.f9927Z.m13282l();
    }

    /* renamed from: x2 */
    public void m13524x2() {
        C7046k1 m13404v0 = m13404v0(C0381f.m22291b().m22267r());
        if (m13404v0 != null) {
            mo13427T0(m13404v0.f18554i, false);
        }
    }

    /* renamed from: y2 */
    public void m13522y2(String str, C2795i c2795i, boolean z) {
        AbstractActivityC3663a.C3667d c3667d = this.f9974S.get(Long.valueOf(c2795i.f9011a));
        if (c3667d != null) {
            if (!z) {
                return;
            }
            C7043j1.m4338a(m13406t0(), c3667d.f9992f);
            return;
        }
        m13536r2();
        AbstractActivityC3663a.C3667d m13596D1 = m13596D1(str, c2795i);
        if (!z) {
            return;
        }
        C7043j1.m4338a(m13406t0(), m13596D1.f9992f);
    }

    /* renamed from: z1 */
    public C7085w1 m13521z1(long j, Runnable runnable) {
        AbstractActivityC3663a.C3667d c3667d = this.f9974S.get(Long.valueOf(j));
        if (c3667d != null) {
            return C7085w1.m4301d().m4299f(c3667d.f9992f, runnable);
        }
        return null;
    }

    /* renamed from: z2 */
    protected void m13520z2() {
        if (this.f9940m0.m17130C(3)) {
            this.f9940m0.m17108d(3);
            return;
        }
        this.f9940m0.m17122K(3);
        if (C0381f.m22291b().m22315E()) {
            return;
        }
        C4684z.m10412f(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.hellotracks.screens.map.HomeMapScreen$b */
    /* loaded from: classes2.dex */
    public class C3660b {
        C3660b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void m13517c() {
            HomeMapScreen.this.m13592G1();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public /* synthetic */ void m13516d() {
            try {
                if (!HomeMapScreen.this.m7809W()) {
                    return;
                }
                C0375b.m22343n("force restart services");
                C4027f.m12258f();
                HomeMapScreen.this.m7807Y();
            } catch (Exception e) {
                C0375b.m22344m(e);
            }
        }

        public void onEventMainThread(C4916o c4916o) {
            if (!HomeMapScreen.this.m7809W()) {
                return;
            }
            HomeMapScreen.this.m13424W0(new LatLng(c4916o.f13409a, c4916o.f13410b), c4916o.f13411c, true);
            HomeMapScreen.this.mo13408r0();
        }

        public void onEventMainThread(LinkedList<C2919a> linkedList) {
            if (HomeMapScreen.this.m7809W()) {
                Runnable m13600B1 = HomeMapScreen.this.m13600B1(linkedList);
                if (HomeMapScreen.this.m13401y0()) {
                    m13600B1.run();
                } else {
                    HomeMapScreen.this.f9946s0 = m13600B1;
                }
            }
        }

        public void onEventMainThread(C4907f c4907f) {
            if (!HomeMapScreen.this.m7809W()) {
                return;
            }
            HomeMapScreen.this.m13593F1(c4907f.f13400a);
        }

        public void onEventMainThread(C4908g c4908g) {
            if (!HomeMapScreen.this.m7809W() || !c4908g.f13401a) {
                return;
            }
            C4695i.m10393g(new AbstractRunnableC4692f() { // from class: com.hellotracks.screens.map.e
                @Override // p087h6.AbstractRunnableC4692f, java.lang.Runnable
                public final void run() {
                    HomeMapScreen.C3660b.this.m13517c();
                }
            });
        }

        public void onEventMainThread(C4902a c4902a) {
            C7046k1[] c7046k1Arr;
            if (!HomeMapScreen.this.m7809W()) {
                return;
            }
            C0375b.m22343n("HMS api objected deleted: kind=" + c4902a.f13394a + " id=" + c4902a.f13395b);
            if (!C2927f.KIND.equals(c4902a.f13394a)) {
                return;
            }
            for (C7046k1 c7046k1 : (C7046k1[]) HomeMapScreen.this.f9972Q.values().toArray(new C7046k1[0])) {
                C2927f c2927f = c7046k1.f18561p;
                if (c2927f != null && c2927f.node_id == c4902a.f13395b) {
                    C0375b.m22343n("HMS api objected deleting marker");
                    HomeMapScreen.this.m13534s2(c7046k1, true);
                }
            }
        }

        public void onEventMainThread(C4911j c4911j) {
            if (!HomeMapScreen.this.m7809W()) {
                return;
            }
            if ("openProfile".equals(c4911j.f13405b)) {
                C3669c.m13388J(HomeMapScreen.this, c4911j.f13404a, c4911j.f13406c);
            } else if (!"removeMarkerFromMap".equals(c4911j.f13405b)) {
            } else {
                C7046k1 c7046k1 = HomeMapScreen.this.f9972Q.get(c4911j.f13404a);
                if (c7046k1 != null) {
                    HomeMapScreen.this.m13534s2(c7046k1, true);
                } else {
                    C0375b.m22353d("no entry to remove");
                }
            }
        }

        public void onEventMainThread(C6710a c6710a) {
            if (!HomeMapScreen.this.m7809W()) {
                return;
            }
            HomeMapScreen.this.m13602A1();
            HomeMapScreen.this.m13599B2();
            HomeMapScreen.this.f9971P.postDelayed(new Runnable() { // from class: com.hellotracks.screens.map.f
                @Override // java.lang.Runnable
                public final void run() {
                    HomeMapScreen.C3660b.this.m13516d();
                }
            }, 500L);
        }

        public void onEventMainThread(C4910i c4910i) {
            if (HomeMapScreen.this.m7809W()) {
                HomeMapScreen.this.f9924B0.m13331a().m3253A();
            }
        }

        public void onEventMainThread(C4913l c4913l) {
            if (!HomeMapScreen.this.m7809W()) {
                return;
            }
            View findViewById = HomeMapScreen.this.findViewById(R.id.contextualPerson);
            if (findViewById.getVisibility() != 0 || !(findViewById.getTag() instanceof String) || !c4913l.f13407a.equals(findViewById.getTag())) {
                return;
            }
            findViewById.findViewById(R.id.textPing).setVisibility(0);
        }
    }
}