package com.hellotracks.screens.map.contextual;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.compose.p012ui.platform.ComposeView;
import com.google.firebase.messaging.Constants;
import com.hellotracks.R;
import com.hellotracks.screens.map.SharedPreferences$OnSharedPreferenceChangeListenerC3685k;
import p188r7.C6751p;
import p206t5.C7401a;

/* loaded from: classes2.dex */
public final class TrackHistoryView extends FrameLayout {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrackHistoryView(Context context) {
        super(context);
        C6751p.m5021f(context, "context");
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        ((ComposeView) findViewById(R.id.composeView)).setContent(C7401a.f19436a.m3351a());
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        C6751p.m5021f(motionEvent, Constants.FirelogAnalytics.PARAM_EVENT);
        if (motionEvent.getAction() == 0) {
            SharedPreferences$OnSharedPreferenceChangeListenerC3685k.m13281m().m13280n().requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrackHistoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C6751p.m5021f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrackHistoryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C6751p.m5021f(context, "context");
    }
}