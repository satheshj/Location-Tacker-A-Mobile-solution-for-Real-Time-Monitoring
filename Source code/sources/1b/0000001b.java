package com.hellotracks.screens.places;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import androidx.core.graphics.drawable.C1679a;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hellotracks.R;
import com.hellotracks.screens.places.C3734t;
import com.hellotracks.screens.places.PlacesScreen;
import java.util.Objects;
import p006a5.C0381f;
import p077g6.C4490k;
import p077g6.C4495m;
import p136m5.AbstractActivityC5510b;

/* loaded from: classes2.dex */
public class PlacesScreen extends AbstractActivityC5510b implements C4490k.AbstractC4492b {

    /* renamed from: P */
    private final C3734t f10091P;

    /* renamed from: Q */
    private final C3731r f10092Q;

    /* renamed from: R */
    private final C3734t f10093R;

    /* renamed from: S */
    private final C3706a0 f10094S;

    /* renamed from: T */
    private final C3729q f10095T;

    /* renamed from: U */
    private ViewGroup f10096U;

    /* renamed from: V */
    private ViewGroup f10097V;

    /* renamed from: W */
    private ViewGroup f10098W;

    /* renamed from: X */
    private ViewGroup f10099X;

    /* renamed from: Y */
    private ViewGroup f10100Y;

    /* renamed from: Z */
    private RecyclerView f10101Z;

    /* renamed from: a0 */
    private RecyclerView f10102a0;

    /* renamed from: b0 */
    private C3727p f10103b0;

    /* renamed from: c0 */
    private C3713g f10104c0;

    /* renamed from: d0 */
    private View f10105d0;

    /* renamed from: e0 */
    private TextView f10106e0;

    /* renamed from: f0 */
    private TextView f10107f0;

    /* renamed from: g0 */
    private TextView f10108g0;

    /* renamed from: h0 */
    private TextView f10109h0;

    /* renamed from: i0 */
    private TextView f10110i0;

    /* renamed from: j0 */
    private TextView f10111j0;

    /* renamed from: k0 */
    private TextView f10112k0;

    /* renamed from: l0 */
    private View f10113l0;

    /* renamed from: m0 */
    private SearchView f10114m0;

    /* renamed from: n0 */
    private boolean f10115n0 = true;

