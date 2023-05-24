package com.hellotracks.screens.places;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import p107j6.C4925i;

/* loaded from: classes2.dex */
public class RoundedMap extends MapView {

    /* renamed from: p */
    private final int f10120p;

    /* renamed from: n */
    private final int f10118n = 16;

    /* renamed from: o */
    private final RectF f10119o = new RectF();

    /* renamed from: q */
    private boolean f10121q = true;

    /* renamed from: r */
    private boolean f10122r = true;

    /* renamed from: s */
    private boolean f10123s = false;

    /* renamed from: t */
    private boolean f10124t = false;

    public RoundedMap(Context context) {
        super(context);
        this.f10120p = C4925i.m9685j(16.0f, context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Path path = new Path();
        int save = canvas.save();
        float[] fArr = new float[8];
        boolean z = this.f10121q;
        float f = BitmapDescriptorFactory.HUE_RED;
        fArr[0] = z ? this.f10120p : 0.0f;
        fArr[1] = z ? this.f10120p : 0.0f;
        boolean z2 = this.f10122r;
        fArr[2] = z2 ? this.f10120p : 0.0f;
        fArr[3] = z2 ? this.f10120p : 0.0f;
        boolean z3 = this.f10124t;
        fArr[4] = z3 ? this.f10120p : 0.0f;
        fArr[5] = z3 ? this.f10120p : 0.0f;
        boolean z4 = this.f10123s;
        fArr[6] = z4 ? this.f10120p : 0.0f;
        if (z4) {
            f = this.f10120p;
        }
        fArr[7] = f;
        path.addRoundRect(this.f10119o, fArr, Path.Direction.CW);
        canvas.clipPath(path);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f10119o.set(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, getWidth(), getHeight());
    }

    public void setCorners(boolean z, boolean z2, boolean z3, boolean z4) {
        this.f10121q = z;
        this.f10122r = z2;
        this.f10123s = z3;
        this.f10124t = z4;
    }

    public RoundedMap(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10120p = C4925i.m9685j(16.0f, context);
    }

    public RoundedMap(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f10120p = C4925i.m9685j(16.0f, context);
    }
}