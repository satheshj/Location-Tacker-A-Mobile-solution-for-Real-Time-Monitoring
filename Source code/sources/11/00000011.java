package com.hellotracks.screens.group;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.hellotracks.R;
import com.hellotracks.screens.group.ManageGroupsScreen;
import com.hellotracks.screens.map.C3669c;
import component.Button;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
import p020b5.AbstractC2755l;
import p020b5.C2752j;
import p020b5.C2767s;
import p077g6.C4488i;
import p077g6.C4499p;
import p077g6.C4503r;
import p136m5.AbstractActivityC5510b;

/* loaded from: classes2.dex */
public class ManageGroupsScreen extends AbstractActivityC5510b {

    /* renamed from: P */
    private final ArrayList<C3654a> f9888P = new ArrayList<>();

    /* renamed from: Q */
    private LinearLayout f9889Q;

    /* renamed from: R */
    private View f9890R;

    /* renamed from: S */
    private EditText f9891S;

    /* renamed from: T */
    private ImageView f9892T;

    /* renamed from: U */
    private LinearLayout f9893U;

    /* renamed from: V */
    private Button f9894V;

    /* renamed from: W */
    private Button f9895W;

    /* renamed from: X */
    private C3654a f9896X;

    /* renamed from: Y */
    private String f9897Y;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A0 */
    public /* synthetic */ void m13667A0(JSONObject jSONObject) {
        m13639s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B0 */
    public /* synthetic */ void m13666B0(C3654a c3654a, View view) {
        m13654N0(c3654a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D0 */
    public /* synthetic */ void m13664D0(C3655b c3655b, View view) {
        m13657K0(c3655b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E0 */
    public /* synthetic */ void m13663E0(C3655b c3655b, View view) {
        C3669c.m13393E(this, c3655b.m13625a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F0 */
    public /* synthetic */ void m13662F0(C3655b c3655b, View view) {
        m13640r0(c3655b);
    }

    /* renamed from: G0 */
    private void m13661G0() {
        if (this.f9897Y != null) {
            finish();
        } else if (this.f9890R.getVisibility() == 0) {
            this.f9890R.setVisibility(8);
            this.f9896X = null;
        } else {
            finish();
        }
    }

    /* renamed from: H0 */
    private void m13660H0() {
        if (this.f9896X != null) {
            JSONObject m7806Z = m7806Z();
            C4488i.m11031m(m7806Z, "groupUid", this.f9896X.f9899a);
            C4488i.m11031m(m7806Z, "inviteRemainingSeconds", 345600);
            C2752j.m14641v("createinvitecode", m7806Z, new C2767s(new AbstractC2755l() { // from class: o5.a0
                @Override // p020b5.AbstractC2755l
                /* renamed from: a */
                public final void mo6487a(Object obj) {
                    ManageGroupsScreen.this.m13632z0((JSONObject) obj);
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I0 */
    public void m13665C0(String str) {
        if (this.f9896X != null) {
            JSONObject m7806Z = m7806Z();
            C4488i.m11031m(m7806Z, AppMeasurementSdk.ConditionalUserProperty.NAME, str);
            C4488i.m11031m(m7806Z, "account", this.f9896X.f9899a);
            C2752j.m14638y("editprofile", m7806Z);
        }
    }

    /* renamed from: J0 */
    private void m13658J0() {
        startActivity(new Intent(this, JoinGroupScreen.class));
    }

    /* renamed from: K0 */
    private void m13657K0(C3655b c3655b) {
        JSONObject m7806Z = m7806Z();
        C4488i.m11031m(m7806Z, "inviteCode", c3655b.f9906c);
        C4488i.m11031m(m7806Z, "inviteRemainingSeconds", 345600);
        C2752j.m14641v("editinvitecode", m7806Z, new C2767s(new AbstractC2755l() { // from class: o5.s
            @Override // p020b5.AbstractC2755l
            /* renamed from: a */
            public final void mo6487a(Object obj) {
                ManageGroupsScreen.this.m13667A0((JSONObject) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L0 */
    public void m13637u0(JSONObject jSONObject) {
        if (!m7809W()) {
            return;
        }
        this.f9888P.clear();
        this.f9888P.addAll(C3657c.m13617e(jSONObject));
        m13655M0();
        if (this.f9897Y != null) {
            Iterator<C3654a> it = this.f9888P.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C3654a next = it.next();
                if (this.f9897Y.equals(next.f9899a)) {
                    this.f9896X = next;
                    break;
                }
            }
        }
        if (this.f9896X == null) {
            return;
        }
        Iterator<C3654a> it2 = this.f9888P.iterator();
        while (it2.hasNext()) {
            C3654a next2 = it2.next();
            if (next2.f9899a.equals(this.f9896X.f9899a)) {
                m13654N0(next2);
            }
        }
    }

    /* renamed from: M0 */
    private void m13655M0() {
        String str;
        String str2;
        this.f9889Q.removeAllViews();
        Iterator<C3654a> it = this.f9888P.iterator();
        while (it.hasNext()) {
            final C3654a next = it.next();
            View inflate = getLayoutInflater().inflate(R.layout.item_group, (ViewGroup) this.f9889Q, false);
            ((TextView) inflate.findViewById(R.id.textInviteCodeGroupName)).setText(next.f9900b);
            TextView textView = (TextView) inflate.findViewById(R.id.textMemberCount);
            if (next.f9901c == 1) {
                str = getString(R.string.OneMember);
            } else {
                str = getString(R.string.XMembers, new Object[]{"" + next.f9901c});
            }
            textView.setText(str);
            TextView textView2 = (TextView) inflate.findViewById(R.id.textInviteCodeCount);
            if (next.f9901c == 1) {
                str2 = getString(R.string.OneActiveInviteCode);
            } else {
                str2 = getString(R.string.XActiveInviteCodes, new Object[]{"" + next.m13626a()});
            }
            textView2.setText(str2);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.hellotracks.screens.group.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ManageGroupsScreen.this.m13666B0(next, view);
                }
            });
            this.f9889Q.addView(inflate);
        }
        this.f9889Q.requestLayout();
    }

    /* renamed from: N0 */
    private void m13654N0(C3654a c3654a) {
        this.f9896X = c3654a;
        this.f9895W.setEnabled(c3654a.f9902d);
        this.f9890R.setVisibility(0);
        this.f9891S.setText(c3654a.f9900b);
        this.f9893U.removeAllViews();
        Iterator<C3655b> it = c3654a.f9903e.iterator();
        while (it.hasNext()) {
            final C3655b next = it.next();
            View inflate = getLayoutInflater().inflate(R.layout.item_invite_code, (ViewGroup) this.f9893U, false);
            TextView textView = (TextView) inflate.findViewById(R.id.textInvitationCode);
            textView.setTextColor(getColor(next.f9907d ? R.color.onyx : R.color.silver));
            textView.setText(C3657c.m13621a(next.f9906c));
            TextView textView2 = (TextView) inflate.findViewById(R.id.textExpiresAt);
            textView2.setText(next.f9908e ? getString(R.string.InviteCodeExpired) : getString(R.string.InviteCodeExpiration, new Object[]{C4503r.m10997f(next.f9913j)}));
            textView2.setTextColor(getColor(next.f9907d ? R.color.green : R.color.strongRed));
            Button button = (Button) inflate.findViewById(R.id.buttonRenew);
            button.setEnabled(next.f9912i);
            button.setOnClickListener(new View.OnClickListener() { // from class: o5.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ManageGroupsScreen.this.m13664D0(next, view);
                }
            });
            Button button2 = (Button) inflate.findViewById(R.id.buttonShare);
            button2.setEnabled(next.f9907d);
            button2.setOnClickListener(new View.OnClickListener() { // from class: o5.y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ManageGroupsScreen.this.m13663E0(next, view);
                }
            });
            ImageView imageView = (ImageView) inflate.findViewById(R.id.imageDelete);
            imageView.setEnabled(next.f9912i);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: o5.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ManageGroupsScreen.this.m13662F0(next, view);
                }
            });
            this.f9891S.setEnabled(next.f9912i);
            this.f9891S.addTextChangedListener(new C4499p(new C4499p.AbstractC4501b() { // from class: o5.t
                @Override // p077g6.C4499p.AbstractC4501b
                /* renamed from: a */
                public final void mo2602a(String str) {
                    ManageGroupsScreen.this.m13665C0(str);
                }
            }));
            this.f9893U.addView(inflate);
        }
    }

    /* renamed from: r0 */
    private void m13640r0(C3655b c3655b) {
        JSONObject m7806Z = m7806Z();
        C4488i.m11031m(m7806Z, "inviteCode", c3655b.f9906c);
        C4488i.m11031m(m7806Z, "inviteRemainingSeconds", 0);
        C2752j.m14641v("editinvitecode", m7806Z, new C2767s(new AbstractC2755l() { // from class: o5.c0
            @Override // p020b5.AbstractC2755l
            /* renamed from: a */
            public final void mo6487a(Object obj) {
                ManageGroupsScreen.this.m13638t0((JSONObject) obj);
            }
        }));
    }

    /* renamed from: s0 */
    private void m13639s0() {
        C2752j.m14641v("getgroups", m7806Z(), new C2767s(new AbstractC2755l() { // from class: o5.b0
            @Override // p020b5.AbstractC2755l
            /* renamed from: a */
            public final void mo6487a(Object obj) {
                ManageGroupsScreen.this.m13637u0((JSONObject) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0 */
    public /* synthetic */ void m13638t0(JSONObject jSONObject) {
        m13639s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0 */
    public /* synthetic */ void m13636v0(View view) {
        m13661G0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0 */
    public /* synthetic */ void m13635w0(View view) {
        m13660H0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0 */
    public /* synthetic */ void m13634x0(View view) {
        m13658J0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0 */
    public /* synthetic */ boolean m13633y0(TextView textView, int i, KeyEvent keyEvent) {
        m13639s0();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z0 */
    public /* synthetic */ void m13632z0(JSONObject jSONObject) {
        m13639s0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p136m5.AbstractActivityC5510b, androidx.fragment.app.ActivityC2104e, androidx.activity.ComponentActivity, androidx.core.app.ActivityC1600g, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.screen_group_manage);
        this.f9889Q = (LinearLayout) findViewById(R.id.layoutContainer);
        this.f9890R = findViewById(R.id.layoutGroup);
        this.f9891S = (EditText) findViewById(R.id.textGroupName);
        this.f9892T = (ImageView) findViewById(R.id.imageViewClose);
        this.f9893U = (LinearLayout) findViewById(R.id.layoutInviteCodesContainer);
        this.f9894V = (Button) findViewById(R.id.buttonJoinOrCreateGroup);
        this.f9895W = (Button) findViewById(R.id.buttonCreateInviteCode);
        this.f9890R.setVisibility(8);
        this.f9892T.setOnClickListener(new View.OnClickListener() { // from class: o5.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ManageGroupsScreen.this.m13636v0(view);
            }
        });
        this.f9895W.setOnClickListener(new View.OnClickListener() { // from class: o5.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ManageGroupsScreen.this.m13635w0(view);
            }
        });
        this.f9894V.setOnClickListener(new View.OnClickListener() { // from class: o5.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ManageGroupsScreen.this.m13634x0(view);
            }
        });
        this.f9891S.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: o5.z
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean m13633y0;
                m13633y0 = ManageGroupsScreen.this.m13633y0(textView, i, keyEvent);
                return m13633y0;
            }
        });
        this.f9897Y = getIntent().getStringExtra("selectedGroupUid");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p136m5.AbstractActivityC5510b, androidx.fragment.app.ActivityC2104e, android.app.Activity
    public void onResume() {
        super.onResume();
        m13639s0();
    }
}