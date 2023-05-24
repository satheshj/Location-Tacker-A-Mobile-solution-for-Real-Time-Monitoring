package com.hellotracks.screens.group;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.pedant.SweetAlert.SweetAlertDialog;
import com.hellotracks.App;
import com.hellotracks.R;
import com.hellotracks.screens.group.JoinGroupScreen;
import com.hellotracks.screens.map.HomeMapScreen;
import component.Button;
import component.InviteCodeView;
import org.json.JSONObject;
import p006a5.C0381f;
import p020b5.AbstractC2755l;
import p020b5.C2752j;
import p020b5.C2767s;
import p077g6.C4488i;
import p077g6.C4502q;
import p077g6.EnumC4478d;
import p086h5.C4661m;
import p107j6.C4925i;
import p136m5.AbstractActivityC5510b;

/* loaded from: classes2.dex */
public class JoinGroupScreen extends AbstractActivityC5510b {

    /* renamed from: P */
    private InviteCodeView f9881P;

    /* renamed from: Q */
    private LinearLayout f9882Q;

    /* renamed from: R */
    private TextView f9883R;

    /* renamed from: S */
    private String f9884S = "";

    /* renamed from: T */
    private Button f9885T;

    /* renamed from: U */
    private C3655b f9886U;

    /* renamed from: V */
    private boolean f9887V;

