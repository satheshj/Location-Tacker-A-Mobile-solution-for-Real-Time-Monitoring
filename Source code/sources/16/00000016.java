package p077g6;

import android.text.Editable;
import android.text.TextWatcher;

/* renamed from: g6.p */
/* loaded from: classes2.dex */
public class C4499p implements TextWatcher {

    /* renamed from: n */
    private final AbstractC4501b f12670n;

    /* renamed from: o */
    private final AbstractC4500a f12671o;

    /* renamed from: g6.p$a */
    /* loaded from: classes2.dex */
    public interface AbstractC4500a {
        /* renamed from: a */
        void mo154a(Editable editable);
    }

    /* renamed from: g6.p$b */
    /* loaded from: classes2.dex */
    public interface AbstractC4501b {
        /* renamed from: a */
        void mo2602a(String str);
    }

    public C4499p(AbstractC4501b abstractC4501b) {
        this(abstractC4501b, null);
    }

    /* renamed from: a */
    public static C4499p m11012a(AbstractC4500a abstractC4500a) {
        return new C4499p(null, abstractC4500a);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        AbstractC4500a abstractC4500a = this.f12671o;
        if (abstractC4500a != null) {
            abstractC4500a.mo154a(editable);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        AbstractC4501b abstractC4501b = this.f12670n;
        if (abstractC4501b != null) {
            abstractC4501b.mo2602a(charSequence.toString());
        }
    }

    private C4499p(AbstractC4501b abstractC4501b, AbstractC4500a abstractC4500a) {
        this.f12670n = abstractC4501b;
        this.f12671o = abstractC4500a;
    }
}