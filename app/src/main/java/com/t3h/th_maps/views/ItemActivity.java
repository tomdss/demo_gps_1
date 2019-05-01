package com.t3h.th_maps.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.t3h.th_maps.R;

public class ItemActivity extends AppCompatActivity {

    private TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        initViews();
    }

    private void initViews() {
        tvInfo = findViewById(R.id.tv_info);
        if(getIntent()!=null){
            String info = getIntent().getStringExtra(MainActivity.INFO);
            tvInfo.setText(""+info);
        }
    }
}
