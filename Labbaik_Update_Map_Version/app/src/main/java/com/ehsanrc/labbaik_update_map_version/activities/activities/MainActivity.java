package com.ehsanrc.labbaik_update_map_version.activities.activities;

import android.content.Context;
import android.content.Intent;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.ehsanrc.labbaik_update_map_version.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.getBackground().setAlpha(0);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Labbaik");

        setParams();

        introduceButtons();


    }

    void introduceButtons(){

        Button button_hajj = (Button) findViewById(R.id.btn_hajj);
        button_hajj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Hajj.class);
                startActivity(intent);
            }
        });

        Button button_umra = (Button) findViewById(R.id.btn_umra);
        button_umra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Umrah.class);
                startActivity(intent);
            }
        });

        Button button_duas = (Button) findViewById(R.id.btn_duas);
        button_duas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Duas.class);
                startActivity(intent);
            }
        });

        Button button_importance = (Button) findViewById(R.id.btn_importance);
        button_importance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScrollingActivity.class);
                intent.putExtra("button","importance");
                startActivity(intent);
            }
        });

        Button button_ihram = (Button) findViewById(R.id.btn_ihram);
        button_ihram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScrollingActivity.class);
                intent.putExtra("button","ihram");
                startActivity(intent);
            }
        });

        Button button_farj = (Button) findViewById(R.id.btn_farj);
        button_farj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScrollingActivity.class);
                intent.putExtra("button","farj");
                startActivity(intent);
            }
        });

        Button button_wajib = (Button) findViewById(R.id.btn_wajib);
        button_wajib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScrollingActivity.class);
                intent.putExtra("button","wajib");
                startActivity(intent);
            }
        });

        Button button_maps = (Button) findViewById(R.id.btn_settings);
        button_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                intent.putExtra("button","maps");
                startActivity(intent);
            }
        });

    }

    void introduceTextviews(){



    }

    void introduceImageviews(){



    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        MultiDex.install(this);
    }

    void setParams(){

        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        int deviceWidth = displayMetrics.widthPixels;
        int deviceHeight = displayMetrics.heightPixels;

        LinearLayout linearLayout_up = (LinearLayout) findViewById(R.id.ll_up);
        LinearLayout linearLayout_down = (LinearLayout) findViewById(R.id.ll_down);

        setParamsLinearLayout(linearLayout_up,((deviceHeight*40)/100),0);
        setParamsLinearLayout(linearLayout_down,((deviceHeight*50)/100),0);

        LinearLayout linearLayout_hajj = (LinearLayout) findViewById(R.id.hajj);
        LinearLayout linearLayout_umra = (LinearLayout) findViewById(R.id.umra);
        LinearLayout linearLayout_duas = (LinearLayout) findViewById(R.id.duas);
        LinearLayout linearLayout_importance = (LinearLayout) findViewById(R.id.importance);
        LinearLayout linearLayout_ihram = (LinearLayout) findViewById(R.id.ihram);
        LinearLayout linearLayout_farj = (LinearLayout) findViewById(R.id.farj);
        LinearLayout linearLayout_wajib = (LinearLayout) findViewById(R.id.wajib);
        LinearLayout linearLayout_settings = (LinearLayout) findViewById(R.id.settings);
        setParamsRelativeLayout(linearLayout_hajj,0,(deviceWidth/2));
        setParamsRelativeLayout(linearLayout_umra,0,(deviceWidth/2));
        setParamsRelativeLayout(linearLayout_duas,0,(deviceWidth/2));
        setParamsRelativeLayout(linearLayout_importance,0,(deviceWidth/2));
        setParamsRelativeLayout(linearLayout_ihram,0,(deviceWidth/2));
        setParamsRelativeLayout(linearLayout_farj,0,(deviceWidth/2));
        setParamsRelativeLayout(linearLayout_wajib,0,(deviceWidth/2));
        setParamsRelativeLayout(linearLayout_settings,0,(deviceWidth/2));

    }

    void setParamsLinearLayout(LinearLayout linearLayout,int mHeight, int mWidth){

        LinearLayout.LayoutParams mParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        if(mHeight!=0)
            mParams.height = (int) mHeight;
        if(mWidth!=0)
            mParams.width = (int) mWidth;

        linearLayout.setLayoutParams(mParams);
    }

    void setParamsRelativeLayout(LinearLayout linearLayout,int mHeight, int mWidth){

        RelativeLayout.LayoutParams mParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();

        if(mHeight!=0)
            mParams.height = (int) mHeight;
        if(mWidth!=0)
            mParams.width = (int) mWidth;

        linearLayout.setLayoutParams(mParams);
    }
}
