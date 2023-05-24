package com.hellotracks.screens.login;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.ActivityC0646d;
import com.hellotracks.App;
import com.hellotracks.R;
import com.hellotracks.screens.login.SplashScreen;
import com.hellotracks.screens.map.HomeMapScreen;
import p087h6.AbstractRunnableC4697j;
import p087h6.C4699l;

/* loaded from: classes2.dex */
public class SplashScreen extends ActivityC0646d {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P */
    public /* synthetic */ void m13603P() {
        startActivity(new Intent(App.m13901f(), HomeMapScreen.class));
        if (!isDestroyed()) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.ActivityC2104e, androidx.activity.ComponentActivity, androidx.core.app.ActivityC1600g, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().getDecorView().setSystemUiVisibility(9488);
        getWindow().setStatusBarColor(getResources().getColor(R.color.htBlueLight));
        getWindow().setNavigationBarColor(getResources().getColor(R.color.htBlueLight));
        C4699l.m10387d(new AbstractRunnableC4697j() { // from class: r5.g
            @Override // p087h6.AbstractRunnableC4697j, java.lang.Runnable
            public final void run() {
                SplashScreen.this.m13603P();
            }
        }, 50L);
    }
}