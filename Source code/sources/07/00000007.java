package com.hellotracks.screens.login;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import cn.pedant.SweetAlert.SweetAlertDialog;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hellotracks.R;
import com.hellotracks.screens.login.LoginScreen;
import com.hellotracks.screens.map.C3669c;
import de.greenrobot.event.EventBus;
import p006a5.C0378d;
import p006a5.C0381f;
import p077g6.EnumC4478d;
import p136m5.AbstractActivityC5510b;
import p186r5.C6710a;
import p186r5.C6714e;

/* loaded from: classes2.dex */
public class LoginScreen extends AbstractActivityC5510b {

    /* renamed from: P */
    private AutoCompleteTextView f9921P;

    /* renamed from: Q */
    private EditText f9922Q;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g0 */
    public /* synthetic */ boolean m13606g0(TextView textView, int i, KeyEvent keyEvent) {
        onLogin(textView);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h0 */
    public /* synthetic */ void m13605h0(CompoundButton compoundButton, boolean z) {
        TransformationMethod transformationMethod;
        EditText editText = this.f9922Q;
        if (z) {
            transformationMethod = HideReturnsTransformationMethod.getInstance();
        } else {
            transformationMethod = PasswordTransformationMethod.getInstance();
        }
        editText.setTransformationMethod(transformationMethod);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // p136m5.AbstractActivityC5510b
    public void onBack(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p136m5.AbstractActivityC5510b, androidx.fragment.app.ActivityC2104e, androidx.activity.ComponentActivity, androidx.core.app.ActivityC1600g, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        setContentView(R.layout.screen_login);
        EditText editText = (EditText) findViewById(R.id.passwordText);
        this.f9922Q = editText;
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: r5.c
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean m13606g0;
                m13606g0 = LoginScreen.this.m13606g0(textView, i, keyEvent);
                return m13606g0;
            }
        });
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, 17367050, C0378d.m22324b().getString("userlist", "").split(","));
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.userText);
        this.f9921P = autoCompleteTextView;
        autoCompleteTextView.setAdapter(arrayAdapter);
        EventBus.getDefault().register(this, C6710a.class, new Class[0]);
        if (getIntent() != null && getIntent().hasExtra("username")) {
            this.f9921P.setText(getIntent().getStringExtra("username"));
            if (getIntent().hasExtra("password")) {
                this.f9922Q.setText(getIntent().getStringExtra("password"));
                onLogin(this.f9922Q);
            }
        }
        this.f9921P.setText(C0381f.m22291b().m22266s());
        this.f9922Q.setText("");
        ((CheckBox) findViewById(R.id.showPasswordCheckBox)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: r5.b
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                LoginScreen.this.m13605h0(compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p136m5.AbstractActivityC5510b, androidx.appcompat.app.ActivityC0646d, androidx.fragment.app.ActivityC2104e, android.app.Activity
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    public void onEventMainThread(C6710a c6710a) {
        finish();
    }

    public void onForgotPassword(View view) {
        C3669c.m13373Y(this, C0381f.m22291b().m22266s());
    }

    @Override // p136m5.AbstractActivityC5510b, androidx.appcompat.app.ActivityC0646d, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            onBack(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void onLogin(View view) {
        EnumC4478d.m11083f("credentials", FirebaseAnalytics.Event.LOGIN, "");
        String trim = this.f9921P.getText().toString().trim();
        String trim2 = this.f9922Q.getText().toString().trim();
        if (trim.length() >= 4 && trim2.length() >= 6) {
            new C6714e(this, false).m5084k(trim, trim2);
            return;
        }
        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(this, 3);
        sweetAlertDialog.setTitleText(getString(R.string.login));
        sweetAlertDialog.setContentText(getString(R.string.enterUsernameAndPasswordToLogin));
        sweetAlertDialog.setCancelable(true);
        sweetAlertDialog.show();
    }
}