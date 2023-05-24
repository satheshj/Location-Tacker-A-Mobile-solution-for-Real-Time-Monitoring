package com.hellotracks.screens.group;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.hellotracks.App;
import com.hellotracks.R;
import com.hellotracks.screens.group.C3655b;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import p006a5.C0381f;
import p077g6.C4488i;

/* renamed from: com.hellotracks.screens.group.c */
/* loaded from: classes2.dex */
public class C3657c {
    /* renamed from: a */
    public static String m13621a(String str) {
        if (str.length() == 6) {
            return str.substring(0, 3) + "-" + str.substring(3);
        }
        return str;
    }

    /* renamed from: b */
    public static String m13620b(String str) {
        return "https://hellotracks.com/get/app/?" + str;
    }

    /* renamed from: c */
    public static String m13619c(C3655b c3655b) {
        if (c3655b != null) {
            if (c3655b.f9910g) {
                return App.m13901f().getString(c3655b.f9909f ? R.string.JoinGroupB2P : R.string.JoinGroupP2P, new Object[]{c3655b.f9905b});
            } else if (c3655b.f9908e) {
                return App.m13901f().getString(R.string.JoinGroupExpired);
            } else {
                if (C0381f.m22291b().m22315E()) {
                    return App.m13901f().getString(R.string.JoinGroupEmployee);
                }
            }
        }
        return App.m13901f().getString(R.string.JoinGroupGeneric);
    }

    /* renamed from: d */
    public static String m13618d(String str) {
        int indexOf = str.indexOf("code=") >= 0 ? str.indexOf("code=") + 5 : 0;
        String upperCase = str.substring(indexOf, str.indexOf("&", indexOf) >= 0 ? str.indexOf("&") : str.length()).replaceAll("-", "").trim().toUpperCase();
        if (upperCase.length() == 6) {
            return upperCase;
        }
        return null;
    }

    /* renamed from: e */
    public static List<C3654a> m13617e(JSONObject jSONObject) {
        LinkedList linkedList = new LinkedList();
        JSONArray m11043a = C4488i.m11043a(jSONObject, "groups");
        for (int i = 0; i < m11043a.length(); i++) {
            JSONObject m11032l = C4488i.m11032l(m11043a, i);
            C3654a c3654a = new C3654a();
            c3654a.f9900b = (String) C4488i.m11042b(m11032l, AppMeasurementSdk.ConditionalUserProperty.NAME, "");
            c3654a.f9901c = ((Integer) C4488i.m11042b(m11032l, "memberCount", 0)).intValue();
            c3654a.f9899a = (String) C4488i.m11042b(m11032l, "uid", "");
            c3654a.f9902d = ((Boolean) C4488i.m11042b(m11032l, "isEditPermitted", Boolean.FALSE)).booleanValue();
            JSONArray m11043a2 = C4488i.m11043a(m11032l, "inviteCodes");
            for (int i2 = 0; i2 < m11043a2.length(); i2++) {
                C3655b m13616f = m13616f(C4488i.m11032l(m11043a2, i2));
                if (m13616f.f9913j > 0) {
                    c3654a.f9903e.add(m13616f);
                }
            }
            linkedList.add(c3654a);
        }
        return linkedList;
    }

    /* renamed from: f */
    public static C3655b m13616f(JSONObject jSONObject) {
        C3655b c3655b = new C3655b();
        Boolean bool = Boolean.FALSE;
        c3655b.f9907d = ((Boolean) C4488i.m11042b(jSONObject, "isValid", bool)).booleanValue();
        c3655b.f9908e = ((Boolean) C4488i.m11042b(jSONObject, "isExpired", bool)).booleanValue();
        c3655b.f9909f = ((Boolean) C4488i.m11042b(jSONObject, "isCompany", bool)).booleanValue();
        c3655b.f9910g = ((Boolean) C4488i.m11042b(jSONObject, "isUsagePermitted", bool)).booleanValue();
        c3655b.f9911h = ((Boolean) C4488i.m11042b(jSONObject, "isMember", bool)).booleanValue();
        c3655b.f9905b = (String) C4488i.m11042b(jSONObject, "groupName", "");
        c3655b.f9904a = (String) C4488i.m11042b(jSONObject, "groupUid", "");
        c3655b.f9912i = ((Boolean) C4488i.m11042b(jSONObject, "isEditPermitted", bool)).booleanValue();
        c3655b.f9906c = (String) C4488i.m11042b(jSONObject, "inviteCode", "");
        c3655b.f9913j = C4488i.m11035i(jSONObject, "expirationTs");
        if (jSONObject.has("availableProfiles")) {
            JSONArray m11043a = C4488i.m11043a(jSONObject, "availableProfiles");
            for (int i = 0; i < m11043a.length(); i++) {
                JSONObject m11032l = C4488i.m11032l(m11043a, i);
                C3655b.C3656a c3656a = new C3655b.C3656a();
                c3656a.f9915a = (String) C4488i.m11042b(m11032l, AppMeasurementSdk.ConditionalUserProperty.NAME, "");
                c3656a.f9916b = (String) C4488i.m11042b(m11032l, "uid", "");
                c3656a.f9917c = (String) C4488i.m11042b(m11032l, "username", "");
                c3656a.f9918d = (String) C4488i.m11042b(m11032l, ImagesContract.URL, "");
                c3655b.f9914k.add(c3656a);
            }
        }
        return c3655b;
    }
}