package com.ehsanrc.labbaik;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private SliderLayout mDemoSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.getBackground().setAlpha(0);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("লাব্বাইক");
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        setParams();

        introduceButtons();

        mDemoSlider = (SliderLayout)findViewById(R.id.slider);

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("1",R.drawable.madina);
        file_maps.put("2",R.drawable.kaba2);
        file_maps.put("3",R.drawable.cover);

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
//                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            //.setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        //mDemoSlider.addOnPageChangeListener(this);


    }

    void introduceButtons(){

        Button button_hajj = (Button) findViewById(R.id.btn_hajj);
        button_hajj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Maps.class);
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

//        Button button_duas = (Button) findViewById(R.id.btn_duas);
//        button_duas.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,Duas.class);
//                startActivity(intent);
//            }
//        });

//        ImageButton button_importance = (ImageButton) findViewById(R.id.btn_importance);
//        button_importance.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, ScrollingActivity.class);
//                intent.putExtra("button","importance");
//                startActivity(intent);
//            }
//        });

        Button button_ihram = (Button) findViewById(R.id.btn_ihram);
        button_ihram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScrollingActivity.class);
                intent.putExtra("button","ihram");
                startActivity(intent);
            }
        });

        Button button_prayer_times = (Button) findViewById(R.id.btn_prayer_times);
        button_prayer_times.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PrayerTime.class);
                startActivity(intent);
            }
        });

//        ImageButton button_farj = (ImageButton) findViewById(R.id.btn_farj);
//        button_farj.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, ScrollingActivity.class);
//                intent.putExtra("button","farj");
//                startActivity(intent);
//            }
//        });

//        ImageButton button_wajib = (ImageButton) findViewById(R.id.btn_wajib);
//        button_wajib.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, ScrollingActivity.class);
//                intent.putExtra("button","wajib");
//                startActivity(intent);
//            }
//        });

//        Button button_map = (Button) findViewById(R.id.btn_map);
//        button_map.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, Maps.class);
//                intent.putExtra("button","wajib");
//                startActivity(intent);
//            }
//        });

//        ImageButton button_events = (ImageButton) findViewById(R.id.btn_events);
//        button_events.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, Events.class);
//                startActivity(intent);
//            }
//        });

        Button button_about = (Button) findViewById(R.id.btn_about);
        button_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        MultiDex.install(this);
    }

    void introduceTextviews(){



    }

    void introduceImageviews(){



    }

    void setParams(){

        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        int deviceWidth = displayMetrics.widthPixels;
        int deviceHeight = displayMetrics.heightPixels;

        LinearLayout linearLayout_up = (LinearLayout) findViewById(R.id.ll_up);
        RelativeLayout linearLayout_down = (RelativeLayout) findViewById(R.id.ll_down);


        if(deviceHeight<=480)
        {
            setParamsLinearLayout(linearLayout_up,((deviceHeight*20)/100),(deviceWidth/3));
            setParamsFrameLayout(linearLayout_down,((deviceHeight*70)/100),0);
            Log.i("height", "Got it "+deviceHeight);
        }

        else if(deviceHeight<deviceWidth)
        {
            setParamsLinearLayout(linearLayout_up,((deviceHeight*40)/100),(deviceWidth/2));
            setParamsFrameLayout(linearLayout_down,((deviceHeight*45)/100),0);
            Log.i("height", ""+deviceHeight);
        }

        else
        {
            setParamsLinearLayout(linearLayout_up,((deviceHeight*40)/100),0);
            setParamsFrameLayout(linearLayout_down,((deviceHeight*50)/100),0);
        }

        LinearLayout linearLayout_hajj = (LinearLayout) findViewById(R.id.hajj);
        LinearLayout linearLayout_umra = (LinearLayout) findViewById(R.id.umra);
//        LinearLayout linearLayout_duas = (LinearLayout) findViewById(R.id.duas);
//        LinearLayout linearLayout_importance = (LinearLayout) findViewById(R.id.importance);
        LinearLayout linearLayout_ihram = (LinearLayout) findViewById(R.id.ihram);
//        LinearLayout linearLayout_farj = (LinearLayout) findViewById(R.id.farj);
//        LinearLayout linearLayout_wajib = (LinearLayout) findViewById(R.id.wajib);
//        LinearLayout linearLayout_settings = (LinearLayout) findViewById(R.id.settings);
        LinearLayout linearLayout_events = (LinearLayout) findViewById(R.id.events);
        LinearLayout linearLayout_about = (LinearLayout) findViewById(R.id.about);

//        setParamsRelativeLayout(linearLayout_duas,0,(deviceWidth/2));
//        setParamsRelativeLayout(linearLayout_importance,0,(deviceWidth/3));

//        setParamsRelativeLayout(linearLayout_farj,0,(deviceWidth/3));
//        setParamsRelativeLayout(linearLayout_wajib,0,(deviceWidth/3));
//        setParamsRelativeLayout(linearLayout_settings,0,(deviceWidth/3));

        setParamsRelativeLayout(linearLayout_ihram,0,(deviceWidth/2));
        setParamsRelativeLayout(linearLayout_hajj,0,(deviceWidth/2));
        setParamsRelativeLayout(linearLayout_umra,0,(deviceWidth/2));
        setParamsRelativeLayout(linearLayout_events,0,(deviceWidth/2));
        setParamsRelativeLayout(linearLayout_about,0,(deviceWidth/2));

    }

    void setParamsLinearLayout(LinearLayout linearLayout,int mHeight, int mWidth){

        LinearLayout.LayoutParams mParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        if(mHeight!=0)
            mParams.height = (int) mHeight;
        if(mWidth!=0)
            mParams.width = (int) mWidth;

        linearLayout.setLayoutParams(mParams);
    }

    void setParamsFrameLayout(RelativeLayout linearLayout,int mHeight, int mWidth){

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
