package com.hellotracks.screens.map;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.location.Location;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PointOfInterest;
import com.google.android.gms.maps.model.Polyline;
import com.google.firebase.iid.ServiceStarter;
import com.google.maps.android.PolyUtil;
import com.google.maps.android.SphericalUtil;
import com.google.maps.android.collections.MarkerManager;
import com.google.maps.android.p038ui.IconGenerator;
import com.hellotracks.R;
import com.hellotracks.screens.map.AbstractActivityC3663a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import p006a5.C0375b;
import p006a5.C0378d;
import p006a5.C0381f;
import p021b6.C2795i;
import p067f6.C4247b;
import p077g6.C4485h;
import p077g6.C4490k;
import p077g6.C4503r;
import p077g6.C4512y;
import p087h6.AbstractRunnableC4692f;
import p087h6.AbstractRunnableC4697j;
import p087h6.C4695i;
import p087h6.C4699l;
import p096i5.C4825c;
import p107j6.C4925i;
import p136m5.AbstractActivityC5510b;
import p196s5.C7014a;
import p196s5.C7043j1;
import p196s5.C7046k1;
import p196s5.C7073t1;
import p206t5.C7416h;

/* renamed from: com.hellotracks.screens.map.a */
/* loaded from: classes2.dex */
public abstract class AbstractActivityC3663a extends AbstractActivityC5510b implements OnMapReadyCallback {

    /* renamed from: U */
    protected MarkerManager f9976U;

    /* renamed from: V */
    protected MarkerManager.Collection f9977V;

    /* renamed from: W */
    private SupportMapFragment f9978W;

    /* renamed from: X */
    private GoogleMap f9979X;

    /* renamed from: P */
    protected final Handler f9971P = new Handler();

    /* renamed from: Q */
    protected HashMap<String, C7046k1> f9972Q = new HashMap<>();

    /* renamed from: R */
    protected HashMap<Marker, C7046k1> f9973R = new HashMap<>();

    /* renamed from: S */
    protected TreeMap<Long, C3667d> f9974S = new TreeMap<>();

    /* renamed from: T */
    protected List<Marker> f9975T = new LinkedList();

    /* renamed from: Y */
    private final HashMap<String, C3665b> f9980Y = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.hellotracks.screens.map.a$a */
    /* loaded from: classes2.dex */
    public class C3664a implements GoogleMap.OnMarkerDragListener {
        C3664a() {
        }

        @Override // com.google.android.gms.maps.GoogleMap.OnMarkerDragListener
        public void onMarkerDrag(Marker marker) {
        }

        @Override // com.google.android.gms.maps.GoogleMap.OnMarkerDragListener
        public void onMarkerDragEnd(Marker marker) {
            C7046k1 c7046k1 = AbstractActivityC3663a.this.f9973R.get(marker);
            if (c7046k1 != null) {
                C3669c.m13350k0(c7046k1.f18546a, marker.getPosition().latitude, marker.getPosition().longitude);
            } else if (!AbstractActivityC3663a.this.f9975T.contains(marker) || !AbstractActivityC3663a.this.m7810V(false)) {
            } else {
                C7073t1.m4313c(AbstractActivityC3663a.this, marker, true);
            }
        }

