package com.hellotracks.screens.other;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import com.hellotracks.R;
import p136m5.AbstractActivityC5510b;

/* loaded from: classes2.dex */
public class InfoScreen extends AbstractActivityC5510b {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p136m5.AbstractActivityC5510b, androidx.fragment.app.ActivityC2104e, androidx.activity.ComponentActivity, androidx.core.app.ActivityC1600g, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.screen_info);
        ((TextView) findViewById(R.id.text)).setText(Html.fromHtml(getResources().getString(R.string.InfoTextHTML)));
    }

    public void onOK(View view) {
        finish();
    }
}