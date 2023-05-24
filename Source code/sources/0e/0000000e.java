package com.hellotracks.screens.teams;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hellotracks.R;
import com.hellotracks.screens.group.JoinGroupScreen;
import com.hellotracks.screens.teams.C3797z;
import com.hellotracks.screens.teams.TeamsScreen;
import java.util.Objects;
import p006a5.C0381f;
import p077g6.C4490k;
import p077g6.C4495m;
import p136m5.AbstractActivityC5510b;

/* loaded from: classes2.dex */
public class TeamsScreen extends AbstractActivityC5510b implements C3797z.AbstractC3801d, C4490k.AbstractC4492b {

    /* renamed from: P */
    private final C3797z f10309P = C3797z.m12941c();

    /* renamed from: Q */
    private final C3792x f10310Q = C3792x.m12951v();

    /* renamed from: R */
    private RecyclerView f10311R;

    /* renamed from: S */
    private C3779p f10312S;

    /* renamed from: T */
    private View f10313T;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g0 */
    public /* synthetic */ void m13017g0(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h0 */
    public void m13016h0(View view) {
        startActivity(new Intent(this, JoinGroupScreen.class));
    }

    /* renamed from: i0 */
    private void m13015i0() {
        this.f10313T.setVisibility(this.f10309P.m12938f() ? 0 : 8);
    }

    @Override // com.hellotracks.screens.teams.C3797z.AbstractC3801d
    /* renamed from: a */
    public void mo12933a() {
        m13015i0();
        this.f10311R.getRecycledViewPool().m15961b();
        this.f10312S.notifyDataSetChanged();
    }

    @Override // p077g6.C4490k.AbstractC4492b
    /* renamed from: e */
    public void mo2356e(boolean z) {
        if (!z || !this.f10309P.m12938f()) {
            return;
        }
        this.f10310Q.m12955r();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p136m5.AbstractActivityC5510b, androidx.fragment.app.ActivityC2104e, androidx.activity.ComponentActivity, androidx.core.app.ActivityC1600g, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.screen_teams);
        this.f10313T = findViewById(R.id.emptyView);
        ((ImageView) findViewById(R.id.imageBack)).setOnClickListener(new View.OnClickListener() { // from class: a6.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TeamsScreen.this.m13017g0(view);
            }
        });
        final C3797z c3797z = this.f10309P;
        Objects.requireNonNull(c3797z);
        ((SearchView) findViewById(R.id.searchView)).setOnQueryTextListener(new C4495m(new C4495m.AbstractC4496a() { // from class: com.hellotracks.screens.teams.a0
            @Override // p077g6.C4495m.AbstractC4496a
            /* renamed from: a */
            public final void mo11017a(String str) {
                C3797z.this.m12936h(str);
            }
        }));
        View findViewById = findViewById(R.id.layoutCreateOrJoinTeam);
        findViewById.setVisibility(C0381f.m22291b().m22315E() ? 8 : 0);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: a6.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TeamsScreen.this.m13016h0(view);
            }
        });
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        this.f10311R = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView recyclerView2 = this.f10311R;
        C3779p c3779p = new C3779p(this);
        this.f10312S = c3779p;
        recyclerView2.setAdapter(c3779p);
        this.f10309P.m12935i(this);
        m13015i0();
        C4490k.m11023e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p136m5.AbstractActivityC5510b, androidx.appcompat.app.ActivityC0646d, androidx.fragment.app.ActivityC2104e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f10309P.m12935i(null);
        this.f10309P.m12936h("");
        C4490k.m11022f(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p136m5.AbstractActivityC5510b, androidx.fragment.app.ActivityC2104e, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f10310Q.m12955r();
    }
}