    /* renamed from: A0 */
    private void m13691A0() {
        EnumC4478d.join_group_clicked.m11088a();
        this.f9885T.setEnabled(false);
        JSONObject m7806Z = m7806Z();
        C4488i.m11031m(m7806Z, "inviteCode", this.f9884S);
        C2752j.m14641v("joingroup", m7806Z, new C2767s(new AbstractC2755l() { // from class: o5.l
            @Override // p020b5.AbstractC2755l
            /* renamed from: a */
            public final void mo6487a(Object obj) {
                JoinGroupScreen.this.m13671w0((JSONObject) obj);
            }
        }, new Runnable() { // from class: o5.q
            @Override // java.lang.Runnable
            public final void run() {
                JoinGroupScreen.this.m13670x0();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B0 */
    public void m13671w0(JSONObject jSONObject) {
        boolean m11003i = C4502q.m11003i((String) C4488i.m11042b(jSONObject, "groupUid", ""));
        if (m7809W()) {
            if (m11003i) {
                C4925i.m9699D(this, "", getString(R.string.JoinGroupSuccessful, new Object[]{this.f9886U.f9905b}), 2);
                finish();
            } else {
                C4925i.m9698E(this, R.string.SomethingWentWrong, 0, 3);
            }
        }
        if (m11003i) {
            EnumC4478d.join_group.m11088a();
        } else {
            EnumC4478d.join_group_failed.m11088a();
        }
    }

    /* renamed from: o0 */
    private boolean m13679o0(Intent intent) {
        Uri data = intent.getData();
        if (data == null || !C4502q.m11003i(data.getQuery())) {
            if (data == null) {
                return true;
            }
            startActivity(new Intent(this, HomeMapScreen.class));
            finish();
            return false;
        }
        String m13618d = C3657c.m13618d(data.getQuery());
        if (m13618d == null) {
            return true;
        }
        if (C0381f.m22291b().m22313G()) {
            this.f9881P.setCode(m13618d);
            return true;
        }
        C4661m.m10463c().m10458h(m13618d);
        startActivity(new Intent(this, HomeMapScreen.class));
        finish();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0 */
    public /* synthetic */ void m13678p0(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public /* synthetic */ void m13677q0(View view) {
        m13669y0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0 */
    public /* synthetic */ void m13676r0(View view) {
        startActivity(new Intent(App.m13901f(), CreateGroupScreen.class));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0 */
    public /* synthetic */ void m13675s0(String str, boolean z) {
        this.f9884S = str;
        C4661m.m10463c().m10457i(this, str, new C4661m.AbstractC4663b() { // from class: o5.p
            @Override // p086h5.C4661m.AbstractC4663b
            /* renamed from: a */
            public final void mo153a(JSONObject jSONObject, boolean z2) {
                JoinGroupScreen.this.m13668z0(jSONObject, z2);
            }
        }, z);
        if (z) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.f9881P.getWindowToken(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0 */
    public /* synthetic */ void m13674t0() {
        this.f9884S = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public /* synthetic */ void m13673u0(View view) {
        m13691A0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0 */
    public /* synthetic */ void m13672v0(SweetAlertDialog sweetAlertDialog) {
        sweetAlertDialog.dismiss();
        if (C0381f.m22291b().m22315E()) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0 */
    public /* synthetic */ void m13670x0() {
        this.f9885T.setEnabled(true);
    }

    /* renamed from: y0 */
    private void m13669y0() {
        EnumC4478d.join_group_cancel.m11088a();
        this.f9881P.m12686g();
        this.f9882Q.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z0 */
    public void m13668z0(JSONObject jSONObject, boolean z) {
        if (!m7809W()) {
            return;
        }
        C4661m.m10463c().m10459g();
        C3655b m13616f = C3657c.m13616f(jSONObject);
        this.f9886U = m13616f;
        if (m13616f.f9911h) {
            this.f9881P.m12686g();
            C4925i.m9699D(this, getString(R.string.JoinGroupAlreadyMember), this.f9886U.f9905b, 2);
        } else if (m13616f.f9910g) {
            EnumC4478d.join_group_viewed.m11088a();
            this.f9882Q.setVisibility(0);
            this.f9883R.setText(C3657c.m13619c(this.f9886U));
        } else if (!z) {
        } else {
            C4925i.m9699D(this, C3657c.m13621a(this.f9884S), C3657c.m13619c(this.f9886U), 3).setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() { // from class: o5.m
                @Override // cn.pedant.SweetAlert.SweetAlertDialog.OnSweetClickListener
                public final void onClick(SweetAlertDialog sweetAlertDialog) {
                    JoinGroupScreen.this.m13672v0(sweetAlertDialog);
                }
            });
            this.f9881P.m12686g();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p136m5.AbstractActivityC5510b, androidx.fragment.app.ActivityC2104e, androidx.activity.ComponentActivity, androidx.core.app.ActivityC1600g, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.screen_group_join);
        ((ImageView) findViewById(R.id.imageViewClose)).setOnClickListener(new View.OnClickListener() { // from class: o5.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JoinGroupScreen.this.m13678p0(view);
            }
        });
        ((Button) findViewById(R.id.buttonCancelJoin)).setOnClickListener(new View.OnClickListener() { // from class: o5.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JoinGroupScreen.this.m13677q0(view);
            }
        });
        Button button = (Button) findViewById(R.id.buttonNewInviteCode);
        button.setOnClickListener(new View.OnClickListener() { // from class: o5.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JoinGroupScreen.this.m13676r0(view);
            }
        });
        button.setEnabled(!C0381f.m22291b().m22315E());
        this.f9882Q = (LinearLayout) findViewById(R.id.layoutJoinGroup);
        InviteCodeView inviteCodeView = (InviteCodeView) findViewById(R.id.inviteCodeView);
        this.f9881P = inviteCodeView;
        inviteCodeView.setOnCodeComplete(new InviteCodeView.AbstractC3856a() { // from class: o5.n
            @Override // component.InviteCodeView.AbstractC3856a
            /* renamed from: a */
            public final void mo156a(String str, boolean z) {
                JoinGroupScreen.this.m13675s0(str, z);
            }
        });
        this.f9881P.setOnCodeIncomplete(new InviteCodeView.AbstractC3857b() { // from class: o5.o
            @Override // component.InviteCodeView.AbstractC3857b
            /* renamed from: a */
            public final void mo155a() {
                JoinGroupScreen.this.m13674t0();
            }
        });
        if (m13679o0(getIntent())) {
            String m10462d = C4661m.m10463c().m10462d();
            if (!isFinishing() && !this.f9881P.m12690c() && C4502q.m11003i(m10462d)) {
                this.f9887V = true;
                this.f9881P.setCode(m10462d);
            }
        }
        TextView textView = (TextView) findViewById(R.id.textMessage);
        this.f9883R = textView;
        textView.setText(C3657c.m13619c(null));
        Button button2 = (Button) findViewById(R.id.buttonJoin);
        this.f9885T = button2;
        button2.setOnClickListener(new View.OnClickListener() { // from class: o5.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JoinGroupScreen.this.m13673u0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.ActivityC2104e, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        m13679o0(intent);
    }
}