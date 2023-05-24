package com.hellotracks.screens.places;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;
import com.google.firebase.messaging.Constants;
import com.hellotracks.R;
import com.hellotracks.screens.places.C3715h;

/* loaded from: classes2.dex */
public class PlacesAutocompleteActivity extends Activity implements AdapterView.OnItemClickListener {

    /* renamed from: n */
    private double f10089n;

    /* renamed from: o */
    private double f10090o;

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.disappear);
    }

    public void onClose(View view) {
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        overridePendingTransition(R.anim.grow_from_top, 0);
        super.onCreate(bundle);
        this.f10089n = getIntent().getDoubleExtra("latitude", 0.0d);
        this.f10090o = getIntent().getDoubleExtra("longitude", 0.0d);
        setContentView(R.layout.places_autocomplete);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        autoCompleteTextView.setAdapter(new C3715h.C3718c(this, R.layout.list_item_places_automcomplete, this.f10089n, this.f10090o));
        autoCompleteTextView.setOnItemClickListener(this);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C3715h.C3717b c3717b = (C3715h.C3717b) adapterView.getItemAtPosition(i);
        Toast.makeText(this, c3717b.f10153b, 0).show();
        Intent intent = new Intent();
        intent.putExtra(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION, c3717b.f10153b);
        intent.putExtra("lat", c3717b.f10152a.f12197n);
        intent.putExtra("lng", c3717b.f10152a.f12198o);
        setResult(-1, intent);
        finish();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}