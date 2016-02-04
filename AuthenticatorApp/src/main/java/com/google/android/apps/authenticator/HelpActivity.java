package com.google.android.apps.authenticator;

import android.app.ActionBar;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

import com.google.android.apps.authenticator2.R;

public class HelpActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_page);

        getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getActionBar().setCustomView(R.layout.action_bar_layout);

        TextView actionBarTitle = (TextView) findViewById(R.id.action_bar_title);
        actionBarTitle.setText(R.string.help);
    }

}
