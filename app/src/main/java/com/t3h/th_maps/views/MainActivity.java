package com.t3h.th_maps.views;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;

import com.t3h.th_maps.R;

public class MainActivity extends AppCompatActivity {

    public static final String INFO = "main.info.item";
    private GridLayout mainGrid;

    private final String[] PERMISSION_LIST = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
    };

    private boolean checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (String p : PERMISSION_LIST) {
                if (checkSelfPermission(p) !=
                        PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(PERMISSION_LIST, 0);
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        checkPermission();
    }

    private void initViews() {
        mainGrid = findViewById(R.id.mainGrid);
        setSingleEvent(mainGrid);
    }

    private void setSingleEvent(GridLayout mainGrid) {

        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(finalI==0){
                        Intent intent = new Intent(MainActivity.this,MapsActivity.class);
//                        intent.putExtra(INFO,"This is activity from card item index "+finalI);
                        startActivity(intent);
                    }else {
                        Intent intent = new Intent(MainActivity.this,ItemActivity.class);
                        intent.putExtra(INFO,"This is activity from card item index "+(finalI+1));
                        startActivity(intent);
                    }
                }
            });
        }


    }
}
