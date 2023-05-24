package com.hellotracks.screens.map;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.DialogC0644c;
import androidx.fragment.app.Fragment;
import cn.pedant.SweetAlert.SweetAlertDialog;
import com.bumptech.glide.ComponentCallbacks2C3025c;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.hellotracks.App;
import com.hellotracks.R;
import com.hellotracks.screens.group.JoinGroupScreen;
import com.hellotracks.screens.group.ManageGroupsScreen;
import com.hellotracks.screens.map.LeftDrawerFragment;
import com.hellotracks.screens.messaging.MessagesScreen;
import com.hellotracks.screens.other.FeedbackScreen;
import com.hellotracks.screens.other.PanicInfoScreen;
import com.hellotracks.screens.teams.TeamsScreen;
import java.util.Locale;
import java.util.Set;
import org.json.JSONObject;
import p006a5.C0375b;
import p006a5.C0378d;
import p006a5.C0381f;
import p020b5.C2752j;
import p020b5.C2767s;
import p077g6.EnumC4478d;
import p120l.C5279b;
import p196s5.C7071t;
import p196s5.DialogInterface$OnClickListenerC7091y0;
import p196s5.DialogInterface$OnClickListenerC7093z0;

/* loaded from: classes2.dex */
public class LeftDrawerFragment extends Fragment {

    /* renamed from: n */
    private View f9958n;

    /* renamed from: o */
    private HomeMapScreen f9959o;

    /* renamed from: p */
    private View f9960p;

    /* renamed from: q */
    private View f9961q;

    /* renamed from: r */
    private TextView f9962r;

    /* renamed from: s */
    private TextView f9963s;

    /* renamed from: t */
    private ImageView f9964t;

    /* renamed from: u */
    private ViewGroup f9965u;

    /* renamed from: v */
    private View f9966v;

    /* renamed from: w */
    private TextView f9967w;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.hellotracks.screens.map.LeftDrawerFragment$a */
    /* loaded from: classes2.dex */
    public class C3662a extends C2767s {
        C3662a() {
        }

