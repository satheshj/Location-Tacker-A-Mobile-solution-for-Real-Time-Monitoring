package com.hellotracks.comm.gcm.util;

import android.content.SharedPreferences;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.hellotracks.comm.gcm.util.C3599a;
import com.hellotracks.comm.gcm.util.HellotracksMessagingService;
import p006a5.C0375b;
import p006a5.C0378d;
import p047d6.C4027f;
import p047d6.C4031j;
import p047d6.C4040o;
import p056e5.C4155b;
import p066f5.C4244d;
import p087h6.AbstractRunnableC4692f;
import p087h6.C4695i;
import p087h6.C4699l;
import p096i5.C4825c;

/* loaded from: classes2.dex */
public class HellotracksMessagingService extends FirebaseMessagingService {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static /* synthetic */ void m13887d(String str) {
        int m9854d = C4825c.m9852f().m9854d(str);
        if (m9854d > 0) {
            C4040o.m12231d(m9854d);
            C4031j.m12246l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static /* synthetic */ void m13885f(String str) {
        C4825c.m9852f().m9849i(str);
        C4699l.m10386e(C4244d.f12175n);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onDeletedMessages() {
        super.onDeletedMessages();
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        C4027f.m12262b();
        C4155b.m11784h(this, remoteMessage.getData());
        C0378d.m22324b().edit().putLong("gcm_last_received", System.currentTimeMillis()).apply();
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageSent(final String str) {
        super.onMessageSent(str);
        C0375b.m22343n("gcm message sent: " + str);
        SharedPreferences m22324b = C0378d.m22324b();
        m22324b.edit().putLong("gcm_last_success", System.currentTimeMillis()).apply();
        if (m22324b.getInt("gcm.failure.counter", 0) > 0) {
            m22324b.edit().putInt("gcm.failure.counter", 0).apply();
        }
        C4695i.m10393g(new AbstractRunnableC4692f() { // from class: f5.c
            @Override // p087h6.AbstractRunnableC4692f, java.lang.Runnable
            public final void run() {
                HellotracksMessagingService.m13887d(str);
            }
        });
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String str) {
        super.onNewToken(str);
        C3599a.m13880b().m13875g(C3599a.EnumC3600a.INVALIDATE_CURRENT_TOKEN);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onSendError(final String str, Exception exc) {
        super.onSendError(str, exc);
        C0375b.m22333x("gcm message not sent: " + str + " " + exc);
        C4040o.m12232c();
        C0378d.m22324b().edit().putLong("gcm_last_error", System.currentTimeMillis()).apply();
        C4695i.m10393g(new AbstractRunnableC4692f() { // from class: f5.b
            @Override // p087h6.AbstractRunnableC4692f, java.lang.Runnable
            public final void run() {
                HellotracksMessagingService.m13885f(str);
            }
        });
    }
}