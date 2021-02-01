package com.ehsanrc.labbaik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class Maps extends AppCompatActivity {

    int deviceWidth;
    int deviceHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        deviceWidth = displayMetrics.widthPixels;
        deviceHeight = displayMetrics.heightPixels;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("মানচিত্র");

        ImageView iv = (ImageView) findViewById(R.id.iv);
        iv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,(deviceHeight*40)/100));

        introduceButtons();

        setParams();


    }

    private void setParams() {

        LinearLayout ll1 = (LinearLayout) findViewById(R.id.ll1);
        LinearLayout ll2 = (LinearLayout) findViewById(R.id.ll2);
        LinearLayout ll3 = (LinearLayout) findViewById(R.id.ll3);
        LinearLayout ll4 = (LinearLayout) findViewById(R.id.ll4);
        LinearLayout ll5 = (LinearLayout) findViewById(R.id.ll5);
        LinearLayout ll6 = (LinearLayout) findViewById(R.id.ll6);
        LinearLayout ll7 = (LinearLayout) findViewById(R.id.ll7);
        LinearLayout ll8 = (LinearLayout) findViewById(R.id.ll8);
        LinearLayout ll9 = (LinearLayout) findViewById(R.id.ll9);

        setParamsLinearLayout(ll1,0,(deviceWidth/2));
        setParamsLinearLayout(ll2,0,(deviceWidth/2));
        setParamsLinearLayout(ll3,0,(deviceWidth/2));
        setParamsLinearLayout(ll4,0,(deviceWidth/2));
        setParamsLinearLayout(ll5,0,(deviceWidth/2));
        setParamsLinearLayout(ll6,0,(deviceWidth/2));
        setParamsLinearLayout(ll7,0,(deviceWidth/2));
        setParamsLinearLayout(ll8,0,(deviceWidth/2));
        setParamsLinearLayout(ll9,0,(deviceWidth/2));

    }

//    void setParamsLinearLayout(LinearLayout linearLayout,int mHeight, int mWidth){
//
//        LinearLayout.LayoutParams mParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
//        if(mHeight!=0)
//            mParams.height = (int) mHeight;
//        if(mWidth!=0)
//            mParams.width = (int) mWidth;
//
//        linearLayout.setLayoutParams(mParams);
//    }

    void setParamsLinearLayout(LinearLayout linearLayout,int mHeight, int mWidth){

        RelativeLayout.LayoutParams mParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();

        if(mHeight!=0)
            mParams.height = (int) mHeight;
        if(mWidth!=0)
            mParams.width = (int) mWidth;

        linearLayout.setLayoutParams(mParams);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onBackPressed();
        return true;
    }

    void introduceButtons()
    {

        Button button1 = (Button) findViewById(R.id.btn_current_pos);
        //button1.setLayoutParams(new RelativeLayout.LayoutParams(deviceWidth/2,ViewGroup.LayoutParams.WRAP_CONTENT));
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Maps.this,ShowMaps.class);
                intent.putExtra("extra",1);
                startActivity(intent);
            }
        });

        Button button2 = (Button) findViewById(R.id.btn_m_haram);
        //button2.setLayoutParams(new RelativeLayout.LayoutParams(deviceWidth/2,ViewGroup.LayoutParams.WRAP_CONTENT));
        //button2.setLayoutParams(new RelativeLayout.LayoutParams());
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Maps.this,ShowMaps.class);
                intent.putExtra("extra",2);
                startActivity(intent);
            }
        });
        Button button3 = (Button) findViewById(R.id.btn_kaaba);
        //button3.setLayoutParams(new RelativeLayout.LayoutParams(deviceWidth/2,ViewGroup.LayoutParams.WRAP_CONTENT));
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Maps.this,ShowMaps.class);
                intent.putExtra("extra",3);
                startActivity(intent);
            }
        });
        Button button4 = (Button) findViewById(R.id.btn_sayee);
        //button4.setLayoutParams(new RelativeLayout.LayoutParams(deviceWidth/2,ViewGroup.LayoutParams.WRAP_CONTENT));
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Maps.this,ShowMaps.class);
                intent.putExtra("extra",4);
                startActivity(intent);
            }
        });
        Button button5 = (Button) findViewById(R.id.btn_mina);
        //button5.setLayoutParams(new RelativeLayout.LayoutParams(deviceWidth/2,ViewGroup.LayoutParams.WRAP_CONTENT));
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Maps.this,ShowMaps.class);
                intent.putExtra("extra",5);
                startActivity(intent);
            }
        });
        Button button6 = (Button) findViewById(R.id.btn_arafat);
        //button6.setLayoutParams(new RelativeLayout.LayoutParams(deviceWidth/2,ViewGroup.LayoutParams.WRAP_CONTENT));
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Maps.this,ShowMaps.class);
                intent.putExtra("extra",6);
                startActivity(intent);
            }
        });
        Button button7 = (Button) findViewById(R.id.btn_muzdalifa);
        //button7.setLayoutParams(new RelativeLayout.LayoutParams(deviceWidth/2,ViewGroup.LayoutParams.WRAP_CONTENT));
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Maps.this,ShowMaps.class);
                intent.putExtra("extra",7);
                startActivity(intent);
            }
        });
        Button button8 = (Button) findViewById(R.id.btn_jaamarat);
        //button8.setLayoutParams(new RelativeLayout.LayoutParams(deviceWidth/2,ViewGroup.LayoutParams.WRAP_CONTENT));
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Maps.this,ShowMaps.class);
                intent.putExtra("extra",8);
                startActivity(intent);
            }
        });
        Button button9 = (Button) findViewById(R.id.btn_m_nababi);
        //button9.setLayoutParams(new RelativeLayout.LayoutParams(deviceWidth/2,ViewGroup.LayoutParams.WRAP_CONTENT));
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Maps.this,ShowMaps.class);
                intent.putExtra("extra",9);
                startActivity(intent);
            }
        });

    }

}