        @Override // com.google.android.gms.maps.GoogleMap.OnMarkerDragListener
        public void onMarkerDragStart(Marker marker) {
            C4490k.m11024d(AbstractActivityC3663a.this, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.hellotracks.screens.map.a$b */
    /* loaded from: classes2.dex */
    public class C3665b {

        /* renamed from: a */
        Marker f9982a;

        /* renamed from: b */
        C4247b.EnumC4248a f9983b;

        private C3665b() {
        }

        /* synthetic */ C3665b(AbstractActivityC3663a abstractActivityC3663a, C3664a c3664a) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.hellotracks.screens.map.a$c */
    /* loaded from: classes2.dex */
    public class C3666c implements GoogleMap.InfoWindowAdapter {

        /* renamed from: a */
        private final View f9985a;

        C3666c() {
            this.f9985a = AbstractActivityC3663a.this.getLayoutInflater().inflate(R.layout.marker_info_person, (ViewGroup) null);
        }

        /* renamed from: a */
        private void m13399a(Marker marker, View view) {
            String title = marker.getTitle();
            TextView textView = (TextView) view.findViewById(R.id.title);
            if (!TextUtils.isEmpty(title)) {
                textView.setText(new SpannableString(title));
            } else {
                textView.setText("");
            }
            String snippet = marker.getSnippet();
            TextView textView2 = (TextView) view.findViewById(R.id.snippet);
            if (!TextUtils.isEmpty(snippet)) {
                textView2.setText(new SpannableString(snippet));
            } else {
                textView2.setText("");
            }
        }

        @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
        public View getInfoContents(Marker marker) {
            return null;
        }

        @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
        public View getInfoWindow(Marker marker) {
            if (AbstractActivityC3663a.this.f9975T.contains(marker)) {
                return null;
            }
            m13399a(marker, this.f9985a);
            return this.f9985a;
        }
    }

    /* renamed from: com.hellotracks.screens.map.a$d */
    /* loaded from: classes2.dex */
    public class C3667d {

        /* renamed from: a */
        final C2795i f9987a;

        /* renamed from: b */
        public Marker f9988b;

        /* renamed from: c */
        public Marker f9989c;

        /* renamed from: d */
        public Polyline f9990d;

        /* renamed from: e */
        public Polyline f9991e;

        /* renamed from: f */
        public List<LatLng> f9992f = null;

        /* renamed from: g */
        public String f9993g;

        /* renamed from: h */
        public int f9994h;

        public C3667d(C2795i c2795i) {
            this.f9987a = c2795i;
        }

        /* renamed from: a */
        public void m13398a() {
            Marker marker = this.f9988b;
            if (marker != null) {
                marker.remove();
            }
            Marker marker2 = this.f9989c;
            if (marker2 != null) {
                marker2.remove();
            }
            this.f9990d.remove();
            this.f9991e.remove();
            AbstractActivityC3663a.this.f9974S.remove(Long.valueOf(this.f9987a.f9011a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C0 */
    public static /* synthetic */ LatLng m13444C0(float f, LatLng latLng, LatLng latLng2) {
        double d = latLng2.latitude;
        double d2 = latLng.latitude;
        double d3 = f;
        double d4 = ((d - d2) * d3) + d2;
        double d5 = latLng2.longitude;
        double d6 = latLng.longitude;
        return new LatLng(d4, ((d5 - d6) * d3) + d6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D0 */
    public /* synthetic */ void m13443D0(PointOfInterest pointOfInterest) {
        m13424W0(pointOfInterest.latLng, pointOfInterest.name, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E0 */
    public /* synthetic */ boolean m13442E0(Marker marker) {
        if (!m13400z0(marker) && !this.f9980Y.containsKey(marker.getPosition().toString())) {
            mo13427T0(marker, false);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F0 */
    public /* synthetic */ void m13441F0(Marker marker) {
        C3667d[] c3667dArr;
        List<LatLng> list;
        C7046k1 c7046k1 = this.f9973R.get(marker);
        if (c7046k1 != null) {
            C3669c.m13388J(this, c7046k1.f18546a, c7046k1.f18549d);
            return;
        }
        for (C3667d c3667d : (C3667d[]) this.f9974S.values().toArray(new C3667d[0])) {
            long round = Math.round(c3667d.f9992f.get(0).latitude * 100000.0d);
            long round2 = Math.round(c3667d.f9992f.get(list.size() - 1).latitude * 100000.0d);
            long round3 = Math.round(marker.getPosition().latitude * 100000.0d);
            if (round == round3 || round2 == round3) {
                C7043j1.m4338a(m13406t0(), c3667d.f9992f);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G0 */
    public /* synthetic */ void m13440G0(LatLng latLng) {
        m13424W0(latLng, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I0 */
    public /* synthetic */ void m13438I0(C4247b[] c4247bArr) {
        if (!m7809W()) {
            return;
        }
        m13402x0(c4247bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0 */
    public /* synthetic */ void m13437J0() {
        final C4247b[] c4247bArr;
        if (C0381f.m22291b().m22307M()) {
            c4247bArr = C4825c.m9852f().m9848j(10000);
        } else {
            c4247bArr = C4825c.m9852f().m9845m(10000);
        }
        C4699l.m10386e(new AbstractRunnableC4697j() { // from class: s5.h
            @Override // p087h6.AbstractRunnableC4697j, java.lang.Runnable
            public final void run() {
                AbstractActivityC3663a.this.m13438I0(c4247bArr);
            }
        });
    }

    /* renamed from: S0 */
    private void m13428S0() {
        if (this.f9978W == null || m13401y0()) {
            return;
        }
        this.f9978W.getMapAsync(this);
    }

    /* renamed from: U0 */
    private void m13426U0(LatLng latLng, boolean z) {
        CameraPosition build = new CameraPosition.Builder().zoom(14.0f).target(latLng).tilt(30.0f).build();
        if (z) {
            m13406t0().animateCamera(CameraUpdateFactory.newCameraPosition(build));
        } else {
            m13406t0().moveCamera(CameraUpdateFactory.newCameraPosition(build));
        }
    }

    /* renamed from: n0 */
    private Marker m13412n0(LatLng latLng, String str, boolean z) {
        if (z) {
            m13434M0();
        }
        m13445B0(latLng);
        IconGenerator iconGenerator = new IconGenerator(this);
        iconGenerator.setStyle(6);
        iconGenerator.setContentRotation(-90);
        Bitmap makeIcon = iconGenerator.makeIcon(str);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.snippet(null);
        markerOptions.title(null).position(latLng).draggable(true).icon(BitmapDescriptorFactory.fromBitmap(makeIcon));
        Marker addMarker = this.f9977V.addMarker(markerOptions);
        this.f9975T.add(addMarker);
        return addMarker;
    }

    /* renamed from: x0 */
    private void m13402x0(C4247b[] c4247bArr) {
        boolean m22307M = C0381f.m22291b().m22307M();
        HashSet hashSet = new HashSet();
        int i = 0;
        for (int length = c4247bArr.length - 1; length >= 0; length--) {
            C4247b c4247b = c4247bArr[length];
            if ((m22307M || c4247b.m11627i()) && System.currentTimeMillis() - c4247b.f12208p <= C4503r.m10983t(14) && c4247b.f12189t < 150) {
                i++;
                if (i > 800) {
                    break;
                }
                LatLng latLng = new LatLng(c4247b.f12197n, c4247b.f12198o);
                hashSet.add(latLng.toString());
                String latLng2 = latLng.toString();
                boolean containsKey = this.f9980Y.containsKey(latLng2);
                if (containsKey) {
                    C3665b c3665b = this.f9980Y.get(latLng2);
                    if (c3665b.f9983b != c4247b.f12192w) {
                        c3665b.f9982a.remove();
                        this.f9980Y.remove(latLng2);
                        containsKey = false;
                    }
                }
                if (!containsKey) {
                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.position(latLng);
                    markerOptions.anchor(0.5f, 0.5f);
                    String format = C4503r.f12673a.format(Long.valueOf(c4247b.f12208p));
                    C4247b.EnumC4248a enumC4248a = c4247b.f12192w;
                    if (enumC4248a == C4247b.EnumC4248a.NEW) {
                        markerOptions.icon(C4485h.m11060f());
                        markerOptions.title(getString(R.string.UnsentWaypointAt, new Object[]{format}) + "");
                    } else if (enumC4248a == C4247b.EnumC4248a.QUEUED) {
                        markerOptions.icon(C4485h.m11061e());
                        markerOptions.title(getString(R.string.QueuedWaypointAt, new Object[]{format}) + "");
                    } else if (enumC4248a == C4247b.EnumC4248a.DELETED) {
                        markerOptions.title(getString(R.string.SentWaypointAt, new Object[]{format}) + "");
                        markerOptions.icon(C4485h.m11058h());
                    } else {
                        markerOptions.title(getString(R.string.UnknownStateForWaypointAt, new Object[]{format}) + "");
                        markerOptions.icon(C4485h.m11056j());
                    }
                    Marker addMarker = this.f9977V.addMarker(markerOptions);
                    C3665b c3665b2 = new C3665b(this, null);
                    c3665b2.f9982a = addMarker;
                    c3665b2.f9983b = c4247b.f12192w;
                    this.f9980Y.put(latLng.toString(), c3665b2);
                }
            }
        }
        Iterator<Map.Entry<String, C3665b>> it = this.f9980Y.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, C3665b> next = it.next();
            if (!hashSet.contains(next.getKey())) {
                next.getValue().f9982a.remove();
                it.remove();
            }
        }
    }

    /* renamed from: A0 */
    public void m13446A0(LatLng latLng) {
        try {
            m13406t0().animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(latLng).zoom(14.0f).tilt(30.0f).build()), ServiceStarter.ERROR_UNKNOWN, null);
            mo13408r0();
        } catch (Exception e) {
            C0375b.m22345l("AbstractMapScreen", e);
        }
    }

    /* renamed from: B0 */
    public void m13445B0(LatLng latLng) {
        try {
            m13406t0().animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(latLng).zoom(15.0f).tilt(50.0f).build()));
        } catch (Exception e) {
            C0375b.m22344m(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: K0 */
    public void m13439H0(GoogleMap googleMap, LatLng latLng) {
        Projection projection = googleMap.getProjection();
        Point screenLocation = projection.toScreenLocation(latLng);
        double computeDistanceBetween = SphericalUtil.computeDistanceBetween(projection.fromScreenLocation(screenLocation), projection.fromScreenLocation(new Point(screenLocation.x + C4925i.m9685j(8.0f, this), screenLocation.y)));
        for (C3667d c3667d : this.f9974S.values()) {
            if (PolyUtil.isLocationOnPath(latLng, c3667d.f9990d.getPoints(), false, computeDistanceBetween)) {
                C7043j1.m4338a(googleMap, c3667d.f9992f);
                return;
            }
        }
    }

    /* renamed from: L0 */
    protected void m13435L0(Marker marker, C7046k1 c7046k1) {
        c7046k1.f18554i = marker;
        this.f9973R.put(marker, c7046k1);
    }

    /* renamed from: M0 */
    public void m13434M0() {
        for (Marker marker : this.f9975T) {
            marker.remove();
        }
        this.f9975T.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: N0 */
    public void m13433N0(Marker marker) {
        if (marker != null) {
            C7046k1 remove = this.f9973R.remove(marker);
            if (remove != null) {
                this.f9972Q.remove(C4512y.m10931k(remove.f18546a));
                remove.f18554i = null;
            }
            marker.remove();
        }
    }

    /* renamed from: O0 */
    public void m13432O0(C3667d c3667d) {
        c3667d.m13398a();
    }

    /* renamed from: P0 */
    public abstract void mo13431P0();

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"MissingPermission"})
    /* renamed from: Q0 */
    public void m13430Q0() {
        if ((checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 || checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) && m13401y0()) {
            boolean z = !this.f9979X.isMyLocationEnabled();
            boolean m22304P = C0381f.m22291b().m22304P();
            this.f9979X.setMyLocationEnabled(m22304P);
            if (!z || !m22304P) {
                return;
            }
            m13425V0(false);
        }
    }

    /* renamed from: R0 */
    protected void m13429R0(final GoogleMap googleMap) {
        MapsInitializer.initialize(this);
        m13430Q0();
        googleMap.setIndoorEnabled(true);
        googleMap.setBuildingsEnabled(true);
        googleMap.setOnPoiClickListener(new GoogleMap.OnPoiClickListener() { // from class: s5.f
            @Override // com.google.android.gms.maps.GoogleMap.OnPoiClickListener
            public final void onPoiClick(PointOfInterest pointOfInterest) {
                AbstractActivityC3663a.this.m13443D0(pointOfInterest);
            }
        });
        googleMap.getUiSettings().setScrollGesturesEnabled(true);
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.getUiSettings().setMyLocationButtonEnabled(false);
        googleMap.getUiSettings().setMapToolbarEnabled(true);
        m13423X0();
        this.f9977V.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() { // from class: s5.e
            @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
            public final boolean onMarkerClick(Marker marker) {
                boolean m13442E0;
                m13442E0 = AbstractActivityC3663a.this.m13442E0(marker);
                return m13442E0;
            }
        });
        this.f9977V.setInfoWindowAdapter(new C3666c());
        this.f9977V.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() { // from class: s5.b
            @Override // com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener
            public final void onInfoWindowClick(Marker marker) {
                AbstractActivityC3663a.this.m13441F0(marker);
            }
        });
        this.f9977V.setOnMarkerDragListener(new C3664a());
        googleMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() { // from class: s5.d
            @Override // com.google.android.gms.maps.GoogleMap.OnMapLongClickListener
            public final void onMapLongClick(LatLng latLng) {
                AbstractActivityC3663a.this.m13440G0(latLng);
            }
        });
        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() { // from class: s5.c
            @Override // com.google.android.gms.maps.GoogleMap.OnMapClickListener
            public final void onMapClick(LatLng latLng) {
                AbstractActivityC3663a.this.m13439H0(googleMap, latLng);
            }
        });
        mo13431P0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: T0 */
    public abstract void mo13427T0(Marker marker, boolean z);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: V0 */
    public void m13425V0(boolean z) {
        if (!m13401y0()) {
            return;
        }
        LatLng latLng = null;
        try {
            if (m13406t0().isMyLocationEnabled() && m13406t0().getMyLocation() != null) {
                latLng = new LatLng(m13406t0().getMyLocation().getLatitude(), m13406t0().getMyLocation().getLongitude());
            } else {
                Location m7815Q = m7815Q();
                if (m7815Q != null) {
                    latLng = new LatLng(m7815Q.getLatitude(), m7815Q.getLongitude());
                }
            }
            if (latLng == null) {
                return;
            }
            m13426U0(latLng, z);
        } catch (Exception e) {
            C0375b.m22344m(e);
        }
    }

    /* renamed from: W0 */
    public void m13424W0(LatLng latLng, String str, boolean z) {
        String str2;
        if (str == null) {
            try {
                str2 = getString(R.string.CreatePlace);
            } catch (Exception e) {
                C0375b.m22345l("AbstractMapScreen", e);
                return;
            }
        } else {
            str2 = str;
        }
        Marker m13412n0 = m13412n0(latLng, str2, z);
        new C7416h((HomeMapScreen) this, latLng, str).m3336o();
        if (str == null) {
            C7073t1.m4313c(this, m13412n0, true);
        } else {
            m13412n0.setSnippet(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: X0 */
    public void m13423X0() {
        if (!m13401y0()) {
            C0375b.m22348i("map is not ready on updateMapType");
        } else {
            m13406t0().setMapType(C0378d.m22324b().getInt("map_type", 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Y0 */
    public void m13422Y0() {
        if (!m13401y0()) {
            C0375b.m22333x("avoid updateUnsetWaypoints if map is not ready");
        } else {
            C4695i.m10393g(new AbstractRunnableC4692f() { // from class: s5.g
                @Override // p087h6.AbstractRunnableC4692f, java.lang.Runnable
                public final void run() {
                    AbstractActivityC3663a.this.m13437J0();
                }
            });
        }
    }

    /* renamed from: m0 */
    public Marker m13413m0(C7046k1 c7046k1, boolean z, boolean z2) {
        C0375b.m22342o("AbstractMapScreen", "add marker " + c7046k1.f18549d);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(c7046k1.f18550e).title(c7046k1.f18549d);
        String str = c7046k1.f18552g;
        if (str != null) {
            markerOptions.snippet(str);
        }
        ImageView m11064b = C4485h.m11064b();
        IconGenerator iconGenerator = new IconGenerator(this);
        iconGenerator.setContentView(m11064b);
        iconGenerator.setStyle(2);
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(iconGenerator.makeIcon()));
        markerOptions.anchor(0.5f, 1.0f);
        if (!z && (c7046k1.m4335b() || c7046k1.m4333d())) {
            markerOptions.draggable(true);
        }
        Marker addMarker = this.f9977V.addMarker(markerOptions);
        m13435L0(addMarker, c7046k1);
        if (c7046k1.m4334c()) {
            mo13407s0(c7046k1, z2);
        }
        return addMarker;
    }

    /* renamed from: o0 */
    public void m13411o0(LatLng latLng, Marker marker, int i) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(marker, Property.of(Marker.class, LatLng.class, "position"), C7014a.f18506a, latLng);
        ofObject.setDuration(i);
        ofObject.setInterpolator(new LinearInterpolator());
        ofObject.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.ActivityC2104e, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1122) {
            m13428S0();
        }
    }

    @Override // p136m5.AbstractActivityC5510b
    public void onBack(View view) {
        finish();
    }

    public void onMapReady(GoogleMap googleMap) {
        this.f9979X = googleMap;
        MarkerManager markerManager = new MarkerManager(googleMap);
        this.f9976U = markerManager;
        this.f9977V = markerManager.newCollection();
        m13429R0(googleMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: p0 */
    public void m13410p0() {
        try {
            SupportMapFragment supportMapFragment = (SupportMapFragment) m16711u().m16567i0(R.id.map);
            this.f9978W = supportMapFragment;
            supportMapFragment.getMapAsync(this);
        } catch (Exception e) {
            Toast.makeText(this, (int) R.string.GoogleMapsNotInit, 1).show();
            C0375b.m22345l("map not initialized", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: q0 */
    public void m13409q0() {
        if (m13401y0()) {
            try {
                m13406t0().clear();
            } catch (IllegalArgumentException e) {
                C0375b.m22344m(e);
            }
        }
    }

    /* renamed from: r0 */
    public abstract void mo13408r0();

    /* renamed from: s0 */
    abstract void mo13407s0(C7046k1 c7046k1, boolean z);

    /* renamed from: t0 */
    public GoogleMap m13406t0() {
        return this.f9979X;
    }

    /* renamed from: u0 */
    public MarkerManager.Collection m13405u0() {
        return this.f9977V;
    }

    /* renamed from: v0 */
    public C7046k1 m13404v0(String str) {
        return this.f9972Q.get(str);
    }

    /* renamed from: w0 */
    public MarkerManager m13403w0() {
        return this.f9976U;
    }

    /* renamed from: y0 */
    public boolean m13401y0() {
        return (this.f9978W == null || this.f9979X == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /* renamed from: z0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m13400z0(com.google.android.gms.maps.model.Marker r6) {
        /*
            r5 = this;
            java.util.List<com.google.android.gms.maps.model.Marker> r0 = r5.f9975T
            boolean r0 = r0.contains(r6)
            r1 = 1
            if (r0 == 0) goto La
            return r1
        La:
            java.util.TreeMap<java.lang.Long, com.hellotracks.screens.map.a$d> r0 = r5.f9974S
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
        L14:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L41
            java.lang.Object r2 = r0.next()
            com.hellotracks.screens.map.a$d r2 = (com.hellotracks.screens.map.AbstractActivityC3663a.C3667d) r2
            com.google.android.gms.maps.model.Marker r3 = r2.f9988b
            java.lang.String r3 = r3.getId()
            java.lang.String r4 = r6.getId()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L40
            com.google.android.gms.maps.model.Marker r2 = r2.f9989c
            java.lang.String r2 = r2.getId()
            java.lang.String r3 = r6.getId()
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L14
        L40:
            return r1
        L41:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hellotracks.screens.map.AbstractActivityC3663a.m13400z0(com.google.android.gms.maps.model.Marker):boolean");
    }
}