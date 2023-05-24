package com.hellotracks.screens.teams;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.compose.runtime.AbstractC1035j;
import androidx.compose.runtime.C1080l;
import p000a.C0000a;
import p007a6.C0401g;
import p007a6.C0405h;
import p007a6.C0422i;
import p068f7.C4290x;
import p111k0.C5035c;
import p178q7.AbstractC6522a;
import p178q7.AbstractC6537p;
import p188r7.AbstractC6752q;

/* loaded from: classes2.dex */
public final class SearchMemberActivity extends ComponentActivity {

    /* renamed from: com.hellotracks.screens.teams.SearchMemberActivity$a */
    /* loaded from: classes2.dex */
    static final class C3761a extends AbstractC6752q implements AbstractC6537p<AbstractC1035j, Integer, C4290x> {

        /* renamed from: n */
        final /* synthetic */ C0422i f10305n;

        /* renamed from: o */
        final /* synthetic */ C0401g f10306o;

        /* renamed from: p */
        final /* synthetic */ SearchMemberActivity f10307p;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.hellotracks.screens.teams.SearchMemberActivity$a$a */
        /* loaded from: classes2.dex */
        public static final class C3762a extends AbstractC6752q implements AbstractC6522a<C4290x> {

            /* renamed from: n */
            final /* synthetic */ SearchMemberActivity f10308n;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C3762a(SearchMemberActivity searchMemberActivity) {
                super(0);
                this.f10308n = searchMemberActivity;
            }

            @Override // p178q7.AbstractC6522a
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.f10308n.finish();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C3761a(C0422i c0422i, C0401g c0401g, SearchMemberActivity searchMemberActivity) {
            super(2);
            this.f10305n = c0422i;
            this.f10306o = c0401g;
            this.f10307p = searchMemberActivity;
        }

        @Override // p178q7.AbstractC6537p
        public /* bridge */ /* synthetic */ C4290x invoke(AbstractC1035j abstractC1035j, Integer num) {
            invoke(abstractC1035j, num.intValue());
            return C4290x.f12239a;
        }

        public final void invoke(AbstractC1035j abstractC1035j, int i) {
            if ((i & 11) == 2 && abstractC1035j.mo20332s()) {
                abstractC1035j.mo20311z();
                return;
            }
            if (C1080l.m20255O()) {
                C1080l.m20244Z(1161185287, i, -1, "com.hellotracks.screens.teams.SearchMemberActivity.onCreate.<anonymous> (SearchMember.kt:57)");
            }
            C0422i c0422i = this.f10305n;
            C0401g c0401g = this.f10306o;
            SearchMemberActivity searchMemberActivity = this.f10307p;
            abstractC1035j.mo20374e(1157296644);
            boolean mo20412O = abstractC1035j.mo20412O(searchMemberActivity);
            Object mo20368g = abstractC1035j.mo20368g();
            if (mo20412O || mo20368g == AbstractC1035j.f3224a.m20456a()) {
                mo20368g = new C3762a(searchMemberActivity);
                abstractC1035j.mo20433H(mo20368g);
            }
            abstractC1035j.mo20421L();
            C0405h.m22218b(c0422i, c0401g, (AbstractC6522a) mo20368g, abstractC1035j, 64);
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
        C0422i c0422i = new C0422i();
        C0401g c0401g = new C0401g(c0422i);
        c0401g.m22230f();
        C0000a.m23053b(this, null, C5035c.m9169c(1161185287, true, new C3761a(c0422i, c0401g, this)), 1, null);
    }
}