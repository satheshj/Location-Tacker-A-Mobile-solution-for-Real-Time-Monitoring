package com.hellotracks.screens.settings;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.compose.runtime.AbstractC1035j;
import androidx.compose.runtime.C1080l;
import p000a.C0000a;
import p068f7.C4290x;
import p111k0.C5035c;
import p178q7.AbstractC6522a;
import p178q7.AbstractC6537p;
import p188r7.AbstractC6752q;
import p256y5.C8455j;

/* loaded from: classes2.dex */
public final class SettingsActivity extends ComponentActivity {

    /* renamed from: com.hellotracks.screens.settings.SettingsActivity$a */
    /* loaded from: classes2.dex */
    static final class C3743a extends AbstractC6752q implements AbstractC6537p<AbstractC1035j, Integer, C4290x> {

        /* renamed from: o */
        final /* synthetic */ boolean f10236o;

        /* renamed from: p */
        final /* synthetic */ boolean f10237p;

        /* renamed from: q */
        final /* synthetic */ boolean f10238q;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.hellotracks.screens.settings.SettingsActivity$a$a */
        /* loaded from: classes2.dex */
        public static final class C3744a extends AbstractC6752q implements AbstractC6522a<C4290x> {

            /* renamed from: n */
            final /* synthetic */ SettingsActivity f10239n;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C3744a(SettingsActivity settingsActivity) {
                super(0);
                this.f10239n = settingsActivity;
            }

            @Override // p178q7.AbstractC6522a
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.f10239n.finish();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C3743a(boolean z, boolean z2, boolean z3) {
            super(2);
            this.f10236o = z;
            this.f10237p = z2;
            this.f10238q = z3;
        }

        @Override // p178q7.AbstractC6537p
        public /* bridge */ /* synthetic */ C4290x invoke(AbstractC1035j abstractC1035j, Integer num) {
            invoke(abstractC1035j, num.intValue());
            return C4290x.f12239a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r11v0, types: [androidx.compose.runtime.j] */
        public final void invoke(AbstractC1035j abstractC1035j, int i) {
            if ((i & 11) == 2 && abstractC1035j.mo20332s()) {
                abstractC1035j.mo20311z();
                return;
            }
            if (C1080l.m20255O()) {
                C1080l.m20244Z(847460343, i, -1, "com.hellotracks.screens.settings.SettingsActivity.onCreate.<anonymous> (SettingsActivity.kt:50)");
            }
            SettingsActivity settingsActivity = SettingsActivity.this;
            boolean z = this.f10236o;
            boolean z2 = this.f10237p;
            boolean z3 = this.f10238q;
            abstractC1035j.mo20374e(1157296644);
            boolean mo20412O = abstractC1035j.mo20412O(settingsActivity);
            Object mo20368g = abstractC1035j.mo20368g();
            if (mo20412O || mo20368g == AbstractC1035j.f3224a.m20456a()) {
                mo20368g = new C3744a(settingsActivity);
                abstractC1035j.mo20433H(mo20368g);
            }
            abstractC1035j.mo20421L();
            C8455j.m752h(settingsActivity, z, z2, z3, mo20368g, abstractC1035j, 0);
            if (!C1080l.m20255O()) {
                return;
            }
            C1080l.m20245Y();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ActivityC1600g, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("filter");
        boolean equals = "general".equals(stringExtra);
        boolean equals2 = "locating".equals(stringExtra);
        boolean equals3 = "map".equals(stringExtra);
        boolean z = false;
        boolean z2 = !equals && !equals2 && !equals3;
        boolean z3 = z2 || equals;
        boolean z4 = z2 || equals2;
        if (z2 || equals3) {
            z = true;
        }
        C0000a.m23053b(this, null, C5035c.m9169c(847460343, true, new C3743a(z3, z4, z)), 1, null);
    }
}