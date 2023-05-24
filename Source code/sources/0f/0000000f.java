package com.hellotracks.screens.base;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import cn.pedant.SweetAlert.SweetAlertDialog;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.hellotracks.R;
import com.hellotracks.screens.base.AlertDialogScreen;
import com.hellotracks.screens.messaging.MessagesScreen;
import p006a5.C0375b;
import p056e5.C4155b;
import p076g5.C4469a;
import p107j6.C4925i;
import p120l.C5279b;
import p136m5.AbstractActivityC5510b;

/* loaded from: classes2.dex */
public class AlertDialogScreen extends AbstractActivityC5510b {

    /* renamed from: com.hellotracks.screens.base.AlertDialogScreen$a */
    /* loaded from: classes2.dex */
    public enum EnumC3617a {
        simple_message
    }

    /* renamed from: g0 */
    public static Intent m13793g0(Context context, Bundle bundle, EnumC3617a enumC3617a) {
        bundle.putString("alert_type", enumC3617a.name());
        Intent intent = new Intent(context, AlertDialogScreen.class);
        intent.putExtras(bundle);
        intent.setFlags(268435456);
        return intent;
    }

    /* renamed from: h0 */
    private int m13792h0(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (!Character.isDigit(charAt) && charAt != '.' && charAt != ',' && charAt != '-') {
                return i;
            }
            i++;
        }
        return str.length();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i0 */
    public /* synthetic */ void m13791i0(SweetAlertDialog sweetAlertDialog) {
        sweetAlertDialog.dismiss();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j0 */
    public /* synthetic */ void m13790j0(String str, String str2, SweetAlertDialog sweetAlertDialog) {
        sweetAlertDialog.dismiss();
        Intent intent = new Intent(this, MessagesScreen.class);
        intent.putExtra("account", str);
        intent.putExtra(AppMeasurementSdk.ConditionalUserProperty.NAME, str2);
        intent.addFlags(268435456);
        startActivity(intent);
        finish();
    }

    /* renamed from: k0 */
    private static void m13789k0(Context context, Bundle bundle, EnumC3617a enumC3617a) {
        context.startActivity(m13793g0(context, bundle, enumC3617a));
        if (!"silent".equals(bundle.getString("ring", ""))) {
            C4469a.m11103h();
        }
    }

    /* renamed from: l0 */
    public static void m13788l0(Context context, Bundle bundle) {
        m13789k0(context, bundle, EnumC3617a.simple_message);
    }

    /* renamed from: m0 */
    private void m13787m0(Bundle bundle) {
        final String string = bundle.getString("account");
        String string2 = bundle.getString("msg");
        final String string3 = bundle.getString("title");
        String string4 = bundle.getString("uri");
        if (C4155b.m11786f(bundle)) {
            new C5279b.C5280a().m8491a().m8492a(this, Uri.parse(string2));
            finish();
            return;
        }
        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(this, 0);
        sweetAlertDialog.setTitleText(string3);
        sweetAlertDialog.setCancelText(getString(R.string.Close));
        sweetAlertDialog.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() { // from class: m5.c
            @Override // cn.pedant.SweetAlert.SweetAlertDialog.OnSweetClickListener
            public final void onClick(SweetAlertDialog sweetAlertDialog2) {
                AlertDialogScreen.this.m13791i0(sweetAlertDialog2);
            }
        });
        sweetAlertDialog.setContentText(string2);
        sweetAlertDialog.setConfirmText(getString(R.string.Reply));
        sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() { // from class: m5.d
            @Override // cn.pedant.SweetAlert.SweetAlertDialog.OnSweetClickListener
            public final void onClick(SweetAlertDialog sweetAlertDialog2) {
                AlertDialogScreen.this.m13790j0(string, string3, sweetAlertDialog2);
            }
        });
        sweetAlertDialog.show();
        if (!C4155b.m11787e(bundle)) {
            return;
        }
        sweetAlertDialog.setConfirmText(getString(R.string.Open));
        try {
            int indexOf = string4.indexOf("q=") + 2;
            String[] split = string4.substring(indexOf, m13792h0(string4, indexOf)).split(",");
            C4925i.m9678q(sweetAlertDialog.getMapView(), Double.parseDouble(split[0]), Double.parseDouble(split[1]));
        } catch (Exception e) {
            C0375b.m22349h(e);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p136m5.AbstractActivityC5510b, androidx.fragment.app.ActivityC2104e, androidx.activity.ComponentActivity, androidx.core.app.ActivityC1600g, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().hasExtra("alert_type")) {
            if (!EnumC3617a.simple_message.name().equals(getIntent().getStringExtra("alert_type"))) {
                return;
            }
            m13787m0(getIntent().getExtras());
            return;
        }
        finish();
    }
}