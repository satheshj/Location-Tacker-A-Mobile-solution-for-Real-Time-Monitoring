package com.hellotracks.screens.map;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.drawable.C1679a;
import com.hellotracks.R;
import com.hellotracks.controllers.SharedPreferences$OnSharedPreferenceChangeListenerC3612c;
import com.hellotracks.screens.map.MainTabs;
import de.greenrobot.event.EventBus;
import p006a5.C0378d;
import p006a5.C0381f;
import p020b5.C2758o;
import p106j5.C4908g;
import p106j5.C4909h;
import p106j5.C4914m;
import p106j5.C4915n;
import p186r5.C6710a;

/* loaded from: classes2.dex */
public class MainTabs extends LinearLayout implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: n */
    private TextView f9969n;

    /* renamed from: o */
    private TextView f9970o;

    public MainTabs(Context context) {
        super(context);
    }

    /* renamed from: d */
    public static boolean m13456d() {
        return "jobs".equals(C0378d.m22324b().getString("tab_active", "map"));
    }

    /* renamed from: e */
    public static boolean m13455e() {
        return "map".equals(C0378d.m22324b().getString("tab_active", "map"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void m13453g(View view) {
        m13450j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ void m13452h(View view) {
        m13451i();
    }

    /* renamed from: i */
    private void m13451i() {
        if (!m13456d()) {
            m13449k();
            EventBus.getDefault().post(new C4914m());
        } else {
            EventBus.getDefault().post(new C4915n());
        }
        C2758o.m14631Q();
    }

    /* renamed from: j */
    private void m13450j() {
        m13448l();
        SharedPreferences$OnSharedPreferenceChangeListenerC3612c.m13839a().m13838b().m13580S1();
    }

    /* renamed from: k */
    public static void m13449k() {
        C0378d.m22324b().edit().putString("tab_active", "jobs").apply();
    }

    /* renamed from: l */
    public static void m13448l() {
        C0378d.m22324b().edit().putString("tab_active", "map").apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m13454f() {
        if (!C0381f.m22291b().m22315E() && C0378d.m22324b().getBoolean("tab_jobs_hidden", false)) {
            setVisibility(8);
            m13448l();
            return;
        }
        setVisibility(0);
        int color = getResources().getColor(R.color.green);
        int color2 = getResources().getColor(R.color.asbestos);
        if (m13456d()) {
            color2 = color;
            color = color2;
        }
        this.f9969n.setTextColor(color);
        C1679a.m18244n(C1679a.m18240r(this.f9969n.getCompoundDrawables()[0]), color);
        this.f9970o.setCompoundDrawablesWithIntrinsicBounds(R.drawable.vec_appointment, 0, 0, 0);
        this.f9970o.setTextColor(color2);
        C1679a.m18244n(C1679a.m18240r(this.f9970o.getCompoundDrawables()[0]), color2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        C0378d.m22324b().registerOnSharedPreferenceChangeListener(this);
        EventBus.getDefault().register(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0378d.m22324b().unregisterOnSharedPreferenceChangeListener(this);
        EventBus.getDefault().unregister(this);
    }

    public void onEventMainThread(C4909h c4909h) {
        this.f9970o.setCompoundDrawablesWithIntrinsicBounds(R.drawable.vec_refresh_02_24dp, 0, 0, 0);
        C1679a.m18244n(C1679a.m18240r(this.f9970o.getCompoundDrawables()[0]), getResources().getColor(R.color.green));
        this.f9970o.postDelayed(new Runnable() { // from class: s5.i1
            @Override // java.lang.Runnable
            public final void run() {
                MainTabs.this.m13454f();
            }
        }, 2000L);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        findViewById(R.id.tabMap).setOnClickListener(new View.OnClickListener() { // from class: s5.g1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainTabs.this.m13453g(view);
            }
        });
        findViewById(R.id.tabJobs).setOnClickListener(new View.OnClickListener() { // from class: s5.h1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainTabs.this.m13452h(view);
            }
        });
        this.f9969n = (TextView) findViewById(R.id.textTabMap);
        this.f9970o = (TextView) findViewById(R.id.textTabJobs);
        m13454f();
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("tab_active".equals(str) || "tab_jobs_hidden".equals(str)) {
            m13454f();
        }
    }

    public MainTabs(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MainTabs(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onEventMainThread(C4908g c4908g) {
        m13454f();
    }

    public void onEventMainThread(C6710a c6710a) {
        m13454f();
    }
}