package com.hellotracks.screens.group;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.hellotracks.App;
import com.hellotracks.R;
import com.hellotracks.screens.group.CreateGroupScreen;
import component.Button;
import org.json.JSONObject;
import p020b5.AbstractC2755l;
import p020b5.C2752j;
import p020b5.C2767s;
import p077g6.C4488i;
import p077g6.C4499p;
import p077g6.C4502q;
import p136m5.AbstractActivityC5510b;

/* loaded from: classes2.dex */
public class CreateGroupScreen extends AbstractActivityC5510b {

    /* renamed from: P */
    private EditText f9879P;

    /* renamed from: Q */
    private Button f9880Q;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0 */
    public /* synthetic */ void m13699m0() {
        this.f9879P.setEnabled(true);
        this.f9880Q.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0 */
    public /* synthetic */ void m13698n0(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public /* synthetic */ void m13697o0(View view) {
        m13693s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0 */
    public /* synthetic */ boolean m13696p0(TextView textView, int i, KeyEvent keyEvent) {
        if (textView.length() > 0) {
            m13693s0();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public /* synthetic */ void m13695q0(Editable editable) {
        this.f9880Q.setEnabled(editable.toString().trim().length() > 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0 */
    public /* synthetic */ void m13694r0(InputMethodManager inputMethodManager) {
        inputMethodManager.showSoftInput(this.f9879P, 1);
    }

    /* renamed from: s0 */
    private void m13693s0() {
        this.f9879P.setEnabled(false);
        this.f9880Q.setEnabled(false);
        String obj = this.f9879P.getText().toString();
        JSONObject m7806Z = m7806Z();
        C4488i.m11031m(m7806Z, "groupName", obj);
        C4488i.m11031m(m7806Z, "inviteRemainingSeconds", 345600);
        C2752j.m14641v("createinvitecode", m7806Z, new C2767s(new AbstractC2755l() { // from class: o5.d
            @Override // p020b5.AbstractC2755l
            /* renamed from: a */
            public final void mo6487a(Object obj2) {
                CreateGroupScreen.this.m13700l0((JSONObject) obj2);
            }
        }, new Runnable() { // from class: o5.f
            @Override // java.lang.Runnable
            public final void run() {
                CreateGroupScreen.this.m13699m0();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0 */
    public void m13700l0(JSONObject jSONObject) {
        C3655b m13616f = C3657c.m13616f(jSONObject);
        if (C4502q.m11003i(m13616f.f9906c)) {
            Intent intent = new Intent(App.m13901f(), ShareGroupScreen.class);
            intent.putExtra("invitationCode", m13616f.f9906c);
            startActivity(intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p136m5.AbstractActivityC5510b, androidx.fragment.app.ActivityC2104e, androidx.activity.ComponentActivity, androidx.core.app.ActivityC1600g, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.screen_group_create);
        ((ImageView) findViewById(R.id.imageViewClose)).setOnClickListener(new View.OnClickListener() { // from class: o5.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateGroupScreen.this.m13698n0(view);
            }
        });
        Button button = (Button) findViewById(R.id.buttonContinue);
        this.f9880Q = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: o5.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateGroupScreen.this.m13697o0(view);
            }
        });
        this.f9880Q.setEnabled(false);
        EditText editText = (EditText) findViewById(R.id.textName);
        this.f9879P = editText;
        editText.setImeOptions(6);
        this.f9879P.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: o5.c
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean m13696p0;
                m13696p0 = CreateGroupScreen.this.m13696p0(textView, i, keyEvent);
                return m13696p0;
            }
        });
        this.f9879P.addTextChangedListener(C4499p.m11012a(new C4499p.AbstractC4500a() { // from class: o5.e
            @Override // p077g6.C4499p.AbstractC4500a
            /* renamed from: a */
            public final void mo154a(Editable editable) {
                CreateGroupScreen.this.m13695q0(editable);
            }
        }));
        this.f9879P.requestFocus();
        final InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        this.f9879P.postDelayed(new Runnable() { // from class: o5.g
            @Override // java.lang.Runnable
            public final void run() {
                CreateGroupScreen.this.m13694r0(inputMethodManager);
            }
        }, 100L);
    }
}