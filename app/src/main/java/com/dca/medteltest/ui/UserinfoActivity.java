package com.dca.medteltest.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.dca.medteltest.R;

public class UserinfoActivity extends AppCompatActivity {
TextView txtname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);
        txtname=findViewById(R.id.textname);
        String name=getIntent().getStringExtra("name");
        String abc="Hi my name is &quot;"+name+"&quot;";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            txtname.setText(Html.fromHtml(abc, Html.FROM_HTML_MODE_COMPACT));
        } else {
            txtname.setText(Html.fromHtml(abc));
        }
    }
}