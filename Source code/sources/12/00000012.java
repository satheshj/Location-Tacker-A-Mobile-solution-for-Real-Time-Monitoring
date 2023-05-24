package com.hellotracks.screens.group;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.hellotracks.R;
import com.hellotracks.screens.group.ShareGroupScreen;
import com.hellotracks.screens.map.C3669c;
import component.Button;
import p136m5.AbstractActivityC5510b;

/* loaded from: classes2.dex */
public class ShareGroupScreen extends AbstractActivityC5510b {

    /* renamed from: P */
    private String f9898P;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g0 */
    public /* synthetic */ void m13629g0(View view) {
        m13627i0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h0 */
    public /* synthetic */ void m13628h0(View view) {
        finish();
    }

    /* renamed from: i0 */
    private void m13627i0() {
        C3669c.m13393E(this, C3657c.m13621a(this.f9898P));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p136m5.AbstractActivityC5510b, androidx.fragment.app.ActivityC2104e, androidx.activity.ComponentActivity, androidx.core.app.ActivityC1600g, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.screen_group_share);
        this.f9898P = getIntent().getStringExtra("invitationCode");
        ((TextView) findViewById(R.id.textInvitationCode)).setText(C3657c.m13621a(this.f9898P));
        ((Button) findViewById(R.id.buttonShare)).setOnClickListener(new View.OnClickListener() { // from class: o5.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShareGroupScreen.this.m13629g0(view);
            }
        });
        ((Button) findViewById(R.id.buttonDoneSharing)).setOnClickListener(new View.OnClickListener() { // from class: o5.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShareGroupScreen.this.m13628h0(view);
            }
        });
    }
}