        @Override // p020b5.C2767s
        /* renamed from: c */
        public void mo690c(String str) {
            LeftDrawerFragment.this.m13462x();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public /* synthetic */ void m13515A(EditText editText, DialogInterface dialogInterface, int i) {
        m13491Y(editText.getText().toString().trim());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public /* synthetic */ void m13513C(DialogInterface dialogInterface, int i) {
        DialogC0644c.C0645a c0645a = new DialogC0644c.C0645a(getActivity());
        c0645a.setMessage(R.string.DeleteAccount);
        final EditText editText = new EditText(getActivity());
        editText.setHint(R.string.PleaseGiveUsFeedbackWhyDelete);
        c0645a.setView(editText);
        c0645a.setPositiveButton(getResources().getString(R.string.DeleteAccount), new DialogInterface.OnClickListener() { // from class: s5.v0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface2, int i2) {
                LeftDrawerFragment.this.m13515A(editText, dialogInterface2, i2);
            }
        });
        c0645a.setNegativeButton(getResources().getString(R.string.Cancel), DialogInterface$OnClickListenerC7093z0.f18643n);
        c0645a.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public /* synthetic */ void m13511E(View view) {
        C3669c.m13336x(this.f9959o);
        view.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F */
    public /* synthetic */ void m13510F(View view) {
        m13461y("menu_tracks");
        this.f9959o.mo13408r0();
        this.f9959o.m13586M1().m13283k();
        C7071t.m4320d(this.f9959o, C0381f.m22291b().m22275j(), C0381f.m22291b().m22267r());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G */
    public /* synthetic */ void m13509G(View view) {
        m13461y("menu_timeline");
        this.f9959o.mo13408r0();
        this.f9959o.m13586M1().m13283k();
        this.f9959o.m13524x2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H */
    public /* synthetic */ void m13508H(View view) {
        m13461y("menu_premium");
        String str = getResources().getString(R.string.PremiumSupportInquiry) + ": " + C0381f.m22291b().m22266s();
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse("mailto:premium@hellotracks.com?subject=" + Uri.encode(str) + "&body="));
        startActivity(Intent.createChooser(intent, getResources().getString(R.string.PremiumSupport)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I */
    public /* synthetic */ void m13507I(SweetAlertDialog sweetAlertDialog, SweetAlertDialog sweetAlertDialog2) {
        m13462x();
        sweetAlertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J */
    public /* synthetic */ boolean m13506J(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 0:
                m13461y("menu_settings_settings");
                C3669c.m13387K(this.f9959o, "");
                return false;
            case 1:
                m13461y("menu_settings_status");
                C3669c.m13349l(this.f9959o);
                return false;
            case 2:
                m13461y("menu_settings_invitecode_management");
                this.f9959o.startActivity(new Intent(this.f9959o, ManageGroupsScreen.class));
                return false;
            case 3:
                m13461y("menu_settings_emergency");
                this.f9959o.startActivity(new Intent(this.f9959o, PanicInfoScreen.class));
                return false;
            case 4:
                m13461y("menu_settings_howdoesitwork");
                this.f9959o.m13540p2();
                return false;
            case 5:
                m13461y("menu_settings_feedback");
                startActivity(new Intent(getActivity(), FeedbackScreen.class));
                return false;
            case 6:
                m13461y("menu_settings_faq");
                m13493W();
                return false;
            case 7:
                m13494V();
                return false;
            case 8:
                m13461y("menu_settings_logout");
                this.f9959o.mo13408r0();
                final SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(this.f9959o, 3);
                sweetAlertDialog.setTitleText(getString(R.string.logoutText));
                sweetAlertDialog.setCancelable(true);
                sweetAlertDialog.setCancelText(getString(R.string.Cancel));
                sweetAlertDialog.setConfirmText(getString(R.string.logout));
                sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() { // from class: s5.x0
                    @Override // cn.pedant.SweetAlert.SweetAlertDialog.OnSweetClickListener
                    public final void onClick(SweetAlertDialog sweetAlertDialog2) {
                        LeftDrawerFragment.this.m13507I(sweetAlertDialog, sweetAlertDialog2);
                    }
                });
                sweetAlertDialog.show();
                return false;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K */
    public /* synthetic */ void m13505K(View view) {
        PopupMenu popupMenu = new PopupMenu(getActivity(), this.f9958n.findViewById(R.id.settingsButton));
        popupMenu.getMenu().add(0, 0, 0, R.string.Settings);
        popupMenu.getMenu().add(0, 1, 0, R.string.ChooseYourCurrentStatus).setVisible(C0381f.m22291b().m22315E());
        popupMenu.getMenu().add(0, 2, 0, R.string.InviteCodeManagement).setVisible(!C0381f.m22291b().m22315E());
        popupMenu.getMenu().add(0, 3, 0, R.string.Emergency);
        popupMenu.getMenu().add(0, 4, 0, R.string.HowDoesItWork);
        popupMenu.getMenu().add(0, 5, 0, R.string.QuestionOrFeedback);
        popupMenu.getMenu().add(0, 6, 0, R.string.FAQforBusiness);
        popupMenu.getMenu().add(0, 7, 0, R.string.DeleteAccount).setVisible(true ^ C0381f.m22291b().m22315E());
        popupMenu.getMenu().add(0, 8, 0, R.string.logout);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: s5.w0
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean m13506J;
                m13506J = LeftDrawerFragment.this.m13506J(menuItem);
                return m13506J;
            }
        });
        popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L */
    public /* synthetic */ void m13504L(View view) {
        C3669c.m13336x(this.f9959o);
        view.setVisibility(8);
        C0378d.m22324b().edit().putBoolean("rateus_button_clicked", true).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M */
    public /* synthetic */ void m13503M(View view) {
        m13461y("menu_teams");
        this.f9959o.startActivity(new Intent(this.f9959o, TeamsScreen.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public /* synthetic */ void m13502N(View view) {
        m13461y("menu_help");
        m13492X();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O */
    public /* synthetic */ void m13501O(View view) {
        m13461y("menu_teams_add");
        this.f9959o.startActivity(new Intent(this.f9959o, JoinGroupScreen.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P */
    public /* synthetic */ void m13500P(View view) {
        m13461y("menu_places");
        C3669c.m13389I(getActivity(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q */
    public /* synthetic */ void m13499Q(View view) {
        m13461y("menu_places_add");
        C3669c.m13389I(getActivity(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R */
    public /* synthetic */ void m13498R(View view) {
        m13461y("menu_profile");
        this.f9959o.mo13408r0();
        this.f9959o.m13586M1().m13283k();
        this.f9959o.m13524x2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S */
    public /* synthetic */ void m13497S(View view) {
        m13461y("menu_messages");
        this.f9959o.startActivityForResult(new Intent(getActivity(), MessagesScreen.class), 114);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T */
    public /* synthetic */ void m13496T(View view) {
        C3669c.m13349l(this.f9959o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U */
    public static /* synthetic */ void m13495U(Set set, C0381f.C0385d c0385d, CompoundButton compoundButton, boolean z) {
        if (z) {
            set.remove(Integer.valueOf(c0385d.f1431a));
        } else {
            set.add(Integer.valueOf(c0385d.f1431a));
        }
        C0381f.m22291b().m22290b0(set);
    }

    /* renamed from: V */
    private void m13494V() {
        DialogC0644c.C0645a c0645a = new DialogC0644c.C0645a(getActivity());
        c0645a.setMessage(R.string.ReallyDeleteAccount);
        c0645a.setPositiveButton(R.string.Yes, new DialogInterface.OnClickListener() { // from class: s5.k0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LeftDrawerFragment.this.m13513C(dialogInterface, i);
            }
        });
        c0645a.setNegativeButton(getResources().getString(R.string.Cancel), DialogInterface$OnClickListenerC7091y0.f18641n);
        c0645a.show();
    }

    /* renamed from: W */
    private void m13493W() {
        m13461y("faq");
        try {
            new C5279b.C5280a().m8491a().m8492a(getActivity(), Uri.parse("http://help.hellotracks.com"));
        } catch (Exception e) {
            C0375b.m22345l("LeftDrawerFragment", e);
        }
    }

    /* renamed from: X */
    private void m13492X() {
        String str;
        if (Locale.getDefault().getLanguage().equals("es")) {
            str = "https://hellotracks-faq-es.helpscoutdocs.com/collection/186-aplicacion-movil";
        } else {
            str = Locale.getDefault().getLanguage().equals("de") ? "https://hellotracks-faq-de.helpscoutdocs.com/collection/257-mobile-app-de" : "https://hellotracks.helpscoutdocs.com/collection/96-mobile-app";
        }
        try {
            new C5279b.C5280a().m8491a().m8492a(getActivity(), Uri.parse(str));
        } catch (Exception e) {
            C0375b.m22345l("LeftDrawerFragment", e);
        }
    }

    /* renamed from: Y */
    private void m13491Y(String str) {
        try {
            JSONObject m14656L = C2752j.m14656L();
            m14656L.put("msg", str);
            C2752j.m14641v("deactivate", m14656L, new C3662a());
        } catch (Exception e) {
            C0375b.m22334w(e);
        }
    }

    /* renamed from: b0 */
    private void m13486b0() {
        if (this.f9962r == null || this.f9963s == null) {
            return;
        }
        SharedPreferences m22324b = C0378d.m22324b();
        this.f9962r.setText(m22324b.getString(AppMeasurementSdk.ConditionalUserProperty.NAME, ""));
        this.f9963s.setText(C0381f.m22291b().m22266s());
        if (!m22324b.contains("profileThumb")) {
            return;
        }
        ComponentCallbacks2C3025c.m14096u(App.m13901f()).m14045g(m22324b.getString("profileThumb", "")).m14057l(this.f9964t);
    }

    /* renamed from: d0 */
    private void m13482d0() {
        C0381f.C0385d[] m22271n = C0381f.m22291b().m22271n();
        if (C0381f.m22291b().m22317C() && m22271n.length > 0) {
            this.f9966v.setVisibility(0);
            this.f9965u.setVisibility(0);
            this.f9965u.removeAllViews();
            final Set<Integer> m22279h = C0381f.m22291b().m22279h();
            for (final C0381f.C0385d c0385d : m22271n) {
                Switch r5 = (Switch) this.f9959o.getLayoutInflater().inflate(R.layout.home_drawer_menu_team_switch, (ViewGroup) null);
                r5.setText(c0385d.f1432b);
                r5.setChecked(!m22279h.contains(Integer.valueOf(c0385d.f1431a)));
                r5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: s5.u0
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        LeftDrawerFragment.m13495U(m22279h, c0385d, compoundButton, z);
                    }
                });
                this.f9965u.addView(r5);
            }
            return;
        }
        this.f9966v.setVisibility(8);
        this.f9965u.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public void m13462x() {
        C3669c.m13341s(this.f9959o, false);
        C3669c.m13390H(this.f9959o);
    }

    /* renamed from: y */
    private void m13461y(String str) {
        EnumC4478d.m11082g(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public /* synthetic */ WindowInsets m13460z(View view, WindowInsets windowInsets) {
        this.f9958n.setPaddingRelative(0, windowInsets.getSystemWindowInsetTop(), 0, 0);
        return windowInsets;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: Z */
    public void m13490Z(boolean z) {
        m13488a0();
        m13486b0();
        m13482d0();
    }

    /* renamed from: a0 */
    void m13488a0() {
        int i = 0;
        boolean z = C0378d.m22324b().getBoolean("is_premium", false);
        boolean m22315E = C0381f.m22291b().m22315E();
        if (z && !m22315E) {
            this.f9960p.setVisibility(0);
        } else {
            this.f9960p.setVisibility(8);
        }
        View view = this.f9961q;
        if (m22315E) {
            i = 8;
        }
        view.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c0 */
    public void m13484c0() {
        String m22272m = C0381f.m22291b().m22272m();
        if (m22272m.length() > 0) {
            this.f9967w.setVisibility(0);
            SpannableString spannableString = new SpannableString(m22272m);
            spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
            this.f9967w.setText(spannableString);
            this.f9967w.setOnClickListener(new View.OnClickListener() { // from class: s5.l0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LeftDrawerFragment.this.m13496T(view);
                }
            });
            return;
        }
        this.f9967w.setVisibility(8);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f9959o = (HomeMapScreen) getActivity();
        View inflate = layoutInflater.inflate(R.layout.home_drawer_menu, (ViewGroup) null);
        this.f9958n = inflate;
        this.f9960p = inflate.findViewById(R.id.premiumSupportButton);
        this.f9962r = (TextView) this.f9958n.findViewById(R.id.textProfileName);
        this.f9963s = (TextView) this.f9958n.findViewById(R.id.textUsername);
        this.f9964t = (ImageView) this.f9958n.findViewById(R.id.imageProfile);
        this.f9961q = this.f9958n.findViewById(R.id.teamsAddButton);
        this.f9965u = (ViewGroup) this.f9958n.findViewById(R.id.teamsSwitchContainer);
        this.f9966v = this.f9958n.findViewById(R.id.teamsSwitchHeader);
        this.f9967w = (TextView) this.f9958n.findViewById(R.id.textStatusLabel);
        this.f9958n.findViewById(R.id.menuContent).setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: s5.a1
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                WindowInsets m13460z;
                m13460z = LeftDrawerFragment.this.m13460z(view, windowInsets);
                return m13460z;
            }
        });
        return this.f9958n;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f9958n.findViewById(R.id.updateAvailableButton).setOnClickListener(new View.OnClickListener() { // from class: s5.o0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LeftDrawerFragment.this.m13511E(view2);
            }
        });
        this.f9958n.findViewById(R.id.rateUsButton).setOnClickListener(new View.OnClickListener() { // from class: s5.m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LeftDrawerFragment.this.m13504L(view2);
            }
        });
        this.f9958n.findViewById(R.id.teamsButton).setOnClickListener(new View.OnClickListener() { // from class: s5.q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LeftDrawerFragment.this.m13503M(view2);
            }
        });
        this.f9958n.findViewById(R.id.helpButton).setOnClickListener(new View.OnClickListener() { // from class: s5.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LeftDrawerFragment.this.m13502N(view2);
            }
        });
        this.f9961q.setOnClickListener(new View.OnClickListener() { // from class: s5.t0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LeftDrawerFragment.this.m13501O(view2);
            }
        });
        this.f9958n.findViewById(R.id.placesButton).setOnClickListener(new View.OnClickListener() { // from class: s5.r0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LeftDrawerFragment.this.m13500P(view2);
            }
        });
        this.f9958n.findViewById(R.id.placesSearchButton).setOnClickListener(new View.OnClickListener() { // from class: s5.f1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LeftDrawerFragment.this.m13499Q(view2);
            }
        });
        this.f9958n.findViewById(R.id.profileButton).setOnClickListener(new View.OnClickListener() { // from class: s5.b1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LeftDrawerFragment.this.m13498R(view2);
            }
        });
        this.f9958n.findViewById(R.id.messagesButton).setOnClickListener(new View.OnClickListener() { // from class: s5.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LeftDrawerFragment.this.m13497S(view2);
            }
        });
        this.f9958n.findViewById(R.id.tracksButton).setOnClickListener(new View.OnClickListener() { // from class: s5.c1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LeftDrawerFragment.this.m13510F(view2);
            }
        });
        this.f9958n.findViewById(R.id.timelineButton).setOnClickListener(new View.OnClickListener() { // from class: s5.d1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LeftDrawerFragment.this.m13509G(view2);
            }
        });
        this.f9958n.findViewById(R.id.premiumSupportButton).setOnClickListener(new View.OnClickListener() { // from class: s5.e1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LeftDrawerFragment.this.m13508H(view2);
            }
        });
        this.f9958n.findViewById(R.id.settingsButton).setOnClickListener(new View.OnClickListener() { // from class: s5.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LeftDrawerFragment.this.m13505K(view2);
            }
        });
        m13484c0();
    }
}