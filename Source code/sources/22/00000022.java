package com.hellotracks.screens.other;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.hellotracks.R;
import com.hellotracks.screens.map.C3669c;
import com.hellotracks.screens.map.SharedPreferences$OnSharedPreferenceChangeListenerC3678h;
import component.Button;
import p077g6.C4512y;
import p086h5.C4678w;
import p136m5.AbstractActivityC5510b;

/* loaded from: classes2.dex */
public class PermissionsScreen extends AbstractActivityC5510b {

    /* renamed from: P */
    private final SharedPreferences$OnSharedPreferenceChangeListenerC3678h f10072P = SharedPreferences$OnSharedPreferenceChangeListenerC3678h.m13315i();

    /* renamed from: Q */
    private Button f10073Q;

    /* renamed from: R */
    private Button f10074R;

    /* renamed from: S */
    private Button f10075S;

    /* renamed from: T */
    private ImageView f10076T;

    /* renamed from: U */
    private ImageView f10077U;

    /* renamed from: V */
    private TextView f10078V;

    /* renamed from: i0 */
    private void m13230i0() {
        int i = 8;
        this.f10073Q.setVisibility(C4512y.m10924r() ? 8 : 0);
        this.f10076T.setVisibility(C4512y.m10924r() ? 0 : 8);
        this.f10074R.setEnabled(C4512y.m10924r());
        this.f10074R.setVisibility(C4512y.m10925q() ? 8 : 0);
        ImageView imageView = this.f10077U;
        if (C4512y.m10925q()) {
            i = 0;
        }
        imageView.setVisibility(i);
        if (!C4512y.m10924r() || !C4512y.m10925q()) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j0 */
    public /* synthetic */ void m13229j0(View view) {
        if (C4512y.m10924r()) {
            this.f10072P.m13325B(this);
        } else {
            this.f10072P.m13324C(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k0 */
    public /* synthetic */ void m13228k0(View view) {
        this.f10072P.m13325B(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l0 */
    public /* synthetic */ void m13227l0(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0 */
    public /* synthetic */ void m13226m0(boolean z) {
        if (z) {
            C3669c.m13352j0(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p136m5.AbstractActivityC5510b, androidx.fragment.app.ActivityC2104e, androidx.activity.ComponentActivity, androidx.core.app.ActivityC1600g, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object obj;
        super.onCreate(bundle);
        setContentView(R.layout.screen_consent);
        this.f10073Q = (Button) findViewById(R.id.buttonEnableLocation);
        this.f10074R = (Button) findViewById(R.id.buttonEnableBackgroundLocation);
        this.f10075S = (Button) findViewById(R.id.buttonRemindMeLater);
        this.f10076T = (ImageView) findViewById(R.id.imageViewLocationEnabled);
        this.f10077U = (ImageView) findViewById(R.id.imageViewBackgroundLocationEnabled);
        TextView textView = (TextView) findViewById(R.id.textConsentFooter);
        this.f10078V = textView;
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        this.f10073Q.setOnClickListener(new View.OnClickListener() { // from class: com.hellotracks.screens.other.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PermissionsScreen.this.m13229j0(view);
            }
        });
        this.f10074R.setOnClickListener(new View.OnClickListener() { // from class: com.hellotracks.screens.other.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PermissionsScreen.this.m13228k0(view);
            }
        });
        this.f10075S.setOnClickListener(new View.OnClickListener() { // from class: com.hellotracks.screens.other.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PermissionsScreen.this.m13227l0(view);
            }
        });
        if (C4512y.m10927o()) {
            obj = getPackageManager().getBackgroundPermissionOptionLabel();
        } else {
            obj = getString(R.string.AllowAllTheTime);
        }
        ((TextView) findViewById(R.id.textPermissionBackgroundLocationDesc)).setText(Html.fromHtml(getString(R.string.ProminentDisclosureBodyBackground, new Object[]{obj})));
    }

    @Override // androidx.fragment.app.ActivityC2104e, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (("android.permission.ACCESS_FINE_LOCATION".equals(strArr[i2]) || "android.permission.ACCESS_BACKGROUND_LOCATION".equals(strArr[i2])) && iArr[i2] == -1) {
                C4678w.m10425c().m10421g(this, new C4678w.AbstractC4679a() { // from class: com.hellotracks.screens.other.f
                    @Override // p086h5.C4678w.AbstractC4679a
                    /* renamed from: a */
                    public final void mo4331a(boolean z) {
                        PermissionsScreen.this.m13226m0(z);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p136m5.AbstractActivityC5510b, androidx.fragment.app.ActivityC2104e, android.app.Activity
    public void onResume() {
        super.onResume();
        m13230i0();
    }
}