    /* renamed from: o0 */
    private boolean f10116o0 = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.hellotracks.screens.places.PlacesScreen$a */
    /* loaded from: classes2.dex */
    public class C3704a implements SearchView.OnQueryTextListener {
        C3704a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ void m13200b() {
            PlacesScreen.this.f10114m0.clearFocus();
        }

        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            if (str.length() > 0) {
                PlacesScreen.this.f10095T.m13140m(str);
            } else {
                PlacesScreen.this.f10114m0.post(new Runnable() { // from class: com.hellotracks.screens.places.x
                    @Override // java.lang.Runnable
                    public final void run() {
                        PlacesScreen.C3704a.this.m13200b();
                    }
                });
                PlacesScreen.this.f10094S.m13189k();
            }
            PlacesScreen.this.m13224B0();
            return false;
        }

        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            PlacesScreen.this.f10114m0.setQuery("", false);
            PlacesScreen.this.f10114m0.clearFocus();
            return false;
        }
    }

    public PlacesScreen() {
        C3734t c3734t = new C3734t();
        this.f10091P = c3734t;
        this.f10092Q = new C3731r(c3734t);
        C3734t c3734t2 = new C3734t();
        this.f10093R = c3734t2;
        this.f10094S = new C3706a0(c3734t2);
        this.f10095T = new C3729q(c3734t2);
    }

    /* renamed from: A0 */
    private void m13225A0() {
        this.f10098W.setVisibility(C0381f.m22291b().m22262w() ? 0 : 8);
        int color = getResources().getColor(R.color.green);
        int color2 = getResources().getColor(R.color.asbestos);
        if (!this.f10115n0) {
            color2 = color;
            color = color2;
        }
        this.f10108g0.setTextColor(color);
        C1679a.m18244n(C1679a.m18240r(this.f10108g0.getCompoundDrawables()[0]), color);
        this.f10109h0.setTextColor(color2);
        C1679a.m18244n(C1679a.m18240r(this.f10109h0.getCompoundDrawables()[0]), color2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B0 */
    public void m13224B0() {
        int i;
        m13202z0();
        m13225A0();
        int i2 = 0;
        this.f10096U.setVisibility(this.f10115n0 ? 0 : 8);
        this.f10097V.setVisibility(this.f10115n0 ? 8 : 0);
        TextView textView = this.f10106e0;
        if (this.f10115n0) {
            i = R.string.MyPlaces;
        } else {
            i = this.f10116o0 ? R.string.NewPlace : R.string.AddPlace;
        }
        textView.setText(i);
        this.f10112k0.setVisibility(this.f10116o0 ? 8 : 0);
        this.f10113l0.setVisibility(this.f10116o0 ? 8 : 0);
        this.f10111j0.setVisibility(this.f10116o0 ? 8 : 0);
        TextView textView2 = this.f10110i0;
        if (this.f10095T.m13143j()) {
            i2 = 8;
        }
        textView2.setVisibility(i2);
    }

    /* renamed from: o0 */
    private View.OnFocusChangeListener m13213o0() {
        return new View.OnFocusChangeListener() { // from class: x5.d
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                PlacesScreen.this.m13212p0(view, z);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0 */
    public /* synthetic */ void m13212p0(View view, boolean z) {
        this.f10116o0 = z;
        if (z) {
            this.f10093R.m13130b();
            this.f10093R.m13125g();
        }
        m13224B0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public /* synthetic */ void m13211q0(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0 */
    public /* synthetic */ void m13210r0(View view) {
        m13204x0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0 */
    public /* synthetic */ void m13209s0(View view) {
        m13205w0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0 */
    public void m13208t0() {
        m13202z0();
        this.f10101Z.getRecycledViewPool().m15961b();
        this.f10103b0.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public void m13207u0() {
        this.f10102a0.getRecycledViewPool().m15961b();
        this.f10104c0.notifyDataSetChanged();
    }

    /* renamed from: v0 */
    private SearchView.OnQueryTextListener m13206v0() {
        return new C3704a();
    }

    /* renamed from: w0 */
    private void m13205w0() {
        this.f10115n0 = false;
        m13224B0();
    }

    /* renamed from: x0 */
    private void m13204x0() {
        this.f10115n0 = true;
        m13224B0();
    }

    /* renamed from: z0 */
    private void m13202z0() {
        String str;
        this.f10105d0.setVisibility((!this.f10115n0 || !this.f10091P.m13127e()) ? 8 : 0);
        TextView textView = this.f10107f0;
        if (this.f10091P.m13126f()) {
            str = getString(R.string.PlacesEmptyDesc);
        } else {
            str = getString(R.string.Connecting);
        }
        textView.setText(str);
    }

    @Override // p077g6.C4490k.AbstractC4492b
    /* renamed from: e */
    public void mo2356e(boolean z) {
        if (!z || !this.f10091P.m13127e()) {
            return;
        }
        this.f10092Q.m13135e();
        this.f10094S.m13189k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p136m5.AbstractActivityC5510b, androidx.fragment.app.ActivityC2104e, androidx.activity.ComponentActivity, androidx.core.app.ActivityC1600g, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().hasExtra("openAsAddPlace")) {
            this.f10115n0 = !getIntent().getBooleanExtra("openAsAddPlace", false);
        }
        setContentView(R.layout.screen_places);
        this.f10105d0 = findViewById(R.id.emptyView);
        this.f10107f0 = (TextView) findViewById(R.id.textEmpty);
        ((ImageView) findViewById(R.id.imageBack)).setOnClickListener(new View.OnClickListener() { // from class: x5.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlacesScreen.this.m13211q0(view);
            }
        });
        this.f10106e0 = (TextView) findViewById(R.id.textTitle);
        this.f10096U = (ViewGroup) findViewById(R.id.layoutPlacesContent);
        this.f10097V = (ViewGroup) findViewById(R.id.layoutSearchPlaceContent);
        this.f10098W = (ViewGroup) findViewById(R.id.layoutTabs);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.tabPlaces);
        this.f10099X = viewGroup;
        viewGroup.setOnClickListener(new View.OnClickListener() { // from class: x5.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlacesScreen.this.m13210r0(view);
            }
        });
        ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.tabAddPlace);
        this.f10100Y = viewGroup2;
        viewGroup2.setOnClickListener(new View.OnClickListener() { // from class: x5.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlacesScreen.this.m13209s0(view);
            }
        });
        this.f10108g0 = (TextView) findViewById(R.id.textTabPlaces);
        this.f10109h0 = (TextView) findViewById(R.id.textTabAddPlace);
        this.f10110i0 = (TextView) findViewById(R.id.textSearchInfo);
        this.f10111j0 = (TextView) findViewById(R.id.textSearchTitle);
        this.f10112k0 = (TextView) findViewById(R.id.textTeamPlacesTitle);
        this.f10113l0 = findViewById(R.id.searchDivider);
        final C3731r c3731r = this.f10092Q;
        Objects.requireNonNull(c3731r);
        ((SearchView) findViewById(R.id.filterPlaceView)).setOnQueryTextListener(new C4495m(new C4495m.AbstractC4496a() { // from class: com.hellotracks.screens.places.w
            @Override // p077g6.C4495m.AbstractC4496a
            /* renamed from: a */
            public final void mo11017a(String str) {
                C3731r.this.m13134f(str);
            }
        }));
        SearchView searchView = (SearchView) findViewById(R.id.searchPlaceView);
        this.f10114m0 = searchView;
        searchView.setImeOptions(6);
        this.f10114m0.setOnQueryTextListener(m13206v0());
        this.f10114m0.setOnQueryTextFocusChangeListener(m13213o0());
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.placesRecyclerView);
        this.f10101Z = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView recyclerView2 = this.f10101Z;
        C3727p c3727p = new C3727p(this, this.f10091P);
        this.f10103b0 = c3727p;
        recyclerView2.setAdapter(c3727p);
        RecyclerView recyclerView3 = (RecyclerView) findViewById(R.id.searchPlaceRecyclerView);
        this.f10102a0 = recyclerView3;
        recyclerView3.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView recyclerView4 = this.f10102a0;
        C3713g c3713g = new C3713g(this, this.f10093R, this.f10094S);
        this.f10104c0 = c3713g;
        recyclerView4.setAdapter(c3713g);
        this.f10091P.m13123i(new C3734t.AbstractC3736b() { // from class: com.hellotracks.screens.places.u
            @Override // com.hellotracks.screens.places.C3734t.AbstractC3736b
            /* renamed from: a */
            public final void mo13121a() {
                PlacesScreen.this.m13208t0();
            }
        });
        this.f10093R.m13123i(new C3734t.AbstractC3736b() { // from class: com.hellotracks.screens.places.v
            @Override // com.hellotracks.screens.places.C3734t.AbstractC3736b
            /* renamed from: a */
            public final void mo13121a() {
                PlacesScreen.this.m13207u0();
            }
        });
        m13224B0();
        C4490k.m11023e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p136m5.AbstractActivityC5510b, androidx.appcompat.app.ActivityC0646d, androidx.fragment.app.ActivityC2104e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C4490k.m11022f(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p136m5.AbstractActivityC5510b, androidx.fragment.app.ActivityC2104e, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f10092Q.m13135e();
        this.f10094S.m13189k();
    }

    /* renamed from: y0 */
    public void m13203y0(String str) {
        this.f10114m0.setQuery(str, false);
        this.f10114m0.requestFocus();
    }
}